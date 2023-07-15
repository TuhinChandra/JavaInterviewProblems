package com.tuhin.examples.directorywatch;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuhin.examples.FileUtils;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DirectoryWatcherExample {
    public static final String CONFIG_FILE_JSON = "com/tuhin/examples/directorywatch/config.json";

    public static void main(String[] args) throws IOException {
        final DirectoryConfiguration config = new ObjectMapper().readValue(FileUtils.getFileContent(new DirectoryWatcherExample().getClass().getClassLoader(), CONFIG_FILE_JSON), DirectoryConfiguration.class);
        final Pattern TIMESTAMP_REGEX = Pattern.compile(config.getRegexForDateTimeParsing());
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(config.getDateTimeFormat());
        final Path sourcePath = Paths.get(config.getSourceLocation());

        final WatchService watchService = FileSystems.getDefault().newWatchService();
        sourcePath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

        try {
            final WatchKey key = watchService.take();
            while (null != key) {
                for (final WatchEvent<?> event : key.pollEvents()) {
                    final String fileName = event.context().toString();
                    try {
                        getTargetDirectory(config, TIMESTAMP_REGEX, dateTimeFormatter, fileName).ifPresent(targetDirectory -> {
                            moveToTargetDirectory(sourcePath, fileName, targetDirectory);
                        });
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                        moveToTargetDirectory(sourcePath, fileName, config.getFailedLocation());
                    }
                }
                key.reset();
            }
        } catch (InterruptedException e) {
            System.err.println("InterruptedException --> " + e.getMessage());
        }
    }

    private static void moveToTargetDirectory(final Path sourcePath, final String fileName, final String targetDirectory) {
        try {
            Files.createDirectories(Paths.get(targetDirectory));
            Files.move(Paths.get(sourcePath + "\\" + fileName), Paths.get(targetDirectory + "\\" + fileName), StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            System.err.println("Failed to create directory!" + e.getMessage());
        }
    }

    private static Optional<String> getTargetDirectory(final DirectoryConfiguration config,
                                                       final Pattern TIMESTAMP_REGEX,
                                                       final DateTimeFormatter dateTimeFormatter,
                                                       final String fileName) throws Exception {
        final Matcher matcher = TIMESTAMP_REGEX.matcher(fileName);
        String targetDirectory = null;
        if (matcher.matches()) {
            LocalDateTime localDateTime = LocalDateTime.parse(matcher.group(1), dateTimeFormatter);
            targetDirectory = buildTargetDirectoryName(config, localDateTime);
        } else {
            throw new Exception("Could not extract timestamp for file ::" + fileName + ". This will will be moved to Failed folder");
        }
        return Optional.ofNullable(targetDirectory);
    }

    private static String buildTargetDirectoryName(final DirectoryConfiguration config, final LocalDateTime localDateTime) {
        return config.getTargetLocation() + localDateTime.getYear() + "\\" + localDateTime.getMonthValue() + "\\" + localDateTime.getDayOfMonth() + "\\";
    }
}