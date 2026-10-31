package bai05;

/*
 * Bài 5 - Lớp trừu tượng TaiKhoan và ba loại tài khoản
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class TaiKhoanThanhToan extends TaiKhoan {
    public TaiKhoanThanhToan(String so, double soDu) { super(so, soDu); }
    @Override public double laiSuatNam() { return 0.001; }
    @Override public String tenLoai()    { return "Thanh toán"; }
}
