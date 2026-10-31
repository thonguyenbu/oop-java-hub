package bai08;

/*
 * Bài 8 - Kết hợp lớp trừu tượng với giao diện CoThuong
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class NhanVienKinhDoanh extends NhanVien implements CoThuong {
    private double doanhSo;
    public NhanVienKinhDoanh(String ma, String ten, double luong, double doanhSo) {
        super(ma, ten, luong);
        this.doanhSo = doanhSo;
    }
    @Override public double tinhLuong()  { return luongCoBan + doanhSo * 0.02; }
    @Override public double tienThuong() {
        return doanhSo >= 1_000_000_000.0 ? 60_000_000 : 5_000_000;
    }
}
