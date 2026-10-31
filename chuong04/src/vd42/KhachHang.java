package vd42;

/*
 * Ví dụ 4.2 - Phân cấp ConNguoi và thứ tự chạy hàm khởi tạo
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class KhachHang extends ConNguoi {
    private String maKhachHang;
    private String hangThanhVien;
 
    public KhachHang(String maKhachHang, String hoTen, String soDienThoai,
                    String diaChi, String hangThanhVien) {
        super(hoTen, soDienThoai, diaChi);      // bắt buộc là câu lệnh đầu tiên
        this.maKhachHang = maKhachHang;
        this.hangThanhVien = hangThanhVien;
        System.out.println("  -> Hàm khởi tạo KhachHang chạy");
    }
 
    public double tiLeChietKhau() {
        return switch (hangThanhVien) {
            case "VANG" -> 0.10;
            case "BAC"  -> 0.05;
            case "DONG" -> 0.02;
            default     -> 0.0;
        };
    }
 
    public String getMaKhachHang() { return maKhachHang; }
 
    @Override public String thongTinLienHe() {    // ghi đè bản của ConNguoi
        return "[KH " + maKhachHang + "] " + super.thongTinLienHe()
               + " | hạng " + hangThanhVien;
    }
}
