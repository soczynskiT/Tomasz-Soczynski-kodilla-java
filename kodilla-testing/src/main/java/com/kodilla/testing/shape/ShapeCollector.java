package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShapeCollector {
    final List<Object> figuresArray = new ArrayList();

    public List<Object> getFiguresArray() {
        return figuresArray;
    }

    public void addFigure(Shape shape) {
    }

    public boolean removeFigure(Shape shape) {
        return true;
    }

    public Shape getFigure(int n) {
        return null;
    }

    public String showFigures() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShapeCollector)) return false;
        ShapeCollector that = (ShapeCollector) o;
        return Objects.equals(getFiguresArray(), that.getFiguresArray());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getFiguresArray());
    }

    @Override
    public String toString() {
        return String.valueOf(this.figuresArray);
    }
}
