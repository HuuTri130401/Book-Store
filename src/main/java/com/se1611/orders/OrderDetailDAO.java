package com.se1611.orders;
import com.se1611.utils.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

public class OrderDetailDAO {
    private Connection con = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;

    private void closeConnection() throws SQLException {
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

    public boolean createOrder(OrderDetailDTO orderDetailDTO) throws SQLException, ClassNotFoundException, NamingException {
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String query = "INSERT INTO OrderDetail (order_Id, book_Id, quantity_Order_Detail, total_Order_Detail)"
                        + "VALUES (?,?,?,?)";
                stm = con.prepareStatement(query);
                stm.setInt(1, orderDetailDTO.getOrder_Id());
                stm.setInt(2, orderDetailDTO.getBook_Id());
                stm.setInt(3, orderDetailDTO.getQuantity_Order_Detail());
                stm.setFloat(4, orderDetailDTO.getTotal_Order_Detail());
                stm.executeUpdate();
                return true;
            }
        } finally {
            closeConnection();
        }
        return false;
    }

    public List<OrderDetailDTO> GetInforOrderDetail(int first, int last) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<OrderDetailDTO> listOrder = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "select image, name_Book, quantity_Order_Detail,price_Book,\n" +
                        "                        total_Order_Detail,category,bookId,order_Detail_Id,order_Id\n" +
                        "                        from (select image, name_Book, quantity_Order_Detail,price_Book,\n" +
                        "                        total_Order_Detail,category,b.book_Id as bookId,order_Detail_Id,order_Id, ROW_NUMBER()over(Order by [order_Detail_Id]) as Rownum\n" +
                        "                    from  [dbo].[OrderDetail] d  inner join Book b on d.book_Id=b.book_Id ) as BookData\n" +
                        "\t\t\t\t\twhere BookData.Rownum between ? and ? ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, first);
                stm.setInt(2, last);
                rs = stm.executeQuery();
                listOrder = new ArrayList<>();
                while (rs.next()) {
                    OrderDetailDTO list=new OrderDetailDTO();
                    list.setOrder_Detail_Id(rs.getInt("order_Detail_Id"));
                    list.setQuantity_Order_Detail(rs.getInt("quantity_Order_Detail"));
                    list.setTotal_Order_Detail(rs.getFloat("total_Order_Detail"));
                    list.setImage_Order(rs.getString("image"));
                    list.setName_Book_Order(rs.getString("name_Book"));
                    list.setCategory_Id(rs.getInt("category"));
                    list.setBook_Id(rs.getInt("bookId"));
                    list.setOrder_Id(rs.getInt("order_Id"));
                    listOrder.add(list);
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
        return listOrder;
    }
//Search
public List<OrderDetailDTO> SearchInforOrderDetail(String search) throws SQLException, NamingException {
    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;
    List<OrderDetailDTO> listOrder = null;
    try {
        con = DBHelper.getConnection();
        if (con != null) {
            String sql = "select image, name_Book, quantity_Order_Detail,price_Book,\n" +
                    "total_Order_Detail,category,b.book_Id as bookId,order_Detail_Id,order_Id\n" +
                    "from [dbo].[OrderDetail] d  inner join Book b \n" +
                    "on d.book_Id=b.book_Id where name_Book like ? ";
            stm = con.prepareStatement(sql);
            stm.setString(1,"%"+search+"%");
            rs = stm.executeQuery();
            listOrder = new ArrayList<>();
            while (rs.next()) {
                OrderDetailDTO list=new OrderDetailDTO();
                list.setOrder_Detail_Id(rs.getInt("order_Detail_Id"));
                list.setQuantity_Order_Detail(rs.getInt("quantity_Order_Detail"));
                list.setTotal_Order_Detail(rs.getFloat("total_Order_Detail"));
                list.setImage_Order(rs.getString("image"));
                list.setName_Book_Order(rs.getString("name_Book"));
                list.setCategory_Id(rs.getInt("category"));
                list.setBook_Id(rs.getInt("bookId"));
                list.setOrder_Id(rs.getInt("order_Id"));
                listOrder.add(list);
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
    return listOrder;
}
    public boolean updateStatus(int orderId, boolean check) throws SQLException, NamingException {
        String query = "UPDATE [dbo].[Order] SET status=? WHERE order_Id=?";
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                stm = con.prepareStatement(query);
                if(check){
                    stm.setBoolean(1, true);
                }else {
                    stm.setBoolean(1, false);
                }
                stm.setInt(2, orderId);
                int result = stm.executeUpdate();
                if (result > 0) {
                    return true;
                }
            }
        } finally {
            closeConnection();
        }
        return false;
    }
}
