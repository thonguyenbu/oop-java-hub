package vd47;

/*
 * Ví dụ 4.7 - Giao diện CoChietKhau và CoTheXuatHoaDon
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public interface CoChietKhau {
    double TI_LE_TOI_DA = 0.50;          // hằng: tự động public static final
 
    double tiLeChietKhau();               // trừu tượng: tự động public abstract
 
    default double tienGiam(double tongTien) {
        double tiLe = Math.min(tiLeChietKhau(), TI_LE_TOI_DA);
        return tongTien * tiLe;
    }
}
