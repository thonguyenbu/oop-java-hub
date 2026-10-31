package vn.edu.hub.oop.chuong02.tienich;

/*
 * Bài 9 - Lớp tiện ích: chuẩn hóa mã sản phẩm
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 2 - Cơ bản về ngôn ngữ lập trình Java
 *
 * Biên dịch: javac -encoding UTF-8 -d bin <đường dẫn tệp>
 */

public class ChuanHoa {

    public static String chuanHoaMa(String ma) {
        if (ma == null) return "";
        String s = ma.strip().toUpperCase();
        if (s.length() != 5 || !s.startsWith("SP")) return "";
        for (int i = 2; i < 5; i++)
            if (s.charAt(i) < '0' || s.charAt(i) > '9') return "";
        return s;
    }
}
