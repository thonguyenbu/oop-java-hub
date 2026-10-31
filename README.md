# Mã nguồn kèm theo tài liệu tham khảo

**Lập trình hướng đối tượng (Cài đặt bằng ngôn ngữ Java)**
Trường Đại học Ngân hàng Thành phố Hồ Chí Minh — Khoa Hệ thống thông tin quản lý

Kho này chứa toàn bộ mã nguồn của các ví dụ và bài tập in trong tài liệu, kể cả
những bài mà sách chỉ trình bày hướng dẫn giải.

## Yêu cầu môi trường

| Thành phần | Yêu cầu |
|---|---|
| JDK | Java 17 trở lên (tài liệu kiểm tra trên Java 25) |
| Công cụ lập trình | Eclipse IDE for Java Developers |
| Cơ sở dữ liệu | Microsoft SQL Server (chỉ cần cho Chương 6) |
| Trình điều khiển | Microsoft JDBC Driver for SQL Server (chỉ cần cho Chương 6) |

Hai tính năng trong tài liệu cao hơn Java 17 và đều có cách viết thay thế:

- So khớp mẫu cho `switch` cần Java 21. Tính năng này dùng ở mục 4.5.2 và ở lời giải
  Bài 9 Chương 4. Thư mục `chuong04/src` chứa cách viết cho Java 17 (chuỗi `if` dùng
  `instanceof`); thư mục `chuong04/src21` chứa cách viết dùng `switch` so khớp mẫu. Thư mục
  `src21` không nằm trong Build Path mặc định; khi dùng JDK 21 trở lên, có thể thêm nó làm
  thư mục nguồn (chuột phải vào `src21` → Build Path → Use as Source Folder).
- Hai thuộc tính `stdout.encoding` và `stderr.encoding` ở mục 2.2.3 cần Java 19; với phiên
  bản cũ hơn, dùng cách thay thế nêu tại mục đó.

## Cách mở trong Eclipse

1. Chọn **File → Import → General → Existing Projects into Workspace**.
2. Trỏ tới thư mục của chương cần mở, ví dụ `chuong03`.
3. Nhấn **Finish**. Mỗi chương là một dự án độc lập.

Để tiếng Việt hiển thị đúng, vào **Run → Run Configurations → Common → Encoding**
và chọn **UTF-8**.

## Biên dịch và chạy bằng dòng lệnh

```
cd chuong03
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -Dstdout.encoding=UTF-8 -cp out bai13.UngDungMiniMart
```

## Ghi chú về kết quả chạy

Ví dụ trong thân bài được đặt vào gói `vdNNN` để tên lớp giữa các mục không trùng nhau.
Vì vậy, với những chương trình cố ý gây lỗi, vết ngăn xếp in ra có thêm tiền tố tên gói
và số dòng lệch đi so với bản in trong sách (bản in không có dòng `package`).

## Tổ chức thư mục

Mỗi chương là một thư mục riêng. Bên trong `src`, mỗi bài tập hoặc mỗi ví dụ nằm
trong một gói riêng để tên lớp giữa các bài không trùng nhau.

| Tiền tố gói | Ý nghĩa |
|---|---|
| `baiNN` | lời giải bài tập số NN của chương |
| `vdNN` | ví dụ minh họa trong thân bài, NN là số mục |
| `tonghop` | ví dụ tổng hợp cuối chương |
| `chung` | các lớp nghiệp vụ dùng chung cho nhiều bài trong chương |

## Ánh xạ bài tập sang thư mục

### Chương 2 — Cơ bản về ngôn ngữ lập trình Java

