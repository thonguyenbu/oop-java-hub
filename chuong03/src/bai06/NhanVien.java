package bai06;

/*
 * Bài 6 - Lớp NhanVien với hằng tĩnh SO_NGAY_CONG_CHUAN
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 3 - Lớp, đối tượng và phương thức
 */

public class NhanVien {

    public static final int SO_NGAY_CONG_CHUAN = 26;   // hằng tĩnh dùng chung

    private final String maNhanVien;
    private String hoTen;
    private String phongBan;
    private double luongCoBan;
    private int soNgayCong;

    public NhanVien(String maNhanVien, String hoTen, String phongBan,
                    double luongCoBan, int soNgayCong) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.phongBan = phongBan;
        setLuongCoBan(luongCoBan);
        setSoNgayCong(soNgayCong);
    }

    public String getMaNhanVien() { return maNhanVien; }
    public String getHoTen()      { return hoTen; }
    public String getPhongBan()   { return phongBan; }
    public double getLuongCoBan() { return luongCoBan; }
    public int    getSoNgayCong() { return soNgayCong; }

    public void setPhongBan(String phongBan) {
        if (phongBan != null && !phongBan.isBlank()) this.phongBan = phongBan.strip();
    }

    public void setLuongCoBan(double luongCoBan) {
        if (luongCoBan < 0) {
            System.out.println("Từ chối: lương cơ bản không được âm");
            return;
        }
        this.luongCoBan = luongCoBan;
    }

    public void setSoNgayCong(int soNgayCong) {
        if (soNgayCong < 0 || soNgayCong > 31) {
            System.out.println("Từ chối: số ngày công phải từ 0 đến 31 (" + soNgayCong + ")");
            return;
        }
        this.soNgayCong = soNgayCong;
    }

    public double tinhLuong() {
        return luongCoBan * soNgayCong / SO_NGAY_CONG_CHUAN;
    }

    public String moTa() {
        return String.format("%-6s %-20s %-14s %14.0f %6d %14.0f",
                maNhanVien, hoTen, phongBan, luongCoBan, soNgayCong, tinhLuong());
    }
}
