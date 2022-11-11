package com.se1611.inventory;

import com.se1611.utils.DBHelper;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryDAO {

    //List get Inventory Exists in Database
    public List<InventoryDTO> GetInventory() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<InventoryDTO> listInventory = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "select i.inventory_Id as inventory_Id,inventory_Detail_Id, image,name_Book, \n"
                        + "quantity_Inventory,note,date_Into_Inventory,fullName,b.book_Id as book_Id,category,status\n"
                        + "from Inventory i inner join InventoryDetail d on \n"
                        + "i.inventory_Id=d.inventory_Id inner join \n"
                        + "Book b on d.book_Id=b.book_Id inner join Employee e on i.employee_Id=e.employee_Id";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                listInventory = new ArrayList<>();
                while (rs.next()) {
                    InventoryDTO list = new InventoryDTO();
                    list.setInventory_Id(rs.getInt("inventory_Id"));
                    list.setInventory_Img(rs.getString("image"));
                    list.setInventory_Name_Book(rs.getString("name_Book"));
                    list.setQuantity_Inventory(rs.getInt("quantity_Inventory"));
                    list.setNote_Inventory(rs.getString("note"));
                    list.setDate_Inventory(rs.getDate("date_Into_Inventory"));
                    list.setEmployee_Inventory(rs.getString("fullName"));
                    list.setInventory_Book_Id(rs.getInt("book_Id"));
                    list.setInventory_Category_Id(rs.getInt("category"));
                    list.setInventory_Status(rs.getBoolean("status"));
                    list.setInventory_Detail_Id(rs.getInt("inventory_Detail_Id"));
                    listInventory.add(list);
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
        return listInventory;
    }
    //Search
    public List<InventoryDTO> SearchInventory(String search) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<InventoryDTO> listInventory = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "select i.inventory_Id as inventory_Id,inventory_Detail_Id, image,name_Book, \n"
                        + "quantity_Inventory,note,date_Into_Inventory,fullName,b.book_Id as book_Id,category,status\n"
                        + "from Inventory i inner join InventoryDetail d on \n"
                        + "i.inventory_Id=d.inventory_Id inner join \n"
                        + "Book b on d.book_Id=b.book_Id inner join Employee e on i.employee_Id=e.employee_Id where name_Book like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1,"%"+search+"%");
                rs = stm.executeQuery();
                listInventory = new ArrayList<>();
                while (rs.next()) {
                    InventoryDTO list = new InventoryDTO();
                    list.setInventory_Id(rs.getInt("inventory_Id"));
                    list.setInventory_Img(rs.getString("image"));
                    list.setInventory_Name_Book(rs.getString("name_Book"));
                    list.setQuantity_Inventory(rs.getInt("quantity_Inventory"));
                    list.setNote_Inventory(rs.getString("note"));
                    list.setDate_Inventory(rs.getDate("date_Into_Inventory"));
                    list.setEmployee_Inventory(rs.getString("fullName"));
                    list.setInventory_Book_Id(rs.getInt("book_Id"));
                    list.setInventory_Category_Id(rs.getInt("category"));
                    list.setInventory_Status(rs.getBoolean("status"));
                    list.setInventory_Detail_Id(rs.getInt("inventory_Detail_Id"));
                    listInventory.add(list);
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
        return listInventory;
    }
    //Insert Inventory
    public boolean InsertInventory(int employee_Id, Date date_Into_Inventory) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = true;
        int count = 0;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "insert into Inventory (employee_Id,date_Into_Inventory)\n" + "values (?,?)";
                stm = con.prepareStatement(sql);
                stm.setInt(1, employee_Id);
                stm.setDate(2, date_Into_Inventory);
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

    //Insert Inventory Detail
    public boolean InsertInventoryDetail(int inventory_Id, int book_Id, int quantity_Inventory, String note) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = true;
        int count = 0;
        boolean status = true;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "insert into InventoryDetail(inventory_Id,book_Id,quantity_Inventory,note,status)\n" + "values (?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setInt(1, inventory_Id);
                stm.setInt(2, book_Id);
                stm.setInt(3, quantity_Inventory);
                stm.setString(4, note);
                stm.setBoolean(5, status);
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
    public boolean DeleteInventory(int inventory_Id,boolean check) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = true;
        int count = 0;

        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "update [dbo].[InventoryDetail] set status=? where [inventory_Detail_Id]=?";
                stm = con.prepareStatement(sql);
                if(check) {
                    stm.setBoolean(1, true);
                }else{
                    stm.setBoolean(1, false);
                }
                stm.setInt(2, inventory_Id);
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

    public int getSumInventoryInYear()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int sumInventoryInYear = 0;

        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "Select SUM(quantity_Inventory)\n"
                        + "From Inventory inv Inner Join InventoryDetail invd\n"
                        + "On inv.inventory_Id = invd.inventory_Id\n"
                        + "Where YEAR(date_Into_Inventory) = YEAR(GETDATE()) ";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String sumValue = rs.getString(1);
                    sumInventoryInYear = Integer.parseInt(sumValue);
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
        return sumInventoryInYear;
    }
}
