package vd271;

import java.util.Arrays;
public class MangSanPham {
    public static void main(String[] args) {
        String[] maSanPham = {"SP003", "SP001", "SP005", "SP002"};
        double[] donGia = new double[4];
        donGia[0] = 19900;
        donGia[1] = 65000;
        donGia[2] = 6000;
        donGia[3] = 42000;
        System.out.printf("Số phần tử: %d%n", maSanPham.length);
        System.out.printf("Trước khi sắp xếp: %s%n", Arrays.toString(maSanPham));
        Arrays.sort(maSanPham);
        System.out.printf("Sau khi sắp xếp:   %s%n", Arrays.toString(maSanPham));
        double tong = 0;
        for (double gia : donGia) {
            tong += gia;
        }
        System.out.printf("Tổng đơn giá: %.0f%n", tong);
    }
}
