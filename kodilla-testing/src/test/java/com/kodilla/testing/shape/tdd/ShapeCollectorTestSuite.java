package com.kodilla.testing.shape.tdd;

import com.kodilla.testing.shape.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("Start of all test for ShapeCollector");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("End of all tests for ShapeCollector");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Start of test no " + testCounter);
    }

    @After
    public void afterEveryTest() {
        System.out.println("End of test no " + testCounter);
    }

    /*Test for adding a new figure to array */
    @Test
    public void testAddFigure() {
        //Given
        final ShapeCollector shapeCollector = new ShapeCollector();
        final Shape circle = new Circle(25);
        //When
        shapeCollector.addFigure(circle);
        //Then
        Assert.assertEquals(1, shapeCollector.getFiguresArray().size());
    }

    /*Test if trying to remove not existing shape return false */
    @Test
    public void testRemoveNotExistingFigure() {
        //Given
        final ShapeCollector shapeCollector = new ShapeCollector();
        final Shape triangle = new Triangle(15, 10);
        //When
        final boolean result = shapeCollector.removeFigure(triangle);
        //Then
        Assert.assertFalse(result);
    }

    /*Test for working: figure removing method */
    @Test
    public void testRemoveFigure() {
        //Given
        final ShapeCollector shapeCollector = new ShapeCollector();
        final Shape square = new Square(45);
        shapeCollector.addFigure(square);
        //When
        final boolean result = shapeCollector.removeFigure(square);
        //Then
        Assert.assertTrue(result);
        Assert.assertFalse(shapeCollector.getFiguresArray().contains(square));
    }

    /*Test if shape added to "n" list position equals to shape get from "n" list position */
    @Test
    public void testGetFigure() {
        //Given
        final ShapeCollector shapeCollector = new ShapeCollector();
        final Shape triangle = new Triangle(15, 6);
        shapeCollector.addFigure(triangle);
        //When
        final Shape retrievedShape = shapeCollector.getFigure(0);
        //Then
        Assert.assertEquals(triangle, retrievedShape);
    }

    /*Test if method showFiguresArray returns array with all added shapes */
    @Test
    public void testShowFigures() {
        //Given
        final ShapeCollector shapeCollector = new ShapeCollector();
        final Shape triangle = new Triangle(15, 11);
        final Shape circle = new Circle(20);
        final List<Shape> anArray = new ArrayList<>();

        shapeCollector.addFigure(triangle);
        shapeCollector.addFigure(circle);

        anArray.add(triangle);
        anArray.add(circle);
        //When
        final String anArrayToString = String.valueOf(anArray);
        final String retrievedArrayToString = shapeCollector.showFigures();
        //Then
        Assert.assertEquals(anArrayToString, retrievedArrayToString);
    }
}