package bai10;

/*
 * Bài 10 - Mở rộng ví dụ tổng hợp: dịch vụ, bảo hành, khách đại lý
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class GiaiBai10 {
    public static void main(String[] args) {
        SanPhamVatLy mayXay = new SanPhamVatLy("SP002", "Máy xay cà phê",
                                               1_250_000, 3.2, 50);
        SanPhamSo phanMem = new SanPhamSo("SP003", "Phần mềm kế toán",
                                          2_400_000, 365);
        DichVuLapDat lapDat = new DichVuLapDat("SP006", "Dịch vụ lắp đặt",
                                               150_000, 2.5);

        System.out.println("a) BA LOẠI SẢN PHẨM, TRONG ĐÓ DỊCH VỤ LÀ LOẠI MỚI");
        SanPham[] danhMuc = { mayXay, phanMem, lapDat };
        for (SanPham sp : danhMuc) System.out.println("  " + sp);

        System.out.println();
        System.out.println("c) NĂNG LỰC BẢO HÀNH - chỉ hàng vật lý và dịch vụ có");
        for (SanPham sp : danhMuc) {
            if (sp instanceof CoBaoHanh bh) {
                System.out.printf("  %-6s %s%n", sp.getMaSanPham(), bh.dieuKienBaoHanh());
            } else {
                System.out.printf("  %-6s (không bảo hành)%n", sp.getMaSanPham());
            }
        }

        System.out.println();
        System.out.println("b) KHÁCH HÀNG ĐẠI LÝ - số lượng tối thiểu mỗi dòng là 10");
        KhachHang daiLy = new KhachDaiLy("KH003", "Đại lý Minh Khai");
        KhachHang caNhan = new KhachCaNhan("KH001", "Nguyễn Văn An", "VANG");
        System.out.println("  " + daiLy.moTa());
        System.out.println("  " + caNhan.moTa());

        System.out.println();
        System.out.println("Kiểm tra quy tắc chapNhanSoLuong (cách khắc phục ở Câu 3):");
        int[] cacSoLuong = {3, 10, 25};
        for (int sl : cacSoLuong) {
            System.out.printf("  mua %2d cái -> đại lý: %-5s | cá nhân: %s%n",
                    sl, daiLy.chapNhanSoLuong(sl), caNhan.chapNhanSoLuong(sl));
        }

        System.out.println();
        System.out.printf("Thành tiền dịch vụ lắp đặt 2 lần: %.0f đ%n",
                lapDat.thanhTien(2));
    }
}
