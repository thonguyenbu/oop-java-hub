package vd424;

/*
 * Mục 4.2.4 - Đa kế thừa kiểu qua giao diện và phương thức default
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class DemoDaKeThuaGiaoDien {
    public static void main(String[] args) {
        DonHangVip don = new DonHangVip();
        System.out.println("Kênh giao của đơn hàng VIP: " + don.kenhGiao());
        System.out.println();
        System.out.println("Lớp DonHangVip cài đặt hai giao diện cùng có phương thức");
        System.out.println("default kenhGiao(). Trình biên dịch buộc lớp phải ghi đè và");
        System.out.println("chỉ rõ bản muốn dùng bằng cú pháp TenGiaoDien.super.tenPhuongThuc().");
    }
}
