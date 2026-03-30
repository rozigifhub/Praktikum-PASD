import java.util.Scanner;
public class SumMain23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Masukkan jumlah elemen: ");
        int elemen = sc.nextInt();
        
        Sum23 sm = new Sum23(elemen);
        for(int i= 0; i < elemen; i++){
            System.out.println("Masukkan elemen ke-"+(i + 1)+": ");
            sm.keuntungan[i] = sc.nextDouble();
        }

        System.out.println("Total keuntungan menggunakan BF: "+ sm.totalBF());
        System.out.println("Total keuntungan menggunakan DC: "+ sm.totalDC(sm.keuntungan, 0, elemen-1));
        sc.close();
    }
}
