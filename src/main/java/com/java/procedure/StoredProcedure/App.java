package com.java.procedure.StoredProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class App {

    public static void callProcedure1 () throws SQLException
    {
        Connection connection=ConnectionProvider.getConnection();
        
        CallableStatement callableStatement =connection.prepareCall("call CountByLast(?,?)");

        // Handling IN type parameters
        callableStatement.setString(1, "Bagga");

        // Handling OUT type parameters

        callableStatement.registerOutParameter(2, Types.INTEGER);

        //execute the callable

        callableStatement.execute();
        int countValue = callableStatement.getInt(2);
        System.out.println("Number of rows " + countValue);
    }

    public static void callProcedure() throws SQLException {
        Connection connection = ConnectionProvider.getConnection();

        // statement - static queries
        // PreparedStatement - dynamic queries
        // callableStatement - stored procedures and functions

        java.sql.CallableStatement callableStatement = connection.prepareCall("call SelectByLast(?)");

        /*
         * ?--> Parameters , IN, OUT,INOUT
         */

        callableStatement.setString(1, "Bagga"); // IN Parameter

        ResultSet resultSet = callableStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("first_name") + " " + resultSet.getString("last_name") + " - "
                    + resultSet.getString("city"));
        }

    }

    public static void main(String[] args) throws SQLException {

        // callProcedure();
         callProcedure1();

    }
}
