package chung;

/*
 * Lớp dùng chung - Các lớp nghiệp vụ dùng chung cho toàn Chương 5
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import java.math.BigDecimal;
import java.util.Objects;

public abstract class SanPham implements Comparable<SanPham> {
    private final String maSanPham;
    private String tenSanPham;
    private BigDecimal donGia;
 
    public SanPham(String maSanPham, String tenSanPham, BigDecimal donGia) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.donGia = (donGia == null || donGia.signum() < 0)
                      ? BigDecimal.ZERO : donGia;
    }
 
    public abstract String loaiSanPham();
 
    public BigDecimal thanhTien(int soLuong) {
        return donGia.multiply(BigDecimal.valueOf(soLuong));
    }
 
    public String getMaSanPham()  { return maSanPham; }
    public String getTenSanPham() { return tenSanPham; }
    public BigDecimal getDonGia() { return donGia; }
 
    @Override
    public int compareTo(SanPham khac) {          // thứ tự tự nhiên: theo mã
        return this.maSanPham.compareTo(khac.maSanPham);
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SanPham)) return false;
        return maSanPham.equals(((SanPham) o).maSanPham);
    }
 
    @Override
    public int hashCode() { return Objects.hash(maSanPham); }
 
    @Override
    public String toString() {
        return String.format("%-6s %-24s %-12s %12s",
                maSanPham, tenSanPham, loaiSanPham(), donGia.toPlainString());
    }
}
