## 1) Đăng nhập & Phân quyền
```mermaid
flowchart TD
    A([Bắt đầu]) --> B[NVBH/QLCH nhập tài khoản & mật khẩu]
    B --> C{HT kiểm tra định dạng?}
    C -- Không --> C1[Hiển thị lỗi định dạng] --> B
    C -- Có --> D[HT băm mật khẩu & tra DB]
    D --> E{Thông tin hợp lệ?}
    E -- Không --> E1[Hiển thị sai thông tin] --> B
    E -- Có --> F[HT tải vai trò & quyền]
    F --> G{Tài khoản bị khóa?}
    G -- Có --> G1[Thông báo bị khóa] --> H([Kết thúc])
    G -- Không --> I[HT tạo phiên đăng nhập + token]
    I --> J[Chuyển tới màn hình theo vai trò]
    J --> H([Kết thúc])
