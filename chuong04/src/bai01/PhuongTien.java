package bai01;

/*
 * Bài 1 - Phân cấp PhuongTien, XeMay, OTo
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class PhuongTien {
    protected String bienSo;
    protected double giaThue1Ngay;
 
    public PhuongTien(String bienSo, double giaThue1Ngay) {
        this.bienSo = bienSo;
        this.giaThue1Ngay = giaThue1Ngay;
    }
    public double tinhTienThue(int soNgay) { return giaThue1Ngay * soNgay; }
    public String loai() { return "Phương tiện"; }
 
    @Override
    public String toString() {
        return String.format("%-12s %-14s %12.0f", bienSo, loai(), giaThue1Ngay);
    }
}
