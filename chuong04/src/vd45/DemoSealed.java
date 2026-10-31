package vd45;

/*
 * Mục 4.5 - Lớp final, phương thức final và lớp sealed
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

import java.util.Locale;

public class DemoSealed {

    // Cách viết cho Java 17 (mục 4.5.2). Bản dùng switch so khớp mẫu nằm ở src21/vd45.
    static String tenHinhThuc(HinhThucThanhToan ht) {
        if (ht instanceof ThanhToanTienMat) return "Tiền mặt";
        if (ht instanceof ThanhToanThe)     return "Thẻ tín dụng";
        if (ht instanceof ThanhToanVi)      return "Ví điện tử";
        throw new IllegalStateException("Hình thức chưa được hỗ trợ: " + ht);
    }

    public static void main(String[] args) {
        Locale vn = Locale.forLanguageTag("vi-VN");
        double soTien = 1_250_000;

        HinhThucThanhToan[] cacHinhThuc = {
            new ThanhToanTienMat(), new ThanhToanThe(), new ThanhToanVi()
        };
        for (HinhThucThanhToan ht : cacHinhThuc) {
            System.out.printf(vn, "%-14s phí %,10.0f đ%n",
                    tenHinhThuc(ht), ht.phiGiaoDich(soTien));
        }

        System.out.println();
        System.out.println("Thuế suất VAT dùng chung: " + HangSo.THUE_SUAT_VAT);
        TaiKhoan tk = new TaiKhoanTietKiem(10_000_000);
        System.out.println("Lãi suất (đa hình): " + tk.laiSuat());
        System.out.println("Rút 3.000.000 hợp lệ? " + tk.rutTienHopLe(3_000_000));
        System.out.println("Rút 30.000.000 hợp lệ? " + tk.rutTienHopLe(30_000_000));
    }
}
