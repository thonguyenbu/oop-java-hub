package tonghop;

/*
 * Ví dụ tổng hợp - Báo cáo bán hàng dùng List, Set, Map và lớp tổng quát
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import chung.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class BaoCaoBanHang {
    public static void main(String[] args) {
        Locale vn = Locale.forLanguageTag("vi-VN");

        // 1. Danh mục sản phẩm lưu trong List
        List<SanPham> danhMuc = DuLieuMau.danhMuc();

        // 2. Bảng tra cứu nhanh theo mã, dựng từ List
        Map<String, SanPham> traCuu = new HashMap<>();
        for (SanPham sp : danhMuc) traCuu.put(sp.getMaSanPham(), sp);

        // 3. Nhật ký bán hàng: dùng lại lớp tổng quát Cap<K,V> của mục 5.2
        List<Cap<String, Integer>> nhatKyBan = List.of(
            new Cap<>("SP001", 3), new Cap<>("SP002", 1), new Cap<>("SP001", 2),
            new Cap<>("SP003", 10), new Cap<>("SP005", 1), new Cap<>("SP002", 4),
            new Cap<>("SP009", 2),      // mã ngoài danh mục
            new Cap<>("SP003", 0),      // số lượng không hợp lệ
            new Cap<>("SP002", 500));   // vượt số lượng tồn kho

        System.out.println("BÁO CÁO BÁN HÀNG TRONG NGÀY");
        System.out.println("=".repeat(72));
        System.out.printf("%-6s %-24s %-12s %4s %14s%n",
                "MÃ", "TÊN SẢN PHẨM", "LOẠI", "SL", "THÀNH TIỀN");
        System.out.println("-".repeat(72));

        BigDecimal tongTien = BigDecimal.ZERO;
        Map<String, Integer> soLuongTheoMa = new TreeMap<>();
        Set<String> maDaBan = new LinkedHashSet<>();

        for (Cap<String, Integer> dong : nhatKyBan) {
            String ma = dong.getKhoa();
            int sl = dong.getGiaTri();
            SanPham sp = traCuu.get(ma);
            if (sp == null) {                       // mã ngoài danh mục
                System.out.printf("%-6s %-24s %-12s %4d %14s%n",
                        ma, "(ngoài danh mục)", "-", sl, "TỪ CHỐI");
                continue;
            }
            if (sl <= 0) {                          // số lượng không hợp lệ
                System.out.printf("%-6s %-24s %-12s %4d %14s%n",
                        ma, sp.getTenSanPham(), sp.loaiSanPham(), sl, "TỪ CHỐI");
                continue;
            }
            if (sp instanceof SanPhamVatLy hang && !hang.xuatKho(sl)) {
                System.out.printf("%-6s %-24s %-12s %4d %14s%n",
                        ma, sp.getTenSanPham(), sp.loaiSanPham(), sl, "THIẾU HÀNG");
                continue;                           // xuất kho thất bại: không ghi nhận
            }
            BigDecimal thanhTien = sp.thanhTien(sl);
            tongTien = tongTien.add(thanhTien);
            soLuongTheoMa.put(ma, soLuongTheoMa.getOrDefault(ma, 0) + sl);
            maDaBan.add(ma);
            System.out.printf(vn, "%-6s %-24s %-12s %4d %,14.0f%n",
                    ma, sp.getTenSanPham(), sp.loaiSanPham(), sl, thanhTien);
        }
        BigDecimal thue = tongTien.multiply(new BigDecimal("0.08"))
                                  .setScale(0, RoundingMode.HALF_UP);
        System.out.println("-".repeat(72));
        System.out.printf(vn, "%-49s %,14.0f%n", "TỔNG TIỀN HÀNG:", tongTien);
        System.out.printf(vn, "%-49s %,14.0f%n", "THUẾ VAT 8%:", thue);
        System.out.printf(vn, "%-49s %,14.0f%n", "TỔNG PHẢI THU:", tongTien.add(thue));

        System.out.println();
        System.out.println("SỐ LƯỢNG BÁN THEO MÃ (TreeMap tự sắp theo khóa):");
        for (Map.Entry<String, Integer> m : soLuongTheoMa.entrySet())
            System.out.printf("  %-6s%4d%n", m.getKey(), m.getValue());

        // 4. Sản phẩm chưa bán được: phép hiệu tập hợp
        Set<String> chuaBan = new TreeSet<>(traCuu.keySet());
        chuaBan.removeAll(maDaBan);
        System.out.println();
        System.out.println("Mã đã bán (Set giữ thứ tự xuất hiện): " + maDaBan);
        System.out.println("Mã chưa bán được: " + chuaBan);

        // 5. Xếp hạng theo đơn giá
        List<SanPham> theoGia = new ArrayList<>(danhMuc);
        theoGia.sort(Collections.reverseOrder(new SoSanhTheoGia()));
        System.out.println();
        System.out.println("TOP 3 SẢN PHẨM ĐƠN GIÁ CAO NHẤT:");
        for (int i = 0; i < 3; i++) System.out.println("  " + theoGia.get(i));

        // 6. Tồn kho sau khi bán
        List<SanPhamVatLy> conTon = new ArrayList<>();
        for (SanPham sp : danhMuc)
            if (sp instanceof SanPhamVatLy h && h.getSoLuongTon() > 0) conTon.add(h);
        System.out.println();
        System.out.println("TỒN KHO SAU KHI BÁN - Hàng vật lý còn tồn ("
                + conTon.size() + " mặt hàng)");
        for (SanPhamVatLy h : conTon)
            System.out.printf("  %-6s %-24s còn %4d%n",
                    h.getMaSanPham(), h.getTenSanPham(), h.getSoLuongTon());
    }
}
