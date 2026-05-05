package Pertemuan11;

public class SingleLinkedList23 {
    Node23 head;
    Node23 tail;

    boolean isEmpty() {
        return head == null;
    }

    void print() {
        if (isEmpty()) {
            System.out.println("Linked List Kosong");
            return;
        }

        Node23 tmp = head;
        while (tmp != null) {
            tmp.data.tampilInformasi();
            System.out.println();
            tmp = tmp.next;
        }
    }

    void addFirst(Mahasiswa23 input) {
        Node23 ndInput = new Node23(input, null);
        if (isEmpty()) {
            head = tail = ndInput;
        } else {
            ndInput.next = head;
            head = ndInput;
        }
    }

    void addLast(Mahasiswa23 input) {
        Node23 ndInput = new Node23(input, null);
        if (isEmpty()) {
            head = tail = ndInput;
        } else {
            tail.next = ndInput;
            tail = ndInput;
        }
    }

    void insertAfter(String keyNim, Mahasiswa23 input) {
        Node23 tmp = head;
        while (tmp != null) {
            if (tmp.data != null && tmp.data.nim.equalsIgnoreCase(keyNim)) {
                Node23 ndInput = new Node23(input, tmp.next);
                tmp.next = ndInput;
                if (tmp == tail) {
                    tail = ndInput;
                }
                return;
            }
            tmp = tmp.next;
        }
        System.out.println("Data key (NIM) tidak ditemukan: " + keyNim);
    }

    void insertAt(int index, Mahasiswa23 input) {
        if (index < 0) {
            System.out.println("Index tidak valid.");
            return;
        }
        if (index == 0) {
            addFirst(input);
            return;
        }

        Node23 tmp = head;
        int i = 0;
        while (tmp != null && i < index - 1) {
            tmp = tmp.next;
            i++;
        }

        if (tmp == null) {
            System.out.println("Index melebihi panjang linked list.");
            return;
        }

        Node23 ndInput = new Node23(input, tmp.next);
        tmp.next = ndInput;
        if (ndInput.next == null) {
            tail = ndInput;
        }
    }

    Mahasiswa23 getData(int index) {
        if (index < 0 || isEmpty()) {
            return null;
        }
        Node23 tmp = head;
        int i = 0;
        while (tmp != null && i < index) {
            tmp = tmp.next;
            i++;
        }
        return tmp == null ? null : tmp.data;
    }

    int indexOf(String keyNim) {
        Node23 tmp = head;
        int i = 0;
        while (tmp != null) {
            if (tmp.data != null && tmp.data.nim.equalsIgnoreCase(keyNim)) {
                return i;
            }
            tmp = tmp.next;
            i++;
        }
        return -1;
    }

    void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked List Kosong");
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    void removeLast() {
        if (isEmpty()) {
            System.out.println("Linked List Kosong");
            return;
        }
        if (head == tail) {
            head = tail = null;
            return;
        }

        Node23 tmp = head;
        while (tmp.next != tail) {
            tmp = tmp.next;
        }
        tmp.next = null;
        tail = tmp;
    }

    void remove(String keyNim) {
        if (isEmpty()) {
            System.out.println("Linked List Kosong");
            return;
        }

        if (head.data != null && head.data.nim.equalsIgnoreCase(keyNim)) {
            removeFirst();
            return;
        }

        Node23 tmp = head;
        while (tmp.next != null) {
            if (tmp.next.data != null && tmp.next.data.nim.equalsIgnoreCase(keyNim)) {
                tmp.next = tmp.next.next;
                if (tmp.next == null) {
                    tail = tmp;
                }
                break;
            }
            tmp = tmp.next;
        }
    }

    void removeAt(int index) {
        if (index < 0 || isEmpty()) {
            System.out.println("Index tidak valid / Linked List kosong");
            return;
        }
        if (index == 0) {
            removeFirst();
            return;
        }

        Node23 tmp = head;
        int i = 0;
        while (tmp != null && i < index - 1) {
            tmp = tmp.next;
            i++;
        }
        if (tmp == null || tmp.next == null) {
            System.out.println("Index melebihi panjang linked list.");
            return;
        }
        if (tmp.next == tail) {
            tail = tmp;
        }
        tmp.next = tmp.next.next;
    }
}