| Bài | Vị trí | Ghi chú |
|---|---|---|
| 1–8, 10–13 | `chuong02/src/BaiN.java` | mỗi bài một tệp ở gói mặc định |
| 9 | `chuong02/src/vn/edu/hub/oop/chuong02/` | bài về tổ chức gói, cần cây thư mục đúng tên gói |
| 14 | `chuong02/src/vn/edu/hub/oop/chuong02/BaoCaoCuoiNgay.java` | bài tổng hợp cuối chương |
| Mục 2.2.3 | `chuong02/src/vd223/` | `ChaoMung`, chương trình đầu tiên |
| Mục 2.3 | `chuong02/src/vd23/` | `EpKieu`, `TinhTien` (dùng `BigDecimal`), `DinhDangSo` |
| Mục 2.4.1 | `chuong02/src/vd241/` | `PhanLoaiDon` |
| Mục 2.4.2 | `chuong02/src/vd242/` | `DemoVongFor`: lớp bao để chạy đoạn mã vòng `for` mà sách in rời |
| Mục 2.4.3 | `chuong02/src/vd243/` | `TimKiemNhiPhan`: tìm kiếm nhị phân bằng đệ quy |
| Mục 2.4.4 | `chuong02/src/vd244/` | ba ví dụ của phần xử lý ngoại lệ |
| Mục 2.5.2 | `chuong02/src/vd252/` | `TruyenThamSo` |
| Mục 2.5.3 | `chuong02/src/vd253/` | `TinhTien` có phương thức nạp chồng |
| Mục 2.5.4 (Ví dụ 2.1) | `chuong02/vidu_2_5_4/` | dự án Eclipse riêng, mở bằng Import như một dự án độc lập: hai lớp dùng gói `vn.edu.hub.oop.chuong02` trùng đường dẫn với lời giải Bài 9 |
| Mục 2.6 | `chuong02/src/vd26/` | `SoSanhChuoi`, `TachDongDonHang`, `DinhDangTien`; `DemoStringBuilder` và `DemoKhoiVanBan` là lớp bao cho đoạn mã sách in rời |
| Mục 2.7.1 | `chuong02/src/vd271/` | `MangSanPham` |
| Mục 2.7.2 | `chuong02/src/vd272/` | `GioHang` |
| Mục 2.7.3 | `chuong02/src/vd273/` | `TapHopMa` |
| Mục 2.7.4 | `chuong02/src/vd274/` | `BangGia`, `ThongKeDoanhThu` |

### Chương 3 — Lớp, đối tượng và phương thức

| Bài | Vị trí | Ghi chú |
|---|---|---|
| 1, 2, 3, 4 | `chuong03/src/bai01/` | cùng xây dựng lớp `KhachHang` nên gộp một gói |
| 5–13 | `chuong03/src/baiNN/` | mỗi bài một gói |
| 14 | — | bài viết báo cáo phân tích thiết kế, không có mã nguồn |
| Mục 3.1.1 (Ví dụ 3.1) | `chuong03/src/vd311/` | `SanPham` phiên bản đầu tiên |
| Mục 3.1.2 (Ví dụ 3.2, 3.3) | `chuong03/src/vd312/` | `DemoTaoDoiTuong`, `DemoThamChieu`, kèm bản sao `SanPham` của Ví dụ 3.1 vì thuộc tính ở mức mặc định chỉ dùng được trong cùng gói |
| Mục 3.2.2 (Ví dụ 3.4) | `chuong03/src/vd322/` | `SanPham` phiên bản 2, `DemoPhuongThuc` |
| Mục 3.2.3 (Ví dụ 3.5) | `chuong03/src/vd323/` | `SanPham` phiên bản 3, `DemoHamKhoiTao` |
| Mục 3.2.4 (Ví dụ 3.6) | `chuong03/vidu_3_2_4/` | dự án Eclipse riêng: `ManHinh.java` cố ý không biên dịch được để quan sát lỗi truy cập thuộc tính mức mặc định từ gói khác |
| Mục 3.3.3 (Ví dụ 3.7) | `chuong03/src/vd333/` | `DemoTruyenDoiTuong`: lớp bao cho đoạn mã sách in rời; dùng `SanPham` phiên bản 4 |
| Mục 3.3.4 (Ví dụ 3.8) | `chuong03/src/vd334/` | `DanhMucSanPham`; `LoiMangDoiTuong` cố ý dừng vì `NullPointerException`; `SanPham` ghép theo lời dẫn của sách |
| Mục 3.4.2 (Ví dụ 3.9) | `chuong03/src/vd342/` | `SanPham` phiên bản 4 (phần trích trong sách cộng các thành phần đã in ở mục trước), `DemoGetterSetter` |
| Mục 3.4.3 (Ví dụ 3.10) | `chuong03/src/vd343/` | `SanPham` phiên bản 4 thêm hai phương thức `thanhTien`; `DemoNapChong` là lớp bao cho lời gọi sách in rời |
| Mục 3.4.4 (Ví dụ 3.11) | `chuong03/src/vd344/` | `KhachHang`, `DemoThis` |
| Mục 3.5.3 (Ví dụ 3.12) | `chuong03/src/vd353/` | `TaiKhoan`, `DemoStatic` |
| Ví dụ tổng hợp cuối chương | `chuong03/src/vdtonghop/` | lớp `ThongKeDoanhThu` |

