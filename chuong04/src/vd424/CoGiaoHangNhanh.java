package vd424;

/*
 * Mục 4.2.4 - Đa kế thừa kiểu qua giao diện và phương thức default
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

interface CoGiaoHangNhanh {
    default String kenhGiao() { return "Giao nhanh"; }
}
