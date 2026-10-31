package vd52;

/*
 * Ví dụ 5.1 – 5.2 - Lớp tổng quát Kho<T>, Cap<K,V> và giao diện tổng quát
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import java.math.BigDecimal;
import chung.*;

public class DemoLopTongQuat {
    public static void main(String[] args) {
        Kho<SanPham> khoSanPham = new Kho<>("Danh mục sản phẩm");
        khoSanPham.them(new SanPhamVatLy("SP001", "Cà phê hòa tan G7",
                                         new BigDecimal("65000"), 120));
        khoSanPham.them(new SanPhamSo("SP005", "Phần mềm kế toán",
                                      new BigDecimal("2400000"), 365));
        khoSanPham.inTatCa();
 
        Kho<String> khoMaKhachHang = new Kho<>("Mã khách hàng");
        khoMaKhachHang.them("KH001");
        khoMaKhachHang.them("KH002");
        khoMaKhachHang.inTatCa();
 
        SanPham sp = khoSanPham.lay(0);          // không cần ép kiểu
        System.out.printf("Phần tử đầu: %s, thành tiền 3 cái = %s%n",
                sp.getTenSanPham(), sp.thanhTien(3).toPlainString());
    }
}
