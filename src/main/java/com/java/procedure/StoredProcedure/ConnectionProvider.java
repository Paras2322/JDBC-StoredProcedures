package com.java.procedure.StoredProcedure;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider 
{
    private static Connection connection;

    //connection method

    public static Connection getConnection()
    {
        try {
            if(connection == null) {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stored_procedures", "root", "SecureParas@123");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}

































