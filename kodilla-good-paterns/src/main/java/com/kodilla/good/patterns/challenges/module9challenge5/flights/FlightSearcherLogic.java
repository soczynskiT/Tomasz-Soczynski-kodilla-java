package com.kodilla.good.patterns.challenges.module9challenge5.flights;

import com.kodilla.good.patterns.challenges.module9challenge5.flights.airports.Airport;
import com.kodilla.good.patterns.challenges.module9challenge5.flights.flights.FlightsDatabase;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class FlightSearcherLogic {
    private final FlightsDatabase flightsDatabase;

    public FlightSearcherLogic(FlightsDatabase flightsDatabase) {
        this.flightsDatabase = flightsDatabase;
    }

    public Set<Airport> showAllFlightsFrom(Airport departureAirport) {
        final Set<Airport> connections = flightsDatabase.getFlightsDatabase().entrySet().stream()
                .filter(entry -> entry.getKey().equals(departureAirport))
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toSet());
        return connections;
    }

    public Set<Airport> showAllFlightsTo(Airport arrivalAirport) {
        final Set<Airport> connections = flightsDatabase.getFlightsDatabase().entrySet().stream()
                .filter(entry -> entry.getValue().contains(arrivalAirport))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        return connections;
    }

    public Set<Airport> showAllFlightsFromToWithOneChangeover(Airport departureAirport, Airport arrivalAirport) {

        final Set<Airport> changeoverAirports = new HashSet<>();

        for (Airport apt : showAllFlightsFrom(departureAirport)) {
            if (showAllFlightsTo(arrivalAirport).contains(apt)) {
                changeoverAirports.add(apt);
            }
        }
        return changeoverAirports;
    }

    public Set<Airport> showAllFlightsFromThrough(Airport departureAirport, Airport changeoverAirport) {
        final Set<Airport> possibleFlights = flightsDatabase.getFlightsDatabase().entrySet().stream()
                .filter(key -> key.getKey().equals(departureAirport))
                .map(Map.Entry::getValue)
                .filter(value -> value.contains(changeoverAirport))
                .flatMap(Collection::stream)
                .filter(airport -> airport.equals(changeoverAirport))
                .flatMap(airport -> airport.getConnectionsSet().stream())
                .collect(Collectors.toSet());

        return possibleFlights;
    }
}
