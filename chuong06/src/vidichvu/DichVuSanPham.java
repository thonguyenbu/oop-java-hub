package vidichvu;

/*
 * Mục 6.7 - Hai vi dịch vụ giao tiếp qua HTTP
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 6 - Xây dựng ứng dụng hướng đối tượng
 */

import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class DichVuSanPham {

    static final String DU_LIEU = """
            [{"maSanPham":"SP001","tenSanPham":"Cà phê hòa tan G7",
              "donGia":65000,"soLuongTon":120},
             {"maSanPham":"SP002","tenSanPham":"Bánh quy bơ",
              "donGia":42000,"soLuongTon":85}]""";

    public static void main(String[] args) throws Exception {
        HttpServer mayChu = HttpServer.create(
                new InetSocketAddress(8081), 0);
        mayChu.createContext("/sanpham", trao -> {
            byte[] than = DU_LIEU.getBytes(StandardCharsets.UTF_8);
            trao.getResponseHeaders()
                .add("Content-Type", "application/json; charset=utf-8");
            trao.sendResponseHeaders(200, than.length);
            try (OutputStream ra = trao.getResponseBody()) {
                ra.write(than);
            }
        });
        mayChu.start();
        System.out.println("DichVuSanPham: http://localhost:8081/sanpham");
    }
}
