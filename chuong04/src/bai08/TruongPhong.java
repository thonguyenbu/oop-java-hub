package bai08;

/*
 * Bài 8 - Kết hợp lớp trừu tượng với giao diện CoThuong
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class TruongPhong extends NhanVien implements CoThuong {
    private int soNhanVien;
    public TruongPhong(String ma, String ten, double luong, int soNhanVien) {
        super(ma, ten, luong);
        this.soNhanVien = soNhanVien;
    }
    @Override public double tinhLuong()  { return luongCoBan + soNhanVien * 500_000; }
    @Override public double tienThuong() { return 20_000_000; }
}
