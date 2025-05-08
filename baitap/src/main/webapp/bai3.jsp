<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #f8f9fa;
    }
    .login-container {
      max-width: 400px;
      margin: 100px auto;
      padding: 30px;
      background-color: white;
      box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
      border-radius: 10px;
    }
  </style>
</head>
<body>
<div class="login-container">
  <h3 class="text-center mb-4">Đăng nhập</h3>
  <form>
    <div class="mb-3">
      <label>Tên đăng nhập</label>
      <input type="text" class="form-control" id="username" placeholder="Nhập tên đăng nhập">
    </div>
    <div class="mb-3">
      <label>Mật khẩu</label>
      <input type="password" class="form-control" id="password" placeholder="Nhập mật khẩu">
    </div>
    <button type="submit" class="btn btn-primary w-100">Đăng nhập</button>
  </form>
  </div>
</body>
</html>