package com.example.mercuriprototype;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB2Connector {


    private static Connection con = null;

    public static Connection getConnection() {
        if (con != null) return con;

        String url = "jdbc:mysql://localhost:3306/hilfling2";
        String user = "root";
        String password = "i9qAH7AZsUdJA2g0R4AS3";

        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("Vi fik ikke connection=" + ex.getMessage());
        }
        return con;
    }
}

