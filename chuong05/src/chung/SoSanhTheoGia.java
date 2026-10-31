package chung;

/*
 * Lớp dùng chung - Các lớp nghiệp vụ dùng chung cho toàn Chương 5
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import java.util.Comparator;

public class SoSanhTheoGia implements Comparator<SanPham> {
    @Override
    public int compare(SanPham a, SanPham b) {
        return a.getDonGia().compareTo(b.getDonGia());
    }
}
