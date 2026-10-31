package vd333;

/*
 * Ví dụ 3.7 (mục 3.3.3) - Hai cách tác động lên đối tượng được truyền vào.
 * Sách in hai phương thức và main dưới dạng đoạn mã rời; kho bổ sung lớp bao
 * DemoTruyenDoiTuong để chạy được. Thân các phương thức giữ nguyên như in trong sách.
 */

public class DemoTruyenDoiTuong {
    static void tangGia(SanPham sp, double tiLe) {
        sp.setDonGia(sp.getDonGia() * (1 + tiLe));
    }
    static void thayTheSanPham(SanPham sp) {
        sp = new SanPham("SP999", "Sản phẩm khác", 1000, 1);
    }
    public static void main(String[] args) {
        SanPham sp = new SanPham("SP001", "Cà phê hòa tan G7", 65000, 120);
        tangGia(sp, 0.10);
        System.out.println("Sau tangGia(sp, 0.10): " + sp.getDonGia());
        thayTheSanPham(sp);
        System.out.println("Sau thayTheSanPham(sp): " + sp.getMaSanPham());
    }
}
