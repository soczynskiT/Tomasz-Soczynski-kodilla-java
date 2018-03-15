package com.kodilla.patterns.builder.bigmac.components;

public final class Sauce {
    public static final String BARBECUE = "BARBECUE";
    public static final String STANDARD = "STANDARD";
    public static final String THOUSAND_ISLANDS = "1000 ISLANDS";

    private final String name;

    public Sauce(final String name) {
        if (name.equals(BARBECUE) || name.equals(STANDARD) || name.equals(THOUSAND_ISLANDS)) {
            this.name = name;
        }
        else {
            System.out.println("Sauce not available");
            this.name = "none";
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
