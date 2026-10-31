package vd252;

public class TruyenThamSo {
    static void tangGia(double gia) {
        gia = gia * 2;
    }
    static void doiPhanTuDau(String[] mang) {
        mang[0] = "ĐÃ ĐỔI";
    }
    static void ganMangMoi(String[] mang) {
        mang = new String[]{"MẢNG MỚI"};
    }
    public static void main(String[] args) {
        double gia = 100_000;
        tangGia(gia);
        System.out.printf("Sau tangGia(gia): %.1f%n", gia);
        String[] ma = {"SP001", "SP002"};
        doiPhanTuDau(ma);
        System.out.printf("Sau doiPhanTuDau: %s%n", ma[0]);
        ganMangMoi(ma);
        System.out.printf("Sau ganMangMoi:   %s%n", ma[0]);
    }
}
