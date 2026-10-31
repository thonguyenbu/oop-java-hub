package chung;

/*
 * Lớp dùng chung - Các lớp nghiệp vụ dùng chung cho toàn Chương 5
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import java.util.Objects;

public class KhachHang {
    private final String maKhachHang;
    private final String hoTen;

    public KhachHang(String maKhachHang, String hoTen) {
        this.maKhachHang = maKhachHang;
        this.hoTen = hoTen;
    }
    public String getMaKhachHang() { return maKhachHang; }
    public String getHoTen()       { return hoTen; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KhachHang)) return false;
        return maKhachHang.equals(((KhachHang) o).maKhachHang);
    }
    @Override public int hashCode() { return Objects.hash(maKhachHang); }
    @Override public String toString() { return maKhachHang + " " + hoTen; }
}
