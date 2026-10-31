package vd274;

import java.util.*;
public class ThongKeDoanhThu {
    public static void main(String[] args) {
        Locale vn = Locale.forLanguageTag("vi-VN");
        // Bảng giá tra cứu theo mã sản phẩm
        Map<String, Double> bangGia = new HashMap<>();
        bangGia.put("SP001", 19900.0);
        bangGia.put("SP002", 42000.0);
        bangGia.put("SP003", 6000.0);
        // Dữ liệu bán hàng thô: mã sản phẩm và số lượng
        String[] cacDongDonHang = {
            "SP001;3", "SP002;1", "SP001;2", "SP003;10", "SP002;4"
        };
        Map<String, Integer> soLuongBan = new TreeMap<>();
        Map<String, Double> doanhThu = new TreeMap<>();
        for (String dong : cacDongDonHang) {
            String[] truong = dong.split(";");
            String ma = truong[0];
            int soLuong = Integer.parseInt(truong[1]);
            double gia = bangGia.getOrDefault(ma, 0.0);
            soLuongBan.put(ma, soLuongBan.getOrDefault(ma, 0) + soLuong);
            doanhThu.put(ma, doanhThu.getOrDefault(ma, 0.0) + gia * soLuong);
        }
        double tongDoanhThu = 0;
        for (String ma : soLuongBan.keySet()) {
            System.out.printf(vn, "  %s: %2d sản phẩm, doanh thu %,.0f%n",
                              ma, soLuongBan.get(ma), doanhThu.get(ma));
            tongDoanhThu += doanhThu.get(ma);
        }
        System.out.printf(vn, "  TỔNG DOANH THU: %,.0f%n", tongDoanhThu);
    }
}
