package tonghop;

/*
 * Ví dụ tổng hợp - Ứng dụng bán hàng: bốn tính chất cùng hoạt động
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class SanPhamVatLy extends SanPham implements CoTheGiaoHang {
    private double trongLuongKg;
    private int soLuongTon;
 
    public SanPhamVatLy(String ma, String ten, double donGia,
                        double trongLuongKg, int soLuongTon) {
        super(ma, ten, donGia);
        this.trongLuongKg = trongLuongKg;
        this.soLuongTon = soLuongTon;
    }
 
    @Override public String loaiSanPham() { return "Hàng vật lý"; }
 
    @Override public double phiVanChuyen() {
        return trongLuongKg <= 1 ? 20_000 : 20_000 + (trongLuongKg - 1) * 8_000;
    }
 
    public boolean xuatKho(int soLuong) {
        if (soLuong <= 0 || soLuong > soLuongTon) return false;
        soLuongTon -= soLuong;
        return true;
    }
    public int getSoLuongTon() { return soLuongTon; }
}
