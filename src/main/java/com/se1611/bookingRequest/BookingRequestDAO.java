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
                String sql = "Select request_Id, image, name_Book, quantity_Request, price_Request, date_Request, note, status, status_Book_Request \n"
                        + "From BookingRequest";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int request_Id = rs.getInt("request_Id");
                    String image = rs.getString("image");
                    String name_Book = rs.getString("name_Book");
                    int quantity_Request = rs.getInt("quantity_Request");
                    float price_Request = rs.getFloat("price_Request");
                    Date date_Request = rs.getDate("date_Request");
                    String note = rs.getString("note");
                    int status = rs.getInt("status");
                    boolean status_Book_Request = rs.getBoolean("status_Book_Request");
                    if (listBookingRequest == null) {
                        listBookingRequest = new ArrayList<>();
                    }
                    listBookingRequest.add(new BookingRequestDTO(request_Id, image, name_Book, quantity_Request, price_Request, date_Request, note, status, status_Book_Request));
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

    public boolean addNewBookingRequest(String image, String name_Book, int quantity_Request, float price_Request, Date date_Request, String note, int status, boolean status_Book_Request)
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
                stm.setDate(5, date_Request);
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

}//end class
