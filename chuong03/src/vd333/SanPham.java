package vd333;

/*
 * Lớp SanPham phiên bản 4 - đóng gói hoàn chỉnh (Ví dụ 3.9, mục 3.4.2).
 * Sách in "trích phần liên quan". Phần trích được giữ nguyên; các thành phần sau dòng
 * "Phần bổ sung của kho" lấy từ những phần sách đã in: hàm khởi tạo hai tham số
 * (mục 3.2.3), giaTriTonKho() và moTa() (mục 3.2.2), nhapKho() (nhắc tới ở mục 3.4.2,
 * mã như bản hoàn chỉnh ở mục 3.5.3), khai báo public theo nguyên tắc ở mục 3.2.4.
 * Ví dụ 3.7 cần getDonGia(), setDonGia(), getMaSanPham() nên dùng phiên bản này.
 */

public class SanPham {
    private String maSanPham;
    private String tenSanPham;
    private double donGia;
    private int soLuongTon;
    public SanPham(String maSanPham, String tenSanPham,
                   double donGia, int soLuongTon) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        setDonGia(donGia);           // dùng lại quy tắc kiểm tra của setter
        setSoLuongTon(soLuongTon);
    }
    public String getMaSanPham()  { return maSanPham; }
    public String getTenSanPham() { return tenSanPham; }
    public double getDonGia()     { return donGia; }
    public int    getSoLuongTon() { return soLuongTon; }
    public void setTenSanPham(String tenSanPham) {
        if (tenSanPham != null && !tenSanPham.isBlank()) {
            this.tenSanPham = tenSanPham.strip();
        }
    }
    public void setDonGia(double donGia) {
        if (donGia < 0) {
            System.out.println("Từ chối: đơn giá không được âm (" + donGia + ")");
            return;
        }
        this.donGia = donGia;
    }
    public void setSoLuongTon(int soLuongTon) {
        if (soLuongTon < 0) {
            System.out.println("Từ chối: tồn kho không được âm (" + soLuongTon + ")");
            return;
        }
        this.soLuongTon = soLuongTon;
    }
    public boolean xuatKho(int soLuong) {
        if (soLuong <= 0 || soLuong > soLuongTon) {
            return false;
        }
        soLuongTon -= soLuong;
        return true;
    }
    // ----- Phần bổ sung của kho: sách chỉ in phần trích ở trên -----
    public SanPham(String maSanPham, String tenSanPham) {
        this(maSanPham, tenSanPham, 0, 0);
    }
    public double giaTriTonKho() {
        return donGia * soLuongTon;
    }
    public void nhapKho(int soLuong) {
        if (soLuong > 0) soLuongTon += soLuong;
    }
    public String moTa() {
        return maSanPham + " | " + tenSanPham
               + " | đơn giá " + donGia + " | tồn " + soLuongTon;
    }
}
