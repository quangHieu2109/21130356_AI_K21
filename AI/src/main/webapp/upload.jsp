<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nhận diện chữ viết tay</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .container {
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 300px;
            text-align: center;
        }

        h1 {
            color: #333;
        }

        form {
            margin-top: 20px;
        }

        input[type="file"] {
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            margin-right: 10px;
            width: 70%;
            display: inline-block;
            box-sizing: border-box;
        }

        button {
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 28%;
            box-sizing: border-box;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Chọn tệp tin để nhận diện</h1>
        
        <!-- Biểu mẫu để tải file lên -->
        <form method="POST" action="UploadServlet" enctype="multipart/form-data">
            <input type="file" name="file" id="fileInput">
            <button type="submit">Tải lên</button>
        </form>
    </div>
</body>
</html>
