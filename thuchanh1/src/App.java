import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        // Tạo JFrame
        JFrame frame = new JFrame("My First Swing App");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout()); // Để căn giữa JLabel

        // Tạo JLabel và thêm vào frame
        JLabel label = new JLabel("Hello World");
        label.setFont(new Font("Arial", Font.BOLD, 24)); // Tuỳ chọn: chỉnh font to đẹp hơn
        frame.add(label);

        // Căn giữa màn hình
        frame.setLocationRelativeTo(null);

        // Hiển thị cửa sổ
        frame.setVisible(true);
    }
}
