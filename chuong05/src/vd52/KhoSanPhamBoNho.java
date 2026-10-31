package vd52;

/*
 * Ví dụ 5.1 – 5.2 - Lớp tổng quát Kho<T>, Cap<K,V> và giao diện tổng quát
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import java.util.List;
import chung.*;
import java.util.ArrayList;

public class KhoSanPhamBoNho implements KhoDuLieu<SanPham> {
    private final List<SanPham> danhSach = new ArrayList<>();
 
    @Override public void them(SanPham sp) { if (sp != null) danhSach.add(sp); }
 
    @Override public SanPham timTheoMa(String ma) {
        for (SanPham sp : danhSach) {
            if (sp.getMaSanPham().equals(ma)) return sp;
        }
        return null;
    }
 
    @Override public List<SanPham> layTatCa() { return List.copyOf(danhSach); }
}
