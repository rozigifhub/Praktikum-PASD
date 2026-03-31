public class MahasiswaDemo23 {
    public static void main(String[] args) {

        MahasiswaBerprestasi23 daftar = new MahasiswaBerprestasi23();

        Mahasiswa23 m1 = new Mahasiswa23("A11", "Andi", "TI-1A", 3.42);
        Mahasiswa23 m2 = new Mahasiswa23("A12", "Budi", "TI-1A", 3.87);
        Mahasiswa23 m3 = new Mahasiswa23("A13", "Citra", "TI-1A", 3.12);
        Mahasiswa23 m4 = new Mahasiswa23("A14", "Dina", "TI-1A", 3.65);
        Mahasiswa23 m5 = new Mahasiswa23("A15", "Eka", "TI-1A", 3.25);

        daftar.tambah(m1);
        daftar.tambah(m2);
        daftar.tambah(m3);
        daftar.tambah(m4);
        daftar.tambah(m5);

        System.out.println("Data mahasiswa (sebelum sorting):");
        daftar.tampil();

        System.out.println("Data mahasiswa (bubble sort, IPK descending):");
        daftar.bubbleSort();
        daftar.tampil();

        System.out.println("Data mahasiswa (selection sort, IPK ascending):");
        daftar.selectionSort();
        daftar.tampil();

        System.out.println("Data mahasiswa (insertion sort, IPK ascending):");
        daftar.insertionSortAsc();
        daftar.tampil();

        System.out.println("Data mahasiswa (insertion sort, IPK descending):");
        daftar.insertionSortDesc();
        daftar.tampil();
    }
}
