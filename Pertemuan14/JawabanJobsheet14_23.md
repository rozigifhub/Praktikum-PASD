# Jawaban Jobsheet 14 (Tree) - Presensi 23

## 14.2.2 Pertanyaan Percobaan

1. **Mengapa pencarian pada BST lebih efektif dibanding binary tree biasa?**  
Pada BST, data terurut berdasarkan aturan `left < root < right`, sehingga setiap langkah pencarian bisa memangkas setengah kemungkinan cabang. Pada binary tree biasa tanpa aturan urutan, pencarian sering harus menelusuri banyak node.

2. **Kegunaan atribut `left` dan `right` pada Node**  
- `left` menunjuk child kiri (nilai lebih kecil dari parent pada BST).
- `right` menunjuk child kanan (nilai lebih besar dari parent pada BST).  
Keduanya dipakai untuk traversal, pencarian, penambahan, dan penghapusan node.

3. **Kegunaan `root` dan nilai awalnya**  
a. `root` adalah titik awal akses seluruh tree. Semua operasi dimulai dari `root`.  
b. Saat objek tree baru dibuat, nilai `root` adalah `null` (tree kosong).

4. **Saat tree kosong lalu ditambah node baru**  
Node baru langsung menjadi `root`, karena belum ada node lain.

5. **Penjelasan baris pada method `add()`**  
Inti alurnya:
- bandingkan IPK data baru dengan node saat ini
- jika lebih kecil pindah ke kiri, jika lebih besar pindah ke kanan
- jika child tujuan `null`, node baru dipasang di posisi itu  
Mekanisme ini menjaga sifat BST tetap valid.

6. **Langkah delete node dengan dua child dan peran `getSuccessor()`**  
- Cari node yang dihapus (`current`) dan parent-nya.
- Karena punya dua child, cari **in-order successor** (node paling kiri dari subtree kanan).
- `getSuccessor()` mengambil node pengganti tersebut dan merapikan pointer subtree kanannya.
- Node successor menggantikan posisi `current`.
- Left subtree dari node lama dihubungkan ke successor.  
Cara ini menjaga urutan BST tetap benar setelah penghapusan.

## 14.3.2 Pertanyaan Percobaan

1. **Kegunaan atribut `data` dan `idxLast`**  
- `data`: array yang menyimpan node tree secara representasi level-order.  
- `idxLast`: indeks elemen terakhir yang valid pada array tree.

2. **Kegunaan `populateData()`**  
Untuk mengisikan data awal tree ke array beserta batas indeks terakhir agar traversal tahu rentang data valid.

3. **Kegunaan `traverseInOrder()`**  
Menelusuri tree dengan urutan `left -> root -> right` pada representasi array.

4. **Jika node ada di indeks 2, posisi child-nya**  
- left child = `2 * 2 + 1 = 5`
- right child = `2 * 2 + 2 = 6`

5. **Kegunaan `idxLast = 6` pada praktikum 2**  
Menandakan elemen valid hanya sampai indeks 6, sehingga traversal tidak memproses indeks di luar data terisi.

6. **Mengapa dipakai indeks `2*idxStart+1` dan `2*idxStart+2`?**  
Karena itu rumus baku representasi binary tree dalam array: child kiri dan child kanan selalu dihitung dari indeks parent dengan rumus tersebut.

## 14.4 Tugas Praktikum - Implementasi

Semua tugas sudah diimplementasikan pada:
- `Pertemuan14/BinaryTree23.java`
  - `addRekursif()`
  - `cariMinIPK()`
  - `cariMaxIPK()`
  - `tampilMahasiswaIPKdiAtas(double ipkBatas)`
- `Pertemuan14/BinaryTreeArray23.java`
  - `add(Mahasiswa23 mahasiswa)`
  - `traversePreOrder(int idxStart)`

File main untuk simulasi:
- `Pertemuan14/BinaryTreeMain23.java`
- `Pertemuan14/BinaryTreeArrayMain23.java`
