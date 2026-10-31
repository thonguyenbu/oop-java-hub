package bai10;

/*
 * Bài 10 - Mở rộng ví dụ tổng hợp: dịch vụ, bảo hành, khách đại lý
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class DichVuLapDat extends SanPham implements CoBaoHanh {
    private double soGioCong;
    public DichVuLapDat(String ma, String ten, double donGiaMotGio, double soGioCong) {
        super(ma, ten, donGiaMotGio);
        this.soGioCong = soGioCong;
    }
    @Override public String loaiSanPham() { return "Dịch vụ"; }
    @Override public double thanhTien(int soLuong) {
        return getDonGia() * soGioCong * soLuong;
    }
    @Override public int soThangBaoHanh() { return 6; }
}
