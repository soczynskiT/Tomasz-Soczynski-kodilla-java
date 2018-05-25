package com.kodilla.exception.test;

public class FlightFinderApp {
    public static void main(String args[]) {
        final FlightSearchEngine searchEngine = new FlightSearchEngine();

        searchEngine.addAirportToDataBase("Berlin", true);
        searchEngine.addAirportToDataBase("Cracow", true);
        searchEngine.addAirportToDataBase("London", false);
        searchEngine.addAirportToDataBase("Warsaw", false);

        final Flight flight = new Flight("London", "Warsaw");
        final Flight flight1 = new Flight("Warsaw", "Berlin");
        final Flight flight2 = new Flight("Berlin", "Cracow");
        final Flight flight3 = new Flight("Szczecin", "Berlin");

        try {
            System.out.println("Route London - Warsaw");
            searchEngine.findFlight(flight);
            System.out.println("\nRoute Warsaw - Berlin");
            searchEngine.findFlight(flight1);
            System.out.println("\nRoute Berlin - Cracow");
            searchEngine.findFlight(flight2);
            System.out.println("\nRoute Szczecin - Berlin");
            searchEngine.findFlight(flight3);
        } catch (RouteNotFoundException rex) {
            System.out.println("Error: " + rex.getMessage());
        }


    }

}
