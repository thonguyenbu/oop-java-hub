package tiemphuthuoc;

/*
 * Mục 6.10.1 - Tiêm phụ thuộc: kiểm thử tầng nghiệp vụ không cần CSDL
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 6 - Xây dựng ứng dụng hướng đối tượng
 */

import chung.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Bản cài đặt trong bộ nhớ: dùng để kiểm thử tầng nghiệp vụ mà không cần CSDL. */
public class KhoSanPhamBoNho implements KhoDuLieu<SanPham, String> {

    private final Map<String, SanPham> duLieu = new LinkedHashMap<>();

    @Override public void them(SanPham sp) {
        if (sp != null) duLieu.put(sp.getMaSanPham(), sp);
    }
    @Override public boolean capNhat(SanPham sp) {
        return sp != null && duLieu.replace(sp.getMaSanPham(), sp) != null;
    }
    @Override public boolean xoaTheoKhoa(String ma) { return duLieu.remove(ma) != null; }
    @Override public SanPham timTheoKhoa(String ma) { return duLieu.get(ma); }
    @Override public List<SanPham> layTatCa()       { return new ArrayList<>(duLieu.values()); }
    @Override public int soLuong()                  { return duLieu.size(); }
}
