/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se1611.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Admin
 */
public class DBHelper implements Serializable {
    public static Connection getConnection() 
            throws SQLException, NamingException {
        //1. get current context
        Context context = new InitialContext();
        //2. get server context
        Context tomcatContext = (Context) context.lookup("java:comp/env");
        //3. user datasource
        DataSource ds = (DataSource) tomcatContext.lookup("DBBOOKSTORE");
        //4. open connection 
        Connection con = ds.getConnection();
        return con;
    }
}
