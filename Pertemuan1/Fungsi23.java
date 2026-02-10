public class Fungsi23 {
    static String[] namaCabang = {"RoyalGarden 1", "RoyalGarden 2", "RoyalGarden 3", "RoyalGarden 4"};
    static String[] namaBunga  = {"Aglonema", "Keladi", "Alocasia", "Mawar"};

    // baris = cabang, kolom = jumlah bunga
    static int[][] stok = {
            {10, 5, 15, 7},
            {6, 11, 9, 12},
            {2, 10, 10, 5},
            {5, 7, 12, 9}
    };

    // harga sesuai soal: Aglonema=75000, Keladi=50000, Alocasia=60000, Mawar=10000
    static int[] harga = {75000, 50000, 60000, 10000};

    public static void main(String[] args) {
        tampilkanPendapatanSemuaCabang();
        System.out.println();
        tampilkanStatusSemuaCabang();
    }

    static int hitungPendapatanCabang(int idxCabang) {
        int total = 0;
        for (int j = 0; j < stok[idxCabang].length; j++) {
            total += stok[idxCabang][j] * harga[j];
        }
        return total;
    }

    static void tampilkanPendapatanSemuaCabang() {
        System.out.println("Pendapatan tiap cabang (jika semua habis terjual):");
        for (int i = 0; i < namaCabang.length; i++) {
            int pendapatan = hitungPendapatanCabang(i);
            System.out.printf("%-15s = Rp%,d%n", namaCabang[i], pendapatan);
        }
    }

    static void tampilkanStatusSemuaCabang() {
        System.out.println("Status tiap cabang:");
        for (int i = 0; i < namaCabang.length; i++) {
            int pendapatan = hitungPendapatanCabang(i);
            String status = (pendapatan > 1_500_000) ? "Sangat Baik" : "Perlu Evaluasi";
            System.out.printf("%-15s = %s%n", namaCabang[i], status);
        }
    }
}
