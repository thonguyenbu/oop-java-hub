package vn.edu.hub.oop.chuong02.tienich;

/*
 * Bài 14 - Tầng tính toán: kiểm tra dữ liệu và tổng hợp, không in ra màn hình
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 2 - Cơ bản về ngôn ngữ lập trình Java
 *
 * Biên dịch: javac -encoding UTF-8 -d bin <đường dẫn tệp>
 */

import java.util.*;

/** Tầng tính toán: chỉ xử lý dữ liệu, không in ra màn hình. */
public class XuLyBanHang {

    /** Kiểm tra một dòng dữ liệu. Trả về chuỗi rỗng nếu hợp lệ, ngược lại là lý do lỗi. */
    public static String kiemTraDong(String dong, Map<String, Double> bangGia) {
        if (dong == null || dong.isBlank()) return "dòng rỗng";
        String[] t = dong.split(";");
        if (t.length != 3) return "không đủ ba trường";
        if (!bangGia.containsKey(t[1])) return "mã sản phẩm " + t[1] + " không có trong bảng giá";
        int sl;
        try {
            sl = Integer.parseInt(t[2].strip());
        } catch (NumberFormatException e) {
            return "số lượng không phải số nguyên";
        }
        if (sl <= 0) return "số lượng phải lớn hơn 0";
        return "";
    }

    public static Map<String, Integer> tinhSoLuongTheoSanPham(List<String> dongHopLe) {
        Map<String, Integer> kq = new TreeMap<>();
        for (String d : dongHopLe) {
            String[] t = d.split(";");
            kq.put(t[1], kq.getOrDefault(t[1], 0) + Integer.parseInt(t[2].strip()));
        }
        return kq;
    }

    public static Map<String, Double> tinhDoanhThuTheoSanPham(
            List<String> dongHopLe, Map<String, Double> bangGia) {
        Map<String, Double> kq = new TreeMap<>();
        for (String d : dongHopLe) {
            String[] t = d.split(";");
            int sl = Integer.parseInt(t[2].strip());
            kq.put(t[1], kq.getOrDefault(t[1], 0.0) + bangGia.get(t[1]) * sl);
        }
        return kq;
    }

    public static Map<String, Double> tinhChiTieuTheoKhachHang(
            List<String> dongHopLe, Map<String, Double> bangGia) {
        Map<String, Double> kq = new TreeMap<>();
        for (String d : dongHopLe) {
            String[] t = d.split(";");
            int sl = Integer.parseInt(t[2].strip());
            kq.put(t[0], kq.getOrDefault(t[0], 0.0) + bangGia.get(t[1]) * sl);
        }
        return kq;
    }

    /** Trả về mã khách hàng có tổng chi tiêu lớn nhất. */
    public static String khachChiTieuCaoNhat(Map<String, Double> chiTieu) {
        String khoa = "";
        double lonNhat = -1;
        for (Map.Entry<String, Double> m : chiTieu.entrySet()) {
            if (m.getValue() > lonNhat) {
                lonNhat = m.getValue();
                khoa = m.getKey();
            }
        }
        return khoa;
    }

    /** Trả về mã sản phẩm bán được nhiều nhất theo số lượng. */
    public static String sanPhamBanChayNhat(Map<String, Integer> soLuong) {
        String khoa = "";
        int lonNhat = -1;
        for (Map.Entry<String, Integer> m : soLuong.entrySet()) {
            if (m.getValue() > lonNhat) {
                lonNhat = m.getValue();
                khoa = m.getKey();
            }
        }
        return khoa;
    }
}
