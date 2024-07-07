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
        println("╔══════════════════════════════════════════════════════════════╗")
        println("║                         PT BANK UNGU                         ║")
        println("╠══════════════════════════════════════════════════════════════╣")
        println("║                           TRANSFER                           ║")
        println("╚══════════════════════════════════════════════════════════════╝")
    }

    override fun tampilkanFooter() {
        println("╚══════════════════════════════════════════════════════════════╝")
    }

    override fun jalankan() {
        tampilkanJudul()
        print("Masukkan Nama Pemilik Rekening: ")
        val nama = scanner.next()
        print("Masukkan Jenis ATM Bank: ")
        val jenis = scanner.next()
        print("Masukkan No Rekening Tujuan: ")
        val norek = scanner.nextInt()
        print("Masukkan Jumlah Transfer Uang: Rp. ")
        val transfer = scanner.nextInt()
        print("Keterangan Pembayaran: ")
        val ket = scanner.next()

        println("────────────────────────────────────────────────────────────────")
        println("                Konfirmasi Pembayaran Anda")
        println("────────────────────────────────────────────────────────────────")
        println("Nama: $nama")
        println("Jenis ATM Bank: $jenis")
        println("No. Rekening Tujuan: $norek")
        println("Jumlah Transfer: Rp. $transfer")
        println("Keterangan: $ket")
        println("────────────────────────────────────────────────────────────────")
        print("Apakah Anda yakin ingin melanjutkan? (y/n): ")
        val konfirmasi = scanner.next()
        if (konfirmasi.equals("y", ignoreCase = true)) {
            if (saldo >= transfer) {
                saldo -= transfer
                println("Transfer Berhasil!")
                println("Sisa saldo Anda: Rp. $saldo")
            } else {
                println("Saldo Anda tidak mencukupi.")
            }
        } else {
            println("Transfer dibatalkan.")
        }
        println("────────────────────────────────────────────────────────────────")
        print("Masukkan kode angka bebas untuk kembali ke menu: ")
        scanner.nextInt()
        tampilkanFooter()
    }
}

// Kelas Menabung yang mewarisi ATM
class Menabung : ATM() {
    override fun tampilkanJudul() {
        println("╔══════════════════════════════════════════════════════════════╗")
        println("║                         PT BANK UNGU                         ║")
        println("╠══════════════════════════════════════════════════════════════╣")
        println("║                          SETOR TUNAI                         ║")
        println("╚══════════════════════════════════════════════════════════════╝")
    }

    override fun tampilkanFooter() {
        println("╚══════════════════════════════════════════════════════════════╝")
    }

    override fun jalankan() {
        tampilkanJudul()
        println("Nominal yang diterima dalam kelipatan Rp100.000")
        println("────────────────────────────────────────────────────────────────")
        print("Masukkan jumlah uang: Rp. ")
        val uang = scanner.nextInt()
        saldo += uang
        println("Setoran Berhasil!")
        println("Saldo Anda saat ini: Rp. $saldo")
        println("────────────────────────────────────────────────────────────────")
        print("Masukkan kode angka bebas untuk kembali ke menu: ")
        scanner.nextInt()
        tampilkanFooter()
    }
}

// Kelas Penarikan yang mewarisi ATM
class Penarikan : ATM() {
    override fun tampilkanJudul() {
        println("╔══════════════════════════════════════════════════════════════╗")
        println("║                        PT BANK UNGU                          ║")
        println("╠══════════════════════════════════════════════════════════════╣")
        println("║                         PENARIKAN                            ║")
        println("╚══════════════════════════════════════════════════════════════╝")
    }

    override fun tampilkanFooter() {
        println("╚══════════════════════════════════════════════════════════════╝")
    }

    override fun jalankan() {
        tampilkanJudul()
        println("─────────────── PILIH JUMLAH PAKET TUNAI PENARIKAN ─────────────")
        println("\t\t\t1. Rp50.000\t\t    2. Rp100.000")
        println("\t\t\t3. Rp200.000\t\t4. Rp1.500.000")
        println("\t\t\t5. Rp300.000\t\t6. Rp2.000.000")
        println("────────────────────────────────────────────────────────────────")
        print("Masukkan pilihan: ")
        val paket = arrayOf(50000, 100000, 200000, 1500000, 300000, 2000000)
        val pilihan = scanner.nextInt()
        println("────────────────────────────────────────────────────────────────")
        if (pilihan in 1..6) {
            if (saldo >= paket[pilihan - 1]) {
                print("Anda akan menarik Rp${paket[pilihan - 1]}. Konfirmasi? (y/n): ")
                val konfirmasi = scanner.next()
                if (konfirmasi.equals("y", ignoreCase = true)) {
                    saldo -= paket[pilihan - 1]
                    println("Penarikan Berhasil!")
                    println("Saldo Anda saat ini: Rp. $saldo")
                } else {
                    println("Penarikan dibatalkan.")
                }
            } else {
                println("Maaf, saldo Anda tidak mencukupi.")
            }
        } else {
            println("Maaf, pilihan Anda tidak tersedia.")
        }
        println("────────────────────────────────────────────────────────────────")
        print("Masukkan kode angka bebas untuk kembali ke menu: ")
        scanner.nextInt()
        tampilkanFooter()
    }
}

