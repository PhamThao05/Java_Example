USE master;
DROP DATABASE IF EXISTS QL_SACH;
DROP TABLE IF EXISTS THU_THU;
DROP TABLE IF EXISTS CHI_TIET_PHIEU_MUON;
DROP TABLE IF EXISTS TAC_GIA;
DROP TABLE IF EXISTS TheLoai;


CREATE DATABASE QL_SACH;
GO
USE QL_SACH;
GO

-- Bảng Tác giả
-- Bảng Tác giả
CREATE TABLE TAC_GIA (
    ma_tac_gia INT IDENTITY(1,1) PRIMARY KEY,
    ten_tac_gia NVARCHAR(255) NOT NULL
);
GO

-- Bảng Thể loại
CREATE TABLE THE_LOAI (
    ma_the_loai INT IDENTITY(1,1) PRIMARY KEY,
    ten_the_loai NVARCHAR(255) NOT NULL
);
GO

-- Bảng Sách
CREATE TABLE SACH (
    ma_sach INT IDENTITY(1,1) PRIMARY KEY,
    ten_sach NVARCHAR(255) NOT NULL,
    ngon_ngu NVARCHAR(255) NOT NULL,
    gia_tri FLOAT,
    so_luong INT,
    ma_tac_gia INT,
    ma_the_loai INT,
    nxb NVARCHAR(255) NOT NULL,
    nam_xuat_ban DATE,
    FOREIGN KEY (ma_tac_gia) REFERENCES TAC_GIA(ma_tac_gia),
    FOREIGN KEY (ma_the_loai) REFERENCES THE_LOAI(ma_the_loai)
);
GO

-- Bảng Thủ thư
CREATE TABLE THU_THU (
    ma_thu_thu INT IDENTITY(1,1) PRIMARY KEY,
    ten_thu_thu NVARCHAR(255) NOT NULL,
    cmnd VARCHAR(20) NOT NULL,
    sdt VARCHAR(20) NOT NULL,
    email NVARCHAR(255) NOT NULL,
    password NVARCHAR(255) NOT NULL,
    Phanquyen NVARCHAR(50) NOT NULL DEFAULT 'THU_THU'
);
GO

-- Bảng Lịch sử
CREATE TABLE LichSu (
    id INT IDENTITY(1,1) PRIMARY KEY,
    maThuThu INT,
    hanhDong NVARCHAR(255),
    thoiGian DATETIME,
    ghiChu NVARCHAR(255)
);
GO

-- Bảng Độc giả
CREATE TABLE DOC_GIA (
    ma_doc_gia INT IDENTITY(1,1) PRIMARY KEY,
    ten_doc_gia NVARCHAR(255) NOT NULL,
    ngay_sinh DATE,
    dia_chi NVARCHAR(255) NOT NULL,
    cmnd VARCHAR(20) NOT NULL,
    sdt VARCHAR(20) NOT NULL
);
GO

-- Bảng Phiếu mượn
CREATE TABLE PHIEU_MUON (
    ma_phieu_muon INT IDENTITY(1,1) PRIMARY KEY,
    ma_thu_thu INT,
    ma_doc_gia INT,
    ngay_muon DATE DEFAULT GETDATE(),
    ngay_hen_tra DATE,
    ngay_tra DATE NULL,
    trang_thai TINYINT, -- 0: Đang mượn, 1: Đã trả
    FOREIGN KEY (ma_thu_thu) REFERENCES THU_THU(ma_thu_thu),
    FOREIGN KEY (ma_doc_gia) REFERENCES DOC_GIA(ma_doc_gia)
);
GO

-- Bảng Chi tiết phiếu mượn
CREATE TABLE CHI_TIET_PHIEU_MUON (
    ma_chi_tiet INT IDENTITY(1,1) PRIMARY KEY,
    ma_phieu_muon INT,
    ma_sach INT,
    so_luong INT,
    FOREIGN KEY (ma_phieu_muon) REFERENCES PHIEU_MUON(ma_phieu_muon),
    FOREIGN KEY (ma_sach) REFERENCES SACH(ma_sach)
);
GO

-- Thêm dữ liệu vào bảng Tác giả
INSERT INTO TAC_GIA (ten_tac_gia) VALUES
(N'Nguyễn Văn A'),
(N'Trần Thị B'),
(N'Tô Hoài');
GO

-- Thêm dữ liệu vào bảng Thể loại
INSERT INTO THE_LOAI (ten_the_loai) VALUES
(N'Giáo trình'),
(N'Văn học');
GO

