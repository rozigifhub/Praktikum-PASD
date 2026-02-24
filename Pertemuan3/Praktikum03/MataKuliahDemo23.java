import java.util.Scanner;

public class MataKuliahDemo23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String kode, nama, dummy;
        int sks, jumlahJam, jmlMK;

        System.out.print("Masukkan jumlah matakuliah: ");
        dummy = sc.nextLine();
        jmlMK = Integer.parseInt(dummy);

        Matakuliah23[] arrayOfMatakuliah = new Matakuliah23[jmlMK];

        for (int i = 0; i < jmlMK; i++) {
            System.out.println("Masukkan Data Matakuliah ke-" + (i + 1));
            System.out.print("Kode      : ");
            kode = sc.nextLine();
            System.out.print("Nama      : ");
            nama = sc.nextLine();
            System.out.print("SKS       : ");
            dummy = sc.nextLine();
            sks = Integer.parseInt(dummy);
            System.out.print("Jumlah Jam: ");
            dummy = sc.nextLine();
            jumlahJam = Integer.parseInt(dummy);
            System.out.println("--------------------------------");

            arrayOfMatakuliah[i] = new Matakuliah23();
            arrayOfMatakuliah[i].tambahData(kode, nama, sks, jumlahJam);
        }

        for (int i = 0; i < jmlMK; i++) {
            System.out.println("Data Matakuliah ke-" + (i + 1));
            arrayOfMatakuliah[i].cetakInfo();
        }


        sc.close();
    }
}
