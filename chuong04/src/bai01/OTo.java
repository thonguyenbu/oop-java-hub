package bai01;

/*
 * Bài 1 - Phân cấp PhuongTien, XeMay, OTo
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class OTo extends PhuongTien {
    private int soChoNgoi;
    public OTo(String bienSo, double giaThue1Ngay, int soChoNgoi) {
        super(bienSo, giaThue1Ngay);
        this.soChoNgoi = soChoNgoi;
    }
    @Override public String loai() { return "Ô tô " + soChoNgoi + " chỗ"; }
    @Override public double tinhTienThue(int soNgay) {
        double tien = super.tinhTienThue(soNgay);
        return soNgay >= 7 ? tien * 0.9 : tien;
    }
}
