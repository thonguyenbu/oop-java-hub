package bai10;

/*
 * Bài 10 - Minh họa tồn kho thay đổi sau khi thực hiện phiếu
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 3 - Lớp, đối tượng và phương thức
 */

public class KiemThuPhieuNhap {

    static void inTonKho(String tieuDe, SanPham[] kho) {
        System.out.println(tieuDe);
        System.out.printf("  %-6s %-24s %8s%n", "MÃ", "TÊN SẢN PHẨM", "TỒN KHO");
        for (SanPham sp : kho)
            System.out.printf("  %-6s %-24s %8d%n",
                    sp.getMaSanPham(), sp.getTenSanPham(), sp.getSoLuongTon());
    }

    public static void main(String[] args) {
        SanPham[] kho = {
            new SanPham("SP001", "Cà phê hòa tan G7", 65_000, 120),
            new SanPham("SP002", "Bánh quy bơ",       42_000,  18),
            new SanPham("SP003", "Nước suối 500ml",    6_000, 500)
        };
        inTonKho("TỒN KHO TRƯỚC KHI NHẬP", kho);

        System.out.println();
        PhieuNhapKho phieu = new PhieuNhapKho("24/09/2026", 5);
        phieu.themDong(kho[0], 80);
        phieu.themDong(kho[1], 100);
        phieu.themDong(kho[2], 200);
        phieu.inPhieu();

        double tongGiaTri = phieu.thucHien();
        System.out.printf("  %-54s %14.0f%n", "TỔNG GIÁ TRỊ NHẬP:", tongGiaTri);

        System.out.println();
        inTonKho("TỒN KHO SAU KHI THỰC HIỆN PHIẾU", kho);

        System.out.println();
        System.out.println("Thử thực hiện lại phiếu lần hai:");
        phieu.thucHien();
        System.out.println("Thử thêm dòng vào phiếu đã thực hiện:");
        phieu.themDong(kho[0], 10);
        System.out.println();
        inTonKho("TỒN KHO KHÔNG ĐỔI SAU HAI THAO TÁC BỊ TỪ CHỐI", kho);
        System.out.println();
        System.out.println("Số phiếu đã lập: " + PhieuNhapKho.getSoPhieuDaLap());
    }
}
