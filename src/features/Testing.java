package features;

import java.util.Scanner;

public class Testing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Inisialisasi sistem perakunan duniawi
        String[] usernames = { "admin", null, null, null, null, null }; // persiapan penambahan akun (max = 5 kasir)
        String[] passwords = { "admin", null, null, null, null, null }; // persiapan penambahan akun (max = 5 kasir)
        String newUsername;
        String newPassword;
        boolean isLoggedIn = false;
        boolean inMenu = false;
        int userIndex = -1; // untuk menyamakan index password dan username
        int cashierChoice;
        
        // Inisialisasi sistem main menu
        boolean backMenu = false;

        // Inisialisasi sistem pemesanan
        int jumlahMenu, scMenu, uangPembeli, inputUpdateStock, inputNewStock, inputUpdatePrice, newPrice, newMenuPrice, newMenuStock;
        String newMenuName = "";
        int uangKembalian = 0, totalMenuFinal = 0;
        String[] menuArr = { "Nasi Goreng", "Sate", "Sayur Lodeh", "Sayur Asem", "Ayam Geprek", "Teh Anget", "Jeruk",
                "Susu Soda" };

        // int[][] masterHargaIsBanyakTotalMenuArr = { { 10000, 15000, 8000, 8000, 10000, 5000, 5000, 5000 },
                // { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 } };
        int[][] hargaIsBanyakTotalMenuArr = { { 10000, 15000, 8000, 8000, 10000, 5000, 5000, 5000 },
                { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 } };

        // int[] masterStockMenuArr = {35, 20, 1, 10, 25, 509, 5320, 20};
        int[] stockMenuArr = {35, 20, 1, 10, 25, 509, 5320, 20};

        // Inisialisasi Fitur Reservasi Meja
        boolean[] statusMeja = { true, true, true, false, true };
        int jmlOrangMeja;
        int scMeja;

        // Sistem Login
        // while (!isLoggedIn) {
        //     System.out.println("+-----------------------------------------+");
        //     System.out.println("|                LOG IN                   |");
        //     System.out.println("+-----------------------------------------+");
        //     System.out.print("Username\t: ");
        //     String inputUsername = sc.nextLine();

        //     for (int i = 0; i < usernames.length; i++) {
        //         if (inputUsername.equals(usernames[i])) {
        //             userIndex = i;
        //             break;
        //         }
        //     }

        //     if (userIndex >= 0) {
        //         System.out.print("Password\t: ");
        //         String inputPassword = sc.nextLine();
        //         if (inputPassword.equals(passwords[userIndex])) {
        //             System.out.println("Log In Successfully.");
        //             isLoggedIn = true;
        //             backMenu = false;
        //         } else {
        //             System.out.println("Password is incorrect.");
        //             continue;
        //         }
        //     } else {
        //         System.out.println("Username doesn't exist.");
        //         continue;
        //     }

            while (!backMenu) {
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
                        backMenu = true; // memberhentikan looping untuk main menu
                        isLoggedIn = false;
                        userIndex = -1; // reset user index untuk selanjutnya
                        System.out.println("Logged out successfully.");
                        continue;
                    case 1:
                    // hargaIsBanyakTotalMenuArr = masterHargaIsBanyakTotalMenuArr;
                    // stockMenuArr = masterStockMenuArr;
                        System.out.println("\t\t+-------------------------------------------------------+");
                        System.out.println("\t\t|                    MENU                       |       |");
                        System.out.println("\t\t+-Nomor-------------- Makanan --------------------Stock-+");


                        for (int i = 0; i < menuArr.length; i++) { // Perulangan Daftar Menu
                            System.out.printf("\t\t|  %d\t| %s  \t\tRp. %d\t| %d\t|\n", i + 1, menuArr[i],
                                    hargaIsBanyakTotalMenuArr[0][i], stockMenuArr[i]);
                        }
                        System.out.println("\t\t+-------------------------------------------------------+\n");

                        System.out.print("Berapa jenis menu makanan dan minuman yang ingin anda pesan? ");
                        jumlahMenu = sc.nextInt();

                        // Perulangan sesuai input jumlahMenu
                        int i = 1;
                        while (jumlahMenu >= i) {
                            System.out.printf("\nApa yang ingin anda pesan pada Menu #%d? (Gunakan nomor Pada Menu) ",
                                    i);
                            scMenu = sc.nextInt();

                            while (scMenu > menuArr.length || scMenu < 1
                                    || hargaIsBanyakTotalMenuArr[1][scMenu - 1] != 0) {
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
                            
                            while (true) { // Validasi input dengan stock yang tersedia
                                int isValidWithStock = sc.nextInt();
                                sc.nextLine();
                                if (stockMenuArr[scMenu-1] < isValidWithStock) {
                                    System.out.print("\nMaaf stock kami belum bisa memenuhi permintaan anda!\nBerapa banyak anda ingin memesan? ");
                                    continue;
                                } else if (isValidWithStock <= 0) {
                                    System.out.print("\nNominal menu tidak bisa kurang dari 1!\nBerapa banyak anda ingin memesannya? ");
                                    continue;
                                } else {
                                    hargaIsBanyakTotalMenuArr[1][scMenu-1] = isValidWithStock;
                                    break;
                                }
                            }

                            // Menghitung total menu dan memasukkan kedalam array totalMenuArr berdasarkan
                            // tiap indeks menu
                            hargaIsBanyakTotalMenuArr[2][scMenu - 1] = hargaIsBanyakTotalMenuArr[1][scMenu - 1]
                                    * hargaIsBanyakTotalMenuArr[0][scMenu - 1];
                            i++; // Update
                        }

                        // Edit menu pilihan user
                        boolean isTrue = true;
                        while (isTrue) {
                            System.out.print("\nApakah anda ingin mengedit menu? (y/n): ");
                            String isEditMenu = sc.nextLine();
                            if (isEditMenu.equalsIgnoreCase("y")) {
                                System.out.print("Menu nomor berapa yang anda ingin edit? ");
                                int noEditMenu = sc.nextInt();

                                // Pengecekan input noEditMenu apabila input tidak sesuai
                                boolean isTruee = true;
                                while (isTruee) {
                                    if (noEditMenu > hargaIsBanyakTotalMenuArr[1].length || noEditMenu < 1) {
                                        System.out.print(
                                                "Menu tersebut bukan menu yang telah anda pilih, masukkan nomor menu yang ingin anda edit: ");
                                        noEditMenu = sc.nextInt();
                                    } else if (hargaIsBanyakTotalMenuArr[1][noEditMenu - 1] == 0) {
                                        System.out.printf(
                                                "Menu #%d %s bukanlah menu yang telah anda pilih, menu nomor berapa yang ingin anda edit? ",
                                                noEditMenu, menuArr[noEditMenu - 1]);
                                        noEditMenu = sc.nextInt();
                                    } else
                                        isTruee = false;
                                }

                                System.out.printf("Berapa banyak anda ingin memesan %s? ", menuArr[noEditMenu - 1]);
                                hargaIsBanyakTotalMenuArr[1][noEditMenu - 1] = sc.nextInt();
                                sc.nextLine();

                                // Mengecek kesesuaian banyaknya menu, sehingga tidak 0
                                while (hargaIsBanyakTotalMenuArr[1][noEditMenu - 1] <= 0) {
                                    System.out.print(
                                            "\nNominal menu tidak bisa kurang dari 1!\nBerapa banyak anda ingin memesannya? ");
                                    hargaIsBanyakTotalMenuArr[1][noEditMenu - 1] = sc.nextInt();
                                    sc.nextLine();
                                }

                                // Menghitung total menu dan memasukkan kedalam array totalMenuArr berdasarkan
                                // tiap indeks menu
                                hargaIsBanyakTotalMenuArr[2][noEditMenu
                                        - 1] = hargaIsBanyakTotalMenuArr[1][noEditMenu - 1]
                                                * hargaIsBanyakTotalMenuArr[0][noEditMenu - 1];

                                // Input elemen array banyak menu tiap menu
                            } else
                                isTrue = false;
                        }

                        // Hitung total semua menu
                        for (int elemen : hargaIsBanyakTotalMenuArr[2]) {
                            totalMenuFinal += elemen;
                        }

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
                            if (hargaIsBanyakTotalMenuArr[2][j] != 0) {
                                System.out.printf("%s    \t: %d  x  Rp. %d\t= Rp. %d\n", menuArr[j],
                                        hargaIsBanyakTotalMenuArr[1][j],
                                        hargaIsBanyakTotalMenuArr[0][j],
                                        hargaIsBanyakTotalMenuArr[2][j]);
                            }
                        }
                        System.out.println("------------------------------------------------------");
                        System.out.println("Total Akhir\t:\t\t\t  Rp. " + totalMenuFinal);
                        System.out.println("Cash\t\t:\t\t\t  Rp. " + uangPembeli);
                        System.out.println("Kembalian\t:\t\t\t  Rp. " + uangKembalian);
                        System.out.println("------------------------------------------------------");
                        System.out.println("  \tTerima Kasih Atas Kunjungan Anda");

                        for (int j = 0; j < stockMenuArr.length; j++) {
                                        stockMenuArr[j] -= hargaIsBanyakTotalMenuArr[1][j];
                                    }

                        backMenu = false; // kembali ke main menu
                        continue;
                    
                    case 2:
                        boolean loopMenuSettings = true;
                        while (loopMenuSettings) {
                            System.out.println("\nMenu Settings");
                            System.out.println("[1] View All Menu");
                            System.out.println("[2] Update Stock");
                            System.out.println("[3] Change Price");
                            System.out.println("[4] Add New Menu");
                            System.out.println("[5] Delete Menu");
                            System.out.println("[0] Back to Main Menu");
                            System.out.print("\nSelect the menu you want : ");
                            int menuType = sc.nextInt();
                            sc.nextLine();

                            switch (menuType) {
                                case 0:
                                    loopMenuSettings = false;
                                    break;
                            
                                case 1:
                                //Menampilkan semua menu
                                    System.out.println("\t\t+-------------------------------------------------------+");
                                    System.out.println("\t\t|                    MENU                       |       |");
                                    System.out.println("\t\t+-Nomor-------------- Makanan --------------------Stock-+");

                                    for (int j = 0; j < menuArr.length; j++) { // Perulangan Daftar Menu
                                        System.out.printf("\t\t|  %d\t| %s  \t\tRp. %d\t| %d\t|\n", j + 1, menuArr[j],
                                                hargaIsBanyakTotalMenuArr[0][j], stockMenuArr[j]);
                                    }
                                    System.out.println("\t\t+-------------------------------------------------------+\n");
                                    continue;

                                case 2:
                                //Update stock menu
                                    System.out.println("Update Stock: ");
                                    
                                    //Menampilkan pilihan menu
                                    for (int j = 0; j < menuArr.length; j++) {
                                        System.out.printf("[%d] %s\n", (j+1), menuArr[j]);
                                    }

                                    System.out.print("\nSelect the menu you want to update (use the number) : ");                                

                                    //Validasi inputUpdateStock tidak boleh lebih dan kurang dari menu yang ada
                                    while (true) {
                                        inputUpdateStock = sc.nextInt();
                                        if (inputUpdateStock > menuArr.length || inputUpdateStock < 1) {
                                            System.out.print("Input yang anda masukkan salah!\nMasukkan menu yang ingin di update: ");
                                            continue;
                                        } else break;
                                    }

                                    System.out.printf("Masukkan perubahan stock dari %s {%d} : ", menuArr[inputUpdateStock-1], stockMenuArr[inputUpdateStock-1]);

                                    //Validasi inputNewStock tidak bisa kurang dari 0
                                    while (true) {
                                        inputNewStock = sc.nextInt();
                                        sc.nextLine();
                                        if (inputNewStock < 0) {
                                            System.out.print("Stock tidak bisa kurang dari 0!\nSilahkan masukkan perubahan stock: ");
                                        } else break;
                                    }

                                    //Replace inputNewStock kedalam array stockMenuArr
                                    stockMenuArr[inputUpdateStock-1] = inputNewStock;
                                    System.out.println("\nStock updated.");
                                    continue;

                                case 3:
                                //Update harga menu
                                    System.out.println("\nChange Price");
                                    for (int j = 0; j < menuArr.length; j++) {
                                        System.out.printf("[%d] %s\n", (j+1), menuArr[j]);
                                    }
                                    System.out.print("\nSelect the menu you want to update (use the number) : ");                                

                                    //Validasi inputUpdatePrice tidak lebih dan kurang dari menu yang ada
                                    while (true) {
                                        inputUpdatePrice = sc.nextInt();
                                        if (inputUpdatePrice > menuArr.length || inputUpdatePrice < 1) {
                                            System.out.print("Input yang anda masukkan salah!\nMasukkan menu yang ingin di update: ");
                                            continue;
                                        } else break;
                                    }

                                    System.out.printf("Masukkan perubahan harga dari %s {%d} : ", menuArr[inputUpdatePrice-1], hargaIsBanyakTotalMenuArr[0][inputUpdatePrice-1]);
                                    
                                    //Validasi newPrice tidak kurang dari 0
                                    while (true) {
                                        newPrice = sc.nextInt();
                                        sc.nextLine();
                                        if (newPrice < 0) {
                                            System.out.print("Harga tidak bisa kurang dari 0!\nSilahkan masukkan perubahan harga: ");
                                        } else break;
                                    }

                                    //Replace harga menu sebelumnya dengan newPrice
                                    hargaIsBanyakTotalMenuArr[0][inputUpdatePrice-1] = newPrice;
                                    System.out.println("\nHarga updated.");
                                    continue;
                                    
                                case 4:
                                //Tambah menu baru

                                    //Deklarasi array temporary
                                    String[] tempMenuArr = new String[menuArr.length + 1]; //+1 kolom
                                    int[][] tempHargaIsBanyakTotalMenuArr = new int[hargaIsBanyakTotalMenuArr[0].length][tempMenuArr.length]; //+1 kolom dari tempMenuArr.length yang telah dideklarasi sebelumnya
                                    int[] tempStockMenuArr = new int[tempMenuArr.length]; //+1 kolom dari deklarasi tempMenuArr

                                    //Mengisi array temporary dengan value array master
                                    for (int j = 0; j < menuArr.length; j++) {
                                        tempMenuArr[j] = menuArr[j];
                                        tempHargaIsBanyakTotalMenuArr[0][j] = hargaIsBanyakTotalMenuArr[0][j];
                                        tempStockMenuArr[j] = stockMenuArr[j];
                                    }

                                    System.out.println("\nAdd New Menu");
                                    System.out.print("Masukkan nama menu baru: ");
                                    
                                    boolean menuExists = false;
                                    // String newMenuName;

                                    boolean trueMinKh = true;
                                    while (trueMinKh) {
                                        menuExists = false;
                                        newMenuName = sc.nextLine();

                                        for (int j = 0; j < tempMenuArr.length; j++) {
                                            if (newMenuName.equalsIgnoreCase(tempMenuArr[j])) {
                                                System.out.print("Menu sudah ditambahkan! Silahkan masukkan nama menu baru: ");
                                                menuExists = true;
                                                break;
                                            }
                                        }

                                        if (!menuExists) {                                            
                                            tempMenuArr[menuArr.length] = newMenuName;
                                            trueMinKh = false;
                                            break;
                                        }
                                    }
                                    
                                    System.out.printf("Masukkan harga awal untuk %s: ", newMenuName);
                                    while (true) {
                                        newMenuPrice = sc.nextInt();
                                        if (newMenuPrice <= 0) {
                                            System.out.print("\nMaaf, harga untuk menu baru tidak bisa kurang dari 1 rupiah\nSilahkan masukkan harga: ");
                                            continue;
                                        } else break;
                                    }
                                    tempHargaIsBanyakTotalMenuArr[0][menuArr.length] = newMenuPrice;

                                    System.out.printf("Masukkan stock awal untuk %s: ", newMenuName);
                                    while (true) {
                                        newMenuStock = sc.nextInt();
                                        sc.nextLine();
                                        if (newMenuStock < 0) {
                                            System.out.println("Maaf, stock untuk menu baru tidak bisa kurang dari 0\nSilahkan masukkan stock awal: ");
                                            continue;
                                        } else break;
                                    }

                                    tempStockMenuArr[menuArr.length] = newMenuStock;

                                    menuArr = tempMenuArr;
                                    hargaIsBanyakTotalMenuArr = tempHargaIsBanyakTotalMenuArr;
                                    stockMenuArr = tempStockMenuArr;

                                    for (int j = 0; j < tempMenuArr.length; j++) {
                                        System.out.println(tempMenuArr[j]);
                                    }

                                    for (int j = 0; j < tempMenuArr.length; j++) {
                                        System.out.println(tempHargaIsBanyakTotalMenuArr[0][j]);
                                    }
                                    for (int j = 0; j < tempMenuArr.length; j++) {
                                        System.out.println(tempStockMenuArr[j]);
                                    }
                      
                                    continue;
                                default:
                                    break;
                            }

                            break;
                        }
                        continue;

                    case 4:
                        System.out.print("Enter a new username: ");
                        newUsername = sc.next();
                        System.out.print("Enter a new password: ");
                        newPassword = sc.next();
                        // mencari index yang kosong
                        for (i = 1; i < usernames.length; i++) {
                            if (usernames[i] == null) {
                                usernames[i] = newUsername;
                                passwords[i] = newPassword;
                                System.out.println("Account created successfully.");
                                break;
                            }
                        }

                        backMenu = false; // kembali ke main menu
                        continue;
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
                    // menu/fitur selanjutnya bisa segera ditambahkan
                    default:
                        System.out.println("Invalid choice/Feature is Under Construction. Please try again.");
                        continue;
                }
            }
        }
    }
// }