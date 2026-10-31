package vd353;

public class TaiKhoan {
    public static final String TEN_NGAN_HANG = "NGAN HANG HUB";
    public static final double LAI_SUAT_KHONG_KY_HAN = 0.001;
    private static int soTaiKhoanDaMo = 0;
    private static double tongSoDuToanHeThong = 0;
    private final String soTaiKhoan;
    private String chuTaiKhoan;
    private double soDu;
    public TaiKhoan(String chuTaiKhoan, double soDuBanDau) {
        soTaiKhoanDaMo++;
        this.soTaiKhoan = String.format("TK%05d", soTaiKhoanDaMo);
        this.chuTaiKhoan = chuTaiKhoan;
        this.soDu = soDuBanDau > 0 ? soDuBanDau : 0;
        tongSoDuToanHeThong += this.soDu;
    }
    public void nopTien(double soTien) {
        if (soTien <= 0) return;
        soDu += soTien;
        tongSoDuToanHeThong += soTien;
    }
    public boolean rutTien(double soTien) {
        if (soTien <= 0 || soTien > soDu) return false;
        soDu -= soTien;
        tongSoDuToanHeThong -= soTien;
        return true;
    }
    public String getSoTaiKhoan()  { return soTaiKhoan; }
    public String getChuTaiKhoan() { return chuTaiKhoan; }
    public double getSoDu()        { return soDu; }
    public static int    getSoTaiKhoanDaMo()      { return soTaiKhoanDaMo; }
    public static double getTongSoDuToanHeThong() { return tongSoDuToanHeThong; }
    public static double tienLaiThang(double soDu) {
        return soDu * LAI_SUAT_KHONG_KY_HAN / 12;
    }
}
