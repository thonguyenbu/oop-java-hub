package vd42;

/*
 * Ví dụ 4.2 - Phân cấp ConNguoi và thứ tự chạy hàm khởi tạo
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class DemoKeThua {
    public static void main(String[] args) {
        System.out.println("Tạo một KhachHang:");
        KhachHang kh = new KhachHang("KH001", "Nguyễn Văn An", "0901234567",
                                     "12 Nguyễn Huệ, Q1", "VANG");

        System.out.println();
        System.out.println("Kế thừa từ ConNguoi : " + kh.getHoTen());
        System.out.println("Bổ sung ở KhachHang: " + kh.getMaKhachHang()
                           + ", chiết khấu " + (kh.tiLeChietKhau() * 100) + "%");
        System.out.println("Ghi đè thongTinLienHe():");
        System.out.println("  " + kh.thongTinLienHe());

        System.out.println();
        NhanVien nv = new NhanVien("NV001", "Trần Thị Bình", "0912345678",
                                   "45 Lê Lợi, Q1", 12_000_000);
        System.out.println("NhanVien dùng bản gốc của ConNguoi:");
        System.out.println("  " + nv.thongTinLienHe());
    }
}
