package org.example.DAO;
import org.example.Entity.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDAO {
    private Connection connection;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    // Thêm nhân viên mới vào cơ sở dữ liệu
    public void addEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO employee (employee_id, employee_name, birthday, phone_number, email) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, employee.getEmployeeId());
            stmt.setString(2, employee.getEmployeeName());
            stmt.setDate(3, employee.getBirthday());
            stmt.setString(4, employee.getPhoneNumber());
            stmt.setString(5, employee.getEmail());
            stmt.executeUpdate();
        }
    }

    // Cập nhật thông tin nhân viên
    public void updateEmployee(Employee employee) throws SQLException {
        String sql = "UPDATE employee SET employee_name = ?, birthday = ?, phone_number = ?, email = ? WHERE employee_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, employee.getEmployeeName());
            stmt.setDate(2, employee.getBirthday());
            stmt.setString(3, employee.getPhoneNumber());
            stmt.setString(4, employee.getEmail());
            stmt.setString(5, employee.getEmployeeId());
            stmt.executeUpdate();
        }
    }

    // Xóa nhân viên theo ID
    public void deleteEmployee(String employeeId) throws SQLException {
        String sql = "DELETE FROM employee WHERE employee_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, employeeId);
            stmt.executeUpdate();
        }
    }

    // Lấy thông tin nhân viên theo ID
    public Employee getEmployeeById(String employeeId) throws SQLException {
        String sql = "SELECT * FROM employee WHERE employee_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, employeeId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Employee(
                            rs.getString("employee_id"),
                            rs.getString("employee_name"),
                            rs.getDate("birthday"),
                            rs.getString("phone_number"),
                            rs.getString("email")
                    );
                }
            }
        }
        return null; // Trả về null nếu không tìm thấy nhân viên
    }

    // Lấy tất cả nhân viên từ cơ sở dữ liệu
    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                employees.add(new Employee(
                        rs.getString("employee_id"),
                        rs.getString("employee_name"),
                        rs.getDate("birthday"),
                        rs.getString("phone_number"),
                        rs.getString("email")
                ));
            }
        }
        return employees;
    }

    }