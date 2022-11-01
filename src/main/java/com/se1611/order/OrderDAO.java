/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se1611.order;

import com.se1611.utils.DBHelper;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author chilamha
 */
public class OrderDAO {
    private List<OrderDTO> orderList;

    public List<OrderDTO> getOrderList() {
        return orderList;
    }
    
    public ArrayList<OrderDTO> SearchOrderList(String empname) throws SQLException, ClassNotFoundException, NamingException {
        Connection connection = null;
        PreparedStatement prestm = null;
        ResultSet rs = null;
        try {
            connection = DBHelper.getConnection();
            if (connection != null) {
                String orderSQLString = "SELECT o.order_Id, o.employee_Id, o.date_To_Oder, o.quantity_Order, o.total_Order, e.fullName "
                        + "from [Order] o inner join Employee e on o.employee_Id = e.employee_Id "
                        + "WHERE e.fullName LIKE '%?%'";

                prestm = connection.prepareStatement(orderSQLString);
                prestm.setString(1, empname);
                rs = prestm.executeQuery();
                ArrayList<OrderDTO> result = new ArrayList<>();
                while (rs.next()) {

                    int OrderID = rs.getInt("order_Id");
                    int EmployeeId = rs.getInt("employee_Id");
                    Date OrderedDate = rs.getDate("date_To_Oder");
                    int quantity = rs.getInt("quantity_Order");
                    float total = rs.getFloat("total_Order");

                    OrderDTO oDTO = new OrderDTO(OrderID, EmployeeId, OrderedDate, quantity, total);
                    result.add(oDTO);
                }
                return result;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (prestm != null) {
                prestm.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return null;
    }

    public int CreateOrder(int empId, int quantity, float total) throws SQLException, ClassNotFoundException, NamingException {
        Connection con = DBHelper.getConnection();

        String sql = "INSERT INTO [Order] (employee_Id, date_To_Oder, quantity_Order, total_Order)"
                + " VALUES (?, GETDATE(), ?, ?)";
        PreparedStatement stm = null;
        ResultSet rs = null;
        Integer newlyAddedOrderID = 0;
        try {
            stm = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stm.setInt(1, empId);
            stm.setInt(2, quantity);
            stm.setFloat(3, total);

            stm.executeUpdate();
            rs = stm.getGeneratedKeys();

            if (rs.next()) {
                newlyAddedOrderID = rs.getInt(1);
                //System.out.println("We have just added " + newlyAddedOrderID + " to database");
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
        return newlyAddedOrderID;
    }

    public ArrayList<OrderDTO> GetAllOrder() throws SQLException, ClassNotFoundException, NamingException {
        Connection connection = null;
        PreparedStatement prestm = null;
        ResultSet rs = null;
        try {
            connection = DBHelper.getConnection();
            if (connection != null) {
                String orderSQLString = "SELECT order_Id, employee_Id, date_To_Oder, quantity_Order, total_Order "
                        + "FROM [Order] "
                        + "ORDER by date_To_Oder desc";

                prestm = connection.prepareStatement(orderSQLString);

                rs = prestm.executeQuery();
                ArrayList<OrderDTO> result = new ArrayList<>();
                while (rs.next()) {

                    int OrderID = rs.getInt("order_Id");
                    int EmployeeId = rs.getInt("employee_Id");
                    Date OrderedDate = rs.getDate("date_To_Oder");
                    int quantity = rs.getInt("quantity_Order");
                    float total = rs.getFloat("total_Order");

                    OrderDTO oDTO = new OrderDTO(OrderID, EmployeeId, OrderedDate, quantity, total);
                    result.add(oDTO);
                }
                return result;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (prestm != null) {
                prestm.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return null;
    }

    public ArrayList<OrderDTO> GetOrderListBySaleID(int empId) throws SQLException, ClassNotFoundException, NamingException {
        Connection connection = null;
        PreparedStatement prestm = null;
        ResultSet rs = null;
        try {
            connection = DBHelper.getConnection();
            if (connection != null) {
                String orderSQLString = "SELECT order_Id, employee_Id, date_To_Oder, quantity_Order, total_Order "
                        + "FROM [Order] "
                        + "WHERE employee_Id = ?";

                prestm = connection.prepareStatement(orderSQLString);
                prestm.setInt(1, empId);
                rs = prestm.executeQuery();
                ArrayList<OrderDTO> result = new ArrayList<>();
                while (rs.next()) {

                    int OrderID = rs.getInt("order_Id");
                    int EmployeeId = rs.getInt("employee_Id");
                    Date OrderedDate = rs.getDate("date_To_Oder");
                    int quantity = rs.getInt("quantity_Order");
                    float total = rs.getFloat("total_Order");

                    OrderDTO oDTO = new OrderDTO(OrderID, EmployeeId, OrderedDate, quantity, total);
                    result.add(oDTO);
                }
                return result;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (prestm != null) {
                prestm.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return null;
    }
}
