package hangdoi;

/*
 * Mục 6.10.2 - Hàng đợi thông điệp với BlockingQueue
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 6 - Xây dựng ứng dụng hướng đối tượng
 */

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class HangDoiThongDiep {

    record ThongDiep(String maDon, String noiDung) { }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<ThongDiep> hangDoi = new LinkedBlockingQueue<>();

        Thread nguoiTieuThu = new Thread(() -> {
            try {
                while (true) {
                    ThongDiep td = hangDoi.take();
                    Thread.sleep(50);         // máy chủ thư chậm
                    System.out.println("   [gửi email] đơn "
                            + td.maDon() + ": " + td.noiDung());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        nguoiTieuThu.setDaemon(true);
        nguoiTieuThu.start();

        for (int i = 1; i <= 3; i++) {
            hangDoi.put(new ThongDiep("DH00" + i, "Đơn đã được xác nhận"));
            System.out.println("Ghi nhận DH00" + i + " (không chờ email)");
        }
        Thread.sleep(400);
    }
}
