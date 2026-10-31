/*
 * Bài 11 - Dùng Set tìm khách hàng duy nhất, dùng Map đếm số lượt mua
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 2 - Cơ bản về ngôn ngữ lập trình Java
 *
 * Biên dịch: javac -encoding UTF-8 -d bin <đường dẫn tệp>
 */
import java.util.*;

public class Bai11 {
    public static void main(String[] args) {
        String[] luotMua = {
            "KH003", "KH001", "KH002", "KH001", "KH004",
            "KH002", "KH001", "KH003", "KH002", "KH001"
        };

        System.out.println("Tổng số lượt mua trong ngày: " + luotMua.length);

        Set<String> duyNhatTheoThuTu = new LinkedHashSet<>(Arrays.asList(luotMua));
        System.out.println();
        System.out.println("Khách hàng duy nhất, theo thứ tự xuất hiện lần đầu:");
        System.out.println("  " + duyNhatTheoThuTu);

        Set<String> duyNhatDaSap = new TreeSet<>(duyNhatTheoThuTu);
        System.out.println("Khách hàng duy nhất, sắp theo mã tăng dần:");
        System.out.println("  " + duyNhatDaSap);
        System.out.println("Số khách hàng khác nhau: " + duyNhatDaSap.size());

        Map<String, Integer> soLuotMua = new TreeMap<>();
        for (String ma : luotMua) {
            soLuotMua.put(ma, soLuotMua.getOrDefault(ma, 0) + 1);
        }
        System.out.println();
        System.out.printf("%-10s %10s%n", "MÃ KH", "SỐ LƯỢT");
        System.out.println("-".repeat(21));
        String khachMuaNhieuNhat = "";
        int nhieuNhat = 0;
        for (Map.Entry<String, Integer> muc : soLuotMua.entrySet()) {
            System.out.printf("%-10s %10d%n", muc.getKey(), muc.getValue());
            if (muc.getValue() > nhieuNhat) {
                nhieuNhat = muc.getValue();
                khachMuaNhieuNhat = muc.getKey();
            }
        }
        System.out.println("-".repeat(21));
        System.out.println("Mua nhiều lượt nhất: " + khachMuaNhieuNhat
                + " với " + nhieuNhat + " lượt");
    }
}
