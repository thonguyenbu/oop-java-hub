package bai07;

/*
 * Bài 7 - Quan hệ has-a giữa HoaDon và KhachHang
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class GiaiBai7 {
    public static void main(String[] args) {
        KhachHang kh1 = new KhachHang("KH001", "Nguyễn Văn An", "VANG");
        KhachHang kh2 = new KhachHang("KH002", "Trần Thị Bình", "MOI");

        HoaDon[] ds = {
            new HoaDon("HD0001", kh1, 5_000_000),
            new HoaDon("HD0002", kh1, 3_200_000),
            new HoaDon("HD0003", kh2, 1_800_000)
        };
        System.out.printf("%-10s %-20s %14s %14s%n",
                "SỐ HĐ", "KHÁCH HÀNG", "TỔNG TIỀN", "PHẢI THU");
        for (HoaDon hd : ds) System.out.println(hd);
    }
}
