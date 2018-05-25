package com.kodilla.patterns.builder.bigmac.components;

public final class Roll {
    private final boolean withSesame;

    public Roll(final boolean withSesame) {
        this.withSesame = withSesame;
    }

    private String getRollType() {
        if (withSesame) {
            return "roll with sesame";
        } else {
            return "roll without sesame";
        }
    }

    public boolean isWithSesame() {
        return withSesame;
    }

    @Override
    public String toString() {
        return getRollType();
    }
}
