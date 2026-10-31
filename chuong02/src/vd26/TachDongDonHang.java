package vd26;

public class TachDongDonHang {
    public static void main(String[] args) {
        String dong = "SP001;Cà phê hòa tan;19900;3";
        String[] truong = dong.split(";");
        String maSP = truong[0];
        String tenSP = truong[1];
        double donGia = Double.parseDouble(truong[2]);
        int soLuong = Integer.parseInt(truong[3]);
        System.out.printf("Mã: %s | Tên: %s | Đơn giá: %.0f | SL: %d | Thành tiền: %.0f%n",
                          maSP, tenSP, donGia, soLuong, donGia * soLuong);
        System.out.println("Ghép lại: " + String.join(" | ", truong));
    }
}
