package balop;

/*
 * Mục 6.8 - Ứng dụng quản lý sản phẩm theo mô hình ba lớp
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 6 - Xây dựng ứng dụng hướng đối tượng
 */

import chung.*;
import jdbc.SanPhamDAO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SanPhamService {
 
    private final SanPhamDAO dao;
 
    public SanPhamService(Connection cn) { this.dao = new SanPhamDAO(cn); }
 
    public void themSanPham(SanPham sp) throws SQLException {
        if (sp.getMaSanPham() == null || sp.getMaSanPham().isBlank())
            throw new IllegalArgumentException("Mã sản phẩm không được rỗng.");
        if (sp.getDonGia().signum() < 0)
            throw new IllegalArgumentException("Đơn giá không được âm.");
        if (dao.timTheoKhoa(sp.getMaSanPham()) != null)
            throw new IllegalArgumentException("Mã " + sp.getMaSanPham()
                    + " đã tồn tại.");
        dao.them(sp);
    }
 
    public List<SanPham> laySapXepTheoMa() throws SQLException {
        return dao.layTatCa();               // DAO đã ORDER BY MaSanPham
    }

    public List<SanPham> laySapXepTheoGiaGiamDan() throws SQLException {
        List<SanPham> ds = new ArrayList<>(dao.layTatCa());
        ds.sort(Collections.reverseOrder(
                Comparator.comparing(SanPham::getDonGia)));
        return ds;
    }
 
    public List<SanPham> layCanDatHang(int nguong) throws SQLException {
        List<SanPham> ds = new ArrayList<>();
        for (SanPham sp : dao.layTatCa())
            if (sp.getSoLuongTon() < nguong) ds.add(sp);
        return ds;
    }
 
    public BigDecimal tongGiaTriTonKho() throws SQLException {
        BigDecimal tong = BigDecimal.ZERO;
        for (SanPham sp : dao.layTatCa())
            tong = tong.add(sp.getDonGia()
                    .multiply(BigDecimal.valueOf(sp.getSoLuongTon())));
        return tong;
    }
}
