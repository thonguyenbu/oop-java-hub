package vd54;

/*
 * Ví dụ 5.4 - Ba dạng ký tự đại diện: ? extends, ? super, ?
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import chung.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DemoKyTuDaiDien {
    public static void main(String[] args) {
        List<SanPhamVatLy> hangVatLy = new ArrayList<>();
        hangVatLy.add(new SanPhamVatLy("SP001", "Cà phê hòa tan G7",
                                       new BigDecimal("65000"), 120));
        hangVatLy.add(new SanPhamVatLy("SP002", "Bánh quy bơ",
                                       new BigDecimal("42000"), 85));

        List<SanPham> danhMuc = new ArrayList<>(hangVatLy);
        danhMuc.add(new SanPhamSo("SP005", "Phần mềm kế toán",
                                  new BigDecimal("2400000"), 365));

        System.out.println("Đọc bằng ? extends SanPham:");
        System.out.println("  Tổng đơn giá hàng vật lý: "
                + KyTuDaiDien.tongDonGia(hangVatLy).toPlainString());
        System.out.println("  Tổng đơn giá cả danh mục: "
                + KyTuDaiDien.tongDonGia(danhMuc).toPlainString());

        System.out.println("Ghi bằng ? super SanPhamVatLy:");
        KyTuDaiDien.themHangMau(hangVatLy);       // List<SanPhamVatLy>
        KyTuDaiDien.themHangMau(danhMuc);         // List<SanPham> - lớp cha
        System.out.printf("  Sau khi thêm hàng mẫu: hangVatLy = %d, danhMuc = %d%n",
                hangVatLy.size(), danhMuc.size());

        System.out.println("Dùng ? khi không quan tâm kiểu:");
        KyTuDaiDien.demSoPhanTu(hangVatLy);
        KyTuDaiDien.demSoPhanTu(List.of("KH001", "KH002"));
    }
}