// Kelas Saldo yang mewarisi ATM
class Saldo : ATM() {
    override fun tampilkanJudul() {
        println("╔══════════════════════════════════════════════════════════════╗")
        println("║                        PT BANK UNGU                          ║")
        println("╠══════════════════════════════════════════════════════════════╣")
        println("║                           SALDO                              ║")
        println("╚══════════════════════════════════════════════════════════════╝")
    }

    override fun tampilkanFooter() {
        println("╚══════════════════════════════════════════════════════════════╝")
    }

    override fun jalankan() {
        tampilkanJudul()
        println("Total saldo Anda: Rp. $saldo")
        println("────────────────────────────────────────────────────────────────")
        print("Masukkan kode angka bebas untuk kembali ke menu: ")
        scanner.nextInt()
        tampilkanFooter()
    }
}

// Kelas Informasi yang mewarisi ATM
class Informasi : ATM() {
    override fun tampilkanJudul() {
        println("╔══════════════════════════════════════════════════════════════╗")
        println("║                        PT BANK UNGU                          ║")
        println("╠══════════════════════════════════════════════════════════════╣")
        println("║                     INFORMASI KELOMPOK                       ║")
        println("╚══════════════════════════════════════════════════════════════╝")
        println("|====|=========|==========================|==============|===================|===============|")
        println("| No |   PIN   |     Nama                 |    NIM       |   Prodi           |     Saldo     |")
        println("|====|=========|==========================|==============|===================|===============|")
    }

    override fun tampilkanFooter() {
        println("╚══════════════════════════════════════════════════════════════╝")
    }

    override fun jalankan() {
        tampilkanJudul()
        val anggota = arrayOf(
            arrayOf("1", "123456", "Fachriza Prima    ", "23.12.2958", "Sistem Informasi", saldo.toString()),
            arrayOf("2", "123456", "Wahyu Nugroho     ", "23.12.2959", "Sistem Informasi", saldo.toString()),
            arrayOf("3", "123456", "Nabil Yudhistira  ", "23.12.2960", "Sistem Informasi", saldo.toString()),
            arrayOf("4", "123456", "Salman Abdurrahman", "23.12.2961", "Sistem Informasi", saldo.toString()),
            arrayOf("5", "123456", "Zidan Zaidan      ", "23.12.2962", "Sistem Informasi", saldo.toString()),
        )
        for (anggota in anggota) {
            println("| ${anggota[0]}  | ${anggota[1]}  | ${anggota[2]}       | ${anggota[3]}   | ${anggota[4]}  |  ${anggota[5]}   \t |")
            println("|====|=========|==========================|==============|===================|===============|")
        }
        print("Masukkan kode angka bebas untuk kembali ke menu: ")
        scanner.nextInt()
        tampilkanFooter()
    }
}

// Fungsi untuk menampilkan menu utama
fun tampilkanMenu() {
    println("╔══════════════════════════════════════════════════════════════╗")
    println("║                          PILIH MENU                          ║")
    println("╠══════════════════════════════════════════════════════════════╣")
    println("║     1. Transfer Uang               4. Informasi Kelompok     ║")
    println("║     2. Menabung                    5. Informasi Saldo        ║")
    println("║     3. Penarikan Uang              6. Keluar                 ║")
    println("╚══════════════════════════════════════════════════════════════╝")
}

fun main() {
    val scanner = Scanner(System.`in`)
    var keluar = false
    var pinVerified = false

    while (!keluar) {
        if (!pinVerified) {
            println("╔════════════════════════════════════════════════════════════════╗")
            println("║                FINAL PROJECT BAHASA PEMROGRAMAN 1              ║")
            println("║                       MESIN ATM SEDERHANA                      ║")
            println("╠════════════════════════════════════════════════════════════════╣")
            println("║                       Welcome to ATM Ungu                      ║")
            println("║                        Kelompok Delapan                        ║")
            println("║                         PIN Anda 123456                        ║")
            println("╚════════════════════════════════════════════════════════════════╝")
            print("Masukkan PIN Anda: ")
            val pin = scanner.nextInt()
            if (pin == 123456) {
                pinVerified = true
            } else {
                println("╔══════════════════════════════════════════════════════════════╗")
                println("║              MAAF PIN YANG ANDA MASUKAN SALAH                ║")
                println("║           SILAHKAN ULANGI DAN PERIKSA PIN ANDA               ║")
                println("║                        TERIMAKASIH                           ║")
                println("╚══════════════════════════════════════════════════════════════╝")
            }
        }

        if (pinVerified) {
            var pilihan: Int
            do {
                tampilkanMenu()
                print("Masukkan pilihan: ")
                pilihan = scanner.nextInt()
                val operasi: OperasiATM = when (pilihan) {
                    1 -> Transfer()
                    2 -> Menabung()
                    3 -> Penarikan()
                    4 -> Informasi()
                    5 -> Saldo()
                    6 -> {
                        println("╔══════════════════════════════════════════════════════════════════╗")
                        println("║       Terima Kasih Telah Menggunakan Mesin ATM Ungu Kami...      ║")
                        println("╚══════════════════════════════════════════════════════════════════╝")
                        keluar = true
                        break
                    }
                    else -> {
                        println("Pilihan tidak tersedia. Silakan coba lagi.")
                        continue
                    }
                }
                operasi.jalankan()
            } while (pilihan in 1..5)
        }
    }
}
