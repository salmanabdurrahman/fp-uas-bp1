import java.util.Scanner

// Variabel global
var saldo: Int = 1000000

// Antarmuka untuk operasi ATM
interface OperasiATM {
    fun jalankan()
}

// Kelas abstrak untuk properti umum
abstract class ATM : OperasiATM {
    protected val scanner = Scanner(System.`in`)
    abstract fun tampilkanJudul()
    abstract fun tampilkanFooter()
}

// Kelas Transfer yang mewarisi ATM
class Transfer : ATM() {
    override fun tampilkanJudul() {
        println("╔══════════════════════════════════════════════════════════════════╗")
        println("║                          -- PT BANK AMIKOM --                    ║")
        println("╚══════════════════════════════════════════════════════════════════╝")
        println("                           TRANSFER UANG")
        println("═══════════════════════════════════════════════════════════════════")
    }

    override fun tampilkanFooter() {
        println("╚══════════════════════════════════════════════════════════════════╝")
    }

    override fun jalankan() {
        tampilkanJudul()
        print("Masukkan Nama Pemilik Rekening        : ")
        val nama = scanner.next()
        print("Masukkan Jenis ATM Bank               : ")
        val jenis = scanner.next()
        print("Masukkan No Rekening Tujuan           : ")
        val norek = scanner.nextInt()
        print("Masukkan Jumlah Transfer Uang         : Rp. ")
        val transfer = scanner.nextInt()
        print("Keterangan Pembayaran                 : ")
        val ket = scanner.next()

        saldo -= transfer

        println("───────────────────────────────────────────────────────────────────")
        println("                    Preview Pembayaran Anda")
        println("───────────────────────────────────────────────────────────────────")
        println("Nama                              : $nama")
        println("Jenis ATM Bank                    : $jenis")
        println("No. Rekening Tujuan               : $norek")
        println("Jumlah Transfer                   : Rp. $transfer")
        println("Keterangan                        : $ket")
        println("───────────────────────────────────────────────────────────────────")
        println("Terimakasih! Transaksi anda sedang diproses....")
        println("Sisa saldo anda : Rp. $saldo")
        print("Masukkan kode Angka Bebas Untuk Kembali Ke Home = ")
        scanner.nextInt()
        tampilkanFooter()
    }
}

// Kelas Menabung yang mewarisi ATM
class Menabung : ATM() {
    override fun tampilkanJudul() {
        println("╔══════════════════════════════════════════════════════════════════╗")
        println("║                          -- PT BANK AMIKOM --                    ║")
        println("╚══════════════════════════════════════════════════════════════════╝")
        println("                            SETOR TUNAI")
        println("═══════════════════════════════════════════════════════════════════")
    }

    override fun tampilkanFooter() {
        println("╚══════════════════════════════════════════════════════════════════╝")
    }

    override fun jalankan() {
        tampilkanJudul()
        println("Nominal Yang Diterima : ")
        println("Kelipatan Rp50.000")
        println("───────────────────────────────────────────────────────────────────")
        print("Masukan Jumlah Uang RP. ")
        val uang = scanner.nextInt()
        saldo += uang
        println("Uang Pada ATM Anda Saat Ini RP. $saldo")
        print("Masukan kode Angka Bebas Untuk Kembali Ke Home = ")
        scanner.nextInt()
        tampilkanFooter()
    }
}

// Kelas Penarikan yang mewarisi ATM
class Penarikan : ATM() {
    override fun tampilkanJudul() {
        println("╔══════════════════════════════════════════════════════════════════╗")
        println("║                          -- PT BANK AMIKOM --                    ║")
        println("╚══════════════════════════════════════════════════════════════════╝")
        println("                      PENARIKAN TUNAI")
        println("═══════════════════════════════════════════════════════════════════")
    }

    override fun tampilkanFooter() {
        println("╚══════════════════════════════════════════════════════════════════╝")
    }

    override fun jalankan() {
        tampilkanJudul()
        println("──────────────── PILIH JUMLAH PAKET TUNAI PENARIKAN ────────────────")
        println("\t\t1. Rp50.000\t      2. Rp100.000")
        println("\t\t3. Rp200.000\t      4. Rp1.500.000")
        println("\t\t5. Rp300.000\t      6. Rp2.000.000")
        print("Masukan Pilihan : ")
        val paket = arrayOf(50000, 100000, 200000, 1500000, 300000, 2000000)
        val pilihan = scanner.nextInt()
        println("───────────────────────────────────────────────────────────────────")
        if (pilihan in 1..6) {
            if (saldo >= paket[pilihan - 1]) {
                saldo -= paket[pilihan - 1]
                println("Penarikan Berhasil")
                println("Anda Melakukan Penarikan Tunai Sebesar RP.${paket[pilihan - 1]}")
                println("Saldo Anda Saat Ini RP. $saldo")
            } else {
                println("Maaf Saldo Anda Tidak Mencukupi")
            }
        } else {
            println("Maaf Pilihan Anda Tidak Tersedia")
        }
        print("Masukan Kode Angka Bebas Untuk Kembali Ke Home = ")
        scanner.nextInt()
        tampilkanFooter()
    }
}

