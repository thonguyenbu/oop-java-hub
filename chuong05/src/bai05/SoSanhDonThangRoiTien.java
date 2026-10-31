package bai05;

/*
 * Bài 5 - Hai Comparator cho lớp DonHang
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import chung.*;
import java.util.Comparator;

public class SoSanhDonThangRoiTien implements Comparator<DonHang> {
    @Override public int compare(DonHang a, DonHang b) {
        int theoThang = Integer.compare(a.getThang(), b.getThang());
        if (theoThang != 0) return theoThang;
        return b.getTongTien().compareTo(a.getTongTien());   // giảm dần
    }
}
