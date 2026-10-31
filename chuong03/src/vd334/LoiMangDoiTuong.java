package vd334;

/*
 * Mục 3.3.4 - Dùng mảng đối tượng khi các ô còn null (chương trình cố ý dừng vì lỗi).
 * Sách in đoạn mã rời, tên lớp LoiMangDoiTuong lấy từ kết quả chạy in trong sách;
 * kho bổ sung lớp bao và phương thức main. Thân main giữ nguyên như in trong sách.
 */

public class LoiMangDoiTuong {
    public static void main(String[] args) {
        SanPham[] danhSach = new SanPham[4];
        System.out.println("danhSach[0] = " + danhSach[0]);
        System.out.println(danhSach[0].moTa());
    }
}
