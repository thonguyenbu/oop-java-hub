package tonghop;

/*
 * Ví dụ tổng hợp - Ứng dụng bán hàng: bốn tính chất cùng hoạt động
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public abstract class SanPham {
    private final String maSanPham;
    private String tenSanPham;
    private double donGia;
 
    public SanPham(String maSanPham, String tenSanPham, double donGia) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.donGia = donGia < 0 ? 0 : donGia;
    }
 
    public abstract String loaiSanPham();
 
    public double thanhTien(int soLuong) { return donGia * soLuong; }
 
    public String getMaSanPham()  { return maSanPham; }
    public String getTenSanPham() { return tenSanPham; }
    public double getDonGia()     { return donGia; }
 
    @Override
    public String toString() {
        return String.format("%-6s %-22s %-12s %10.0f",
                maSanPham, tenSanPham, loaiSanPham(), donGia);
    }
}
