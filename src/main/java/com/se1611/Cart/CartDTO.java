package com.se1611.Cart;
import java.sql.Date;
public class CartDTO {
    private int bookId;
    private String bookName;
    private int quantity;
    private int quantity_Book;
    private float price;
    private String image;
    private Date dateOrder;

    public CartDTO() {
    }

    public CartDTO(int bookId, String bookName, int quantity, int quantity_Book, float price, String image, Date dateOrder) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.quantity = quantity;
        this.quantity_Book = quantity_Book;
        this.price = price;
        this.image = image;
        this.dateOrder = dateOrder;
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

    public int getQuantity_Book() {
        return quantity_Book;
    }

    public void setQuantity_Book(int quantity_Book) {
        this.quantity_Book = quantity_Book;
    }
}
