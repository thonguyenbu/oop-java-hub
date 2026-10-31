package bai05;

/*
 * Bài 5 - Lớp trừu tượng TaiKhoan và ba loại tài khoản
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class TaiKhoanTietKiemKyHan extends TaiKhoan {
    private int soThang;
    public TaiKhoanTietKiemKyHan(String so, double soDu, int soThang) {
        super(so, soDu);
        this.soThang = soThang;
    }
    @Override public double laiSuatNam() {
        if (soThang >= 12) return 0.058;
        if (soThang >= 6)  return 0.050;
        return 0.042;
    }
    @Override public String tenLoai() { return "Tiết kiệm " + soThang + " tháng"; }
}
