package com.kodilla.stream.world;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public final class World {
    private final Set<Continent> continentSet = new HashSet<>();

    public void addContinent(Continent continent) {
        continentSet.add(continent);
    }

    public BigInteger getPeopleQuantity() {
        return continentSet.stream()
                .flatMap(continent -> continent.getCountryList().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigInteger.ZERO, (sum, current) -> sum = sum.add(current));
    }
}
