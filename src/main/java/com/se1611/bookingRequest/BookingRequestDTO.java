/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.se1611.bookingRequest;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class BookingRequestDTO {

    private int request_Id;
    private String image;
    private String name_Book;
    private int quantity_Request;
    private float price_Request;
    private LocalDate date_Request;
    private Date date_Request_Done;
    private String note;
    private int status;
    private boolean status_Book_Request;

    public BookingRequestDTO() {
    }

    public BookingRequestDTO(int request_Id, String image, String name_Book, int quantity_Request, float price_Request, LocalDate date_Request, Date date_Request_Done, String note, int status, boolean status_Book_Request) {
        this.request_Id = request_Id;
        this.image = image;
        this.name_Book = name_Book;
        this.quantity_Request = quantity_Request;
        this.price_Request = price_Request;
        this.date_Request = date_Request;
        this.date_Request_Done = date_Request_Done;
        this.note = note;
        this.status = status;
        this.status_Book_Request = status_Book_Request;
    }

    public BookingRequestDTO(int request_Id, String image, String name_Book, int quantity_Request, float price_Request, LocalDate date_Request, String note, int status, boolean status_Book_Request) {
        this.request_Id = request_Id;
        this.image = image;
        this.name_Book = name_Book;
        this.quantity_Request = quantity_Request;
        this.price_Request = price_Request;
        this.date_Request = date_Request;
        this.note = note;
        this.status = status;
        this.status_Book_Request = status_Book_Request;
    }
    
    private float total = price_Request * quantity_Request;
    private int date_To_Order_Month;
    private int date_To_Order_Year;
    private float total_Order = total;

    public float getTotal_Order() {
        return total_Order;
    }

    public void setTotal_Order(float total_Order) {
        this.total_Order = total_Order;
    }
    
    public int getDate_To_Order_Month() {
        return date_To_Order_Month;
    }

    public BookingRequestDTO(int date_To_Order_Month, int date_To_Order_Year, float total) {
        this.date_To_Order_Month = date_To_Order_Month;
        this.date_To_Order_Year = date_To_Order_Year;
        this.total_Order = total;
    }

    public void setDate_To_Order_Month(int date_To_Order_Month) {
        this.date_To_Order_Month = date_To_Order_Month;
    }

    public int getDate_To_Order_Year() {
        return date_To_Order_Year;
    }

    public void setDate_To_Order_Year(int date_To_Order_Year) {
        this.date_To_Order_Year = date_To_Order_Year;
    }

    public int getRequest_Id() {
        return request_Id;
    }

    public void setRequest_Id(int request_Id) {
        this.request_Id = request_Id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName_Book() {
        return name_Book;
    }

    public void setName_Book(String name_Book) {
        this.name_Book = name_Book;
    }

    public int getQuantity_Request() {
        return quantity_Request;
    }

    public void setQuantity_Request(int quantity_Request) {
        this.quantity_Request = quantity_Request;
    }

    public float getPrice_Request() {
        return price_Request;
    }

    public void setPrice_Request(float price_Request) {
        this.price_Request = price_Request;
    }

    public LocalDate getDate_Request() {
        return date_Request;
    }

    public void setDate_Request(LocalDate date_Request) {
        this.date_Request = date_Request;
    }

    public Date getDate_Request_Done() {
        return date_Request_Done;
    }

    public void setDate_Request_Done(Date date_Request_Done) {
        this.date_Request_Done = date_Request_Done;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isStatus_Book_Request() {
        return status_Book_Request;
    }

    public void setStatus_Book_Request(boolean status_Book_Request) {
        this.status_Book_Request = status_Book_Request;
    }

}
