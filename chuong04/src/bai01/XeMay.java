package bai01;

/*
 * Bài 1 - Phân cấp PhuongTien, XeMay, OTo
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class XeMay extends PhuongTien {
    public XeMay(String bienSo, double giaThue1Ngay) { super(bienSo, giaThue1Ngay); }
    @Override public String loai() { return "Xe máy"; }
}
