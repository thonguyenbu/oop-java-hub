package bai06;

/*
 * Bài 6 - Duyệt mảng hỗn hợp bằng instanceof so khớp mẫu
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class TruongPhong extends NhanVien {
    private double phuCapTrachNhiem;
    private int soNhanVienQuanLy;
 
    public TruongPhong(String maNhanVien, String hoTen, double luongCoBan,
                   double phuCapTrachNhiem, int soNhanVienQuanLy) {
        super(maNhanVien, hoTen, luongCoBan);
        this.phuCapTrachNhiem = phuCapTrachNhiem;
        this.soNhanVienQuanLy = soNhanVienQuanLy;
    }
 
    @Override
    public double tinhLuong() {
        return super.tinhLuong() + phuCapTrachNhiem;
    }
 
    public void hopGiaoBan() {
        System.out.printf("  %s chủ trì họp giao ban với %d nhân viên.%n",
                          getHoTen(), soNhanVienQuanLy);
    }
}
