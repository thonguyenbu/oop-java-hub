package chung;

/*
 * Lớp dùng chung - Các lớp nghiệp vụ dùng chung cho toàn Chương 5
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import java.math.BigDecimal;
import java.util.Objects;

public class SanPhamSo extends SanPham {
    private int soNgayHieuLuc;
    public SanPhamSo(String ma, String ten, BigDecimal donGia, int soNgayHieuLuc) {
        super(ma, ten, donGia);
        this.soNgayHieuLuc = soNgayHieuLuc;
    }
    @Override public String loaiSanPham() { return "Hàng số"; }
    public int getSoNgayHieuLuc() { return soNgayHieuLuc; }
}
