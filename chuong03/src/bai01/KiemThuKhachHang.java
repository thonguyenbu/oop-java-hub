package bai01;

/*
 * Bài 1, 2, 3 - Lớp kiểm thử ba hàm khởi tạo và các ràng buộc
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 3 - Lớp, đối tượng và phương thức
 */

public class KiemThuKhachHang {
    public static void main(String[] args) {
        System.out.println("=== BÀI 2: ba hàm khởi tạo ===");
        KhachHang k1 = new KhachHang();
        KhachHang k2 = new KhachHang("KH002", "Trần Thị Bình");
        KhachHang k3 = new KhachHang("KH003", "Lê Văn Cường",
                                     "0912345678", "VANG", 34_000_000);
        System.out.printf("%-8s %-20s %-13s %-6s %14s%n",
                "MÃ KH", "HỌ TÊN", "ĐIỆN THOẠI", "HẠNG", "TỔNG CHI TIÊU");
        System.out.println("-".repeat(66));
        System.out.println(k1.moTa());
        System.out.println(k2.moTa());
        System.out.println(k3.moTa());

        System.out.println();
        System.out.println("=== BÀI 1: thuộc tính được bảo vệ ===");
        k2.setHoTen("Trần Thị Bình An");
        k2.setHangThanhVien("bac");
        k2.setHangThanhVien("KIM CUONG");      // không hợp lệ, bị từ chối
        k2.capNhatChiTieu(6_500_000);
        k2.capNhatChiTieu(-1_000_000);         // âm, bị bỏ qua
        System.out.println(k2.moTa());
        System.out.println("Không có setMaKhachHang và setTongChiTieu, nên hai");
        System.out.println("thuộc tính này không thể bị gán tùy ý từ bên ngoài.");

        System.out.println();
        System.out.println("=== BÀI 3: tỉ lệ chiết khấu theo hạng ===");
        KhachHang[] ds = {k1, k2, k3};
        for (KhachHang k : ds) {
            System.out.printf("  %-8s hạng %-6s -> chiết khấu %.0f%%%n",
                    k.getMaKhachHang(), k.getHangThanhVien(),
                    k.layTiLeChietKhau() * 100);
        }
    }
}
