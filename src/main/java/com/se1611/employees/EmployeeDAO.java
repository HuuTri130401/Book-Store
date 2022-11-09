/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.se1611.employees;

import com.se1611.utils.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author Admin
 */
public class EmployeeDAO {

    public EmployeeDTO getAccountByAccoutIdAndPassword(String account_Id, String password)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        EmployeeDTO employee = null;

        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "Select employee_Id, account_Id, password, fullName, phone, address, gender, role, status_Employee\n"
                        + "From Employee \n"
                        + "Where account_Id = ? and password = ?;";

                stm = con.prepareStatement(sql);
                stm.setString(1, account_Id);
                stm.setString(2, password);

                rs = stm.executeQuery();
                if (rs.next()) {
                    int employee_Id = rs.getInt("employee_Id");
                    String fullName = rs.getString("fullName");
                    String phone = rs.getString("phone");
                    String address = rs.getString("address");
                    String gender = rs.getString("gender");
                    String role = rs.getString("role");
                    boolean status_Employee = rs.getBoolean("status_Employee");
                    employee = new EmployeeDTO(employee_Id, account_Id, password, fullName, phone, address, gender, role, status_Employee);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return employee;
    }

    public List<EmployeeDTO> getListEmployee()
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<EmployeeDTO> listEmployees = new ArrayList<>();
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "Select employee_Id, account_Id, password, fullName, phone, address, gender, role, status_Employee \n"
                        + "From Employee \n"
                        + "Order by status_Employee";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int employee_Id = rs.getInt("employee_Id");
                    String account_Id = rs.getString("account_Id");
                    String password = rs.getString("password");
                    String fullName = rs.getString("fullName");
                    String phone = rs.getString("phone");
                    String address = rs.getString("address");
                    String gender = rs.getString("gender");
                    String role = rs.getString("role");
                    boolean status_Employee = rs.getBoolean("status_Employee");
                    EmployeeDTO dto = new EmployeeDTO(employee_Id, account_Id, password, fullName, phone, address, gender, role, status_Employee);
                    listEmployees.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return listEmployees;
    }

    public List<EmployeeDTO> searchEmployeesByName(String searchValue)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        List<EmployeeDTO> listEmployee = new ArrayList<>();

        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "Select employee_Id, account_Id, password, fullName, phone, address, gender, role, status_Employee\n"
                        + "From Employee\n"
                        + "Where fullName LIKE  ?";

                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    int employee_Id = rs.getInt("employee_Id");
                    String account_Id = rs.getString("account_Id");
                    String password = rs.getString("password");
                    String fullName = rs.getString("fullName");
                    String phone = rs.getString("phone");
                    String address = rs.getString("address");
                    String gender = rs.getString("gender");
                    String role = rs.getString("role");
                    boolean status_Employee = rs.getBoolean("status_Employee");

                    EmployeeDTO dto = new EmployeeDTO(employee_Id, account_Id, password, fullName, phone, address, gender, role, status_Employee);
                    listEmployee.add(dto);
                }//end while rs not null
            }//end if con is not null
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return listEmployee;
    }

    public boolean deleteEmployeeAccount(String employee_Id)
            throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "Update Employee Set status_Employee = 0 Where employee_Id = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, employee_Id);
                int rowEffect = stm.executeUpdate();

                if (rowEffect > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean updateEmployeeAccount(int employee_Id, String account_Id, String password, String fullName, String phone, String address, String gender, String role, boolean status_Employee)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "  Update Employee \n"
                        + "  Set account_Id = ?, password = ?, fullName = ?, phone = ?, address = ?, gender = ?, role = ?, status_Employee = ? \n"
                        + "  Where employee_Id = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, account_Id);
                stm.setString(2, password);
                stm.setString(3, fullName);
                stm.setString(4, phone);
                stm.setString(5, address);
                stm.setString(6, gender);
                stm.setString(7, role);
                stm.setBoolean(8, status_Employee);
                stm.setInt(9, employee_Id);

                int rowEffect = stm.executeUpdate();
                if (rowEffect > 0) {
                    return true;
                } //end if result > 0
            } //end if con is not null
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return false;
    }

    public boolean addEmployeeAccount(EmployeeDTO employee)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "Insert Employee(account_Id, password, fullName, phone, address, gender, role, status_Employee)\n"
                        + "Values (?, ?, ?, ?, ?, ?, ?, ?)";

                stm = con.prepareStatement(sql);
                stm.setString(1, employee.getAccount_Id());
                stm.setString(2, employee.getPassword());
                stm.setString(3, employee.getFullName());
                stm.setString(4, employee.getPhone());
                stm.setString(5, employee.getAddress());
                stm.setString(6, employee.getGender());
                stm.setString(7, employee.getRole());
                stm.setBoolean(8, employee.isStatus_Employee());

                int rowEffect = stm.executeUpdate();
                if (rowEffect > 0) {
                    return true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean checkAcoountDuplicate(String account_Id) throws SQLException, NamingException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement("SELECT account_Id FROM Employee WHERE account_Id = ?");
                stm.setString(1, account_Id);
                rs = stm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return check;
    }

}
