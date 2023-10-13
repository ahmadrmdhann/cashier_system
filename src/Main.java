
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //Inisialisasi Sistem Registrasi
        String username, password;
        String usernameOwner = "Owner";
        String passwordOwner = "owner123";
        boolean isCorrect = false;

        //Inisialisasi Fitur Main Menu
        int menuChoice;

        //Inisialisasi Fitur Daftar Menu
        int jumlahMenu, banyakSate = 0, banyakSayurLodeh = 0, banyakSayurAsem = 0, banyakAyamGeprek = 0, banyakTeh = 0, banyakJeruk = 0, banyakSusuSoda = 0, totalNasgor = 0, totalSate = 0, totalSayurLodeh = 0, totalSayurAsem = 0, totalAyamGeprek = 0, totalTeh = 0, totalJeruk = 0, totalSusuSoda = 0, banyakNasgor = 0, totalHarga = 0, uangKembalian = 0;
        int uangPembeli;

        //Inisialisasi Fitur Reservasi Meja
        boolean meja01 = true, meja02 = true, meja03 = true;
        boolean mejaStatusTrue = true; //Persiapan meja kembali tersedia
        boolean mejaStatusFalse = false;
        String mejaMana;
        int jumlahOrang;

        // Sistem registrasi

        while (!isCorrect){
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
                    isCorrect=true;
                }
                else {
                    System.out.println("Password yang anda masukkan salah\n");
                    continue;
                }
            }
            else {
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
                System.out.println("\t\t+-----------------------------------------+");
                System.out.println("\t\t|                   MENU                  |");
                System.out.println("\t\t+-Kode------------ Makanan ---------------+");
                System.out.println("\t\t|  A1  | Nasi Goreng\t\tRp. 10.000|");
                System.out.println("\t\t|  A2  | Sate\t\t\tRp. 15.000|");
                System.out.println("\t\t|  A3  | Sayur Lodeh\t\tRp. 8.000 |");
                System.out.println("\t\t|  A4  | Sayur Asem\t\tRp. 8.000 |");
                System.out.println("\t\t|  A5  | Ayam Geprek\t\tRp. 10.000|");
                System.out.println("\t\t|----------------- Minuman ---------------|");
                System.out.println("\t\t|  B1  | Teh\t\t\tRp. 5.000 |");
                System.out.println("\t\t|  B2  | Jeruk\t\t\tRp. 5.000 |");
                System.out.println("\t\t|  B3  | Susu Soda\t\tRp. 5.000 |");
                System.out.println("\t\t+-----------------------------------------+\n");

                System.out.print("Berapa jenis menu makanan dan minuman yang ingin anda pesan? ");
                jumlahMenu = sc.nextInt();
                
                System.out.println("\nUntuk memasukkan pilihan makanan yang ingin dipesan, gunakanlah KODE!");

                int i = 1;
                while (i <= jumlahMenu) {
                    System.out.printf("Apa yang ingin anda pesan pada Menu #%d? ", i);
                    String scMenu = sc.next();
                    
                    if (scMenu.equalsIgnoreCase("A1")) {
                        System.out.print("Berapa banyak anda ingin memesan Nasi Goreng? ");
                        banyakNasgor = sc.nextInt();
                        while (banyakNasgor <= 0) {
                            System.out.print("\nNominal menu tidak bisa kurang dari 1!\nBerapa banyak anda ingin memesannya? ");
                            banyakNasgor = sc.nextInt();
                        }
                        totalNasgor = banyakNasgor * 10000;
                        i++;
                        continue;
                    } else if (scMenu.equalsIgnoreCase("A2")) {
                        System.out.print("Berapa banyak anda ingin memesan Sate? ");
                        banyakSate = sc.nextInt();
                        while (banyakSate <= 0) {
                            System.out.print("\nNominal menu tidak bisa kurang dari 1!\nBerapa banyak anda ingin memesannya? ");
                            banyakSate = sc.nextInt();
                        }
                        totalSate = banyakSate * 15000;
                        i++;
                        continue;
                    } else if (scMenu.equalsIgnoreCase("A3")) {
                        System.out.print("Berapa banyak anda ingin memesan Sayur Lodeh? ");
                        banyakSayurLodeh = sc.nextInt();
                        while (banyakSayurLodeh <= 0) {
                            System.out.print("\nNominal menu tidak bisa kurang dari 1!\nBerapa banyak anda ingin memesannya? ");
                            banyakSayurLodeh = sc.nextInt();
                        }
                        totalSayurLodeh = banyakSayurLodeh * 8000;
                        i++;
                        continue;
                    } else if (scMenu.equalsIgnoreCase("A4")) {
                        System.out.print("Berapa banyak anda ingin memesan Sayur Asem? ");
                        banyakSayurAsem = sc.nextInt();
                        while (banyakSayurAsem <= 0) {
                            System.out.print("\nNominal menu tidak bisa kurang dari 1!\nBerapa banyak anda ingin memesannya? ");
                            banyakSayurAsem = sc.nextInt();
                        }
                        totalSayurAsem = banyakSayurAsem * 8000;
                        i++;
                        continue;
                    } else if (scMenu.equalsIgnoreCase("A5")) {
                        System.out.print("Berapa banyak anda ingin memesan Ayam Geprek? ");
                        banyakAyamGeprek = sc.nextInt();
                        while (banyakAyamGeprek <= 0) {
                            System.out.print("\nNominal menu tidak bisa kurang dari 1!\nBerapa banyak anda ingin memesannya? ");
                            banyakAyamGeprek = sc.nextInt();
                        }
                        totalAyamGeprek = banyakAyamGeprek * 10000;
                        i++;
                        continue;
                    } else if (scMenu.equalsIgnoreCase("B1")) {
                        System.out.print("Berapa banyak anda ingin memesan Teh? ");
                        banyakTeh = sc.nextInt();
                        while (banyakTeh <= 0) {
                            System.out.print("\nNominal menu tidak bisa kurang dari 1!\nBerapa banyak anda ingin memesannya? ");
                            banyakTeh = sc.nextInt();
                        }
                        System.out.print("Teh dingin/anget? ");
                        String opsiTeh = sc.next();
                        totalTeh = banyakTeh * 5000;
                        i++;
                        continue;
                    } else if (scMenu.equalsIgnoreCase("B2")) {
                        System.out.print("Berapa banyak anda ingin memesan minuman Jeruk? ");
                        sc.nextInt(); //Formalitas penanyaan dingin/panas sehingga tidak perlu di inisialisasi
                        while (banyakJeruk <= 0) {
                            System.out.print("\nNominal menu tidak bisa kurang dari 1!\nBerapa banyak anda ingin memesannya? ");
                            banyakJeruk = sc.nextInt();
                        }
                        System.out.print("Jeruk dingin/anget? ");
                        sc.next(); //Formalitas penanyaan dingin/panas sehingga tidak perlu di inisialisasi
                        totalJeruk = banyakJeruk * 12000;
                        i++;
                        continue;
                    } else if (scMenu.equalsIgnoreCase("B3")) {
                        System.out.print("Berapa banyak anda ingin memesan Susu Soda? ");
                        banyakSusuSoda = sc.nextInt();
                        while (banyakSusuSoda <= 0) {
                            System.out.print("\nNominal menu tidak bisa kurang dari 1!\nBerapa banyak anda ingin memesannya? ");
                            banyakSusuSoda = sc.nextInt();
                        }
                        totalSusuSoda = banyakSusuSoda * 12000;
                        i++;
                        continue;
                    } else {
                        System.out.print("\nMenu tidak valid, silahkan isi menu kembali..\n");
                    }  
                }
                totalHarga = totalNasgor + totalSate + totalSayurLodeh + totalSayurAsem + totalAyamGeprek + totalTeh + totalJeruk + totalSusuSoda;

                System.out.println("Total harga yang harus dibayarkan : " + totalHarga);
                System.out.print("Masukkan uang anda : ");
                uangPembeli = sc.nextInt();

                while (uangPembeli < totalHarga) {
                    System.out.print("\nMaaf uang anda kurang.\nSilahkan memasukkan nominal lain: ");
                    uangPembeli = sc.nextInt();

                }

                uangKembalian = uangPembeli - totalHarga;
                
                System.out.println("\n\n------------------------Struk------------------------");
                System.out.printf("Nasi Goreng\t: %d  x  Rp. 10.000\t= Rp. %d\n", banyakNasgor, totalNasgor);
                System.out.printf("Sate\t\t: %d  x  Rp. 15.000\t= Rp. %d\n", banyakSate, totalSate);
                System.out.printf("Sayur Lodeh\t: %d  x  Rp. 8.000\t= Rp. %d\n", banyakSayurLodeh, totalSayurLodeh);
                System.out.printf("Sayur Asem\t: %d  x  Rp. 8.000\t= Rp. %d\n", banyakSayurAsem, totalSayurAsem);
                System.out.printf("Ayam Geprek\t: %d  x  Rp. 10.000\t= Rp. %d\n", banyakAyamGeprek, totalAyamGeprek);
                System.out.printf("Teh\t\t: %d  x  Rp. 5.000\t= Rp. %d\n", banyakAyamGeprek, totalAyamGeprek);
                System.out.printf("Jeruk\t\t: %d  x  Rp. 5.000\t= Rp. %d\n", banyakAyamGeprek, totalAyamGeprek);
                System.out.printf("Susu Soda\t: %d  x  Rp. 5.000\t= Rp. %d\n", banyakAyamGeprek, totalAyamGeprek);
                System.out.println("-----------------------------------------------------");
                System.out.println("Total Akhir\t:\t\t\t  Rp. " + totalHarga);
                System.out.println("Cash\t\t:\t\t\t  Rp. " + uangPembeli);
                System.out.println("Kembalian\t:\t\t\t  Rp. " + uangKembalian);
                System.out.println("-----------------------------------------------------");
                System.out.println("\tTerima Kasih Atas Kunjungan Anda");
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
                        System.out.println("Anda telah melakukan reservasi untuk meja 1 untuk "+jumlahOrang+" orang");
                        meja01 = mejaStatusFalse;
                        // System.out.println(meja01);
                        break;
                    case "2":
                        System.out.println("Anda telah melakukan reservasi untuk meja 2 untuk "+jumlahOrang+" orang");
                        meja02 = mejaStatusFalse;
                        // System.out.println(meja02);
                        break;
                    case "3":
                        System.out.println("Anda telah melakukan reservasi untuk3 meja 3 untuk "+jumlahOrang+" orang");
                        meja03 = mejaStatusFalse;
                        // System.out.println(meja03);
                        break;
            }
        }
    }
}