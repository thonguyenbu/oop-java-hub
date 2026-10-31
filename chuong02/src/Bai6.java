/*
 * Bài 6 - Sổ tiết kiệm tính bằng vòng lặp và bằng đệ quy
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 2 - Cơ bản về ngôn ngữ lập trình Java
 *
 * Biên dịch: javac -encoding UTF-8 -d bin <đường dẫn tệp>
 */
import java.util.Locale;

public class Bai6 {

    /** Cách 1: dùng vòng lặp. */
    static double soDuSauNamLap(double goc, double laiSuat, int soNam) {
        double soDu = goc;
        for (int nam = 1; nam <= soNam; nam++) {
            soDu = soDu * (1 + laiSuat);
        }
        return soDu;
    }

    /** Cách 2: dùng đệ quy. Trường hợp cơ sở: gửi 0 năm thì số dư bằng gốc. */
    static double soDuSauNamDeQuy(double goc, double laiSuat, int soNam) {
        if (soNam == 0) return goc;                                   // trường hợp cơ sở
        return soDuSauNamDeQuy(goc, laiSuat, soNam - 1) * (1 + laiSuat);  // bước đệ quy
    }

    public static void main(String[] args) {
        Locale vn = Locale.forLanguageTag("vi-VN");
        double goc = 100_000_000;
        double laiSuat = 0.06;
        int soNam = 5;

        System.out.printf(vn, "Gửi ban đầu: %,.0f đ, lãi suất %.1f%%/năm%n%n",
                goc, laiSuat * 100);
        System.out.printf("%-6s %18s %18s %12s%n", "NĂM", "VÒNG LẶP", "ĐỆ QUY", "CHÊNH LỆCH");
        System.out.println("-".repeat(58));
        for (int nam = 1; nam <= soNam; nam++) {
            double a = soDuSauNamLap(goc, laiSuat, nam);
            double b = soDuSauNamDeQuy(goc, laiSuat, nam);
            System.out.printf(vn, "%-6d %,18.2f %,18.2f %12.2f%n", nam, a, b, a - b);
        }
        System.out.println("-".repeat(58));
        System.out.println("Hai cách cho cùng kết quả vì thực hiện đúng một dãy phép nhân.");
    }
}
