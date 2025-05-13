<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Đếm ký tự</title>
</head>
<body>
    <h2>Nhập chuỗi để đếm ký tự:</h2>

    <!-- Form nhập chuỗi -->
    <form action="count" method="post">
        <input type="text" name="inputString" />
        <input type="submit" value="Đếm ký tự" />
    </form>

    <c:if test="${not empty count}">
        <p>Chuỗi "${param.inputString}" có ${count} ký tự.</p>

        <!-- Hiển thị thông báo nếu chuỗi dài hơn 10 ký tự -->
        <c:if test="${count > 10}">
            <p>Chuỗi quá dài!</p>
        </c:if>
    </c:if>
</body>
</html>
