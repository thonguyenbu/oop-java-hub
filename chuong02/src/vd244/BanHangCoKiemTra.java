package vd244;

public class BanHangCoKiemTra {

    static int soLuongTon = 50;

    static void ban(int soLuong) {
        if (soLuong <= 0) {
            throw new IllegalArgumentException("Số lượng bán phải lớn hơn 0, nhận được " + soLuong);
        }
        if (soLuong > soLuongTon) {
            throw new IllegalStateException("Tồn kho chỉ còn " + soLuongTon
                                            + ", không đủ cho " + soLuong);
        }
        soLuongTon -= soLuong;
        System.out.println("Đã bán " + soLuong + ", tồn kho còn " + soLuongTon);
    }

    public static void main(String[] args) {
        int[] cacYeuCau = {20, -5, 100, 10};
        for (int sl : cacYeuCau) {
            try {
                ban(sl);
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Từ chối: " + e.getMessage());
            }
        }
    }
}
