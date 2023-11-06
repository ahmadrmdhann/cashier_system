
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inisialisasi Sistem Registrasi
        String username, password;
        String usernameOwner = "Owner";
        String passwordOwner = "owner123";
        boolean isCorrect = false;

        // Inisialisasi Fitur Main Menu
        int menuChoice;

        // Inisialisasi Fitur Daftar Menu
        int jumlahMenu, scMenu, uangPembeli;
        int uangKembalian = 0, totalMenuFinal = 0;
        String[] menuArr = { "Nasi Goreng", "Sate", "Sayur Lodeh", "Sayur Asem", "Ayam Geprek", "Teh Anget", "Jeruk",
                "Susu Soda" };
        int[] hargaMenuArr = { 10000, 15000, 8000, 8000, 10000, 5000, 5000, 5000 };
        int[] isBanyakMenuArr = new int[8];
        int[] totalMenuArr = new int[8];

        // Inisialisasi Fitur Reservasi Meja
        boolean[] statusMeja = { true, true, true, false, true };
        int jmlOrangMeja;
        int scMeja;

        // Sistem registrasi

        while (!isCorrect) {
            System.out.println("\t\t+-----------------------------------------+");
            System.out.println("\t\t|                   LOG IN                |");
            System.out.println("\t\t+-----------------------------------------+");
            System.out.print("\t\tUsername\t: ");
            username = sc.nextLine();
            if (username.equals(usernameOwner)) {
                System.out.print("\t\tPassword\t: ");
                password = sc.nextLine();
                if (password.equals(passwordOwner)) {
                    System.out.println("Anda berhasil login\n");
                    isCorrect = true;
                } else {
                    System.out.println("Password yang anda masukkan salah\n");
                    continue;
                }
            } else {
                System.out.println("Username yang anda masukkan tidak ditemukan\n");
                continue;
            }
        }

        // Fitur main menu
        System.out.println("\n\nSelamat datang di restoran kami!\n");
        System.out.println("-------------------- MENU UTAMA --------------------");
        System.out.println("[1] Pesan Disini!");
        System.out.println("[2] Stock Manajemen");
        System.out.println("[3] Pengaturan Diskon");
        System.out.println("[4] Menambanhkan Akun");
        System.out.println("[5] Reservasi Meja");
        System.out.println("[0] Keluar");
        System.out.print("Pilih menu yang ingin anda pilih : ");
        menuChoice = sc.nextInt();

        switch (menuChoice) {
            case 1:
                // Fitur order menu dan cetak struk
                System.out.println("\t\t+-----------------------------------------------+");
                System.out.println("\t\t|                    MENU                       |");
                System.out.println("\t\t+-Nomor-------------- Makanan ------------------+");

                for (int i = 0; i < menuArr.length; i++) { // Perulangan Daftar Menu
                    System.out.printf("\t\t|   %d  | %s   \t\tRp. %d\t|\n", i + 1, menuArr[i], hargaMenuArr[i]);
                }
                System.out.println("\t\t+-----------------------------------------------+\n");

                System.out.print("Berapa jenis menu makanan dan minuman yang ingin anda pesan? ");
                jumlahMenu = sc.nextInt();

                // Perulangan sesuai input jumlahMenu
                int i = 1;
                while (jumlahMenu >= i) {
                    System.out.printf("\nApa yang ingin anda pesan pada Menu #%d? ", i);
                    scMenu = sc.nextInt();

                    while (scMenu > menuArr.length || scMenu < 1 || isBanyakMenuArr[scMenu - 1] != 0) {
                        // Mengecek kesesuaian input tidak lebih dari menu atau tidak 0
                        if (scMenu > menuArr.length || scMenu < 1) {
                            System.out.print("Menu tidak ada, silahkan isi kembali: ");
                            scMenu = sc.nextInt();
                        } else { // Mengecek menu jika sudah pernah ditambahkan
                            System.out.printf("\nMenu %s sudah ditambahkan\nSilahkan pilih menu yang lain: ",
                                    menuArr[scMenu - 1]);
                            scMenu = sc.nextInt();
                        }
                    }

                    // Input elemen array banyak menu tiap menu
                    System.out.printf("Berapa banyak anda ingin memesan %s? ", menuArr[scMenu - 1]);
                    isBanyakMenuArr[scMenu - 1] = sc.nextInt();

                    // Mengecek kesesuaian banyaknya menu, sehingga tidak 0
                    while (isBanyakMenuArr[scMenu - 1] <= 0) {
                        System.out.print(
                                "\nNominal menu tidak bisa kurang dari 1!\nBerapa banyak anda ingin memesannya? ");
                        isBanyakMenuArr[scMenu - 1] = sc.nextInt();
                    }

                    // Menghitung total menu dan memasukkan kedalam array totalMenuArr berdasarkan
                    // tiap indeks menu
                    totalMenuArr[scMenu - 1] = isBanyakMenuArr[scMenu - 1] * hargaMenuArr[scMenu - 1];
                    i++; // Update
                }

                // Hitung total semua menu
                for (int elemen : totalMenuArr) {
                    totalMenuFinal += elemen;
                }
                System.out.println(totalMenuFinal);

                System.out.println("\nTotal harga yang harus dibayarkan : " + totalMenuFinal);
                System.out.print("Masukkan uang anda : ");
                uangPembeli = sc.nextInt();

                while (uangPembeli < totalMenuFinal) {
                    System.out.print("\nMaaf uang anda kurang.\nSilahkan memasukkan nominal lain: ");
                    uangPembeli = sc.nextInt();

                }

                uangKembalian = uangPembeli - totalMenuFinal;

                System.out.println("\n\n-------------------------Struk------------------------");
                for (int j = 0; j < menuArr.length; j++) {
                    if (totalMenuArr[j] != 0) {
                        System.out.printf("%s    \t: %d  x  Rp. %d\t= Rp. %d\n", menuArr[j], isBanyakMenuArr[j],
                                hargaMenuArr[j],
                                totalMenuArr[j]);
                    }
                }
                System.out.println("------------------------------------------------------");
                System.out.println("Total Akhir\t:\t\t\t  Rp. " + totalMenuFinal);
                System.out.println("Cash\t\t:\t\t\t  Rp. " + uangPembeli);
                System.out.println("Kembalian\t:\t\t\t  Rp. " + uangKembalian);
                System.out.println("------------------------------------------------------");
                System.out.println("  \tTerima Kasih Atas Kunjungan Anda");
                break;

            default:
                break;
            case 2:
                System.out.println("Under Construction!!");
                break;

            case 3:
                System.out.println("Under Construction!!");
                break;

            case 4:
                System.out.println("Under Construction!!");
                break;

            case 5:
                // Fitur Reservasi Meja
                // Mengecek ketersediaan meja
                for (int k = 1; k <= statusMeja.length; k++) {
                    if (statusMeja[k - 1] == true) {
                        System.out.printf("Meja %d tersedia!\n", k);
                    }
                }

                System.out.printf("Pilihlah meja mana yang ingin anda tempati (1-%d) : ", statusMeja.length);
                scMeja = sc.nextInt();

                // Mengecek inputan scMeja
                while (scMeja > statusMeja.length || scMeja < 1 || statusMeja[scMeja - 1] == false) {
                    // Menangkap scMeja jika 0 atau lebih dari meja yang tersedia
                    if (scMeja > statusMeja.length || scMeja < 1) {
                        System.out.print("Meja tidak tersedia, silahkan pilih lagi: ");
                        scMeja = sc.nextInt();
                    } else { // Menangkap ketidaksediaan meja
                        System.out.println("Maaf, meja tidak tersedia");
                        System.out.printf("Pilihlah meja mana yang ingin anda  (1-%d) : ", statusMeja.length);
                        scMeja = sc.nextInt();
                    }
                }

                System.out.printf("Anda ingin reservasi meja %d untuk berapa orang? ", scMeja);
                jmlOrangMeja = sc.nextInt();

                // Mengecek input jmlOrangMeja tidak 0
                while (jmlOrangMeja < 1) {
                    System.out.println("\nReservasi meja tidak boleh kosong");
                    System.out.printf("Anda ingin reservasi meja %d untuk berapa orang? ", scMeja);
                    jmlOrangMeja = sc.nextInt();
                }
                statusMeja[scMeja - 1] = false;

                System.out.printf("\nAnda telah melakukan reservasi meja %d untuk %d", scMeja, jmlOrangMeja);
                break;
        }
    }
}