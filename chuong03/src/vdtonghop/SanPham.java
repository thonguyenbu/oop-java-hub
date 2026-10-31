package vdtonghop;

public class SanPham {
    public static final double THUE_SUAT_VAT = 0.08;
    private static int soDoiTuongDaTao = 0;
    private String maSanPham;
    private String tenSanPham;
    private double donGia;
    private int soLuongTon;
    public SanPham(String maSanPham, String tenSanPham,
                   double donGia, int soLuongTon) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        setDonGia(donGia);
        setSoLuongTon(soLuongTon);
        soDoiTuongDaTao++;
    }
    public SanPham(String maSanPham, String tenSanPham) {
        this(maSanPham, tenSanPham, 0, 0);
    }
    // ----- getter / setter -----
    public String getMaSanPham()  { return maSanPham; }
    public String getTenSanPham() { return tenSanPham; }
    public double getDonGia()     { return donGia; }
    public int    getSoLuongTon() { return soLuongTon; }
    public void setTenSanPham(String tenSanPham) {
        if (tenSanPham != null && !tenSanPham.isBlank()) {
            this.tenSanPham = tenSanPham.strip();
        }
    }
    public void setDonGia(double donGia) {
        if (donGia < 0) {
            System.out.println("Từ chối: đơn giá không được âm (" + donGia + ")");
            return;
        }
        this.donGia = donGia;
    }
    public void setSoLuongTon(int soLuongTon) {
        if (soLuongTon < 0) {
            System.out.println("Từ chối: tồn kho không được âm (" + soLuongTon + ")");
            return;
        }
        this.soLuongTon = soLuongTon;
    }
    // ----- phương thức nghiệp vụ -----
    public double giaTriTonKho() { return donGia * soLuongTon; }
    public double thanhTien(int soLuong) { return donGia * soLuong; }
    public double thanhTien(int soLuong, double tiLeChietKhau) {
        return donGia * soLuong * (1 - tiLeChietKhau);
    }
    public void nhapKho(int soLuong) {
        if (soLuong > 0) soLuongTon += soLuong;
    }
    public boolean xuatKho(int soLuong) {
        if (soLuong <= 0 || soLuong > soLuongTon) return false;
        soLuongTon -= soLuong;
        return true;
    }
    public String moTa() {
        return String.format("%-6s %-22s %10.0f %6d",
                             maSanPham, tenSanPham, donGia, soLuongTon);
    }
    // ----- thành phần tĩnh -----
    public static int getSoDoiTuongDaTao() { return soDoiTuongDaTao; }
    public static double tienThue(double thanhTien) {
        return thanhTien * THUE_SUAT_VAT;
    }
}
