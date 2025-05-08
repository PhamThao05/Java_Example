<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Đăng ký</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    .container {
      max-width: 600px;
      margin-top: 50px;
    }
  </style>
</head>
<body>
<div class="container">
  <h3 class="text-center mb-4">Form Đăng ký</h3>
  <form>
    <div class="mb-3">
      <label for="inputEmail" class="form-label">Email</label>
      <input type="email" class="form-control" id="inputEmail" placeholder="Nhập email">
    </div>

    <div class="mb-3">
      <label for="inputPassword" class="form-label">Password</label>
      <input type="password" class="form-control" id="inputPassword" placeholder="Nhập mật khẩu">
    </div>

    <div class="mb-3">
      <label for="inputAddress" class="form-label">Address</label>
      <input type="text" class="form-control" id="inputAddress" placeholder="123 Đường ABC">
    </div>

    <div class="row">
      <div class="col-md-6 mb-3">
        <label for="inputCity" class="form-label">City</label>
        <input type="text" class="form-control" id="inputCity">
      </div>

      <div class="col-md-4 mb-3">
        <label for="inputState" class="form-label">State</label>
        <select id="inputState" class="form-select">
          <option selected>Chọn...</option>
          <option>Hà Nội</option>
          <option>TP. HCM</option>
          <option>Đà Nẵng</option>
        </select>
      </div>

      <div class="col-md-2 mb-3">
        <label for="inputZip" class="form-label">Zip</label>
        <input type="text" class="form-control" id="inputZip">
      </div>
    </div>

    <div class="form-check mb-3">
      <input class="form-check-input" type="checkbox" id="checkMeOut">
      <label class="form-check-label" for="checkMeOut">
        Check me out
      </label>
    </div>

    <button type="submit" class="btn btn-primary w-100">Sign in</button>
  </form>
</div>
</body>
</html>