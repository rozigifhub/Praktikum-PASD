public class SortingMain23 {
    public static void main(String[] args) {
        int[] a = { 10, 40, 30, 50, 70, 20, 100, 90 };
        Sorting23 dataUrut1 = new Sorting23(a, a.length);
        System.out.println("Data awal (bubble sort):");
        dataUrut1.tampil();
        dataUrut1.bubbleSort();
        System.out.println("Data setelah bubble sort:");
        dataUrut1.tampil();

        int[] b = { 30, 20, 10, 50, 70, 40, 90, 100 };
        Sorting23 dataUrut2 = new Sorting23(b, b.length);
        System.out.println("\nData awal (selection sort):");
        dataUrut2.tampil();
        dataUrut2.selectionSort();
        System.out.println("Data setelah selection sort:");
        dataUrut2.tampil();

        int[] c = { 40, 10, 30, 50, 70, 20, 100, 90 };
        Sorting23 dataUrut3 = new Sorting23(c, c.length);
        System.out.println("\nData awal (insertion sort):");
        dataUrut3.tampil();
        dataUrut3.insertionSort();
        System.out.println("Data setelah insertion sort:");
        dataUrut3.tampil();
    }
}

