/*
 * Bài 13 - So sánh BigDecimal với double trên hóa đơn 20 dòng
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 2 - Cơ bản về ngôn ngữ lập trình Java
 *
 * Biên dịch: javac -encoding UTF-8 -d bin <đường dẫn tệp>
 */
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

public class Bai13 {

    // Đơn giá hàng cân ký nên có phần lẻ tới hàng xu
    static final String[] DON_GIA = {
        "19900.10","42000.35","6000.05","12500.25","8900.15","15900.45",
        "23500.55","7800.65","31200.75","9900.85","18700.95","26400.05",
        "5500.15","14300.25","21900.35","33100.45","11200.55","27600.65",
        "16800.75","29400.85"
    };
    static final int[] SO_LUONG = {3,1,12,5,7,2,4,9,1,6,8,3,20,5,2,1,11,4,6,3};

    static BigDecimal tiLeChietKhau(String hang) {
        return switch (hang) {
            case "VANG" -> new BigDecimal("0.10");
            case "BAC"  -> new BigDecimal("0.05");
            default     -> new BigDecimal("0.02");
        };
    }

    public static void main(String[] args) {
        Locale vn = Locale.forLanguageTag("vi-VN");
        final BigDecimal VAT = new BigDecimal("0.08");
        String hang = "BAC";

        // ---------- Cách đúng: BigDecimal ----------
        BigDecimal tongBD = BigDecimal.ZERO;
        for (int i = 0; i < DON_GIA.length; i++) {
            tongBD = tongBD.add(new BigDecimal(DON_GIA[i])
                        .multiply(BigDecimal.valueOf(SO_LUONG[i])));
        }
        BigDecimal giamBD = tongBD.multiply(tiLeChietKhau(hang))
                                  .setScale(2, RoundingMode.HALF_UP);
        BigDecimal sauGiamBD = tongBD.subtract(giamBD);
        BigDecimal thueBD = sauGiamBD.multiply(VAT).setScale(2, RoundingMode.HALF_UP);
        BigDecimal phaiTraBD = sauGiamBD.add(thueBD);

        // ---------- Cách sai: double ----------
        double tongD = 0;
        for (int i = 0; i < DON_GIA.length; i++) {
            tongD += Double.parseDouble(DON_GIA[i]) * SO_LUONG[i];
        }
        double giamD = tongD * 0.05;
        double sauGiamD = tongD - giamD;
        double thueD = sauGiamD * 0.08;
        double phaiTraD = sauGiamD + thueD;

        System.out.println("HÓA ĐƠN 20 DÒNG HÀNG - khách hạng " + hang);
        System.out.println("=".repeat(66));
        System.out.printf("%-22s %20s %20s%n", "KHOẢN MỤC", "BigDecimal", "double");
        System.out.println("-".repeat(66));
        System.out.printf("%-22s %20s %20.10f%n", "Tổng tiền hàng:",
                tongBD.toPlainString(), tongD);
        System.out.printf("%-22s %20s %20.10f%n", "Chiết khấu 5%:",
                giamBD.toPlainString(), giamD);
        System.out.printf("%-22s %20s %20.10f%n", "Sau chiết khấu:",
                sauGiamBD.toPlainString(), sauGiamD);
        System.out.printf("%-22s %20s %20.10f%n", "Thuế VAT 8%:",
                thueBD.toPlainString(), thueD);
        System.out.printf("%-22s %20s %20.10f%n", "TỔNG PHẢI TRẢ:",
                phaiTraBD.toPlainString(), phaiTraD);
        System.out.println("=".repeat(66));

        BigDecimal chenhLech = phaiTraBD.subtract(new BigDecimal(Double.toString(phaiTraD)));
        System.out.println("Chênh lệch giữa hai cách: " + chenhLech.toPlainString() + " đ");
        System.out.println();
        System.out.printf(vn, "Làm tròn để in hóa đơn - BigDecimal: %,.0f đ%n",
                phaiTraBD.setScale(0, RoundingMode.HALF_UP));
        System.out.printf(vn, "Làm tròn để in hóa đơn - double    : %,.0f đ%n", phaiTraD);

        // Sai số tích lũy khi số dòng hóa đơn tăng lên
        System.out.println();
        System.out.println("SAI SỐ TÍCH LŨY KHI CỘNG 10.000 DÒNG, MỖI DÒNG 0,10 đ");
        double congBangDouble = 0;
        BigDecimal congBangBigDecimal = BigDecimal.ZERO;
        BigDecimal motHao = new BigDecimal("0.10");
        for (int i = 0; i < 10_000; i++) {
            congBangDouble += 0.10;
            congBangBigDecimal = congBangBigDecimal.add(motHao);
        }
        System.out.println("  Kết quả đúng phải là : 1000.00");
        System.out.println("  BigDecimal cho       : " + congBangBigDecimal.toPlainString());
        System.out.println("  double cho           : " + congBangDouble);
    }
}
