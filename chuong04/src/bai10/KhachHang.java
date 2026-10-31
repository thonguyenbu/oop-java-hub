package bai10;

/*
 * Bài 10 - Mở rộng ví dụ tổng hợp: dịch vụ, bảo hành, khách đại lý
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public abstract class KhachHang {
    protected String maKhachHang;
    protected String ten;
 
    public KhachHang(String maKhachHang, String ten) {
        this.maKhachHang = maKhachHang;
        this.ten = ten;
    }
 
    public abstract double tiLeChietKhau();
 
    public double tienGiam(double tongTien) { return tongTien * tiLeChietKhau(); }
    public String getTen() { return ten; }
 
    // Bổ sung cho Bài 10: quy tắc số lượng tối thiểu, mặc định chỉ cần dương
    public boolean chapNhanSoLuong(int soLuong) { return soLuong > 0; }

    public String moTa() {
        return maKhachHang + " " + ten + " (chiết khấu "
               + Math.round(tiLeChietKhau() * 100) + "%)";
    }
}
