package vd242;

/*
 * Mục 2.4.2 - Vòng for đếm số lần.
 * Sách in đoạn mã rời kèm kết quả chạy; kho bổ sung lớp bao và phương thức main
 * để chạy được. Thân main giữ nguyên như in trong sách.
 */

public class DemoVongFor {
    public static void main(String[] args) {
        double soDu = 100_000_000;
        final double LAI_SUAT = 0.06;
        for (int nam = 1; nam <= 5; nam++) {
            soDu = soDu * (1 + LAI_SUAT);
            System.out.printf("Năm %d: %,.0f đ%n", nam, soDu);
        }
    }
}
