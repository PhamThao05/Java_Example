package listener; 

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent; 

public class SessionAttributeListener implements HttpSessionAttributeListener { 
    
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) { 
        if ("inputString".equals(event.getName())) {
            System.out.println("Thêm chuỗi: " + event.getValue()); // In ra giá trị của thuộc tính được thêm vào.
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) { // Ghi đè phương thức được gọi khi một thuộc tính trong session bị thay thế.
        if ("inputString".equals(event.getName())) { // Kiểm tra xem tên thuộc tính bị thay thế có phải là "inputString" không.
            System.out.println("Cập nhật chuỗi: " + event.getValue()); // In ra giá trị cũ của thuộc tính trước khi bị thay thế.
        }
    }
}
