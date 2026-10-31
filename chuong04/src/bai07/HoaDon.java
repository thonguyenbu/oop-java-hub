package bai07;

/*
 * Bài 7 - Quan hệ has-a giữa HoaDon và KhachHang
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class HoaDon {
    private final String soHoaDon;
    private final KhachHang khachHang;     // quan hệ has-a
    private double tongTien;
 
    public HoaDon(String soHoaDon, KhachHang khachHang, double tongTien) {
        this.soHoaDon = soHoaDon;
        this.khachHang = khachHang;
        this.tongTien = tongTien;
    }
 
    public double tienPhaiThu() {
        return tongTien * (1 - khachHang.tiLeChietKhau());
    }
 
    @Override
    public String toString() {
        return String.format("%-10s %-20s %14.0f %14.0f",
                soHoaDon, khachHang.getTen(), tongTien, tienPhaiThu());
    }
}
