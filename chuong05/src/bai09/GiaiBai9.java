package bai09;

/*
 * Bài 9 - Bốn cách xóa phần tử khi đang duyệt, một cách sai
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import java.util.*;

public class GiaiBai9 {

    static List<String> duLieu() {
        return new ArrayList<>(List.of("SP001", "SP002", "SP003", "SP002", "SP004"));
    }

    public static void main(String[] args) {
        // (a) SAI
        List<String> ds1 = duLieu();
        System.out.println("Cách 1 - for-each rồi remove (SAI):");
        try {
            for (String ma : ds1) if (ma.equals("SP002")) ds1.remove(ma);
            System.out.println("  " + ds1);
        } catch (ConcurrentModificationException e) {
            System.out.println("  Ném ConcurrentModificationException, danh sách hỏng dở:");
            System.out.println("  " + ds1);
        }

        // (b) ĐÚNG - Iterator.remove()
        List<String> ds2 = duLieu();
        Iterator<String> it = ds2.iterator();
        while (it.hasNext()) if (it.next().equals("SP002")) it.remove();
        System.out.println("Cách 2 - Iterator.remove() (ĐÚNG): " + ds2);

        // (c) ĐÚNG - duyệt ngược theo chỉ số
        List<String> ds3 = duLieu();
        for (int i = ds3.size() - 1; i >= 0; i--)
            if (ds3.get(i).equals("SP002")) ds3.remove(i);
        System.out.println("Cách 3 - duyệt ngược theo chỉ số (ĐÚNG): " + ds3);

        // (d) ĐÚNG - dựng danh sách mới
        List<String> ds4 = duLieu();
        List<String> giuLai = new ArrayList<>();
        for (String ma : ds4) if (!ma.equals("SP002")) giuLai.add(ma);
        System.out.println("Cách 4 - dựng danh sách mới (ĐÚNG): " + giuLai);
    }
}
