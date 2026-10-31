package vd57;

/*
 * Mục 5.8 - Thao tác với List, xóa khi đang duyệt, danh sách bất biến
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import java.util.*;

public class DemoList {
    public static void main(String[] args) {
        System.out.println("(1) Các thao tác thường dùng:");
        List<String> gioHang = new ArrayList<>();
        gioHang.add("SP001");
        gioHang.add("SP002");
        gioHang.add("SP003");
        gioHang.add(1, "SP009");                 // chèn vào vị trí 1
        System.out.printf("  %s  size=%d%n", gioHang, gioHang.size());
        gioHang.set(0, "SP007");                 // thay thế phần tử
        System.out.println("  sau set(0): " + gioHang);
        System.out.println("  indexOf(SP003) = " + gioHang.indexOf("SP003"));
        System.out.println("  subList(1,3)   = " + gioHang.subList(1, 3));

        System.out.println();
        System.out.println("(2) Cái bẫy remove(int) và remove(Object):");
        List<Integer> soLuong = new ArrayList<>(List.of(10, 20, 30));
        soLuong.remove(2);                       // xóa theo CHỈ SỐ
        System.out.println("  sau remove(2)                  -> " + soLuong);
        soLuong.remove(Integer.valueOf(20));     // xóa theo GIÁ TRỊ
        System.out.println("  sau remove(Integer.valueOf(20))-> " + soLuong);

        System.out.println();
        System.out.println("(3) Xóa phần tử khi đang duyệt:");
        List<String> ds1 = new ArrayList<>(List.of("SP001", "SP002", "SP003", "SP004"));
        try {
            for (String ma : ds1) if (ma.equals("SP002")) ds1.remove(ma);
        } catch (ConcurrentModificationException e) {
            System.out.println("  Cách sai gây ConcurrentModificationException");
        }

        List<String> ds2 = new ArrayList<>(List.of("SP001", "SP002", "SP003"));
        Iterator<String> it = ds2.iterator();
        while (it.hasNext()) {
            if (it.next().equals("SP002")) it.remove();
        }
        System.out.println("  Cách đúng dùng Iterator.remove(): " + ds2);

        List<String> ds3 = new ArrayList<>(List.of("SP001", "SP002", "SP003"));
        ds3.removeIf(ma -> ma.equals("SP002"));
        System.out.println("  Cách ngắn nhất removeIf():       " + ds3);

        System.out.println();
        System.out.println("(4) Danh sách bất biến và chuyển đổi với mảng:");
        List<String> khongSuaDuoc = List.of("SP001", "SP002");
        System.out.println("  " + khongSuaDuoc);
        try {
            khongSuaDuoc.add("SP003");
        } catch (UnsupportedOperationException e) {
            System.out.println("  Thêm vào List.of gây UnsupportedOperationException");
        }
        String[] mang = ds2.toArray(new String[0]);
        List<String> lai = new ArrayList<>(Arrays.asList(mang));
        System.out.println("  List -> mảng -> List: " + lai);
    }
}
