package chung;

/*
 * Lớp dùng chung - Các lớp nghiệp vụ dùng chung cho toàn Chương 5
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import java.math.BigDecimal;
import java.util.Objects;

public class SanPhamVatLy extends SanPham {
    private int soLuongTon;
    public SanPhamVatLy(String ma, String ten, BigDecimal donGia, int soLuongTon) {
        super(ma, ten, donGia);
        this.soLuongTon = soLuongTon;
    }
    @Override public String loaiSanPham() { return "Hàng vật lý"; }
    public int getSoLuongTon() { return soLuongTon; }
    public boolean xuatKho(int sl) {
        if (sl <= 0 || sl > soLuongTon) return false;
        soLuongTon -= sl; return true;
    }
}
