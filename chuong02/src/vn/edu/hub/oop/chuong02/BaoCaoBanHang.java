package vn.edu.hub.oop.chuong02;

/*
 * Bài 9 - Lớp có phương thức main, gọi sang các lớp tiện ích ở gói con
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 2 - Cơ bản về ngôn ngữ lập trình Java
 *
 * Biên dịch: javac -encoding UTF-8 -d bin <đường dẫn tệp>
 */

import java.util.Locale;
import vn.edu.hub.oop.chuong02.tienich.ChuanHoa;
import vn.edu.hub.oop.chuong02.tienich.TinhTien;

public class BaoCaoBanHang {
    public static void main(String[] args) {
        Locale vn = Locale.forLanguageTag("vi-VN");

        String maNhap = "  sp001  ";
        String ma = ChuanHoa.chuanHoaMa(maNhap);
        System.out.println("Mã nhập vào   : [" + maNhap + "]");
        System.out.println("Sau chuẩn hóa : " + ma);

        double thanhTien = TinhTien.thanhTien(65_000, 7);
        double thue = TinhTien.tienThue(thanhTien);
        System.out.println();
        System.out.printf(vn, "Thành tiền : %,12.0f đ%n", thanhTien);
        System.out.printf(vn, "Thuế VAT   : %,12.0f đ%n", thue);
        System.out.printf(vn, "Tổng cộng  : %,12.0f đ%n", thanhTien + thue);
        System.out.println();
        System.out.println("Hạng của khách chi tiêu 12.500.000 đ: "
                + TinhTien.xepHang(12_500_000));
    }
}
