/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.se1611.book;

import com.se1611.utils.DBHelper;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tuan vu
 */
public class BookDAO {
    //Delete Inventory
    public boolean StatusBook(int book_Id,boolean check) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = true;
        int count = 0;

        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "update Book set status_Book=? where book_Id=?";
                stm = con.prepareStatement(sql);
                if(check) {
                    stm.setBoolean(1, true);
                }else{
                    stm.setBoolean(1, false);
                }
                stm.setInt(2, book_Id);
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
    //Get Book Deleted
    public List<BookDTO> getInformationBookDeleted(int first, int last) throws SQLException, NamingException {
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
                        + "	from Book where status_Book=0)\n"
                        + "as BookData\n"
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
                rs.close();
                stm.close();
                con.close();
        }
        return listBook;
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
                        + "	from Book where status_Book=1\n"
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
//Search Book
public List<BookDTO> SearchBook(int first, int last,String search) throws SQLException, NamingException {
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
                    + "	from Book where name_Book like ?\n"
                    + ")as BookData\n"
                    + "where BookData.Rownum between ? and ?";
            stm = con.prepareStatement(sql);
            stm.setString(1,"%"+search+"%");
            stm.setInt(2, first);
            stm.setInt(3, last);
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
    public List<BookDTO> getCategoryBook(int categoryId, int firstPage, int lastPage) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<BookDTO> listCategoryBook = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "select book_Id,name_Book,author_Book,year_Of_Public,category,price_Book,quantity_Book,image\n"
                        + "                        ,status_Book, category_Name as nameCate,description_Book\n"
                        + "                        from (\n"
                        + "                        \tselect *, ROW_NUMBER()over(Order by [book_Id]) as Rownum\n"
                        + "                        \tfrom Book b inner join Category c on b.category=c.category_Id where b.category=?\n"
                        + "                        )as BookData \n"
                        + "                        where BookData.Rownum between ? and ? ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, categoryId);
                stm.setInt(2, firstPage);
                stm.setInt(3, lastPage);
                rs = stm.executeQuery();
                listCategoryBook = new ArrayList<>();
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

    public boolean UpdateBook(String nameBook, String author, int yearOfPublic, int category, float price,
            int quantity, int bookId) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = true;
        int count = 0;
        boolean status = true;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "update [dbo].[Book] set name_Book=?,author_Book=?,year_Of_Public=?,category=?,price_Book=?,quantity_Book=? where book_Id=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, nameBook);
                stm.setString(2, author);
                stm.setInt(3, yearOfPublic);
                stm.setInt(4, category);
                stm.setFloat(5, price);
                stm.setInt(6, quantity);
                stm.setInt(7, bookId);
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
    public boolean createBook(String nameBook, String author, int yearOfPublic, int category, float price,
                              int quantity, String image, String description) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = true;
        int count = 0;
        boolean status = true;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "insert Book ([name_Book],[author_Book],[year_Of_Public],[category],[price_Book],[quantity_Book],\n"
                        + "[image],[description_Book],[status_Book])\n"
                        + "values(?,?,?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, nameBook);
                stm.setString(2, author);
                stm.setInt(3, yearOfPublic);
                stm.setInt(4, category);
                stm.setFloat(5, price);
                stm.setInt(6, quantity);
                stm.setString(7, image);
                stm.setString(8, description);
                stm.setBoolean(9, status);
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
    public List<BookDTO> getListMostInventoryBook()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<BookDTO> listMostInventoryBook = null;

        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "Select Top 1 WITH TIES name_Book, quantity_Book, year_Of_Public\n"
                        + "From Book \n"
                        + "Order By quantity_Book DESC";

                stm = con.prepareStatement(sql);
                listMostInventoryBook = new ArrayList<>();
                rs = stm.executeQuery();

                while (rs.next()) {
                    String name_Book = rs.getString("name_Book");
                    int quantity_Book = rs.getInt("quantity_Book");
                    int year_Of_Public = rs.getInt("year_Of_Public");
                    listMostInventoryBook.add(new BookDTO(name_Book, year_Of_Public, quantity_Book));
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
        return listMostInventoryBook;
    }
    public BookDTO getBookById(int bookId) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        BookDTO book = new BookDTO();
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String query = "SELECT * FROM Book WHERE book_Id =?";
                stm = con.prepareStatement(query);
                stm.setInt(1, bookId);
                rs = stm.executeQuery();
                while (rs.next()) {
                    book.setBook_Id(rs.getInt("book_Id"));
                    book.setName(rs.getString("name_Book"));
                    book.setAuthor(rs.getString("author_Book"));
                    book.setYear_Of_Public(rs.getInt("year_Of_Public"));
                    book.setCategory(rs.getInt("category"));
                    book.setPrice_Book(rs.getFloat("price_Book"));
                    book.setQuantity_Book(rs.getInt("quantity_Book"));
                    book.setImage_Book(rs.getString("image"));
                    book.setStatus(rs.getBoolean("status_Book"));
                    book.setCategoryName(rs.getString("nameCate"));
                    book.setDescriptionBook(rs.getString("description_Book"));
                }
            }
        } catch (SQLException e) {
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
        return book;
    }

}
