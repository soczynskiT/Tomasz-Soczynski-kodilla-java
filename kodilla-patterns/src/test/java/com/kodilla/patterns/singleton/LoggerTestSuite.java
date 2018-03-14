package com.kodilla.patterns.singleton;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Start of testSuite");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("End of testSuite");
    }

    @Test
    public void testGetLastLog() {
        //Given
        Logger.getInstance().log("new log");
        Logger.getInstance().log("last log");

        //When
        final String result = Logger.getInstance().getLastLog();

        //Then
        Assert.assertEquals("last log", result);
    }
}
