package com.se1611.orders;

import java.sql.Date;

public class OrderDTO {

    private int order_Id;
    private int employee_Id;
    private Date date_To_Order;
    private int quantity_Order;
    private Float total_Order;
    private String fullname;
    private boolean status_Order;

    public OrderDTO() {
    }

    public OrderDTO(Date date_To_Order, Float total_Order) {
        this.date_To_Order = date_To_Order;
        this.total_Order = total_Order;
    }

    private int date_To_Order_Month;
    private int date_To_Order_Year;

    public int getDate_To_Order_Month() {
        return date_To_Order_Month;
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

    public OrderDTO(int date_To_Order_Month, int date_To_Order_Year, Float total_Order) {
        this.date_To_Order_Month = date_To_Order_Month;
        this.date_To_Order_Year = date_To_Order_Year;
        this.total_Order = total_Order;
    }

 

    public OrderDTO(int order_Id, int employee_Id, Date date_To_Order, int quantity_Order, Float total_Order) {
        this.order_Id = order_Id;
        this.employee_Id = employee_Id;
        this.date_To_Order = date_To_Order;
        this.quantity_Order = quantity_Order;
        this.total_Order = total_Order;

    }

    public OrderDTO(int employee_Id, Date date_To_Order, int quantity_Order, Float total_Order, Boolean status_Order) {
        this.employee_Id = employee_Id;
        this.date_To_Order = date_To_Order;
        this.quantity_Order = quantity_Order;
        this.total_Order = total_Order;
        this.status_Order = status_Order;
    }

    public int getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(int order_Id) {
        this.order_Id = order_Id;
    }

    public int getEmployee_Id() {
        return employee_Id;
    }

    public void setEmployee_Id(int employee_Id) {
        this.employee_Id = employee_Id;
    }

    public Date getDate_To_Order() {
        return date_To_Order;
    }

    public void setDate_To_Order(Date date_To_Order) {
        this.date_To_Order = date_To_Order;
    }

    public int getQuantity_Order() {
        return quantity_Order;
    }

    public void setQuantity_Order(int quantity_Order) {
        this.quantity_Order = quantity_Order;
    }

    public Float getTotal_Order() {
        return total_Order;
    }

    public void setTotal_Order(Float total_Order) {
        this.total_Order = total_Order;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean isStatus_Order() {
        return status_Order;
    }

    public void setStatus_Order(boolean status_Order) {
        this.status_Order = status_Order;
    }
}
