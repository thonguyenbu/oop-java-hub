package vn.edu.hub.oop.chuong02.tienich;
public class TinhTien {
    public static final double THUE_SUAT_VAT = 0.08;
    public static double thanhTien(double donGia, int soLuong) {
        return donGia * soLuong;
    }
    public static double tienThue(double thanhTien) {
        return thanhTien * THUE_SUAT_VAT;
    }
}
