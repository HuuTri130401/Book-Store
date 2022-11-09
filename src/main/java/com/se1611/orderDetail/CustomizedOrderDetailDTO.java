/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.se1611.orderDetail;

/**
 *
 * @author chilamha
 */
public class CustomizedOrderDetailDTO {
    private int detailId;
    private int bookId;
    private int quantity;
    private int cateId;
    private String title;
    private float price;
    private float total;
    private String cover;

    public CustomizedOrderDetailDTO(int detailId, int bookId, int quantity, int cateId, String title, float price, String cover) {
        this.detailId = detailId;
        this.bookId = bookId;
        this.quantity = quantity;
        this.cateId = cateId;
        this.title = title;
        this.price = price;
        this.cover = cover;
    }

    
    public CustomizedOrderDetailDTO(int detailId, int bookId, int quantity, int cateId, String title, float price, float total, String cover) {
        this.detailId = detailId;
        this.bookId = bookId;
        this.quantity = quantity;
        this.cateId = cateId;
        this.title = title;
        this.price = price;
        this.total = total;
        this.cover = cover;
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
    
    
}
