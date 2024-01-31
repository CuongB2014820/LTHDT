import java.util.Scanner;

class Date {
    private int ngay;
    private int thang;
    private int nam;

    public Date() {
        // Khởi tạo mặc định ngày là 1, tháng là 1, năm là 2000
        this(1, 1, 2000);
    }

    public Date(int ngay, int thang, int nam) {
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
    }

    public void hienThi() {
        System.out.println("Ngày: " + ngay + "/" + thang + "/" + nam);
    }

    public void nhapNgay() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhập ngày: ");
            ngay = scanner.nextInt();
            System.out.print("Nhập tháng: ");
            thang = scanner.nextInt();
            System.out.print("Nhập năm: ");
            nam = scanner.nextInt();
        } while (!hopLe());
    }

    public boolean hopLe() {
        if (thang < 1 || thang > 12 || ngay < 1) {
            return false;
        }

        int[] soNgayTrongThang = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (thang == 2 && nam % 4 == 0 && (nam % 100 != 0 || nam % 400 == 0)) {
            // Năm nhuận, tháng 2 có 29 ngày
            return ngay <= 29;
        } else {
            return ngay <= soNgayTrongThang[thang];
        }
    }

    public Date ngayHomSau() {
        Date ngaySau = new Date(ngay, thang, nam);
        ngaySau.ngay++;

        if (!ngaySau.hopLe()) {
            ngaySau.ngay = 1;
            ngaySau.thang++;
        }

        if (!ngaySau.hopLe()) {
            ngaySau.thang = 1;
            ngaySau.nam++;
        }

        return ngaySau;
    }

    public Date congNgay(int n) {
        Date ngaySau = new Date(ngay, thang, nam);

        for (int i = 0; i < n; i++) {
            ngaySau = ngaySau.ngayHomSau();
        }

        return ngaySau;
    }
}

public class SDDate {
    public static void main(String[] args) {
        Date ngayTest = new Date();
        ngayTest.nhapNgay();

        System.out.print("Ngày vừa nhập: ");
        ngayTest.hienThi();

        if (ngayTest.hopLe()) {
            Date ngaySau = ngayTest.ngayHomSau();
            System.out.print("Ngày hôm sau: ");
            ngaySau.hienThi();

            int soNgayCongThem = 20;
            Date ngayCongThem = ngayTest.congNgay(soNgayCongThem);
            System.out.print("Ngày cộng thêm " + soNgayCongThem + " ngày: ");
            ngayCongThem.hienThi();
        } else {
            System.out.println("Ngày không hợp lệ.");
        }
    }
}
