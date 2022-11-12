/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.se1611.bookingRequest;

import java.sql.Date;
import java.time.LocalDate;

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
    private LocalDate date_Request_Done;

    private String note;
    private int status;
    private boolean status_Book_Request;

    public BookingRequestDTO() {
    }

    public BookingRequestDTO(int request_Id, String image, String name_Book, int quantity_Request, float price_Request, LocalDate date_Request, LocalDate date_Request_Done, String note, int status, boolean status_Book_Request) {
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

    public LocalDate getDate_Request_Done() {
        return date_Request_Done;
    }

    public void setDate_Request_Done(LocalDate date_Request_Done) {
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
