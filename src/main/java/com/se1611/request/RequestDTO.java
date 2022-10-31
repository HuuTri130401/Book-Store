package com.se1611.request;

import java.sql.Date;

public class RequestDTO {
    public int request_Id;
    public int request_Book_Id;
    public String request_Image;
    public String request_Name_Book;
    public int request_Quantity;
    public Date request_Date;
    public String request_Note;
    public int request_Status;
    public int request_Category;
    public RequestDTO(int request_Id, int request_Book_Id, String request_Image, String request_Name_Book,
                      int request_Quantity, Date request_Date, String request_Note, int request_Status) {
        this.request_Id = request_Id;
        this.request_Book_Id = request_Book_Id;
        this.request_Image = request_Image;
        this.request_Name_Book = request_Name_Book;
        this.request_Quantity = request_Quantity;
        this.request_Date = request_Date;
        this.request_Note = request_Note;
        this.request_Status = request_Status;
    }

    public RequestDTO() {

    }

    public int getRequest_Id() {
        return request_Id;
    }

    public void setRequest_Id(int request_Id) {
        this.request_Id = request_Id;
    }

    public int getRequest_Book_Id() {
        return request_Book_Id;
    }

    public void setRequest_Book_Id(int request_Book_Id) {
        this.request_Book_Id = request_Book_Id;
    }

    public String getRequest_Image() {
        return request_Image;
    }

    public int getRequest_Category() {
        return request_Category;
    }

    public void setRequest_Category(int request_Category) {
        this.request_Category = request_Category;
    }

    public void setRequest_Image(String request_Image) {
        this.request_Image = request_Image;
    }

    public String getRequest_Name_Book() {
        return request_Name_Book;
    }

    public void setRequest_Name_Book(String request_Name_Book) {
        this.request_Name_Book = request_Name_Book;
    }

    public int getRequest_Quantity() {
        return request_Quantity;
    }

    public void setRequest_Quantity(int request_Quantity) {
        this.request_Quantity = request_Quantity;
    }

    public Date getRequest_Date() {
        return request_Date;
    }

    public void setRequest_Date(Date request_Date) {
        this.request_Date = request_Date;
    }

    public String getRequest_Note() {
        return request_Note;
    }

    public void setRequest_Note(String request_Note) {
        this.request_Note = request_Note;
    }

    public int getRequest_Status() {
        return request_Status;
    }

    public void setRequest_Status(int request_Status) {
        this.request_Status = request_Status;
    }
}
