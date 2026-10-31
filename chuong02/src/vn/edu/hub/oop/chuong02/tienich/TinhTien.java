package vn.edu.hub.oop.chuong02.tienich;

/*
 * Bài 9 - Lớp tiện ích: các phép tính tiền hàng và xếp hạng
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 2 - Cơ bản về ngôn ngữ lập trình Java
 *
 * Biên dịch: javac -encoding UTF-8 -d bin <đường dẫn tệp>
 */

public class TinhTien {

    public static final double THUE_SUAT_VAT = 0.08;

    public static double thanhTien(double donGia, int soLuong) {
        return donGia * soLuong;
    }

    public static double tienThue(double thanhTien) {
        return thanhTien * THUE_SUAT_VAT;
    }

    public static String xepHang(double tongChiTieu) {
        if (tongChiTieu >= 20_000_000) return "VÀNG";
        else if (tongChiTieu >= 5_000_000) return "BẠC";
        else return "ĐỒNG";
    }
}
