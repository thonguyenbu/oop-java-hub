package bai12;

/*
 * Bài 12 - Phiên bản cũ dùng double cho tiền tệ
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 3 - Lớp, đối tượng và phương thức
 */

/** Phiên bản cũ: dùng double cho tiền tệ. */
public class SanPhamDouble {

    private final String maSanPham;
    private String tenSanPham;
    private double donGia;
    private int soLuongTon;

    public SanPhamDouble(String ma, String ten, double donGia, int soLuongTon) {
        this.maSanPham = ma; this.tenSanPham = ten;
        this.donGia = donGia; this.soLuongTon = soLuongTon;
    }
    public String getMaSanPham()  { return maSanPham; }
    public String getTenSanPham() { return tenSanPham; }
    public double getDonGia()     { return donGia; }

    public double thanhTien(int soLuong) { return donGia * soLuong; }
}
