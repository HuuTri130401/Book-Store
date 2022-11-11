package com.se1611.servlets;

import com.se1611.inventory.InventoryDAO;
import com.se1611.inventory.InventoryDTO;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InventoryServlet extends HttpServlet {
    private final String INVALID_PAGE = "invalidPage";
    private final String INVENTORY_PAGE="staffInventoryPage";
    private final String INVENTORY_HISTORY_PAGE="staffInventoryHistoryPage";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws NamingException,
            ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String url = INVALID_PAGE;
        //Declace Session
        HttpSession session = request.getSession();
        //Get Action
        String action = request.getParameter("action");
        //
        List<InventoryDTO> listInventory = new ArrayList<>();
        InventoryDAO dao = new InventoryDAO();
        //Declace inventory Id
        int inventory_detail_id;
        try {
            switch (action) {
                case "getInventory":
                    listInventory = dao.GetInventory();
                    session.setAttribute("listInventory", listInventory);
                    url = INVENTORY_PAGE;
                    break;
                case "insertInventory":
                    //Get List Inventory
                    listInventory = dao.GetInventory();
                    //Get Data Prepare insert Inventory SQL
                    int book_id_Inventory = Integer.parseInt(request.getParameter("book_Id_Inventory"));
                    int quantity_Inventory = Integer.parseInt(request.getParameter("quantity"));
                    String note = request.getParameter("note");
                    int employee_Inventory = (Integer) session.getAttribute("employee_Id");
                    int id_Inventory = (listInventory.get(listInventory.size() - 1).getInventory_Id()) + 1;
                    long millis = System.currentTimeMillis();
                    Date date_Inventory = new Date(millis);
                    //Insert Inventory
                    if (dao.InsertInventory(employee_Inventory, date_Inventory)) {
                        //Insert Inventory Detail
                        if (dao.InsertInventoryDetail(id_Inventory, book_id_Inventory, quantity_Inventory, note)) {
                            listInventory = dao.GetInventory();
                            session.setAttribute("listInventory", listInventory);
                            url = INVENTORY_PAGE;
                        }
                    }
                    break;
                case "deleteInventory":
                    inventory_detail_id = Integer.parseInt(request.getParameter("inventory_Detail_Id"));
                    int count =Integer.parseInt(request.getParameter("count"));
                    String nameBook= request.getParameter("nameBook");
                    if(dao.DeleteInventory(inventory_detail_id,false)){
                        listInventory = dao.GetInventory();
                        session.setAttribute("listInventory", listInventory);
                        request.setAttribute("nameBook",nameBook);
                        request.setAttribute("count",count);
                        url = INVENTORY_PAGE;
                    }
                    break;
                case "returnInventoryDelete":
                    inventory_detail_id = Integer.parseInt(request.getParameter("inventory_Detail_Id"));
                    count =Integer.parseInt(request.getParameter("count"));
                    nameBook= request.getParameter("nameBook");
                    if(dao.DeleteInventory(inventory_detail_id,true)){
                        listInventory = dao.GetInventory();
                        session.setAttribute("listInventory", listInventory);
                        request.setAttribute("nameBook",nameBook);
                        request.setAttribute("count",count);
                        url = INVENTORY_HISTORY_PAGE;
                    }
                    break;

                case "historyInventory":
                    listInventory = dao.GetInventory();
                    session.setAttribute("listInventory", listInventory);
                    url = INVENTORY_HISTORY_PAGE;
                    break;
                case"searchInventory":
                    String search=request.getParameter("search");
                    //Search
                    listInventory=dao.SearchInventory(search);
                    session.setAttribute("listInventory", listInventory);
                    request.setAttribute("search",search);
                    url = INVENTORY_PAGE;
                    break;
                case"searchInventoryHistory":
                   search=request.getParameter("search");
                    //Search
                    listInventory=dao.SearchInventory(search);
                    session.setAttribute("listInventory", listInventory);
                    request.setAttribute("search",search);
                    url = INVENTORY_PAGE;
                    break;
            }
        } catch (SQLException e) {
            log("BookServlet_SQL_" + e.getMessage());
        } finally {
            // request url;
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(AdminBookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(AdminBookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
