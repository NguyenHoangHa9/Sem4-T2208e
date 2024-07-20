package org.example.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.Dto.EmployeeDto;
import org.example.Service.EmployeeService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        String jdbcURL = "jdbc:mysql://localhost:3306/mysql";
        String jdbcUsername = "root";
        String jdbcPassword = "admin@123";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            employeeService = new EmployeeService(connection);
        } catch (SQLException e) {
            throw new ServletException("Unable to connect to the database", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        try {

            if ("add".equals(action)) {
                // Xử lý thêm nhân viên
                EmployeeDto EmployeeDto = new EmployeeDto(
                        request.getParameter("employee_id"),
                        request.getParameter("employee_name"),
                        request.getParameter("birthday"),
                        request.getParameter("phone_number"),
                        request.getParameter("email")
                );
                employeeService.addEmployee(EmployeeDto);
                response.sendRedirect("success.jsp");

            } else if ("update".equals(action)) {
                // Xử lý cập nhật nhân viên
                EmployeeDto EmployeeDto = new EmployeeDto(
                        request.getParameter("employee_id"),
                        request.getParameter("employee_name"),
                        request.getParameter("birthday"),
                        request.getParameter("phone_number"),
                        request.getParameter("email")
                );
                employeeService.updateEmployee(EmployeeDto);
                response.sendRedirect("success.jsp");

            } else if ("delete".equals(action)) {
                // Xử lý xóa nhân viên
                String employeeId = request.getParameter("employee_id");
                employeeService.deleteEmployee(employeeId);
                response.sendRedirect("success.jsp");

            } else if ("search".equals(action)) {
                // Xử lý tìm kiếm nhân viên
                String employeeId = request.getParameter("employee_id");
                String employeeName = request.getParameter("employee_name");

                if (employeeId != null && !employeeId.isEmpty()) {
                    EmployeeDto EmployeeDto = employeeService.getEmployeeById(employeeId);
                    request.setAttribute("employee", EmployeeDto);
                    request.getRequestDispatcher("employeeDetails.jsp").forward(request, response);
                } else if (employeeName != null && !employeeName.isEmpty()) {
                    List<EmployeeDto> employees = employeeService.getAllEmployees();
                    List<EmployeeDto> filteredEmployees = new ArrayList<>();
                    for (EmployeeDto emp : employees) {
                        if (emp.getEmployeeName().contains(employeeName)) {
                            filteredEmployees.add(emp);
                        }
                    }
                    request.setAttribute("employees", filteredEmployees);
                    request.getRequestDispatcher("employeeList.jsp").forward(request, response);
                } else {
                    // Không tìm thấy nhân viên nào
                    request.setAttribute("message", "No results found.");
                    request.getRequestDispatcher("searchEmployee.jsp").forward(request, response);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Database error occurred: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Có thể xử lý các yêu cầu GET nếu cần
        doPost(request, response);
    }
}