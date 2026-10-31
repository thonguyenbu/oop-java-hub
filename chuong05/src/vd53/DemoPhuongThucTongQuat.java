package vd53;

/*
 * Ví dụ 5.3 - Phương thức tổng quát và kiểu có giới hạn
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 5 - Kiểu tổng quát (Generics) và Khung tập hợp Java
 */

import chung.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DemoPhuongThucTongQuat {
    public static void main(String[] args) {
        String[] maKhachHang = {"KH001", "KH002", "KH003"};
        Integer[] soLuong = {3, 1, 10};

        ThongKe.inDanhSach("Danh sách mã khách hàng:", maKhachHang);
        ThongKe.inDanhSach("Danh sách số lượng:", soLuong);

        System.out.println();
        System.out.println("Mã sản phẩm lớn nhất theo thứ tự chữ cái: "
                + ThongKe.lonNhat(List.of("SP001", "SP002", "SP005")));
        System.out.println("Số lượng lớn nhất: " + ThongKe.lonNhat(List.of(soLuong)));

        List<SanPham> danhMuc = new ArrayList<>();
        danhMuc.add(new SanPhamVatLy("SP001", "Cà phê hòa tan G7",
                                     new BigDecimal("65000"), 120));
        danhMuc.add(new SanPhamVatLy("SP002", "Bánh quy bơ",
                                     new BigDecimal("42000"), 85));
        danhMuc.add(new SanPhamSo("SP005", "Phần mềm kế toán",
                                  new BigDecimal("2400000"), 365));

        System.out.println();
        System.out.println("Sản phẩm có mã lớn nhất: "
                + ThongKe.lonNhat(danhMuc).getTenSanPham());
        System.out.println("Tổng đơn giá danh mục: "
                + ThongKe.tongGiaTri(danhMuc).toPlainString());
    }
}
