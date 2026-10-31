package vd344;

public class KhachHang {
    private String hoTen;
    private String hangThanhVien;
    // SAI: tham số che khuất thuộc tính, phép gán không có tác dụng
    public void datTenSai(String hoTen) {
        hoTen = hoTen;
    }
    // ĐÚNG: this.hoTen là thuộc tính, hoTen là tham số
    public void datTenDung(String hoTen) {
        this.hoTen = hoTen;
    }
    public KhachHang(String hoTen, String hangThanhVien) {
        this.hoTen = hoTen;
        this.hangThanhVien = hangThanhVien;
    }
    public KhachHang(String hoTen) {
        this(hoTen, "DONG");          // gọi hàm khởi tạo còn lại
    }
    public String getHoTen()         { return hoTen; }
    public String getHangThanhVien() { return hangThanhVien; }
    public boolean cungHangVoi(KhachHang khac) {
        return this.hangThanhVien.equals(khac.hangThanhVien);
    }
}
