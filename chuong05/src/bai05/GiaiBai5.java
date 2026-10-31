package bai05;

/*
 * Bài 5 - Hai Comparator cho lớp DonHang
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import chung.*;
import java.util.ArrayList;
import java.util.List;

public class GiaiBai5 {
    public static void main(String[] args) {
        List<DonHang> ds = new ArrayList<>(DonHang.duLieuMau());

        ds.sort(new SoSanhDonTheoTien());
        System.out.println("Bài 5 - sắp theo tổng tiền tăng dần:");
        for (DonHang d : ds) System.out.println("  " + d);

        ds.sort(new SoSanhDonThangRoiTien());
        System.out.println("Bài 5 - sắp theo tháng rồi tiền giảm dần:");
        for (DonHang d : ds) System.out.println("  " + d);
    }
}
