public class NilaiMahasiswaMain23 {
    static int maxUTSIndexDC(NilaiMahasiswa23[] arr, int l, int r) {
        if (l == r) {
            return l;
        }

        int mid = (l + r) / 2;
        int leftIndex = maxUTSIndexDC(arr, l, mid);
        int rightIndex = maxUTSIndexDC(arr, mid + 1, r);

        return arr[leftIndex].nilaiUTS >= arr[rightIndex].nilaiUTS ? leftIndex : rightIndex;
    }

    static int minUTSIndexDC(NilaiMahasiswa23[] arr, int l, int r) {
        if (l == r) {
            return l;
        }

        int mid = (l + r) / 2;
        int leftIndex = minUTSIndexDC(arr, l, mid);
        int rightIndex = minUTSIndexDC(arr, mid + 1, r);

        return arr[leftIndex].nilaiUTS <= arr[rightIndex].nilaiUTS ? leftIndex : rightIndex;
    }

    static double rataRataUASBF(NilaiMahasiswa23[] arr) {
        int total = 0;
        for (NilaiMahasiswa23 mhs : arr) {
            total += mhs.nilaiUAS;
        }
        return (double) total / arr.length;
    }

    public static void main(String[] args) {
        NilaiMahasiswa23[] mhs = new NilaiMahasiswa23[] {
                new NilaiMahasiswa23("Ahmad", "220101001", 2022, 78, 82),
                new NilaiMahasiswa23("Budi", "220101002", 2022, 85, 88),
                new NilaiMahasiswa23("Cindy", "220101003", 2021, 90, 87),
                new NilaiMahasiswa23("Dian", "220101004", 2021, 76, 79),
                new NilaiMahasiswa23("Eko", "220101005", 2023, 92, 95),
                new NilaiMahasiswa23("Fajar", "220101006", 2020, 88, 85),
                new NilaiMahasiswa23("Gina", "220101007", 2023, 80, 83),
                new NilaiMahasiswa23("Hadi", "220101008", 2020, 82, 84)
        };

        int idxMax = maxUTSIndexDC(mhs, 0, mhs.length - 1);
        int idxMin = minUTSIndexDC(mhs, 0, mhs.length - 1);
        double rataUAS = rataRataUASBF(mhs);

        System.out.println("Nilai UTS tertinggi (DC): " + mhs[idxMax].nilaiUTS + " - " + mhs[idxMax].nama + " (" + mhs[idxMax].nim + ")");
        System.out.println("Nilai UTS terendah (DC): " + mhs[idxMin].nilaiUTS + " - " + mhs[idxMin].nama + " (" + mhs[idxMin].nim + ")");
        System.out.println("Rata-rata nilai UAS (BF): " + rataUAS);
    }
}

