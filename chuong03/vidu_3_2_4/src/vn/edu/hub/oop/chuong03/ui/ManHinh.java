package vn.edu.hub.oop.chuong03.ui;
import vn.edu.hub.oop.chuong03.kho.SanPham;
public class ManHinh {
    public static void main(String[] args) {
        SanPham p = new SanPham("SP001", "Cà phê hòa tan G7");
        System.out.println(p.tenSanPham);       // public -> được
        System.out.println(p.getMaSanPham());   // qua phương thức public -> được
        System.out.println(p.ghiChuNoiBo);      // mặc định, khác gói -> LỖI
    }
}
