package com.tuhin.examples;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatching {
    private static final Pattern TIMESTAMP_REGEX = Pattern.compile(".*_(\\d{14}).xml");

    public static void main(final String[] args) {
//        final String fileName = "inbound/pricepromotion/new/CF_InitialPricePromotion_CAFR_202208241247.xml";
        final String fileName = "inbound/pricepromotion/new/CF_DeltaPricePromotion_CAFR_20220922133547.xml";

//        final String dateTime = fileName.replaceAll(".xml", "").substring(fileName.lastIndexOf("_") + 1);
//        final OffsetDateTime odt = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyyMMddHHmm")).atZone(ZoneId.systemDefault()).toOffsetDateTime();
//        System.out.println(odt);
        System.out.println(extractTimestamp(fileName));
        final Matcher matcher = TIMESTAMP_REGEX.matcher(fileName);
        if (matcher.matches()) {
            final String dateTime = matcher.group(1);
            final ZonedDateTime zdt = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyyMMddHHmmss")).atZone(ZoneId.of("UTC"));
            System.out.println(zdt);
        }
    }

    private static String extractTimestamp(final String filePath) {
        final Matcher matcher = TIMESTAMP_REGEX.matcher(filePath);

        if (matcher.matches()) {
            return matcher.group(1);
        }

        return "";
    }
}
