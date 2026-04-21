package Pertemuan9;

public class StackKonversi23 {
    int[] tumpukanBiner;
    int size;
    int top;

    public StackKonversi23(int size) {
        this.size = size;
        tumpukanBiner = new int[size];
        top = -1;
    }

    boolean isFull() {
        return top == size - 1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    void push(int data) {
        if (isFull()) {
            return;
        }
        tumpukanBiner[++top] = data;
    }

    int pull() {
        if (isEmpty()) {
            return -1;
        }
        return tumpukanBiner[top--];
    }
}
