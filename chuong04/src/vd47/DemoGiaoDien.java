package vd47;

/*
 * Ví dụ 4.7 - Giao diện CoChietKhau và CoTheXuatHoaDon
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

import java.util.Locale;

public class DemoGiaoDien {
    public static void main(String[] args) {
        Locale vn = Locale.forLanguageTag("vi-VN");
        double tongTien = 50_000_000;

        CoChietKhau[] cacKhach = {
            new KhachHangCaNhan("Nguyễn Văn An", "VANG"),
            new KhachHangCaNhan("Trần Thị Bình", "MOI"),
            new KhachHangDoanhNghiep("Công ty ABC", "0301234567", 6_000_000_000.0),
            new KhachHangDoanhNghiep("Công ty XYZ", "0309876543", 800_000_000.0)
        };

        System.out.printf(vn, "Đơn hàng trị giá %,.0f đ%n%n", tongTien);
        for (CoChietKhau kh : cacKhach) {
            System.out.printf(vn, "  chiết khấu %5.1f%%  giảm %,12.0f  còn %,14.0f%n",
                    kh.tiLeChietKhau() * 100, kh.tienGiam(tongTien),
                    tongTien - kh.tienGiam(tongTien));
        }

        System.out.println();
        System.out.println("Một đối tượng có thể được nhìn qua nhiều giao diện:");
        Object o = cacKhach[2];
        if (o instanceof CoTheXuatHoaDon hd) {
            System.out.println("  " + hd.noiDungHoaDon());
        }
        if (o instanceof CoChietKhau ck) {
            System.out.printf("  tỉ lệ chiết khấu: %.0f%%%n", ck.tiLeChietKhau() * 100);
        }
        System.out.println("  Trần tối đa theo giao diện: "
                + (CoChietKhau.TI_LE_TOI_DA * 100) + "%");
    }
}
