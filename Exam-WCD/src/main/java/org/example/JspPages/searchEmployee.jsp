<!DOCTYPE html>
<html>
<head>
    <title>Search Employee</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 20px;
        }
        .container {
            max-width: 600px;
            margin: auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }
        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .form-group input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
        }
        .form-group input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .message {
            text-align: center;
            color: #d9534f;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Search Employee</h1>
        <form action="EmployeeServlet" method="post">
            <div class="form-group">
                <label for="employee_id">Employee ID:</label>
                <input type="text" id="employee_id" name="employee_id" placeholder="Enter Employee ID" />
            </div>
            <div class="form-group">
                <label for="employee_name">Employee Name:</label>
                <input type="text" id="employee_name" name="employee_name" placeholder="Enter Employee Name" />
            </div>
            <input type="hidden" name="action" value="search" />
            <div class="form-group">
                <input type="submit" value="Search" />
            </div>
        </form>

        <c:if test="${not empty message}">
            <div class="message">
                <p>${message}</p>
            </div>
        </c:if>
    </div>
</body>
</html>
