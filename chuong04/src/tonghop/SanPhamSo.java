package tonghop;

/*
 * Ví dụ tổng hợp - Ứng dụng bán hàng: bốn tính chất cùng hoạt động
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class SanPhamSo extends SanPham {
    private int soNgayHieuLuc;
 
    public SanPhamSo(String ma, String ten, double donGia, int soNgayHieuLuc) {
        super(ma, ten, donGia);
        this.soNgayHieuLuc = soNgayHieuLuc;
    }
 
    @Override public String loaiSanPham() { return "Hàng số"; }
 
    public String taoKhoaKichHoat() {
        return "KEY-" + getMaSanPham() + "-" + soNgayHieuLuc;
    }
}
