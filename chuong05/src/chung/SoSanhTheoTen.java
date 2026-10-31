package chung;

/*
 * Lớp dùng chung - Các lớp nghiệp vụ dùng chung cho toàn Chương 5
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class SoSanhTheoTen implements Comparator<SanPham> {
    private final Collator collator = Collator.getInstance(Locale.forLanguageTag("vi-VN"));
 
    @Override
    public int compare(SanPham a, SanPham b) {
        return collator.compare(a.getTenSanPham(), b.getTenSanPham());
    }
}
