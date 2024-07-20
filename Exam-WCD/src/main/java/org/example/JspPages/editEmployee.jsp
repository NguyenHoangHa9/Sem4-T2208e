<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Employee</title>
</head>
<body>
    <h1>Edit Employee</h1>
    <form action="employee" method="post">
        <input type="hidden" name="action" value="edit" />
        Employee ID: <input type="text" name="employee_id" value="${employee_id}" readonly /><br />
        Employee Name: <input type="text" name="employee_name" value="${employee_name}" required /><br />
        Birthday: <input type="date" name="birthday" value="${birthday}" required /><br />
        Phone Number: <input type="text" name="phone_number" value="${phone_number}" required /><br />
        Email: <input type="email" name="email" value="${email}" required /><br />
        <input type="submit" value="Update Employee" />
    </form>
</body>
</html>
