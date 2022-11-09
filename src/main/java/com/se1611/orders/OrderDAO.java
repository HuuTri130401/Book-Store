/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.se1611.orders;

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

    public List<OrderDTO> getOrderListByEmpID(int empID) throws SQLException, NamingException {
        List<OrderDTO> orders = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT order_Id, date_To_Oder, quantity_Order, total_Order "
                        + "FROM [Order] "
                        + "WHERE employee_Id = ? "
                        + "ORDER BY date_To_Oder DESC";

                stm = con.prepareStatement(sql);
                stm.setInt(1, empID);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int orderId = rs.getInt("order_Id");
                    Date orderedDate = rs.getDate("date_To_Oder");
                    int quantity = rs.getInt("quantity_Order");
                    float total = rs.getFloat("total_Order");

                    OrderDTO dto = new OrderDTO(orderId, empID, orderedDate, quantity, total);
                    if (orders == null) {
                        orders = new ArrayList<>();
                    }
                    orders.add(dto);
                }
            }
        } finally {
            closeConnection();
            return orders;
        }
        
    }
    
    public OrderDTO getOrderByOrderId(int id) throws SQLException, NamingException {
        OrderDTO order = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT employee_Id, date_To_Oder, quantity_Order, total_Order "
                        + "FROM [Order] "
                        + "WHERE order_Id = ? "
                        + "ORDER BY date_To_Oder DESC";

                stm = con.prepareStatement(sql);
                stm.setInt(1, id);
                rs = stm.executeQuery();

                if (rs.next()) {
                    int empID = rs.getInt("employee_Id");
                    Date orderedDate = rs.getDate("date_To_Oder");
                    int quantity = rs.getInt("quantity_Order");
                    float total = rs.getFloat("total_Order");

                    order = new OrderDTO(id, empID, orderedDate, quantity, total);
                }
            }
        } finally {
            closeConnection();
            return order;
        }
    }
}
