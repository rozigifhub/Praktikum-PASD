package CM2_copy;

public class DaftarPesanan23 {
    NodePesanan23 head;
    NodePesanan23 tail;

    boolean isEmpty() {
        return head == null;
    }

    void tambahPesanan(Pesanan23 pesanan) {
        NodePesanan23 newNode = new NodePesanan23(tail, pesanan, null);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    int size() {
        int count = 0;
        NodePesanan23 current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    Pesanan23[] toArray() {
        Pesanan23[] data = new Pesanan23[size()];
        NodePesanan23 current = head;
        int index = 0;
        while (current != null) {
            data[index] = current.data;
            current = current.next;
            index++;
        }
        return data;
    }

    void insertionSortByNamaPesanan(Pesanan23[] data) {
        for (int i = 1; i < data.length; i++) {
            Pesanan23 temp = data[i];
            int j = i;
            while (j > 0 && data[j - 1].namaPesanan.compareToIgnoreCase(temp.namaPesanan) > 0) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = temp;
        }
    }

    int hitungTotalPendapatan() {
        int total = 0;
        NodePesanan23 current = head;
        while (current != null) {
            total += current.data.harga;
            current = current.next;
        }
        return total;
    }

    void tampilkanLaporanTerurut() {
        if (isEmpty()) {
            System.out.println("Belum ada pesanan yang masuk.");
            return;
        }

        Pesanan23[] data = toArray();
        insertionSortByNamaPesanan(data);

        System.out.println("\nLaporan Pesanan (urut nama pesanan):");
        System.out.printf(
                "%-10s %-20s %-12s %-10s %-20s %s%n",
                "Kode",
                "Nama Pesanan",
                "Harga",
                "Antrian",
                "Pembeli",
                "No HP");
        for (Pesanan23 pesanan : data) {
            pesanan.tampil();
        }
        System.out.println("Total pendapatan restoran: Rp " + hitungTotalPendapatan());
    }

    void linearSearchByNama(String target) {
        NodePesanan23 current = head;
        boolean ketemu = false;

        while (current != null) {
            if (current.data.pembeli.namaPembeli.equalsIgnoreCase(target)) {
                if (!ketemu) {
                    System.out.println("Data pesanan ditemukan:");
                    System.out.printf(
                        "%-10s %-20s %-12s %-10s %-20s %s%n",
                        "Kode", "Nama Pesanan", "Harga", "Antrian", "Pembeli", "No HP"
                    );
                }
                current.data.tampil();
                ketemu = true;
            }
            current = current.next;
        }

        if (!ketemu) {
            System.out.println("Pesanan dengan nama pembeli " + target + " tidak ditemukan.");
        }
    }
    void hapusSemuaPesanan() {
        if (isEmpty()) {
            System.out.println("Belum ada pesanan.");
            return;
        }

        head = null;
        tail = null;
        System.out.println("Semua pesanan berhasil dihapus.");
    }


}
