/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.se1611.bookingRequest;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class BookingRequestError {

    private int request_IdError;
    private String imageError;
    private String name_BookError;
    private String quantity_RequestError;
    private String price_RequestError;
    private String date_RequestError;
    private String noteError;
    private String statusError;
    private String status_Book_RequestError;

    public BookingRequestError() {
    }

    public int getRequest_IdError() {
        return request_IdError;
    }

    public void setRequest_IdError(int request_IdError) {
        this.request_IdError = request_IdError;
    }

    public String getImageError() {
        return imageError;
    }

    public void setImageError(String imageError) {
        this.imageError = imageError;
    }

    public String getName_BookError() {
        return name_BookError;
    }

    public void setName_BookError(String name_BookError) {
        this.name_BookError = name_BookError;
    }

    public String getQuantity_RequestError() {
        return quantity_RequestError;
    }

    public void setQuantity_RequestError(String quantity_RequestError) {
        this.quantity_RequestError = quantity_RequestError;
    }

    public String getPrice_RequestError() {
        return price_RequestError;
    }

    public void setPrice_RequestError(String price_RequestError) {
        this.price_RequestError = price_RequestError;
    }

    public String getDate_RequestError() {
        return date_RequestError;
    }

    public void setDate_RequestError(String date_RequestError) {
        this.date_RequestError = date_RequestError;
    }

    public String getNoteError() {
        return noteError;
    }

    public void setNoteError(String noteError) {
        this.noteError = noteError;
    }

    public String getStatusError() {
        return statusError;
    }

    public void setStatusError(String statusError) {
        this.statusError = statusError;
    }

    public String getStatus_Book_RequestError() {
        return status_Book_RequestError;
    }

    public void setStatus_Book_RequestError(String status_Book_RequestError) {
        this.status_Book_RequestError = status_Book_RequestError;
    }

    public BookingRequestError(int request_IdError, String imageError, String name_BookError, String quantity_RequestError, String price_RequestError, String date_RequestError, String noteError, String statusError, String status_Book_RequestError) {
        this.request_IdError = request_IdError;
        this.imageError = imageError;
        this.name_BookError = name_BookError;
        this.quantity_RequestError = quantity_RequestError;
        this.price_RequestError = price_RequestError;
        this.date_RequestError = date_RequestError;
        this.noteError = noteError;
        this.statusError = statusError;
        this.status_Book_RequestError = status_Book_RequestError;
    }

 
}
