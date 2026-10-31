package bai04;

/*
 * Bài 4 - Giao diện CoTinhThue với phương thức default
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

import java.util.Locale;

public class GiaiBai4 {
    public static void main(String[] args) {
        Locale vn = Locale.forLanguageTag("vi-VN");
        CoTinhThue[] cacKhoan = {
            new HangHoa("Cà phê hòa tan G7", 65_000, 4),
            new HangHoa("Máy xay cà phê", 1_250_000, 1),
            new DichVu("Phí lắp đặt", 300_000)
        };
        System.out.printf("%-14s %14s %14s%n", "TRƯỚC THUẾ", "THUẾ VAT", "SAU THUẾ");
        double tong = 0;
        for (CoTinhThue k : cacKhoan) {
            System.out.printf(vn, "%,14.0f %,14.0f %,14.0f%n",
                    k.giaTruocThue(), k.tienThue(), k.giaSauThue());
            tong += k.giaSauThue();
        }
        System.out.printf(vn, "%-29s %,14.0f%n", "TỔNG PHẢI THU:", tong);
    }
}
