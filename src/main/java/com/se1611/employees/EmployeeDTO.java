/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.se1611.employees;

/**
 *
 * @author Admin
 */
public class EmployeeDTO {

    private int employee_Id;
    private String account_Id;
    private String password;
    private String fullName;
//    private int phone;
    private String phone;
    private String address;
    private String gender;
    private String role;
    private boolean status_Employee;

    public EmployeeDTO() {
    }

    public EmployeeDTO(int employee_Id, String account_Id, String password, String fullName, String phone, String address, String gender, String role, boolean status_Employee) {
        this.employee_Id = employee_Id;
        this.account_Id = account_Id;
        this.password = password;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.role = role;
        this.status_Employee = status_Employee;
    }

    public EmployeeDTO(String account_Id, String password, String fullName, String phone, String address, String gender, String role, boolean status_Employee) {
        this.account_Id = account_Id;
        this.password = password;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.role = role;
        this.status_Employee = status_Employee;
    }

    public int getEmployee_Id() {
        return employee_Id;
    }

    public void setEmployee_Id(int employee_Id) {
        this.employee_Id = employee_Id;
    }

    public String getAccount_Id() {
        return account_Id;
    }

    public void setAccount_Id(String account_Id) {
        this.account_Id = account_Id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isStatus_Employee() {
        return status_Employee;
    }

    public void setStatus_Employee(boolean status_Employee) {
        this.status_Employee = status_Employee;
    }

}
