package bai10;

/*
 * Bài 10 - Giao diện KhoDuLieu<T, K> và lớp cài đặt trong bộ nhớ
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import chung.*;
import java.math.BigDecimal;
import java.util.*;

public class GiaiBai10 {
    public static void main(String[] args) {
        KhoSanPhamBoNho kho = new KhoSanPhamBoNho();
        kho.them(new SanPhamVatLy("SP001", "Cà phê hòa tan G7",
                                  new BigDecimal("65000"), 120));
        kho.them(new SanPhamVatLy("SP002", "Bánh quy bơ",
                                  new BigDecimal("42000"), 85));
        kho.them(new SanPhamVatLy("SP003", "Nước suối 500ml",
                                  new BigDecimal("6000"), 500));
        kho.them(new SanPhamSo("SP004", "Khóa học trực tuyến",
                               new BigDecimal("890000"), 90));

        System.out.println("Số sản phẩm trong kho: " + kho.soLuong());
        System.out.println("Tìm SP003: " + kho.timTheoKhoa("SP003").getTenSanPham());
        System.out.println("Tìm SP999: " + kho.timTheoKhoa("SP999"));
        System.out.println("Xóa SP002: " + kho.xoaTheoKhoa("SP002")
                + ", còn " + kho.soLuong() + " sản phẩm");

        System.out.println();
        System.out.println("Danh mục sắp theo đơn giá giảm dần:");
        for (SanPham sp : kho.laySapXep(Collections.reverseOrder(new SoSanhTheoGia())))
            System.out.println("  " + sp);

        System.out.println();
        System.out.println("Thêm cùng mã SP001 lần nữa (cập nhật, không nhân đôi):");
        kho.them(new SanPhamVatLy("SP001", "Cà phê G7 hộp mới",
                                  new BigDecimal("68000"), 100));
        System.out.println("  Số sản phẩm: " + kho.soLuong()
                + ", tên hiện tại của SP001: "
                + kho.timTheoKhoa("SP001").getTenSanPham());
    }
}
