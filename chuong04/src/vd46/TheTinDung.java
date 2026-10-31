package vd46;

/*
 * Ví dụ 4.6 - Lớp trừu tượng ThanhToan và ba hình thức thanh toán
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class TheTinDung extends ThanhToan {
    private String soThe;
    public TheTinDung(String maGiaoDich, double soTien, String soThe) {
        super(maGiaoDich, soTien);
        this.soThe = soThe;
    }
    @Override public boolean thucHien() {
        System.out.println("  Gửi yêu cầu tới cổng thanh toán thẻ " + che(soThe));
        return true;
    }
    @Override public double phiGiaoDich() { return soTien * 0.022; }
 
    private String che(String so) {
        return "****" + so.substring(so.length() - 4);
    }
}
