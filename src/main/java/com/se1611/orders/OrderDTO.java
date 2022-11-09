/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se1611.orders;

import com.se1611.orderDetail.CustomizedOrderDetailDTO;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderDTO implements Serializable {
    private int order_Id;
    private int employee_Id;
    private Date date_To_Order;
    private int quantity_Order;
    private float total_Order;
    private List<CustomizedOrderDetailDTO> details;

    public OrderDTO() {
    }

    public OrderDTO(int order_Id, int employee_Id, Date date_To_Order, int quantity_Order, float total_Order) {
        this.order_Id = order_Id;
        this.employee_Id = employee_Id;
        this.date_To_Order = date_To_Order;
        this.quantity_Order = quantity_Order;
        this.total_Order = total_Order;
    }
    
    public OrderDTO(int employee_Id, Date date_To_Order, int quantity_Order, float total_Order) {
        this.employee_Id = employee_Id;
        this.date_To_Order = date_To_Order;
        this.quantity_Order = quantity_Order;
        this.total_Order = total_Order;
    }

    public OrderDTO(int order_Id, int employee_Id, Date date_To_Order) {
        this.order_Id = order_Id;
        this.employee_Id = employee_Id;
        this.date_To_Order = date_To_Order;
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

    public float getTotal_Order() {
        return total_Order;
    }

   // public void setTotal_Order(Float total_Order) {
     //   this.total_Order = total_Order;
   // }

    public List<CustomizedOrderDetailDTO> getDetails() {
        return details;
    }

    public void setDetails(List<CustomizedOrderDetailDTO> details) {
        this.details = details;
        for(int i = 0; i < details.size(); ++i){
            this.total_Order += details.get(i).getTotal();
        }
        
    }
}
