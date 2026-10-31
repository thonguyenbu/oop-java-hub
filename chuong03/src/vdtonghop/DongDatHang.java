package vdtonghop;

public class DongDatHang {
    private SanPham sanPham;
    private int soLuong;
    private double donGiaMua;   // đơn giá tại thời điểm bán
    public DongDatHang(SanPham sanPham, int soLuong) {
        this.sanPham = sanPham;
        this.soLuong = soLuong > 0 ? soLuong : 0;
        this.donGiaMua = sanPham.getDonGia();
    }
    public SanPham getSanPham() { return sanPham; }
    public int getSoLuong() { return soLuong; }
    public double getDonGiaMua() { return donGiaMua; }
    public double thanhTien() {
        return donGiaMua * soLuong;
    }
}
