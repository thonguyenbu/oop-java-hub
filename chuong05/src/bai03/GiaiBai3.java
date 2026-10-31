package bai03;

/*
 * Bài 3 - Phương thức sanhChep với ? extends và ? super
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import chung.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GiaiBai3 {
    public static void main(String[] args) {
        List<SanPhamVatLy> nguon = List.of(
            new SanPhamVatLy("SP001", "Cà phê hòa tan G7", new BigDecimal("65000"), 120),
            new SanPhamVatLy("SP002", "Bánh quy bơ",       new BigDecimal("42000"),  85),
            new SanPhamVatLy("SP003", "Nước suối 500ml",   new BigDecimal("6000"),  500));

        List<SanPham> dich = new ArrayList<>();
        dich.add(new SanPhamSo("SP005", "Phần mềm kế toán",
                               new BigDecimal("2400000"), 365));

        SaoChep.<SanPham>sanhChep(nguon, dich);

        System.out.println("Bài 3:");
        System.out.println("  Sau khi sao chép, danh mục có " + dich.size() + " sản phẩm:");
        for (SanPham sp : dich) System.out.println("    " + sp);
    }
}
