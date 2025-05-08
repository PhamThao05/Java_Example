<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Giải phương trình bậc 2</title>
</head>
<body>
    <h2>Giải phương trình bậc 2: ax² + bx + c = 0</h2>

    <form method="post">
        a: <input type="text" name="a" required><br>
        b: <input type="text" name="b" required><br>
        c: <input type="text" name="c" required><br>
        <input type="submit" value="Giải">
    </form>

    <%
        String aStr = request.getParameter("a");
        String bStr = request.getParameter("b");
        String cStr = request.getParameter("c");

        if (aStr != null && bStr != null && cStr != null) {
            try {
                double a = Double.parseDouble(aStr);
                double b = Double.parseDouble(bStr);
                double c = Double.parseDouble(cStr);

                if (a == 0) {
                    if (b == 0) {
                        if (c == 0) {
                            out.println("Phương trình vô số nghiệm.");
                        } else {
                            out.println("Phương trình vô nghiệm.");
                        }
                    } else {
                        double x = -c / b;
                        out.println("Phương trình có một nghiệm: x = " + x);
                    }
                } else {
                    double delta = b * b - 4 * a * c;
                    if (delta < 0) {
                        out.println("Phương trình vô nghiệm.");
                    } else if (delta == 0) {
                        double x = -b / (2 * a);
                        out.println("Phương trình có nghiệm kép: x = " + x);
                    } else {
                        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                        out.println("Phương trình có 2 nghiệm phân biệt:<br>");
                        out.println("x1 = " + x1 + "<br>");
                        out.println("x2 = " + x2);
                    }
                }
            } catch (NumberFormatException e) {
                out.println("Vui lòng nhập đúng định dạng số.");
            }
        }
    %>
</body>
</html>
