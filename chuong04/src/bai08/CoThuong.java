package bai08;

/*
 * Bài 8 - Kết hợp lớp trừu tượng với giao diện CoThuong
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public interface CoThuong {
    double MUC_THUONG_TOI_DA = 50_000_000;
    double tienThuong();
    default double tienThuongThucNhan() {
        return Math.min(tienThuong(), MUC_THUONG_TOI_DA);
    }
}
