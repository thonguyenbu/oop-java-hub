/*
 * Bài 10 - Quản lý danh sách mã sản phẩm bằng ArrayList, chạy theo menu
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 2 - Cơ bản về ngôn ngữ lập trình Java
 *
 * Biên dịch: javac -encoding UTF-8 -d bin <đường dẫn tệp>
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Bai10 {

    static void inMenu() {
        System.out.println();
        System.out.println("--- QUẢN LÝ DANH SÁCH MÃ SẢN PHẨM ---");
        System.out.println("1. Thêm mã sản phẩm");
        System.out.println("2. Xóa theo mã");
        System.out.println("3. Kiểm tra mã có tồn tại");
        System.out.println("4. Đếm số lượng");
        System.out.println("5. In toàn bộ danh sách");
        System.out.println("0. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    public static void main(String[] args) {
        ArrayList<String> danhSach = new ArrayList<>();
        Scanner banPhim = new Scanner(System.in);
        int chon;
        do {
            inMenu();
            chon = Integer.parseInt(banPhim.nextLine().strip());
            switch (chon) {
                case 1 -> {
                    System.out.print("Nhập mã cần thêm: ");
                    String ma = banPhim.nextLine().strip().toUpperCase();
                    if (ma.isEmpty()) System.out.println("  Mã rỗng, bỏ qua.");
                    else if (danhSach.contains(ma)) System.out.println("  Mã " + ma + " đã có.");
                    else { danhSach.add(ma); System.out.println("  Đã thêm " + ma); }
                }
                case 2 -> {
                    System.out.print("Nhập mã cần xóa: ");
                    String ma = banPhim.nextLine().strip().toUpperCase();
                    System.out.println(danhSach.remove(ma)
                            ? "  Đã xóa " + ma : "  Không tìm thấy " + ma);
                }
                case 3 -> {
                    System.out.print("Nhập mã cần kiểm tra: ");
                    String ma = banPhim.nextLine().strip().toUpperCase();
                    System.out.println(danhSach.contains(ma)
                            ? "  Có " + ma + " ở vị trí " + danhSach.indexOf(ma)
                            : "  Không có " + ma);
                }
                case 4 -> System.out.println("  Số lượng mã: " + danhSach.size());
                case 5 -> {
                    if (danhSach.isEmpty()) System.out.println("  Danh sách rỗng.");
                    else {
                        System.out.println("  Danh sách hiện có:");
                        for (int i = 0; i < danhSach.size(); i++)
                            System.out.println("    " + (i + 1) + ". " + danhSach.get(i));
                    }
                }
                case 0 -> System.out.println("Kết thúc chương trình.");
                default -> System.out.println("  Chức năng không hợp lệ.");
            }
        } while (chon != 0);
        banPhim.close();
    }
}
