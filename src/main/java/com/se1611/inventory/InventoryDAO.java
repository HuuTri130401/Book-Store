package com.se1611.inventory;

import com.se1611.book.BookDTO;
import com.se1611.utils.DBHelper;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                String sql = "select i.inventory_Id as inventory_Id, image,name_Book, \n" +
                        "quantity_Inventory,note,date_Into_Inventory,fullName,b.book_Id as book_Id,category\n" +
                        "from Inventory i inner join InventoryDetail d on \n" +
                        "i.inventory_Id=d.inventory_Id inner join \n" +
                        "Book b on d.book_Id=b.book_Id inner join Employee e on i.employee_Id=e.employee_Id";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                listInventory = new ArrayList<>();
                while (rs.next()) {
                    InventoryDTO list=new InventoryDTO();
                    list.setInventory_Id(rs.getInt("inventory_Id"));
                    list.setInventory_Img(rs.getString("image"));
                    list.setInventory_Name_Book(rs.getString("name_Book"));
                    list.setQuantity_Inventory(rs.getInt("quantity_Inventory"));
                    list.setNote_Inventory(rs.getString("note"));
                    list.setDate_Inventory(rs.getDate("date_Into_Inventory"));
                    list.setEmployee_Inventory(rs.getString("fullName"));
                    list.setInventory_Book_Id(rs.getInt("book_Id"));
                    list.setInventory_Category_Id(rs.getInt("category"));
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

}
