/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se1611.order;

import com.se1611.orderdetail.CustomizedOrderDetailDTO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author chilamha
 */
public class OrderDTO {
    private int orderId;
    private int employeeId;
    private Date orderDate;
    private int quantity;
    private float total;
    private float totalSum;
    private List<CustomizedOrderDetailDTO> details;

    public OrderDTO() {
    }

    public OrderDTO(int orderId, int employeeId, Date orderDate, int quantity, float total) {
        this.orderId = orderId;
        this.employeeId = employeeId;
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.total = total;
    }

    
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public List<CustomizedOrderDetailDTO> getDetails() {
        return details;
    }

    public void setDetails(List<CustomizedOrderDetailDTO> details) {
        this.details = details;
        int num = details.size();
        for(int i = 0; i < details.size(); ++i){
            this.totalSum += details.get(i).getTotal();
        }
    }
    
}
