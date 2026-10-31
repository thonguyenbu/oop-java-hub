package bai13;

/*
 * Bài 13 - Lớp KhachHang tự động nâng hạng khi vượt ngưỡng
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 3 - Lớp, đối tượng và phương thức
 */

public class KhachHang {

    public static final double NGUONG_HANG_BAC  =  5_000_000;
    public static final double NGUONG_HANG_VANG = 20_000_000;
    private static int soDoiTuongDaTao = 0;

    private final String maKhachHang;
    private String hoTen;
    private String hangThanhVien;
    private double tongChiTieu;

    public KhachHang(String maKhachHang, String hoTen, double tongChiTieu) {
        this.maKhachHang = maKhachHang;
        this.hoTen = hoTen;
        this.tongChiTieu = tongChiTieu < 0 ? 0 : tongChiTieu;
        capNhatHang();
        soDoiTuongDaTao++;
    }

    public String getMaKhachHang()   { return maKhachHang; }
    public String getHoTen()         { return hoTen; }
    public String getHangThanhVien() { return hangThanhVien; }
    public double getTongChiTieu()   { return tongChiTieu; }

    public static int getSoDoiTuongDaTao() { return soDoiTuongDaTao; }

    private void capNhatHang() {
        if (tongChiTieu >= NGUONG_HANG_VANG)      hangThanhVien = "VANG";
        else if (tongChiTieu >= NGUONG_HANG_BAC)  hangThanhVien = "BAC";
        else                                      hangThanhVien = "DONG";
    }

    public double layTiLeChietKhau() {
        if (hangThanhVien.equals("VANG")) return 0.10;
        if (hangThanhVien.equals("BAC"))  return 0.05;
        return 0.02;
    }

    /** Cộng dồn chi tiêu và tự động nâng hạng khi vượt ngưỡng. */
    public void capNhatChiTieu(double soTien) {
        if (soTien <= 0) return;
        String hangCu = hangThanhVien;
        tongChiTieu += soTien;
        capNhatHang();
        if (!hangCu.equals(hangThanhVien)) {
            System.out.printf("    [Nâng hạng] %s: %s -> %s%n",
                    maKhachHang, hangCu, hangThanhVien);
        }
    }

    public String moTa() {
        return String.format("%-8s %-20s %-6s %14.0f", maKhachHang, hoTen,
                hangThanhVien, tongChiTieu);
    }
}
