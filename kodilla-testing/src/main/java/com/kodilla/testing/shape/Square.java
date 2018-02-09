package com.kodilla.testing.shape;

import java.util.Objects;

public class Square implements Shape {
    final private String name = "Square";
    private double side;

    public Square(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Illegal side value: " + side);
        }
        this.side = side;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return this.side * this.side;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;
        Square square = (Square) o;
        return getField() == square.getField() &&
                Objects.equals(name, square.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, getField());
    }

    @Override
    public String toString() {
        return this.getShapeName() + " field= " + getField();
    }
}
