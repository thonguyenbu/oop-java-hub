package vd46;

/*
 * Ví dụ 4.6 - Lớp trừu tượng ThanhToan và ba hình thức thanh toán
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class ViDienTu extends ThanhToan {
    private String soDienThoai;
    public ViDienTu(String maGiaoDich, double soTien, String soDienThoai) {
        super(maGiaoDich, soTien);
        this.soDienThoai = soDienThoai;
    }
    @Override public boolean thucHien() {
        System.out.println("  Trừ ví điện tử của số " + soDienThoai);
        return true;
    }
    @Override public double phiGiaoDich() { return 1_100; }
}
