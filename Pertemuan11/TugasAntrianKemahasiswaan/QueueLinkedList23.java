package Pertemuan11.TugasAntrianKemahasiswaan;

public class QueueLinkedList23 {
    NodeAntri23 front;
    NodeAntri23 rear;
    int size;
    int max;

    public QueueLinkedList23(int max) {
        this.max = max;
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size == max;
    }

    void clear() {
        front = rear = null;
        size = 0;
        System.out.println("Antrian berhasil dikosongkan.");
    }

    void enqueue(MahasiswaAntri23 mhs) {
        if (isFull()) {
            System.out.println("Antrian penuh! Tidak bisa menambah.");
            return;
        }

        NodeAntri23 newNode = new NodeAntri23(mhs);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Mahasiswa berhasil ditambahkan ke antrian.");
    }

    MahasiswaAntri23 dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian kosong! Tidak ada yang dipanggil.");
            return null;
        }

        MahasiswaAntri23 data = front.data;
        front = front.next;
        size--;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    MahasiswaAntri23 peekFront() {
        return isEmpty() ? null : front.data;
    }

    MahasiswaAntri23 peekRear() {
        return isEmpty() ? null : rear.data;
    }

    int getJumlahAntrian() {
        return size;
    }
}

