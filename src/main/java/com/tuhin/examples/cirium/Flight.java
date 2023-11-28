// Copyright (C) 2017 Snowflake Software Ltd. All rights reserved.
package com.tuhin.examples.cirium;

import java.time.Instant;

/**
 * The class representing a Flight.
 */
public class Flight {

    /** The aerodrome the flight is arriving at. */
    private final String arrivalAerodrome;

    /** The date/time the flight is arriving. */
    private final Instant arrivalTime;

    /** The aerodrome the flight is departing from. */
    private final String departureAerodrome;

    /** The date/time the flight is departing. */
    private final Instant departureTime;

    /* The current co-ordinate of the flight */
    private Coordinate currentCoordinate;

    /**
     * Construct a flight.
     *
     * @param arrivalAerodrome   The aerodrome the flight is arriving at.
     * @param arrivalTime        The date/time the flight is arriving.
     * @param departureAerodrome The aerodrome the flight is departing from.
     * @param departureTime      The date/time the flight is departing.
     */
    public Flight(final String arrivalAerodrome, final Instant arrivalTime, final String departureAerodrome, final Instant departureTime) {
        this.arrivalAerodrome = arrivalAerodrome;
        this.arrivalTime = arrivalTime;
        this.departureAerodrome = departureAerodrome;
        this.departureTime = departureTime;
    }

    /**
     * Gets the aerodrome the flight is arriving at.
     *
     * @return the arrival aerodrome.
     */
    public String getArrivalAerodrome() {
        return arrivalAerodrome;
    }

    /**
     * Gets the date/time the flight is arriving.
     *
     * @return the arrival time.
     */
    public Instant getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Gets the aerodrome the flight is departing from.
     *
     * @return the departure aerodrome.
     */
    public String getDepartureAerodrome() {
        return departureAerodrome;
    }

    /**
     * Gets the date/time the flight is departing.
     *
     * @return the departure time.
     */
    public Instant getDepartureTime() {
        return departureTime;
    }

    /**
     * Gets the current co-ordinate of the flight
     * @return current co-ordinate of the flight
     */
    public Coordinate getCurrentCoordinate() {
        return currentCoordinate;
    }

    /**
     * Sets current co-ordinate of the flight
     * @param currentCoordinate
     */
    public void setCurrentCoordinate(final Coordinate currentCoordinate) {
        this.currentCoordinate = currentCoordinate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Flight ");
        sb.append(departureAerodrome).append(" to ").append(arrivalAerodrome);
        if (null != currentCoordinate) {
            sb.append(", which is currently at ").append(currentCoordinate);
        }
        return sb.toString();
    }
}
