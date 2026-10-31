-- Chương 6 - Lược đồ cơ sở dữ liệu MiniMart cho SQL Server
-- Chạy trước: CREATE DATABASE MiniMart;  rồi USE MiniMart;

CREATE TABLE SanPham (
    MaSanPham      VARCHAR(10)   NOT NULL PRIMARY KEY,
    TenSanPham     NVARCHAR(100) NOT NULL,
    DonGia         DECIMAL(18,2) NOT NULL,
    SoLuongTon     INT           NOT NULL,
    NgungKinhDoanh BIT           NOT NULL DEFAULT 0
);
 
CREATE TABLE KhachHang (
    MaKhachHang   VARCHAR(10)   NOT NULL PRIMARY KEY,
    HoTen         NVARCHAR(100) NOT NULL,
    HangThanhVien VARCHAR(20)   NOT NULL
);
 
CREATE TABLE DonHang (
    SoDon       INT IDENTITY(1,1) PRIMARY KEY,
    MaKhachHang VARCHAR(10)   NOT NULL,
    NgayDat     DATE          NOT NULL,
    TongTien    DECIMAL(18,2) NOT NULL
);
 
CREATE TABLE ChiTietDonHang (
    SoDon     INT           NOT NULL,
    MaSanPham VARCHAR(10)   NOT NULL,
    SoLuong   INT           NOT NULL,
    DonGiaBan DECIMAL(18,2) NOT NULL,
    PRIMARY KEY (SoDon, MaSanPham)
);
