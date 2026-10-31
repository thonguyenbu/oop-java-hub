package bai01;

/*
 * Bài 1, 2, 3 - Lớp KhachHang: đóng gói, ba hàm khởi tạo, phương thức nghiệp vụ
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 3 - Lớp, đối tượng và phương thức
 */

public class KhachHang {

    // Mã khách hàng là định danh, không đổi sau khi tạo -> khai báo final,
    // vì vậy KHÔNG có setMaKhachHang.
    private final String maKhachHang;
    private String hoTen;
    private String soDienThoai;
    private String hangThanhVien;
    // Tổng chi tiêu chỉ tăng khi khách mua hàng, không được gán tùy ý từ
    // bên ngoài -> KHÔNG có setTongChiTieu, thay bằng phương thức nghiệp vụ
    // capNhatChiTieu có kiểm tra.
    private double tongChiTieu;

    // ----- Bài 2: ba hàm khởi tạo, hai hàm đầu gọi lại hàm đầy đủ -----
    public KhachHang() {
        this("CHUA_CO_MA", "Chưa đặt tên", "", "DONG", 0);
    }

    public KhachHang(String maKhachHang, String hoTen) {
        this(maKhachHang, hoTen, "", "DONG", 0);
    }

    public KhachHang(String maKhachHang, String hoTen, String soDienThoai,
                     String hangThanhVien, double tongChiTieu) {
        this.maKhachHang = maKhachHang;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        setHangThanhVien(hangThanhVien);
        this.tongChiTieu = tongChiTieu < 0 ? 0 : tongChiTieu;
    }

    // ----- getter cho mọi thuộc tính -----
    public String getMaKhachHang()   { return maKhachHang; }
    public String getHoTen()         { return hoTen; }
    public String getSoDienThoai()   { return soDienThoai; }
    public String getHangThanhVien() { return hangThanhVien; }
    public double getTongChiTieu()   { return tongChiTieu; }

    // ----- setter chỉ cho những thuộc tính được phép thay đổi -----
    public void setHoTen(String hoTen) {
        if (hoTen != null && !hoTen.isBlank()) this.hoTen = hoTen.strip();
    }

    public void setSoDienThoai(String soDienThoai) {
        if (soDienThoai != null) this.soDienThoai = soDienThoai.strip();
    }

    public void setHangThanhVien(String hangThanhVien) {
        if (hangThanhVien == null) { this.hangThanhVien = "DONG"; return; }
        String h = hangThanhVien.strip().toUpperCase();
        if (h.equals("VANG") || h.equals("BAC") || h.equals("DONG")) {
            this.hangThanhVien = h;
        } else {
            System.out.println("Từ chối: hạng thành viên không hợp lệ (" + hangThanhVien + ")");
            if (this.hangThanhVien == null) this.hangThanhVien = "DONG";
        }
    }

    // ----- Bài 3: phương thức nghiệp vụ -----
    public double layTiLeChietKhau() {
        if (hangThanhVien.equals("VANG")) return 0.10;
        if (hangThanhVien.equals("BAC"))  return 0.05;
        if (hangThanhVien.equals("DONG")) return 0.02;
        return 0;
    }

    public void capNhatChiTieu(double soTien) {
        if (soTien > 0) tongChiTieu += soTien;
    }

    public String moTa() {
        return String.format("%-8s %-20s %-13s %-6s %14.0f",
                maKhachHang, hoTen, soDienThoai, hangThanhVien, tongChiTieu);
    }
}
