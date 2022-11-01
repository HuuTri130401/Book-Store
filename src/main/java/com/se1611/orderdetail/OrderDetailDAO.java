/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se1611.orderdetail;

import com.se1611.utils.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import com.se1611.book.BookDAO;
import com.se1611.book.BookDTO;

/**
 *
 * @author chilamha
 */
public class OrderDetailDAO {
    
    public List<CustomizedOrderDetailDTO> getOrderDetailsByOrderID(int orderId) throws SQLException, NamingException{
        List<CustomizedOrderDetailDTO> details = null;
        
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try{
            con = DBHelper.getConnection();
            if(con != null){
                String sql = "Select od.order_Detail_Id, od.book_Id, od.quantity_Order_Detail, od.total_Order_Detail, b.category, b.image_Book, b.name, b.price_Book "
                        + "From OrderDetail od join Book b on od.book_Id = b.book_Id "
                        + "Where od.order_Detail_Id = ? ";
                
                stm = con.prepareStatement(sql);
                stm.setInt(1, orderId);
                rs = stm.executeQuery();
                
                while(rs.next()){
                    int detailId = rs.getInt("order_Detail_Id");
                    int bookID = rs.getInt("book_Id");
                    String name = rs.getString("name");
                    String img = rs.getString("image_Book");
                    int cate = rs.getInt("category");
                    int quantity = rs.getInt("quantity_Order_Detail");
                    float price = rs.getFloat("price_Book");
                    float total = rs.getFloat("total_Order_Detail");
                    CustomizedOrderDetailDTO dto = new CustomizedOrderDetailDTO(detailId, bookID, quantity, cate, name, price, img);
                    
                    if(details == null){
                        details = new ArrayList<>();
                    }
                    details.add(dto);
                }
            }
        }
        finally{
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(con != null){
                con.close();
            }
        }
        return details;
    }
    
    public ArrayList<OrderItemObj> GetOrderDetailByOrderID(int OrderID) throws SQLException, ClassNotFoundException, NamingException {
        Connection connection = null;
        PreparedStatement prestm = null;
        ResultSet rs = null;
        try {
            connection = DBHelper.getConnection();
            if (connection != null) {
                String orderSQLString = "SELECT order_Detail_Id, order_Id, book_Id, quantity_Order_Detail, total_Order_Detail "
                        + "FROM OrderDetail "
                        + "WHERE order_Id = ?";

                prestm = connection.prepareStatement(orderSQLString);
                prestm.setInt(1, OrderID);
                rs = prestm.executeQuery();
                ArrayList<OrderItemObj> result = new ArrayList<>();
                while (rs.next()) {
                    
                    BookDAO BookDAO = new BookDAO();
                    BookDTO BookDTO = BookDAO.GetBookbyID(rs.getInt("book_Id"));
                    OrderItemObj OrderItemObj = new OrderItemObj(BookDTO, rs.getInt("quantity_Order_Detail"));
                    result.add(OrderItemObj);
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
     public boolean CreateOrderDetail(int OrderID, int BookID, int quantity, float total) throws
            SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "INSERT INTO OrderDetail(order_Id, book_Id, quantity_Order_Detail, total_Order_Detail) "
                        + "VALUES (?, ?, ?, ?)";
                stm = con.prepareStatement(sql);
                stm.setInt(1, OrderID);
                stm.setInt(2, BookID);
                stm.setInt(3, quantity);
                stm.setFloat(4, total);
                int result = stm.executeUpdate();
                if (result > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
     public int GetQuantityByOrderID(int OrderID) throws SQLException, ClassNotFoundException, NamingException {
        Connection connection = null;
        PreparedStatement prestm = null;
        ResultSet rs = null;
        Integer quantity = 0;
        try {
            connection = DBHelper.getConnection();
            if (connection != null) {
                String orderSQLString = "SELECT order_Detail_Id, order_Id, book_Id, quantity_Order_Detail, total_Order_Detail "
                        + "FROM OrderDetail "
                        + "WHERE order_Id = ?";

                prestm = connection.prepareStatement(orderSQLString);
                prestm.setInt(1, OrderID);
                rs = prestm.executeQuery();
                
                if (rs.next()) {
                     quantity = rs.getInt("Quantity");
                    
                }
                
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
        return quantity;
    }   
    
    public boolean deleteOrderDetail(int OrderID) throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "DELETE FROM OrderDetail "
                        + " WHERE order_Detail_Id = ? ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, OrderID);
                int rowAffect = stm.executeUpdate();
                if (rowAffect > 0) {
                    return true;
                }
            }

        } finally {

            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
}
