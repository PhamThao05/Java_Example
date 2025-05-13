package filter;

import java.io.IOException;
import javax.servlet.Filter; 
import javax.servlet.FilterChain; 
import javax.servlet.FilterConfig; 
import javax.servlet.ServletException; 
import javax.servlet.ServletRequest; 
import javax.servlet.ServletResponse; 
import javax.servlet.annotation.WebFilter; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 

public class InputFilter implements Filter { // Định nghĩa lớp InputFilter, implements giao diện Filter để làm bộ lọc.
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException { // Phương thức doFilter được gọi để xử lý yêu cầu và phản hồi.
        
        String input = request.getParameter("inputString"); // Lấy tham số "inputString" từ yêu cầu của người dùng.
        
        if (input == null || input.trim().isEmpty()) { // Kiểm tra xem tham số có tồn tại và không phải chuỗi trống hay không.
            ((HttpServletResponse) response).sendRedirect("count.jsp"); // Nếu tham số không hợp lệ (null hoặc trống), chuyển hướng người dùng tới trang count.jsp.
        } else { // Nếu tham số hợp lệ, tiếp tục thực thi chuỗi bộ lọc.
            chain.doFilter(request, response); // Chuyển tiếp yêu cầu và phản hồi cho bộ lọc tiếp theo trong chuỗi (hoặc Servlet cuối cùng).
        }
    }
}
