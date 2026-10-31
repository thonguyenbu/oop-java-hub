package vd58;

/*
 * Mục 5.8.4 - Phân biệt không sửa đổi được cấu trúc với tính bất biến
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import chung.SanPham;
import chung.SanPhamVatLy;
import java.math.BigDecimal;
import java.util.List;

public class BatBienNongSau {
    public static void main(String[] args) {
        SanPhamVatLy sp = new SanPhamVatLy("SP001", "Cà phê hòa tan G7",
                                           new BigDecimal("65000"), 120);
        List<SanPham> khongSua = List.copyOf(List.of(sp));
        try {
            khongSua.add(sp);                  // chặn được: thay đổi cấu trúc
        } catch (UnsupportedOperationException e) {
            System.out.println("Thêm phần tử: bị từ chối");
        }
        ((SanPhamVatLy) khongSua.get(0)).xuatKho(20);   // không chặn được
        System.out.println("Tồn kho đọc từ danh sách: "
                + ((SanPhamVatLy) khongSua.get(0)).getSoLuongTon());
        System.out.println("Tồn kho của đối tượng gốc: " + sp.getSoLuongTon());
        System.out.println("Hai tham chiếu trỏ cùng một đối tượng: "
                + (sp == khongSua.get(0)));
    }
}
