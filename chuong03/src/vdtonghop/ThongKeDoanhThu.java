package vdtonghop;

import java.util.Locale;
public class ThongKeDoanhThu {
    static double tongDoanhThu(DongDatHang[] cacDong) {
        double tong = 0;
        for (DongDatHang dong : cacDong) {
            if (dong != null) tong += dong.thanhTien();
        }
        return tong;
    }
    static DongDatHang dongLonNhat(DongDatHang[] cacDong) {
        DongDatHang lonNhat = null;
        for (DongDatHang dong : cacDong) {
            if (dong == null) continue;
            if (lonNhat == null || dong.thanhTien() > lonNhat.thanhTien()) {
                lonNhat = dong;
            }
        }
        return lonNhat;
    }
    public static void main(String[] args) {
        Locale vn = Locale.forLanguageTag("vi-VN");
        SanPham caPhe = new SanPham("SP001", "Cà phê hòa tan G7", 65000, 120);
        SanPham banhQuy = new SanPham("SP002", "Bánh quy bơ", 42000, 85);
        SanPham nuoc = new SanPham("SP003", "Nước suối 500ml", 6000, 500);
        DongDatHang[] cacDong = {
            new DongDatHang(caPhe, 3),
            new DongDatHang(banhQuy, 1),
            new DongDatHang(caPhe, 2),
            new DongDatHang(nuoc, 10),
            new DongDatHang(banhQuy, 4),
            new DongDatHang(nuoc, -5),       // số lượng không hợp lệ
            new DongDatHang(banhQuy, 500)    // vượt số lượng tồn kho
        };
        DongDatHang[] daBan = new DongDatHang[cacDong.length];
        System.out.println("BÁO CÁO BÁN HÀNG TRONG NGÀY");
        System.out.println("-".repeat(58));
        System.out.printf("%-6s %-22s %4s %14s%n", "MÃ", "TÊN SẢN PHẨM", "SL", "THÀNH TIỀN");
        for (int i = 0; i < cacDong.length; i++) {
            DongDatHang dong = cacDong[i];
            SanPham sp = dong.getSanPham();
            int sl = dong.getSoLuong();
            if (sl <= 0) {                   // số lượng không hợp lệ
                System.out.printf("%-6s %-22s %4d %14s%n",
                        sp.getMaSanPham(), sp.getTenSanPham(), sl, "TỪ CHỐI");
                continue;
            }
            if (!sp.xuatKho(sl)) {           // tồn kho không đủ
                System.out.printf("%-6s %-22s %4d %14s%n",
                        sp.getMaSanPham(), sp.getTenSanPham(), sl, "THIẾU HÀNG");
                continue;                    // không ghi nhận doanh thu
            }
            daBan[i] = dong;                 // chỉ ghi nhận khi xuất kho thành công
            System.out.printf(vn, "%-6s %-22s %4d %,14.0f%n",
                    sp.getMaSanPham(), sp.getTenSanPham(), sl, dong.thanhTien());
        }
        System.out.println("-".repeat(58));
        double tong = tongDoanhThu(daBan);
        System.out.printf(vn, "%-34s %,14.0f%n", "TỔNG DOANH THU:", tong);
        System.out.printf(vn, "%-34s %,14.0f%n", "THUẾ VAT 8%:", SanPham.tienThue(tong));
        System.out.printf(vn, "%-34s %,14.0f%n", "TỔNG PHẢI THU:",
                tong + SanPham.tienThue(tong));
        DongDatHang lon = dongLonNhat(daBan);
        System.out.println();
        if (lon != null) {
            System.out.println("Dòng bán hàng lớn nhất: "
                    + lon.getSanPham().getTenSanPham() + " x " + lon.getSoLuong());
        }
        System.out.println("Số đối tượng SanPham đã tạo: " + SanPham.getSoDoiTuongDaTao());
        System.out.println();
        System.out.println("TỒN KHO SAU KHI BÁN");
        System.out.println(caPhe.moTa());
        System.out.println(banhQuy.moTa());
        System.out.println(nuoc.moTa());
    }
}
