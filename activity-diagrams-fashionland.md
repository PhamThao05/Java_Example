# Biểu đồ hoạt động hệ thống quản lý cửa hàng Fashionland

> File này dùng cho GitHub hoặc các nền tảng hỗ trợ Mermaid.

---

## 1) Đăng nhập & Phân quyền
```mermaid
flowchart TD
    A([Bắt đầu]) --> B[NVBH/QLCH nhập tài khoản & mật khẩu]
    B --> C{Kiểm tra định dạng?}
    C -- Không --> C1[Hiển thị lỗi định dạng] --> B
    C -- Có --> D[Tra DB để xác thực]
    D --> E{Thông tin hợp lệ?}
    E -- Không --> E1[Thông báo sai thông tin] --> B
    E -- Có --> F[Tải vai trò và quyền hạn]
    F --> G{Tài khoản bị khóa?}
    G -- Có --> G1[Thông báo bị khóa] --> H([Kết thúc])
    G -- Không --> I[Tạo phiên đăng nhập]
    I --> J[Chuyển đến giao diện phù hợp]
    J --> H([Kết thúc])
```

---

## 2) Bán hàng tại quầy (POS Checkout)
```mermaid
flowchart TD
    A([Bắt đầu]) --> B[NVBH mở phiên bán hàng]
    B --> C[Quét mã sản phẩm / tìm kiếm]
    C --> D{Tìm thấy sản phẩm?}
    D -- Không --> D1[Thông báo không tìm thấy] --> C
    D -- Có --> E[Thêm vào giỏ; kiểm tra tồn kho]
    E --> F{Còn hàng?}
    F -- Không --> F1[Thông báo hết hàng; đề xuất SP thay thế] --> C
    F -- Có --> G[Nhập số lượng, áp mã khuyến mãi/voucher]
    G --> H{Voucher hợp lệ?}
    H -- Không --> H1[Thông báo không hợp lệ] --> G
    H -- Có --> I[Tính tổng tiền, thuế, chiết khấu]
    I --> J[Chọn phương thức thanh toán]
    J --> K{Tiền mặt?}
    K -- Có --> N[Phát hành hóa đơn & cập nhật tồn kho]
    K -- Không --> L[Gửi yêu cầu tới cổng thanh toán]
    L --> M{Thanh toán thành công?}
    M -- Thất bại --> M1[Thông báo lỗi / đổi phương thức] --> J
    M -- Thành công --> N
    N --> O[In hoặc gửi e-receipt cho khách hàng]
    O --> P([Kết thúc])
```

---

## 3) Bán hàng online
```mermaid
flowchart TD
    A([Bắt đầu]) --> B[Khách hàng tạo giỏ hàng trên website/app]
    B --> C[Đăng nhập hoặc đăng ký tài khoản]
    C --> D[Nhập địa chỉ và chọn phương thức giao hàng]
    D --> E[Áp mã giảm giá / điểm tích lũy]
    E --> F[Tính phí giao hàng và tổng tiền]
    F --> G[Xác nhận đặt hàng]
    G --> H[Hệ thống giữ tồn kho tạm thời]
    H --> I[Thanh toán online hoặc COD]
    I --> J{Thanh toán thành công?}
    J -- Không --> J1[Chờ thanh toán hoặc hủy sau thời gian quy định]
    J -- Có --> K[Tạo đơn hàng chính thức]
    K --> L[Kho xử lý và đóng gói]
    L --> M[Giao hàng cho đơn vị vận chuyển]
    M --> N[Cập nhật trạng thái giao hàng]
    N --> O[Khách hàng nhận và xác nhận]
    O --> P([Kết thúc])
```

---

## 4) Quản lý sản phẩm
```mermaid
flowchart TD
    A([Bắt đầu]) --> B[Quản lý mở màn hình Sản phẩm]
    B --> C{Chọn hành động}
    C -- Tạo mới --> D[Nhập tên, SKU, thuộc tính, hình ảnh]
    D --> E[Thêm biến thể như size, màu]
    E --> F[Đặt giá, thuế, giá khuyến mãi]
    F --> G[Chọn danh mục và thương hiệu]
    G --> H[Lưu]
    C -- Cập nhật --> I[Chỉnh sửa thông tin, giá, ảnh, trạng thái]
    I --> H
    C -- Ẩn sản phẩm --> J[Đổi trạng thái Không bán]
    J --> H
    H --> K{Kiểm tra ràng buộc dữ liệu}
    K -- Lỗi --> K1[Hiển thị lỗi] --> C
    K -- Hợp lệ --> L[Ghi dữ liệu và reindex tìm kiếm]
    L --> M([Kết thúc])
```

