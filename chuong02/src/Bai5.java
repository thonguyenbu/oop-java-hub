/*
 * Bài 5 - Xếp hạng khách hàng theo tổng chi tiêu tích lũy
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 2 - Cơ bản về ngôn ngữ lập trình Java
 *
 * Biên dịch: javac -encoding UTF-8 -d bin <đường dẫn tệp>
 */
import java.util.Locale;

public class Bai5 {

    /** Xếp hạng thành viên theo tổng chi tiêu tích lũy. */
    static String xepHang(double tongChiTieu) {
        if (tongChiTieu >= 20_000_000) return "VÀNG";
        else if (tongChiTieu >= 5_000_000) return "BẠC";
        else return "ĐỒNG";
    }

    static double tiLeChietKhau(String hang) {
        return switch (hang) {
            case "VÀNG" -> 0.10;
            case "BẠC"  -> 0.05;
            default     -> 0.02;
        };
    }

    public static void main(String[] args) {
        Locale vn = Locale.forLanguageTag("vi-VN");

        String[] maKhachHang = {"KH001", "KH002", "KH003", "KH004", "KH005", "KH006"};
        double[] chiTieu     = {1_200_000, 4_999_000, 5_000_000,
                                12_500_000, 19_999_000, 34_000_000};

        System.out.printf("%-8s %16s %8s %10s%n", "MÃ KH", "TỔNG CHI TIÊU", "HẠNG", "CHIẾT KHẤU");
        System.out.println("-".repeat(46));
        int demVang = 0, demBac = 0, demDong = 0;
        for (int i = 0; i < maKhachHang.length; i++) {
            String hang = xepHang(chiTieu[i]);
            System.out.printf(vn, "%-8s %,16.0f %8s %9.0f%%%n",
                    maKhachHang[i], chiTieu[i], hang, tiLeChietKhau(hang) * 100);
            if (hang.equals("VÀNG")) demVang++;
            else if (hang.equals("BẠC")) demBac++;
            else demDong++;
        }
        System.out.println("-".repeat(46));
        System.out.printf("Thống kê: %d khách hạng Vàng, %d hạng Bạc, %d hạng Đồng%n",
                demVang, demBac, demDong);
    }
}
