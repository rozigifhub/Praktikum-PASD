package Pertemuan9;

public class StackTugasMahasiswa23 {
    Mahasiswa23[] stack;
    int size;
    int top;

    public StackTugasMahasiswa23(int size) {
        this.size = size;
        stack = new Mahasiswa23[size];
        top = -1;
    }

    boolean isFull() {
        return top == size - 1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    void push(Mahasiswa23 mhs) {
        if (isFull()) {
            System.out.println("Stack penuh! Tidak bisa menambah tugas.");
            return;
        }
        stack[++top] = mhs;
        System.out.println("Tugas berhasil ditumpuk.");
    }

    Mahasiswa23 pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong! Tidak ada tugas yang bisa diambil.");
            return null;
        }
        Mahasiswa23 data = stack[top];
        stack[top] = null;
        top--;
        return data;
    }

    Mahasiswa23 peek() {
        if (isEmpty()) {
            return null;
        }
        return stack[top];
    }

    Mahasiswa23 peekBottom() {
        if (isEmpty()) {
            return null;
        }
        return stack[0];
    }

    int jumlahTugasTerkumpul() {
        return top + 1;
    }

    void print() {
        if (isEmpty()) {
            System.out.println("Stack kosong.");
            return;
        }
        System.out.println("\nDaftar tugas dalam stack (atas ke bawah):");
        for (int i = top; i >= 0; i--) {
            Mahasiswa23 mhs = stack[i];
            if (mhs != null) {
                System.out.printf("%d) %s - %s - %s - nilai: %s%n", (top - i + 1), mhs.nim, mhs.nama, mhs.kelas,
                        (mhs.nilai == -1 ? "belum dinilai" : String.valueOf(mhs.nilai)));
            }
        }
    }

    String konversiDesimalKeBiner(int kode) {
        if (kode == 0) {
            return "0";
        }

        StackKonversi23 stackKonversi = new StackKonversi23(32);
        int angka = kode;
        while (angka != 0) {
            int sisa = angka % 2;
            stackKonversi.push(sisa);
            angka = angka / 2;
        }

        StringBuilder biner = new StringBuilder();
        while (!stackKonversi.isEmpty()) {
            biner.append(stackKonversi.pull());
        }
        return biner.toString();
    }
}
