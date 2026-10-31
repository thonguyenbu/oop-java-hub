package vd43;

/*
 * Ví dụ 4.3 – 4.5 - Đa hình, ghi đè, ép kiểu và toán tử instanceof
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class DemoEqualsHashCode {
    public static void main(String[] args) {
        NhanVien a = new NhanVien("NV001", "Nguyễn Văn An", 12_000_000);
        NhanVien b = new NhanVien("NV001", "Nguyễn Văn An (đổi ca)", 15_000_000);
        System.out.println("a == b        -> " + (a == b));
        System.out.println("a.equals(b)   -> " + a.equals(b));
    }
}
