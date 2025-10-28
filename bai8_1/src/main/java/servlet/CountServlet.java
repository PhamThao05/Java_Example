package servlet; 

import java.io.IOException; 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession; 

public class CountServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String input = request.getParameter("inputString");

        int count = input.length(); 

        request.setAttribute("count", count); 

        HttpSession session = request.getSession(); 

        session.setAttribute("inputString", input); 

        RequestDispatcher dispatcher = request.getRequestDispatcher("count.jsp"); 

        dispatcher.forward(request, response); 
    }
}
