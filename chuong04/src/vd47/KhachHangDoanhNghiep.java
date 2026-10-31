package vd47;

/*
 * Ví dụ 4.7 - Giao diện CoChietKhau và CoTheXuatHoaDon
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class KhachHangDoanhNghiep implements CoChietKhau, CoTheXuatHoaDon {
    private String tenCongTy;
    private String maSoThue;
    private double doanhSoNam;
 
    public KhachHangDoanhNghiep(String tenCongTy, String maSoThue, double doanhSoNam) {
        this.tenCongTy = tenCongTy;
        this.maSoThue = maSoThue;
        this.doanhSoNam = doanhSoNam;
    }
 
    @Override
    public double tiLeChietKhau() {
        if (doanhSoNam >= 5_000_000_000.0) return 0.15;
        if (doanhSoNam >= 1_000_000_000.0) return 0.08;
        return 0.03;
    }
 
    @Override
    public String noiDungHoaDon() {
        return "Hóa đơn GTGT - " + tenCongTy + " - MST " + maSoThue;
    }
}
