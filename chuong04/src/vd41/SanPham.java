package vd41;

/*
 * Ví dụ 4.1 - Rò rỉ dữ liệu qua getter trả về mảng bên trong
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

import java.util.Arrays;

public class SanPham {
    private String maSanPham;
    private double donGia;
    private double[] lichSuGia;
    private int soLanDoiGia;
 
    public SanPham(String maSanPham, double donGia) {
        this.maSanPham = maSanPham;
        this.donGia = donGia;
        this.lichSuGia = new double[10];
        this.lichSuGia[0] = donGia;
        this.soLanDoiGia = 1;
    }
 
    public void doiGia(double giaMoi) {
        if (giaMoi < 0 || soLanDoiGia >= lichSuGia.length) return;
        this.donGia = giaMoi;
        this.lichSuGia[soLanDoiGia] = giaMoi;
        this.soLanDoiGia++;
    }
 
    // CÁCH SAI: trả về chính mảng bên trong
    public double[] getLichSuGiaSai() {
        return lichSuGia;
    }
 
    // CÁCH ĐÚNG: trả về bản sao đúng phần đã dùng
    public double[] getLichSuGia() {
        return Arrays.copyOf(lichSuGia, soLanDoiGia);
    }
}
