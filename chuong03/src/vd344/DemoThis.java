package vd344;

public class DemoThis {
    public static void main(String[] args) {
        KhachHang kh = new KhachHang("Nguyễn Văn An", "VANG");
        System.out.println("Ban đầu: " + kh.getHoTen());
        kh.datTenSai("Trần Thị Bình");
        System.out.println("Sau datTenSai : " + kh.getHoTen());
        kh.datTenDung("Trần Thị Bình");
        System.out.println("Sau datTenDung: " + kh.getHoTen());
        KhachHang kh2 = new KhachHang("Lê Văn Cường");
        System.out.println();
        System.out.println(kh2.getHoTen() + " - hạng " + kh2.getHangThanhVien());
        System.out.println("Hai khách cùng hạng? " + kh.cungHangVoi(kh2));
    }
}
