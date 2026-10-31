/*
 * Mục 2.4.3 - Ví dụ nghiệp vụ: tìm kiếm nhị phân bằng đệ quy trên danh sách mã đã sắp xếp
 *
 * Sách tham khảo: Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)
 * Chương 2 - Cơ bản về ngôn ngữ lập trình Java
 *
 * Biên dịch: javac -encoding UTF-8 -d bin <đường dẫn tệp>
 */
package vd243;

public class TimKiemNhiPhan {

    static int soLanSoSanh = 0;

    /**
     * Tìm ma trong khoảng [dau, cuoi] của mảng đã sắp xếp tăng dần.
     * Trả về chỉ số tìm thấy, hoặc -1 nếu không có.
     */
    static int timKiem(String[] dsMa, String ma, int dau, int cuoi) {
        if (dau > cuoi) {                       // trường hợp cơ sở: khoảng tìm kiếm rỗng
            return -1;
        }
        int giua = (dau + cuoi) / 2;
        soLanSoSanh++;
        int ketQua = ma.compareTo(dsMa[giua]);
        if (ketQua == 0) {
            return giua;
        } else if (ketQua < 0) {
            return timKiem(dsMa, ma, dau, giua - 1);    // gọi lại trên nửa trái
        } else {
            return timKiem(dsMa, ma, giua + 1, cuoi);   // gọi lại trên nửa phải
        }
    }

    public static void main(String[] args) {
        String[] dsMa = {"SP001", "SP003", "SP004", "SP007", "SP010",
                         "SP012", "SP015", "SP018", "SP020", "SP025"};
        for (String ma : new String[]{"SP015", "SP001", "SP011"}) {
            soLanSoSanh = 0;
            int viTri = timKiem(dsMa, ma, 0, dsMa.length - 1);
            System.out.printf("Tìm %s: %s sau %d lần so sánh%n", ma,
                    viTri >= 0 ? "ở vị trí " + viTri : "không có", soLanSoSanh);
        }

        // Danh mục một triệu mã: tìm phần tử cuối cùng
        String[] lon = new String[1_000_000];
        for (int i = 0; i < lon.length; i++) {
            lon[i] = String.format("SP%07d", i);
        }
        soLanSoSanh = 0;
        int viTri = timKiem(lon, "SP0999999", 0, lon.length - 1);
        System.out.printf("Danh mục 1.000.000 mã, tìm SP0999999: vị trí %d sau %d lần so sánh%n",
                viTri, soLanSoSanh);
    }
}
