package vd312;

public class DemoTaoDoiTuong {
    public static void main(String[] args) {
        SanPham sp1 = new SanPham();
        System.out.printf("Giá trị mặc định: %s | %s | %s | %s%n",
                sp1.maSanPham, sp1.tenSanPham, sp1.donGia, sp1.soLuongTon);
        sp1.maSanPham = "SP001";
        sp1.tenSanPham = "Cà phê hòa tan G7";
        sp1.donGia = 65000;
        sp1.soLuongTon = 120;
        SanPham sp2 = new SanPham();
        sp2.maSanPham = "SP002";
        sp2.tenSanPham = "Bánh quy bơ";
        sp2.donGia = 42000;
        sp2.soLuongTon = 85;
        System.out.printf("sp1: %s - %s - %s - %d%n",
                sp1.maSanPham, sp1.tenSanPham, sp1.donGia, sp1.soLuongTon);
        System.out.printf("sp2: %s - %s - %s - %d%n",
                sp2.maSanPham, sp2.tenSanPham, sp2.donGia, sp2.soLuongTon);
        sp1.donGia = -50000;
        System.out.println("Sau khi gán đơn giá âm: " + sp1.donGia);
    }
}
