package vd43;

/*
 * Ví dụ 4.3 – 4.5 - Đa hình, ghi đè, ép kiểu và toán tử instanceof
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

import java.util.Objects;

public class NhanVien {
    private final String maNhanVien;
    private String hoTen;
    protected double luongCoBan;
 
    public NhanVien(String maNhanVien, String hoTen, double luongCoBan) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.luongCoBan = luongCoBan;
    }
 
    public double tinhLuong() { return luongCoBan; }
 
    public String getMaNhanVien() { return maNhanVien; }
    public String getHoTen()      { return hoTen; }
 
    @Override
    public String toString() {
        return String.format("%-6s %-18s %14.0f", maNhanVien, hoTen, tinhLuong());
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NhanVien khac = (NhanVien) o;
        return maNhanVien.equals(khac.maNhanVien);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(maNhanVien);
    }
}
