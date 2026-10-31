package vd56;

/*
 * Mục 5.7 - Comparable và Comparator: năm cách sắp xếp
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import chung.*;
import java.util.*;

public class DemoSapXep {
    public static void main(String[] args) {
        List<SanPham> danhMuc = DuLieuMau.danhMuc();
        List<SanPham> ds = new ArrayList<>(danhMuc);

        Collections.sort(ds);
        in("(a) Thứ tự tự nhiên (Comparable), theo mã sản phẩm:", ds);
        ds.sort(new SoSanhTheoGia());
        in("(b) Comparator theo đơn giá tăng dần:", ds);
        ds.sort(new SoSanhTheoTen());
        in("(c) Comparator theo tên, đúng thứ tự tiếng Việt:", ds);
        ds.sort(new SoSanhTheoLoaiRoiGia());
        in("(d) Comparator hai tiêu chí: loại tăng dần, "
           + "trong mỗi loại giá giảm dần:", ds);

        Set<SanPham> tapTheoGia = new TreeSet<>(new SoSanhTheoGia());
        tapTheoGia.addAll(danhMuc);
        in("(e) TreeSet dùng Comparator, tự sắp theo giá:", tapTheoGia);
    }

    static void in(String tieuDe, Collection<SanPham> ds) {
        System.out.println(tieuDe);
        for (SanPham sp : ds) System.out.println("  " + sp);
    }
}
