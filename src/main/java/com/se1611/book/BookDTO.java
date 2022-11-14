/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.se1611.book;

/**
 *
 * @author tuan vu
 */
public class BookDTO {

    private int book_Id;
    private String name;
    private String author;
    private int year_Of_Public;
    private int category;
    private float price_Book;
    private int quantity_Book;
    private String image_Book;
    private boolean status;
    private String categoryName;

    private String descriptionBook;

    public BookDTO() {
    }

    public BookDTO(String name, int year_Of_Public, int quantity_Book) {
        this.name = name;
        this.year_Of_Public = year_Of_Public;
        this.quantity_Book = quantity_Book;
    }

    public BookDTO(int book_Id, String name, String author, int year_Of_Public, int category, float price_Book, int quantity_Book) {
        this.book_Id = book_Id;
        this.name = name;
        this.author = author;
        this.year_Of_Public = year_Of_Public;
        this.category = category;
        this.price_Book = price_Book;
        this.quantity_Book = quantity_Book;
    }

    public BookDTO(int book_Id, String name, String author, int year_Of_Public, int category, float price_Book, int quantity_Book, String image_Book, boolean status, String categoryName) {
        this.book_Id = book_Id;
        this.name = name;
        this.author = author;
        this.year_Of_Public = year_Of_Public;
        this.category = category;
        this.price_Book = price_Book;
        this.quantity_Book = quantity_Book;
        this.image_Book = image_Book;
        this.status = status;
        this.categoryName = categoryName;
    }

    public BookDTO(int book_Id, String name, String author, int year_Of_Public, int category, float price_Book, int quantity_Book, String image_Book, boolean status) {
        this.book_Id = book_Id;
        this.name = name;
        this.author = author;
        this.year_Of_Public = year_Of_Public;
        this.category = category;
        this.price_Book = price_Book;
        this.quantity_Book = quantity_Book;
        this.image_Book = image_Book;
        this.status = status;
    }

    public int getBook_Id() {
        return book_Id;
    }

    public void setBook_Id(int book_Id) {
        this.book_Id = book_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear_Of_Public() {
        return year_Of_Public;
    }

    public void setYear_Of_Public(int year_Of_Public) {
        this.year_Of_Public = year_Of_Public;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public float getPrice_Book() {
        return price_Book;
    }

    public void setPrice_Book(float price_Book) {
        this.price_Book = price_Book;
    }

    public int getQuantity_Book() {
        return quantity_Book;
    }

    public void setQuantity_Book(int quantity_Book) {
        this.quantity_Book = quantity_Book;
    }

    public String getImage_Book() {
        return image_Book;
    }

    public void setImage_Book(String image_Book) {
        this.image_Book = image_Book;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescriptionBook() {
        return descriptionBook;
    }

    public void setDescriptionBook(String descriptionBook) {
        this.descriptionBook = descriptionBook;
    }
}