---

## 5) Nhập hàng
```mermaid
flowchart TD
    A([Bắt đầu]) --> B[Tạo đơn mua hàng: nhà cung cấp, sản phẩm, số lượng, giá]
    B --> C[Phê duyệt đơn mua nếu cần]
    C --> D[Nhà cung cấp giao hàng]
    D --> E[Kiểm đếm và ghi nhận lô, hạn dùng]
    E --> F{Khớp với đơn mua?}
    F -- Không --> F1[Lập biên bản chênh lệch] --> G[Quyết định xử lý]
    F -- Có --> H[Nhập kho và cập nhật tồn kho, giá vốn]
    G --> H
    H --> I[Tạo chứng từ nhập và công nợ nhà cung cấp]
    I --> J([Kết thúc])
```

---

## 6) Quản lý tồn kho
```mermaid
flowchart TD
    A([Bắt đầu]) --> B[Chạy báo cáo tồn kho]
    B --> C{Có chênh lệch thực tế?}
    C -- Có --> D[Lập phiếu kiểm kê]
    D --> E[Nhập số liệu thực tế]
    E --> F[So sánh và đề xuất điều chỉnh]
    F --> G{Phê duyệt?}
    G -- Không --> B
    G -- Có --> H[Tạo phiếu điều chỉnh tồn]
    C -- Không --> I[Theo dõi cảnh báo: hết hạn, dưới mức tối thiểu]
    I --> J[Đề xuất nhập hoặc điều chuyển]
    H --> K([Kết thúc])
    J --> K
```

---

## 7) Thanh toán và hoàn tiền
```mermaid
flowchart TD
    A([Bắt đầu]) --> B[Chọn hóa đơn cần hoàn]
    B --> C[Kiểm tra điều kiện hoàn hoặc đổi]
    C --> D{Đủ điều kiện?}
    D -- Không --> D1[Thông báo từ chối] --> Z([Kết thúc])
    D -- Có --> E[Chọn sản phẩm và số lượng hoàn]
    E --> F[Cập nhật tồn kho dự kiến]
    F --> G[Chọn hình thức hoàn: tiền mặt, thẻ, ví]
    G --> H[Hệ thống hoặc cổng thanh toán xử lý hoàn]
    H --> I{Kết quả giao dịch?}
    I -- Lỗi --> I1[Thông báo lỗi và thử lại] --> G
    I -- Thành công --> J[Phát hành phiếu hoàn tiền hoặc credit note]
    J --> K([Kết thúc])
```

---

## 8) Quản lý khuyến mãi
```mermaid
flowchart TD
    A([Bắt đầu]) --> B[Tạo chương trình khuyến mãi]
    B --> C[Nhập điều kiện: thời gian, sản phẩm, mức giảm]
    C --> D{Theo voucher hay theo sản phẩm?}
    D -- Voucher --> E[Tạo dải mã và số lần sử dụng]
    D -- Theo SP --> F[Cấu hình quy tắc tính giảm giá]
    E --> G
    F --> G
    G[Phê duyệt & kích hoạt] --> H[Đồng bộ đến POS & website]
    H --> I[Áp dụng trong quá trình bán hàng]
    I --> J([Kết thúc])
```

---

## 9) Quản lý khách hàng
```mermaid
flowchart TD
    A([Bắt đầu]) --> B[Tạo hoặc cập nhật hồ sơ khách hàng]
    B --> C[Phân loại nhóm hoặc hạng khách hàng]
    C --> D[Tính điểm tích lũy và ưu đãi]
    D --> E[Gửi SMS/Email chăm sóc khách hàng]
    E --> F[Theo dõi phản hồi và lịch sử mua hàng]
    F --> G([Kết thúc])
```

---

## 10) Báo cáo và thống kê
```mermaid
flowchart TD
    A([Bắt đầu]) --> B[Chọn loại báo cáo]
    B --> C[Chọn bộ lọc: thời gian, cửa hàng, sản phẩm]
    C --> D[Trích xuất dữ liệu]
    D --> E[Tính KPI: doanh thu, lợi nhuận, tồn kho]
    E --> F[Hiển thị bảng hoặc biểu đồ]
    F --> G[Xuất file CSV, Excel, PDF]
    G --> H([Kết thúc])
```

