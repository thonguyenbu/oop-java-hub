package vd51;

/*
 * Mục 5.1 - Kiểu thô và hậu quả: lỗi chỉ lộ ra lúc chạy
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import java.util.ArrayList;
import java.util.List;

public class DemoKieuTho {
    public static void main(String[] args) {
        List danhSach = new ArrayList();      // kiểu thô: không nêu kiểu phần tử
        danhSach.add("SP001");
        danhSach.add("SP002");
        danhSach.add(12345);                  // lọt vào, không hề bị phản đối
 
        System.out.println("Danh sách: " + danhSach);
        for (Object o : danhSach) {
            String ma = (String) o;           // phải tự ép kiểu
            System.out.println("Xử lý mã: " + ma.toUpperCase());
        }
    }
}
