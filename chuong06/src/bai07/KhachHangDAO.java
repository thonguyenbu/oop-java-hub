package bai07;

/*
 * Bài 7 - Ứng dụng quản lý bán hàng hoàn chỉnh
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 6 - Xây dựng ứng dụng hướng đối tượng
 */

import chung.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class KhachHangDAO implements KhoDuLieu<KhachHang, String> {
    private final Connection cn;
    public KhachHangDAO(Connection cn) { this.cn = cn; }
 
    private KhachHang docMotDong(ResultSet rs) throws SQLException {
        return new KhachHang(rs.getString("MaKhachHang"),
                             rs.getString("HoTen"),
                             rs.getString("HangThanhVien"));
    }
 
    @Override public void them(KhachHang kh) throws SQLException {
        String sql = "INSERT INTO KhachHang (MaKhachHang, HoTen, HangThanhVien) "
                   + "VALUES (?,?,?)";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, kh.getMaKhachHang());
            ps.setString(2, kh.getHoTen());
            ps.setString(3, kh.getHangThanhVien());
            ps.executeUpdate();
        }
    }
 
    @Override public KhachHang timTheoKhoa(String ma) throws SQLException {
        String sql = "SELECT MaKhachHang, HoTen, HangThanhVien "
                   + "FROM KhachHang WHERE MaKhachHang = ?";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, ma);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? docMotDong(rs) : null;
            }
        }
    }
 
    // Ba phương thức dưới đây viết theo đúng khuôn mẫu của SanPhamDAO
    @Override public boolean capNhat(KhachHang kh) throws SQLException {
        String sql = "UPDATE KhachHang SET HoTen = ?, HangThanhVien = ? "
                   + "WHERE MaKhachHang = ?";
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, kh.getHoTen());
            ps.setString(2, kh.getHangThanhVien());
            ps.setString(3, kh.getMaKhachHang());
            return ps.executeUpdate() > 0;
        }
    }

    @Override public boolean xoaTheoKhoa(String ma) throws SQLException {
        try (PreparedStatement ps = cn.prepareStatement(
                "DELETE FROM KhachHang WHERE MaKhachHang = ?")) {
            ps.setString(1, ma);
            return ps.executeUpdate() > 0;
        }
    }

    @Override public List<KhachHang> layTatCa() throws SQLException {
        String sql = "SELECT MaKhachHang, HoTen, HangThanhVien "
                   + "FROM KhachHang ORDER BY MaKhachHang";
        List<KhachHang> ds = new ArrayList<>();
        try (PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) ds.add(docMotDong(rs));
        }
        return ds;
    }

    @Override public int soLuong() throws SQLException {
        try (PreparedStatement ps = cn.prepareStatement(
                 "SELECT COUNT(*) FROM KhachHang");
             ResultSet rs = ps.executeQuery()) {
            rs.next();
            return rs.getInt(1);
        }
    }
}
