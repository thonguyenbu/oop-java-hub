package chung;

/*
 * Lớp dùng chung - Lớp thực thể và giao diện kho dữ liệu dùng chung
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 6 - Xây dựng ứng dụng hướng đối tượng
 */

import java.math.BigDecimal;
import java.util.Objects;

public class SanPham {

    private final String maSanPham;
    private String tenSanPham;
    private BigDecimal donGia;
    private int soLuongTon;

    public SanPham(String maSanPham, String tenSanPham,
                   BigDecimal donGia, int soLuongTon) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.donGia = donGia;
        this.soLuongTon = soLuongTon;
    }

    public String getMaSanPham()  { return maSanPham; }
    public String getTenSanPham() { return tenSanPham; }
    public BigDecimal getDonGia() { return donGia; }
    public int getSoLuongTon()    { return soLuongTon; }

    public void setTenSanPham(String t) {
        if (t != null && !t.isBlank()) this.tenSanPham = t.strip();
    }
    // Lớp thực thể chỉ mang dữ liệu; việc kiểm tra quy tắc nghiệp vụ
    // được đặt ở tầng nghiệp vụ (SanPhamService), đúng kiến trúc ba lớp.
    public void setDonGia(BigDecimal g)  { this.donGia = g; }
    public void setSoLuongTon(int sl)    { this.soLuongTon = sl; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SanPham)) return false;
        return maSanPham.equals(((SanPham) o).maSanPham);
    }
    @Override public int hashCode() { return Objects.hash(maSanPham); }

    @Override public String toString() {
        return String.format("%-6s %-24s %12s %6d",
                maSanPham, tenSanPham, donGia.toPlainString(), soLuongTon);
    }
}
