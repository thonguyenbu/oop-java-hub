package bai08;

/*
 * Bài 8 - Kết hợp lớp trừu tượng với giao diện CoThuong
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

import java.util.Locale;

public class GiaiBai8 {
    public static void main(String[] args) {
        Locale vn = Locale.forLanguageTag("vi-VN");
        NhanVien[] ds = {
            new NhanVienVanPhong("NV001", "Nguyễn Văn An", 12_000_000),
            new NhanVienKinhDoanh("NV002", "Trần Thị Bình", 8_000_000, 1_500_000_000.0),
            new TruongPhong("NV003", "Lê Văn Cường", 20_000_000, 8),
            new NhanVienKinhDoanh("NV004", "Phạm Thị Dung", 8_000_000, 300_000_000.0)
        };
        System.out.printf("%-6s %-18s %-16s %14s %14s%n",
                "MÃ", "HỌ TÊN", "LOẠI", "LƯƠNG", "TỔNG THU NHẬP");
        double tong = 0;
        for (NhanVien nv : ds) { System.out.println(nv); tong += nv.tongThuNhap(); }
        System.out.printf(vn, "%-57s %,14.0f%n", "TỔNG CHI PHÍ NHÂN SỰ:", tong);
    }
}
