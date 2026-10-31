package chung;

/*
 * Lớp dùng chung - Các lớp nghiệp vụ dùng chung cho toàn Chương 5
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

public class Cap<K, V> {
    private final K khoa;
    private final V giaTri;
 
    public Cap(K khoa, V giaTri) { this.khoa = khoa; this.giaTri = giaTri; }
 
    public K getKhoa()   { return khoa; }
    public V getGiaTri() { return giaTri; }
 
    @Override public String toString() { return khoa + " -> " + giaTri; }
}
