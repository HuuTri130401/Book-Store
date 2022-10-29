package com.se1611.servlets;

import com.se1611.inventory.InventoryDAO;
import com.se1611.inventory.InventoryDTO;

import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InventoryServlet extends HttpServlet {
    private final String INVALID_PAGE = "invalidPage";
    private final String INVENTORY_PAGE="staffInventoryPage";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws NamingException,
            ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = INVALID_PAGE;
        //Declace Session
        HttpSession session = request.getSession();
        //
        List<InventoryDTO> listInventory= new ArrayList<>();
        InventoryDAO dao= new InventoryDAO();
        try{
            listInventory=dao.GetInventory();
            session.setAttribute("listInventory",listInventory);
            url=INVENTORY_PAGE;
        }catch(SQLException e) {
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
        } catch (NamingException ex) {
            Logger.getLogger(AdminBookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(AdminBookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
