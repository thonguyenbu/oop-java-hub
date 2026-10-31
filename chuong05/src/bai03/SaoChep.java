package bai03;

/*
 * Bài 3 - Phương thức sanhChep với ? extends và ? super
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import java.util.List;

public class SaoChep {

    public static <T> void sanhChep(List<? extends T> nguon, List<? super T> dich) {
        for (T x : nguon) dich.add(x);
    }
}
