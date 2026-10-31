package tonghop;

/*
 * Ví dụ tổng hợp - Ứng dụng bán hàng: bốn tính chất cùng hoạt động
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

import java.util.Locale;

public class DonHang {
    private static int soDonDaLap = 0;

    private final String maDon;
    private final KhachHang khachHang;
    private SanPham[] cacSanPham;
    private int[] cacSoLuong;
    private int soDong;

    public DonHang(KhachHang khachHang, int sucChua) {
        soDonDaLap++;
        this.maDon = String.format("DH%04d", soDonDaLap);
        this.khachHang = khachHang;
        this.cacSanPham = new SanPham[sucChua];
        this.cacSoLuong = new int[sucChua];
        this.soDong = 0;
    }

    public boolean themDong(SanPham sp, int soLuong) {
        if (soDong >= cacSanPham.length || soLuong <= 0) return false;
        if (sp instanceof SanPhamVatLy hang && !hang.xuatKho(soLuong)) {
            System.out.println("  Từ chối: " + sp.getTenSanPham() + " không đủ tồn kho.");
            return false;
        }
        cacSanPham[soDong] = sp;
        cacSoLuong[soDong] = soLuong;
        soDong++;
        return true;
    }

    public double tongPhiVanChuyen() {
        double phi = 0;
        for (int i = 0; i < soDong; i++) {
            if (cacSanPham[i] instanceof CoTheGiaoHang gh) phi += gh.phiVanChuyen();
        }
        return phi;
    }

    public double tienChietKhau() { return khachHang.tienGiam(tongTienHang()); }

    public double tongTienHang() {
        double tong = 0;
        for (int i = 0; i < soDong; i++) tong += cacSanPham[i].thanhTien(cacSoLuong[i]);
        return tong;
    }

    public double tongPhaiThu() {
        double truocThue = tongTienHang() - tienChietKhau() + tongPhiVanChuyen();
        return truocThue * 1.08;
    }

    public void inHoaDon() {
        Locale vn = Locale.forLanguageTag("vi-VN");
        System.out.println("=".repeat(66));
        System.out.println("HÓA ĐƠN " + maDon + "  -  " + khachHang.moTa());
        System.out.println("-".repeat(66));
        System.out.printf("%-6s %-22s %-12s %4s %13s%n",
                "MÃ", "TÊN SẢN PHẨM", "LOẠI", "SL", "THÀNH TIỀN");
        for (int i = 0; i < soDong; i++) {
            SanPham sp = cacSanPham[i];
            System.out.printf(vn, "%-6s %-22s %-12s %4d %,13.0f%n",
                    sp.getMaSanPham(), sp.getTenSanPham(), sp.loaiSanPham(),
                    cacSoLuong[i], sp.thanhTien(cacSoLuong[i]));
        }
        System.out.println("-".repeat(66));
        System.out.printf(vn, "%-46s %,17.0f%n", "Tổng tiền hàng:", tongTienHang());
        System.out.printf(vn, "%-46s %,17.0f%n", "Chiết khấu khách hàng:", -tienChietKhau());
        System.out.printf(vn, "%-46s %,17.0f%n", "Phí vận chuyển:", tongPhiVanChuyen());
        System.out.printf(vn, "%-46s %,17.0f%n",
                "TỔNG PHẢI THU (đã gồm VAT 8%):", tongPhaiThu());
        System.out.println("=".repeat(66));
    }

    public static int getSoDonDaLap() { return soDonDaLap; }
}
