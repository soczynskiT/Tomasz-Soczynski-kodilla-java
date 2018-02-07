package com.kodilla.testing.forum;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.*;


import java.util.ArrayList;
import java.util.Random;

public class CollectionTestSuite {
    @Before
    public void before() {
        System.out.println("Start o case checking.");
    }

    @After
    public void after() {
        System.out.println("End of case checking.");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Start of Collection test.");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("End of Collection test.");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        final ArrayList<Integer> anArray = new ArrayList<>();
        //When
        final ArrayList<Integer> evenNoArray = exterminator.exterminate(anArray);
        System.out.println("Checking method result for empty array.");
        //Then
        Assert.assertTrue(evenNoArray.isEmpty());
    }
    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        Random random = new Random();
        final ArrayList<Integer> numbersList = new ArrayList<>();
        for (int i=0; i<50; i++) {
            Integer number = random.nextInt()+1;
            numbersList.add(number);
        }
        //When
        final ArrayList<Integer> evenNoArray = exterminator.exterminate(numbersList);
        System.out.println("Checking method result for non empty array.");

    }

}
