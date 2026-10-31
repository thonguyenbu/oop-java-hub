package bai05;

/*
 * Bài 5 - Lớp trừu tượng TaiKhoan và ba loại tài khoản
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public abstract class TaiKhoan {
    private final String soTaiKhoan;
    protected double soDu;
 
    public TaiKhoan(String soTaiKhoan, double soDu) {
        this.soTaiKhoan = soTaiKhoan;
        this.soDu = soDu > 0 ? soDu : 0;
    }
 
    public abstract double laiSuatNam();
    public abstract String tenLoai();
 
    public double tienLaiMotNam() { return soDu * laiSuatNam(); }
 
    @Override
    public String toString() {
        return String.format("%-10s %-22s %14.0f %6.2f%% %14.0f",
                soTaiKhoan, tenLoai(), soDu, laiSuatNam() * 100, tienLaiMotNam());
    }
}
