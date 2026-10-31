package bai07;

/*
 * Bài 7 - Ba phương thức nạp chồng thanhTien dùng lại lẫn nhau
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 3 - Lớp, đối tượng và phương thức
 */

public class SanPham {

    public static final double THUE_SUAT_VAT = 0.08;

    private final String maSanPham;
    private String tenSanPham;
    private double donGia;
    private int soLuongTon;

    public SanPham(String maSanPham, String tenSanPham, double donGia, int soLuongTon) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        setDonGia(donGia);
        setSoLuongTon(soLuongTon);
    }

    public String getMaSanPham()  { return maSanPham; }
    public String getTenSanPham() { return tenSanPham; }
    public double getDonGia()     { return donGia; }
    public int    getSoLuongTon() { return soLuongTon; }

    public void setDonGia(double donGia) {
        if (donGia < 0) { System.out.println("Từ chối: đơn giá không được âm"); return; }
        this.donGia = donGia;
    }
    public void setSoLuongTon(int soLuongTon) {
        if (soLuongTon < 0) { System.out.println("Từ chối: tồn kho không được âm"); return; }
        this.soLuongTon = soLuongTon;
    }

    // ----- Bài 7: ba phương thức nạp chồng, dùng lại lẫn nhau -----

    /** Phiên bản 1: chỉ nhân đơn giá với số lượng. */
    public double thanhTien(int soLuong) {
        return donGia * soLuong;
    }

    /** Phiên bản 2: gọi lại phiên bản 1 rồi trừ chiết khấu. */
    public double thanhTien(int soLuong, double tiLeChietKhau) {
        if (tiLeChietKhau < 0 || tiLeChietKhau > 1) tiLeChietKhau = 0;
        return thanhTien(soLuong) * (1 - tiLeChietKhau);
    }

    /** Phiên bản 3: gọi lại phiên bản 2 rồi cộng thuế. */
    public double thanhTien(int soLuong, double tiLeChietKhau, double thueSuat) {
        if (thueSuat < 0) thueSuat = 0;
        return thanhTien(soLuong, tiLeChietKhau) * (1 + thueSuat);
    }
}
