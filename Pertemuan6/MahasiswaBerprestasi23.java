public class MahasiswaBerprestasi23 {
    Mahasiswa23[] listMhs = new Mahasiswa23[5];
    int idx;

    void tambah(Mahasiswa23 mhs) {
        if (idx < listMhs.length) {
            listMhs[idx] = mhs;
            idx++;
        } else {
            System.out.println("Data sudah penuh!");
        }
    }

    void tampil() {
        for (Mahasiswa23 mhs : listMhs) {
            if (mhs != null) {
                mhs.tampilInformasi();
                System.out.println();
            }
        }
    }

    // Bubble sort berdasarkan IPK secara descending
    void bubbleSort() {
        for (int i = 0; i < listMhs.length - 1; i++) {
            for (int j = 1; j < listMhs.length - i; j++) {
                if (listMhs[j] != null && listMhs[j - 1] != null && listMhs[j].ipk > listMhs[j - 1].ipk) {
                    Mahasiswa23 tmp = listMhs[j];
                    listMhs[j] = listMhs[j - 1];
                    listMhs[j - 1] = tmp;
                }
            }
        }
    }

    // Selection sort berdasarkan IPK secara ascending
    void selectionSort() {
        for (int i = 0; i < listMhs.length - 1; i++) {
            int idxMin = i;
            for (int j = i + 1; j < listMhs.length; j++) {
                if (listMhs[j] != null && listMhs[idxMin] != null && listMhs[j].ipk < listMhs[idxMin].ipk) {
                    idxMin = j;
                }
            }

            Mahasiswa23 tmp = listMhs[idxMin];
            listMhs[idxMin] = listMhs[i];
            listMhs[i] = tmp;
        }
    }

    // Insertion sort berdasarkan IPK secara ascending
    void insertionSortAsc() {
        for (int i = 1; i < listMhs.length; i++) {
            Mahasiswa23 temp = listMhs[i];
            int j = i;
            while (j > 0 && listMhs[j - 1] != null && temp != null && listMhs[j - 1].ipk > temp.ipk) {
                listMhs[j] = listMhs[j - 1];
                j--;
            }
            listMhs[j] = temp;
        }
    }

    // Insertion sort berdasarkan IPK secara descending
    void insertionSortDesc() {
        for (int i = 1; i < listMhs.length; i++) {
            Mahasiswa23 temp = listMhs[i];
            int j = i;
            while (j > 0 && listMhs[j - 1] != null && temp != null && listMhs[j - 1].ipk < temp.ipk) {
                listMhs[j] = listMhs[j - 1];
                j--;
            }
            listMhs[j] = temp;
        }
    }

    // Default: sesuai jobsheet (ascending)
    void insertionSort() {
        insertionSortAsc();
    }
}