---

## 11) Quản lý nhân viên và ca làm
```mermaid
flowchart TD
    A([Bắt đầu]) --> B[Tạo hồ sơ nhân viên]
    B --> C[Phân quyền theo vai trò]
    C --> D[Tạo ca làm việc và phân công]
    D --> E[Chấm công: checkin/checkout]
    E --> F[Tổng hợp công và tính thưởng doanh số]
    F --> G[Phê duyệt và khóa kỳ công]
    G --> H([Kết thúc])
```

---

## 12) Quản trị hệ thống và danh mục chung
```mermaid
flowchart TD
    A([Bắt đầu]) --> B[Quản trị danh mục: đơn vị tính, thuế, kho]
    B --> C[Quản lý người dùng và phân quyền]
    C --> D[Cấu hình tích hợp: cổng thanh toán, vận chuyển, email, SMS]
    D --> E[Sao lưu và phục hồi dữ liệu]
    E --> F[Theo dõi nhật ký hệ thống]
    F --> G([Kết thúc])
```
# Class Diagram kết hợp mô hình **ECB** – Hệ thống quản lý cửa hàng **FASHIONLAND**

> Xuất theo **PlantUML** để bạn render trực tiếp. Cấu trúc gồm 3 nhóm: **«boundary»** (UI/adapter), **«control»** (điều phối UC), **«entity»** (miền nghiệp vụ).

