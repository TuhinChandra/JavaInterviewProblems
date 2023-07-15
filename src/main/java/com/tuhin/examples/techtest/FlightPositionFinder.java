package com.tuhin.examples.techtest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlightPositionFinder {

    private static boolean checkIfFlighWithinAirspace(Flight flight, Airspace airspace) {
        boolean isFlightWithinXAxis = flight.getCurrentCoordinate().getX() >= airspace.getBottomLeft().getX() &&
                flight.getCurrentCoordinate().getX() <= airspace.getTopRight().getX();
        boolean isFlightWithinYAxis = flight.getCurrentCoordinate().getY() >= airspace.getBottomLeft().getY() &&
                flight.getCurrentCoordinate().getY() <= airspace.getTopRight().getY();
        return isFlightWithinXAxis && isFlightWithinYAxis;
    }

    public static Optional<Airspace> determineFlightInWhichAirspace(Flight flight, List<Airspace> listOfAirspaces) {
        final Optional<Airspace> currentAirspace = listOfAirspaces.stream().filter(airspace -> checkIfFlighWithinAirspace(flight, airspace)).collect(Collectors.toList()).stream().findFirst();
        if (currentAirspace.isPresent()) {
            System.out.println(flight + ", is located on " + currentAirspace.get() + " airspace");
        } else {
            System.out.println(flight + ", is currently on unknown airspace");
        }
        return currentAirspace;
    }
}
