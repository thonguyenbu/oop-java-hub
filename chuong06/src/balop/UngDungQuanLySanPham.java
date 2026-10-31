package balop;

/*
 * Mục 6.8 - Ứng dụng quản lý sản phẩm theo mô hình ba lớp
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 6 - Xây dựng ứng dụng hướng đối tượng
 */

import chung.*;
import jdbc.KetNoiCSDL;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;
import java.util.Locale;

public class UngDungQuanLySanPham {

    static final Locale VN = Locale.forLanguageTag("vi-VN");

    static String tien(BigDecimal x) { return String.format(VN, "%,.0f", x); }

    static void inBang(String tieuDe, List<SanPham> ds) {
        System.out.println(tieuDe);
        System.out.println("  " + "-".repeat(56));
        System.out.printf("  %-6s %-24s %12s %8s%n",
                "MÃ", "TÊN SẢN PHẨM", "ĐƠN GIÁ", "TỒN");
        System.out.println("  " + "-".repeat(56));
        for (SanPham sp : ds)
            System.out.printf(VN, "  %-6s %-24s %12s %8d%n",
                    sp.getMaSanPham(), sp.getTenSanPham(),
                    tien(sp.getDonGia()), sp.getSoLuongTon());
        System.out.println("  " + "-".repeat(56));
    }

    static void inDong(List<SanPham> ds) {
        for (SanPham sp : ds)
            System.out.printf(VN, "  %-6s %-24s %12s %8d%n",
                    sp.getMaSanPham(), sp.getTenSanPham(),
                    tien(sp.getDonGia()), sp.getSoLuongTon());
    }

    public static void main(String[] args) throws Exception {
        try (Connection cn = KetNoiCSDL.moKetNoi()) {
            SanPhamService dichVu = new SanPhamService(cn);

            System.out.println("ỨNG DỤNG QUẢN LÝ SẢN PHẨM - MÔ HÌNH BA LỚP");
            System.out.println();

            dichVu.themSanPham(new SanPham("SP001", "Cà phê hòa tan G7",
                    new BigDecimal("65000"), 120));
            dichVu.themSanPham(new SanPham("SP002", "Bánh quy bơ",
                    new BigDecimal("42000"), 85));
            dichVu.themSanPham(new SanPham("SP003", "Nước suối 500ml",
                    new BigDecimal("6000"), 500));
            dichVu.themSanPham(new SanPham("SP004", "Phần mềm kế toán",
                    new BigDecimal("2400000"), 8));
            inBang("1. DANH MỤC SẢN PHẨM", dichVu.laySapXepTheoMa());

            System.out.println();
            System.out.println("2. QUY TẮC NGHIỆP VỤ ĐƯỢC TẦNG SERVICE BẢO VỆ");
            try {
                dichVu.themSanPham(new SanPham("SP001", "Trùng mã",
                        new BigDecimal("1000"), 1));
            } catch (IllegalArgumentException e) {
                System.out.println("   Từ chối: " + e.getMessage());
            }
            try {
                dichVu.themSanPham(new SanPham("SP005", "Giá âm",
                        new BigDecimal("-5000"), 1));
            } catch (IllegalArgumentException e) {
                System.out.println("   Từ chối: " + e.getMessage());
            }

            System.out.println();
            System.out.println("3. XẾP HẠNG THEO ĐƠN GIÁ GIẢM DẦN");
            inDong(dichVu.laySapXepTheoGiaGiamDan());

            System.out.println();
            System.out.println("4. SẢN PHẨM CẦN ĐẶT HÀNG (tồn dưới 100)");
            inDong(dichVu.layCanDatHang(100));

            System.out.printf(VN, "%n5. TỔNG GIÁ TRỊ TỒN KHO: %s đ%n",
                    tien(dichVu.tongGiaTriTonKho()));
        }
    }
}
