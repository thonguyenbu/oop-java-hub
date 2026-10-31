package bai01;

/*
 * Bài 1 - Phân cấp PhuongTien, XeMay, OTo
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

import java.util.Locale;

public class GiaiBai1 {
    public static void main(String[] args) {
        Locale vn = Locale.forLanguageTag("vi-VN");
        PhuongTien[] doi = {
            new XeMay("59-H1 123.45", 120_000),
            new OTo("51G-678.90", 900_000, 4),
            new OTo("51H-111.22", 1_400_000, 7)
        };
        System.out.printf("%-12s %-14s %12s %14s%n",
                "BIỂN SỐ", "LOẠI", "GIÁ/NGÀY", "THUÊ 10 NGÀY");
        for (PhuongTien pt : doi) {
            System.out.printf(vn, "%s %,14.0f%n", pt, pt.tinhTienThue(10));
        }
    }
}
