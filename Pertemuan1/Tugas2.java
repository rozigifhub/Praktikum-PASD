import java.util.Scanner;

public class Tugas2 {
    static final int COL_MK = 0;
    static final int COL_RUANG = 1;
    static final int COL_HARI = 2;
    static final int COL_JAM = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah jadwal (n): ");
        int n = sc.nextInt();
        sc.nextLine(); // buang enter

        String[][] jadwal = new String[n][4];

        inputJadwal(sc, jadwal);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tampilkan semua jadwal");
            System.out.println("2. Cari jadwal berdasarkan hari");
            System.out.println("3. Cari jadwal berdasarkan nama MK");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");

            int pilih = sc.nextInt();
            sc.nextLine();

            if (pilih == 0) break;
            if (pilih == 1) {
                tampilkanSemua(jadwal);
            } else if (pilih == 2) {
                System.out.print("Masukkan hari (contoh Senin): ");
                String hari = sc.nextLine();
                tampilkanByHari(jadwal, hari);
            } else if (pilih == 3) {
                System.out.print("Masukkan nama MK: ");
                String mk = sc.nextLine();
                tampilkanByMK(jadwal, mk);
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }

        sc.close();
    }

    static void inputJadwal(Scanner sc, String[][] jadwal) {
        for (int i = 0; i < jadwal.length; i++) {
            System.out.println("\nInput jadwal ke-" + (i + 1));
            System.out.print("Nama Mata Kuliah: ");
            jadwal[i][COL_MK] = sc.nextLine();

            System.out.print("Ruang: ");
            jadwal[i][COL_RUANG] = sc.nextLine();

            System.out.print("Hari: ");
            jadwal[i][COL_HARI] = sc.nextLine();

            System.out.print("Jam (contoh 08.00-10.00): ");
            jadwal[i][COL_JAM] = sc.nextLine();
        }
    }

    static void tampilkanSemua(String[][] jadwal) {
        System.out.printf("%-3s %-25s %-15s %-10s %-15s%n", "No", "Mata Kuliah", "Ruang", "Hari", "Jam");
        for (int i = 0; i < jadwal.length; i++) {
            System.out.printf("%-3d %-25s %-15s %-10s %-15s%n",
                    (i + 1),
                    jadwal[i][COL_MK],
                    jadwal[i][COL_RUANG],
                    jadwal[i][COL_HARI],
                    jadwal[i][COL_JAM]);
        }
    }

    static void tampilkanByHari(String[][] jadwal, String hari) {
        boolean ketemu = false;
        for (int i = 0; i < jadwal.length; i++) {
            if (jadwal[i][COL_HARI].equalsIgnoreCase(hari.trim())) {
                if (!ketemu) {
                    System.out.println("\nJadwal hari " + hari + ":");
                    System.out.printf("%-3s %-25s %-15s %-10s %-15s%n", "No", "Mata Kuliah", "Ruang", "Hari", "Jam");
                }
                ketemu = true;
                System.out.printf("%-3d %-25s %-15s %-10s %-15s%n",
                        (i + 1),
                        jadwal[i][COL_MK],
                        jadwal[i][COL_RUANG],
                        jadwal[i][COL_HARI],
                        jadwal[i][COL_JAM]);
            }
        }
        if (!ketemu) System.out.println("Tidak ada jadwal untuk hari itu.");
    }

    static void tampilkanByMK(String[][] jadwal, String mk) {
        boolean ketemu = false;
        for (int i = 0; i < jadwal.length; i++) {
            if (jadwal[i][COL_MK].equalsIgnoreCase(mk.trim())) {
                if (!ketemu) {
                    System.out.println("\nJadwal untuk MK " + mk + ":");
                    System.out.printf("%-3s %-25s %-15s %-10s %-15s%n", "No", "Mata Kuliah", "Ruang", "Hari", "Jam");
                }
                ketemu = true;
                System.out.printf("%-3d %-25s %-15s %-10s %-15s%n",
                        (i + 1),
                        jadwal[i][COL_MK],
                        jadwal[i][COL_RUANG],
                        jadwal[i][COL_HARI],
                        jadwal[i][COL_JAM]);
            }
        }
        if (!ketemu) System.out.println("MK tidak ditemukan.");
    }
}
