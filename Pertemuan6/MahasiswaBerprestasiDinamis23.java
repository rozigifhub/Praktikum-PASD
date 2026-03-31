public class MahasiswaBerprestasiDinamis23 {
    Mahasiswa23[] listMhs;
    int idx;

    public MahasiswaBerprestasiDinamis23(int kapasitas) {
        if (kapasitas <= 0) {
            kapasitas = 1;
        }
        listMhs = new Mahasiswa23[kapasitas];
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
            listMhs[i].tampilInformasi();
            System.out.println();
        }
    }

    // Bubble sort berdasarkan IPK secara descending
    void bubbleSort() {
        for (int i = 0; i < idx - 1; i++) {
            for (int j = 1; j < idx - i; j++) {
                if (listMhs[j].ipk > listMhs[j - 1].ipk) {
                    Mahasiswa23 tmp = listMhs[j];
                    listMhs[j] = listMhs[j - 1];
                    listMhs[j - 1] = tmp;
                }
            }
        }
    }
}

