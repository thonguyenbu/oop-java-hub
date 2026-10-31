package vd244;

public class NgoaiLeCoBan {
    public static void main(String[] args) {
        String[] duLieu = {"12", "mười", "7"};
        int tong = 0;
        for (String o : duLieu) {
            try {
                int sl = Integer.parseInt(o);
                tong += sl;
                System.out.println("Đã cộng: " + sl);
            } catch (NumberFormatException e) {
                System.out.println("Bỏ qua ô không phải số: \"" + o + "\"");
            } finally {
                System.out.println("  -> đã xử lý xong một ô");
            }
        }
        System.out.println("Tổng số lượng hợp lệ: " + tong);
    }
}
