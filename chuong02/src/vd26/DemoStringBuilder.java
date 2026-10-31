package vd26;

/*
 * Mục 2.6 - Nối chuỗi trong vòng lặp bằng StringBuilder.
 * Sách in đoạn mã rời kèm kết quả chạy; kho bổ sung lớp bao và phương thức main
 * để chạy được. Thân main giữ nguyên như in trong sách.
 */

public class DemoStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            sb.append("SP00").append(i);
            if (i < 5) {
                sb.append(", ");
            }
        }
        System.out.println(sb.toString());
    }
}
