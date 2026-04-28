package Pertemuan10.TugasKRS;

public class AntrianKRS23 {
    MahasiswaKRS23[] data;
    int front;
    int rear;
    int size;
    int max;

    public AntrianKRS23(int n) {
        max = n;
        data = new MahasiswaKRS23[max];
        size = 0;
        front = rear = -1;
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size == max;
    }

    void clear() {
        front = rear = -1;
        size = 0;
        System.out.println("Antrian berhasil dikosongkan.");
    }

    void enqueue(MahasiswaKRS23 mhs) {
        if (isFull()) {
            System.out.println("Antrian penuh! Tidak bisa menambah.");
            return;
        }

        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % max;
        }
        data[rear] = mhs;
        size++;
        System.out.println("Mahasiswa berhasil masuk antrian.");
    }

    MahasiswaKRS23 dequeue() {
        if (isEmpty()) {
            return null;
        }

        MahasiswaKRS23 mhs = data[front];
        data[front] = null;
        size--;

        if (isEmpty()) {
            front = rear = -1;
        } else {
            front = (front + 1) % max;
        }
        return mhs;
    }

    void printAll() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Daftar antrian KRS:");
        int i = front;
        for (int j = 0; j < size; j++) {
            System.out.println("\nAntrian ke-" + (j + 1));
            data[i].tampilkanData();
            i = (i + 1) % max;
        }
    }

    void printFront2() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("2 antrian terdepan:");
        int count = Math.min(2, size);
        int i = front;
        for (int j = 0; j < count; j++) {
            System.out.println("\nAntrian ke-" + (j + 1));
            data[i].tampilkanData();
            i = (i + 1) % max;
        }
    }

    void lihatAkhir() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Antrian paling akhir:");
        data[rear].tampilkanData();
    }

    int getJumlahAntrian() {
        return size;
    }
}

