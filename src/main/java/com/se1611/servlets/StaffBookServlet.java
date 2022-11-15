/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.se1611.servlets;

import com.se1611.book.BookDAO;
import com.se1611.book.BookDTO;
import com.se1611.bookingRequest.RequestDAO;
import com.se1611.bookingRequest.RequestDTO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tuan vu
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)
public class StaffBookServlet extends HttpServlet {

    private final String INVALID_PAGE = "invalidPage";
    private final String STAFF_BOOK_PAGE = "staffBookPage";
    private final String STAFF_BOOK_DELETED_PAGE = " staffBookDeletedPage";

    private final String STAFF_BOOK_DETAIL_PAGE = "staffBookDetailPage";
    private final String STAFF_BOOK_DETAIL_DELETED_PAGE = "staffBookDetailDeletedPage";
    private final String STAFF_BOOK_CATEGOTY_PAGE = "staffBookCategoryPage";
    //Declare Hashmap save information When create Book
    HashMap<String, String> fieldUpload = new HashMap<>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String url = INVALID_PAGE;
        // /lấy Acction Để đưa vào switch vô case chuyển page
        String action = request.getParameter("action");
        // Session
        HttpSession session = request.getSession();
        // Create list save book
        List<BookDTO> listBook = new ArrayList<>();
        BookDAO daoBook = new BookDAO();
        //GEt List Request
        List<RequestDTO> listRequest = new ArrayList<>();
        RequestDAO daoRequest = new RequestDAO();

        // số book cần lấy, 1 page gồm 4 book
        int first = 1;
        int last = 100;
        int categoryId=1;

        //Get List Request
        listRequest = daoRequest.getRequest();

