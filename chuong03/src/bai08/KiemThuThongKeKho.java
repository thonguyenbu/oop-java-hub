package bai08;

/*
 * Bài 8 - Kiểm thử ba phép thống kê tồn kho
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 3 - Lớp, đối tượng và phương thức
 */

public class KiemThuThongKeKho {
    public static void main(String[] args) {
        SanPham[] kho = {
            new SanPham("SP001", "Cà phê hòa tan G7",    65_000, 120),
            new SanPham("SP002", "Bánh quy bơ",          42_000,  18),
            new SanPham("SP003", "Nước suối 500ml",       6_000, 500),
            new SanPham("SP004", "Phần mềm kế toán",  2_400_000,   8),
            new SanPham("SP005", "Trà xanh không đường", 12_000,  45)
        };

        System.out.printf("%-6s %-24s %12s %8s %16s%n",
                "MÃ", "TÊN SẢN PHẨM", "ĐƠN GIÁ", "TỒN", "GIÁ TRỊ TỒN");
        System.out.println("-".repeat(70));
        for (SanPham sp : kho) System.out.println(sp.moTa());
        System.out.println("-".repeat(70));
        System.out.printf("%-52s %16.0f%n", "TỔNG GIÁ TRỊ TỒN KHO:",
                ThongKeKho.tongGiaTriTonKho(kho));

        SanPham it = ThongKeKho.tonKhoThapNhat(kho);
        System.out.println();
        System.out.printf("Sản phẩm tồn kho thấp nhất: %s - %s (còn %d)%n",
                it.getMaSanPham(), it.getTenSanPham(), it.getSoLuongTon());

        int nguong = 50;
        System.out.println();
        System.out.println("Sản phẩm có tồn kho dưới " + nguong + ":");
        SanPham[] canDat = ThongKeKho.duoiNguong(kho, nguong);
        if (canDat.length == 0) System.out.println("  (không có)");
        for (SanPham sp : canDat)
            System.out.printf("  %-6s %-24s còn %d%n",
                    sp.getMaSanPham(), sp.getTenSanPham(), sp.getSoLuongTon());
        System.out.println("Số mặt hàng cần đặt thêm: " + canDat.length);
    }
}
