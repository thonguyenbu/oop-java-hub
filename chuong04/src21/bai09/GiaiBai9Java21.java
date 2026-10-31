package bai09;

/*
 * Bài 9 - Giao diện sealed TrangThaiDon và switch không cần default
 * Phiên bản dùng switch so khớp mẫu: cần Java 21 trở lên
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class GiaiBai9Java21 {

    static String moTa(TrangThaiDon tt) {
        return switch (tt) {
            case MoiTao t    -> "Mới tạo, chờ xác nhận";
            case DaXacNhan t -> "Đã xác nhận, chuẩn bị hàng";
            case DangGiao t  -> "Đang giao cho khách";
            case HoanTat t   -> "Hoàn tất";
            case DaHuy t     -> "Đã hủy - lý do: " + t.getLyDo();
        };
    }

    static boolean choPhepHuy(TrangThaiDon tt) {
        return switch (tt) {
            case MoiTao t    -> true;
            case DaXacNhan t -> true;
            default          -> false;
        };
    }
    public static void main(String[] args) {
        TrangThaiDon[] cacTrangThai = {
            new MoiTao(), new DaXacNhan(), new DangGiao(),
            new HoanTat(), new DaHuy("Khách đổi ý")
        };
        for (TrangThaiDon tt : cacTrangThai) {
            System.out.printf("%-12s %-36s hủy được: %s%n",
                    tt.getClass().getSimpleName(), moTa(tt), choPhepHuy(tt));
        }
    }
}
