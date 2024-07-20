package org.example.Service;

import org.example.DAO.EmployeeDAO;
import org.example.Dto.EmployeeDto;
import org.example.Entity.Employee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private EmployeeDAO employeeDAO;

    public EmployeeService(Connection connection) {
        this.employeeDAO = new EmployeeDAO(connection);
    }

    // Thêm nhân viên mới
    public void addEmployee(EmployeeDto employeeDTO) throws SQLException {
        Employee employee = new Employee(
                employeeDTO.getEmployeeId(),
                employeeDTO.getEmployeeName(),
                Date.valueOf(employeeDTO.getBirthday()),
                employeeDTO.getPhoneNumber(),
                employeeDTO.getEmail()
        );
        employeeDAO.addEmployee(employee);
    }

    // Cập nhật thông tin nhân viên
    public void updateEmployee(EmployeeDto employeeDTO) throws SQLException {
        Employee employee = new Employee(
                employeeDTO.getEmployeeId(),
                employeeDTO.getEmployeeName(),
                Date.valueOf(employeeDTO.getBirthday()), // Chuyển đổi String sang Date
                employeeDTO.getPhoneNumber(),
                employeeDTO.getEmail()
        );
        employeeDAO.updateEmployee(employee);
    }

    // Xóa nhân viên theo ID
    public void deleteEmployee(String employeeId) throws SQLException {
        employeeDAO.deleteEmployee(employeeId);
    }

    // Lấy thông tin nhân viên theo ID
    public EmployeeDto getEmployeeById(String employeeId) throws SQLException {
        Employee employee = employeeDAO.getEmployeeById(employeeId);
        return convertToDTO(employee);
    }

    // Lấy tất cả nhân viên
    public List<EmployeeDto> getAllEmployees() throws SQLException {
        List<Employee> employees = employeeDAO.getAllEmployees();
        List<EmployeeDto> employeeDTOs = new ArrayList<>();
        for (Employee employee : employees) {
            employeeDTOs.add(convertToDTO(employee));
        }
        return employeeDTOs;
    }

    // Chuyển đổi từ Entity sang DTO
    private EmployeeDto convertToDTO(Employee employee) {
        return new EmployeeDto(
                employee.getEmployeeId(),
                employee.getEmployeeName(),
                employee.getBirthday().toString(), // Chuyển đổi Date sang String
                employee.getPhoneNumber(),
                employee.getEmail()
        );
    }
}
