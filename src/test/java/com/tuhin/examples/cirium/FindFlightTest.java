package com.tuhin.examples.cirium;


import com.fasterxml.jackson.core.type.TypeReference;
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

import static com.tuhin.examples.cirium.FlightPositionFinder.determineFlightInWhichAirspace;

public class FindFlightTest {

    public static final String CONFIG_FILE_JSON = "techtest/airspace.json";
    public static final String AERODROME_KOLKATA = "CCU";
    public static final String AERODROME_LONDON = "LHR";

    @Test
    @DisplayName("Problem #1 - Enhance the Flight class to allow its user to determine where it is located.")
    void test_determine_current_location_of_flight() {
        final Flight flight = createAFlightInstance(AERODROME_KOLKATA, AERODROME_LONDON);
        final Coordinate currentCoordinate = generateCurrentCoordinate();
        setCurrentCoordinateOfFlight(flight, currentCoordinate);
        Assertions.assertEquals(currentCoordinate, flight.getCurrentCoordinate(),
                "Flight's current location is (49.0, 30.0)");
    }

    @Test
    @DisplayName("Problem #2 - Given an instance of a Flight, and an instance of an Airspace, enhance the code to allow\n" +
            "users to determine if the flight is within the airspace. Test result must return a known airspace")
    void given_flight_and_airspace_test_flight_in_which_airspace() throws IOException {
        final List<Airspace> listOfAirspaces = generateListOfAirspaces();
        final Flight flight = createAFlightInstance(AERODROME_KOLKATA, AERODROME_LONDON);
        final Coordinate currentCoordinate = generateCurrentCoordinate();
        setCurrentCoordinateOfFlight(flight, currentCoordinate);
        final Optional<Airspace> currentAirspace = determineFlightInWhichAirspace(flight, listOfAirspaces);
        Assertions.assertEquals("Dubai", currentAirspace.get().getName(),
                "Flight is currently at Dubai Airspace");
    }

    @Test
    @DisplayName("Problem #3 - Given an instance of a Flight, and an instance of an Airspace, enhance the code to allow\n" +
            "users to determine if the flight is within the airspace. Test must return an unknown airspace")
    void given_flight_and_airspace_test_flight_in_unknown_airspace() throws IOException {
        final List<Airspace> listOfAirspaces = generateListOfAirspaces();
        final Flight flight = createAFlightInstance(AERODROME_KOLKATA, AERODROME_LONDON);
        setCurrentCoordinateOfFlight(flight, new Coordinate(5, 10));
        final Optional<Airspace> currentAirspace = determineFlightInWhichAirspace(flight, listOfAirspaces);
        Assertions.assertEquals(Optional.empty(), currentAirspace,
                "Flight is currently at unknown Airspace");
    }

    private static Coordinate generateCurrentCoordinate() {
        return new Coordinate(49.0, 30.0);
    }

    private static void setCurrentCoordinateOfFlight(final Flight flight, final Coordinate coordinate) {
        flight.setCurrentCoordinate(coordinate);
    }

    private static Flight createAFlightInstance(final String departureAerodrome, final String arrivalAerodrome) {
        return new Flight(arrivalAerodrome, LocalDateTime.of(2023, 7, 14, 12, 00).toInstant(ZoneOffset.UTC), departureAerodrome, LocalDateTime.of(2023, 7, 15, 03, 00).toInstant(ZoneOffset.UTC));
    }

    private static List<Airspace> generateListOfAirspaces() throws IOException {
        /*Airspace airspaceKolkata = createAirspaceInstance("Kolkata", new Coordinate(-80.0D, -42.0D), new Coordinate(-58.0, -23.0));
        Airspace airspaceDubai = createAirspaceInstance("Dubai", new Coordinate(35.0D, 25.0D), new Coordinate(66.0, 44.0));
        Airspace airspaceLondon = createAirspaceInstance("London", new Coordinate(124.0D, 36.0D), new Coordinate(145.0, 65.0));
        return List.of(airspaceLondon, airspaceKolkata, airspaceDubai);*/
        return new ObjectMapper().readValue(FileUtils.getFileContent(new FindFlightTest().getClass().getClassLoader(), CONFIG_FILE_JSON), new TypeReference<List<Airspace>>() {
        });
    }

    private static Airspace createAirspaceInstance(final String airspaceName, final Coordinate bottomLeft, final Coordinate topRight) {
        return new Airspace(bottomLeft, topRight, airspaceName);
    }
}
