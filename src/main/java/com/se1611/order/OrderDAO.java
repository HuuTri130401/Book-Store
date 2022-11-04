/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se1611.order;

import com.se1611.employees.EmployeeDTO;
import com.se1611.utils.DBHelper;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author Admin
 */
public class OrderDAO {

    private Connection con = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;

    private void closeConnection() throws SQLException {
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

    public boolean createOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException, NamingException {
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String query = "INSERT INTO [Order] (employee_Id, date_To_Oder, quantity_Order, total_Order)"
                        + "VALUES (?,?,?,?)";
                stm = con.prepareStatement(query);
                stm.setInt(1, orderDTO.getEmployee_Id());
                stm.setDate(2, orderDTO.getDate_To_Order());
                stm.setInt(3, orderDTO.getQuantity_Order());
                stm.setFloat(4, orderDTO.getTotal_Order());
                stm.executeUpdate();
                return true;
            }
        } finally {
            closeConnection();
        }
        return false;
    }

    public OrderDTO getOrder(int employee_Id, Date date_To_Order, int quantity_Order, float total_Order) throws SQLException {
        OrderDTO orderDTO = new OrderDTO();
        try {
            String query = "SELECT * FROM [Order] "
                    + "WHERE employee_Id=? "
                    + "AND date_To_Oder=? "
                    + "AND quantity_Order=? "
                    + "AND total_Order=? ";

            con = DBHelper.getConnection();
            stm = con.prepareStatement(query);
            stm.setInt(1, employee_Id);
            stm.setDate(2, date_To_Order);
            stm.setInt(3, quantity_Order);
            stm.setFloat(4, total_Order);
            rs = stm.executeQuery();
            while (rs.next()) {
                int order_id = rs.getInt(1);
                employee_Id = rs.getInt(2);
                date_To_Order = rs.getDate(3);
                quantity_Order = rs.getInt(4);
                total_Order = rs.getFloat(5);
                orderDTO = new OrderDTO(order_id, employee_Id, date_To_Order, quantity_Order, total_Order);
            }
        } finally {
            closeConnection();
            return orderDTO;
        }
    }

}