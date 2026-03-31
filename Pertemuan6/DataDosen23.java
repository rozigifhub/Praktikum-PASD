public class DataDosen23 {
    Dosen23[] dataDosen = new Dosen23[10];
    int idx;

    void tambah(Dosen23 dsn) {
        if (idx < dataDosen.length) {
            dataDosen[idx] = dsn;
            idx++;
        } else {
            System.out.println("Data dosen sudah penuh!");
        }
    }

    void tampil() {
        if (idx == 0) {
            System.out.println("Belum ada data dosen.");
            return;
        }
        for (int i = 0; i < idx; i++) {
            System.out.println("----- Data Dosen ke-" + (i + 1) + " -----");
            dataDosen[i].tampil();
        }
    }

    // Sorting ASC (usia termuda -> tertua) menggunakan Bubble Sort
    void sortingASC() {
        for (int i = 0; i < idx - 1; i++) {
            for (int j = 1; j < idx - i; j++) {
                if (dataDosen[j].usia < dataDosen[j - 1].usia) {
                    Dosen23 tmp = dataDosen[j];
                    dataDosen[j] = dataDosen[j - 1];
                    dataDosen[j - 1] = tmp;
                }
            }
        }
    }

    // Alias sesuai penamaan di jobsheet
    void SortingASC() {
        sortingASC();
    }

    // Sorting DSC (usia tertua -> termuda) menggunakan Selection Sort
    void sortingDSC() {
        for (int i = 0; i < idx - 1; i++) {
            int idxMax = i;
            for (int j = i + 1; j < idx; j++) {
                if (dataDosen[j].usia > dataDosen[idxMax].usia) {
                    idxMax = j;
                }
            }
            Dosen23 tmp = dataDosen[idxMax];
            dataDosen[idxMax] = dataDosen[i];
            dataDosen[i] = tmp;
        }
    }

    // Alternatif Sorting DSC: insertion sort (usia tertua -> termuda)
    void insertionSort() {
        for (int i = 1; i < idx; i++) {
            Dosen23 temp = dataDosen[i];
            int j = i;
            while (j > 0 && dataDosen[j - 1].usia < temp.usia) {
                dataDosen[j] = dataDosen[j - 1];
                j--;
            }
            dataDosen[j] = temp;
        }
    }
}

