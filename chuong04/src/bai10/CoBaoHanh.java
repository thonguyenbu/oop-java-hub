package bai10;

/*
 * Bài 10 - Mở rộng ví dụ tổng hợp: dịch vụ, bảo hành, khách đại lý
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public interface CoBaoHanh {
    int soThangBaoHanh();
    default String dieuKienBaoHanh() {
        return "Bảo hành " + soThangBaoHanh()
               + " tháng, không áp dụng cho hư hỏng do người dùng.";
    }
}
