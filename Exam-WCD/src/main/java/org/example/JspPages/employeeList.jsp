<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
    <h1>Employee List</h1>
    <c:if test="${not empty employees}">
        <table border="1">
            <tr>
                <th>Employee ID</th>
                <th>Employee Name</th>
                <th>Birthday</th>
                <th>Phone Number</th>
                <th>Email</th>
            </tr>
            <c:forEach var="employee" items="${employees}">
                <tr>
                    <td>${employee.employeeId}</td>
                    <td>${employee.employeeName}</td>
                    <td>${employee.birthday}</td>
                    <td>${employee.phoneNumber}</td>
                    <td>${employee.email}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${empty employees}">
        <p>No employees found.</p>
    </c:if>
    <a href="searchEmployee.jsp">Back to Search</a>
</body>
</html>
