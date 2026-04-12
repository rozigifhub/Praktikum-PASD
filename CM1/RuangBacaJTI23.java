package CM1;

import java.util.Arrays;

public class RuangBacaJTI23 {
    Mahasiswa23[] daftarMahasiswa;
    Buku23[] daftarBuku;
    Peminjaman23[] daftarPeminjaman;

    public RuangBacaJTI23() {
        initDataAwal();
    }

    void initDataAwal() {
        daftarMahasiswa = new Mahasiswa23[] {
                new Mahasiswa23("22001", "Andi", "Teknik Informatika"),
                new Mahasiswa23("22002", "Budi", "Teknik Informatika"),
                new Mahasiswa23("22003", "Citra", "Sistem Informasi Bisnis")
        };

        daftarBuku = new Buku23[] {
                new Buku23("B001", "Algoritma", 2020),
                new Buku23("B002", "Basis Data", 2019),
                new Buku23("B003", "Pemrograman", 2021),
                new Buku23("B004", "Fisika", 2024)
        };

        daftarPeminjaman = new Peminjaman23[] {
                new Peminjaman23(findMahasiswaByNim("22001"), findBukuByJudul("Algoritma"), 7),
                new Peminjaman23(findMahasiswaByNim("22002"), findBukuByJudul("Basis Data"), 3),
                new Peminjaman23(findMahasiswaByNim("22003"), findBukuByJudul("Pemrograman"), 10),
                new Peminjaman23(findMahasiswaByNim("22003"), findBukuByJudul("Fisika"), 6),
                new Peminjaman23(findMahasiswaByNim("22001"), findBukuByJudul("Basis Data"), 4)
        };
    }

    Mahasiswa23 findMahasiswaByNim(String nim) {
        for (Mahasiswa23 mhs : daftarMahasiswa) {
            if (mhs != null && mhs.nim.equals(nim)) {
                return mhs;
            }
        }
        return null;
    }

    Buku23 findBukuByJudul(String judul) {
        for (Buku23 buku : daftarBuku) {
            if (buku != null && buku.judul.equalsIgnoreCase(judul)) {
                return buku;
            }
        }
        return null;
    }

    public void tampilkanDataMahasiswa() {
        System.out.println("\nData Mahasiswa");
        System.out.printf("%-6s %-10s %s%n", "NIM", "Nama", "Prodi");
        for (Mahasiswa23 mhs : daftarMahasiswa) {
            mhs.tampil();
        }
    }
    
    public void tampilkanDataBuku(){
        System.out.println("\nData Buku");
        System.out.printf("%-5s %-15s %s%n", "Kode", "Judul", "Tahun");
        for (Buku23 buku : daftarBuku) {
            buku.tampil();
        }
    }

    public void tampilkanDataPeminjaman() {
        System.out.println("\nData Peminjaman");
        System.out.printf("%-6s %-10s %-15s %s%n", "NIM", "Nama", "Judul Buku", "Lama");
        for (Peminjaman23 p : daftarPeminjaman) {
            p.tampil();
        }
    }

    public void tampilkanPerhitunganDenda() {
        System.out.println("\nPerhitungan Keterlambatan & Denda");
        System.out.println("Ketentuan: batas maksimal 5 hari, denda Rp 2.000 per hari (jika tidak terlambat, denda = 0)");
        System.out.printf("%-6s %-10s %-15s %4s %4s %s%n", "NIM", "Nama", "Judul Buku", "Lama", "Late", "Denda");

        int totalSemuaDenda = 0;
        for (Peminjaman23 p : daftarPeminjaman) {
            totalSemuaDenda += p.hitungDenda();
            p.tampilDenganDenda();
        }
        System.out.printf("Total denda semua peminjaman: Rp %,d%n", totalSemuaDenda);
    }

    public void tampilkanPeminjamanUrutDendaTerbesar() {
        Peminjaman23[] data = copyPeminjaman();
        hitungDendaSemua(data);
        insertionSortByDendaDesc(data);

        System.out.println("\nData Peminjaman (Urut Denda Terbesar)");
        System.out.printf("%-6s %-10s %-15s %4s %4s %s%n", "NIM", "Nama", "Judul Buku", "Lama", "Late", "Denda");
        for (Peminjaman23 p : data) {
            p.tampilDenganDenda();
        }
    }

    public void cariPeminjamanByNim(String nim) {
        Peminjaman23[] data = copyPeminjaman();
        insertionSortByNimAsc(data);

        int idx = binarySearchByNim(data, nim);
        if (idx == -1) {
            System.out.println("Data peminjaman untuk NIM " + nim + " tidak ditemukan.");
            return;
        }

        int first = idx;
        while (first > 0 && data[first - 1].mahasiswa.nim.equals(nim)) {
            first--;
        }

        System.out.println("\nHasil Pencarian Peminjaman (NIM: " + nim + ")");
        System.out.printf("%-6s %-10s %-15s %s%n", "NIM", "Nama", "Judul Buku", "Lama");
        for (int i = first; i < data.length && data[i].mahasiswa.nim.equals(nim); i++) {
            data[i].tampil();
        }
    }

    Peminjaman23[] copyPeminjaman() {
        return Arrays.copyOf(daftarPeminjaman, daftarPeminjaman.length);
    }

    void hitungDendaSemua(Peminjaman23[] data) {
        for (Peminjaman23 p : data) {
            p.hitungDenda();
        }
    }

    void insertionSortByDendaDesc(Peminjaman23[] data) {
        for (int i = 1; i < data.length; i++) {
            Peminjaman23 temp = data[i];
            int j = i;
            while (j > 0 && data[j - 1].totalDenda < temp.totalDenda) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = temp;
        }
    }

    void insertionSortByNimAsc(Peminjaman23[] data) {
        for (int i = 1; i < data.length; i++) {
            Peminjaman23 temp = data[i];
            int j = i;
            while (j > 0 && data[j - 1].mahasiswa.nim.compareTo(temp.mahasiswa.nim) > 0) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = temp;
        }
    }

    int binarySearchByNim(Peminjaman23[] data, String nim) {
        int left = 0;
        int right = data.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = data[mid].mahasiswa.nim.compareTo(nim);
            if (cmp == 0) {
                return mid;
            }
            if (cmp > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
