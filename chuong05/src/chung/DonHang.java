package chung;

/*
 * Lớp dùng chung - Các lớp nghiệp vụ dùng chung cho toàn Chương 5
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import java.math.BigDecimal;

public class DonHang {
    private final String maDon;
    private final String maKhachHang;
    private final BigDecimal tongTien;
    private final int thang;

    public DonHang(String maDon, String maKhachHang, BigDecimal tongTien, int thang) {
        this.maDon = maDon;
        this.maKhachHang = maKhachHang;
        this.tongTien = tongTien;
        this.thang = thang;
    }
    public String getMaDon()        { return maDon; }
    public String getMaKhachHang()  { return maKhachHang; }
    public BigDecimal getTongTien() { return tongTien; }
    public int getThang()           { return thang; }

    @Override public String toString() {
        return String.format("%-8s %-8s T%-6d %8s",
                maDon, maKhachHang, thang, tongTien.toPlainString());
    }

    /** Năm đơn hàng mẫu dùng chung cho Bài 5, 6 và 7. */
    public static java.util.List<DonHang> duLieuMau() {
        return java.util.List.of(
            new DonHang("DH0001", "KH001", new BigDecimal("5200000"), 1),
            new DonHang("DH0002", "KH002", new BigDecimal("1800000"), 1),
            new DonHang("DH0003", "KH001", new BigDecimal("9400000"), 2),
            new DonHang("DH0004", "KH003", new BigDecimal("3100000"), 2),
            new DonHang("DH0005", "KH002", new BigDecimal("7600000"), 2));
    }
}
