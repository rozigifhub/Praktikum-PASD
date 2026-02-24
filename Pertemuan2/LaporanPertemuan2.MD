|  | System Operasi  |
|--|--|
| NIM |  254107020081|
| Nama |  Muhammad Zainur Roziqin |
| Kelas | TI - 1G |

## Praktikum 1
1.  * Atribut (property/state): data atau kondisi yang dimiliki object.
    * Metode (behavior): aksi/perilaku yang bisa dilakukan object.
2.  Ada 4, Nama, Nim, Kelas, IPK.
3.  Ada 4, tampilkanInformasi(), ubahKelas(), updateIPK(double ipkBaru), nilaiKinerja()
4.  Done
5.  Method `nilaiKinerja()` bekerja dengan **membaca nilai `ipk`** mahasiswa, lalu mengecek **rentang IPK** memakai rangkaian `if - else if - else`. Begitu ada kondisi yang cocok, method langsung **mengembalikan (return) String** kategori kinerjanya.

    **Kriteria yang digunakan (berdasarkan IPK):**
    - Jika `ipk >= 3.5` → `"Kinerja sangat baik"`
    - Else jika `ipk >= 3.0` → `"Kinerja baik"`
    - Else jika `ipk >= 2.0` → `"Kinerja cukup"`
    - Selain itu (`ipk < 2.0`) → `"Kinerja buruk"`

    **Yang di-return:**
    - Sebuah **String** berisi **kategori kinerja** sesuai nilai `ipk` (salah satu dari 4 teks di atas).

## Praktikum 2
1.  Mahasiswa23 mhs1 = new Mahasiswa23();, object yang dihasilkan adalah mhs1.
2.  Cara mengakses atribut dan method dari objek memakai **operator titik (`.`)**:
    - Atribut: `mhs1.nama`, `mhs1.nim`, `mhs1.ipk`
    - Method: `mhs1.tampilkanInformasi()`, `mhs1.ubahKelas("S1 2K")`, `mhs1.updateIpk(3.60)`

3.  Output pemanggilan `tampilkanInformasi()` pertama dan kedua berbeda karena **nilai atribut objek `mhs1` sudah diubah** di antara dua pemanggilan itu:
    - `ubahKelas("S1 2K")` mengubah nilai `kelas`
    - `updateIpk(3.60)` mengubah nilai `ipk`
    Jadi saat `tampilkanInformasi()` dipanggil lagi, yang dicetak adalah data terbaru.
