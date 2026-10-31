package vd53;

/*
 * Ví dụ 5.3 - Phương thức tổng quát và kiểu có giới hạn
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import java.math.BigDecimal;
import java.util.List;
import chung.*;

public class ThongKe {
 
    // Phương thức tổng quát: hoạt động với mảng bất kỳ kiểu nào
    public static <T> void inDanhSach(String tieuDe, T[] mang) {
        System.out.println(tieuDe);
        for (T p : mang) System.out.println("  " + p);
    }
 
    // Phương thức tổng quát có giới hạn: T phải so sánh được với chính nó
    public static <T extends Comparable<T>> T lonNhat(List<T> ds) {
        if (ds == null || ds.isEmpty()) return null;
        T max = ds.get(0);
        for (T p : ds) if (p.compareTo(max) > 0) max = p;
        return max;
    }
 
    // Giới hạn theo lớp miền nghiệp vụ
    public static <T extends SanPham> BigDecimal tongGiaTri(List<T> ds) {
        BigDecimal tong = BigDecimal.ZERO;
        for (T sp : ds) tong = tong.add(sp.getDonGia());
        return tong;
    }
}
