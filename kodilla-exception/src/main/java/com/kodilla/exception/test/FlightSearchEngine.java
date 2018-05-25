package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearchEngine {
    final private Map<String, Boolean> airportsMap = new HashMap<>();

    public void addAirportToDataBase(String airport, Boolean isAvailable) {
        airportsMap.put(airport, isAvailable);
    }

    public void findFlight(Flight flight) throws RouteNotFoundException {
        final String airportArr = flight.getArrivalAirport();
        final String airportDep = flight.getDepartureAirport();

        if (airportsMap.containsKey(airportArr) && airportsMap.containsKey(airportDep)) {
            if (airportsMap.get(airportArr) && airportsMap.get(airportDep)) {
                System.out.println("Route founded !!!");
            } else {
                System.out.println("Route founded but one or both airports are temporary not available.");
            }
        } else
            throw new RouteNotFoundException("One or both airports do not exist in database. Route not possible to find");
    }
}
