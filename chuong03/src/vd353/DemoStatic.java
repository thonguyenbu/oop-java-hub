package vd353;

import java.util.Locale;
public class DemoStatic {
    public static void main(String[] args) {
        Locale vn = Locale.forLanguageTag("vi-VN");
        System.out.println("Số tài khoản đã mở lúc đầu: " + TaiKhoan.getSoTaiKhoanDaMo());
        TaiKhoan tk1 = new TaiKhoan("Nguyễn Văn An", 5_000_000);
        TaiKhoan tk2 = new TaiKhoan("Trần Thị Bình", 12_000_000);
        TaiKhoan tk3 = new TaiKhoan("Lê Văn Cường", 800_000);
        System.out.println();
        System.out.printf(vn, "%s | %-16s | %,12.0f đ%n",
                tk1.getSoTaiKhoan(), tk1.getChuTaiKhoan(), tk1.getSoDu());
        System.out.printf(vn, "%s | %-16s | %,12.0f đ%n",
                tk2.getSoTaiKhoan(), tk2.getChuTaiKhoan(), tk2.getSoDu());
        System.out.printf(vn, "%s | %-16s | %,12.0f đ%n",
                tk3.getSoTaiKhoan(), tk3.getChuTaiKhoan(), tk3.getSoDu());
        tk1.nopTien(2_000_000);
        tk2.rutTien(500_000);
        System.out.println();
        System.out.println("Ngân hàng: " + TaiKhoan.TEN_NGAN_HANG);
        System.out.println("Số tài khoản đã mở: " + TaiKhoan.getSoTaiKhoanDaMo());
        System.out.printf(vn, "Tổng số dư toàn hệ thống: %,.0f đ%n",
                TaiKhoan.getTongSoDuToanHeThong());
        System.out.printf(vn, "Lãi tháng của tk1: %,.2f đ%n",
                TaiKhoan.tienLaiThang(tk1.getSoDu()));
    }
}
