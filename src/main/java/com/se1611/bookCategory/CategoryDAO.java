/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se1611.bookCategory;

import com.se1611.utils.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author chilamha
 */
public class CategoryDAO {
    private List<CategoryDTO> CateList;

    public List<CategoryDTO> getCateList() {
        return CateList;
    }
    
    public void getAllCategory()throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBHelper.getConnection();
            if(con != null){
                String sql = "SELECT category_Id, category_Name "
                        + "FROM Category "
                        + "ORDER BY category_Name ASC";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                
                while(rs.next()){
                    int categoryID = rs.getInt("category_Id");
                    String categoryName = rs.getString("category_Name");
                    CategoryDTO dto = new CategoryDTO(categoryID, categoryName);
                    if(this.CateList == null){
                        this.CateList = new ArrayList<>();
                    }
                    this.CateList.add(dto);
                }
            }
        }finally{
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
    }
}
