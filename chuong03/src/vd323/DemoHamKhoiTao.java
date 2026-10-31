package vd323;

public class DemoHamKhoiTao {
    public static void main(String[] args) {
        SanPham sp1 = new SanPham();
        SanPham sp2 = new SanPham("SP002", "Bánh quy bơ");
        SanPham sp3 = new SanPham("SP003", "Nước suối 500ml", 6000, 500);
        SanPham sp4 = new SanPham("SP004", "Trà xanh", -12000, -3);
        System.out.println(sp1.moTa());
        System.out.println(sp2.moTa());
        System.out.println(sp3.moTa());
        System.out.println(sp4.moTa());
    }
}
