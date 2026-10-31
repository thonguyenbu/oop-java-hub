package bai04;

/*
 * Bài 4 - Giao diện CoTinhThue với phương thức default
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 4 - Tính trừu tượng, đóng gói, kế thừa và đa hình
 */

public interface CoTinhThue {
    double THUE_SUAT_VAT = 0.08;
 
    double giaTruocThue();
 
    default double tienThue()   { return giaTruocThue() * THUE_SUAT_VAT; }
    default double giaSauThue() { return giaTruocThue() + tienThue(); }
}
