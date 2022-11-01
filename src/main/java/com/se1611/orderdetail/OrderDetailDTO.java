/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se1611.orderdetail;


/**
 *
 * @author chilamha
 */
public class OrderDetailDTO {
    private int orderId;
    private int orderDetailId;
    private int bookId;
    private int quantity;
    private double total;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(int orderId, int orderDetailId, int bookId, int quantity, double total) {
        this.orderId = orderId;
        this.orderDetailId = orderDetailId;
        this.bookId = bookId;
        this.quantity = quantity;
        this.total = total;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
