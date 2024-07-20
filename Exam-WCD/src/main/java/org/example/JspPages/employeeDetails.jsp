<!DOCTYPE html>
<html>
<head>
    <title>Employee Details</title>
</head>
<body>
    <h1>Employee Details</h1>
    <c:if test="${not empty employee}">
        <p>Employee ID: ${employee.employeeId}</p>
        <p>Employee Name: ${employee.employeeName}</p>
        <p>Birthday: ${employee.birthday}</p>
        <p>Phone Number: ${employee.phoneNumber}</p>
        <p>Email: ${employee.email}</p>
    </c:if>
    <c:if test="${empty employee}">
        <p>No employee found with the given ID.</p>
    </c:if>
    <a href="searchEmployee.jsp">Back to Search</a>
</body>
</html>
