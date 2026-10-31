package vd253;

import java.util.Locale;
public class TinhTien {
    static double tinhThanhTien(double donGia, int soLuong) {
        return donGia * soLuong;
    }
    static double tinhThanhTien(double donGia, int soLuong, double tiLeChietKhau) {
        return donGia * soLuong * (1 - tiLeChietKhau);
    }
    public static void main(String[] args) {
        Locale vn = Locale.forLanguageTag("vi-VN");
        System.out.printf(vn, "Không chiết khấu: %,.0f đ%n", tinhThanhTien(19_900, 3));
        System.out.printf(vn, "Chiết khấu 10%%:   %,.0f đ%n", tinhThanhTien(19_900, 3, 0.10));
    }
}
