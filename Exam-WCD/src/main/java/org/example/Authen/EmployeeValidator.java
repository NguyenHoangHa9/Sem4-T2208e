package org.example.Authen;

public class EmployeeValidator {
    public static boolean validateEmployeeId(String id) {
        return id != null && !id.trim().isEmpty();
    }

    public static boolean validateEmployeeName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static boolean validateEmail(String email) {
        return email != null && email.matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");
    }
}
