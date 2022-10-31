package com.se1611.Importation;

import java.sql.Date;

public class ImportationDTO {
    public int import_Id;
    public int import_Detail_Id;
    public int import_Request_Id;
    public int import_Quantity_Request;
    public String import_image;
    public String import_Name_Book;
    public String import_Note;
    public float import_Detail_Price_Book;
    public float import_Detail_Total;
    public Date import_Date;
    public boolean import_Status;
    public int import_Book_Id;
    public int import_Category_Id;
    public String import_Employee;
    public ImportationDTO() {
    }

    public ImportationDTO(int import_Id, int import_Detail_Id, int import_Request_Id, int import_Quantity_Request,
                          String import_image, String import_Name_Book, String import_Note, float import_Detail_Price_Book,
                          float import_Detail_Total, Date import_Date, boolean import_Status) {
        this.import_Id = import_Id;
        this.import_Detail_Id = import_Detail_Id;
        this.import_Request_Id = import_Request_Id;
        this.import_Quantity_Request = import_Quantity_Request;
        this.import_image = import_image;
        this.import_Name_Book = import_Name_Book;
        this.import_Note = import_Note;
        this.import_Detail_Price_Book = import_Detail_Price_Book;
        this.import_Detail_Total = import_Detail_Total;
        this.import_Date = import_Date;
        this.import_Status = import_Status;
    }

    public int getImport_Id() {
        return import_Id;
    }

    public void setImport_Id(int import_Id) {
        this.import_Id = import_Id;
    }

    public int getImport_Detail_Id() {
        return import_Detail_Id;
    }

    public void setImport_Detail_Id(int import_Detail_Id) {
        this.import_Detail_Id = import_Detail_Id;
    }

    public int getImport_Request_Id() {
        return import_Request_Id;
    }

    public void setImport_Request_Id(int import_Request_Id) {
        this.import_Request_Id = import_Request_Id;
    }

    public int getImport_Quantity_Request() {
        return import_Quantity_Request;
    }

    public void setImport_Quantity_Request(int import_Quantity_Request) {
        this.import_Quantity_Request = import_Quantity_Request;
    }

    public String getImport_image() {
        return import_image;
    }

    public void setImport_image(String import_image) {
        this.import_image = import_image;
    }

    public String getImport_Name_Book() {
        return import_Name_Book;
    }

    public void setImport_Name_Book(String import_Name_Book) {
        this.import_Name_Book = import_Name_Book;
    }

    public String getImport_Note() {
        return import_Note;
    }

    public void setImport_Note(String import_Note) {
        this.import_Note = import_Note;
    }

    public float getImport_Detail_Price_Book() {
        return import_Detail_Price_Book;
    }

    public void setImport_Detail_Price_Book(float import_Detail_Price_Book) {
        this.import_Detail_Price_Book = import_Detail_Price_Book;
    }

    public float getImport_Detail_Total() {
        return import_Detail_Total;
    }

    public void setImport_Detail_Total(float import_Detail_Total) {
        this.import_Detail_Total = import_Detail_Total;
    }

    public Date getImport_Date() {
        return import_Date;
    }

    public void setImport_Date(Date import_Date) {
        this.import_Date = import_Date;
    }

    public boolean isImport_Status() {
        return import_Status;
    }

    public void setImport_Status(boolean import_Status) {
        this.import_Status = import_Status;
    }

    public int getImport_Book_Id() {
        return import_Book_Id;
    }

    public void setImport_Book_Id(int import_Book_Id) {
        this.import_Book_Id = import_Book_Id;
    }

    public int getImport_Category_Id() {
        return import_Category_Id;
    }

    public void setImport_Category_Id(int import_Category_Id) {
        this.import_Category_Id = import_Category_Id;
    }

    public String getImport_Employee() {
        return import_Employee;
    }

    public void setImport_Employee(String import_Employee) {
        this.import_Employee = import_Employee;
    }
}
