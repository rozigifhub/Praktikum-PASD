# Jawaban Jobsheet 15 (Collection) - Presensi 23

## ArrayList

1. `ArrayList` tetap bisa menambah elemen meskipun melebihi kapasitas awal, karena kapasitas itu hanya kapasitas awal, bukan batas maksimum tetap.
2. Saat `customers.add(new Customer(...))` dipanggil tanpa index, object baru ditambahkan di akhir collection.
3. Index pada `ArrayList` dimulai dari `0`.
4. Method `indexOf()` digunakan untuk mencari posisi object dalam collection.
5. Method `get(index)` digunakan untuk mengambil object pada index tertentu.
6. `ArrayList` bisa diinstansiasi tanpa menentukan size awal, misalnya `new ArrayList<>()`.
7. Method `addAll()` digunakan untuk menambahkan seluruh elemen dari collection lain sekaligus.
8. `System.out.println(customers)` bisa dipakai untuk debugging karena object sudah memiliki `toString()`.

## Stack

1. Pengecekan `temp != null` dipakai agar program aman sebelum mencetak hasil `peek()` atau `pop()`.
2. Method `peek()` melihat elemen teratas tanpa menghapusnya.
3. Method `pop()` mengambil sekaligus menghapus elemen teratas.
4. Method `search()` mencari posisi elemen dari atas stack. Hasil `1` berarti elemen ada di puncak stack.

## TreeSet

1. Urutan data pada `TreeSet` berbeda dari urutan penambahan karena `TreeSet` menyimpan data dalam keadaan terurut otomatis.
2. `first()` mengambil elemen terkecil/terawal.
3. `last()` mengambil elemen terbesar/terakhir.
4. `remove(x)` menghapus elemen tertentu.
5. `pollFirst()` mengambil dan menghapus elemen pertama.
6. `pollLast()` mengambil dan menghapus elemen terakhir.

## Sorting

1. `Collections.sort()` digunakan untuk mengurutkan data primitif wrapper atau `String`.
2. Untuk object, pengurutan perlu comparator, misalnya `customers.sort((c1, c2) -> c1.name.compareTo(c2.name));`
3. Pengurutan object bisa ditentukan berdasarkan atribut tertentu, misalnya `name`.

## File Implementasi

- `Pertemuan15/Customer23.java`
- `Pertemuan15/Book23.java`
- `Pertemuan15/DemoArrayList23.java`
- `Pertemuan15/StackDemo23.java`
- `Pertemuan15/TreeSetDemo23.java`
- `Pertemuan15/SortingDemo23.java`
