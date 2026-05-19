package CM2_copy;

public class AntrianPembeli23 {
    NodePembeli23 head;
    NodePembeli23 tail;
    int nextNoAntrian = 1;

    boolean isEmpty() {
        return head == null;
    }

    int size() {
        int count = 0;
        NodePembeli23 current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    void tambahAntrian(String namaPembeli, String noHp) {
        Pembeli23 pembeli = new Pembeli23(nextNoAntrian, namaPembeli, noHp);
        NodePembeli23 newNode = new NodePembeli23(tail, pembeli, null);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        nextNoAntrian++;
        System.out.println("Antrian berhasil ditambahkan.");
        System.out.println("Nomor antrian: " + pembeli.noAntrian);
    }

    // void tambahAntrianPrioritas(int index, Pembeli23 dataBaru) {
    //     if (index < 0) {
    //         System.out.println("Index tidak valid.");
    //         return;
    //     }

    //     if (isEmpty()) {
    //         System.out.println("Linked list masih kosong.");
    //         return;
    //     }

    //     NodePembeli23 current = head;
    //     int i = 0;

    //     while (current != null && i < index) {
    //         current = current.next;
    //         i++;
    //     }

    //     if (current == null) {
    //         System.out.println("Index melebihi panjang linked list.");
    //         return;
    //     }

    //     NodePembeli23 newNode = new NodePembeli23(current, dataBaru, current.next);

    //     if (current.next != null) {
    //         current.next.prev = newNode;
    //     } else {
    //         tail = newNode;
    //     }

    //     current.next = newNode;
    // }

    void tambahAntrianPrioritas(int index, Pembeli23 dataBaru) {
        if (index < 0) {
            System.out.println("Index tidak valid.");
            return;
        }

        if (index == 0) {
            NodePembeli23 newNode = new NodePembeli23(null, dataBaru, head);
            if (isEmpty()) {
                head = tail = newNode;
            } else {
                head.prev = newNode;
                head = newNode;
            }
            return;
        }

        NodePembeli23 current = head;
        int i = 0;

        while (current != null && i < index - 1) {
            current = current.next;
            i++;
        }

        if (current == null) {
            System.out.println("Index melebihi panjang linked list.");
            return;
        }

        NodePembeli23 newNode = new NodePembeli23(current, dataBaru, current.next);

        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode;
        }

        current.next = newNode;
    }

    void cetakAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian masih kosong.");
            return;
        }

        System.out.println("\nDaftar Antrian Pembeli:");
        System.out.printf("%-10s %-20s %s%n", "No", "Nama Pembeli", "No HP");

        NodePembeli23 current = head;
        while (current != null) {
            current.data.tampil();
            current = current.next;
        }
        System.out.println("Jumlah pembeli dalam antrian: " + size());
    }

    Pembeli23 hapusAntrian(int noAntrian) {
        if (isEmpty()) {
            return null;
        }

        NodePembeli23 current = head;
        while (current != null && current.data.noAntrian != noAntrian) {
            current = current.next;
        }

        if (current == null) {
            return null;
        }

        if (head == tail) {
            head = tail = null;
        } else if (current == head) {
            head = head.next;
            head.prev = null;
        } else if (current == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        return current.data;
    }
    Pembeli23 hapusAntrianDepan() {
        if (isEmpty()) {
            return null;
        }

        Pembeli23 dataDepan = head.data;

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        return dataDepan;
    }
    Pembeli23 hapusAntrianBelakang() {
        if (isEmpty()) {
            return null;
        }

        Pembeli23 dataBelakang = tail.data;

        if (head == tail) {
            head = tail = null;
        } else {
            tail = null;
        }

        return dataBelakang;
    }
    void lihatAntreanDepan(){
        if (isEmpty()) {
            System.out.println("Antrian masih kosong.");
            return;
        }else{
            NodePembeli23 current = head;
            current.data.tampil();
        }
    }
    void lihatAntreanBelakang(){
        if (isEmpty()) {
            System.out.println("Antrian masih kosong.");
            return;
        }else{
            NodePembeli23 current = tail;
            current.data.tampil();
        }
    }


    void tampilkanRingkasSetelahTambah() {
        cetakAntrian();
    }

    Pembeli23 batalAntrian(int noAntrian) {
        if (isEmpty()) {
            return null;
        }

        NodePembeli23 current = head;

        while (current != null) {
            if (current.data.noAntrian == noAntrian) {
                Pembeli23 dataBatal = current.data;

                if (head == tail) {
                    head = tail = null;
                } else if (current == head) {
                    head = head.next;
                    head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }

                return dataBatal;
            }
            current = current.next;
        }

        return null;
    }

}
