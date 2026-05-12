package Pertemuan12.Jobsheet12;

public class DoubleLinkedList23 {
    Node23 head;
    Node23 tail;

    public DoubleLinkedList23() {
        head = null;
        tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    int size() {
        int count = 0;
        Node23 current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    void addFirst(Mahasiswa23 data) {
        Node23 newNode = new Node23(null, data, head);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            head.prev = newNode;
            head = newNode;
        }
    }

    void addLast(Mahasiswa23 data) {
        Node23 newNode = new Node23(tail, data, null);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    void add(Mahasiswa23 data, int index) {
        if (index < 0) {
            System.out.println("Index tidak valid.");
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }

        int currentSize = size();
        if (index > currentSize) {
            System.out.println("Index melebihi panjang linked list.");
            return;
        }
        if (index == currentSize) {
            addLast(data);
            return;
        }

        Node23 current = head;
        int i = 0;
        while (current != null && i < index) {
            current = current.next;
            i++;
        }

        if (current == null) {
            System.out.println("Index melebihi panjang linked list.");
            return;
        }

        Node23 newNode = new Node23(current.prev, data, current);
        current.prev.next = newNode;
        current.prev = newNode;
    }

    Node23 search(String keyNim) {
        Node23 current = head;
        while (current != null) {
            if (current.data.nim.equalsIgnoreCase(keyNim)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    void insertAfter(String keyNim, Mahasiswa23 data) {
        Node23 current = search(keyNim);
        if (current == null) {
            System.out.println("Data dengan NIM " + keyNim + " tidak ditemukan.");
            return;
        }

        if (current == tail) {
            addLast(data);
            return;
        }

        Node23 newNode = new Node23(current, data, current.next);
        current.next.prev = newNode;
        current.next = newNode;
    }

    void print() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong");
            return;
        }

        System.out.println("Isi Double Linked List:");
        Node23 current = head;
        int no = 1;
        while (current != null) {
            System.out.println("Data ke-" + no);
            current.data.tampil();
            System.out.println();
            current = current.next;
            no++;
        }
    }

    void printReverse() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong");
            return;
        }

        System.out.println("Isi Double Linked List (reverse):");
        Node23 current = tail;
        int no = size();
        while (current != null) {
            System.out.println("Data ke-" + no);
            current.data.tampil();
            System.out.println();
            current = current.prev;
            no--;
        }
    }

    Mahasiswa23 removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong");
            return null;
        }

        Mahasiswa23 removedData = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        System.out.println("Data berhasil dihapus dari awal:");
        removedData.tampil();
        return removedData;
    }

    Mahasiswa23 removeLast() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong");
            return null;
        }

        Mahasiswa23 removedData = tail.data;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        System.out.println("Data berhasil dihapus dari akhir:");
        removedData.tampil();
        return removedData;
    }
}
