package vd43;

/*
 * Ví dụ 4.3 – 4.5 - Đa hình, ghi đè, ép kiểu và toán tử instanceof
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class DemoEpKieu {
    public static void main(String[] args) {
        NhanVien nv = new TruongPhong("NV003", "Lê Văn Cường", 20_000_000, 5_000_000, 8);
        System.out.printf("Lương (gọi qua tham chiếu NhanVien): %.0f%n", nv.tinhLuong());
 
        TruongPhong ql = (TruongPhong) nv;          // downcasting hợp lệ
        ql.hopGiaoBan();
 
        NhanVien nv2 = new NhanVienKinhDoanh("NV002", "Trần Thị Bình",
                                      8_000_000, 250_000_000, 0.02);
        try {
            TruongPhong sai = (TruongPhong) nv2;    // downcasting sai loại
            sai.hopGiaoBan();
        } catch (ClassCastException e) {
            System.out.println("Bắt được ClassCastException:");
            System.out.println("  " + e.getMessage());
        }
 
        if (nv2 instanceof TruongPhong) {       // kiểm tra trước khi ép
            ((TruongPhong) nv2).hopGiaoBan();
        } else {
            System.out.println(nv2.getHoTen() + " không phải TruongPhong, bỏ qua.");
        }
    }
}
