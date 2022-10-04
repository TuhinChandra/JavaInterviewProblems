package com.tuhin.examples;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeApiTest {
    public static void main(final String[] args) {
        final ZonedDateTime dateTime = ZonedDateTime.now(ZoneId.of("UTC"));
        System.out.println(dateTime);
        final String bstTime = "202212091614";
        final ZonedDateTime utc = LocalDateTime.parse(bstTime, DateTimeFormatter.ofPattern("yyyyMMddHHmm")).atZone(ZoneId.of("UTC"));
        System.out.println(utc);
    }
}
