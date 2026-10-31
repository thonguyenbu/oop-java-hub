/*
 * Bài 3 - Tính thành tiền, thuế VAT 8% và tổng phải trả
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 2 - Cơ bản về ngôn ngữ lập trình Java
 *
 * Biên dịch: javac -encoding UTF-8 -d bin <đường dẫn tệp>
 */
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

public class Bai3 {
    public static void main(String[] args) {
        Locale vn = Locale.forLanguageTag("vi-VN");

        BigDecimal donGia  = new BigDecimal("65000");
        int soLuong = 7;
        final BigDecimal THUE_SUAT_VAT = new BigDecimal("0.08");

        BigDecimal thanhTien = donGia.multiply(BigDecimal.valueOf(soLuong));
        BigDecimal tienThue  = thanhTien.multiply(THUE_SUAT_VAT)
                                        .setScale(0, RoundingMode.HALF_UP);
        BigDecimal tongCong  = thanhTien.add(tienThue);

        System.out.printf(vn, "%-22s %,15.0f đ%n", "Đơn giá:", donGia);
        System.out.printf(vn, "%-22s %,15d%n",    "Số lượng:", soLuong);
        System.out.println("-".repeat(42));
        System.out.printf(vn, "%-22s %,15.0f đ%n", "Thành tiền:", thanhTien);
        System.out.printf(vn, "%-22s %,15.0f đ%n", "Thuế VAT 8%:", tienThue);
        System.out.printf(vn, "%-22s %,15.0f đ%n", "TỔNG PHẢI TRẢ:", tongCong);
    }
}
