/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se1611.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import javax.activation.DataSource;
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;

/**
 *
 * @author Admin
 */
public class DBHelper implements Serializable {
    public static Connection getConnection() 
            throws ClassNotFoundException, SQLException {
        Connection con = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=UserManagement";
        con = DriverManager.getConnection(url, "sa", "12345");
        return con;
    }
}
