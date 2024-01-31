import java.util.Scanner;

class Diem {
    private int x;
    private int y;

    public Diem() {
        this.x = 0;
        this.y = 0;
    }

    public Diem(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void nhapDiem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập giá trị x: ");
        this.x = scanner.nextInt();
        System.out.print("Nhập giá trị y: ");
        this.y = scanner.nextInt();
    }

    public void hienThi() {
        System.out.println("Tọa độ điểm: (" + this.x + "," + this.y + ")");
    }

    public void doiDiem(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public int giaTriX() {
        return this.x;
    }

    public int giaTriY() {
        return this.y;
    }

    public float khoangCach() {
        return (float) Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public float khoangCachToiDiem(Diem d) {
        return (float) Math.sqrt(Math.pow(this.x - d.giaTriX(), 2) + Math.pow(this.y - d.giaTriY(), 2));
    }
}

public class SDDiem {
    public static void main(String[] args) {
        // Tạo điểm A tọa độ (3,4)
        Diem A = new Diem(3, 4);
        A.hienThi();

        // Tạo điểm B từ người dùng
        Diem B = new Diem();
        B.nhapDiem();
        B.hienThi();

        // Tạo điểm C đối xứng với B qua gốc tọa độ
        Diem C = new Diem(-B.giaTriX(), -B.giaTriY());
        C.hienThi();

        // Hiển thị khoảng cách từ B đến tâm O
        float khoangCach_B_to_O = B.khoangCach();
        System.out.println("Khoảng cách từ điểm B đến tâm O: " + khoangCach_B_to_O);

        // Hiển thị khoảng cách từ A đến B
        float khoangCach_A_to_B = A.khoangCachToiDiem(B);
        System.out.println("Khoảng cách từ điểm A đến B: " + khoangCach_A_to_B);
    }
}
