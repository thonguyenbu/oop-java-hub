package vd46;

/*
 * Ví dụ 4.6 - Lớp trừu tượng ThanhToan và ba hình thức thanh toán
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

import java.util.Locale;

public class DemoTruuTuong {
    public static void main(String[] args) {
        Locale vn = Locale.forLanguageTag("vi-VN");

        // ThanhToan tt = new ThanhToan("GD000", 100);  // LỖI: lớp trừu tượng

        ThanhToan[] cacGiaoDich = {
            new TienMat("GD001", 595_000),
            new TheTinDung("GD002", 1_250_000, "4111111111111234"),
            new ViDienTu("GD003", 320_000, "0901234567")
        };

        System.out.printf("%-10s %-22s %12s %10s %12s%n",
                "MÃ GD", "HÌNH THỨC", "SỐ TIỀN", "PHÍ", "TỔNG TRẢ");
        System.out.println("-".repeat(70));
        double tong = 0;
        for (ThanhToan tt : cacGiaoDich) {
            System.out.println(tt);
            tong += tt.tongPhaiTra();
        }
        System.out.println("-".repeat(70));
        System.out.printf(vn, "%-46s %,22.0f%n", "TỔNG CỘNG:", tong);

        System.out.println();
        System.out.println("Thực hiện lần lượt các giao dịch:");
        for (ThanhToan tt : cacGiaoDich) {
            tt.thucHien();
        }
    }
}
