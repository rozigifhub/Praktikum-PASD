package Pertemuan11.TugasAntrianKemahasiswaan;

public class MahasiswaAntri23 {
    String nim;
    String nama;
    String prodi;
    String kelas;

    public MahasiswaAntri23(String nim, String nama, String prodi, String kelas) {
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

