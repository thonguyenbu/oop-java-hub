package vd23;

import java.util.Locale;
public class DinhDangSo {
    public static void main(String[] args) {
        Locale vn = Locale.forLanguageTag("vi-VN");
        System.out.printf(vn, "Thành tiền: %,.0f đ%n", 59700.0);
        System.out.printf(vn, "Tỉ lệ:      %.1f%%%n", 8.0);
    }
}
