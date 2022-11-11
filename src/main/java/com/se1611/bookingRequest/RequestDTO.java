package com.se1611.bookingRequest;

import java.sql.Date;

public class RequestDTO {
    public int request_Id;
    public float request_Price;
    public String request_Image;
    public String request_Name_Book;
    public int request_Quantity;
    public Date request_Date;
    public Date request_Date_Done;
    public String request_Note;
    public int request_Status;
    public int request_Category;
    public boolean status_Book_Request;

    public RequestDTO() {

    }

    public int getRequest_Id() {
        return request_Id;
    }

    public void setRequest_Id(int request_Id) {
        this.request_Id = request_Id;
    }

    public float getRequest_Price() {
        return request_Price;
    }

    public void setRequest_Price(float request_Price) {
        this.request_Price = request_Price;
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

    public boolean isStatus_Book_Request() {
        return status_Book_Request;
    }

    public void setStatus_Book_Request(boolean status_Book_Request) {
        this.status_Book_Request = status_Book_Request;
    }

    public Date getRequest_Date_Done() {
        return request_Date_Done;
    }

    public void setRequest_Date_Done(Date request_Date_Done) {
        this.request_Date_Done = request_Date_Done;
    }
}
