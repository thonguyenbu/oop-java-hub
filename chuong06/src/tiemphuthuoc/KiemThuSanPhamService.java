package tiemphuthuoc;

/*
 * Mục 6.10.1 - Tiêm phụ thuộc: kiểm thử tầng nghiệp vụ không cần CSDL
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 6 - Xây dựng ứng dụng hướng đối tượng
 */

import chung.*;
import java.math.BigDecimal;
import java.util.Locale;

public class KiemThuSanPhamService {
    public static void main(String[] args) throws Exception {
        SanPhamService dichVu =
                new SanPhamService(new KhoSanPhamBoNho());

        dichVu.themSanPham(new SanPham("SP001", "Cà phê hòa tan G7",
                new BigDecimal("65000"), 120));
        dichVu.themSanPham(new SanPham("SP002", "Bánh quy bơ",
                new BigDecimal("42000"), 85));

        System.out.printf(Locale.forLanguageTag("vi-VN"),
                "Tổng giá trị tồn kho: %,.0f%n", dichVu.tongGiaTriTonKho());

        try {
            dichVu.themSanPham(new SanPham("SP001", "Trùng mã",
                    new BigDecimal("1000"), 1));
        } catch (IllegalArgumentException e) {
            System.out.println("Bắt đúng lỗi: " + e.getMessage());
        }
        try {
            dichVu.themSanPham(new SanPham("SP003", "Đơn giá âm",
                    new BigDecimal("-5"), 1));
        } catch (IllegalArgumentException e) {
            System.out.println("Bắt đúng lỗi: " + e.getMessage());
        }
    }
}
