package bai04;

/*
 * Bài 4 - Giao diện CoTinhThue với phương thức default
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class DichVu implements CoTinhThue {
    private String ten;
    private double phiDichVu;
 
    public DichVu(String ten, double phiDichVu) {
        this.ten = ten;
        this.phiDichVu = phiDichVu;
    }
    @Override public double giaTruocThue() { return phiDichVu; }
}
