/*
 * Bài 4 - Minh họa hiện tượng tràn số kiểu int
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 2 - Cơ bản về ngôn ngữ lập trình Java
 *
 * Biên dịch: javac -encoding UTF-8 -d bin <đường dẫn tệp>
 */
public class Bai4 {
    public static void main(String[] args) {
        int soLuong = 3_000_000;
        int donGia  = 800_000;

        // Cả hai toán hạng đều là int nên phép nhân thực hiện trong phạm vi int.
        // Kết quả thật là 2.400.000.000.000, vượt xa giới hạn 2.147.483.647 của int
        // nên bị cắt bớt và cho ra một số âm vô nghĩa. Java KHÔNG báo lỗi.
        int ketQuaSai = soLuong * donGia;

        // Ép một toán hạng sang long trước khi nhân thì phép nhân
        // được thực hiện trong phạm vi long, đủ chỗ chứa kết quả.
        long ketQuaDung = (long) soLuong * donGia;

        System.out.println("Giới hạn của int : " + Integer.MAX_VALUE);
        System.out.println("Giới hạn của long: " + Long.MAX_VALUE);
        System.out.println();
        System.out.println("Tính bằng int  : " + ketQuaSai  + "   <-- SAI do tràn số");
        System.out.println("Tính bằng long : " + ketQuaDung + "    <-- ĐÚNG");
        System.out.println();
        System.out.println("Chênh lệch: " + (ketQuaDung - ketQuaSai));
    }
}
