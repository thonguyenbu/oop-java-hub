package bai08;

/*
 * Bài 8 - Kết hợp lớp trừu tượng với giao diện CoThuong
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class NhanVienVanPhong extends NhanVien {
    public NhanVienVanPhong(String ma, String ten, double luong) { super(ma, ten, luong); }
    @Override public double tinhLuong() { return luongCoBan; }
}
