package com.tuhin.examples.directorywatch;

public class DirectoryConfiguration {
    private String sourceLocation;
    private String targetLocation;
    private String failedLocation;
    private String dateTimeFormat;
    private String regexForDateTimeParsing;

    public DirectoryConfiguration(){

    }

    public DirectoryConfiguration(final String sourceLocation,
                                  final String targetLocation,
                                  final String failedLocation,
                                  final String dateTimeFormat,
                                  final String regexForDateTimeParsing) {
        this.sourceLocation = sourceLocation;
        this.targetLocation = targetLocation;
        this.failedLocation = failedLocation;
        this.dateTimeFormat = dateTimeFormat;
        this.regexForDateTimeParsing = regexForDateTimeParsing;
    }

    public String getSourceLocation() {
        return sourceLocation;
    }

    public void setSourceLocation(final String sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    public String getTargetLocation() {
        return targetLocation;
    }

    public void setTargetLocation(final String targetLocation) {
        this.targetLocation = targetLocation;
    }

    public String getFailedLocation() {
        return failedLocation;
    }

    public void setFailedLocation(final String failedLocation) {
        this.failedLocation = failedLocation;
    }

    public String getDateTimeFormat() {
        return dateTimeFormat;
    }

    public void setDateTimeFormat(final String dateTimeFormat) {
        this.dateTimeFormat = dateTimeFormat;
    }

    public String getRegexForDateTimeParsing() {
        return regexForDateTimeParsing;
    }

    public void setRegexForDateTimeParsing(final String regexForDateTimeParsing) {
        this.regexForDateTimeParsing = regexForDateTimeParsing;
    }
}
