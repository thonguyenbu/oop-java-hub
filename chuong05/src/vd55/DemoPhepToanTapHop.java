package vd55;

/*
 * Ví dụ 5.5 - Set, vai trò của equals/hashCode và các phép toán tập hợp
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DemoPhepToanTapHop {
    public static void main(String[] args) {
        Set<String> thang1 = new TreeSet<>(List.of("KH001", "KH002", "KH003"));
        Set<String> thang2 = new TreeSet<>(List.of("KH002", "KH003", "KH004", "KH005"));

        Set<String> hop = new TreeSet<>(thang1);
        hop.addAll(thang2);                       // phép hợp

        Set<String> giao = new TreeSet<>(thang1);
        giao.retainAll(thang2);                   // phép giao

        Set<String> hieu = new TreeSet<>(thang1);
        hieu.removeAll(thang2);                   // phép hiệu

        System.out.printf("  %-19s: %s%n", "Tháng 1", thang1);
        System.out.printf("  %-19s: %s%n", "Tháng 2", thang2);
        System.out.printf("  %-19s: %s%n", "Hợp (mua ít nhất 1)", hop);
        System.out.printf("  %-19s: %s%n", "Giao (mua cả 2)", giao);
        System.out.printf("  %-19s: %s%n", "Chỉ mua tháng 1", hieu);
    }
}
