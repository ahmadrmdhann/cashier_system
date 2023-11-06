
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
        boolean meja01 = true, meja02 = true, meja03 = true;
        boolean mejaStatusTrue = true; // Persiapan meja kembali tersedia
        boolean mejaStatusFalse = false;
        String mejaMana;
        int jumlahOrang;

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
                if (meja01 == true) {
                    System.out.println("\nMeja 1 tersedia!");
                }
                if (meja02 == true) {
                    System.out.println("Meja 2 tersedia!");
                }
                if (meja03 == true) {
                    System.out.println("Meja 3 tersedia!");
                }
                System.out.print("Pilihlah meja mana yang ingin anda tempati (1/2/3) : ");
                mejaMana = sc.next();
                System.out.print("Anda ingin melakukan reservasi untuk berapa orang : ");
                jumlahOrang = sc.nextInt();

                switch (mejaMana) {
                    case "1":
                        System.out
                                .println("Anda telah melakukan reservasi untuk meja 1 untuk " + jumlahOrang + " orang");
                        meja01 = mejaStatusFalse;
                        // System.out.println(meja01);
                        break;
                    case "2":
                        System.out
                                .println("Anda telah melakukan reservasi untuk meja 2 untuk " + jumlahOrang + " orang");
                        meja02 = mejaStatusFalse;
                        // System.out.println(meja02);
                        break;
                    case "3":
                        System.out.println(
                                "Anda telah melakukan reservasi untuk3 meja 3 untuk " + jumlahOrang + " orang");
                        meja03 = mejaStatusFalse;
                        // System.out.println(meja03);
                        break;
                }
        }
    }
}