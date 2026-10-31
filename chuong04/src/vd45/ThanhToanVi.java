package vd45;

/*
 * Mục 4.5 - Lớp final, phương thức final và lớp sealed
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public final class ThanhToanVi implements HinhThucThanhToan {
    @Override public double phiGiaoDich(double soTien) { return 1_100; }
}
