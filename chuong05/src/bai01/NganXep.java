package bai01;

/*
 * Bài 1 - Lớp tổng quát NganXep<T>
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import java.util.ArrayList;
import java.util.List;

public class NganXep<T> {
    private final List<T> phanTu = new ArrayList<>();
    private final int sucChua;
 
    public NganXep(int sucChua) { this.sucChua = sucChua; }
 
    public boolean day()   { return phanTu.size() >= sucChua; }
    public boolean rong()  { return phanTu.isEmpty(); }
    public int soLuong()   { return phanTu.size(); }
 
    public boolean day(T x) {                      // push
        if (x == null || day()) return false;
        phanTu.add(x);
        return true;
    }
    public T lay() {                               // pop
        if (rong()) return null;
        return phanTu.remove(phanTu.size() - 1);
    }
    public T xem() {                               // peek
        return rong() ? null : phanTu.get(phanTu.size() - 1);
    }
}
