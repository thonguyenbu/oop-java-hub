/*
 * Bài 7 - Chuẩn hóa và kiểm tra tính hợp lệ của mã sản phẩm
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 2 - Cơ bản về ngôn ngữ lập trình Java
 *
 * Biên dịch: javac -encoding UTF-8 -d bin <đường dẫn tệp>
 */
public class Bai7 {

    /**
     * Chuẩn hóa mã sản phẩm: bỏ khoảng trắng thừa, chuyển chữ hoa,
     * kiểm tra đúng dạng SP + ba chữ số. Trả về chuỗi rỗng nếu không hợp lệ.
     */
    static String chuanHoaMa(String ma) {
        if (ma == null) return "";
        String s = ma.strip().toUpperCase();
        if (s.length() != 5) return "";
        if (!s.startsWith("SP")) return "";
        for (int i = 2; i < 5; i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') return "";
        }
        return s;
    }

    public static void main(String[] args) {
        String[] duLieuNhap = {
            "  sp001  ", "SP002", "sp01", "SPX99", "  sp123", "KH001", "sp0012", null
        };
        System.out.printf("%-14s %-14s %s%n", "ĐẦU VÀO", "KẾT QUẢ", "NHẬN XÉT");
        System.out.println("-".repeat(58));
        for (String d : duLieuNhap) {
            String kq = chuanHoaMa(d);
            String nhanXet = kq.isEmpty() ? "không hợp lệ" : "hợp lệ";
            System.out.printf("%-14s %-14s %s%n",
                    (d == null ? "null" : "[" + d + "]"),
                    (kq.isEmpty() ? "(rỗng)" : kq), nhanXet);
        }
    }
}
