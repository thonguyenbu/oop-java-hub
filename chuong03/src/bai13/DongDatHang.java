package bai13;

/*
 * Bài 13 - Lớp DongDatHang giữ đơn giá tại thời điểm mua
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 3 - Lớp, đối tượng và phương thức
 */

public class DongDatHang {

    private static int soDoiTuongDaTao = 0;

    private final SanPham sanPham;
    private final int soLuong;
    private final double donGiaLucMua;   // giữ giá tại thời điểm mua

    public DongDatHang(SanPham sanPham, int soLuong) {
        this.sanPham = sanPham;
        this.soLuong = soLuong;
        this.donGiaLucMua = sanPham.getDonGia();
        soDoiTuongDaTao++;
    }

    public SanPham getSanPham()    { return sanPham; }
    public int    getSoLuong()     { return soLuong; }
    public double getDonGiaLucMua(){ return donGiaLucMua; }

    public static int getSoDoiTuongDaTao() { return soDoiTuongDaTao; }

    public double thanhTien() {
        return donGiaLucMua * soLuong;
    }

    public String moTa() {
        return String.format("  %-6s %-24s %12.0f %6d %14.0f",
                sanPham.getMaSanPham(), sanPham.getTenSanPham(),
                donGiaLucMua, soLuong, thanhTien());
    }
}
