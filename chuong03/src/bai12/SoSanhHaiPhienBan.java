package bai12;

/*
 * Bài 12 - Đối chiếu hai phiên bản trên 20 dòng bán hàng
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 3 - Lớp, đối tượng và phương thức
 */

import java.math.BigDecimal;

public class SoSanhHaiPhienBan {

    // Đơn giá hàng cân ký nên có phần lẻ tới hàng xu
    static final String[] MA      = {"SP001","SP002","SP003","SP004","SP005"};
    static final String[] TEN     = {"Cà phê rang xay","Thịt bò thăn","Cá hồi phi lê",
                                     "Rau cải hữu cơ","Tôm sú tươi"};
    static final String[] DON_GIA = {"99999.99","88888.88","77777.77","66666.66","55555.55"};

    // 20 dòng bán hàng: chỉ số sản phẩm và số lượng
    static final int[] CHI_SO   = {0,1,2,3,4,0,1,2,3,4,0,1,2,3,4,0,1,2,3,4};
    static final int[] SO_LUONG = {3,2,1,7,2,5,1,3,4,1,2,6,2,9,3,1,4,1,5,2};

    public static void main(String[] args) {
        SanPhamDouble[] cuMoi = new SanPhamDouble[5];
        SanPhamBigDecimal[] moi = new SanPhamBigDecimal[5];
        for (int i = 0; i < 5; i++) {
            cuMoi[i] = new SanPhamDouble(MA[i], TEN[i], Double.parseDouble(DON_GIA[i]), 100);
            moi[i]   = new SanPhamBigDecimal(MA[i], TEN[i], new BigDecimal(DON_GIA[i]), 100);
        }

        System.out.println("HÓA ĐƠN 20 DÒNG HÀNG - ĐỐI CHIẾU HAI PHIÊN BẢN LỚP SanPham");
        System.out.println("=".repeat(76));
        System.out.printf("%-4s %-6s %4s %20s %22s%n",
                "DÒNG", "MÃ", "SL", "double", "BigDecimal");
        System.out.println("-".repeat(76));

        double tongCu = 0;
        BigDecimal tongMoi = BigDecimal.ZERO;
        for (int i = 0; i < CHI_SO.length; i++) {
            int k = CHI_SO[i];
            double a = cuMoi[k].thanhTien(SO_LUONG[i]);
            BigDecimal c = moi[k].thanhTien(SO_LUONG[i]);
            tongCu += a;
            tongMoi = tongMoi.add(c);
            if (i < 5 || i >= 17) {              // in năm dòng đầu và ba dòng cuối
                System.out.printf("%-4d %-6s %4d %20.10f %22s%n",
                        i + 1, MA[k], SO_LUONG[i], a, c.toPlainString());
            } else if (i == 5) {
                System.out.println("...");
            }
        }
        System.out.println("-".repeat(76));
        System.out.printf("%-16s %20.10f %22s%n", "TỔNG CỘNG:", tongCu, tongMoi.toPlainString());
        System.out.println("=".repeat(76));

        BigDecimal chenhLech = tongMoi.subtract(new BigDecimal(Double.toString(tongCu)));
        System.out.println("Chênh lệch: " + chenhLech.toPlainString() + " đ");
        System.out.println();
        System.out.println("Tổng giá trị tồn kho (mỗi mặt hàng 100 đơn vị):");
        BigDecimal tonMoi = BigDecimal.ZERO;
        double tonCu = 0;
        for (int i = 0; i < 5; i++) {
            tonMoi = tonMoi.add(moi[i].giaTriTonKho());
            tonCu += Double.parseDouble(DON_GIA[i]) * 100;
        }
        System.out.printf("  double     : %.10f%n", tonCu);
        System.out.println("  BigDecimal : " + tonMoi.toPlainString());

        // Sai số tích lũy khi số dòng bán hàng tăng lên
        System.out.println();
        System.out.println("SAI SỐ TÍCH LŨY KHI CỘNG 10.000 DÒNG, MỖI DÒNG 0,10 đ");
        double congD = 0;
        BigDecimal congBD = BigDecimal.ZERO;
        BigDecimal motHao = new BigDecimal("0.10");
        for (int i = 0; i < 10_000; i++) {
            congD += 0.10;
            congBD = congBD.add(motHao);
        }
        System.out.println("  Kết quả đúng phải là : 1000.00");
        System.out.println("  BigDecimal cho       : " + congBD.toPlainString());
        System.out.println("  double cho           : " + congD);
    }
}
