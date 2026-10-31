package vd334;

/*
 * Lớp SanPham dùng cho mục 3.3.4. Sách không in riêng lớp này mà ghi: "Ví dụ dùng lớp
 * SanPham gồm hàm khởi tạo bốn tham số của Ví dụ 3.5 cùng hai phương thức giaTriTonKho()
 * và moTa() của Ví dụ 3.4". Kho ghép đúng các phần đó, giữ nguyên mã như in trong sách.
 */

public class SanPham {
    String maSanPham;
    String tenSanPham;
    double donGia;
    int soLuongTon;
    // Hàm khởi tạo đầy đủ
    SanPham(String maSanPham, String tenSanPham, double donGia, int soLuongTon) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.donGia = donGia < 0 ? 0 : donGia;
        this.soLuongTon = soLuongTon < 0 ? 0 : soLuongTon;
    }
    double giaTriTonKho() {
        return donGia * soLuongTon;
    }
    String moTa() {
        return maSanPham + " | " + tenSanPham
               + " | đơn giá " + donGia + " | tồn " + soLuongTon;
    }
}
