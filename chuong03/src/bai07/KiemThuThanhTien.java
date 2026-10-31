package bai07;

/*
 * Bài 7 - Kiểm thử cả ba phiên bản thanhTien
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 3 - Lớp, đối tượng và phương thức
 */

public class KiemThuThanhTien {
    public static void main(String[] args) {
        SanPham sp = new SanPham("SP001", "Cà phê hòa tan G7", 65_000, 120);
        int soLuong = 10;

        System.out.println("Sản phẩm: " + sp.getTenSanPham()
                + ", đơn giá " + (long) sp.getDonGia() + " đ, mua " + soLuong + " cái");
        System.out.println("-".repeat(62));
        System.out.printf("%-46s %14.0f%n", "thanhTien(10)", sp.thanhTien(soLuong));
        System.out.printf("%-46s %14.0f%n", "thanhTien(10, 0.10)  chiết khấu 10%",
                sp.thanhTien(soLuong, 0.10));
        System.out.printf("%-46s %14.0f%n", "thanhTien(10, 0.10, 0.08)  + VAT 8%",
                sp.thanhTien(soLuong, 0.10, SanPham.THUE_SUAT_VAT));
        System.out.println("-".repeat(62));

        System.out.println();
        System.out.println("Kiểm tra dữ liệu ngoài khoảng cho phép:");
        System.out.printf("%-46s %14.0f%n", "thanhTien(10, 1.5)  tỉ lệ vô lý -> bỏ qua",
                sp.thanhTien(soLuong, 1.5));
        System.out.printf("%-46s %14.0f%n", "thanhTien(10, 0.10, -0.05)  thuế âm -> bỏ qua",
                sp.thanhTien(soLuong, 0.10, -0.05));

        System.out.println();
        System.out.println("Ba phiên bản dùng lại lẫn nhau: công thức nhân đơn giá");
        System.out.println("với số lượng chỉ viết MỘT lần ở phiên bản một chữ số.");
    }
}