        //Lấy all Book in List
        listBook=daoBook.getInformationBook(first,last);
        request.setAttribute("numLastBook",listBook.size());
        try {
            callCaseBookPage1:
            while (true) {
                switch (action) {


                    //Search Book
                    case "searchBook":
                        String search=request.getParameter("search");
                        //Search
                        listBook=daoBook.SearchBook(1,4,search);
                        session.setAttribute("listBook", listBook);
                        request.setAttribute("search",search);
                        url = STAFF_BOOK_PAGE;
                        break;
                    //Create Book
                    case "createBook":
                        // Upload Book
                        String image =request.getParameter("imageUpload");
                        int requestId=Integer.parseInt(request.getParameter("request_Id"));

                        //Get Parameter Book
                        String nameBook =request.getParameter("nameBook");
                        System.out.println(nameBook);
                        String author = request.getParameter("author");
                        int quantity = Integer.parseInt(request.getParameter("quantity"));
                        Float price = Float.parseFloat(request.getParameter("price"));
                        int category = Integer.parseInt(request.getParameter("category"));
                        int publicOfYear = Integer.parseInt(request.getParameter("publicOfYear"));
                        String description = request.getParameter("description");

                        //Create Book
                        if (daoBook.createBook(nameBook, author, publicOfYear, category, price, quantity, image, description)) {
                            if (daoRequest.UpdateStatusNewOld(requestId)) {
                                action = "bookPage1";
                                continue callCaseBookPage1;
                            }
                        }
                        break;

                    //Update Book
                    case "updateBook":
                        // Upload Book
                        int bookId = Integer.parseInt(request.getParameter("bookId"));
                        int update = Integer.parseInt(request.getParameter("update"));

                        //Get Parameter Book
                        nameBook = request.getParameter("bookName");
                        author = request.getParameter("author");
                        quantity = Integer.parseInt(request.getParameter("quantity"));
                        price = Float.parseFloat(request.getParameter("price"));
                        category = Integer.parseInt(request.getParameter("categoryId"));
                        publicOfYear = Integer.parseInt(request.getParameter("publicOfYear"));

                        //Update Book
                        if (daoBook.UpdateBook(nameBook, author, publicOfYear, category, price, quantity, bookId)) {
                            action = "bookDetail";
                            request.setAttribute("nameBook", nameBook);
                            request.setAttribute("update", update);
                            listBook = daoBook.getInformationBook(first, last);
                            continue callCaseBookPage1;
                        }
                        //Delete Book
                    case "deleteBook":
                        bookId = Integer.parseInt(request.getParameter("bookId"));
                        int counLoop = Integer.parseInt(request.getParameter("count"));
                        nameBook = request.getParameter("bookName");
                        if (daoBook.StatusBook(bookId, false)) {
                            action = "bookPage1";
                            request.setAttribute("nameBook", nameBook);
                            request.setAttribute("count", counLoop);
                            continue callCaseBookPage1;
                        }
                    case "bookPage1":
                        first = 1;
                        last = 4;
                        listBook = daoBook.getInformationBook(first, last);
                        session.setAttribute("listBook", listBook);
                        url = STAFF_BOOK_PAGE;
                        break;
                    case "bookPage2":
                        first = 5;
                        last = 8;
                        listBook = daoBook.getInformationBook(first, last);
                        session.setAttribute("listBook", listBook);
                        url = STAFF_BOOK_PAGE;
                        break;
                    case "bookPage3":
                        first = 9;
                        last = 12;
                        listBook = daoBook.getInformationBook(first, last);
                        session.setAttribute("listBook", listBook);
                        url = STAFF_BOOK_PAGE;
                        break;
                    case "bookPage4":
                        first = 13;
                        last = 16;
                        listBook = daoBook.getInformationBook(first, last);
                        session.setAttribute("listBook", listBook);
                        url = STAFF_BOOK_PAGE;
                        break;
                    case "bookPage5":
                        first = 17;
                        last = 20;
                        listBook = daoBook.getInformationBook(first, last);
                        session.setAttribute("listBook", listBook);
                        url = STAFF_BOOK_PAGE;
                        break;
                    case "bookPage6":
                        first = 21;
                        last = 24;
                        listBook = daoBook.getInformationBook(first, last);
                        session.setAttribute("listBook", listBook);
                        url = STAFF_BOOK_PAGE;
                        break;

                    // Page Category Book
                    case "Romance":
                        //Get all list category book, get quantity category
                        categoryId=1;
                        listBook = daoBook.getCategoryBook(categoryId,first,last);
                        session.setAttribute("numLastCategory",listBook.size());
                        //get 1-4 list book category
                        first = 1;
                        last=4;
                        listBook = daoBook.getCategoryBook(categoryId,first,last);
                        session.setAttribute("listCategoryBook", listBook);
                        request.setAttribute("nameCategory", listBook.get(0).getCategoryName());
                        url = STAFF_BOOK_CATEGOTY_PAGE;
                        break;
                    case "Romance2":
                        categoryId=1;
                        first = 5;
                        last=8;
                        listBook = daoBook.getCategoryBook(categoryId,first,last);
                        session.setAttribute("listCategoryBook", listBook);
                        request.setAttribute("nameCategory", listBook.get(0).getCategoryName());
                        url = STAFF_BOOK_CATEGOTY_PAGE;
                        break;
                    case "Romance3":
                        categoryId=1;
                        first = 9;
                        last=12;
                        listBook = daoBook.getCategoryBook(categoryId,first,last);
                        session.setAttribute("listCategoryBook", listBook);
                        request.setAttribute("nameCategory", listBook.get(0).getCategoryName());
                        url = STAFF_BOOK_CATEGOTY_PAGE;
                        break;
                    case "Self-help":
                        //Get all list category book, get quantity category
                        categoryId=2;
                        listBook = daoBook.getCategoryBook(categoryId,first,last);
                        session.setAttribute("numLastCategory",listBook.size());
                        //get 1-4 list book category
                        first = 1;
                        last=4;
                        listBook = daoBook.getCategoryBook(categoryId,first,last);
                        session.setAttribute("listCategoryBook", listBook);
                        request.setAttribute("nameCategory", listBook.get(0).getCategoryName());
                        url = STAFF_BOOK_CATEGOTY_PAGE;
                        break;
                    case "Self-help2":
                        categoryId=2;
                        first = 5;
                        last=8;
                        listBook = daoBook.getCategoryBook(categoryId,first,last);
                        session.setAttribute("listCategoryBook", listBook);
                        request.setAttribute("nameCategory", listBook.get(0).getCategoryName());
                        url = STAFF_BOOK_CATEGOTY_PAGE;
                        break;
                    case "Self-help3":
                        categoryId=2;
                        first = 9;
                        last=12;
                        listBook = daoBook.getCategoryBook(categoryId,first,last);
                        session.setAttribute("listCategoryBook", listBook);
                        request.setAttribute("nameCategory", listBook.get(0).getCategoryName());
                        url = STAFF_BOOK_CATEGOTY_PAGE;
                        break;
                    case "Novel":
                        //Get all list category book, get quantity category
                        categoryId=3;
                        listBook = daoBook.getCategoryBook(categoryId,first,last);
                        session.setAttribute("numLastCategory",listBook.size());
                        //get 1-4 list book category
                        first = 1;
                        last=4;
                        listBook = daoBook.getCategoryBook(categoryId,first,last);
                        session.setAttribute("listCategoryBook", listBook);
                        request.setAttribute("nameCategory", listBook.get(0).getCategoryName());
                        url = STAFF_BOOK_CATEGOTY_PAGE;
                        break;
                    case "Novel2":
                        categoryId=3;
                        first = 5;
                        last=8;
                        listBook = daoBook.getCategoryBook(categoryId,first,last);
                        session.setAttribute("listCategoryBook", listBook);
                        request.setAttribute("nameCategory", listBook.get(0).getCategoryName());
                        url = STAFF_BOOK_CATEGOTY_PAGE;
                        break;
                    case "Novel3":
                        categoryId=3;
                        first = 9;
                        last=12;
                        listBook = daoBook.getCategoryBook(categoryId,first,last);
                        session.setAttribute("listCategoryBook", listBook);
                        request.setAttribute("nameCategory", listBook.get(0).getCategoryName());
                        url = STAFF_BOOK_CATEGOTY_PAGE;
                        break;
                    case "Fantasy":
                        //Get all list category book, get quantity category
                        categoryId=4;
                        listBook = daoBook.getCategoryBook(categoryId,first,last);
                        session.setAttribute("numLastCategory",listBook.size());
                        //get 1-4 list book category
                        first = 1;
                        last=4;
                        listBook = daoBook.getCategoryBook(categoryId,first,last);
                        session.setAttribute("listCategoryBook", listBook);
                        request.setAttribute("nameCategory", listBook.get(0).getCategoryName());
                        url = STAFF_BOOK_CATEGOTY_PAGE;
                        break;
                    case "Fantasy2":
                        categoryId=4;
                        first = 5;
                        last=8;
                        listBook = daoBook.getCategoryBook(categoryId,first,last);
                        session.setAttribute("listCategoryBook", listBook);
                        request.setAttribute("nameCategory", listBook.get(0).getCategoryName());
                        url = STAFF_BOOK_CATEGOTY_PAGE;
                        break;
                    case "Fantasy3":
                        categoryId=4;
                        first = 9;
                        last=12;
                        listBook = daoBook.getCategoryBook(categoryId, first, last);
                        session.setAttribute("listCategoryBook", listBook);
                        request.setAttribute("nameCategory", listBook.get(0).getCategoryName());
                        url = STAFF_BOOK_CATEGOTY_PAGE;
                        break;
                    // Page Detail Book khi click vào từng book
                    case "bookDetail":

                        //Check Status Book to display button
                        String nameBookDetail = request.getParameter("bookName");
                        checkStatusBook(nameBookDetail, listRequest, request);
                        bookId = GetBookId(nameBookDetail,listBook);
                        //If book Deleted
                        if(bookId==0){
                            listBook=daoBook.getInformationBookDeleted(first,last);
                            bookId= GetBookId(nameBookDetail,listBook);
                            url=STAFF_BOOK_DETAIL_DELETED_PAGE;
                        }else {
                            url = STAFF_BOOK_DETAIL_PAGE;
                        }
                        //set Attribute List Book
                        session.setAttribute("listBook", listBook);
                        categoryId = Integer.parseInt(request.getParameter("categoryId"));
                        listBook = daoBook.getCategoryBook(categoryId, first, last);
                        request.setAttribute("categoryId", categoryId);
                        request.setAttribute("bookIdServlet", bookId);
                        request.setAttribute("nameCategory", listBook.get(0).getCategoryName());
                        break;
                    case "bookDetailRequest":
                        //Get Name Book
                        String nameBookRequest = request.getParameter("bookNameRequest");
                        checkStatusBook(nameBookRequest, listRequest, request);
                        //Get IdBook In List Book
                        int quantityRequset=Integer.parseInt(request.getParameter("qtyRequest"));
                        float priceRequset=Float.parseFloat(request.getParameter("priceRequest"));
                        int bookIdRequest = GetBookId(nameBookRequest,listBook);
                        //If book Deleted
                        if(bookIdRequest==0){
                            listBook=daoBook.getInformationBookDeleted(first,last);
                            bookIdRequest= GetBookId(nameBookRequest,listBook);
                            url=STAFF_BOOK_DETAIL_DELETED_PAGE;
                        }else {
                            url = STAFF_BOOK_DETAIL_PAGE;
                        }
                        //Get Category
                        int categoryIdRequest=GetCatrgoryId(nameBookRequest,listBook);
                        //set Attribute List Book
                        session.setAttribute("listBook", listBook);
                        listBook = daoBook.getCategoryBook(categoryIdRequest, first, last);
                        request.setAttribute("quantityRequset", quantityRequset);
                        request.setAttribute("priceRequset", priceRequset);
                        request.setAttribute("bookIdServlet", bookIdRequest);
                        request.setAttribute("nameCategory", listBook.get(0).getCategoryName());
                        break;

                }
                break callCaseBookPage1;
            }
        } catch (SQLException e) {
            log("BookServlet_SQL_" + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
            // response.sendRedirect(url);
        }
    }
    //Get CategoryID
    private int GetCatrgoryId(String nameBookRequest, List<BookDTO> listBook) {
        int categoryId = 0;
        for (int i = 0; i < listBook.size(); i++) {
            if (nameBookRequest.trim().compareTo(listBook.get(i).getName().trim()) == 0) {
                categoryId = listBook.get(i).getCategory();
            }
        }
        return categoryId;
    }

    //Get BookID
    private int GetBookId(String nameBookRequest, List<BookDTO> listBook) {
        int bookId = 0;
        for (int i = 0; i < listBook.size(); i++) {
            if (nameBookRequest.trim().compareTo(listBook.get(i).getName().trim()) == 0) {
                bookId = listBook.get(i).getBook_Id();
            }
        }
        return bookId;
    }

    //Upload Image Book
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

    //Check lấy bookid trong list Request
    private void checkStatusBook(String bookName, List<RequestDTO> listRequest, HttpServletRequest request) {
        for (int i = 0; i < listRequest.size(); i++) {
            if (bookName.trim().compareTo(listRequest.get(i).getRequest_Name_Book().trim()) == 0) {
                //Get Request Id
                request.setAttribute("request_Id",listRequest.get(i).getRequest_Id());
                //Get Requet Status
                request.setAttribute("request_status", listRequest.get(i).getRequest_Status());
            }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(StaffBookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(StaffBookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
