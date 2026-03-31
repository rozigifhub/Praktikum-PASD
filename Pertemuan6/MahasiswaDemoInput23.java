import java.util.Scanner;

public class MahasiswaDemoInput23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah mahasiswa: ");
        int n = sc.nextInt();
        sc.nextLine();

        MahasiswaBerprestasiDinamis23 daftar = new MahasiswaBerprestasiDinamis23(n);

        for (int i = 0; i < n; i++) {
            System.out.println("\nData mahasiswa ke-" + (i + 1));
            System.out.print("NIM   : ");
            String nim = sc.nextLine();
            System.out.print("Nama  : ");
            String nama = sc.nextLine();
            System.out.print("Kelas : ");
            String kelas = sc.nextLine();
            System.out.print("IPK   : ");
            double ipk = sc.nextDouble();
            sc.nextLine();

            daftar.tambah(new Mahasiswa23(nim, nama, kelas, ipk));
        }

        System.out.println("\nData mahasiswa (sebelum sorting):");
        daftar.tampil();

        System.out.println("Data mahasiswa (bubble sort, IPK descending):");
        daftar.bubbleSort();
        daftar.tampil();
        sc.close();
    }
}

