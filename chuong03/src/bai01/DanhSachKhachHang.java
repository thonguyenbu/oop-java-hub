package bai01;

/*
 * Bài 4 - Mảng đối tượng và phương thức tĩnh tìm khách chi tiêu cao nhất
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 3 - Lớp, đối tượng và phương thức
 */

public class DanhSachKhachHang {

    /** Bài 4: phương thức tĩnh nhận mảng, trả về khách có chi tiêu cao nhất. */
    public static KhachHang khachChiTieuCaoNhat(KhachHang[] ds) {
        if (ds == null || ds.length == 0) return null;
        KhachHang caoNhat = ds[0];
        for (KhachHang k : ds) {
            if (k != null && k.getTongChiTieu() > caoNhat.getTongChiTieu()) caoNhat = k;
        }
        return caoNhat;
    }

    public static void main(String[] args) {
        KhachHang[] ds = {
            new KhachHang("KH001", "Nguyễn Văn An",  "0901234567", "DONG",  1_200_000),
            new KhachHang("KH002", "Trần Thị Bình",  "0912345678", "BAC",   8_500_000),
            new KhachHang("KH003", "Lê Văn Cường",   "0923456789", "VANG", 34_000_000),
            new KhachHang("KH004", "Phạm Thị Dung",  "0934567890", "BAC",  12_700_000),
            new KhachHang("KH005", "Hoàng Văn Em",   "0945678901", "DONG",   450_000)
        };

        System.out.printf("%-8s %-20s %-13s %-6s %14s%n",
                "MÃ KH", "HỌ TÊN", "ĐIỆN THOẠI", "HẠNG", "TỔNG CHI TIÊU");
        System.out.println("-".repeat(66));
        double tong = 0;
        for (KhachHang k : ds) {
            System.out.println(k.moTa());
            tong += k.getTongChiTieu();
        }
        System.out.println("-".repeat(66));
        System.out.printf("%-50s %14.0f%n", "TỔNG CHI TIÊU TOÀN DANH SÁCH:", tong);

        KhachHang caoNhat = khachChiTieuCaoNhat(ds);
        System.out.println();
        System.out.printf("Khách chi tiêu cao nhất: %s - %s (%.0f đ)%n",
                caoNhat.getMaKhachHang(), caoNhat.getHoTen(), caoNhat.getTongChiTieu());
    }
}
