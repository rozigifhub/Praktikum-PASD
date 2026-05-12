# Jawaban Jobsheet 12 (Double Linked List) - Presensi 23

## Percobaan 1 - Operasi Penambahan pada Double Linked List

### 12.2.3 Pertanyaan

1. **Perbedaan struktur dan traversal antara Single Linked List dan Double Linked List**
- `Single Linked List` hanya memiliki pointer `next`, jadi traversal normal hanya bisa maju dari `head` ke node berikutnya.
- `Double Linked List` memiliki pointer `next` dan `prev`, jadi traversal bisa maju dari `head` ke `tail` maupun mundur dari `tail` ke `head`.
- Pada proses sisip/hapus, `Double Linked List` membutuhkan pengaturan dua arah pointer, sedangkan `Single Linked List` hanya mengatur hubungan `next`.

2. **Fungsi atribut `next` dan `prev` pada class `Node`**
- `next` menunjuk ke node sesudah node saat ini, sehingga dipakai saat traversal maju.
- `prev` menunjuk ke node sebelum node saat ini, sehingga dipakai saat traversal mundur.
- Pada manipulasi node, kedua pointer ini menjaga agar hubungan antar node tetap tersambung saat penyisipan maupun penghapusan.

3. **Fungsi konstruktor pada class `DoubleLinkedList` terhadap kondisi awal linked list**
- Konstruktor menginisialisasi `head` dan `tail` dengan `null`.
- Ini menandakan linked list masih kosong dan belum memiliki node.
- Kondisi awal tersebut dipakai method `isEmpty()` untuk membedakan linked list kosong dan tidak kosong.

4. **Mengapa `head` dan `tail` menunjuk node yang sama saat linked list masih kosong lalu ditambah 1 node**
- Karena saat elemen pertama ditambahkan, node itu sekaligus menjadi node pertama dan node terakhir.
- Belum ada node lain di depan maupun di belakangnya.
- Setelah ada penambahan node berikutnya, `head` dan `tail` baru bisa menunjuk node yang berbeda.

5. **Modifikasi `print()` agar menampilkan pesan saat linked list kosong**
- Sudah diterapkan pada `Pertemuan12/Jobsheet12/DoubleLinkedList23.java`.
- Jika `isEmpty()` bernilai `true`, method `print()` menampilkan `Linked List masih kosong`.

6. **Modifikasi `printReverse()` untuk menampilkan data dari `tail` ke `head`**
- Sudah diterapkan pada `Pertemuan12/Jobsheet12/DoubleLinkedList23.java`.
- Method `printReverse()` melakukan traversal mundur mulai dari `tail`, lalu berpindah dengan pointer `prev` sampai mencapai `head`.

## Percobaan 2 - Operasi Penghapusan pada Double Linked List

### 12.3.3 Pertanyaan

1. **Fungsi `head = head.next;` dan `head.prev = null;` pada `removeFirst()`**
- `head = head.next;` memindahkan penunjuk `head` ke node kedua, sehingga node pertama lama tidak lagi menjadi awal linked list.
- `head.prev = null;` memutus hubungan balik dari node baru pertama ke node lama yang sudah dihapus.
- Kombinasi keduanya membuat node pertama terhapus dengan struktur linked list tetap valid.

2. **Modifikasi `removeFirst()` dan `removeLast()` agar menampilkan data yang dihapus**
- Sudah diterapkan pada `Pertemuan12/Jobsheet12/DoubleLinkedList23.java`.
- `removeFirst()` menampilkan data yang dihapus dari bagian awal.
- `removeLast()` menampilkan data yang dihapus dari bagian akhir.

## File Implementasi

- Source code ada di package `Pertemuan12.Jobsheet12`
- Class yang dibuat:
  - `Mahasiswa23.java`
  - `Node23.java`
  - `DoubleLinkedList23.java`
  - `DoubleLinkedListMain23.java`
