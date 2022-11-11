/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.se1611.servlets;

import com.se1611.employees.EmployeeDAO;
import com.se1611.employees.EmployeeDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class AdminManageListEmployeesServlet extends HttpServlet {

    private final String RESULT = "adminManageListEmployeesPage";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITE_MAP");
        String url = (String) siteMap.get(RESULT);
        try {
            String searchValue = request.getParameter("txtSearch");
            EmployeeDAO employeeDAO = new EmployeeDAO();
            List<EmployeeDTO> listEmployees = employeeDAO.getListEmployee();
            if (!listEmployees.isEmpty()) {
                request.setAttribute("LIST_EMPLOYEES", listEmployees);
            } 
            if (searchValue != null && searchValue.trim().length() > 0) {
                listEmployees = employeeDAO.searchEmployeesByName(searchValue);
                request.setAttribute("LIST_EMPLOYEES", listEmployees);
            }
        } catch (SQLException e) {
            log("AdminManageListEmployeesServlet_SQL_ " + e.getMessage());
        } catch (NamingException e) {
            log("AdminManageListEmployeesServlet_NamingExceptionNamingException " + e.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }

//    public static void main(String[] args) 
//            throws NamingException, SQLException {
//        EmployeeDAO employeeDAO = new EmployeeDAO();
//            List<EmployeeDTO> listEmployees = employeeDAO.getListEmployee();
//            if (!listEmployees.isEmpty()) {
//                System.out.println(listEmployees);
//            }
//    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
