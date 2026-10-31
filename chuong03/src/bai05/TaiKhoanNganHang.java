package bai05;

/*
 * Bài 5 - Lớp TaiKhoanNganHang: nộp, rút, chuyển khoản, hạn mức thấu chi
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 3 - Lớp, đối tượng và phương thức
 */

public class TaiKhoanNganHang {

    private static int soTaiKhoanDaCap = 0;          // bộ đếm tĩnh sinh số tài khoản

    private final String soTaiKhoan;                 // bất biến, sinh tự động
    private String chuTaiKhoan;
    private double soDu;
    private double hanMucThauChi;

    public TaiKhoanNganHang(String chuTaiKhoan, double soDuBanDau, double hanMucThauChi) {
        soTaiKhoanDaCap++;
        this.soTaiKhoan = String.format("TK%05d", soTaiKhoanDaCap);
        this.chuTaiKhoan = chuTaiKhoan;
        this.soDu = soDuBanDau > 0 ? soDuBanDau : 0;
        this.hanMucThauChi = hanMucThauChi > 0 ? hanMucThauChi : 0;
    }

    public String getSoTaiKhoan()    { return soTaiKhoan; }
    public String getChuTaiKhoan()   { return chuTaiKhoan; }
    public double getSoDu()          { return soDu; }
    public double getHanMucThauChi() { return hanMucThauChi; }

    public static int getSoTaiKhoanDaCap() { return soTaiKhoanDaCap; }

    /** a) Chỉ chấp nhận số tiền dương. */
    public boolean nopTien(double soTien) {
        if (soTien <= 0) {
            System.out.printf("  [%s] Từ chối nộp: số tiền phải dương (%.0f)%n",
                    soTaiKhoan, soTien);
            return false;
        }
        soDu += soTien;
        return true;
    }

    /** b) Chỉ cho rút khi số tiền dương và không vượt số dư cộng hạn mức thấu chi. */
    public boolean rutTien(double soTien) {
        if (soTien <= 0) {
            System.out.printf("  [%s] Từ chối rút: số tiền phải dương (%.0f)%n",
                    soTaiKhoan, soTien);
            return false;
        }
        if (soTien > soDu + hanMucThauChi) {
            System.out.printf("  [%s] Từ chối rút %.0f: vượt khả năng chi trả "
                    + "(số dư %.0f + thấu chi %.0f)%n",
                    soTaiKhoan, soTien, soDu, hanMucThauChi);
            return false;
        }
        soDu -= soTien;
        return true;
    }

    /** c) Chỉ nộp cho tài khoản nhận khi phép rút thành công. */
    public boolean chuyenKhoan(TaiKhoanNganHang nhan, double soTien) {
        if (nhan == null || nhan == this) {
            System.out.println("  Từ chối chuyển khoản: tài khoản nhận không hợp lệ");
            return false;
        }
        if (!rutTien(soTien)) return false;       // rút hỏng thì dừng, không nộp
        nhan.nopTien(soTien);
        return true;
    }

    public String moTa() {
        return String.format("%-8s %-20s %14.0f %12.0f",
                soTaiKhoan, chuTaiKhoan, soDu, hanMucThauChi);
    }
}
