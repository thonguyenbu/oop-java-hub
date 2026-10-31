package bai07;

/*
 * Bài 7 - Ba phép toán tập hợp trên mã khách hàng
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import chung.*;
import java.util.*;

public class GiaiBai7 {
    public static void main(String[] args) {
        List<DonHang> ds = DonHang.duLieuMau();

        Set<String> thang1 = new TreeSet<>(), thang2 = new TreeSet<>();
        for (DonHang d : ds) (d.getThang() == 1 ? thang1 : thang2).add(d.getMaKhachHang());

        Set<String> caHai = new TreeSet<>(thang1);
        caHai.retainAll(thang2);
        Set<String> chiThang2 = new TreeSet<>(thang2);
        chiThang2.removeAll(thang1);

        System.out.println("Bài 7 - khách hàng mua ở cả hai tháng:");
        System.out.println("  Tháng 1     : " + thang1);
        System.out.println("  Tháng 2     : " + thang2);
        System.out.println("  Mua cả hai  : " + caHai);
        System.out.println("  Chỉ tháng 2 : " + chiThang2);
    }
}
