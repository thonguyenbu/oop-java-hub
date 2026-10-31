package bai08;

/*
 * Bài 8 - Lớp tổng quát KhoTongQuat<T extends Comparable<T>>
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import chung.*;
import java.math.BigDecimal;
import java.util.*;

public class GiaiBai8 {
    public static void main(String[] args) {
        KhoTongQuat<SanPham> kho = new KhoTongQuat<>();
        kho.them(new SanPhamVatLy("SP001", "Cà phê hòa tan G7",
                                  new BigDecimal("65000"), 120));
        kho.them(new SanPhamVatLy("SP003", "Nước suối 500ml",
                                  new BigDecimal("6000"), 500));
        kho.them(new SanPhamSo("SP005", "Phần mềm kế toán",
                               new BigDecimal("2400000"), 365));
        kho.them(new SanPhamVatLy("SP001", "Trùng mã, bị bỏ qua",
                                  new BigDecimal("99000"), 1));

        System.out.println("Số phần tử (đã khử trùng theo mã): " + kho.soLuong());

        System.out.println("Sắp theo thứ tự tự nhiên (mã):");
        for (SanPham sp : kho.sapXepTuNhien()) System.out.println("  " + sp);

        System.out.println("Sắp theo đơn giá giảm dần:");
        for (SanPham sp : kho.sapXepTheo(Collections.reverseOrder(new SoSanhTheoGia())))
            System.out.println("  " + sp);

        System.out.println("Mã lớn nhất: " + kho.lonNhat().getMaSanPham()
                + ", mã nhỏ nhất: " + kho.nhoNhat().getMaSanPham());

        KhoTongQuat<String> khoChuoi = new KhoTongQuat<>();
        khoChuoi.them("KH002");
        khoChuoi.them("KH001");
        khoChuoi.them("KH002");
        System.out.println("Kho chuỗi sau khi sắp: " + khoChuoi.sapXepTuNhien());
    }
}
