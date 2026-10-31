package bai02;

/*
 * Bài 2 - Ghi đè toString, equals và hashCode
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class GiaiBai2 {
    public static void main(String[] args) {
        SinhVien a = new SinhVien("050101", "Nguyễn Văn An", 3.45);
        SinhVien b = new SinhVien("050101", "Nguyễn Văn An (nhập lại)", 3.20);
        SinhVien c = new SinhVien("050102", "Trần Thị Bình", 3.80);

        System.out.println("In đối tượng nhờ toString():");
        System.out.println("  " + a);
        System.out.println("  " + c);

        System.out.println();
        System.out.println("a == b        -> " + (a == b));
        System.out.println("a.equals(b)   -> " + a.equals(b));
        System.out.println("a.equals(c)   -> " + a.equals(c));
        System.out.println("hashCode bằng nhau? " + (a.hashCode() == b.hashCode()));
    }
}
