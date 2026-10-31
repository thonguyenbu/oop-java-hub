package bai10;

/*
 * Bài 10 - Mở rộng ví dụ tổng hợp: dịch vụ, bảo hành, khách đại lý
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class KhachDoanhNghiep extends KhachHang {
    private double doanhSoNam;
    public KhachDoanhNghiep(String ma, String ten, double doanhSoNam) {
        super(ma, ten);
        this.doanhSoNam = doanhSoNam;
    }
    @Override public double tiLeChietKhau() {
        return doanhSoNam >= 1_000_000_000.0 ? 0.12 : 0.06;
    }
}
