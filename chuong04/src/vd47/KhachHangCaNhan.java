package vd47;

/*
 * Ví dụ 4.7 - Giao diện CoChietKhau và CoTheXuatHoaDon
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class KhachHangCaNhan implements CoChietKhau, CoTheXuatHoaDon {
    private String hoTen;
    private String hangThanhVien;

    public KhachHangCaNhan(String hoTen, String hangThanhVien) {
        this.hoTen = hoTen;
        this.hangThanhVien = hangThanhVien;
    }

    @Override
    public double tiLeChietKhau() {
        return switch (hangThanhVien) {
            case "VANG" -> 0.10;
            case "BAC"  -> 0.05;
            default     -> 0.02;
        };
    }

    @Override
    public String noiDungHoaDon() {
        return "Hóa đơn cá nhân - " + hoTen;
    }
}
