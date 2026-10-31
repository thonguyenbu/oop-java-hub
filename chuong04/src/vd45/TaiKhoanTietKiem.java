package vd45;

/*
 * Mục 4.5 - Lớp final, phương thức final và lớp sealed
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class TaiKhoanTietKiem extends TaiKhoan {
    public TaiKhoanTietKiem(double soDu) { this.soDu = soDu; }

    @Override public double laiSuat() { return 0.055; }
    // @Override public boolean rutTienHopLe(double t) { return true; }  // LỖI: final
}
