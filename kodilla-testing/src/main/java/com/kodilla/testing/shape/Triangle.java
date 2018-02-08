package com.kodilla.testing.shape;

import java.util.Objects;

public class Triangle implements Shape {
    final private String name = "Triangle";
    private int field;

    public Triangle(int field) {
        this.field = field;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public int getField() {
        return this.field;
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