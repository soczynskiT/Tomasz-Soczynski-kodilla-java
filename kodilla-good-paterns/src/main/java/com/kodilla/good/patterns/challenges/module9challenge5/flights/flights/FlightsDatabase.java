package com.kodilla.good.patterns.challenges.module9challenge5.flights.flights;

import com.kodilla.good.patterns.challenges.module9challenge5.flights.airports.Airport;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FlightsDatabase {
    final private Map<Airport, HashSet<Airport>> flightsDatabase = new HashMap<>();

    public void addNewFlightFromTo(Airport airport, Airport airport2) {
        airport.getConnectionsSet().add(airport2);
        flightsDatabase.put(airport, airport.getConnectionsSet());
    }

    public Map<Airport, HashSet<Airport>> getFlightsDatabase() {
        return flightsDatabase;
    }
}
