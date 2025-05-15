package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    // Trang đăng ký
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String processRegister(@ModelAttribute User user) {
        // Bạn có thể lưu thông tin user vào CSDL ở đây
        // Demo: Chuyển về login sau khi đăng ký
        return "redirect:/login";
    }

    // Trang đăng nhập
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("error", null);
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username,
                               @RequestParam String password,
                               Model model) {

        System.out.println("Login attempt: " + username + " / " + password);

        // Kiểm tra tài khoản giả lập
        if ("admin".equals(username) && "123".equals(password)) {
            model.addAttribute("username", username);
            return "welcome"; // welcome.html
        } else {
            model.addAttribute("error", "Sai thông tin đăng nhập!");
            return "login"; // quay lại login.html kèm lỗi
        }
    }

    // Trang welcome (sau khi đăng nhập thành công)
    @GetMapping("/welcome")
    public String showWelcomePage() {
        return "welcome";
    }
}
