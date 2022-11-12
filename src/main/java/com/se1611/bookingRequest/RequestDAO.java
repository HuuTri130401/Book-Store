package com.se1611.bookingRequest;

import com.se1611.utils.DBHelper;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestDAO {
    //Get List Request
    public List<RequestDTO> getRequest() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<RequestDTO> listRequest = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "select request_Id,image, name_Book,quantity_Request,price_Request,date_Request,note,status," +
                        " status_Book_Request, date_Request_Done\n" +
                        " from BookingRequest";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                listRequest = new ArrayList<>();
                while (rs.next()) {
                    RequestDTO list = new RequestDTO();
                    list.setRequest_Id(rs.getInt("request_Id"));
                    list.setRequest_Image(rs.getString("image"));
                    list.setRequest_Name_Book(rs.getString("name_Book"));
                    list.setRequest_Quantity(rs.getInt("quantity_Request"));
                    list.setRequest_Date(rs.getDate("date_Request"));
                    list.setRequest_Date_Done(rs.getDate("date_Request_Done"));
                    list.setRequest_Note(rs.getString("note"));
                    list.setRequest_Status(rs.getInt("status"));
                    list.setStatus_Book_Request(rs.getBoolean("status_Book_Request"));
                    list.setRequest_Price(rs.getFloat("price_Request"));
                    listRequest.add(list);
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
        return listRequest;
    }

    //Search
    public List<RequestDTO> SearchRequest(String search) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<RequestDTO> listRequest = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "select request_Id,image, name_Book,quantity_Request,price_Request,date_Request,note,status," +
                        "status_Book_Request,date_Request_Done\n" +
                        "                        from BookingRequest where name_Book like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                listRequest = new ArrayList<>();
                while (rs.next()) {
                    RequestDTO list = new RequestDTO();
                    list.setRequest_Id(rs.getInt("request_Id"));
                    list.setRequest_Image(rs.getString("image"));
                    list.setRequest_Name_Book(rs.getString("name_Book"));
                    list.setRequest_Quantity(rs.getInt("quantity_Request"));
                    list.setRequest_Date(rs.getDate("date_Request"));
                    list.setRequest_Date_Done(rs.getDate("date_Request_Done"));
                    list.setRequest_Note(rs.getString("note"));
                    list.setRequest_Status(rs.getInt("status"));
                    list.setStatus_Book_Request(rs.getBoolean("status_Book_Request"));
                    list.setRequest_Price(rs.getFloat("price_Request"));
                    listRequest.add(list);
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
        return listRequest;
    }
    //update Status Request
    public boolean UpdateStatusRequest(int request_Id,boolean check) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = true;
        int count = 0;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "update [dbo].[BookingRequest] set status=? where [request_Id]=?";
                stm = con.prepareStatement(sql);
                //Check status, if true to update Done, false update Un Done
                if(check) {
                    stm.setInt(1, 2);
                }else{
                    stm.setInt(1, 3);
                }
                stm.setInt(2, request_Id);
                count = stm.executeUpdate();
                if (count == 0) {
                    result = false;
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
        return result;
    }

    //Update Date Request Done
    public void UpdateDateRequestDone(int request_Id, Date dateRequestDone) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "update [dbo].[BookingRequest] set date_Request_Done=? where [request_Id]=?";
                stm = con.prepareStatement(sql);
                //Check status, if true to update Done, false update Un Done
                stm.setDate(1, dateRequestDone);
                stm.setInt(2, request_Id);
                stm.executeUpdate();
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    //update Status Book New/Old Request
    public boolean UpdateStatusNewOld(int request_Id) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = true;
        int count = 0;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "update [dbo].[BookingRequest] set [status_Book_Request]=? where [request_Id]=?";
                stm = con.prepareStatement(sql);
                //Check status, if true to update Done, false update Un Done
                    stm.setBoolean(1, false);
                stm.setInt(2, request_Id);
                count = stm.executeUpdate();
                if (count == 0) {
                    result = false;
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
        return result;
    }

    //Delete Request
    public boolean DeleteRequest(int request_Id) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = true;
        int count = 0;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "update [dbo].[BookingRequest] set status=? where [request_Id]=?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, 0);
                stm.setInt(2, request_Id);
                count = stm.executeUpdate();
                if (count == 0) {
                    result = false;
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
        return result;
    }
}
