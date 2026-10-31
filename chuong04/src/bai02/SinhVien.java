package bai02;

/*
 * Bài 2 - Ghi đè toString, equals và hashCode
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

import java.util.Objects;

public class SinhVien {
    private final String maSoSinhVien;
    private String hoTen;
    private double diemTrungBinh;
 
    public SinhVien(String maSoSinhVien, String hoTen, double diemTrungBinh) {
        this.maSoSinhVien = maSoSinhVien;
        this.hoTen = hoTen;
        this.diemTrungBinh = (diemTrungBinh < 0 || diemTrungBinh > 4) ? 0 : diemTrungBinh;
    }
 
    @Override
    public String toString() {
        return String.format("%-10s %-20s %4.2f", maSoSinhVien, hoTen, diemTrungBinh);
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinhVien khac = (SinhVien) o;
        return maSoSinhVien.equals(khac.maSoSinhVien);
    }
 
    @Override
    public int hashCode() { return Objects.hash(maSoSinhVien); }
}
