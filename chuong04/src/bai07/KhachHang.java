package bai07;

/*
 * Bài 7 - Quan hệ has-a giữa HoaDon và KhachHang
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class KhachHang {
    private String maKhachHang;
    private String hoTen;
    private String hangThanhVien;

    public KhachHang(String ma, String hoTen, String hang) {
        this.maKhachHang = ma;
        this.hoTen = hoTen;
        this.hangThanhVien = hang;
    }
    public String getTen() { return hoTen; }
    public double tiLeChietKhau() {
        return switch (hangThanhVien) {
            case "VANG" -> 0.10;
            case "BAC"  -> 0.05;
            default     -> 0.0;
        };
    }
}
