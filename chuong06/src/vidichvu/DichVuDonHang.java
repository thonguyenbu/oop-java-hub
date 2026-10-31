package vidichvu;

/*
 * Mục 6.7 - Hai vi dịch vụ giao tiếp qua HTTP
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 6 - Xây dựng ứng dụng hướng đối tượng
 */

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class DichVuDonHang {

    static final HttpClient KHACH = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(2)).build();

    static String layDanhSachSanPham() throws Exception {
        HttpRequest yeuCau = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8081/sanpham"))
                .timeout(Duration.ofSeconds(3))
                .GET().build();
        HttpResponse<String> traLoi = KHACH.send(
                yeuCau, HttpResponse.BodyHandlers.ofString());
        if (traLoi.statusCode() != 200)
            throw new IllegalStateException(
                    "Dịch vụ sản phẩm trả về mã " + traLoi.statusCode());
        return traLoi.body();
    }

    public static void main(String[] args) {
        try {
            String json = layDanhSachSanPham();
            System.out.println("Nhận được từ DichVuSanPham:");
            System.out.println(json);
        } catch (Exception e) {
            System.out.println("Không gọi được DichVuSanPham ("
                    + e.getClass().getSimpleName() + ").");
            System.out.println("Đơn hàng vẫn ghi nhận, "
                    + "tồn kho đối soát sau.");
        }
    }
}
