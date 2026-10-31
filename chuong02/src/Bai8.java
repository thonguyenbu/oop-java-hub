/*
 * Bài 8 - Dựng hóa đơn nhiều dòng bằng StringBuilder
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 2 - Cơ bản về ngôn ngữ lập trình Java
 *
 * Biên dịch: javac -encoding UTF-8 -d bin <đường dẫn tệp>
 */
import java.util.Locale;

public class Bai8 {
    public static void main(String[] args) {
        Locale vn = Locale.forLanguageTag("vi-VN");

        String duLieu =
                "SP001;Cà phê hòa tan G7;65000;3\n"
              + "SP002;Bánh quy bơ;42000;2\n"
              + "SP003;Nước suối 500ml;6000;12\n"
              + "SP004;Trà xanh không đường;12000;5";

        StringBuilder hoaDon = new StringBuilder();
        hoaDon.append("CỬA HÀNG MINIMART\n");
        hoaDon.append("=".repeat(62)).append('\n');
        hoaDon.append(String.format("%-6s %-24s %10s %4s %13s%n",
                "MÃ", "TÊN SẢN PHẨM", "ĐƠN GIÁ", "SL", "THÀNH TIỀN"));
        hoaDon.append("-".repeat(62)).append('\n');

        double tongCong = 0;
        for (String dong : duLieu.split("\n")) {
            String[] truong = dong.split(";");
            String ma  = truong[0];
            String ten = truong[1];
            double donGia = Double.parseDouble(truong[2]);
            int soLuong   = Integer.parseInt(truong[3]);
            double thanhTien = donGia * soLuong;
            tongCong += thanhTien;
            hoaDon.append(String.format(vn, "%-6s %-24s %,10.0f %4d %,13.0f%n",
                    ma, ten, donGia, soLuong, thanhTien));
        }
        hoaDon.append("-".repeat(62)).append('\n');
        hoaDon.append(String.format(vn, "%-46s %,13.0f%n", "TỔNG CỘNG:", tongCong));
        hoaDon.append("=".repeat(62));

        System.out.println(hoaDon.toString());
    }
}
