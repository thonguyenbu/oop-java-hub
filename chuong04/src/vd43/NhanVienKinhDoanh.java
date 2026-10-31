package vd43;

/*
 * Ví dụ 4.3 – 4.5 - Đa hình, ghi đè, ép kiểu và toán tử instanceof
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class NhanVienKinhDoanh extends NhanVien {
    private double doanhSo;
    private double tiLeHoaHong;
 
    public NhanVienKinhDoanh(String maNhanVien, String hoTen, double luongCoBan,
                      double doanhSo, double tiLeHoaHong) {
        super(maNhanVien, hoTen, luongCoBan);
        this.doanhSo = doanhSo;
        this.tiLeHoaHong = tiLeHoaHong;
    }
 
    @Override
    public double tinhLuong() {
        return luongCoBan + doanhSo * tiLeHoaHong;
    }
 
    public double getDoanhSo() { return doanhSo; }
}
