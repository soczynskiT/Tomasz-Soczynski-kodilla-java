package com.kodilla.good.patterns.challenges.module9challenge5.flights.airports;

import java.util.HashSet;
import java.util.Objects;

public class Airport {
    final private String name;
    final private String airportUniqueCode;
    final private HashSet<Airport> connectionsSet = new HashSet<>();

    public Airport(String name, String airportUniqueCode) {
        this.name = name;
        this.airportUniqueCode = airportUniqueCode;
    }

    public String getName() {
        return name;
    }

    public HashSet<Airport> getConnectionsSet() {
        return connectionsSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airport)) return false;
        Airport airport = (Airport) o;
        return Objects.equals(getName(), airport.getName()) &&
                Objects.equals(airportUniqueCode, airport.airportUniqueCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), airportUniqueCode);
    }

    @Override
    public String toString() {
        return "Airport " + name;
    }
}
