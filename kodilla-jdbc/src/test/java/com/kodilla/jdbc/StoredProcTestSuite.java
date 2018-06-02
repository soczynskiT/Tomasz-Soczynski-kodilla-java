package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StoredProcTestSuite {
    @Test
    public void testUpdateVipLevels() throws SQLException {
        //Given
        final DbManager dbManager = DbManager.getInstance();
        final String sqlUpdate = "UPDATE READERS SET VIP_LEVEL=\"Not set\"";
        final Statement statement = dbManager.getConnection().createStatement();
        statement.execute(sqlUpdate);

        //When
        final String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement.execute(sqlProcedureCall);

        //Then
        final String sqlCheckTable = "SELECT COUNT(*) HOW_MANY FROM READERS WHERE VIP_LEVEL=\"Not set\"";
        final ResultSet rs = statement.executeQuery(sqlCheckTable);
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }
        Assert.assertEquals(0, howMany);
    }

    @Test
    public void testUpdateBestsellers() throws SQLException {
        //Given
        final DbManager dbManager = DbManager.getInstance();
        final Statement statement = dbManager.getConnection().createStatement();
        final String sqlUpdate = "UPDATE BOOKS SET BESTSELLER=NULL";
        statement.executeUpdate(sqlUpdate);

        //Then
        final String sqlProcedureCall = "CALL UpdateBestsellers()";
        statement.execute(sqlProcedureCall);

        //Then
        final String sqlCheckTable = "SELECT COUNT(*) HOW_MANY_NULLS FROM BOOKS WHERE BESTSELLER = NULL";
        final ResultSet rs = statement.executeQuery(sqlCheckTable);
        int howManyNulls = -1;
        if (rs.next()) {
            howManyNulls = rs.getInt("HOW_MANY_NULLS");
        }
        Assert.assertEquals(0, howManyNulls);
    }

}
