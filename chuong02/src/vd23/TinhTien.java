package vd23;

import java.math.BigDecimal;
import java.math.RoundingMode;
public class TinhTien {
    public static void main(String[] args) {
        // Cách sai: dùng double
        double a = 0.1, b = 0.2;
        System.out.println("0.1 + 0.2 = " + (a + b));
        double tien = 0.0;
        for (int k = 0; k < 10; k++) {
            tien += 0.1;
        }
        System.out.println("Cộng 0.1 mười lần = " + tien);
        // Cách đúng: dùng BigDecimal
        BigDecimal donGia = new BigDecimal("19900");
        BigDecimal soLuong = new BigDecimal("3");
        BigDecimal thanhTien = donGia.multiply(soLuong);
        BigDecimal vat = thanhTien.multiply(new BigDecimal("0.08"))
                                  .setScale(0, RoundingMode.HALF_UP);
        System.out.printf("Thành tiền = %s%n", thanhTien);
        System.out.printf("VAT 8%%     = %s%n", vat);
        System.out.printf("Tổng cộng  = %s%n", thanhTien.add(vat));
    }
}
