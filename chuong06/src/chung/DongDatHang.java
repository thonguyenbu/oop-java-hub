package chung;

/*
 * Lớp dùng chung - Lớp thực thể và giao diện kho dữ liệu dùng chung
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 6 - Xây dựng ứng dụng hướng đối tượng
 */

public class DongDatHang {
    private final String maSanPham;
    private final int soLuong;

    public DongDatHang(String maSanPham, int soLuong) {
        this.maSanPham = maSanPham;
        this.soLuong = soLuong;
    }
    public String getMaSanPham() { return maSanPham; }
    public int getSoLuong()      { return soLuong; }
}