```plantuml
@startuml
skinparam shadowing false
skinparam linetype ortho
skinparam classAttributeIconSize 0
skinparam PackageStyle rectangle
skinparam class {
  BackgroundColor<<entity>> LightYellow
  BackgroundColor<<control>> LightBlue
  BackgroundColor<<boundary>> HoneyDew
}

' =================== BOUNDARY ===================
package "Boundary" <<Frame>> {
  class POSUI <<boundary>> {
    +scanBarcode(code)
    +applyVoucher(code)
    +selectPayment(method)
    +printReceipt(orderId)
  }
  class OnlineStoreUI <<boundary>> {
    +browseCatalog(q)
    +checkout(cart)
    +trackOrder(code)
  }
  class AdminPortalUI <<boundary>> {
    +login()
    +manageProducts()
    +managePromotions()
    +reports()
  }
  class PaymentGatewayAdapter <<boundary>> { +pay(amount, method): PaymentResult }
  class ShippingAdapter <<boundary>> { +createShipment(orderId) }
  class NotificationAdapter <<boundary>> { +send(channel, content) }
  class LoyaltyAdapter <<boundary>> { +addPoints(customerId, points) }
}

' =================== CONTROL ===================
package "Control" <<Frame>> {
  class AuthControl <<control>> {
    +authenticate(username, password)
    +assignRoles(userId, roles)
  }
  class ManageProductControl <<control>> {
    +createProduct(...)
    +updateProduct(...)
    +createVariant(...)
    +setPrices(...)
  }
  class PurchaseControl <<control>> {
    +createPO(supplierId, items)
    +receiveGRN(poId, items)
  }
  class InventoryControl <<control>> {
    +adjustStock(sku, qty, reason)
    +warnLowStock()
    +warnNearExpiry()
    +cycleCount(plan)
  }
  class POSCheckoutControl <<control>> {
    +addItem(sku, qty)
    +applyPromotion(orderId)
    +applyVoucher(code)
    +takePayment(orderId, method)
    +finalize(orderId)
  }
  class OnlineOrderControl <<control>> {
    +createOrder(cart, customerId)
    +confirmOnlinePayment(orderId, txn)
    +arrangeShipping(orderId)
  }
  class ReturnExchangeControl <<control>> {
    +createReturn(salesOrderId, items, reason)
    +processRefund(returnId)
    +createExchange(returnId, newItems)
  }
  class CustomerControl <<control>> {
    +classify(customerId)
    +recordFeedback(customerId, content)
    +purchaseHistory(customerId)
  }
  class PromotionControl <<control>> {
    +createCampaign(...)
    +issueVoucher(...)
    +evaluateRules(order)
  }
  class ReportControl <<control>> {
    +revenueReport(range)
    +inventoryReport(range)
    +topSelling(range)
  }
  class UserAdminControl <<control>> {
    +createUser(...)
    +assignRole(userId, role)
    +backup()
    +restore()
  }
}

' =================== ENTITY ===================
package "Entity" <<Frame>> {
  class Category <<entity>> { +id: long +name: String }
  class Brand <<entity>> { +id: long +name: String }
  class Product <<entity>> {
    +id: long
    +name: String
    +description: String
    +basePrice: Decimal
    +status: String
  }
  class ProductVariant <<entity>> {
    +sku: String
    +barcode: String
    +color: String
    +size: String
    +price: Decimal
    +status: VariantStatus
  }
  class Warehouse <<entity>> { +id: long +name: String +location: String }
  class Inventory <<entity>> {
    +id: long
    +sku: String
    +warehouseId: long
    +qtyOnHand: int
    +qtyAvailable: int
    +reorderPoint: int
    +expiryDate: Date?
  }
  class Supplier <<entity>> { +id: long +name: String +taxCode: String +phone: String +email: String }

  class PurchaseOrder <<entity>> {
    +id: long
    +code: String
    +orderDate: Date
    +status: POStatus
    +totalAmount: Decimal
  }
  class POItem <<entity>> { +id: long +sku: String +qtyOrdered: int +unitPrice: Decimal }
  class GoodsReceipt <<entity>> { +id: long +code: String +receivedDate: Date +status: GRNStatus }
  class GRNItem <<entity>> { +id: long +sku: String +qtyReceived: int +lot: String +expiryDate: Date? }

  class Customer <<entity>> { +id: long +code: String +name: String +phone: String +email: String +tier: String }
  class LoyaltyAccount <<entity>> { +id: long +points: int +tier: String }

  class SalesOrder <<entity>> {
    +id: long
    +code: String
    +channel: Channel
    +orderDate: DateTime
    +status: OrderStatus
    +subtotal: Decimal
    +discountTotal: Decimal
    +finalAmount: Decimal
  }
  class SalesItem <<entity>> { +id: long +sku: String +qty: int +unitPrice: Decimal +discount: Decimal }
  class Payment <<entity>> { +id: long +method: PaymentMethod +amount: Decimal +status: PaymentStatus +txnRef: String }

  class ReturnOrder <<entity>> { +id: long +type: ReturnType +reason: String +status: ReturnStatus }
  class ReturnItem <<entity>> { +id: long +sku: String +qty: int +refundAmount: Decimal }

  class PromotionCampaign <<entity>> {
    +id: long
    +name: String
    +type: PromotionType
    +startAt: DateTime
    +endAt: DateTime
    +active: boolean
  }
  class PromotionRule <<entity>> {
    +id: long
    +ruleType: RuleType
    +minAmount: Decimal
    +percent: Decimal
    +fixedAmount: Decimal
    +buyX: int
    +getY: int
  }
  class Voucher <<entity>> { +code: String +value: Decimal +type: VoucherType +expireAt: DateTime +status: String }

  class Employee <<entity>> { +id: long +fullName: String +phone: String }
  class Role <<entity>> { +id: long +name: String }
  class Permission <<entity>> { +id: long +name: String }
  class UserAccount <<entity>> { +id: long +username: String +passwordHash: String +isActive: boolean +lastLoginAt: DateTime }
  class AuditLog <<entity>> { +id: long +at: DateTime +actorId: long +action: String +target: String }

  enum VariantStatus { Active; Inactive }
  enum POStatus { Draft; Submitted; Approved; PartiallyReceived; FullyReceived; Cancelled }
  enum GRNStatus { Draft; Received; Reconciled }
  enum Channel { POS; ONLINE }
  enum OrderStatus { Draft; Confirmed; Paid; Fulfilled; Cancelled; Returned; PartiallyReturned }
  enum PaymentMethod { Cash; Card; QR; EWallet; COD; BankTransfer }
  enum PaymentStatus { Pending; Authorized; Captured; Refunded; Failed }
  enum ReturnType { Return; Exchange }
  enum ReturnStatus { Pending; Approved; Rejected; Refunded; Exchanged }
  enum PromotionType { Percentage; FixedAmount; BuyXGetY; Bundle }
  enum RuleType { OrderLevel; ItemLevel }
  enum VoucherType { Amount; Percent }
  enum StockMoveType { Receipt; Issue; AdjustInc; AdjustDec; TransferIn; TransferOut; ReturnToSupplier; ReturnFromCustomer }
}

' ===== Entity Relationships =====
Product "1" -- "*" ProductVariant : has
ProductVariant "1" -- "*" Inventory : stock
Inventory "*" --> "1" Warehouse
Product "*" --> "1" Brand
Product "*" -- "*" Category

PurchaseOrder "1" -- "*" POItem
POItem "*" --> "1" ProductVariant
GoodsReceipt "1" -- "*" GRNItem
GoodsReceipt --> PurchaseOrder
GRNItem --> ProductVariant

Customer "1" -- "0..1" LoyaltyAccount
SalesOrder "1" -- "*" SalesItem
SalesItem "*" --> "1" ProductVariant
SalesOrder "1" -- "*" Payment
SalesOrder "*" --> "0..1" Customer

ReturnOrder "1" -- "*" ReturnItem
ReturnOrder --> SalesOrder : original
ReturnItem --> ProductVariant

PromotionCampaign "1" -- "*" PromotionRule
Voucher "*" --> "0..1" Customer

UserAccount "1" -- "*" Role
Role "1" -- "*" Permission
Employee "1" -- "1" UserAccount
AuditLog ..> UserAccount

' ===== Control → Entity Dependencies =====
ManageProductControl --> Product
ManageProductControl --> ProductVariant
ManageProductControl --> Category
ManageProductControl --> Brand

PurchaseControl --> PurchaseOrder
PurchaseControl --> POItem
PurchaseControl --> GoodsReceipt
PurchaseControl --> GRNItem
PurchaseControl --> Supplier

InventoryControl --> Inventory
InventoryControl --> Warehouse
InventoryControl --> ProductVariant

POSCheckoutControl --> SalesOrder
POSCheckoutControl --> SalesItem
POSCheckoutControl --> Payment
POSCheckoutControl --> Voucher
POSCheckoutControl --> PromotionCampaign
POSCheckoutControl --> PromotionRule

OnlineOrderControl --> SalesOrder
OnlineOrderControl --> SalesItem
OnlineOrderControl --> Payment
OnlineOrderControl --> Customer
OnlineOrderControl --> Voucher
OnlineOrderControl --> PromotionCampaign

ReturnExchangeControl --> ReturnOrder
ReturnExchangeControl --> ReturnItem
ReturnExchangeControl --> SalesOrder

CustomerControl --> Customer
CustomerControl --> LoyaltyAccount
PromotionControl --> PromotionCampaign
PromotionControl --> PromotionRule
PromotionControl --> Voucher

ReportControl ..> SalesOrder
ReportControl ..> Payment
ReportControl ..> Inventory
ReportControl ..> ProductVariant

UserAdminControl --> UserAccount
UserAdminControl --> Role
UserAdminControl --> Permission
UserAdminControl --> AuditLog

' ===== Boundary → Control =====
POSUI ..> POSCheckoutControl
POSUI ..> ReturnExchangeControl
OnlineStoreUI ..> OnlineOrderControl
AdminPortalUI ..> ManageProductControl
AdminPortalUI ..> PurchaseControl
AdminPortalUI ..> InventoryControl
AdminPortalUI ..> PromotionControl
AdminPortalUI ..> ReportControl
AdminPortalUI ..> UserAdminControl

PaymentGatewayAdapter ..> POSCheckoutControl : pay()
ShippingAdapter ..> OnlineOrderControl : createShipment()
NotificationAdapter ..> OnlineOrderControl : notify()
LoyaltyAdapter ..> CustomerControl : addPoints()

@enduml
```

## Gợi ý mapping Use Case → Control (đối chiếu nhanh)

* **Đăng nhập & phân quyền** → `AuthControl`, `UserAdminControl`, `UserAccount/Role/Permission`.
* **Bán hàng tại quầy (POS)** → `POSCheckoutControl` + `PaymentGatewayAdapter` + `SalesOrder/Payment`.
* **Bán hàng online** → `OnlineOrderControl` + `ShippingAdapter`.
* **Nhập hàng** → `PurchaseControl` + `PurchaseOrder/GoodsReceipt`.
* **Quản lý khuyến mãi/voucher/điểm** → `PromotionControl`, `Voucher`, `PromotionCampaign/Rule`, `LoyaltyAccount`.
* **Báo cáo – thống kê** → `ReportControl` (doanh thu, tồn, bán chạy).

> Nếu cần, mình có thể xuất thêm bản **Mermaid** hoặc chuyển thành **.drawio**.
