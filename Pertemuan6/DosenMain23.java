import java.util.Scanner;

public class DosenMain23 {
    static boolean inputJenisKelamin(Scanner sc) {
        while (true) {
            System.out.print("Jenis kelamin (L/P): ");
            String jk = sc.nextLine().trim().toUpperCase();
            if (jk.equals("L")) {
                return true;
            }
            if (jk.equals("P")) {
                return false;
            }
            System.out.println("Input tidak valid. Masukkan L atau P.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataDosen23 list = new DataDosen23();

        while (true) {
            System.out.println("\n=== MENU DATA DOSEN ===");
            System.out.println("1. Tambah data dosen");
            System.out.println("2. Tampil data dosen");
            System.out.println("3. Sorting ASC (usia termuda -> tertua, bubble sort)");
            System.out.println("4. Sorting DSC (usia tertua -> termuda, selection sort)");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            int pilih;
            if (sc.hasNextInt()) {
                pilih = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Input menu harus angka.");
                sc.nextLine();
                continue;
            }

            if (pilih == 0) {
                break;
            }

            switch (pilih) {
                case 1:
                    System.out.print("Kode: ");
                    String kode = sc.nextLine();
                    System.out.print("Nama: ");
                    String nama = sc.nextLine();
                    boolean jk = inputJenisKelamin(sc);
                    System.out.print("Usia: ");
                    int usia = sc.nextInt();
                    sc.nextLine();
                    list.tambah(new Dosen23(kode, nama, jk, usia));
                    break;
                case 2:
                    list.tampil();
                    break;
                case 3:
                    list.sortingASC();
                    System.out.println("Data berhasil diurutkan ASC.");
                    list.tampil();
                    break;
                case 4:
                    list.sortingDSC();
                    System.out.println("Data berhasil diurutkan DSC.");
                    list.tampil();
                    break;
                default:
                    System.out.println("Menu tidak tersedia.");
                    break;
            }
        }
    }
}
