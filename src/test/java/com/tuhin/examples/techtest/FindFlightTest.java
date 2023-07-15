package com.tuhin.examples.techtest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuhin.examples.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

import static com.tuhin.examples.techtest.FlightPositionFinder.determineFlightInWhichAirspace;

public class FindFlightTest {

    public static final String CONFIG_FILE_JSON = "techtest/airspace.json";

    @Test
    @DisplayName("For a given flight instance and given list of airspaces," +
            "determine in which airspace the flight current is")
    void given_flight_and_airspace_determine_flight_in_which_airspace() throws IOException {
        final List<Airspace> listOfAirspaces = generateListOfAirspaces();
        final Flight flight = createAFlightInstance("CCU", "LHR");
        setCurrentCoordinateOfFlight(flight, new Coordinate(49.0, 30.0));
        final Optional<Airspace> currentAirspace = determineFlightInWhichAirspace(flight, listOfAirspaces);
        Assertions.assertEquals("Dubai", currentAirspace.get().getName(),
                "Flight is currently at Dubai Airspace");
    }

    private static void setCurrentCoordinateOfFlight(final Flight flight, final Coordinate coordinate) {
        flight.setCurrentCoordinate(coordinate);
    }

    private static Flight createAFlightInstance(final String departureAerodrome, final String arrivalAerodrome) {
        return new Flight(arrivalAerodrome, LocalDateTime.of(2023, 7, 14, 12, 00).toInstant(ZoneOffset.UTC),
                departureAerodrome, LocalDateTime.of(2023, 7, 15, 03, 00).toInstant(ZoneOffset.UTC));
    }

    private static List<Airspace> generateListOfAirspaces() throws IOException {
        final Airspace config = new ObjectMapper().readValue(FileUtils.getFileContent(new FindFlightTest().getClass().getClassLoader(), CONFIG_FILE_JSON), Airspace.class);
        Airspace airspaceKolkata = createAirspaceInstance("Kolkata", new Coordinate(-80.0D, -42.0D), new Coordinate(-58.0, -23.0));
        Airspace airspaceDubai = createAirspaceInstance("Dubai", new Coordinate(35.0D, 25.0D), new Coordinate(66.0, 44.0));
        Airspace airspaceLondon = createAirspaceInstance("London", new Coordinate(124.0D, 36.0D), new Coordinate(145.0, 65.0));
        return List.of(airspaceLondon, airspaceKolkata, airspaceDubai);
    }

    private static Airspace createAirspaceInstance(final String airspaceName, final Coordinate bottomLeft, final Coordinate topRight) {
        return new Airspace(bottomLeft, topRight, airspaceName);
    }
}
