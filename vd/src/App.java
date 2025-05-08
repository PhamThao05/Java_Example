import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Thông tin sinh viên");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel chính dùng BoxLayout dọc
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel nameLabel = new JLabel("Họ tên: Phạm Thị Thảo");
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel mssvLabel = new JLabel("Mã sinh viên: 20222082");
        mssvLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Load và resize icon
        ImageIcon icon = new ImageIcon("src/wv5zuffp.png");
        Image scaled = icon.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaled);

        JButton button = new JButton("Phạm Thị Thảo", resizedIcon);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Thêm thành phần vào panel
        mainPanel.add(Box.createVerticalGlue()); // Đẩy nội dung vào giữa
        mainPanel.add(nameLabel);
        mainPanel.add(mssvLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Khoảng cách
        mainPanel.add(button);
        mainPanel.add(Box.createVerticalGlue());

        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
