package CM1;

import java.util.Arrays;

public class RuangBacaJT23 {
    Mahasiswa23[] daftarMahasiswa;
    int jumlahMahasiswa;

    Buku23[] daftarBuku;
    PeminjamanJT23[] daftarPeminjaman;

    public RuangBacaJT23() {
        daftarMahasiswa = new Mahasiswa23[3];
        jumlahMahasiswa = 0;
        initDataBukuDanPeminjaman();
    }

    void initDataBukuDanPeminjaman() {
        daftarBuku = new Buku23[] {
                new Buku23("B001", "Algoritma", 2020),
                new Buku23("B002", "Basis Data", 2019),
                new Buku23("B003", "Pemrograman", 2021),
                new Buku23("B004", "Fisika", 2024)
        };

        daftarPeminjaman = new PeminjamanJT23[] {
                new PeminjamanJT23("22001", "Andi", findBukuByJudul("Algoritma"), 7),
                new PeminjamanJT23("22002", "Budi", findBukuByJudul("Basis Data"), 3),
                new PeminjamanJT23("22003", "Citra", findBukuByJudul("Pemrograman"), 10),
                new PeminjamanJT23("22003", "Citra", findBukuByJudul("Fisika"), 6),
                new PeminjamanJT23("22001", "Andi", findBukuByJudul("Basis Data"), 4)
        };
    }

    void ensureMahasiswaCapacity() {
        if (jumlahMahasiswa < daftarMahasiswa.length) {
            return;
        }
        daftarMahasiswa = Arrays.copyOf(daftarMahasiswa, daftarMahasiswa.length * 2);
    }

    public boolean tambahMahasiswa(String nim, String nama, String prodi) {
        if (nim == null || nim.isBlank()) {
            return false;
        }
        if (findMahasiswaByNim(nim) != null) {
            return false;
        }
        ensureMahasiswaCapacity();
        daftarMahasiswa[jumlahMahasiswa] = new Mahasiswa23(nim, nama, prodi);
        jumlahMahasiswa++;
        return true;
    }

    public Mahasiswa23 findMahasiswaByNim(String nim) {
        for (int i = 0; i < jumlahMahasiswa; i++) {
            Mahasiswa23 mhs = daftarMahasiswa[i];
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

    public void tampilkanDataBukuDanMahasiswa() {
        System.out.println("\nData Mahasiswa (Input)");
        System.out.printf("%-6s %-10s %s%n", "NIM", "Nama", "Prodi");
        if (jumlahMahasiswa == 0) {
            System.out.println("(Belum ada data mahasiswa. Silakan input melalui menu.)");
        } else {
            for (int i = 0; i < jumlahMahasiswa; i++) {
                daftarMahasiswa[i].tampil();
            }
        }

        System.out.println("\nData Buku");
        System.out.printf("%-5s %-15s %s%n", "Kode", "Judul", "Tahun");
        for (Buku23 buku : daftarBuku) {
            buku.tampil();
        }
    }

    public void tampilkanDataPeminjaman() {
        System.out.println("\nData Peminjaman");
        System.out.printf("%-6s %-10s %-15s %s%n", "NIM", "Nama", "Judul Buku", "Lama");
        for (PeminjamanJT23 p : daftarPeminjaman) {
            p.tampilRingkas(findMahasiswaByNim(p.nim));
        }
    }

    public void tampilkanPerhitunganDenda() {
        System.out.println("\nPerhitungan Keterlambatan & Denda");
        System.out.println("Ketentuan: batas maksimal 5 hari, denda Rp 2.000 per hari (jika tidak terlambat, denda = 0)");
        System.out.printf("%-6s %-10s %-15s %4s %4s %s%n", "NIM", "Nama", "Judul Buku", "Lama", "Late", "Denda");

        int totalSemuaDenda = 0;
        for (PeminjamanJT23 p : daftarPeminjaman) {
            totalSemuaDenda += p.hitungDenda();
            p.tampilDenganDenda(findMahasiswaByNim(p.nim));
        }
        System.out.printf("Total denda semua peminjaman: Rp %,d%n", totalSemuaDenda);
    }

    public void tampilkanPeminjamanUrutDendaTerbesar(int pilihanAlgoritma) {
        PeminjamanJT23[] data = Arrays.copyOf(daftarPeminjaman, daftarPeminjaman.length);
        for (PeminjamanJT23 p : data) {
            p.hitungDenda();
        }

        switch (pilihanAlgoritma) {
            case 2:
                selectionSortByDendaDesc(data);
                break;
            case 3:
                bubbleSortByDendaDesc(data);
                break;
            default:
                insertionSortByDendaDesc(data);
        }

        System.out.println("\nData Peminjaman (Urut Denda Terbesar)");
        System.out.printf("%-6s %-10s %-15s %4s %4s %s%n", "NIM", "Nama", "Judul Buku", "Lama", "Late", "Denda");
        for (PeminjamanJT23 p : data) {
            p.tampilDenganDenda(findMahasiswaByNim(p.nim));
        }
    }

    void insertionSortByDendaDesc(PeminjamanJT23[] data) {
        for (int i = 1; i < data.length; i++) {
            PeminjamanJT23 temp = data[i];
            int j = i;
            while (j > 0 && data[j - 1].totalDenda < temp.totalDenda) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = temp;
        }
    }

    void selectionSortByDendaDesc(PeminjamanJT23[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int idxMax = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j].totalDenda > data[idxMax].totalDenda) {
                    idxMax = j;
                }
            }
            PeminjamanJT23 tmp = data[idxMax];
            data[idxMax] = data[i];
            data[i] = tmp;
        }
    }

    void bubbleSortByDendaDesc(PeminjamanJT23[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            boolean swapped = false;
            for (int j = 1; j < data.length - i; j++) {
                if (data[j].totalDenda > data[j - 1].totalDenda) {
                    PeminjamanJT23 tmp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) {
                return;
            }
        }
    }

    public void cariPeminjamanByNim(String nim) {
        PeminjamanJT23[] data = Arrays.copyOf(daftarPeminjaman, daftarPeminjaman.length);
        insertionSortByNimAsc(data);

        int idx = binarySearchByNim(data, nim);
        if (idx == -1) {
            System.out.println("Data peminjaman untuk NIM " + nim + " tidak ditemukan.");
            return;
        }

        int first = idx;
        while (first > 0 && data[first - 1].nim.equals(nim)) {
            first--;
        }

        System.out.println("\nHasil Pencarian Peminjaman (NIM: " + nim + ")");
        System.out.printf("%-6s %-10s %-15s %s%n", "NIM", "Nama", "Judul Buku", "Lama");
        for (int i = first; i < data.length && data[i].nim.equals(nim); i++) {
            data[i].tampilRingkas(findMahasiswaByNim(data[i].nim));
        }
    }

    void insertionSortByNimAsc(PeminjamanJT23[] data) {
        for (int i = 1; i < data.length; i++) {
            PeminjamanJT23 temp = data[i];
            int j = i;
            while (j > 0 && data[j - 1].nim.compareTo(temp.nim) > 0) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = temp;
        }
    }

    int binarySearchByNim(PeminjamanJT23[] data, String nim) {
        int left = 0;
        int right = data.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = data[mid].nim.compareTo(nim);
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
