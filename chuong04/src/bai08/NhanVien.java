package bai08;

/*
 * Bài 8 - Kết hợp lớp trừu tượng với giao diện CoThuong
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public abstract class NhanVien {
    private final String maNhanVien;
    private String hoTen;
    protected double luongCoBan;
 
    public NhanVien(String maNhanVien, String hoTen, double luongCoBan) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.luongCoBan = luongCoBan;
    }
 
    public abstract double tinhLuong();
    public String getHoTen() { return hoTen; }
 
    public double tongThuNhap() {
        double thuong = (this instanceof CoThuong ct) ? ct.tienThuongThucNhan() : 0;
        return tinhLuong() + thuong;
    }
 
    @Override public String toString() {
        return String.format("%-6s %-18s %-16s %14.0f %14.0f",
                maNhanVien, hoTen, getClass().getSimpleName(), tinhLuong(), tongThuNhap());
    }
}
