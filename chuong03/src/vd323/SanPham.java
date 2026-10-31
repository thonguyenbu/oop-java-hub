package vd323;

public class SanPham {
    String maSanPham;
    String tenSanPham;
    double donGia;
    int soLuongTon;
    // Hàm khởi tạo không tham số
    SanPham() {
        this("CHUA_CO_MA", "Chưa đặt tên", 0, 0);
    }
    // Hàm khởi tạo chỉ với thông tin nhận diện
    SanPham(String maSanPham, String tenSanPham) {
        this(maSanPham, tenSanPham, 0, 0);
    }
    // Hàm khởi tạo đầy đủ
    SanPham(String maSanPham, String tenSanPham, double donGia, int soLuongTon) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.donGia = donGia < 0 ? 0 : donGia;
        this.soLuongTon = soLuongTon < 0 ? 0 : soLuongTon;
    }
    String moTa() {
        return maSanPham + " | " + tenSanPham
               + " | đơn giá " + donGia + " | tồn " + soLuongTon;
    }
}
