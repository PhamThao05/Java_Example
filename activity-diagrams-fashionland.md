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

    flowchart TD
A([Bắt đầu]) --> B[NVBH mở phiên bán hàng]
B --> C[Quét mã SP / tìm kiếm]
C --> D{Tìm thấy SP?}
D -- Không --> D1[Thông báo không tìm thấy] --> C
D -- Có --> E[Thêm vào giỏ; HT kiểm tra tồn kho]
E --> F{Còn hàng?}
F -- Không --> F1[Thông báo hết hàng; đề xuất SP thay thế] --> C
F -- Có --> G[Nhập số lượng, áp mã KM/Voucher]
G --> H{Voucher hợp lệ?}
H -- Không --> H1[Thông báo không hợp lệ] --> G
H -- Có --> I[HT tính tổng tiền, thuế, chiết khấu]
I --> J[Chọn phương thức thanh toán]
J --> K{Tiền mặt/Quẹt thẻ/QR/Chuyển khoản}
K --> L[HT gửi yêu cầu tới CTT (nếu không dùng tiền mặt)]
L --> M{Kết quả thanh toán?}
M -- Thất bại --> M1[Thông báo lỗi/Thử lại/Đổi phương thức] --> J
M -- Thành công hoặc Tiền mặt --> N[HT phát hành hóa đơn & cập nhật tồn kho]
N --> O[In/ gửi e-receipt cho KH]
O --> P([Kết thúc])
