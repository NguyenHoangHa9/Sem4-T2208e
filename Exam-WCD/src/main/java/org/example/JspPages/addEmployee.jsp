<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
    <h1>Add Employee</h1>
    <form action="employee" method="post">
        <input type="hidden" name="action" value="add" />
        Employee ID: <input type="text" name="employee_id" required /><br />
        Employee Name: <input type="text" name="employee_name" required /><br />
        Birthday: <input type="date" name="birthday" required /><br />
        Phone Number: <input type="text" name="phone_number" required /><br />
        Email: <input type="email" name="email" required /><br />
        <input type="submit" value="Add Employee" />
    </form>
</body>
</html>
