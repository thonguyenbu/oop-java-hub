package bai13;

/*
 * Bài 13 - Lớp SanPham có mức tồn tối thiểu và canDatHang
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 3 - Lớp, đối tượng và phương thức
 */

public class SanPham {

    public static final double THUE_SUAT_VAT = 0.08;
    private static int soDoiTuongDaTao = 0;

    private final String maSanPham;
    private String tenSanPham;
    private double donGia;
    private int soLuongTon;
    private int mucTonToiThieu;

    public SanPham(String maSanPham, String tenSanPham, double donGia,
                   int soLuongTon, int mucTonToiThieu) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        setDonGia(donGia);
        setSoLuongTon(soLuongTon);
        this.mucTonToiThieu = mucTonToiThieu < 0 ? 0 : mucTonToiThieu;
        soDoiTuongDaTao++;
    }

    public String getMaSanPham()   { return maSanPham; }
    public String getTenSanPham()  { return tenSanPham; }
    public double getDonGia()      { return donGia; }
    public int    getSoLuongTon()  { return soLuongTon; }
    public int    getMucTonToiThieu() { return mucTonToiThieu; }

    public static int getSoDoiTuongDaTao() { return soDoiTuongDaTao; }

    public void setDonGia(double donGia) {
        if (donGia < 0) { System.out.println("Từ chối: đơn giá không được âm"); return; }
        this.donGia = donGia;
    }

    public void setSoLuongTon(int soLuongTon) {
        if (soLuongTon < 0) { System.out.println("Từ chối: tồn kho không được âm"); return; }
        this.soLuongTon = soLuongTon;
    }

    public void nhapKho(int soLuong) {
        if (soLuong > 0) soLuongTon += soLuong;
    }

    public boolean xuatKho(int soLuong) {
        if (soLuong <= 0 || soLuong > soLuongTon) return false;
        soLuongTon -= soLuong;
        return true;
    }

    public boolean canDatHang() {
        return soLuongTon < mucTonToiThieu;
    }

    public String moTa() {
        return String.format("%-6s %-24s %12.0f %8d %8d   %s",
                maSanPham, tenSanPham, donGia, soLuongTon, mucTonToiThieu,
                canDatHang() ? "CẦN ĐẶT HÀNG" : "");
    }
}
