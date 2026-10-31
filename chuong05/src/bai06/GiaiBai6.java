package bai06;

/*
 * Bài 6 - Tổng hợp doanh thu theo khách hàng bằng TreeMap
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import chung.*;
import java.math.BigDecimal;
import java.util.*;

public class GiaiBai6 {
    public static void main(String[] args) {
        List<DonHang> ds = DonHang.duLieuMau();

        Map<String, BigDecimal> doanhThu = new TreeMap<>();
        for (DonHang d : ds) {
            String kh = d.getMaKhachHang();
            doanhThu.put(kh, doanhThu.getOrDefault(kh, BigDecimal.ZERO).add(d.getTongTien()));
        }

        System.out.println("Bài 6 - doanh thu theo khách hàng (TreeMap):");
        for (Map.Entry<String, BigDecimal> m : doanhThu.entrySet())
            System.out.printf("  %-8s %14s%n", m.getKey(), m.getValue().toPlainString());
    }
}
