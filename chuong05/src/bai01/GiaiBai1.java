package bai01;

/*
 * Bài 1 - Lớp tổng quát NganXep<T>
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

public class GiaiBai1 {
    public static void main(String[] args) {
        NganXep<String> nx = new NganXep<>(3);
        System.out.println("Đẩy KH001: " + nx.day("KH001"));
        System.out.println("Đẩy KH002: " + nx.day("KH002"));
        System.out.println("Đẩy KH003: " + nx.day("KH003"));
        System.out.println("Đẩy KH004 khi đã đầy: " + nx.day("KH004"));
        System.out.println("Đỉnh hiện tại: " + nx.xem() + ", số lượng: " + nx.soLuong());
        System.out.println("Lấy ra: " + nx.lay());
        System.out.println("Lấy ra: " + nx.lay());
        System.out.println("Còn lại: " + nx.soLuong() + ", rỗng? " + nx.rong());

        NganXep<Integer> nxSo = new NganXep<>(5);
        nxSo.day(10); nxSo.day(20);
        System.out.println("Ngăn xếp số: đỉnh = " + nxSo.xem());
    }
}
