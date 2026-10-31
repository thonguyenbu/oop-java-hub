package vd42;

/*
 * Ví dụ 4.2 - Phân cấp ConNguoi và thứ tự chạy hàm khởi tạo
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class NhanVien extends ConNguoi {
    private String maNhanVien;
    protected double luongCoBan;

    public NhanVien(String maNhanVien, String hoTen, String soDienThoai,
                    String diaChi, double luongCoBan) {
        super(hoTen, soDienThoai, diaChi);
        this.maNhanVien = maNhanVien;
        this.luongCoBan = luongCoBan;
    }

    public double tinhLuong() { return luongCoBan; }

    public String getMaNhanVien() { return maNhanVien; }
}
