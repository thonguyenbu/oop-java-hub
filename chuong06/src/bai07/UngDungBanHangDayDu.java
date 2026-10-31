package bai07;

/*
 * Bài 7 - Ứng dụng quản lý bán hàng hoàn chỉnh
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 6 - Xây dựng ứng dụng hướng đối tượng
 */

import balop.SanPhamService;
import chung.*;
import jdbc.BanHangService;
import jdbc.KetNoiCSDL;
import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

public class UngDungBanHangDayDu {

    static final Locale VN = Locale.forLanguageTag("vi-VN");
    static String tien(BigDecimal x) { return String.format(VN, "%,.0f", x); }

    public static void main(String[] args) throws Exception {
        try (Connection cn = KetNoiCSDL.moKetNoi()) {
            SanPhamService spDichVu = new SanPhamService(cn);
            BanHangService banHang  = new BanHangService(cn);
            KhachHangDAO khDao      = new KhachHangDAO(cn);
            BaoCaoDAO baoCao        = new BaoCaoDAO(cn);

            System.out.println("ỨNG DỤNG QUẢN LÝ BÁN HÀNG MINIMART");

            spDichVu.themSanPham(new SanPham("SP001", "Cà phê hòa tan G7",
                    new BigDecimal("65000"), 120));
            spDichVu.themSanPham(new SanPham("SP002", "Bánh quy bơ",
                    new BigDecimal("42000"), 85));
            spDichVu.themSanPham(new SanPham("SP003", "Nước suối 500ml",
                    new BigDecimal("6000"), 500));
            spDichVu.themSanPham(new SanPham("SP004", "Phần mềm kế toán",
                    new BigDecimal("2400000"), 8));
            khDao.them(new KhachHang("KH001", "Nguyễn Văn An", "VANG"));
            khDao.them(new KhachHang("KH002", "Công ty ABC", "DOANHNGHIEP"));

            System.out.println();
            System.out.println("1. DANH MỤC SẢN PHẨM");
            System.out.println("-".repeat(64));
            System.out.printf("  %-6s %-24s %12s %8s%n",
                    "MÃ", "TÊN SẢN PHẨM", "ĐƠN GIÁ", "TỒN");
            for (SanPham sp : spDichVu.laySapXepTheoMa())
                System.out.printf(VN, "  %-6s %-24s %12s %8d%n", sp.getMaSanPham(),
                        sp.getTenSanPham(), tien(sp.getDonGia()), sp.getSoLuongTon());

            System.out.println();
            System.out.println("2. LẬP ĐƠN HÀNG (mỗi đơn là một giao dịch)");
            System.out.println("-".repeat(64));
            int d1 = banHang.lapDonHang("KH001", List.of(
                    new DongDatHang("SP001", 3), new DongDatHang("SP003", 10)));
            System.out.println("  Đơn 1 cho KH001 -> số đơn " + d1);
            int d2 = banHang.lapDonHang("KH002", List.of(
                    new DongDatHang("SP004", 2), new DongDatHang("SP001", 5)));
            System.out.println("  Đơn 2 cho KH002 -> số đơn " + d2);
            int d3 = banHang.lapDonHang("KH001", List.of(new DongDatHang("SP002", 4)));
            System.out.println("  Đơn 3 cho KH001 -> số đơn " + d3);
            try {
                banHang.lapDonHang("KH002", List.of(
                        new DongDatHang("SP002", 2),
                        new DongDatHang("SP004", 9999)));
            } catch (SQLException e) {
                System.out.println("  Đơn 4 bị từ chối: " + e.getMessage());
            }

            System.out.println();
            System.out.println("3. LỊCH SỬ ĐƠN HÀNG CỦA KH001");
            System.out.println("-".repeat(64));
            System.out.printf("  %-8s %-12s %14s%n", "SỐ ĐƠN", "NGÀY ĐẶT", "TỔNG TIỀN");
            for (String dong : baoCao.lichSuDonHang("KH001"))
                System.out.println("  " + dong);

            System.out.println();
            System.out.println("4. BÁO CÁO DOANH THU THEO SẢN PHẨM");
            System.out.println("-".repeat(64));
            System.out.printf("  %-6s %-24s %4s %16s%n",
                    "MÃ", "TÊN SẢN PHẨM", "SL", "DOANH THU");
            BigDecimal tongDoanhThu = BigDecimal.ZERO;
            for (Map.Entry<String, BigDecimal> e
                    : baoCao.doanhThuTheoSanPham().entrySet()) {
                System.out.printf(VN, "  %s %16s%n", e.getKey(), tien(e.getValue()));
                tongDoanhThu = tongDoanhThu.add(e.getValue());
            }
            System.out.println("  " + "-".repeat(62));
            System.out.printf(VN, "  %-36s %16s%n", "TỔNG DOANH THU:", tien(tongDoanhThu));

            System.out.println();
            System.out.println("5. TỒN KHO SAU KHI BÁN - kiểm chứng giao dịch đã hoàn tác đúng");
            System.out.println("-".repeat(64));
            System.out.printf("  %-6s %-24s %8s%n", "MÃ", "TÊN SẢN PHẨM", "TỒN");
            for (SanPham sp : spDichVu.laySapXepTheoMa())
                System.out.printf("  %-6s %-24s %8d%n",
                        sp.getMaSanPham(), sp.getTenSanPham(), sp.getSoLuongTon());

            System.out.printf(VN, "%n6. TỔNG GIÁ TRỊ TỒN KHO: %s đ%n",
                    tien(spDichVu.tongGiaTriTonKho()));
        }
    }
}
