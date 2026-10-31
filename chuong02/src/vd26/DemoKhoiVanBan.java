package vd26;

/*
 * Mục 2.6 - Khối văn bản (text block), yêu cầu Java 15 trở lên.
 * Sách in đoạn mã rời kèm kết quả chạy; kho bổ sung lớp bao và phương thức main
 * để chạy được. Thân main giữ nguyên như in trong sách.
 */

public class DemoKhoiVanBan {
    public static void main(String[] args) {
        String tieuDeHoaDon = """
                CỬA HÀNG MINIMART
                --------------------------
                Mã SP   Số lượng   Thành tiền""";
        System.out.println(tieuDeHoaDon);
    }
}
