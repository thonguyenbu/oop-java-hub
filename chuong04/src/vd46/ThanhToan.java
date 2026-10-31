package vd46;

/*
 * Ví dụ 4.6 - Lớp trừu tượng ThanhToan và ba hình thức thanh toán
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public abstract class ThanhToan {
    protected String maGiaoDich;
    protected double soTien;
 
    public ThanhToan(String maGiaoDich, double soTien) {
        this.maGiaoDich = maGiaoDich;
        this.soTien = soTien;
    }
 
    // Phương thức trừu tượng: mỗi hình thức tự quyết định cách thực hiện
    public abstract boolean thucHien();
 
    // Phương thức trừu tượng: phí giao dịch khác nhau theo hình thức
    public abstract double phiGiaoDich();
 
    // Phương thức thường: dùng chung cho mọi hình thức
    public double tongPhaiTra() {
        return soTien + phiGiaoDich();
    }
 
    @Override
    public String toString() {
        return String.format("%-10s %-22s %12.0f %10.0f %12.0f",
                maGiaoDich, getClass().getSimpleName(),
                soTien, phiGiaoDich(), tongPhaiTra());
    }
}
