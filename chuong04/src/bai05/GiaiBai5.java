package bai05;

/*
 * Bài 5 - Lớp trừu tượng TaiKhoan và ba loại tài khoản
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

import java.util.Locale;

public class GiaiBai5 {
    public static void main(String[] args) {
        Locale vn = Locale.forLanguageTag("vi-VN");
        TaiKhoan[] ds = {
            new TaiKhoanThanhToan("TK00001", 15_000_000),
            new TaiKhoanTietKiemKyHan("TK00002", 300_000_000, 12),
            new TaiKhoanTietKiemKyHan("TK00003", 80_000_000, 6),
            new TaiKhoanTietKiemKhongKyHan("TK00004", 45_000_000)
        };
        System.out.printf("%-10s %-22s %14s %7s %14s%n",
                "SỐ TK", "LOẠI", "SỐ DƯ", "LÃI/NĂM", "TIỀN LÃI");
        double tongLai = 0;
        for (TaiKhoan tk : ds) {
            System.out.println(tk);
            tongLai += tk.tienLaiMotNam();
        }
        System.out.printf(vn, "%-55s %,14.0f%n", "TỔNG TIỀN LÃI PHẢI TRẢ:", tongLai);
    }
}
