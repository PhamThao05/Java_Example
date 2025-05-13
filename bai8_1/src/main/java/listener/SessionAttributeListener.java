package listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        if ("inputString".equals(event.getName())) {
            System.out.println("Thêm chuỗi: " + event.getValue());
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        if ("inputString".equals(event.getName())) {
            System.out.println("Cập nhật chuỗi: " + event.getValue());
        }
    }
}
