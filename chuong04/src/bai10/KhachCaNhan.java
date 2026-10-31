package bai10;

/*
 * Bài 10 - Mở rộng ví dụ tổng hợp: dịch vụ, bảo hành, khách đại lý
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class KhachCaNhan extends KhachHang {
    private String hang;
    public KhachCaNhan(String ma, String ten, String hang) {
        super(ma, ten);
        this.hang = hang;
    }
    @Override public double tiLeChietKhau() {
        return switch (hang) {
            case "VANG" -> 0.10;
            case "BAC"  -> 0.05;
            default     -> 0.02;
        };
    }
}
