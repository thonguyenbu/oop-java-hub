package vd45;

/*
 * Mục 4.5 - Lớp final, phương thức final và lớp sealed
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class TaiKhoan {
    protected double soDu;
 
    // Không lớp con nào được phép đổi cách kiểm tra này
    public final boolean rutTienHopLe(double soTien) {
        return soTien > 0 && soTien <= soDu;
    }
 
    public double laiSuat() { return 0.001; }   // lớp con được phép ghi đè
}