### Chương 4 — Tính trừu tượng, đóng gói, kế thừa và đa hình

| Bài | Vị trí | Ghi chú |
|---|---|---|
| 1, 2, 4–10 | `chuong04/src/baiNN/` | mỗi bài một gói; Bài 9 viết cho Java 17 |
| 9 (Java 21) | `chuong04/src21/bai09/` | cách viết dùng `switch` so khớp mẫu |
| 3 | — | bài phân tích đoạn mã cho sẵn, không có mã nguồn riêng |
| Ví dụ thân bài | `chuong04/src/vd4N/` | theo số mục; `src21/vd45` là cách viết Java 21 của mục 4.5.2 |
| Ví dụ tổng hợp | `chuong04/src/tonghop/` | ứng dụng bán hàng |

### Chương 5 — Kiểu tổng quát và Khung tập hợp Java

| Bài | Vị trí | Ghi chú |
|---|---|---|
| 1, 2, 3, 5–10 | `chuong05/src/baiNN/` | mỗi bài một gói |
| 4 | — | bài phân tích, không có mã nguồn riêng |
| Lớp dùng chung | `chuong05/src/chung/` | `SanPham`, `KhachHang`, `DonHang`, `Cap`, các bộ so sánh |
| Ví dụ thân bài | `chuong05/src/vd5N/` | theo số mục |
| Ví dụ tổng hợp 5.7 | `chuong05/src/tonghop/` | báo cáo bán hàng |

### Chương 6 — Xây dựng ứng dụng hướng đối tượng

| Nội dung | Vị trí |
|---|---|
| Kịch bản tạo cơ sở dữ liệu | `chuong06/sql/` |
| Ví dụ JDBC | `chuong06/src/jdbc/` |
| Ứng dụng ba lớp | `chuong06/src/balop/` |
| Vi dịch vụ | `chuong06/src/vidichvu/` |
| Tiêm phụ thuộc | `chuong06/src/tiemphuthuoc/` |
| Hàng đợi thông điệp | `chuong06/src/hangdoi/` |
| Gọi phương thức từ xa | `chuong06/src/rmi/` |
| Bài 7 — ứng dụng quản lý bán hàng | `chuong06/src/bai07/` |
| Các bài còn lại | bài phân tích kiến trúc, không có mã nguồn |

## Ghi chú về Chương 6

Các chương trình JDBC cần một cơ sở dữ liệu SQL Server đang chạy và tệp
`mssql-jdbc-*.jar` trong Build Path của dự án. Hãy chạy kịch bản trong thư mục
`chuong06/sql` trước, rồi sửa chuỗi kết nối trong lớp cấu hình cho khớp với máy
của mình.

## Giấy phép

Mã nguồn được cung cấp cho mục đích học tập cùng tài liệu tham khảo nói trên.
