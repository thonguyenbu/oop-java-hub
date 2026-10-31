package bai05;

/*
 * Bài 5 - Kiểm thử bốn tình huống giao dịch
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 3 - Lớp, đối tượng và phương thức
 */

public class KiemThuNganHang {

    static void inBang(String tieuDe, TaiKhoanNganHang... cacTk) {
        System.out.println(tieuDe);
        System.out.printf("  %-8s %-20s %14s %12s%n",
                "SỐ TK", "CHỦ TÀI KHOẢN", "SỐ DƯ", "THẤU CHI");
        for (TaiKhoanNganHang tk : cacTk) System.out.println("  " + tk.moTa());
    }

    public static void main(String[] args) {
        TaiKhoanNganHang a = new TaiKhoanNganHang("Nguyễn Văn An", 10_000_000, 2_000_000);
        TaiKhoanNganHang b = new TaiKhoanNganHang("Trần Thị Bình",  3_000_000,         0);
        inBang("TRẠNG THÁI BAN ĐẦU", a, b);

        System.out.println();
        System.out.println("Tình huống 1 - chuyển khoản THÀNH CÔNG: A chuyển 4.000.000 cho B");
        System.out.println("  Kết quả: " + a.chuyenKhoan(b, 4_000_000));
        inBang("  Sau giao dịch:", a, b);

        System.out.println();
        System.out.println("Tình huống 2 - chuyển khoản THẤT BẠI do thiếu tiền:");
        System.out.println("  B chuyển 9.000.000 cho A (số dư 7.000.000, không có thấu chi)");
        System.out.println("  Kết quả: " + b.chuyenKhoan(a, 9_000_000));
        inBang("  Sau giao dịch (phải giữ nguyên):", a, b);

        System.out.println();
        System.out.println("Tình huống 3 - nộp số tiền ÂM:");
        System.out.println("  Kết quả: " + a.nopTien(-500_000));

        System.out.println();
        System.out.println("Tình huống 4 - rút VƯỢT hạn mức thấu chi:");
        System.out.println("  A rút 9.000.000 (số dư 6.000.000 + thấu chi 2.000.000)");
        System.out.println("  Kết quả: " + a.rutTien(9_000_000));
        System.out.println("  A rút 8.000.000 (đúng bằng giới hạn)");
        System.out.println("  Kết quả: " + a.rutTien(8_000_000));
        inBang("  Sau hai lần rút:", a, b);

        System.out.println();
        System.out.println("Số tài khoản đã cấp: " + TaiKhoanNganHang.getSoTaiKhoanDaCap());
    }
}
