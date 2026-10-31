package vd55;

/*
 * Ví dụ 5.5 - Set, vai trò của equals/hashCode và các phép toán tập hợp
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

public class KhachHangKhongBam {
    private final String ma;
    private final String hoTen;
    public KhachHangKhongBam(String ma, String hoTen) {
        this.ma = ma; this.hoTen = hoTen;
    }
 
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KhachHangKhongBam)) return false;
        return ma.equals(((KhachHangKhongBam) o).ma);
    }
    // CỐ Ý KHÔNG ghi đè hashCode()
}
