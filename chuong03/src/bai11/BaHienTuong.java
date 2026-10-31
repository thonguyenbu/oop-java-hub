package bai11;

/*
 * Bài 11 - Ba hiện tượng của kiểu tham chiếu, có chú thích phân tích
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 3 - Lớp, đối tượng và phương thức
 */

public class BaHienTuong {

    /** Dùng cho hiện tượng (b): gán lại tham số bên trong phương thức. */
    static void thayTheSanPham(SanPham sp) {
        // Tham số sp là một BẢN SAO của tham chiếu ở nơi gọi.
        // Gán lại sp chỉ đổi bản sao; biến ở nơi gọi vẫn trỏ đối tượng cũ.
        sp = new SanPham("SP999", "Sản phẩm thay thế", 1_000, 1);
        System.out.println("    Bên trong phương thức, sp trỏ tới: " + sp.getTenSanPham());
    }

    /** Dùng để đối chiếu: sửa thuộc tính qua tham số thì CÓ tác dụng. */
    static void doiTenSanPham(SanPham sp, String tenMoi) {
        sp.setTenSanPham(tenMoi);
    }

    public static void main(String[] args) {

        System.out.println("=== (a) HAI BIẾN CÙNG TRỎ MỘT ĐỐI TƯỢNG ===");
        SanPham a = new SanPham("SP001", "Cà phê hòa tan G7", 65_000, 120);
        SanPham b = a;                    // KHÔNG tạo sản phẩm thứ hai
        System.out.println("  Trước khi sửa:");
        System.out.println("    a.tồn kho = " + a.getSoLuongTon());
        System.out.println("    b.tồn kho = " + b.getSoLuongTon());
        b.setSoLuongTon(75);              // sửa qua b
        System.out.println("  Sau khi sửa qua biến b:");
        System.out.println("    a.tồn kho = " + a.getSoLuongTon() + "   <-- a cũng đổi");
        System.out.println("    b.tồn kho = " + b.getSoLuongTon());
        System.out.println("    a == b ? " + (a == b));
        System.out.println("  Giải thích: câu lệnh b = a chỉ sao chép ĐỊA CHỈ, nên hai");
        System.out.println("  biến là hai tên gọi của cùng một đối tượng trong bộ nhớ.");

        System.out.println();
        System.out.println("=== (b) GÁN LẠI THAM SỐ BÊN TRONG PHƯƠNG THỨC ===");
        SanPham c = new SanPham("SP002", "Bánh quy bơ", 42_000, 85);
        System.out.println("  Trước khi gọi: c trỏ tới " + c.getTenSanPham());
        thayTheSanPham(c);
        System.out.println("  Sau khi gọi  : c trỏ tới " + c.getTenSanPham()
                + "   <-- KHÔNG đổi");
        doiTenSanPham(c, "Bánh quy bơ loại đặc biệt");
        System.out.println("  Nhưng sửa THUỘC TÍNH qua tham số thì có tác dụng:");
        System.out.println("    c.tên = " + c.getTenSanPham());
        System.out.println("  Giải thích: Java truyền tham số theo giá trị. Gán lại tham số");
        System.out.println("  chỉ đổi bản sao địa chỉ; gọi setter thì đi theo địa chỉ ấy");
        System.out.println("  tới đúng đối tượng gốc nên sửa được.");

        System.out.println();
        System.out.println("=== (c) MẢNG ĐỐI TƯỢNG CHƯA ĐƯỢC TẠO PHẦN TỬ ===");
        SanPham[] kho = new SanPham[3];   // ba ô đều đang là null
        System.out.println("  Sau new SanPham[3], giá trị từng ô:");
        for (int i = 0; i < kho.length; i++) System.out.println("    kho[" + i + "] = " + kho[i]);
        try {
            System.out.println("  Thử gọi kho[0].getTenSanPham() ...");
            System.out.println(kho[0].getTenSanPham());
        } catch (NullPointerException e) {
            System.out.println("    Bắt được NullPointerException");
        }
        kho[0] = new SanPham("SP003", "Nước suối 500ml", 6_000, 500);
        System.out.println("  Sau khi tạo đối tượng cho ô thứ nhất:");
        System.out.println("    kho[0].tên = " + kho[0].getTenSanPham());
        System.out.println("  Giải thích: new SanPham[3] chỉ cấp phát ba Ô CHỨA địa chỉ,");
        System.out.println("  chưa tạo đối tượng nào. Phải gọi new SanPham(...) cho từng ô.");
    }
}
