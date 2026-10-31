package bai02;

/*
 * Bài 2 - Hai phương thức tổng quát có giới hạn khác nhau
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import chung.*;
import java.math.BigDecimal;
import java.util.List;

public class TienIch {

    public static <T extends SanPham> int demSanPhamDatGia(List<T> ds, BigDecimal nguong) {
        int dem = 0;
        for (T sp : ds) if (sp.getDonGia().compareTo(nguong) >= 0) dem++;
        return dem;
    }

    public static <T extends Comparable<T>> T nhoNhat(List<T> ds) {
        if (ds == null || ds.isEmpty()) return null;
        T min = ds.get(0);
        for (T x : ds) if (x.compareTo(min) < 0) min = x;
        return min;
    }
}
