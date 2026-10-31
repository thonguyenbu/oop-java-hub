package vd55;

/*
 * Ví dụ 5.5 - Set, vai trò của equals/hashCode và các phép toán tập hợp
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import java.util.*;
import chung.*;

public class DemoBangBam {
    public static void main(String[] args) {
        Set<KhachHangKhongBam> tapA = new HashSet<>();
        tapA.add(new KhachHangKhongBam("KH001", "Nguyễn Văn An"));
        tapA.add(new KhachHangKhongBam("KH001", "Nguyễn Văn An"));
        System.out.println("=== (a) Quên ghi đè hashCode() ===");
        System.out.printf("  Số phần tử (đáng lẽ 1): %d%n", tapA.size());
        System.out.printf("  contains(KH001): %b%n",
                tapA.contains(new KhachHangKhongBam("KH001", "Nguyễn Văn An")));
 
        Set<KhachHang> tapB = new HashSet<>();
        tapB.add(new KhachHang("KH001", "Nguyễn Văn An"));
        tapB.add(new KhachHang("KH001", "Nguyễn Văn An"));
        System.out.println("=== (b) Ghi đè đủ equals và hashCode ===");
        System.out.printf("  Số phần tử: %d%n", tapB.size());
        System.out.printf("  contains(KH001): %b%n",
                tapB.contains(new KhachHang("KH001", "Nguyễn Văn An")));
    }
}
