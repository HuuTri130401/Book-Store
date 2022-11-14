/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.se1611.servlets;

import com.se1611.bookingRequest.BookingRequestDAO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class AdminCreateBookingRequestServlet extends HttpServlet {

    private final String ADMIN_MANAGE_LIST_BOOK_REQUEST = "adminShowListBookingRequest";
    private final String ADMIN_CREATE_BOOK_REQUEST = "adminCreateBookRequestPage";
    HashMap<String,String> fieldUpload=new HashMap<>();
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
        request.setCharacterEncoding("utf-8");
        //GET SITEMAP
        Properties siteMap = (Properties) request.getServletContext().getAttribute("SITE_MAP");
        //getRequest Parameter
        String image = uploadFile(request,response);

        String name_Book = fieldUpload.get("txtBookName");
        int quantity_Request = Integer.parseInt(fieldUpload.get("txtQuantityBook"));
        float price_Request = Float.parseFloat(fieldUpload.get("txtPrice"));
//        Date date_Request = Date.valueOf(request.getParameter("txtDate"));
        LocalDate date_Request = LocalDate.now();
        String note =fieldUpload.get("txtNote");
        int status = Integer.parseInt(fieldUpload.get("radioStatus"));
        boolean status_Book_Request = Boolean.parseBoolean(fieldUpload.get("radioStatusBook"));

//        String confirmPassword = request.getParameter("txtConfirmPassword");

        String url = siteMap.getProperty(ADMIN_CREATE_BOOK_REQUEST);
        boolean errFound = true;

//        CreateEmployeeError employeeErrors = new CreateEmployeeError();
        try {
//            if (account_Id.trim().length() < 5 || account_Id.trim().length() > 30) {
//                errFound = false;
//                employeeErrors.setAccount_IdError("Account ID length has [5..30] chars");
//            }
//            if (password.trim().length() < 5 || password.trim().length() > 30) {
//                errFound = false;
//                employeeErrors.setPasswordError("Password length has [5..30] chars");
//            } else if (!confirmPassword.trim().equals(password.trim())) {
//                errFound = false;
//                employeeErrors.setConfirmPasswordError("Confirm Password does not match Password");
//            }
//            if (fullName.trim().length() < 2 || fullName.trim().length() > 30) {
//                errFound = false;
//                employeeErrors.setAccount_IdError("Full Name length has [2..30] chars");
//            }
//            int count = String.valueOf(phone).length();
//            if (count < 10 || count > 11) {
//                errFound = false;
//                employeeErrors.setPhoneError("Phone length has [10 or 11] chars");
//            }
//            if (address.trim().length() < 2 || address.trim().length() > 20) {
//                errFound = false;
//                employeeErrors.setAddressError("Address length has [2..20] chars");
//            }
//            if (gender.trim().length() < 1 || gender.trim().length() > 7) {
//                errFound = false;
//                employeeErrors.setGenderError("Gender length has [1..7] chars");
//            }
//            if (role.trim().length() < 2 || role.trim().length() > 7) {
//                errFound = false;
//                employeeErrors.setRoleError("Role length has [2..7] chars");
//            }
            if (errFound) {
                BookingRequestDAO bookRequestDAO = new BookingRequestDAO();
                
                boolean createBookRequest = bookRequestDAO.addNewBookingRequest(image, name_Book, quantity_Request, price_Request, date_Request, note, status, status_Book_Request);
                if (createBookRequest) {
                    url = ADMIN_MANAGE_LIST_BOOK_REQUEST;
                    RequestDispatcher rd = request.getRequestDispatcher(url);
                    rd.forward(request, response);
                }
            } else {
                url = ADMIN_CREATE_BOOK_REQUEST;
                //bookError.setMessageError("Can not Create New Book !");
                request.setAttribute("BOOK_REQUEST_ERROR", "Can not Create New Book Request!");
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            }
        } catch (SQLException e) {
            log("AccountCreateNewBookRequest Servlet _ SQLException_ " + e.getMessage());
        } catch (NamingException e) {
            log("AccountCreateNewBookRequest Servlet _ NamingException_ " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            log("AccountCreateNewBookRequest Servlet _ ClassNotFoundException_ " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }
    private String uploadFile(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Verify the content type
        String filePath = getServletContext().getInitParameter("file-upload");
        // Location save Image
        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        fileItemFactory.setRepository(new File(filePath));
        ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
        String nameimg = "";
        try {
            List<FileItem> fileItems = upload.parseRequest(request);
            for (FileItem fileItem : fileItems) {

                if (!fileItem.isFormField()) {
                    // xử lý file
                    nameimg = fileItem.getName();
                    if (!nameimg.equals("")) {
                        String dirUrl = filePath;
                        File dir = new File(dirUrl);
                        if (!dir.exists()) {
                            dir.mkdir();
                        }
                        String fileImg = dirUrl + File.separator + nameimg;
                        File file = new File(fileImg);
                        try {
                            fileItem.write(file);
                            System.out.println("UPLOAD THÀNH CÔNG...!");
                        } catch (Exception e) {
                            System.out.println("CÓ LỖI TRONG QUÁ TRÌNH UPLOAD!");
                            e.printStackTrace();
                        }
                    }
                }else{

                    //Save cac filed name book, quantity, author.....
                    fieldUpload.put(fileItem.getFieldName(),fileItem.getString());
                } //end If

            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        return nameimg;
    }
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
