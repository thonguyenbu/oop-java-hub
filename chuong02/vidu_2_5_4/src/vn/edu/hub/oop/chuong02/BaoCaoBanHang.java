package vn.edu.hub.oop.chuong02;
import java.util.Locale;
import vn.edu.hub.oop.chuong02.tienich.TinhTien;
public class BaoCaoBanHang {
    public static void main(String[] args) {
        Locale vn = Locale.forLanguageTag("vi-VN");
        double thanhTien = TinhTien.thanhTien(19_900, 3);
        double thue = TinhTien.tienThue(thanhTien);
        System.out.printf(vn, "Thành tiền : %,.0f đ%n", thanhTien);
        System.out.printf(vn, "Thuế VAT   : %,.0f đ%n", thue);
        System.out.printf(vn, "Tổng cộng  : %,.0f đ%n", thanhTien + thue);
    }
}
