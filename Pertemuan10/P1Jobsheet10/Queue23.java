package Pertemuan10.P1Jobsheet10;

public class Queue23 {
    int[] data;
    int front;
    int rear;
    int size;
    int max;

    public Queue23(int n) {
        max = n;
        data = new int[max];
        size = 0;
        front = rear = -1;
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size == max;
    }

    void peek() {
        if (isEmpty()) {
            System.out.println("Queue masih kosong");
            return;
        }
        System.out.println("Elemen terdepan: " + data[front]);
    }

    void print() {
        if (isEmpty()) {
            System.out.println("Queue masih kosong");
            return;
        }
        System.out.println("Isi queue:");
        int i = front;
        for (int j = 0; j < size; j++) {
            System.out.println(data[i]);
            i = (i + 1) % max;
        }
        System.out.println("Jumlah elemen: " + size);
    }

    void clear() {
        if (isEmpty()) {
            System.out.println("Queue sudah kosong");
            return;
        }
        front = rear = -1;
        size = 0;
        System.out.println("Queue berhasil dikosongkan");
    }

    void enqueue(int dt) {
        if (isFull()) {
            System.out.println("Queue sudah penuh (overflow)!");
            System.out.println("Program dihentikan.");
            System.exit(1);
        }

        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % max;
        }
        data[rear] = dt;
        size++;
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue masih kosong (underflow)!");
            System.out.println("Program dihentikan.");
            System.exit(1);
        }

        int dt = data[front];
        size--;

        if (isEmpty()) {
            front = rear = -1;
        } else {
            front = (front + 1) % max;
        }
        return dt;
    }
}

