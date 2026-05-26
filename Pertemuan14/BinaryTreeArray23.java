package Pertemuan14;

public class BinaryTreeArray23 {
    Mahasiswa23[] data;
    int idxLast;

    public BinaryTreeArray23() {
        data = new Mahasiswa23[20];
        idxLast = -1;
    }

    void populateData(Mahasiswa23[] data, int idxLast) {
        int kapasitas = Math.max(20, data.length);
        this.data = new Mahasiswa23[kapasitas];
        for (int i = 0; i <= idxLast && i < data.length; i++) {
            this.data[i] = data[i];
        }
        this.idxLast = idxLast;
    }

    void traverseInOrder(int idxStart) {
        if (idxStart <= idxLast) {
            traverseInOrder(2 * idxStart + 1);
            if (data[idxStart] != null) {
                data[idxStart].tampilInformasi();
                System.out.println();
            }
            traverseInOrder(2 * idxStart + 2);
        }
    }

    void traversePreOrder(int idxStart) {
        if (idxStart <= idxLast) {
            if (data[idxStart] != null) {
                data[idxStart].tampilInformasi();
                System.out.println();
            }
            traversePreOrder(2 * idxStart + 1);
            traversePreOrder(2 * idxStart + 2);
        }
    }

    void add(Mahasiswa23 mahasiswa) {
        if (idxLast + 1 >= data.length) {
            System.out.println("Array tree penuh, data gagal ditambahkan.");
            return;
        }
        data[++idxLast] = mahasiswa;
    }
}
