package vd334;

import java.util.Locale;
public class DanhMucSanPham {
    static double tongGiaTri(SanPham[] danhSach) {
        double tong = 0;
        for (SanPham sp : danhSach) {
            tong += sp.giaTriTonKho();
        }
        return tong;
    }
    public static void main(String[] args) {
        Locale vn = Locale.forLanguageTag("vi-VN");
        SanPham[] danhSach = new SanPham[4];
        danhSach[0] = new SanPham("SP001", "Cà phê hòa tan G7", 65000, 120);
        danhSach[1] = new SanPham("SP002", "Bánh quy bơ", 42000, 85);
        danhSach[2] = new SanPham("SP003", "Nước suối 500ml", 6000, 500);
        danhSach[3] = new SanPham("SP004", "Trà xanh không đường", 12000, 200);
        System.out.println("DANH MỤC SẢN PHẨM");
        for (SanPham p : danhSach) {
            System.out.println(p.moTa());
        }
        System.out.printf(vn, "Tổng giá trị tồn kho: %,.0f%n",
                tongGiaTri(danhSach));
    }
}
