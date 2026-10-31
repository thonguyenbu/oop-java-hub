package tiemphuthuoc;

/*
 * Mục 6.10.1 - Tiêm phụ thuộc: kiểm thử tầng nghiệp vụ không cần CSDL
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 6 - Xây dựng ứng dụng hướng đối tượng
 */

import chung.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SanPhamService {

    private final KhoDuLieu<SanPham, String> kho;   // do bên ngoài cung cấp

    public SanPhamService(KhoDuLieu<SanPham, String> kho) {
        this.kho = kho;
    }

    public void themSanPham(SanPham sp) throws SQLException {
        if (sp.getDonGia().signum() < 0)
            throw new IllegalArgumentException("Đơn giá không được âm.");
        if (kho.timTheoKhoa(sp.getMaSanPham()) != null)
            throw new IllegalArgumentException(
                    "Mã " + sp.getMaSanPham() + " đã tồn tại.");
        kho.them(sp);
    }

    public List<SanPham> laySapXepTheoGiaGiamDan() throws SQLException {
        List<SanPham> ds = new ArrayList<>(kho.layTatCa());
        ds.sort(Collections.reverseOrder(Comparator.comparing(SanPham::getDonGia)));
        return ds;
    }

    public BigDecimal tongGiaTriTonKho() throws SQLException {
        BigDecimal tong = BigDecimal.ZERO;
        for (SanPham sp : kho.layTatCa())
            tong = tong.add(sp.getDonGia()
                    .multiply(BigDecimal.valueOf(sp.getSoLuongTon())));
        return tong;
    }
}
