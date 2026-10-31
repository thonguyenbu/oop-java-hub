package bai12;

/*
 * Bài 12 - Phiên bản mới dùng BigDecimal cho tiền tệ
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 3 - Lớp, đối tượng và phương thức
 */

import java.math.BigDecimal;
import java.math.RoundingMode;

/** Phiên bản mới: dùng BigDecimal cho mọi giá trị tiền tệ. */
public class SanPhamBigDecimal {

    public static final BigDecimal THUE_SUAT_VAT = new BigDecimal("0.08");

    private final String maSanPham;
    private String tenSanPham;
    private BigDecimal donGia;
    private int soLuongTon;

    public SanPhamBigDecimal(String ma, String ten, BigDecimal donGia, int soLuongTon) {
        this.maSanPham = ma;
        this.tenSanPham = ten;
        setDonGia(donGia);
        setSoLuongTon(soLuongTon);
    }

    public String getMaSanPham()   { return maSanPham; }
    public String getTenSanPham()  { return tenSanPham; }
    public BigDecimal getDonGia()  { return donGia; }
    public int getSoLuongTon()     { return soLuongTon; }

    public void setDonGia(BigDecimal donGia) {
        // So sánh BigDecimal phải dùng compareTo, không dùng equals
        if (donGia == null || donGia.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("Từ chối: đơn giá không hợp lệ");
            if (this.donGia == null) this.donGia = BigDecimal.ZERO;
            return;
        }
        this.donGia = donGia;
    }

    public void setSoLuongTon(int soLuongTon) {
        if (soLuongTon < 0) { System.out.println("Từ chối: tồn kho không được âm"); return; }
        this.soLuongTon = soLuongTon;
    }

    public BigDecimal thanhTien(int soLuong) {
        return donGia.multiply(BigDecimal.valueOf(soLuong));
    }

    public BigDecimal giaTriTonKho() {
        return donGia.multiply(BigDecimal.valueOf(soLuongTon));
    }

    public BigDecimal tienThue(BigDecimal thanhTien) {
        return thanhTien.multiply(THUE_SUAT_VAT).setScale(2, RoundingMode.HALF_UP);
    }
}
