package bai10;

/*
 * Bài 10 - Giao diện KhoDuLieu<T, K> và lớp cài đặt trong bộ nhớ
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import java.util.List;
import java.util.*;
import chung.*;

public interface KhoDuLieu<T, K> {
    void them(T doiTuong);
    boolean xoaTheoKhoa(K khoa);
    T timTheoKhoa(K khoa);
    List<T> layTatCa();
    int soLuong();
}
