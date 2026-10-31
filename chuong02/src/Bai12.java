/*
 * Bài 12 - Mở rộng báo cáo doanh thu: thêm tên sản phẩm và sản phẩm dẫn đầu
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 2 - Cơ bản về ngôn ngữ lập trình Java
 *
 * Biên dịch: javac -encoding UTF-8 -d bin <đường dẫn tệp>
 */
import java.util.*;

public class Bai12 {
    public static void main(String[] args) {
        Locale vn = Locale.forLanguageTag("vi-VN");

        Map<String, Double> bangGia = new HashMap<>();
        bangGia.put("SP001", 19_900.0);
        bangGia.put("SP002", 42_000.0);
        bangGia.put("SP003", 6_000.0);

        Map<String, String> bangTen = new HashMap<>();
        bangTen.put("SP001", "Cà phê hòa tan G7");
        bangTen.put("SP002", "Bánh quy bơ");
        bangTen.put("SP003", "Nước suối 500ml");

        String[] cacDongDonHang = {"SP001;3", "SP002;1", "SP001;2", "SP003;10", "SP002;4"};

        Map<String, Integer> soLuongBan = new TreeMap<>();
        Map<String, Double>  doanhThu   = new TreeMap<>();

        for (String dong : cacDongDonHang) {
            String[] truong = dong.split(";");
            String ma = truong[0];
            int soLuong = Integer.parseInt(truong[1]);
            double gia = bangGia.getOrDefault(ma, 0.0);
            soLuongBan.put(ma, soLuongBan.getOrDefault(ma, 0) + soLuong);
            doanhThu.put(ma, doanhThu.getOrDefault(ma, 0.0) + gia * soLuong);
        }

        System.out.printf("%-6s %-24s %6s %14s%n", "MÃ", "TÊN SẢN PHẨM", "SL", "DOANH THU");
        System.out.println("-".repeat(54));
        double tongDoanhThu = 0;
        String maCaoNhat = "";
        double doanhThuCaoNhat = -1;
        for (String ma : soLuongBan.keySet()) {
            double dt = doanhThu.get(ma);
            System.out.printf(vn, "%-6s %-24s %6d %,14.0f%n",
                    ma, bangTen.getOrDefault(ma, "(chưa có tên)"), soLuongBan.get(ma), dt);
            tongDoanhThu += dt;
            if (dt > doanhThuCaoNhat) { doanhThuCaoNhat = dt; maCaoNhat = ma; }
        }
        System.out.println("-".repeat(54));
        System.out.printf(vn, "%-38s %,14.0f%n", "TỔNG DOANH THU:", tongDoanhThu);
        System.out.println();
        System.out.printf(vn, "Sản phẩm có doanh thu cao nhất: %s - %s (%,.0f đ)%n",
                maCaoNhat, bangTen.get(maCaoNhat), doanhThuCaoNhat);
    }
}
