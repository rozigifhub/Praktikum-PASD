package Pertemuan10.P2Jobsheet10;

public class AntrianLayanan23 {
    Mahasiswa23[] data;
    int front;
    int rear;
    int size;
    int max;

    public AntrianLayanan23(int n) {
        max = n;
        data = new Mahasiswa23[max];
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
        System.out.println("Antrian berhasil dikosongkan");
    }

    void enqueue(Mahasiswa23 dt) {
        if (isFull()) {
            System.out.println("Antrian sudah penuh!");
            return;
        }

        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % max;
        }
        data[rear] = dt;
        size++;
    }

    Mahasiswa23 dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian masih kosong!");
            return null;
        }

        Mahasiswa23 dt = data[front];
        data[front] = null;
        size--;

        if (isEmpty()) {
            front = rear = -1;
        } else {
            front = (front + 1) % max;
        }
        return dt;
    }

    void peek() {
        if (isEmpty()) {
            System.out.println("Antrian masih kosong!");
            return;
        }
        System.out.println("Antrian terdepan:");
        data[front].tampilkanData();
    }

    void print() {
        if (isEmpty()) {
            System.out.println("Antrian masih kosong!");
            return;
        }
        System.out.println("Daftar antrian:");
        int i = front;
        for (int j = 0; j < size; j++) {
            System.out.println("\nAntrian ke-" + (j + 1));
            data[i].tampilkanData();
            i = (i + 1) % max;
        }
    }

    int getJumlahAntrian() {
        return size;
    }

    // Pertanyaan 2.2.3: cek antrian paling belakang
    void lihatAkhir() {
        if (isEmpty()) {
            System.out.println("Antrian masih kosong!");
            return;
        }
        System.out.println("Antrian paling belakang:");
        data[rear].tampilkanData();
    }
}

