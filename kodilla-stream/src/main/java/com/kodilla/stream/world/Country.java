package com.kodilla.stream.world;

import java.math.BigInteger;
import java.util.Objects;

public final class Country {
    private final String name;
    private final BigInteger peopleQuantity;

    public Country(final String name, final BigInteger peopleQuantity) {
        this.name = name;
        this.peopleQuantity = peopleQuantity;
    }

    public String getName() {
        return name;
    }

    public BigInteger getPeopleQuantity() {
        return peopleQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country = (Country) o;
        return Objects.equals(getName(), country.getName()) &&
                Objects.equals(getPeopleQuantity(), country.getPeopleQuantity());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getPeopleQuantity());
    }
}