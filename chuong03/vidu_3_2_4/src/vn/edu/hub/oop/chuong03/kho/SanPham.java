package vn.edu.hub.oop.chuong03.kho;
public class SanPham {
    private   String maSanPham;    // chỉ trong lớp SanPham
              String ghiChuNoiBo;  // mặc định: chỉ trong gói kho
    protected double giaVon;       // gói kho + các lớp con
    public    String tenSanPham;   // mọi nơi
    public SanPham(String ma, String ten) {
        this.maSanPham = ma;
        this.tenSanPham = ten;
        this.ghiChuNoiBo = "";
        this.giaVon = 0;
    }
    public String getMaSanPham() { return maSanPham; }
}
