package tonghop;

/*
 * Ví dụ tổng hợp - Ứng dụng bán hàng: bốn tính chất cùng hoạt động
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
 
    public String moTa() {
        return maKhachHang + " " + ten + " (chiết khấu "
               + Math.round(tiLeChietKhau() * 100) + "%)";
    }
}
