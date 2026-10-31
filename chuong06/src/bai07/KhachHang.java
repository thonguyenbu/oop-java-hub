package bai07;

/*
 * Bài 7 - Ứng dụng quản lý bán hàng hoàn chỉnh
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 6 - Xây dựng ứng dụng hướng đối tượng
 */

import chung.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class KhachHang {
    private final String maKhachHang;
    private String hoTen;
    private String hangThanhVien;
 
    public KhachHang(String ma, String hoTen, String hang) {
        this.maKhachHang = ma; this.hoTen = hoTen; this.hangThanhVien = hang;
    }
    public String getMaKhachHang()   { return maKhachHang; }
    public String getHoTen()         { return hoTen; }
    public String getHangThanhVien() { return hangThanhVien; }
 
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KhachHang)) return false;
        return maKhachHang.equals(((KhachHang) o).maKhachHang);
    }
    @Override public int hashCode() { return Objects.hash(maKhachHang); }
}
