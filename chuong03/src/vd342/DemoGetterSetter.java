package vd342;

public class DemoGetterSetter {
    public static void main(String[] args) {
        SanPham sp = new SanPham("SP001", "Cà phê hòa tan G7", 65000, 120);
        System.out.println("Đơn giá hiện tại: " + sp.getDonGia());
        sp.setDonGia(-50000);
        System.out.println("Sau khi thử gán -50000: " + sp.getDonGia());
        sp.setDonGia(68000);
        System.out.println("Sau khi gán 68000: " + sp.getDonGia());
        System.out.println();
        System.out.println("Xuất kho 30 sản phẩm: " + sp.xuatKho(30));
        System.out.println("Xuất kho 500 sản phẩm: " + sp.xuatKho(500));
        System.out.println("Tồn kho còn: " + sp.getSoLuongTon());
    }
}
