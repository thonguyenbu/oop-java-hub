package bai09;

/*
 * Bài 9 - Giao diện sealed TrangThaiDon và switch không cần default
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public final class DaHuy implements TrangThaiDon {
    private final String lyDo;
    public DaHuy(String lyDo) { this.lyDo = lyDo; }
    public String getLyDo() { return lyDo; }
}
