package CM2;

public class AntrianPembeli23 {
    NodePembeli23 head;
    NodePembeli23 tail;
    int nextNoAntrian = 1;

    boolean isEmpty() {
        return head == null;
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

    void tampilkanRingkasSetelahTambah() {
        if (isEmpty()) {
            System.out.println("Antrian masih kosong.");
            return;
        }

        System.out.println("\nAntrian saat ini:");
        System.out.printf("%-10s %-20s %s%n", "No", "Nama Pembeli", "No HP");

        NodePembeli23 current = head;
        while (current != null) {
            current.data.tampil();
            current = current.next;
        }
    }
}
