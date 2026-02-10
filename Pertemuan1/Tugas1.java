import java.util.Scanner;
public class Tugas1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] kode = new char[10];
        char[][] kota = {
            {'B','A','N','T','E','N'},
            {'J','A','K','A','R','T','A'},
            {'B','A','N','D','U','N','G'},
            {'C','I','R','E','B','O','N'},
            {'B','O','G','O','R'},
            {'P','E','K','A','L','O','N','G','A','N'},
            {'S','E','M','A','R','A','N','G'},
            {'S','U','R','A','B','A','Y','A'},
            {'M','A','L','A','N','G'},
            {'T','E','G','A','L'}
        };
        
        System.out.print("Masukkan kode plat (A/B/D/E/F/H/L/N/T): ");
        String in = sc.nextLine().trim().toUpperCase();

        if (in.length() != 1) {
            System.out.println("Kode harus 1 huruf.");
            sc.close();
            return;
        }

        char inputKode = in.charAt(0);

        int idx = -1;
        for (int i = 0; i < kode.length; i++) {
            if (kode[i] == inputKode) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            System.out.println("Kode tidak ditemukan.");
        } else {
            System.out.print("Nama kota: ");
            for (int j = 0; j < kota[idx].length; j++) {
                System.out.print(kota[idx][j]);
            }
            System.out.println();
        }

        sc.close();
    }
}