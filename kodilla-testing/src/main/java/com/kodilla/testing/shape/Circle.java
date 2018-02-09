package com.kodilla.testing.shape;

import java.util.Objects;

public class Circle implements Shape {
    final private String name = "Circle";
    private double radius;

    public Circle(int radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Illegal radius value: " + radius);
        }
        this.radius = radius;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return 3.14 * this.radius * this.radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        Circle circle = (Circle) o;
        return getField() == circle.getField() &&
                Objects.equals(name, circle.name);
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
