package com.kodilla.testing.shape;

import java.util.Objects;

public class Circle implements Shape {
    final private String name = "Circle";
    private int field;

    public Circle(int field) {
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
