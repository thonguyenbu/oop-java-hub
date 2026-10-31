package chung;

/*
 * Lớp dùng chung - Các lớp nghiệp vụ dùng chung cho toàn Chương 5
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/** Danh mục năm sản phẩm dùng lại ở nhiều ví dụ và bài tập của chương. */
public final class DuLieuMau {

    private DuLieuMau() { }

    public static List<SanPham> danhMuc() {
        List<SanPham> ds = new ArrayList<>();
        ds.add(new SanPhamVatLy("SP001", "Cà phê hòa tan G7", new BigDecimal("65000"), 120));
        ds.add(new SanPhamVatLy("SP002", "Bánh quy bơ",       new BigDecimal("42000"),  85));
        ds.add(new SanPhamVatLy("SP003", "Nước suối 500ml",   new BigDecimal("6000"),  500));
        ds.add(new SanPhamSo("SP004", "Khóa học trực tuyến",  new BigDecimal("890000"),  90));
        ds.add(new SanPhamSo("SP005", "Phần mềm kế toán",     new BigDecimal("2400000"), 365));
        return ds;
    }
}
