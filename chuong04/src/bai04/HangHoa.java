package bai04;

/*
 * Bài 4 - Giao diện CoTinhThue với phương thức default
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class HangHoa implements CoTinhThue {
    private String ten;
    private double donGia;
    private int soLuong;
 
    public HangHoa(String ten, double donGia, int soLuong) {
        this.ten = ten;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }
    @Override public double giaTruocThue() { return donGia * soLuong; }
}
