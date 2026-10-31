package bai08;

/*
 * Bài 8 - Lớp tiện ích chỉ gồm phương thức tĩnh
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 3 - Lớp, đối tượng và phương thức
 */

/**
 * Lớp tiện ích chỉ gồm phương thức tĩnh.
 *
 * VÌ SAO CÁC PHƯƠNG THỨC Ở ĐÂY LÀ static CÒN CỦA SanPham THÌ KHÔNG:
 * Một phương thức nên là phương thức thể hiện khi nó cần dữ liệu của MỘT
 * đối tượng cụ thể. Phương thức giaTriTonKho() của SanPham cần đơn giá và
 * tồn kho của chính sản phẩm đó, nên phải gắn với đối tượng.
 * Ngược lại, các phép tính ở đây thao tác trên MỘT MẢNG sản phẩm chứ không
 * thuộc về sản phẩm nào cả; chúng nhận toàn bộ dữ liệu cần thiết qua tham số
 * và không giữ trạng thái nào. Vì vậy chúng là phương thức tĩnh, và lớp này
 * không cần và cũng không nên tạo đối tượng.
 */
public class ThongKeKho {

    private ThongKeKho() { }   // ngăn tạo đối tượng của lớp tiện ích

    public static double tongGiaTriTonKho(SanPham[] ds) {
        double tong = 0;
        for (SanPham sp : ds) if (sp != null) tong += sp.giaTriTonKho();
        return tong;
    }

    public static SanPham tonKhoThapNhat(SanPham[] ds) {
        if (ds == null || ds.length == 0) return null;
        SanPham thapNhat = null;
        for (SanPham sp : ds) {
            if (sp == null) continue;
            if (thapNhat == null || sp.getSoLuongTon() < thapNhat.getSoLuongTon())
                thapNhat = sp;
        }
        return thapNhat;
    }

    public static SanPham[] duoiNguong(SanPham[] ds, int nguong) {
        int dem = 0;
        for (SanPham sp : ds) if (sp != null && sp.getSoLuongTon() < nguong) dem++;
        SanPham[] kq = new SanPham[dem];
        int i = 0;
        for (SanPham sp : ds) if (sp != null && sp.getSoLuongTon() < nguong) kq[i++] = sp;
        return kq;
    }
}
