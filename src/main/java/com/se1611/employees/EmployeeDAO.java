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
import javax.naming.NamingException;

/**
 *
 * @author Admin
 */
public class EmployeeDAO {

    public EmployeeDTO getAccountByAccoutIdAndPassword(String account_Id, String password)
            throws SQLException, ClassNotFoundException, NamingException {
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
                    int phone = rs.getInt("phone");
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
}
