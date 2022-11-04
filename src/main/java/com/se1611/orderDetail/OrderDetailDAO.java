/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se1611.orderDetail;

import com.se1611.utils.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author Admin
 */
public class OrderDetailDAO {

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

    public boolean createOrder(OrderDetailDTO orderDetailDTO) throws SQLException, ClassNotFoundException, NamingException {
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String query = "INSERT INTO OrderDetail (order_Id, book_Id, quantity_Order_Detail, total_Order_Detail, status)"
                        + "VALUES (?,?,?,?,?)";
                stm = con.prepareStatement(query);
                stm.setInt(1, orderDetailDTO.getOrder_Id());
                stm.setInt(2, orderDetailDTO.getBook_Id());
                stm.setInt(3, orderDetailDTO.getQuantity_Order_Detail());
                stm.setFloat(4, orderDetailDTO.getTotal_Order_Detail());
                stm.setBoolean(5, true);
                stm.executeUpdate();
                return true;
            }
        } finally {
            closeConnection();
        }
        return false;
    }

    public ArrayList<OrderDetailDTO> getListOrderDetail() throws SQLException, NamingException {
        ArrayList<OrderDetailDTO> listOrderDetail = new ArrayList<>();
        try {
            String query = "SELECT * FROM OrderDetail";
            con = DBHelper.getConnection();
            if (con != null) {
                stm = con.prepareStatement(query);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int order_Detail_Id = rs.getInt(1);
                    int order_Id = rs.getInt(2);
                    int book_Id = rs.getInt(3);
                    int quantity_Order_Detail = rs.getInt(4);
                    float total_Order_Detail = rs.getFloat(5);
                    boolean status = rs.getBoolean(6);
                    OrderDetailDTO orderDetailDTO = new OrderDetailDTO(order_Detail_Id, order_Id, book_Id, quantity_Order_Detail, total_Order_Detail, status);
                    listOrderDetail.add(orderDetailDTO);
                }
            }
        } finally {
            closeConnection();
        }
        return listOrderDetail;
    }

    public boolean updateStatus(int orderDetailId) throws SQLException, NamingException {
        String query = "UPDATE OrderDetail SET status=? WHERE order_Detail_Id=?";
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                stm = con.prepareStatement(query);
                stm.setBoolean(1, false);
                stm.setInt(2, orderDetailId);
                int result = stm.executeUpdate();
                if (result > 0) {
                    return true;
                }
            }
        } finally {
            closeConnection();
        }
        return false;
    }
}
