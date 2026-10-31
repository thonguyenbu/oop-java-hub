package vd23;

public class EpKieu {
    public static void main(String[] args) {
        int soLuongLon = 3_000_000;
        long doanhThu = (long) soLuongLon * 800_000;   // đúng
        int doanhThuSai = soLuongLon * 800_000;        // tràn số
        System.out.println("Đúng (long): " + doanhThu);
        System.out.println("Sai  (int) : " + doanhThuSai);
        double d = 9.99;
        int i = (int) d;
        System.out.println("(int) 9.99 = " + i);
    }
}
