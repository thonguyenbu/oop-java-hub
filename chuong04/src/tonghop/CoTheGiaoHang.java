package tonghop;

/*
 * Ví dụ tổng hợp - Ứng dụng bán hàng: bốn tính chất cùng hoạt động
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public interface CoTheGiaoHang {
    double phiVanChuyen();
    default String ghiChuGiaoHang() { return "Giao trong 2-3 ngày."; }
}
