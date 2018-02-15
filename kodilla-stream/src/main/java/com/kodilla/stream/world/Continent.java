package com.kodilla.stream.world;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Continent {
    private final String name;
    private final Set<Country> countryList = new HashSet<>();

    public Continent(final String name) {
        this.name = name;
    }

    public void addCountry(Country country) {
        countryList.add(country);
    }

    public Set<Country> getCountryList() {
        return new HashSet<>(countryList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Continent)) return false;
        Continent continent = (Continent) o;
        return Objects.equals(name, continent.name) &&
                Objects.equals(getCountryList(), continent.getCountryList());
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, getCountryList());
    }
}
