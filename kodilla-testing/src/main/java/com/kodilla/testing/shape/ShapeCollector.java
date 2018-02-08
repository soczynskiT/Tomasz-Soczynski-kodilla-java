package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShapeCollector {
    final private List<Shape> figuresArray = new ArrayList<>();

    public List<Shape> getFiguresArray() {
        return figuresArray;
    }

    public void addFigure(Shape shape) {
        if (shape.getField() > 0) {
            figuresArray.add(shape);
        }
    }

    public boolean removeFigure(Shape shape) {
        boolean result = false;
        if (figuresArray.contains(shape)) {
            figuresArray.remove(shape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int n) {
        Shape shape = null;
        if (n >= 0 && n < figuresArray.size()) {
            shape = figuresArray.get(n);
        }
        return shape;
    }

    public String showFigures() {
        return this.toString();
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
