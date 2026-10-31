package bai09;

/*
 * Bài 9 - Giao diện sealed TrangThaiDon và switch không cần default
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class GiaiBai9 {

    // Cách viết cho Java 17. Bản dùng switch so khớp mẫu, không cần nhánh default,
    // nằm ở src21/bai09/GiaiBai9Java21.java (cần Java 21 trở lên).
    static String moTa(TrangThaiDon tt) {
        if (tt instanceof MoiTao)    return "Mới tạo, chờ xác nhận";
        if (tt instanceof DaXacNhan) return "Đã xác nhận, chuẩn bị hàng";
        if (tt instanceof DangGiao)  return "Đang giao cho khách";
        if (tt instanceof HoanTat)   return "Hoàn tất";
        if (tt instanceof DaHuy)     return "Đã hủy - lý do: " + ((DaHuy) tt).getLyDo();
        throw new IllegalStateException("Trạng thái chưa được hỗ trợ: " + tt);
    }

    static boolean choPhepHuy(TrangThaiDon tt) {
        return tt instanceof MoiTao || tt instanceof DaXacNhan;
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
