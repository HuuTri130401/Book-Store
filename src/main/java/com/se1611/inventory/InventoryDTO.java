package com.se1611.inventory;

import java.sql.Date;

public class InventoryDTO {
        public int inventory_Id;
        public int inventory_Detail_Id;
        public String inventory_Img;
        public String inventory_Name_Book;
        public int quantity_Inventory;
        public Date date_Inventory;
        public String employee_Inventory;
        public String note_Inventory;
        public int inventory_Book_Id;
        public int inventory_Category_Id;
        public boolean inventory_Status;

        public InventoryDTO(int inventory_Id, int inventory_Detail_Id, String inventory_Img, String inventory_Name_Book,
                            int quantity_Inventory, Date date_Inventory, String employee_Inventory, String note_Inventory,
                            int inventory_Book_Id, int inventory_Category_Id, boolean inventory_Status) {
                this.inventory_Id = inventory_Id;
                this.inventory_Detail_Id = inventory_Detail_Id;
                this.inventory_Img = inventory_Img;
                this.inventory_Name_Book = inventory_Name_Book;
                this.quantity_Inventory = quantity_Inventory;
                this.date_Inventory = date_Inventory;
                this.employee_Inventory = employee_Inventory;
                this.note_Inventory = note_Inventory;
                this.inventory_Book_Id = inventory_Book_Id;
                this.inventory_Category_Id = inventory_Category_Id;
                this.inventory_Status = inventory_Status;
        }

        public InventoryDTO(int inventory_Id, String inventory_Img, String inventory_Name_Book, int quantity_Inventory,
                            Date date_Inventory, String employee_Inventory, String note_Inventory, int inventory_Book_Id,
                            int inventory_Category_Id, boolean inventory_Status) {
                this.inventory_Id = inventory_Id;
                this.inventory_Img = inventory_Img;
                this.inventory_Name_Book = inventory_Name_Book;
                this.quantity_Inventory = quantity_Inventory;
                this.date_Inventory = date_Inventory;
                this.employee_Inventory = employee_Inventory;
                this.note_Inventory = note_Inventory;
                this.inventory_Book_Id = inventory_Book_Id;
                this.inventory_Category_Id = inventory_Category_Id;
                this.inventory_Status = inventory_Status;
        }


        public InventoryDTO() {
        }

        public int getInventory_Id() {
                return inventory_Id;
        }

        public void setInventory_Id(int inventory_Id) {
                this.inventory_Id = inventory_Id;
        }

        public String getInventory_Img() {
                return inventory_Img;
        }

        public void setInventory_Img(String inventory_Img) {
                this.inventory_Img = inventory_Img;
        }

        public String getInventory_Name_Book() {
                return inventory_Name_Book;
        }

        public void setInventory_Name_Book(String inventory_Name_Book) {
                this.inventory_Name_Book = inventory_Name_Book;
        }

        public int getQuantity_Inventory() {
                return quantity_Inventory;
        }

        public void setQuantity_Inventory(int quantity_Inventory) {
                this.quantity_Inventory = quantity_Inventory;
        }

        public Date getDate_Inventory() {
                return date_Inventory;
        }

        public void setDate_Inventory(Date date_Inventory) {
                this.date_Inventory = date_Inventory;
        }

        public String getEmployee_Inventory() {
                return employee_Inventory;
        }

        public void setEmployee_Inventory(String employee_Inventory) {
                this.employee_Inventory = employee_Inventory;
        }

        public String getNote_Inventory() {
                return note_Inventory;
        }

        public void setNote_Inventory(String note_Inventory) {
                this.note_Inventory = note_Inventory;
        }

        public int getInventory_Book_Id() {
                return inventory_Book_Id;
        }

        public void setInventory_Book_Id(int inventory_Book_Id) {
                this.inventory_Book_Id = inventory_Book_Id;
        }

        public int getInventory_Category_Id() {
                return inventory_Category_Id;
        }

        public void setInventory_Category_Id(int inventory_Category_Id) {
                this.inventory_Category_Id = inventory_Category_Id;
        }

        public boolean isInventory_Status() {
                return inventory_Status;
        }

        public void setInventory_Status(boolean inventory_Status) {
                this.inventory_Status = inventory_Status;
        }

        public int getInventory_Detail_Id() {
                return inventory_Detail_Id;
        }

        public void setInventory_Detail_Id(int inventory_Detail_Id) {
                this.inventory_Detail_Id = inventory_Detail_Id;
        }
}
