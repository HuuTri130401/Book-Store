package com.se1611.Importation;

import com.se1611.book.BookDTO;
import com.se1611.inventory.InventoryDTO;
import com.se1611.utils.DBHelper;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImportationDAO {
    //Get List Importation
    public List<ImportationDTO> getImportation() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<ImportationDTO> listImportation = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "select i.import_Id as importId, import_Detail_Id,r.request_Id as requestId, b.image as image, b.name_Book as name_Book, date_Import,\n" +
                        "                        price_Import_Detail,quantity_Import_Detail,total_Import_Detail,d.note as note,d.status as status_Import,\n" +
                        "                        b.book_Id as bookId,category,fullName\n" +
                        "                        from Importation i inner join ImportationDetail d on i.import_Id=d.import_Id inner join\n" +
                        "                        BookingRequest r on r.request_Id=i.request_id inner join Book b on d.book_Id=b.book_Id\n" +
                        "                        inner join Employee e on i.employee_Id=e.employee_Id";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                listImportation = new ArrayList<>();
                while (rs.next()) {
                    ImportationDTO list = new ImportationDTO();
                    list.setImport_Id(rs.getInt("importId"));
                    list.setImport_Detail_Id(rs.getInt("import_Detail_Id"));
                    list.setImport_Request_Id(rs.getInt("requestId"));
                    list.setImport_image(rs.getString("image"));
                    list.setImport_Name_Book(rs.getString("name_Book"));
                    list.setImport_Date(rs.getDate("date_Import"));
                    list.setImport_Detail_Price_Book(rs.getFloat("price_Import_Detail"));
                    list.setImport_Quantity_Request(rs.getInt("quantity_Import_Detail"));
                    list.setImport_Detail_Total(rs.getFloat("total_Import_Detail"));
                    list.setImport_Status(rs.getBoolean("status_Import"));
                    list.setImport_Note(rs.getString("note"));
                    list.setImport_Book_Id(rs.getInt("bookId"));
                    list.setImport_Category_Id(rs.getInt("category"));
                    list.setImport_Employee(rs.getString("fullName"));
                    listImportation.add(list);
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
        return listImportation;
    }
//Search
public List<ImportationDTO> SearchImportation(String search) throws SQLException, NamingException {
    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;
    List<ImportationDTO> listImportation = null;
    try {
        con = DBHelper.getConnection();
        if (con != null) {
            String sql = "select i.import_Id as importId, import_Detail_Id,r.request_Id as requestId, b.image as image, b.name_Book as name_Book, date_Import,\n" +
                    "                        price_Import_Detail,quantity_Import_Detail,total_Import_Detail,d.note as note,d.status as status_Import,\n" +
                    "                        b.book_Id as bookId,category,fullName\n" +
                    "                        from Importation i inner join ImportationDetail d on i.import_Id=d.import_Id inner join\n" +
                    "                        BookingRequest r on r.request_Id=i.request_id inner join Book b on d.book_Id=b.book_Id\n" +
                    "                        inner join Employee e on i.employee_Id=e.employee_Id where b.name_Book like ?";
            stm = con.prepareStatement(sql);
            stm.setString(1,"%"+search+"%");
            rs = stm.executeQuery();
            listImportation = new ArrayList<>();
            while (rs.next()) {
                ImportationDTO list = new ImportationDTO();
                list.setImport_Id(rs.getInt("importId"));
                list.setImport_Detail_Id(rs.getInt("import_Detail_Id"));
                list.setImport_Request_Id(rs.getInt("requestId"));
                list.setImport_image(rs.getString("image"));
                list.setImport_Name_Book(rs.getString("name_Book"));
                list.setImport_Date(rs.getDate("date_Import"));
                list.setImport_Detail_Price_Book(rs.getFloat("price_Import_Detail"));
                list.setImport_Quantity_Request(rs.getInt("quantity_Import_Detail"));
                list.setImport_Detail_Total(rs.getFloat("total_Import_Detail"));
                list.setImport_Status(rs.getBoolean("status_Import"));
                list.setImport_Note(rs.getString("note"));
                list.setImport_Book_Id(rs.getInt("bookId"));
                list.setImport_Category_Id(rs.getInt("category"));
                list.setImport_Employee(rs.getString("fullName"));
                listImportation.add(list);
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
    return listImportation;
}
    //Insert To Importation
    public boolean InsertImportation(int employee_Id, Date date_Into_Inventory, int request_Id) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = true;
        int count = 0;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "insert Importation (employee_Id,date_Import,request_id)\n" +
                        "values (?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setInt(1, employee_Id);
                stm.setDate(2, date_Into_Inventory);
                stm.setInt(3, request_Id);
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

    //Insert Importation Detail
    public boolean InsertImportationDetail(int import_Id, int quantity_import, float import_price,
                                    float import_total,String note,int BookId) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = true;
        int count = 0;
        boolean status=true;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "insert ImportationDetail([import_Id],quantity_Import_Detail,\n" +
                        "[price_Import_Detail],[total_Import_Detail],[note],status,book_Id)\n" +
                        "values (?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setInt(1, import_Id);
                stm.setInt(2, quantity_import);
                stm.setFloat(3, import_price);
                stm.setFloat(4, import_total);
                stm.setString(5, note);
                stm.setBoolean(6, status);
                stm.setInt(7,BookId);
                count = stm.executeUpdate();
                if (count == 0) {
                    result = false;
                } else {
                    result = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            stm.close();
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    //Delete Inventory
    public boolean DeleteImportation(int importation_Id, boolean check) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = true;
        int count = 0;

        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "update [dbo].[ImportationDetail] set [status]=? where [import_Detail_Id]=?";
                stm = con.prepareStatement(sql);
                if(check) {
                    stm.setBoolean(1, true);
                }else{
                    stm.setBoolean(1, false);
                }
                stm.setInt(2, importation_Id);
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