-- Thêm dữ liệu vào bảng Sách
INSERT INTO SACH (ten_sach, ngon_ngu, gia_tri, so_luong, ma_tac_gia, ma_the_loai, nxb, nam_xuat_ban) VALUES
(N'Lập Trình C Căn Bản', N'Tiếng Việt', 100000, 50, 1, 1, N'NXB Giáo Dục', '1990-01-01'),
(N'Học Python Trong 24 Giờ', N'Tiếng Việt', 150000, 30, 2, 1, N'NXB Trẻ', '1985-06-15'),
(N'Dế Mèn Phiêu Lưu Ký', N'Tiếng Việt', 50000, 70, 3, 2, N'NXB Kim Đồng', '1995-12-30');
GO

-- Thêm dữ liệu vào bảng Thủ thư
INSERT INTO THU_THU (ten_thu_thu, cmnd, sdt, email, password) VALUES
(N'Nguyễn Văn Thủ Thư', '123456789', '0987654321', 'thu@thu.com', 'thu123');

INSERT INTO THU_THU (ten_thu_thu, cmnd, sdt, email, password, Phanquyen) VALUES
(N'Nguyễn Văn A', '123456789', '0123456789', 'admin2@gmail.com', 'admin1234', 'ADMIN');
GO

-- Thêm dữ liệu vào bảng Độc giả
INSERT INTO DOC_GIA (ten_doc_gia, ngay_sinh, dia_chi, cmnd, sdt) VALUES
(N'Nguyễn Văn C', '1990-01-01', N'Hà Nội', '123456789', '0987654321'),
(N'Trần Thị D', '1985-06-15', N'TP Hồ Chí Minh', '987654321', '0912345678'),
(N'Lê Văn E', '1995-12-30', N'Đà Nẵng', '456123789', '0934567890');
GO

-- Thêm dữ liệu vào bảng Phiếu mượn
INSERT INTO PHIEU_MUON (ma_thu_thu, ma_doc_gia, ngay_muon, ngay_hen_tra, ngay_tra, trang_thai) VALUES
(1, 1, '2023-08-01', '2023-08-15', NULL, 0),
(1, 2, '2023-09-05', '2023-09-20', '2023-09-19', 1),
(1, 3, '2023-08-10', '2023-08-25', NULL, 0);
GO

-- Thêm dữ liệu vào bảng Chi tiết phiếu mượn
INSERT INTO CHI_TIET_PHIEU_MUON (ma_phieu_muon, ma_sach, so_luong) VALUES
(1, 1, 1),
(1, 2, 1),
(1, 3, 1);
GO

	-- Thống kê số lượng sách, tên độc giả, thủ thư, ngày mượn, ngày hẹn trả, và tình trạng mượn
SELECT 
    S.ten_sach,
	DG.ten_doc_gia,
    TT.ten_thu_thu,
    PM.ngay_muon,
    PM.ngay_hen_tra,
    S.so_luong AS tong_so_sach,
    COALESCE(SUM(CASE 
                 WHEN PM.trang_thai = 0 THEN CTPM.so_luong 
                 END), 0) AS so_luong_da_cho_muon,
    COALESCE(SUM(CASE 
                 WHEN PM.trang_thai = 1 THEN CTPM.so_luong 
                 END), 0) AS so_luong_da_tra,
    (S.so_luong - COALESCE(SUM(CASE 
                 WHEN PM.trang_thai = 0 THEN CTPM.so_luong 
                 END), 0)) AS so_luong_con_lai,
    
    CASE
        -- Trường hợp sách chưa trả và quá hạn
        WHEN PM.trang_thai = 0 AND GETDATE() > PM.ngay_hen_tra THEN 
            N'Quá hạn ' + CAST(DATEDIFF(DAY, PM.ngay_hen_tra, GETDATE()) AS NVARCHAR) + N' ngày'
        
        -- Trường hợp sách chưa trả và còn trong thời hạn mượn
        WHEN PM.trang_thai = 0 AND GETDATE() <= PM.ngay_hen_tra THEN 
            N'Còn ' + CAST(DATEDIFF(DAY, GETDATE(), PM.ngay_hen_tra) AS NVARCHAR) + N' ngày'
        
        -- Trường hợp sách đã trả
        ELSE N'Đã trả'
    END AS tinh_trang,
	-- Cột tiền phạt: Chỉ áp dụng khi quá hạn và sách chưa trả
    CASE
        WHEN PM.trang_thai = 0 AND GETDATE() > PM.ngay_hen_tra THEN 
            DATEDIFF(DAY, PM.ngay_hen_tra, GETDATE()) * 5000
        ELSE 0
    END AS tien_phat
