package vd43;

/*
 * Ví dụ 4.3 – 4.5 - Đa hình, ghi đè, ép kiểu và toán tử instanceof
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

import java.util.Locale;

public class DemoDaHinh {
    public static void main(String[] args) {
        Locale vn = Locale.forLanguageTag("vi-VN");
 
        NhanVien[] bangLuong = {
            new NhanVien("NV001", "Nguyễn Văn An", 12_000_000),
            new NhanVienKinhDoanh("NV002", "Trần Thị Bình", 8_000_000, 250_000_000, 0.02),
            new TruongPhong("NV003", "Lê Văn Cường", 20_000_000, 5_000_000, 8),
            new NhanVienKinhDoanh("NV004", "Phạm Thị Dung", 8_000_000, 120_000_000, 0.03)
        };
 
        System.out.printf("%-6s %-18s %14s%n", "MÃ", "HỌ TÊN", "LƯƠNG");
        System.out.println("-".repeat(40));
        double tongQuyLuong = 0;
        for (NhanVien nv : bangLuong) {
            System.out.println(nv);
            tongQuyLuong += nv.tinhLuong();
        }
        System.out.println("-".repeat(40));
        System.out.printf(vn, "%-25s %14.0f%n", "TỔNG QUỸ LƯƠNG:", tongQuyLuong);
    }
}
