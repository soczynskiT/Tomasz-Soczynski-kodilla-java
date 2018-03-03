package com.kodilla.good.patterns.challenges.module9challenge5.flights;

import com.kodilla.good.patterns.challenges.module9challenge5.flights.airports.Airport;
import com.kodilla.good.patterns.challenges.module9challenge5.flights.flights.FlightsDatabase;

public class FlightSearcherApp {
    public static void main(String args[]) {
        final FlightsDatabase allFlightsMap = new FlightsDatabase();
        final Airport warsaw = new Airport("WARSAW", "WAW");
        final Airport krakow = new Airport("KRAKOW", "KRK");
        final Airport berlin = new Airport("BERLIN", "BER");
        final Airport frankfurt = new Airport("FRANKFURT", "FRK");
        final Airport praha = new Airport("PRAHA", "PRG");
        final Airport vienna = new Airport("VIENNA", "VIE");
        final Airport gdansk = new Airport("GDANSK", "GDN");
        final Airport malta = new Airport("MALTA", "MLT");

        allFlightsMap.addNewFlightFromTo(warsaw, krakow);
        allFlightsMap.addNewFlightFromTo(warsaw, vienna);
        allFlightsMap.addNewFlightFromTo(warsaw, praha);
        allFlightsMap.addNewFlightFromTo(krakow, frankfurt);
        allFlightsMap.addNewFlightFromTo(krakow, gdansk);
        allFlightsMap.addNewFlightFromTo(frankfurt, berlin);
        allFlightsMap.addNewFlightFromTo(frankfurt, praha);
        allFlightsMap.addNewFlightFromTo(berlin, malta);
        allFlightsMap.addNewFlightFromTo(praha, malta);
        allFlightsMap.addNewFlightFromTo(gdansk, praha);

        final FlightSearcherLogic searcherLogic = new FlightSearcherLogic(allFlightsMap);

        System.out.println("All flights map:");
        allFlightsMap.getFlightsDatabase().entrySet().stream()
                .forEach(System.out::println);

        System.out.println("\nLooking for all flights from " + krakow);
        System.out.println(krakow + "=" + searcherLogic.showAllFlightsFrom(krakow).toString());

        System.out.println("\nLooking for all flights to " + praha);
        System.out.println(praha + "=" + searcherLogic.showAllFlightsTo(praha).toString());

        System.out.println("\nLooking for flights from " + frankfurt + " to " + malta + " with one changeover");
        for (Airport apt : searcherLogic.showAllFlightsFromToWithOneChangeover(frankfurt, malta)) {
            System.out.println(frankfurt + " = " + apt + " = " + malta);
        }

        System.out.println("\nLooking for flights from " + krakow + " through " + frankfurt);
        System.out.println(searcherLogic.showAllFlightsFromThrough(krakow, frankfurt));
    }
}
