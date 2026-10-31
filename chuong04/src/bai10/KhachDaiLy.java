package bai10;

/*
 * Bài 10 - Mở rộng ví dụ tổng hợp: dịch vụ, bảo hành, khách đại lý
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class KhachDaiLy extends KhachHang {
    public KhachDaiLy(String ma, String ten) { super(ma, ten); }
    @Override public double tiLeChietKhau() { return 0.18; }
    public int soLuongToiThieu() { return 10; }

    // Cách khắc phục nêu ở Câu 3: đưa quy tắc lên lớp cha rồi ghi đè
    @Override public boolean chapNhanSoLuong(int soLuong) { return soLuong >= 10; }
}
