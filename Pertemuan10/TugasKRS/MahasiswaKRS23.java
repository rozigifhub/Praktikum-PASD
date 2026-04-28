package Pertemuan10.TugasKRS;

public class MahasiswaKRS23 {
    String nim;
    String nama;
    String prodi;
    String kelas;

    public MahasiswaKRS23(String nim, String nama, String prodi, String kelas) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        this.kelas = kelas;
    }

    void tampilkanData() {
        System.out.println("NIM   : " + nim);
        System.out.println("Nama  : " + nama);
        System.out.println("Prodi : " + prodi);
        System.out.println("Kelas : " + kelas);
    }
}

