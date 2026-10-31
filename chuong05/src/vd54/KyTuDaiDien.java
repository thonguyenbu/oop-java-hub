package vd54;

/*
 * Ví dụ 5.4 - Ba dạng ký tự đại diện: ? extends, ? super, ?
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import chung.*;

public class KyTuDaiDien {
 
    // CHỈ ĐỌC: nhận danh sách của SanPham hoặc bất kỳ lớp con nào
    public static BigDecimal tongDonGia(List<? extends SanPham> ds) {
        BigDecimal tong = BigDecimal.ZERO;
        for (SanPham sp : ds) tong = tong.add(sp.getDonGia());
        // ds.add(...);   // KHÔNG được: không biết kiểu phần tử thật
        return tong;
    }
 
    // CHỈ GHI: nhận danh sách của SanPhamVatLy hoặc bất kỳ lớp cha nào
    public static void themHangMau(List<? super SanPhamVatLy> ds) {
        ds.add(new SanPhamVatLy("SP999", "Hàng mẫu", new BigDecimal("1000"), 1));
    }
 
    public static void demSoPhanTu(List<?> ds) {
        System.out.println("  Số phần tử: " + ds.size());
    }
}
