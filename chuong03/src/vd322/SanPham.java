package vd322;

public class SanPham {
    String maSanPham;
    String tenSanPham;
    double donGia;
    int soLuongTon;
    double giaTriTonKho() {
        return donGia * soLuongTon;
    }
    boolean duHang(int soLuongCan) {
        return soLuongTon >= soLuongCan;
    }
    void banHang(int soLuongBan) {
        if (soLuongBan <= 0) {
            System.out.println("Số lượng bán phải lớn hơn 0.");
            return;
        }
        if (!duHang(soLuongBan)) {
            System.out.println("Không đủ hàng: tồn " + soLuongTon
                               + ", cần " + soLuongBan);
            return;
        }
        soLuongTon = soLuongTon - soLuongBan;
    }
    String moTa() {
        return maSanPham + " | " + tenSanPham
               + " | đơn giá " + donGia + " | tồn " + soLuongTon;
    }
}
