/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.se1611.category;

import com.se1611.utils.DBHelper;
import java.io.Serializable;
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
public class CategoryDAO implements Serializable {
    private List<CategoryDTO> cateList;

    public List<CategoryDTO> getCateList() {
        return cateList;
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
                    if(this.cateList == null){
                        this.cateList = new ArrayList<>();
                    }
                    this.cateList.add(dto);
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
