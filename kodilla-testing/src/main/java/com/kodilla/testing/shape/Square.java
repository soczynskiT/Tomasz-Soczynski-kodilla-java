package com.kodilla.testing.shape;

import java.util.Objects;

public class Square implements Shape {
    final private String name = "Square";
    private int field;

    public Square(int field) {
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
