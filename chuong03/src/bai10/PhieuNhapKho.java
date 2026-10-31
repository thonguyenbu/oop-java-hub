package bai10;

/*
 * Bài 10 - Lớp PhieuNhapKho: số phiếu sinh tự động, cờ đã thực hiện
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 3 - Lớp, đối tượng và phương thức
 */

public class PhieuNhapKho {

    private static int soPhieuDaLap = 0;

    private final String soPhieu;
    private final String ngayNhap;
    private SanPham[] cacSanPham;
    private int[] cacSoLuongNhap;
    private int soDong;
    private boolean daThucHien;

    public PhieuNhapKho(String ngayNhap, int sucChua) {
        soPhieuDaLap++;
        this.soPhieu = String.format("PN%04d", soPhieuDaLap);
        this.ngayNhap = ngayNhap;
        this.cacSanPham = new SanPham[sucChua];
        this.cacSoLuongNhap = new int[sucChua];
        this.soDong = 0;
        this.daThucHien = false;
    }

    public String getSoPhieu()  { return soPhieu; }
    public String getNgayNhap() { return ngayNhap; }
    public int getSoDong()      { return soDong; }
    public boolean isDaThucHien() { return daThucHien; }

    public static int getSoPhieuDaLap() { return soPhieuDaLap; }

    public boolean themDong(SanPham sp, int soLuongNhap) {
        if (daThucHien) {
            System.out.println("  Từ chối: phiếu đã thực hiện, không sửa được nữa");
            return false;
        }
        if (sp == null || soLuongNhap <= 0 || soDong >= cacSanPham.length) return false;
        cacSanPham[soDong] = sp;
        cacSoLuongNhap[soDong] = soLuongNhap;
        soDong++;
        return true;
    }

    /** Cập nhật tồn kho của từng sản phẩm và trả về tổng giá trị nhập. */
    public double thucHien() {
        if (daThucHien) {
            System.out.println("  Từ chối: phiếu " + soPhieu + " đã được thực hiện");
            return 0;
        }
        double tongGiaTri = 0;
        for (int i = 0; i < soDong; i++) {
            cacSanPham[i].nhapKho(cacSoLuongNhap[i]);      // sửa TRỰC TIẾP đối tượng gốc
            tongGiaTri += cacSanPham[i].getDonGia() * cacSoLuongNhap[i];
        }
        daThucHien = true;
        return tongGiaTri;
    }

    public void inPhieu() {
        System.out.println("PHIẾU NHẬP KHO " + soPhieu + "   ngày " + ngayNhap);
        System.out.printf("  %-6s %-24s %8s %12s %14s%n",
                "MÃ", "TÊN SẢN PHẨM", "SL NHẬP", "ĐƠN GIÁ", "THÀNH TIỀN");
        for (int i = 0; i < soDong; i++) {
            SanPham sp = cacSanPham[i];
            System.out.printf("  %-6s %-24s %8d %12.0f %14.0f%n",
                    sp.getMaSanPham(), sp.getTenSanPham(), cacSoLuongNhap[i],
                    sp.getDonGia(), sp.getDonGia() * cacSoLuongNhap[i]);
        }
    }
}
