/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se1611.orderdetail;

import com.se1611.book.BookDTO;
/**
 *
 * @author chilamha
 */
public class OrderItemObj {
    private BookDTO book;
    private int quantity;

    public OrderItemObj(BookDTO book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
