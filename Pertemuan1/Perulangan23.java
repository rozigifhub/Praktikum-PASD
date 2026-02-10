import java.util.Scanner;

public class Perulangan23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan NIM: ");
        String nim = sc.nextLine().trim();

        int n = ambil2DigitTerakhir(nim);
        if (n < 10) n += 10;

        for (int i = 1; i <= n; i++) {
            if (i == 10 || i == 15) continue;

            if (i % 3 == 0) {
                System.out.print("# ");
            } else if (i % 2 == 0) {
                System.out.print(i + " ");
            } else {
                System.out.print("* ");
            }
        }

        sc.close();
    }

    static int ambil2DigitTerakhir(String nim) {
        if (nim.length() < 2) return Integer.parseInt(nim); // kalau cuma 1 digit
        String last2 = nim.substring(nim.length() - 2);
        return Integer.parseInt(last2);
    }
}
