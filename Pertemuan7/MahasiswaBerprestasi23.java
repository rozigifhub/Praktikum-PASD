public class MahasiswaBerprestasi23 {
    Mahasiswa23[] listMhs;
    int idx;

    MahasiswaBerprestasi23() {
        this(5);
    }

    MahasiswaBerprestasi23(int kapasitas) {
        if (kapasitas <= 0) {
            kapasitas = 5;
        }
        listMhs = new Mahasiswa23[kapasitas];
        idx = 0;
    }

    void tambah(Mahasiswa23 mhs) {
        if (idx < listMhs.length) {
            listMhs[idx] = mhs;
            idx++;
        } else {
            System.out.println("Data sudah penuh!");
        }
    }

    void tampil() {
        for (int i = 0; i < idx; i++) {
            if (listMhs[i] != null) {
                listMhs[i].tampilInformasi();
                System.out.println();
            }
        }
    }

    int sequentialSearch(double cari) {
        return sequentialSearching(cari);
    }

    int sequentialSearching(double cari) {
        int posisi = -1;
        for (int i = 0; i < idx; i++) {
            if (listMhs[i] != null && Double.compare(listMhs[i].ipk, cari) == 0) {
                posisi = i;
                break;
            }
        }
        return posisi;
    }

    void tampilPosisi(double x, int pos) {
        if (pos != -1) {
            System.out.println("Data : " + x + " ditemukan pada indeks " + pos);
        } else {
            System.out.println("Data : " + x + " tidak ditemukan");
        }
    }

    // Alias sesuai teks jobsheet (typo: Poisisi)
    void tampilPoisisi(double x, int pos) {
        tampilPosisi(x, pos);
    }

    void tampilDataSearch(double x, int pos) {
        if (pos != -1) {
            System.out.println("Data mahasiswa dengan IPK : " + x);
            listMhs[pos].tampilInformasi();
        } else {
            System.out.println("Data mahasiswa dengan IPK : " + x + " tidak ditemukan");
        }
    }

    int findBinarySearch(double cari) {
        if (idx == 0) {
            return -1;
        }
        return findBinarySearch(cari, 0, idx - 1);
    }

    int findBinarySearch(double cari, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (listMhs[mid] == null) {
            return -1;
        }

        int cmp = Double.compare(listMhs[mid].ipk, cari);
        if (cmp == 0) {
            return mid;
        }

        boolean ascending = listMhs[left] != null && listMhs[right] != null && listMhs[left].ipk <= listMhs[right].ipk;

        if (ascending) {
            if (cmp > 0) {
                return findBinarySearch(cari, left, mid - 1);
            }
            return findBinarySearch(cari, mid + 1, right);
        }

        // Descending
        if (cmp < 0) {
            return findBinarySearch(cari, left, mid - 1);
        }
        return findBinarySearch(cari, mid + 1, right);
    }

    void insertionSortAsc() {
        for (int i = 1; i < idx; i++) {
            Mahasiswa23 temp = listMhs[i];
            int j = i;
            while (j > 0 && listMhs[j - 1] != null && temp != null && listMhs[j - 1].ipk > temp.ipk) {
                listMhs[j] = listMhs[j - 1];
                j--;
            }
            listMhs[j] = temp;
        }
    }
}
