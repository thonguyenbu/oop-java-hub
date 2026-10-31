package bai06;

/*
 * Bài 6 - Duyệt mảng hỗn hợp bằng instanceof so khớp mẫu
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

import java.util.Locale;

public class GiaiBai6 {
    public static void main(String[] args) {
        Locale vn = Locale.forLanguageTag("vi-VN");
        NhanVien[] ds = {
            new NhanVien("NV001", "Nguyễn Văn An", 12_000_000),
            new NhanVienKinhDoanh("NV002", "Trần Thị Bình", 8_000_000, 250_000_000, 0.02),
            new TruongPhong("NV003", "Lê Văn Cường", 20_000_000, 5_000_000, 8),
            new NhanVienKinhDoanh("NV004", "Phạm Thị Dung", 8_000_000, 120_000_000, 0.03)
        };

        int soQuanLy = 0, soKinhDoanh = 0, soKhac = 0;
        double tongDoanhSo = 0;

        for (NhanVien nv : ds) {
            if (nv instanceof TruongPhong ql) {
                soQuanLy++;
                ql.hopGiaoBan();
            } else if (nv instanceof NhanVienKinhDoanh ns) {
                soKinhDoanh++;
                tongDoanhSo += ns.getDoanhSo();
            } else {
                soKhac++;
            }
        }

        System.out.println();
        System.out.println("Quản lý      : " + soQuanLy);
        System.out.println("Kinh doanh   : " + soKinhDoanh);
        System.out.println("Nhân viên khác: " + soKhac);
        System.out.printf(vn, "Tổng doanh số của bộ phận kinh doanh: %,.0f đ%n", tongDoanhSo);
    }
}
