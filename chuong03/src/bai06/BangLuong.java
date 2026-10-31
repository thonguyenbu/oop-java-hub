package bai06;

/*
 * Bài 6 - In bảng lương và tính tổng quỹ lương
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 3 - Lớp, đối tượng và phương thức
 */

public class BangLuong {
    public static void main(String[] args) {
        NhanVien[] ds = {
            new NhanVien("NV001", "Nguyễn Văn An",  "Kinh doanh", 12_000_000, 26),
            new NhanVien("NV002", "Trần Thị Bình",  "Kế toán",    15_000_000, 24),
            new NhanVien("NV003", "Lê Văn Cường",   "Kho",         9_000_000, 26),
            new NhanVien("NV004", "Phạm Thị Dung",  "Kinh doanh", 11_000_000, 13),
            new NhanVien("NV005", "Hoàng Văn Em",   "Kỹ thuật",   18_000_000, 28)
        };

        System.out.println("BẢNG LƯƠNG THÁNG (số ngày công chuẩn = "
                + NhanVien.SO_NGAY_CONG_CHUAN + ")");
        System.out.println("=".repeat(80));
        System.out.printf("%-6s %-20s %-14s %14s %6s %14s%n",
                "MÃ NV", "HỌ TÊN", "PHÒNG BAN", "LƯƠNG CƠ BẢN", "NGÀY", "THỰC LĨNH");
        System.out.println("-".repeat(80));
        double tongQuyLuong = 0;
        for (NhanVien nv : ds) {
            System.out.println(nv.moTa());
            tongQuyLuong += nv.tinhLuong();
        }
        System.out.println("-".repeat(80));
        System.out.printf("%-64s %14.0f%n", "TỔNG QUỸ LƯƠNG:", tongQuyLuong);
    }
}
