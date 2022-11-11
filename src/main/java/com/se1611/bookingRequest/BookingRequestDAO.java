/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.se1611.bookingRequest;

import com.se1611.utils.DBHelper;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author Admin
 */
public class BookingRequestDAO {

    public List<BookingRequestDTO> getListBookingRequest()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<BookingRequestDTO> listBookingRequest = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
//                String sql = "Select request_Id, image, name_Book, quantity_Request, price_Request, date_Request, note, status, status_Book_Request\n"
//                        + "From BookingRequest";
                String sql = "Select request_Id, image, name_Book, quantity_Request, price_Request, date_Request, date_Request_Done, note, status, status_Book_Request\n"
                        + "From BookingRequest "
                        + "Order by status";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int request_Id = rs.getInt("request_Id");
                    String image = rs.getString("image");
                    String name_Book = rs.getString("name_Book");
                    int quantity_Request = rs.getInt("quantity_Request");
                    float price_Request = rs.getFloat("price_Request");
                    LocalDate date_Request = rs.getDate("date_Request").toLocalDate();
                    LocalDate date_Request_Done = null;
                    String note = rs.getString("note");
                    int status = rs.getInt("status");
                    boolean status_Book_Request = rs.getBoolean("status_Book_Request");
                    if (listBookingRequest == null) {
                        listBookingRequest = new ArrayList<>();
                    }
                    listBookingRequest.add(new BookingRequestDTO(request_Id, image, name_Book, quantity_Request, price_Request, date_Request, date_Request_Done, note, status, status_Book_Request));
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
        return listBookingRequest;
    }//end getListBooking request function

    public List<BookingRequestDTO> searchBookRequest(String searchValue)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        List<BookingRequestDTO> listBookRequest = new ArrayList<>();

        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "Select request_Id, image, name_Book, quantity_Request, price_Request, date_Request, date_Request_Done, note, status, status_Book_Request\n"
                        + "From BookingRequest\n"
                        + "Where name_Book LIKE ?";

                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    int request_Id = rs.getInt("request_Id");
                    String image = rs.getString("image");
                    String name_Book = rs.getString("name_Book");
                    int quantity_Request = rs.getInt("quantity_Request");
                    float price_Request = rs.getFloat("price_Request");
                    LocalDate date_Request = rs.getDate("date_Request").toLocalDate();
                    LocalDate date_Request_Done = rs.getDate("date_Request_Done").toLocalDate();
                    String note = rs.getString("note");
                    int status = rs.getInt("status");
                    boolean status_Book_Request = rs.getBoolean("status_Book_Request");

                    if (date_Request_Done != null) {
                        listBookRequest.add(new BookingRequestDTO(request_Id, image, name_Book, quantity_Request, price_Request, date_Request, date_Request_Done, note, status, status_Book_Request));
                    } else {
                        listBookRequest.add(new BookingRequestDTO(request_Id, image, name_Book, quantity_Request, price_Request, date_Request, note, status, status_Book_Request));
                    }
                }//end while rs not null
            }//end if con is not null
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
        return listBookRequest;
    }

    public boolean addNewBookingRequest(String image, String name_Book, int quantity_Request, float price_Request, LocalDate date_Request, String note, int status, boolean status_Book_Request)
            throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "Insert Into BookingRequest(image, name_Book, quantity_Request, price_Request, date_Request, note, status, status_Book_Request)\n"
                        + "Values (?, ?, ?, ?, ?, ?, ?, ?);";

                stm = con.prepareStatement(sql);
                stm.setString(1, image);
                stm.setString(2, name_Book);
                stm.setInt(3, quantity_Request);
                stm.setFloat(4, price_Request);
                stm.setDate(5, Date.valueOf(date_Request));
                stm.setString(6, note);
                stm.setInt(7, status);
                stm.setBoolean(8, status_Book_Request);

                int rowEffect = stm.executeUpdate();
                if (rowEffect > 0) {
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
    }//end addNewBookingRequest

    public float getTotalMoneyLastMonthBookRequest()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        float totalMoneyLastMonthBookRequest = 0;

        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT SUM(price_Request * quantity_Request)\n"
                        + "FROM BookingRequest\n"
                        + "Where Month(GETDATE()) - 1 = MONTH(date_Request) ";
//                String sql = "Select SUM(quantity_Request * price_Request)\n"
//                        + "From [BookingRequest]\n"
//                        + "Where Month(date_Request) = Month(GETDATE() - 1) ";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String sumValue = rs.getString(1);
                    totalMoneyLastMonthBookRequest = Float.parseFloat(sumValue);
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
        return totalMoneyLastMonthBookRequest;
    }
}//end class
