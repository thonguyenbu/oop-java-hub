package bai02;

/*
 * Bài 2 - Hai phương thức tổng quát có giới hạn khác nhau
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import chung.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GiaiBai2 {
    public static void main(String[] args) {
        List<SanPhamVatLy> hangVatLy = List.of(
            new SanPhamVatLy("SP001", "Cà phê hòa tan G7", new BigDecimal("65000"), 120),
            new SanPhamVatLy("SP002", "Bánh quy bơ",       new BigDecimal("42000"),  85),
            new SanPhamVatLy("SP003", "Nước suối 500ml",   new BigDecimal("6000"),  500));

        System.out.println("Bài 2:");
        System.out.println("  Số hàng vật lý có đơn giá >= 40.000: "
                + TienIch.demSanPhamDatGia(hangVatLy, new BigDecimal("40000")));
        System.out.println("  Mã nhỏ nhất trong List<String>: "
                + TienIch.nhoNhat(List.of("SP003", "SP001", "SP002")));
        System.out.println("  Sản phẩm có mã nhỏ nhất: "
                + TienIch.nhoNhat(new ArrayList<SanPham>(hangVatLy)).getTenSanPham());
    }
}
