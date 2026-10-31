package vd52;

/*
 * Ví dụ 5.1 – 5.2 - Lớp tổng quát Kho<T>, Cap<K,V> và giao diện tổng quát
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import java.util.List;
import chung.*;
import java.util.ArrayList;

public interface KhoDuLieu<T> {
    void them(T doiTuong);
    T timTheoMa(String ma);
    List<T> layTatCa();
}
