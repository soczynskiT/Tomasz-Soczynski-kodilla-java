package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearchEngine {
    public void findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> flightsMap = new HashMap<>();
        flightsMap.put("Berlin", true);
        flightsMap.put("Cracow", true);
        flightsMap.put("London", false);
        flightsMap.put("Warsaw", false);
        final String airportArr = flight.getArrivalAirport();
        final String airportDep = flight.getDepartureAirport();

        if (flightsMap.containsKey(airportArr) && flightsMap.containsKey(airportDep)) {
            if (flightsMap.get(airportArr) && flightsMap.get(airportDep)) {
                System.out.println("Route founded !!!");
            } else {
                System.out.println("Route founded but one or both airports are temporary not available.");
            }
        }
        else throw new RouteNotFoundException("One or both airports do not exist in database. Route not possible to find");
    }
}
