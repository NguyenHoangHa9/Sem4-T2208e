<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            padding: 50px;
            background-color: #f4f4f4;
        }
        .container {
            border: 1px solid #f8d7da;
            border-radius: 5px;
            background-color: #f8d7da;
            color: #721c24;
            padding: 20px;
            display: inline-block;
        }
        .button {
            display: inline-block;
            padding: 10px 20px;
            margin-top: 20px;
            border: none;
            border-radius: 5px;
            background-color: #dc3545;
            color: #fff;
            text-decoration: none;
            font-size: 16px;
        }
        .button:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Error Occurred</h1>
        <p><%= request.getAttribute("errorMessage") %></p>
        <a href="index.jsp" class="button">Back to Home</a>
    </div>
</body>
</html>
