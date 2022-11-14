/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.se1611.orders;

import com.se1611.utils.DBHelper;

import javax.naming.NamingException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderDAO {

    public List<OrderDTO> getTotalOrderIn12Months()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<OrderDTO> listTotalOrder = new ArrayList<>();

        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "select Month(date_To_Oder) as m, Year(date_To_Oder) as y, sum(total_Order) as total\n"
                        + "From [Order]\n"
                        + "Where Year(GETDATE()) = Year(date_To_Oder) \n"
                        + "group by Month(date_To_Oder), Year(date_To_Oder)";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int month = rs.getInt("m");
                    int year = rs.getInt("y");
                    float totalOrder = rs.getFloat("total");
                    OrderDTO orderDTO = new OrderDTO(month, year, totalOrder);
                    listTotalOrder.add(orderDTO);
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
        return listTotalOrder;
    }

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

    public List<OrderDTO> GetInforOrder(int first, int last) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<OrderDTO> listOrder = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "select order_Id,quantity_Order,total_Order,fullName, date_To_Oder,status\n"
                        + "                        from (select order_Id,quantity_Order,total_Order,fullName, date_To_Oder,status, ROW_NUMBER()over(Order by [order_Id]) as Rownum\n"
                        + "                    from  [dbo].[Order] o inner join Employee e on e.employee_Id=o.employee_Id )as BookData\n"
                        + "\t\t\t\t\t\twhere BookData.Rownum between ? and ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, first);
                stm.setInt(2, last);
                rs = stm.executeQuery();
                listOrder = new ArrayList<>();
                while (rs.next()) {
                    OrderDTO list = new OrderDTO();
                    list.setOrder_Id(rs.getInt("order_Id"));
                    list.setQuantity_Order(rs.getInt("quantity_Order"));
                    list.setTotal_Order(rs.getFloat("total_Order"));
                    list.setDate_To_Order(rs.getDate("date_To_Oder"));
                    list.setFullname(rs.getString("fullName"));
                    list.setStatus_Order(rs.getBoolean("status"));
                    listOrder.add(list);
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
        return listOrder;
    }

    //Search
    public List<OrderDTO> SeachInforOrder(List<Integer> orderIdList) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<OrderDTO> listOrder = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                listOrder = new ArrayList<>();
                for (int i = 0; i < orderIdList.size(); i++) {
                    //SQl connect data access
                    String sql = "select order_Id,quantity_Order,total_Order,fullName, date_To_Oder,status\n"
                            + "from [dbo].[Order] o inner join Employee e on e.employee_Id=o.employee_Id where order_Id = ?";
                    stm = con.prepareStatement(sql);
                    stm.setInt(1, orderIdList.get(i));
                    rs = stm.executeQuery();
                    while (rs.next()) {
                        OrderDTO list = new OrderDTO();
                        list.setOrder_Id(rs.getInt("order_Id"));
                        list.setQuantity_Order(rs.getInt("quantity_Order"));
                        list.setTotal_Order(rs.getFloat("total_Order"));
                        list.setDate_To_Order(rs.getDate("date_To_Oder"));
                        list.setFullname(rs.getString("fullName"));
                        list.setStatus_Order(rs.getBoolean("status"));
                        listOrder.add(list);
                    }
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
        return listOrder;
    }

    public boolean createOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException, NamingException {
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String query = "INSERT INTO [Order] (employee_Id, date_To_Oder, quantity_Order, total_Order,status)"
                        + "VALUES (?,?,?,?,?)";
                stm = con.prepareStatement(query);
                stm.setInt(1, orderDTO.getEmployee_Id());
                stm.setDate(2, orderDTO.getDate_To_Order());
                stm.setInt(3, orderDTO.getQuantity_Order());
                stm.setFloat(4, orderDTO.getTotal_Order());
                stm.setBoolean(5, true);
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
