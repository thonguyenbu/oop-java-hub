package tonghop;

/*
 * Ví dụ tổng hợp - Ứng dụng bán hàng: bốn tính chất cùng hoạt động
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class UngDungBanHang {
    public static void main(String[] args) {
        SanPhamVatLy caPhe = new SanPhamVatLy("SP001", "Cà phê hòa tan G7",
                                              65_000, 0.5, 120);
        SanPhamVatLy mayXay = new SanPhamVatLy("SP002", "Máy xay cà phê",
                                               1_250_000, 3.2, 5);
        SanPhamSo phanMem = new SanPhamSo("SP003", "Phần mềm kế toán",
                                          2_400_000, 365);

        KhachHang khCaNhan = new KhachCaNhan("KH001", "Nguyễn Văn An", "VANG");
        KhachHang khDoanhNghiep = new KhachDoanhNghiep("KH002", "Công ty ABC",
                                                       2_000_000_000.0);

        DonHang don1 = new DonHang(khCaNhan, 5);
        don1.themDong(caPhe, 4);
        don1.themDong(mayXay, 1);
        don1.inHoaDon();

        System.out.println();
        DonHang don2 = new DonHang(khDoanhNghiep, 5);
        don2.themDong(phanMem, 3);
        don2.themDong(mayXay, 10);
        don2.themDong(caPhe, 20);
        don2.inHoaDon();

        System.out.println();
        System.out.println("Số đơn hàng đã lập: " + DonHang.getSoDonDaLap());
        System.out.println("Tồn kho cà phê còn: " + caPhe.getSoLuongTon());
        System.out.println("Khóa kích hoạt phần mềm: " + phanMem.taoKhoaKichHoat());
        System.out.println();
        System.out.println("Danh mục sản phẩm (đa hình qua toString và loaiSanPham):");
        SanPham[] danhMuc = { caPhe, mayXay, phanMem };
        for (SanPham sp : danhMuc) System.out.println("  " + sp);
    }
}
