package vd26;

import java.text.NumberFormat;
import java.util.Locale;
public class DinhDangTien {
    public static void main(String[] args) {
        Locale vn = Locale.forLanguageTag("vi-VN");
        NumberFormat dinhDang = NumberFormat.getCurrencyInstance(vn);
        System.out.println(dinhDang.format(59700));
        System.out.printf(vn, "%,.0f đ%n", 133822558.08);
    }
}
