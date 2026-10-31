package vd424;

/*
 * Mục 4.2.4 - Đa kế thừa kiểu qua giao diện và phương thức default
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class DonHangVip implements CoGiaoHangNhanh, CoGiaoHangTietKiem {
    @Override
    public String kenhGiao() {
        return CoGiaoHangNhanh.super.kenhGiao();   // chỉ rõ bản muốn dùng
    }
}
