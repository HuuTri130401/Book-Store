package com.se1611.servlets;

import com.se1611.Importation.ImportationDAO;
import com.se1611.Importation.ImportationDTO;
import com.se1611.bookingRequest.RequestDAO;
import com.se1611.bookingRequest.RequestDTO;

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

public class StaffImportationServlet extends HttpServlet {
    private final String INVALID_PAGE = "invalidPage";
    private final String IMPORTATION_PAGE = "staffImportationPage";
    private final String REQUEST_PAGE = "staffRequestPage";
    private final String REQUEST_HISTORY_PAGE = "staffRequestHistoryPage";
    private final String IMPORTATION_HISTORY_PAGE = "staffImportationHistoryPage";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws NamingException,
            ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String url = INVALID_PAGE;
        //Declace Session
        HttpSession session = request.getSession();
        //Get Action
        String action = request.getParameter("action");
        //List Importation
        List<ImportationDTO> listImportation = new ArrayList<>();
        //List Request
        List<RequestDTO> listRequest = new ArrayList<>();
        //DAO
        ImportationDAO daoImportation = new ImportationDAO();
        RequestDAO daoRequest = new RequestDAO();
        //Declace request ID
        int request_Id;
        //Declace import ID
        int importation_detail_id;
        try {
            switch (action) {

                case "getRequest":
                    listRequest = daoRequest.getRequest();
                    session.setAttribute("listRequest", listRequest);
                    url = REQUEST_PAGE;
                    break;
                case "getImportation":
                    //Get List Inventory
                    listImportation = daoImportation.getImportation();
                    session.setAttribute("listImportation", listImportation);
                    url = IMPORTATION_PAGE;
                    break;
                case"updateStatusRequestUnDone":
                    request_Id = Integer.parseInt(request.getParameter("request_Id"));
                    //Update Status Request
                    if (daoRequest.UpdateStatusRequest(request_Id, false)) {
                        listRequest = daoRequest.getRequest();
                        session.setAttribute("listRequest", listRequest);
                        url = REQUEST_PAGE;
                    }
                    break;
                case "insertImportation":
                    //get List Importation
                    listImportation = daoImportation.getImportation();
                    //Get Data Prepare insert Inventory SQL
                    int book_id_Importation = Integer.parseInt(request.getParameter("book_Id_Importation"));
                    request_Id = Integer.parseInt(request.getParameter("request_Id"));
                    int quantity_Importation = Integer.parseInt(request.getParameter("quantityImportation"));
                    float price_Importation = Float.parseFloat(request.getParameter("priceImportation"));
                    float total_Importation = quantity_Importation * price_Importation;
                    //Get Note Importation
                    String note = request.getParameter("note");
                    String noteOther = request.getParameter("noteOther");
                    String noteImportation = note + " " + noteOther;
                    //Get Employee Id
                    int employee_Importation = (Integer) session.getAttribute("employee_Id");
                    int id_Importation = (listImportation.get(listImportation.size() - 1).getImport_Id()) + 1;
                    long millis = System.currentTimeMillis();
                    Date date_Importation = new Date(millis);
                    //Get Date Request
                    Date date_Request = new Date(millis);
                    //Insert Importation
                    if (daoImportation.InsertImportation(employee_Importation, date_Importation, request_Id)) {
                        //Insert Importation Detail
                        if (daoImportation.InsertImportationDetail(id_Importation, quantity_Importation, price_Importation,
                                total_Importation, noteImportation, book_id_Importation)) {
                            //Update Status Request
                            if (daoRequest.UpdateStatusRequest(request_Id, true)) {
                                daoRequest.UpdateDateRequestDone(request_Id, date_Request);
                                listImportation = daoImportation.getImportation();
                                session.setAttribute("listImportation", listImportation);
                                url = IMPORTATION_PAGE;
                            }
                        }
                    }
                    break;
                case "deleteImportation":
                    importation_detail_id = Integer.parseInt(request.getParameter("import_Detail_Id"));
                    int count = Integer.parseInt(request.getParameter("count"));
                    String nameBook = request.getParameter("nameBook");
                    if (daoImportation.DeleteImportation(importation_detail_id, false)) {
                        listImportation = daoImportation.getImportation();
                        session.setAttribute("listImportation", listImportation);
                        request.setAttribute("nameBook", nameBook);
                        request.setAttribute("count", count);
                        url = IMPORTATION_PAGE;
                    }
                    break;
                case "deleteRequest":
                    int request_Idx = Integer.parseInt(request.getParameter("request_Id"));
                    count = Integer.parseInt(request.getParameter("count"));
                    nameBook = request.getParameter("nameBook");
                    System.out.println(nameBook.trim());
                    if (daoRequest.DeleteRequest(request_Idx)) {
                        listRequest = daoRequest.getRequest();
                        session.setAttribute("listRequest", listRequest);
                        request.setAttribute("nameBook", nameBook);
                        request.setAttribute("count", count);
                        url = REQUEST_PAGE;
                    }
                    break;
                case "historyRequest":
                    listRequest = daoRequest.getRequest();
                    session.setAttribute("listRequest", listRequest);
                    url = REQUEST_HISTORY_PAGE;
                    break;
                case "historyImportation":
                    //Get List Inventory
                    listImportation = daoImportation.getImportation();
                    session.setAttribute("listImportation", listImportation);
                    url = IMPORTATION_HISTORY_PAGE;
                    break;
                case "returnRequestDelete":
                    request_Id = Integer.parseInt(request.getParameter("request_Id"));
                    count = Integer.parseInt(request.getParameter("count"));
                    nameBook = request.getParameter("nameBook");
                    //Update Status Request
                    if (daoRequest.UpdateStatusRequest(request_Id, true)) {
                        listRequest = daoRequest.getRequest();
                        session.setAttribute("listRequest", listRequest);
                        request.setAttribute("nameBook", nameBook);
                        request.setAttribute("count", count);
                        url = REQUEST_HISTORY_PAGE;
                    }
                    break;
                case "returnImportationDelete":
                    importation_detail_id = Integer.parseInt(request.getParameter("import_Detail_Id"));
                    count = Integer.parseInt(request.getParameter("count"));
                    nameBook = request.getParameter("nameBook");
                    if (daoImportation.DeleteImportation(importation_detail_id, true)) {
                        listImportation = daoImportation.getImportation();
                        session.setAttribute("listImportation", listImportation);
                        request.setAttribute("nameBook", nameBook);
                        request.setAttribute("count", count);
                        url = IMPORTATION_HISTORY_PAGE;
                    }
                    break;
                case "searchRequest":
                    String search = request.getParameter("search");
                    //Search
                    listRequest = daoRequest.SearchRequest(search);
                    session.setAttribute("listRequest", listRequest);
                    request.setAttribute("search", search);
                    url = REQUEST_PAGE;
                    break;
                case "searchRequestHistory":
                    search = request.getParameter("search");
                    //Search
                    listRequest = daoRequest.SearchRequest(search);
                    session.setAttribute("listRequest", listRequest);
                    request.setAttribute("search", search);
                    url = REQUEST_HISTORY_PAGE;
                    break;
                case "searchImportation":
                    search = request.getParameter("search");
                    //Search
                    listImportation = daoImportation.SearchImportation(search);
                    session.setAttribute("listImportation", listImportation);
                    request.setAttribute("search", search);
                    url = IMPORTATION_PAGE;
                    break;
                case "searchImportationHistory":
                    search = request.getParameter("search");
                    //Search
                    listImportation = daoImportation.SearchImportation(search);
                    session.setAttribute("listImportation", listImportation);
                    request.setAttribute("search", search);
                    url = IMPORTATION_HISTORY_PAGE;
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
