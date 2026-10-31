package bai13;

/*
 * Bài 13 - Chương trình chính: bán hàng, hóa đơn, báo cáo tồn kho
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 3 - Lớp, đối tượng và phương thức
 */

public class UngDungMiniMart {

    /** Ghi nhận một dòng bán hàng; trả về null nếu không đủ tồn kho. */
    static DongDatHang banHang(SanPham sp, int soLuong) {
        if (!sp.xuatKho(soLuong)) {
            System.out.printf("    [Từ chối] %s - %s: cần %d nhưng chỉ còn %d%n",
                    sp.getMaSanPham(), sp.getTenSanPham(), soLuong, sp.getSoLuongTon());
            return null;
        }
        return new DongDatHang(sp, soLuong);
    }

    /** In hóa đơn cho một khách hàng, trả về tổng phải thu. */
    static double inHoaDon(KhachHang kh, DongDatHang[] cacDong, int soDong) {
        System.out.println("HÓA ĐƠN - " + kh.getMaKhachHang() + " " + kh.getHoTen()
                + " (hạng " + kh.getHangThanhVien() + ")");
        System.out.printf("  %-6s %-24s %12s %6s %14s%n",
                "MÃ", "TÊN SẢN PHẨM", "ĐƠN GIÁ", "SL", "THÀNH TIỀN");
        double tongTruocChietKhau = 0;
        for (int i = 0; i < soDong; i++) {
            System.out.println(cacDong[i].moTa());
            tongTruocChietKhau += cacDong[i].thanhTien();
        }
        double tiLe = kh.layTiLeChietKhau();
        double tienChietKhau = tongTruocChietKhau * tiLe;
        double sauChietKhau = tongTruocChietKhau - tienChietKhau;
        double thue = sauChietKhau * SanPham.THUE_SUAT_VAT;
        double phaiThu = sauChietKhau + thue;

        System.out.println("  " + "-".repeat(64));
        System.out.printf("  %-50s %14.0f%n", "Tổng tiền trước chiết khấu:", tongTruocChietKhau);
        System.out.printf("  %-50s %14.0f%n",
                String.format("Chiết khấu hạng %s (%.0f%%):", kh.getHangThanhVien(), tiLe * 100),
                -tienChietKhau);
        System.out.printf("  %-50s %14.0f%n", "Thuế VAT 8%:", thue);
        System.out.printf("  %-50s %14.0f%n", "TỔNG PHẢI THU:", phaiThu);
        kh.capNhatChiTieu(phaiThu);
        System.out.println();
        return phaiThu;
    }

    public static void main(String[] args) {
        // a) Danh mục sản phẩm và khách hàng
        SanPham caPhe   = new SanPham("SP001", "Cà phê hòa tan G7",     65_000, 120, 50);
        SanPham banhQuy = new SanPham("SP002", "Bánh quy bơ",           42_000,  18, 30);
        SanPham nuoc    = new SanPham("SP003", "Nước suối 500ml",        6_000, 500, 100);
        SanPham phanMem = new SanPham("SP004", "Phần mềm kế toán",   2_400_000,   8,  5);
        SanPham traXanh = new SanPham("SP005", "Trà xanh không đường",  12_000,  45, 40);

        KhachHang khAn    = new KhachHang("KH001", "Nguyễn Văn An",  4_800_000);
        KhachHang khBinh  = new KhachHang("KH002", "Trần Thị Bình", 21_000_000);
        KhachHang khCuong = new KhachHang("KH003", "Lê Văn Cường",     300_000);

        System.out.println("CỬA HÀNG MINIMART - BÁN HÀNG TRONG NGÀY");
        System.out.println("=".repeat(70));
        System.out.println("b) GHI NHẬN CÁC DÒNG BÁN HÀNG");

        DongDatHang[] donAn    = new DongDatHang[5];  int nAn = 0;
        DongDatHang[] donBinh  = new DongDatHang[5];  int nBinh = 0;
        DongDatHang[] donCuong = new DongDatHang[5];  int nCuong = 0;

        DongDatHang d;
        if ((d = banHang(caPhe,   3))  != null) donAn[nAn++] = d;
        if ((d = banHang(nuoc,   10))  != null) donAn[nAn++] = d;
        if ((d = banHang(traXanh, 5))  != null) donAn[nAn++] = d;

        if ((d = banHang(phanMem, 2))  != null) donBinh[nBinh++] = d;
        if ((d = banHang(caPhe,   4))  != null) donBinh[nBinh++] = d;
        if ((d = banHang(banhQuy, 99)) != null) donBinh[nBinh++] = d;   // KHÔNG đủ tồn kho

        if ((d = banHang(banhQuy, 6))  != null) donCuong[nCuong++] = d;
        if ((d = banHang(nuoc,   24))  != null) donCuong[nCuong++] = d;
        if ((d = banHang(traXanh, 2))  != null) donCuong[nCuong++] = d;

        System.out.println();
        System.out.println("c) HÓA ĐƠN TỪNG KHÁCH HÀNG");
        System.out.println("=".repeat(70));
        double doanhThu = 0;
        doanhThu += inHoaDon(khAn,    donAn,    nAn);
        doanhThu += inHoaDon(khBinh,  donBinh,  nBinh);
        doanhThu += inHoaDon(khCuong, donCuong, nCuong);

        System.out.println("d) BÁO CÁO TỒN KHO CUỐI NGÀY");
        System.out.println("=".repeat(70));
        SanPham[] kho = {caPhe, banhQuy, nuoc, phanMem, traXanh};
        System.out.printf("%-6s %-24s %12s %8s %8s   %s%n",
                "MÃ", "TÊN SẢN PHẨM", "ĐƠN GIÁ", "TỒN", "TỐI THIỂU", "GHI CHÚ");
        System.out.println("-".repeat(80));
        int soCanDat = 0;
        for (SanPham sp : kho) {
            System.out.println(sp.moTa());
            if (sp.canDatHang()) soCanDat++;
        }
        System.out.println("-".repeat(80));
        System.out.println("Số mặt hàng cần đặt thêm: " + soCanDat);

        System.out.println();
        System.out.println("e) TỔNG KẾT");
        System.out.println("=".repeat(70));
        System.out.printf("%-40s %14.0f%n", "TỔNG DOANH THU TRONG NGÀY:", doanhThu);
        System.out.println();
        System.out.println("Số đối tượng đã tạo của từng lớp:");
        System.out.println("  SanPham     : " + SanPham.getSoDoiTuongDaTao());
        System.out.println("  KhachHang   : " + KhachHang.getSoDoiTuongDaTao());
        System.out.println("  DongDatHang : " + DongDatHang.getSoDoiTuongDaTao());
        System.out.println();
        System.out.println("Trạng thái khách hàng sau khi mua:");
        System.out.printf("%-8s %-20s %-6s %14s%n", "MÃ KH", "HỌ TÊN", "HẠNG", "TỔNG CHI TIÊU");
        for (KhachHang k : new KhachHang[]{khAn, khBinh, khCuong})
            System.out.println(k.moTa());
    }
}
