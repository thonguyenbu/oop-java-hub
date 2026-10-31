package vd241;

public class PhanLoaiDon {
    static String xepLoai(double tongTien) {
        if (tongTien >= 10_000_000) {
            return "Đơn hàng lớn";
        } else if (tongTien >= 2_000_000) {
            return "Đơn hàng trung bình";
        } else {
            return "Đơn hàng nhỏ";
        }
    }
    public static void main(String[] args) {
        double[] cacDon = {850_000, 3_500_000, 12_000_000};
        for (double tien : cacDon) {
            System.out.printf("%,.0f đ -> %s%n", tien, xepLoai(tien));
        }
    }
}
