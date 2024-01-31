import java.util.Scanner;

class PhanSo {
    private int tu;
    private int mau;

    public PhanSo() {
        this.tu = 0;
        this.mau = 1;
    }

    public PhanSo(int tu, int mau) {
        this.tu = tu;
        this.mau = (mau != 0) ? mau : 1;
    }

    public void nhapPhanSo() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhập tử số: ");
            tu = scanner.nextInt();
            System.out.print("Nhập mẫu số: ");
            mau = scanner.nextInt();
        } while (mau == 0);
    }

    public void hienThi() {
        if (tu == 0) {
            System.out.println("0");
        } else if (mau == 1) {
            System.out.println(tu);
        } else {
            System.out.println(tu + "/" + mau);
        }
    }

    public void nghichDao() {
        if (tu != 0) {
            int temp = tu;
            tu = mau;
            mau = temp;
        }
    }

    public PhanSo giaTriNghichDao() {
        return new PhanSo(mau, tu);
    }

    public double giaTriThuc() {
        return (double) tu / mau;
    }

    public boolean lonHon(PhanSo a) {
        return (tu * a.mau) > (a.tu * mau);
    }

    public PhanSo cong(PhanSo a) {
        int tuMoi = tu * a.mau + a.tu * mau;
        int mauMoi = mau * a.mau;
        return new PhanSo(tuMoi, mauMoi);
    }

    public PhanSo tru(PhanSo a) {
        int tuMoi = tu * a.mau - a.tu * mau;
        int mauMoi = mau * a.mau;
        return new PhanSo(tuMoi, mauMoi);
    }

    public PhanSo nhan(PhanSo a) {
        int tuMoi = tu * a.tu;
        int mauMoi = mau * a.mau;
        return new PhanSo(tuMoi, mauMoi);
    }

    public PhanSo chia(PhanSo a) {
        if (a.tu == 0) {
            System.out.println("Phép chia không hợp lệ.");
            return null;
        }

        int tuMoi = tu * a.mau;
        int mauMoi = mau * a.tu;
        return new PhanSo(tuMoi, mauMoi);
    }
}

public class SDPhanSo {
    public static void main(String[] args) {
        // Tạo phân số a = 3/7, b = 4/9
        PhanSo a = new PhanSo(3, 7);
        PhanSo b = new PhanSo(4, 9);

        System.out.print("Phân số a: ");
        a.hienThi();
        System.out.print("Phân số b: ");
        b.hienThi();

        // Tạo 2 phân số x và y. Nhập giá trị cho x và y từ bàn phím.
        PhanSo x = new PhanSo();
        PhanSo y = new PhanSo();

        System.out.println("Nhập giá trị cho phân số x:");
        x.nhapPhanSo();
        System.out.println("Nhập giá trị cho phân số y:");
        y.nhapPhanSo();

        // Hiển thị giá trị nghịch đảo của phân số x ra màn hình (không làm thay đổi giá trị của x).
        PhanSo nghichDaoX = x.giaTriNghichDao();
        System.out.print("Giá trị nghịch đảo của phân số x: ");
        nghichDaoX.hienThi();

        // Tính tổng của x + y và in kết quả ra màn hình.
        PhanSo tongXY = x.cong(y);
        System.out.print("Tổng của x + y: ");
        tongXY.hienThi();

        // Nhập vào 1 danh sách gồm n phân số (n: nhập từ bàn phím).
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phân số: ");
        int n = scanner.nextInt();
        PhanSo[] danhSachPhanSo = new PhanSo[n];

        for (int i = 0; i < n; i++) {
            danhSachPhanSo[i] = new PhanSo();
            System.out.println("Nhập giá trị cho phân số thứ " + (i + 1) + ":");
            danhSachPhanSo[i].nhapPhanSo();
        }

        // Tính tổng n phân số đó.
        PhanSo tongDanhSach = new PhanSo();
        for (int i = 0; i < n; i++) {
            tongDanhSach = tongDanhSach.cong(danhSachPhanSo[i]);
        }

        System.out.print("Tổng của danh sách phân số: ");
        tongDanhSach.hienThi();

        // Tìm phân số lớn nhất trong danh sách phân số.
        PhanSo maxPhanSo = danhSachPhanSo[0];
        for (int i = 1; i < n; i++) {
            if (danhSachPhanSo[i].lonHon(maxPhanSo)) {
                maxPhanSo = danhSachPhanSo[i];
            }
        }

        System.out.print("Phân số lớn nhất trong danh sách: ");
        maxPhanSo.hienThi();

        // Sắp xếp danh sách phân số theo thứ tự tăng dần.
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if
