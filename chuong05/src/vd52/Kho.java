package vd52;

/*
 * Ví dụ 5.1 – 5.2 - Lớp tổng quát Kho<T>, Cap<K,V> và giao diện tổng quát
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import java.util.ArrayList;
import java.util.List;
import chung.*;

public class Kho<T> {
    private final String tenKho;
    private final List<T> danhSach = new ArrayList<>();
 
    public Kho(String tenKho) { this.tenKho = tenKho; }
 
    public void them(T phanTu) {
        if (phanTu != null) danhSach.add(phanTu);
    }
    public T lay(int viTri)  { return danhSach.get(viTri); }
    public int soLuong()     { return danhSach.size(); }
    public boolean coChua(T phanTu) { return danhSach.contains(phanTu); }
    public List<T> tatCa()   { return List.copyOf(danhSach); }   // sao chép phòng vệ
    public String getTenKho(){ return tenKho; }
 
    public void inTatCa() {
        System.out.printf("KHO: %s (%d phần tử)%n", tenKho, danhSach.size());
        for (T p : danhSach) System.out.println("  " + p);
    }
}
