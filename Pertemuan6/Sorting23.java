public class Sorting23 {
    int[] data;
    int jumlahData;

    public Sorting23(int[] dataInput, int jmlDat) {
        jumlahData = jmlDat;
        data = new int[jmlDat];
        for (int i = 0; i < jumlahData; i++) {
            data[i] = dataInput[i];
        }
    }

    void bubbleSort() {
        for (int i = 0; i < jumlahData - 1; i++) {
            for (int j = 1; j < jumlahData - i; j++) {
                if (data[j - 1] > data[j]) {
                    int tmp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = tmp;
                }
            }
        }
    }

    void selectionSort() {
        for (int i = 0; i < jumlahData - 1; i++) {
            int idxMin = i;
            for (int j = i + 1; j < jumlahData; j++) {
                if (data[j] < data[idxMin]) {
                    idxMin = j;
                }
            }

            int tmp = data[idxMin];
            data[idxMin] = data[i];
            data[i] = tmp;
        }
    }

    void insertionSort() {
        for (int i = 1; i < jumlahData; i++) {
            int temp = data[i];
            int j = i;
            while (j > 0 && data[j - 1] > temp) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = temp;
        }
    }

    void tampil() {
        for (int i = 0; i < jumlahData; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
