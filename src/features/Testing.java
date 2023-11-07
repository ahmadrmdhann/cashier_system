package features;

import java.util.Scanner;

public class Testing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] usernames = {"admin", null, null, null, null, null}; // persiapan penambahan akun (max = 5 kasir)
        String[] passwords = {"admin", null, null, null, null, null}; // persiapan penambahan akun (max = 5 kasir)
        String newUsername;
        String newPassword;
        boolean isLoggedIn = false;
        boolean inMenu = false;
        int userIndex = -1; // untuk menyamakan index password dan username
        int cashierChoice;

        // Inisialisasi sistem pemesanan
        int jumlahMenu, scMenu, uangPembeli;
        int uangKembalian = 0, totalMenuFinal = 0;
        String[] menuArr = { "Nasi Goreng", "Sate", "Sayur Lodeh", "Sayur Asem", "Ayam Geprek", "Teh Anget", "Jeruk",
                "Susu Soda" };
        int[] hargaMenuArr = { 10000, 15000, 8000, 8000, 10000, 5000, 5000, 5000 };
        int[] isBanyakMenuArr = new int[8];
        int[] totalMenuArr = new int[8];

        // Sistem Login
        while (!isLoggedIn) {
            System.out.println("+-----------------------------------------+");
            System.out.println("|                LOG IN                   |");
            System.out.println("+-----------------------------------------+");
            System.out.print("Username\t: ");
            String inputUsername = sc.nextLine();

            for (int i = 0; i < usernames.length; i++) {
                if (inputUsername.equals(usernames[i])) {
                    userIndex = i;
                    break;
                }
            }

            if (userIndex >= 0) {
                System.out.print("Password\t: ");
                String inputPassword = sc.nextLine();
                if (inputPassword.equals(passwords[userIndex])) {
                    System.out.println("Log In Successfully.");
                    isLoggedIn = true;
                }
                else {
                    System.out.println("Password is incorrect.");
                    continue;
                }
            } else {
                System.out.println("Username doesn't exist.");
                continue;
            }

                System.out.println("\nWelcome to our Restaurant!\n");
                System.out.println("-------------------- MAIN MENU --------------------");
                System.out.println("[1] Order Here!");
                System.out.println("[2] Stock Management");
                System.out.println("[3] Menu Settings");
                System.out.println("[4] Add Account");
                System.out.println("[5] Table Reservation");
                System.out.println("[0] Log Out");
                System.out.print("Select the menu you want: ");
                int inputMenu = sc.nextInt();
    
                switch (inputMenu) {
                    case 0:
                        isLoggedIn = false;
                        userIndex = -1; // reset user index untuk selanjutnya
                        System.out.println("Logged out successfully.");
                        continue;
                    case 1:
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
                        System.out.printf("\nApa yang ingin anda pesan pada Menu #%d? (Gunakan Menu Pada Menu) ", i);
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
                    continue;
                    case 4:
                        System.out.print("Enter a new username: ");
                        newUsername = sc.next();
                        System.out.print("Enter a new password: ");
                        newPassword = sc.next();
                        // mencari index yang kosong
                            for (int j = 1; j < usernames.length; j++) {
                                if (usernames[j] == null) {
                                    usernames[j] = newUsername;
                                    passwords[j] = newPassword;
                                    System.out.println("Account created successfully.");
                                }
                            }
                        continue;
                    // menu/fitur selanjutnya bisa segera ditambahkan
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        continue;
            }
        }
    }
}