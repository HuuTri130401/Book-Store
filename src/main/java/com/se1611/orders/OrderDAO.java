/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.se1611.orders;

import com.se1611.utils.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author Admin
 */
public class OrderDAO {

    public float getTotalOrderOfBook()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        float totalOrderOfBook = 0;

        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "Select SUM(total_Order) \n"
                        + "From [Order]\n"
                        + "Where YEAR(date_To_Oder) = YEAR(GETDATE())";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String sumValue = rs.getString(1);
                    totalOrderOfBook = Float.parseFloat(sumValue);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return totalOrderOfBook;
    }
}
