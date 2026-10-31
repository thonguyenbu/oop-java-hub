/*
 * Bài 2 - Khai báo và in tám kiểu dữ liệu nguyên thủy
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 2 - Cơ bản về ngôn ngữ lập trình Java
 *
 * Biên dịch: javac -encoding UTF-8 -d bin <đường dẫn tệp>
 */
public class Bai2 {
    public static void main(String[] args) {
        byte    soNhomHang   = 12;
        short   soNhaCungCap = 250;
        int     soLuongTon    = 1_200;
        long    doanhThuNam   = 2_400_000_000L;
        float   tiLeChietKhau = 0.05f;
        double  trongLuongKg  = 0.485;
        char    phanLoai      = 'A';
        boolean dangKinhDoanh = true;

        System.out.println("byte    soNhomHang    = " + soNhomHang   + "   (số nhóm hàng)");
        System.out.println("short   soNhaCungCap  = " + soNhaCungCap + "  (số nhà cung cấp)");
        System.out.println("int     soLuongTon    = " + soLuongTon   + " (tồn kho, cái)");
        System.out.println("long    doanhThuNam   = " + doanhThuNam  + " (đồng)");
        System.out.println("float   tiLeChietKhau = " + tiLeChietKhau + "  (5%)");
        System.out.println("double  trongLuongKg  = " + trongLuongKg + " (kg/sản phẩm)");
        System.out.println("char    phanLoai      = " + phanLoai     + "      (hạng sản phẩm)");
        System.out.println("boolean dangKinhDoanh = " + dangKinhDoanh + "   (còn bán hay không)");
    }
}
