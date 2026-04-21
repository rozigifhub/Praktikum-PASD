# Jawaban Jobsheet 9 (Stack) – Presensi 23

## 2.1.3 Pertanyaan (Percobaan 1: Mahasiswa Mengumpulkan Tugas)

1) **Perbaikan agar output sesuai verifikasi**
- Bagian yang biasanya perlu diperbaiki ada pada **pengelolaan pointer `top` dan pengecekan batas stack**:
  - `top` harus diinisialisasi `-1` (stack kosong).
  - `isFull()` harus bernilai benar saat `top == size - 1`.
  - `push()` harus menaikkan `top` dulu lalu mengisi data.
  - `pop()` harus mengambil data lalu menurunkan `top`.
  - `print()` sebaiknya menampilkan dari **atas ke bawah** agar sesuai konsep stack (LIFO).

2) **Berapa banyak data yang dapat ditampung?**
- Sebanyak **`size`** data, pada program ini stack dibuat berkapasitas **5**.
- Potongan kode:
  - `StackTugasMahasiswa23 stack = new StackTugasMahasiswa23(5);` di `Pertemuan9/MahasiswaDemo23.java`
  - Array stack dibuat: `stack = new Mahasiswa23[size];` di `Pertemuan9/StackTugasMahasiswa23.java`

3) **Mengapa perlu pengecekan `!isFull()` pada `push`? Apa dampaknya jika dihapus?**
- Untuk **mencegah stack overflow** (melewati kapasitas array).
- Jika dihapus dan data terus ditambah, program bisa error **ArrayIndexOutOfBoundsException** atau data menjadi tidak valid.

4) **Modifikasi agar bisa melihat tugas terbawah (yang pertama kali mengumpulkan)**
- Ditambahkan operasi **peek bawah** dengan mengambil elemen indeks `0`.
- Implementasi: method `peekBottom()` di `Pertemuan9/StackTugasMahasiswa23.java` dan menu “Lihat Tugas Terbawah” di `Pertemuan9/MahasiswaDemo23.java`.

5) **Method untuk menghitung jumlah tugas yang terkumpul + operasi menu**
- Jumlah data di stack = `top + 1`.
- Implementasi: method `jumlahTugasTerkumpul()` di `Pertemuan9/StackTugasMahasiswa23.java` + menu “Hitung Jumlah Tugas Terkumpul” di `Pertemuan9/MahasiswaDemo23.java`.

## 2.2.3 Pertanyaan (Percobaan 2: Konversi Nilai ke Biner)

1) **Alur kerja method `konversiDesimalKeBiner`**
- Selama angka belum 0, hitung sisa bagi 2 (`angka % 2`) lalu **push** sisa ke stack konversi.
- Angka dibagi 2 (`angka / 2`) sampai habis.
- Setelah itu, hasil biner dibentuk dengan **pull/pop** dari stack (urutan jadi benar dari MSB ke LSB).

2) **Jika perulangan diubah menjadi `while (kode != 0)`, bagaimana hasilnya?**
- Untuk `kode > 0`, hasil biner tetap sama.
- Untuk `kode == 0`, `while (kode != 0)` tidak berjalan sama sekali sehingga hasilnya bisa **kosong** (bukan `"0"`).
- Itulah kenapa pada implementasi perlu penanganan khusus untuk `kode == 0`.

