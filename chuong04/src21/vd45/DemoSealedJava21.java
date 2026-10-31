package vd45;

/*
 * Mục 4.5 - Lớp final, phương thức final và lớp sealed
 * Phiên bản dùng switch so khớp mẫu: cần Java 21 trở lên
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

import java.util.Locale;

public class DemoSealedJava21 {

static String tenHinhThuc(HinhThucThanhToan ht) {
    return switch (ht) {
        case ThanhToanTienMat t -> "Tiền mặt";
        case ThanhToanThe t     -> "Thẻ tín dụng";
        case ThanhToanVi t      -> "Ví điện tử";
    };
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
