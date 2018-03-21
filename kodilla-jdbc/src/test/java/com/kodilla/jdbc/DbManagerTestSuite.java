package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManagerTestSuite {
    @Test
    public void testConnect() throws SQLException {
        //Given
        //When
        final DbManager dbManager = DbManager.getInstance();
        //Then
        Assert.assertNotNull(dbManager.getConnection());
    }

    @Test
    public void testSelectUsers() throws SQLException {
        //Given
        final DbManager dbManager = DbManager.getInstance();

        //When
        final String sqlQuery = "SELECT * FROM USERS";
        final Statement statement = dbManager.getConnection().createStatement();
        final ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(5, counter);
    }

    @Test
    public void testSelectUsersAndPosts() throws SQLException {
        //Given
        final DbManager dbManager = DbManager.getInstance();

        //When
        final String sqlQuery = "SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS TOTAL_POSTS FROM POSTS P, USERS U " +
                "WHERE P.USER_ID = U.ID GROUP BY P.USER_ID HAVING COUNT(*) >= 2 ORDER BY U.FIRSTNAME, U.LASTNAME";
        final Statement statement = dbManager.getConnection().createStatement();
        final ResultSet resultSet = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (resultSet.next()) {
            System.out.println(resultSet.getString("FIRSTNAME") + " | " +
                    resultSet.getString("LASTNAME") + " | " +
                    resultSet.getInt("TOTAL_POSTS"));
            counter++;
        }
        resultSet.close();
        statement.close();
        Assert.assertEquals(1, counter);
    }
}