package com.se1611.orders;

public class OrderDetailDTO {
    private int order_Detail_Id;
    private int order_Id;
    private int book_Id;
    private int quantity_Order_Detail;
    private float total_Order_Detail;
    private boolean status;
    private String image_Order;
    private String name_Book_Order;
    private int category_Id;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(int order_Detail_Id, int order_Id, int book_Id, int quantity_Order_Detail, float total_Order_Detail, boolean status) {
        this.order_Detail_Id = order_Detail_Id;
        this.order_Id = order_Id;
        this.book_Id = book_Id;
        this.quantity_Order_Detail = quantity_Order_Detail;
        this.total_Order_Detail = total_Order_Detail;
        this.status = status;
    }

    public OrderDetailDTO(int order_Id, int book_Id, int quantity_Order_Detail, float total_Order_Detail, boolean status) {
        this.order_Id = order_Id;
        this.book_Id = book_Id;
        this.quantity_Order_Detail = quantity_Order_Detail;
        this.total_Order_Detail = total_Order_Detail;
        this.status = status;
    }

    public int getOrder_Detail_Id() {
        return order_Detail_Id;
    }

    public void setOrder_Detail_Id(int order_Detail_Id) {
        this.order_Detail_Id = order_Detail_Id;
    }

    public int getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(int order_Id) {
        this.order_Id = order_Id;
    }

    public int getBook_Id() {
        return book_Id;
    }

    public void setBook_Id(int book_Id) {
        this.book_Id = book_Id;
    }

    public int getQuantity_Order_Detail() {
        return quantity_Order_Detail;
    }

    public void setQuantity_Order_Detail(int quantity_Order_Detail) {
        this.quantity_Order_Detail = quantity_Order_Detail;
    }

    public float getTotal_Order_Detail() {
        return total_Order_Detail;
    }

    public void setTotal_Order_Detail(float total_Order_Detail) {
        this.total_Order_Detail = total_Order_Detail;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getImage_Order() {
        return image_Order;
    }

    public void setImage_Order(String image_Order) {
        this.image_Order = image_Order;
    }

    public String getName_Book_Order() {
        return name_Book_Order;
    }

    public void setName_Book_Order(String name_Book_Order) {
        this.name_Book_Order = name_Book_Order;
    }

    public int getCategory_Id() {
        return category_Id;
    }

    public void setCategory_Id(int category_Id) {
        this.category_Id = category_Id;
    }
}
