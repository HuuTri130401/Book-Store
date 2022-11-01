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
public class CustomizedOrderDetailDTO {
    private int orderDetailId;
    private int bookId;
    private int quantity;
    private int cateId;
    private String name;
    private float price;
    private float total;
    private String img;

    public CustomizedOrderDetailDTO(int orderDetailId, int bookId, int quantity, int cateId, String name, float price, String img) {
        this.orderDetailId = orderDetailId;
        this.bookId = bookId;
        this.quantity = quantity;
        this.cateId = cateId;
        this.name = name;
        this.price = price;
        this.total = quantity*price;
        this.img = img;
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

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
}