// Kelas Saldo yang mewarisi ATM
class Saldo : ATM() {
    override fun tampilkanJudul() {
        println("╔══════════════════════════════════════════════════════════════════╗")
        println("║                          -- PT BANK AMIKOM --                    ║")
        println("╚══════════════════════════════════════════════════════════════════╝")
        println("                         SALDO ANDA")
        println("═══════════════════════════════════════════════════════════════════")
    }

    override fun tampilkanFooter() {
        println("╚══════════════════════════════════════════════════════════════════╝")
    }

    override fun jalankan() {
        tampilkanJudul()
        println("TOTAL SALDO : Rp $saldo")
        println("═══════════════════════════════════════════════════════════════════")
        print("Masukkan Kode Angka Bebas untuk kembali ke Home : ")
        scanner.nextInt()
        tampilkanFooter()
    }
}

// Kelas Informasi yang mewarisi ATM
class Informasi : ATM() {
    override fun tampilkanJudul() {
        println("╔══════════════════════════════════════════════════════════════════╗")
        println("║                          -- PT BANK AMIKOM --                    ║")
        println("╚══════════════════════════════════════════════════════════════════╝")
        println("                     INFORMASI KELOMPOK")
        println("═══════════════════════════════════════════════════════════════════")
        println("| No |   PIN   |     Nama            |    NIM       |   Prodi           |     Saldo     |")
        println("|====|=========|=====================|==============|===================|===============|")
    }

    override fun tampilkanFooter() {
        println("╚══════════════════════════════════════════════════════════════════╝")
    }

    override fun jalankan() {
        tampilkanJudul()
        val anggota = arrayOf(
            arrayOf("1", "123456", "Rama Danadipa", "23.12.2956", "Sistem Informasi", saldo.toString()),
            arrayOf("2", "123456", "Salman Abdurrahman", "23.12.2961", "Sistem Informasi", saldo.toString()),
            arrayOf("3", "123456", "Wisnu Fadhillah", "23.12.2952", "Sistem Informasi", saldo.toString()),
            arrayOf("4", "123456", "Rizki Maulana", "23.12.2940", "Sistem Informasi", saldo.toString())
        )
        for (anggota in anggota) {
            println("| ${anggota[0]}  | ${anggota[1]}  | ${anggota[2]}       | ${anggota[3]}   | ${anggota[4]}  |  ${anggota[5]}   \t|")
            println("|====|=========|=====================|==============|===================|===============|")
        }
        print("Masukan kode Angka Bebas Untuk Kembali Ke Home = ")
        scanner.nextInt()
        tampilkanFooter()
    }
}

// Fungsi untuk menampilkan menu utama
fun tampilkanMenu() {
    println("╔══════════════════════════════════════════════════════════════════╗")
    println("║                       PILIH MENU DI BAWAH INI                    ║")
    println("╠══════════════════════════════════════════════════════════════════╣")
    println("║ 1.) <---  Transfer Uang        Info Data       ---> 4.)          ║")
    println("║ 2.) <---  Menabung             Info Saldo      ---> 5.)          ║")
    println("║ 3.) <---  Penarikan            Keluar          ---> 6.)          ║")
    println("╚══════════════════════════════════════════════════════════════════╝")
}

// Fungsi utama
fun main() {
    val scanner = Scanner(System.`in`)
    val operasi = mapOf(
        1 to Transfer(),
        2 to Menabung(),
        3 to Penarikan(),
        4 to Informasi(),
        5 to Saldo()
    )

    println("╔══════════════════════════════════════════════════════════════════╗")
    println("║              FINAL PROJECT PEMROGRAMAN TERSTRUKTUR               ║")
    println("║                       MESIN ATM SEDERHANA                        ║")
    println("╠══════════════════════════════════════════════════════════════════╣")
    println("║#####################  Welcome to ATM Amikom   ###################║")
    println("║                          Kelompok YTTA                           ║")
    println("║                         PIN Anda 123456                          ║")
    println("║############## @Amikom/Prodi_Sistem_Informasi/2024 ###############║")
    println("╚══════════════════════════════════════════════════════════════════╝")

    print("Masukan PIN anda : ")
    val pin = scanner.nextInt()

    if (pin == 123456) {
        while (true) {
            tampilkanMenu()
            print("Masukan Pilihan = ")
            val pilihan = scanner.nextInt()
            if (pilihan == 6) {
                println("╔══════════════════════════════════════════════════════════════════╗")
                println("║    Terima Kasih Telah Menggunakan Mesin ATM Sederhana Kami...    ║")
                println("╚══════════════════════════════════════════════════════════════════╝")
                break
            }
            operasi[pilihan]?.jalankan() ?: println("Pilihan salah ...... !!")
        }
    } else {
        println("╔══════════════════════════════════════════════════════════════════╗")
        println("║                          MAAF PIN YANG ANDA MASUKAN SALAH        ║")
        println("║                  SILAHKAN ULANGI DAN PERIKSA PIN ANDA            ║")
        println("║                             TERIMAKASIH                          ║")
        println("╚══════════════════════════════════════════════════════════════════╝")
        println("                   Program Selesai .............")
    }
}
