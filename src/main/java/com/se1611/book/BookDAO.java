/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.se1611.book;

import com.se1611.utils.DBHelper;
import java.io.Serializable;
import java.sql.CallableStatement;
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
 * @author tuan vu
 */
public class BookDAO implements Serializable {

    private List<BookDTO> bookList;

    public List<BookDTO> getBookList() {
        return bookList;
    }
    
    public void getAllBook() throws SQLException, NamingException{
        Connection con = null;
        CallableStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBHelper.getConnection();
            if(con != null){
                String sql = "SELECT book_Id, name_Book, author_Book, year_Of_Public, category, price_Book, quantity_Book, image, status_Book, description_Book "
                        + "FROM Book "
                        + "WHERE status_Book = 1";
                stm = con.prepareCall(sql);
                rs = stm.executeQuery();
                
                while(rs.next()){
                    int bookID = rs.getInt("book_Id");
                    String name = rs.getString("name_Book");
                    String author = rs.getString("author_Book");
                    int year = rs.getInt("year_Of_Public");
                    int categoryId = rs.getInt("category");
                    float price = rs.getFloat("price_Book");
                    int quantity = rs.getInt("quantity_Book");
                    String img = rs.getString("image");
                    boolean status = rs.getBoolean("status_Book");
                    String des = rs.getString("description_Book");
                        
                    BookDTO dto = new BookDTO(bookID, name, author, year, categoryId, price, quantity, img, status, des);
                    
                    if(this.bookList == null){
                        this.bookList = new ArrayList<>();
                    }
                    this.bookList.add(dto);
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
    
    public List<BookDTO> getInformationBook(int first, int last) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<BookDTO> listBook = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "select book_Id,name_Book,author_Book,year_Of_Public,category,price_Book,quantity_Book,image\n"
                        + ",status_Book,description_Book\n"
                        + "from (\n"
                        + "	select *, ROW_NUMBER()over(Order by [book_Id]) as Rownum\n"
                        + "	from Book\n"
                        + ")as BookData\n"
                        + "where BookData.Rownum between ? and ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, first);
                stm.setInt(2, last);
                rs = stm.executeQuery();
                listBook = new ArrayList<>();
                while (rs.next()) {
                    BookDTO list = new BookDTO();
                    list.setBook_Id(rs.getInt("book_Id"));
                    list.setName(rs.getString("name_Book"));
                    list.setAuthor(rs.getString("author_Book"));
                    list.setYear_Of_Public(rs.getInt("year_Of_Public"));
                    list.setCategory(rs.getInt("category"));
                    list.setPrice_Book(rs.getFloat("price_Book"));
                    list.setQuantity_Book(rs.getInt("quantity_Book"));
                    list.setImage_Book(rs.getString("image"));
                    list.setStatus(rs.getBoolean("status_Book"));
                    list.setDescriptionBook(rs.getString("description_Book"));
                    listBook.add(list);
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
        return listBook;
    }

    public List<BookDTO> getCategoryBook(int categoryId) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<BookDTO> listCategoryBook = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "select book_Id,name_Book,author_Book,year_Of_Public,category,price_Book,quantity_Book,image\n"
                        + ",status_Book,c.category_Name as nameCate,description_Book\n"
                        + "from Book b inner join Category c on b.category=c.category_Id\n"
                        + "where b.category=?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, categoryId);
                rs = stm.executeQuery();
                listCategoryBook = new ArrayList<>();
                while (rs.next()) {
                   BookDTO list=new BookDTO();
                    list.setBook_Id(rs.getInt("book_Id"));
                    list.setName(rs.getString("name_Book"));
                    list.setAuthor(rs.getString("author_Book"));
                    list.setYear_Of_Public(rs.getInt("year_Of_Public"));
                    list.setCategory(rs.getInt("category"));
                    list.setPrice_Book(rs.getFloat("price_Book"));
                    list.setQuantity_Book(rs.getInt("quantity_Book"));
                    list.setImage_Book(rs.getString("image"));
                    list.setStatus(rs.getBoolean("status_Book"));
                    list.setCategoryName(rs.getString("nameCate"));
                    list.setDescriptionBook(rs.getString("description_Book"));
                    listCategoryBook.add(list);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
        return listCategoryBook;
    }

    public BookDTO GetBookbyID(int bookId)
            throws SQLException, NamingException{
            Connection con = null;
            PreparedStatement stm = null;
            ResultSet rs = null;
            try{
                con = DBHelper.getConnection();
                if(con != null){
                    String sql = "Select book_Id, name_Book, author_Book, year_Of_Public, category, price_Book, quantity_Book, image, status_Book, description_Book "
                            + "From Book "
                            + "Where book_Id = ?";
                    
                    stm = con.prepareStatement(sql);
                    stm.setInt(1, bookId);
                    rs = stm.executeQuery();
                    
                    if(rs.next()){
                        int bookID = rs.getInt("book_Id");
                        String name = rs.getString("name_Book");
                        String author = rs.getString("author_Book");
                        int year = rs.getInt("year_Of_Public");
                        int categoryId = rs.getInt("category");
                        float price = rs.getFloat("price_Book");
                        int quantity = rs.getInt("quantity_Book");
                        String img = rs.getString("image");
                        boolean status = rs.getBoolean("status_Book");
                        String des = rs.getString("description_Book");
                        
                        BookDTO dto = new BookDTO(bookID, name, author, year, categoryId, price, quantity, img, status, des);
                        return dto;
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
        return null;
    }
}
