# Program ATM Sederhana

## Tujuan

Program ini dibuat untuk memenuhi tugas akhir pada mata kuliah Bahasa Pemrograman 1. Program ini mensimulasikan mesin ATM sederhana dengan beberapa fitur seperti transfer uang, menabung, penarikan uang, informasi saldo, dan informasi kelompok.

## Keterangan

Program ini ditulis dalam bahasa Kotlin dan menggunakan konsep-konsep Object-Oriented Programming (OOP) seperti Polymorphism, Inheritance, Interface, dan Visibility Modifiers. Program ini juga memanfaatkan Array dan Collections serta berbagai fungsi untuk mendukung operasi ATM.

## Alur Penggunaan Program

1. Pengguna akan diminta memasukkan PIN untuk masuk ke sistem.
2. Setelah verifikasi PIN, pengguna akan disajikan menu utama dengan beberapa pilihan: Transfer Uang, Menabung, Penarikan Uang, Informasi Kelompok, Informasi Saldo, dan Keluar.
3. Pengguna memilih operasi yang diinginkan.
4. Program akan menjalankan operasi yang dipilih dan kembali ke menu utama setelah operasi selesai.
5. Pengguna dapat keluar dari sistem dengan memilih opsi "Keluar".

## Struktur Program

-   `interface OperasiATM`: Interface untuk operasi ATM yang mendefinisikan fungsi `jalankan()`.
-   `abstract class ATM`: Kelas abstrak yang mewarisi `OperasiATM` dan mendefinisikan struktur dasar untuk kelas-kelas turunan.
-   `class Transfer`: Kelas untuk operasi transfer uang.
-   `class Menabung`: Kelas untuk operasi menabung.
-   `class Penarikan`: Kelas untuk operasi penarikan uang.
-   `class Saldo`: Kelas untuk menampilkan informasi saldo.
-   `class Informasi`: Kelas untuk menampilkan informasi kelompok.
-   Fungsi `tampilkanMenu()`: Fungsi untuk menampilkan menu utama.
-   Fungsi `main()`: Fungsi utama yang menjalankan program.

## Materi yang Digunakan

1. **Polymorphism**: Program ini menggunakan polymorphism dengan mendefinisikan interface `OperasiATM` dan mengimplementasikan fungsi `jalankan()` di kelas-kelas turunan.
2. **Interface**: Interface `OperasiATM` digunakan untuk mendefinisikan operasi dasar yang harus diimplementasikan oleh setiap kelas operasi ATM.
3. **Inheritance**: Kelas `ATM` adalah kelas abstrak yang diwarisi oleh kelas-kelas `Transfer`, `Menabung`, `Penarikan`, `Saldo`, dan `Informasi`.
4. **Class & Object**: Program ini menggunakan kelas dan objek untuk merepresentasikan berbagai operasi ATM.
5. **Visibility Modifiers**: Modifier `protected` digunakan dalam kelas `ATM` untuk memungkinkan akses oleh kelas-kelas turunan.
6. **Array & Collections**: Array digunakan dalam kelas `Penarikan` dan `Informasi` untuk menyimpan dan mengelola data.
7. **Function**: Program ini menggunakan berbagai fungsi untuk mendefinisikan logika program, termasuk fungsi `tampilkanMenu()` dan `main()`.

## Cara Menjalankan Program

1. Pastikan Anda memiliki Java dan Kotlin terinstal di sistem Anda.
2. Buat file dengan nama `ATM.kt` dan salin kode program di bawah ini ke dalam file tersebut.
3. Buka terminal dan arahkan ke direktori tempat file `ATM.kt` berada.
4. Jalankan perintah berikut untuk mengompilasi program:

```
kotlinc ATM.kt -include-runtime -d ATM.jar
```

5. Jalankan program dengan perintah berikut:

```
java -jar ATM.jar
```

Selamat menggunakan Program ATM Sederhana ini!
