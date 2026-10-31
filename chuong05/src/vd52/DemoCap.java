package vd52;

/*
 * Ví dụ 5.1 – 5.2 - Lớp tổng quát Kho<T>, Cap<K,V> và giao diện tổng quát
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import chung.*;
import java.math.BigDecimal;

public class DemoCap {
    public static void main(String[] args) {
        Cap<String, BigDecimal> capGia = new Cap<>("SP001", new BigDecimal("65000"));
        Cap<String, Integer> capTon = new Cap<>("SP001", 120);
        System.out.println("Cặp giá:   " + capGia);
        System.out.println("Cặp tồn:   " + capTon);

        System.out.println();
        KhoSanPhamBoNho kho = new KhoSanPhamBoNho();
        for (SanPham sp : DuLieuMau.danhMuc()) kho.them(sp);
        System.out.println("Giao diện tổng quát KhoDuLieu<SanPham>:");
        System.out.println("  tìm SP003 -> " + kho.timTheoMa("SP003").getTenSanPham());
        System.out.println("  tìm SP999 -> " + kho.timTheoMa("SP999"));
        System.out.println("  số phần tử -> " + kho.layTatCa().size());
    }
}
