package vn.edu.hub.oop.chuong02;

/*
 * Bài 14 - Tầng hiển thị: chỉ in báo cáo, không chứa phép tính nghiệp vụ
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 2 - Cơ bản về ngôn ngữ lập trình Java
 *
 * Biên dịch: javac -encoding UTF-8 -d bin <đường dẫn tệp>
 */

import java.util.*;
import vn.edu.hub.oop.chuong02.tienich.XuLyBanHang;

/** Tầng hiển thị: chỉ in ra màn hình, mọi tính toán gọi sang lớp tiện ích. */
public class BaoCaoCuoiNgay {

    static final Locale VN = Locale.forLanguageTag("vi-VN");

    public static void main(String[] args) {
        Map<String, Double> bangGia = new HashMap<>();
        bangGia.put("SP001", 19_900.0);
        bangGia.put("SP002", 42_000.0);
        bangGia.put("SP003", 6_000.0);
        bangGia.put("SP004", 12_500.0);

        Map<String, String> bangTen = new HashMap<>();
        bangTen.put("SP001", "Cà phê hòa tan G7");
        bangTen.put("SP002", "Bánh quy bơ");
        bangTen.put("SP003", "Nước suối 500ml");
        bangTen.put("SP004", "Trà xanh không đường");

        String[] duLieuThô = {
            "KH001;SP001;3",  "KH002;SP002;1",  "KH001;SP003;10",
            "KH003;SP001;2",  "KH002;SP004;4",  "KH001;SP002;2",
            "KH004;SP999;5",          // mã sản phẩm không có trong bảng giá
            "KH003;SP003;-2",         // số lượng âm
            "KH002;SP001",            // thiếu trường
            "KH004;SP004;ba",         // số lượng không phải số
            "KH003;SP002;3",  "KH001;SP004;1"
        };

        List<String> hopLe = new ArrayList<>();
        List<String> khongHopLe = new ArrayList<>();
        for (String d : duLieuThô) {
            String loi = XuLyBanHang.kiemTraDong(d, bangGia);
            if (loi.isEmpty()) hopLe.add(d);
            else khongHopLe.add(d + "   -> " + loi);
        }

        System.out.println("BÁO CÁO BÁN HÀNG CUỐI NGÀY - CỬA HÀNG MINIMART");
        System.out.println("=".repeat(64));
        System.out.println("a) KIỂM TRA DỮ LIỆU");
        System.out.println("   Tổng số dòng   : " + duLieuThô.length);
        System.out.println("   Dòng hợp lệ    : " + hopLe.size());
        System.out.println("   Dòng bị loại   : " + khongHopLe.size());
        for (String d : khongHopLe) System.out.println("     " + d);

        Map<String, Integer> soLuong = XuLyBanHang.tinhSoLuongTheoSanPham(hopLe);
        Map<String, Double> doanhThu = XuLyBanHang.tinhDoanhThuTheoSanPham(hopLe, bangGia);

        System.out.println();
        System.out.println("b) DOANH THU THEO SẢN PHẨM");
        System.out.printf("   %-6s %-24s %6s %14s%n", "MÃ", "TÊN SẢN PHẨM", "SL", "DOANH THU");
        System.out.println("   " + "-".repeat(54));
        double tong = 0;
        for (String ma : doanhThu.keySet()) {
            System.out.printf(VN, "   %-6s %-24s %6d %,14.0f%n",
                    ma, bangTen.get(ma), soLuong.get(ma), doanhThu.get(ma));
            tong += doanhThu.get(ma);
        }
        System.out.println("   " + "-".repeat(54));
        System.out.printf(VN, "   %-38s %,14.0f%n", "TỔNG DOANH THU:", tong);

        Map<String, Double> chiTieu = XuLyBanHang.tinhChiTieuTheoKhachHang(hopLe, bangGia);
        System.out.println();
        System.out.println("c) KHÁCH HÀNG ĐÃ MUA TRONG NGÀY");
        System.out.println("   Danh sách duy nhất: " + chiTieu.keySet());
        System.out.printf("   %-10s %16s%n", "MÃ KH", "TỔNG CHI TIÊU");
        System.out.println("   " + "-".repeat(27));
        for (Map.Entry<String, Double> m : chiTieu.entrySet())
            System.out.printf(VN, "   %-10s %,16.0f%n", m.getKey(), m.getValue());

        String khachCaoNhat = XuLyBanHang.khachChiTieuCaoNhat(chiTieu);
        String spBanChay    = XuLyBanHang.sanPhamBanChayNhat(soLuong);
        System.out.println();
        System.out.println("d) XẾP HẠNG");
        System.out.printf(VN, "   Khách chi tiêu cao nhất : %s với %,.0f đ%n",
                khachCaoNhat, chiTieu.get(khachCaoNhat));
        System.out.printf("   Sản phẩm bán chạy nhất  : %s - %s với %d sản phẩm%n",
                spBanChay, bangTen.get(spBanChay), soLuong.get(spBanChay));
        System.out.println("=".repeat(64));
    }
}
