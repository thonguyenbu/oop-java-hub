package vd343;

/*
 * Ví dụ 3.10 (mục 3.4.3) - Lời gọi hai phương thức thanhTien nạp chồng.
 * Sách in hai lời gọi rời và ghi "với sp có đơn giá 68000"; kho bổ sung lớp bao,
 * phương thức main và dòng tạo sp. Hai lời gọi giữ nguyên như in trong sách.
 */

public class DemoNapChong {
    public static void main(String[] args) {
        SanPham sp = new SanPham("SP001", "Cà phê hòa tan G7", 68000, 120);
        System.out.printf("Thành tiền khi mua 3  : %.0f%n", sp.thanhTien(3));
        System.out.printf("Thành tiền có CK 10%%  : %.0f%n", sp.thanhTien(3, 0.10));
    }
}
