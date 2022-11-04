/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se1611.order.com.se1611.cart;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class CartDTO {

    private int bookId;
    private String bookName;
    private int quantity;
    private float price;
    private String image;
    private Date dateOrder;

    public CartDTO() {
    }

    public CartDTO(String bookName, int quantity, float price, String image, Date dateOrder) {
        this.bookName = bookName;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
        this.dateOrder = dateOrder;
    }

    public CartDTO(int bookId, String bookName, int quantity, float price, String image, Date dateOrder) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
        this.dateOrder = dateOrder;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

}
