package bai09;

/*
 * Bài 9 - Lớp SinhVien: mã bất biến, ràng buộc điểm, bộ đếm tĩnh
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 3 - Lớp, đối tượng và phương thức
 */

public class SinhVien {

    private static int soSinhVienDaTao = 0;

    private final String maSoSinhVien;      // bất biến
    private String hoTen;
    private String ngaySinh;
    private double diemTrungBinh;           // chỉ nhận 0 đến 4
    private int soTinChiDaDat;

    public SinhVien(String maSoSinhVien, String hoTen, String ngaySinh,
                    double diemTrungBinh, int soTinChiDaDat) {
        this.maSoSinhVien = maSoSinhVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        setDiemTrungBinh(diemTrungBinh);
        setSoTinChiDaDat(soTinChiDaDat);
        soSinhVienDaTao++;
    }

    public String getMaSoSinhVien()  { return maSoSinhVien; }
    public String getHoTen()         { return hoTen; }
    public String getNgaySinh()      { return ngaySinh; }
    public double getDiemTrungBinh() { return diemTrungBinh; }
    public int    getSoTinChiDaDat() { return soTinChiDaDat; }

    public static int getSoSinhVienDaTao() { return soSinhVienDaTao; }

    public void setHoTen(String hoTen) {
        if (hoTen != null && !hoTen.isBlank()) this.hoTen = hoTen.strip();
    }

    public void setDiemTrungBinh(double diemTrungBinh) {
        if (diemTrungBinh < 0 || diemTrungBinh > 4) {
            System.out.println("Từ chối: điểm trung bình phải từ 0 đến 4 ("
                    + diemTrungBinh + ")");
            return;
        }
        this.diemTrungBinh = diemTrungBinh;
    }

    public void setSoTinChiDaDat(int soTinChiDaDat) {
        if (soTinChiDaDat < 0) {
            System.out.println("Từ chối: số tín chỉ không được âm");
            return;
        }
        this.soTinChiDaDat = soTinChiDaDat;
    }

    public String xepLoaiHocLuc() {
        if (diemTrungBinh >= 3.6) return "Xuất sắc";
        if (diemTrungBinh >= 3.2) return "Giỏi";
        if (diemTrungBinh >= 2.5) return "Khá";
        if (diemTrungBinh >= 2.0) return "Trung bình";
        return "Yếu";
    }

    public String moTa() {
        return String.format("%-10s %-20s %-12s %6.2f %8d   %s",
                maSoSinhVien, hoTen, ngaySinh, diemTrungBinh,
                soTinChiDaDat, xepLoaiHocLuc());
    }
}
