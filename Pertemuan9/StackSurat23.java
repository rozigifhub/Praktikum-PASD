package Pertemuan9;

public class StackSurat23 {
    Surat23[] stack;
    int size;
    int top;

    public StackSurat23(int size) {
        this.size = size;
        stack = new Surat23[size];
        top = -1;
    }

    boolean isFull() {
        return top == size - 1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    void push(Surat23 surat) {
        if (isFull()) {
            System.out.println("Stack surat penuh! Tidak bisa menerima surat baru.");
            return;
        }
        stack[++top] = surat;
        System.out.println("Surat berhasil diterima.");
    }

    Surat23 pop() {
        if (isEmpty()) {
            System.out.println("Stack surat kosong! Tidak ada surat untuk diproses.");
            return null;
        }
        Surat23 s = stack[top];
        stack[top] = null;
        top--;
        return s;
    }

    Surat23 peek() {
        if (isEmpty()) {
            return null;
        }
        return stack[top];
    }

    void tampilRingkas(Surat23 s) {
        if (s == null) {
            System.out.println("Data tidak ada.");
            return;
        }
        System.out.println("ID Surat       : " + s.idSurat);
        System.out.println("Nama Mahasiswa : " + s.namaMahasiswa);
        System.out.println("Kelas          : " + s.kelas);
        System.out.println("Jenis Izin     : " + s.jenisIzin);
        System.out.println("Durasi (hari)  : " + s.durasi);
    }

    boolean cariByNama(String nama) {
        if (isEmpty()) {
            return false;
        }

        boolean ketemu = false;
        for (int i = top; i >= 0; i--) {
            if (stack[i] != null && stack[i].namaMahasiswa.equalsIgnoreCase(nama)) {
                if (!ketemu) {
                    System.out.println("\nSurat ditemukan untuk nama: " + nama);
                }
                ketemu = true;
                System.out.println("\nPosisi di stack: " + i);
                tampilRingkas(stack[i]);
            }
        }
        return ketemu;
    }
}
