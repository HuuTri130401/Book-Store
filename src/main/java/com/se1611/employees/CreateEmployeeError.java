/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.se1611.employees;

/**
 *
 * @author Admin
 */
public class CreateEmployeeError {

    private int employee_IdError;
    private String account_IdError;
    private String passwordError;
    private String confirmPasswordError;
    private String fullNameError;
    private String phoneError;
    private String addressError;
    private String genderError;
    private String roleError;
    private String status_EmployeeError;
    private String employeeErrorMsg;

    public CreateEmployeeError() {
    }

    public CreateEmployeeError(int employee_IdError, String account_IdError, String passwordError, String confirmPasswordError, String fullNameError, String phoneError, String addressError, String genderError, String roleError, String status_EmployeeError) {
        this.employee_IdError = employee_IdError;
        this.account_IdError = account_IdError;
        this.passwordError = passwordError;
        this.confirmPasswordError = confirmPasswordError;
        this.fullNameError = fullNameError;
        this.phoneError = phoneError;
        this.addressError = addressError;
        this.genderError = genderError;
        this.roleError = roleError;
        this.status_EmployeeError = status_EmployeeError;
    }

    public int getEmployee_IdError() {
        return employee_IdError;
    }

    public void setEmployee_IdError(int employee_IdError) {
        this.employee_IdError = employee_IdError;
    }

    public String getEmployeeErrorMsg() {
        return employeeErrorMsg;
    }

    public void setEmployeeErrorMsg(String employeeErrorMsg) {
        this.employeeErrorMsg = employeeErrorMsg;
    }

    public String getAccount_IdError() {
        return account_IdError;
    }

    public void setAccount_IdError(String account_IdError) {
        this.account_IdError = account_IdError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getConfirmPasswordError() {
        return confirmPasswordError;
    }

    public void setConfirmPasswordError(String confirmPasswordError) {
        this.confirmPasswordError = confirmPasswordError;
    }

    public String getFullNameError() {
        return fullNameError;
    }

    public void setFullNameError(String fullNameError) {
        this.fullNameError = fullNameError;
    }

    public String getPhoneError() {
        return phoneError;
    }

    public void setPhoneError(String phoneError) {
        this.phoneError = phoneError;
    }

    public String getAddressError() {
        return addressError;
    }

    public void setAddressError(String addressError) {
        this.addressError = addressError;
    }

    public String getGenderError() {
        return genderError;
    }

    public void setGenderError(String genderError) {
        this.genderError = genderError;
    }

    public String getRoleError() {
        return roleError;
    }

    public void setRoleError(String roleError) {
        this.roleError = roleError;
    }

    public String getStatus_EmployeeError() {
        return status_EmployeeError;
    }

    public void setStatus_EmployeeError(String status_EmployeeError) {
        this.status_EmployeeError = status_EmployeeError;
    }

}
