package Pertemuan9;

public class Surat23 {
    String idSurat;
    String namaMahasiswa;
    String kelas;
    char jenisIzin; // S: sakit, I: izin
    int durasi;

    public Surat23() {
    }

    public Surat23(String idSurat, String namaMahasiswa, String kelas, char jenisIzin, int durasi) {
        this.idSurat = idSurat;
        this.namaMahasiswa = namaMahasiswa;
        this.kelas = kelas;
        this.jenisIzin = jenisIzin;
        this.durasi = durasi;
    }
}
