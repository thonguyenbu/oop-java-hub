package bai07;

/*
 * Bài 7 - Ứng dụng quản lý bán hàng hoàn chỉnh
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 6 - Xây dựng ứng dụng hướng đối tượng
 */

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

public class BaoCaoDAO {
    private final Connection cn;
    public BaoCaoDAO(Connection cn) { this.cn = cn; }
 
    /** Lịch sử đơn hàng của một khách hàng. */
    public List<String> lichSuDonHang(String maKhachHang) throws SQLException {
        String sql = "SELECT SoDon, NgayDat, TongTien FROM DonHang "
                   + "WHERE MaKhachHang = ? ORDER BY SoDon";
        List<String> ds = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, maKhachHang);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next())
                    ds.add(String.format("DH%04d   %s   %14s",
                            rs.getInt("SoDon"), rs.getDate("NgayDat"),
                            rs.getBigDecimal("TongTien").toPlainString()));
            }
        }
        return ds;
    }
 
    /** Doanh thu theo từng sản phẩm, sắp giảm dần. */
    public LinkedHashMap<String, BigDecimal> doanhThuTheoSanPham() throws SQLException {
        String sql = "SELECT ct.MaSanPham, sp.TenSanPham, "
                   + "SUM(ct.SoLuong) AS TongSoLuong, "
                   + "SUM(ct.SoLuong * ct.DonGiaBan) AS DoanhThu "
                   + "FROM ChiTietDonHang ct "
                   + "JOIN SanPham sp ON ct.MaSanPham = sp.MaSanPham "
                   + "GROUP BY ct.MaSanPham, sp.TenSanPham "
                   + "ORDER BY SUM(ct.SoLuong * ct.DonGiaBan) DESC";
        LinkedHashMap<String, BigDecimal> kq = new LinkedHashMap<>();
        try (PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next())
                kq.put(String.format("%-6s %-24s %4d",
                        rs.getString("MaSanPham"), rs.getString("TenSanPham"),
                        rs.getInt("TongSoLuong")), rs.getBigDecimal("DoanhThu"));
        }
        return kq;
    }
}
