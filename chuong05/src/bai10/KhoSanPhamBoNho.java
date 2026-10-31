package bai10;

/*
 * Bài 10 - Giao diện KhoDuLieu<T, K> và lớp cài đặt trong bộ nhớ
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import java.util.List;
import java.util.*;
import chung.*;

public class KhoSanPhamBoNho implements KhoDuLieu<SanPham, String> {
    private final Map<String, SanPham> duLieu = new LinkedHashMap<>();
 
    @Override public void them(SanPham sp) {
        if (sp != null) duLieu.put(sp.getMaSanPham(), sp);
    }
    @Override public boolean xoaTheoKhoa(String ma) { return duLieu.remove(ma) != null; }
    @Override public SanPham timTheoKhoa(String ma) { return duLieu.get(ma); }
    @Override public List<SanPham> layTatCa()       { return new ArrayList<>(duLieu.values()); }
    @Override public int soLuong()                  { return duLieu.size(); }
 
    // phương thức riêng của lớp cài đặt, không thuộc giao diện
    public List<SanPham> laySapXep(Comparator<SanPham> bs) {
        List<SanPham> ds = layTatCa();
        ds.sort(bs);
        return ds;
    }
}
