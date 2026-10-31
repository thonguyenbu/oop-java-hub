package vd312;

public class DemoThamChieu {
    public static void main(String[] args) {
        SanPham a = new SanPham();
        a.maSanPham = "SP001";
        a.donGia = 65000;
        SanPham b = a;                 // sao chép THAM CHIẾU, không sao chép đối tượng
        b.donGia = 70000;
        System.out.println("a.donGia = " + a.donGia);
        System.out.println("b.donGia = " + b.donGia);
        System.out.println("a == b   -> " + (a == b));
        SanPham c = new SanPham();
        c.maSanPham = "SP001";
        c.donGia = 70000;
        System.out.println("a == c   -> " + (a == c));
        System.out.println();
        System.out.println("In thẳng đối tượng: " + a);
        SanPham d = null;
        System.out.println("d = " + d);
        try {
            System.out.println(d.maSanPham);
        } catch (NullPointerException e) {
            System.out.println("Truy cập d.maSanPham gây lỗi NullPointerException");
        }
    }
}
