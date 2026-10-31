package vd322;

public class DemoPhuongThuc {
    public static void main(String[] args) {
        SanPham sp = new SanPham();
        sp.maSanPham = "SP001";
        sp.tenSanPham = "Cà phê hòa tan G7";
        sp.donGia = 65000;
        sp.soLuongTon = 120;
        System.out.println(sp.moTa());
        System.out.println("Giá trị tồn kho: " + sp.giaTriTonKho());
        System.out.println("Đủ 50 sản phẩm? " + sp.duHang(50));
        System.out.println("Đủ 200 sản phẩm? " + sp.duHang(200));
        System.out.println();
        sp.banHang(30);
        System.out.println("Sau khi bán 30: " + sp.moTa());
        sp.banHang(500);
        sp.banHang(-5);
        System.out.println("Trạng thái cuối: " + sp.moTa());
    }
}
