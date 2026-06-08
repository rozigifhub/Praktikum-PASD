package Belajar.Tree;

public class BinaryTreeArray {
    Mahasiswa[] data;
    int idxLast;

    BinaryTreeArray(int size) {
        data = new Mahasiswa[size];
        idxLast = -1;
    }

    void add(Mahasiswa mhs) {
        if (idxLast + 1 >= data.length) {
            System.out.println("Array tree penuh");
            return;
        }
        data[++idxLast] = mhs;
    }

    void traverseInOrder(int idxStart) {
        if (idxStart <= idxLast) {
            traverseInOrder(2 * idxStart + 1);
            if (data[idxStart] != null) {
                System.out.println(data[idxStart].nama + " " + data[idxStart].ipk);
            }
            traverseInOrder(2 * idxStart + 2);
        }
    }

    void traversePreOrder(int idxStart) {
        if (idxStart <= idxLast) {
            if (data[idxStart] != null) {
                System.out.println(data[idxStart].nama + " " + data[idxStart].ipk);
            }
            traversePreOrder(2 * idxStart + 1);
            traversePreOrder(2 * idxStart + 2);
        }
    }
}
