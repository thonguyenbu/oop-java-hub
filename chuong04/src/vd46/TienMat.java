package vd46;

/*
 * Ví dụ 4.6 - Lớp trừu tượng ThanhToan và ba hình thức thanh toán
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class TienMat extends ThanhToan {
    public TienMat(String maGiaoDich, double soTien) {
        super(maGiaoDich, soTien);
    }
    @Override public boolean thucHien() {
        System.out.printf("  Thu tiền mặt %.0f đ tại quầy.%n", soTien);
        return true;
    }
    @Override public double phiGiaoDich() { return 0; }
}
