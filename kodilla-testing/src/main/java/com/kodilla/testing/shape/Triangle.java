package com.kodilla.testing.shape;

import java.util.Objects;

public class Triangle implements Shape {
    final private String name = "Triangle";
    private double side;
    private double height;

    public Triangle(double side, double height) {
        if (side <= 0 || height <= 0) {
            throw new IllegalArgumentException("Illegal height or side value.");
        }
        this.side = side;
        this.height = height;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return (this.side * this.height) / 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return getField() == triangle.getField() &&
                Objects.equals(name, triangle.name);
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