import java.util.Scanner;
public class FaktorialMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan  n: ");
        int input = sc.nextInt();

        Faktorial fk = new Faktorial();
        System.out.println("Nilai Faktorial: " + input + "Menggunakan BF: " + fk.FaktorialBF(input));
        System.out.println("Nilai Faktorial: " + input + "Menggunakan DC: " + fk.FaktorialDC(input));
        System.out.println("Yang pake while: " + fk.FaktorialBFWhile(input));
        sc.close();
    }   
}
