package vd42;

/*
 * Ví dụ 4.2 - Phân cấp ConNguoi và thứ tự chạy hàm khởi tạo
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public class ConNguoi {
    protected String hoTen;
    protected String soDienThoai;
    private String diaChi;
 
    public ConNguoi(String hoTen, String soDienThoai, String diaChi) {
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        System.out.println("  -> Hàm khởi tạo ConNguoi chạy");
    }
 
    public String getHoTen()  { return hoTen; }
    public String getDiaChi() { return diaChi; }
 
    public String thongTinLienHe() {
        return hoTen + " | " + soDienThoai + " | " + diaChi;
    }
}
