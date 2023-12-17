package features;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Testing{
    public static Scanner sc = new Scanner(System.in);
    /*
     * Multi Bahasa
     */
    public static String bahasaSelection;
    public static int selectedBahasa;

    public static int changeLanguage(){
        System.out.println("\n[1] Bahasa Indonesia");
        System.out.println("[2] English Language");
        System.out.print("Select your language: ");
        bahasaSelection = sc.nextLine();
        clearScreen();
        switch (bahasaSelection) {
            case "1":
                System.out.println("Anda telah memilih Bahasa Indonesia");
                selectedBahasa = 1;
                return selectedBahasa;

            case "2":
                System.out.println("You have selected English Language");
                selectedBahasa = 0;
                return selectedBahasa;

            default:
                System.out.println("You have selected default language (English Language)");
                selectedBahasa = 0;
                return selectedBahasa;
        }
    }

    static String[][] logInMessages = {
        { "0",
            "Login Success!", // 1
            "Password Invalid!", // 2
            "Username Doesn't Exist!" }, //3
        { "0",
            "Login berhasil!",
            "Password tidak valid!",
            "Username tidak ada!" } };

    static String[][] menuMessages = {
            { "0",
                "\nWelcome to our Restaurant!\n", // 1
                "Select the menu you want : ", // 2
                "\nMenu Settings", // 3
                "[1] View All Menu", // 4
                "[2] Update Stock", // 5
                "[3] Change Price", // 6
                "[4] Add New Menu", // 7
                "[5] Delete Menu", // 8
                "[0] Back to Main Menu", // 9
                "Select the menu you want : ", // 10
                "Invalid option. Please try again.", //11
                "\nInput Invalid!" }, // 12
            { "0",
                "\nSelamat datang di Restoran!\n",
                "Pilih menu yang Anda inginkan: ",
                "\nPengaturan Menu",
                "[1] Lihat Semua Menu",
                "[2] Perbarui Stok",
                "[3] Ubah Harga",
                "[4] Tambah Menu Baru",
                "[5] Hapus Menu",
                "[0] Kembali ke Menu Utama",
                "Pilih menu yang Anda inginkan: ",
                "Opsi tidak valid, harap pilih lagi.", "\nInput tidak valid." } };

    static String[][] displayMainMenuMessages = {
            { "0",
                "[1] Order Here!", // 1
                "[2] Table Reservation", // 2
                "[3] Sales Report", // 3
                "[4] Menu Settings", // 4
                "[5] Account Settings", // 5
                "[6] Change Language", // 6
                "[0] Log Out" }, // 7
            { "0",
                "[1] Pesan disini!",
                "[2] Reservasi Meja",
                "[3] Laporan Penjualan",
                "[4] Pengaturan Menu",
                "[5] Pengaturan Akun",
                "[6] Ubah Bahasa",
                "[0] Log Out" } };

    static String[][] displayUserMenuMessages = {
        {"0",
            "[1] Order Here!", // 1
            "[2] Table Reservation", // 2
            "[3] Change Language", // 3
            "[0] Log Out" }, // 4
        { "0",
            "[1] Pesan disini!",
            "[2] Reservasi Meja",
            "[3] Ubah Bahasa",
            "[0] Log out" } };

    static String[][] showMenuMessages = { { "0", "\t\t| Number | Menu                  | Price        | Stock  |" },
            { "0", "\t\t| Nomor  | Menu                  | Harga        | Stok   |" } };

    static String[][] orderMenuMessages = {
        { "0",
            "How much menu do you want to order? ", //1 
            "\nWhat would you like to order from Menu #%d? (Use the number on the menu) ", //2
            "Sorry, the stock is currently empty.", // 3
            "The menu is not available, please fill it out again: ", // 4
            "\nMenu %s has been added.\nPlease choose another menu: ", // 5
            "How many %s would you like to order? ", // 6
            "Sorry, our stock cannot fulfill your request at the moment.\nHow many would, you like to order? ", // 7
            "\nThe menu quantity cannot be less than 1!\nHow many would you like to, order? ", // 8
            "\nDo you want to edit the menu? (y/n): ", // 9
            "Which menu number would you like to edit? ", // 10
            "That menu is not the one you selected. Please enter the menu number you want, to edit: ", // 11
            "Menu #%d %s is not the menu you selected. Which menu number would you like, to edit?", // 12
            "How many would you like to order for %s? ", // 13
            "\nSorry, our stock cannot meet your request at the moment!\n", // 14
            "\nThe menu quantity cannot be less than 1!\n", // 15
            "\nThe menu quantity cannot be less than 1!\nHow many would you like to order? ", // 16
            "\nThe total price to be paid: ", // 17
            "Insert your money: ", // 18
            "\nSorry, your money is insufficient.\nPlease enter a different amount: ", // 19
            "\n\n-------------------------Receipt------------------------", // 20
            "Final Total\t:\t\t\t Rp. ", // 21
            "Cash\t\t:\t\t\t  Rp. ", // 22
            "Change \t\t:\t\t\t Rp. ", // 23
            "  \tThank you for your visit\n", // 24
            "The requested number of menu is invalid!\n" //25
        },
        { "0",
            "Berapa banyak menu yang ingin anda pesan? ",
            "\nApa yang ingin anda pesan pada Menu #%d? (Gunakan nomor Pada Menu) ",
            "\nMaaf stock sedang kosong!",
            "Menu tidak tersedia, silahkan isi kembali: ",
            "\nMenu %s sudah ditambahkan\nSilahkan pilih menu yang lain: ",
            "Berapa banyak anda ingin memesan %s? ",
            "\nMaaf stock kami belum bisa memenuhi permintaan anda!\nBerapa banyak anda ingin memesan? ",
            "\nNominal menu tidak bisa kurang dari 1!\nBerapa banyak anda ingin memesannya? ",
            "\nApakah anda ingin mengedit menu? (y/n): ",
            "Menu nomor berapa yang anda ingin edit? ",
            "Menu tersebut bukan menu yang telah anda pilih, masukkan nomor menu yang ingin anda edit: ",
            "Menu #%d %s bukanlah menu yang telah anda pilih, menu nomor berapa yang ingin anda edit? ",
            "Berapa banyak anda ingin memesan %s? ",
            "\nMaaf stock kami belum bisa memenuhi permintaan anda!\n",
            "\nNominal menu tidak bisa kurang dari 1!\n",
            "\nNominal menu tidak bisa kurang dari 1!\nBerapa banyak anda ingin memesannya? ",
            "\nTotal harga yang harus dibayarkan : ",
            "Masukkan uang anda : ",
            "\nMaaf uang anda kurang.\nSilahkan memasukkan nominal lain: ",
            "\n\n-------------------------Struk------------------------",
            "Total Akhir\t:\t\t\t  Rp. ",
            "Cash\t\t:\t\t\t  Rp. ",
            "Kembalian\t:\t\t\t  Rp. ",
            "  \tTerima Kasih Atas Kunjungan Anda\n",
            "Nomor menu yang diminta tidak valid!\n"}};
    
    static String[][] salesReportMenuMessages = {
        { "0",
            "\nSales Report: ", // 1
            "[1] Order Menu\n[2] Reservation Table\n[0] Back to Main Menu", // 2
            "Select menu:  ", // 3
            "Invalid Input."}, // 4
        { "0",
            "\nLaporan Penjualan: ",
            "[1] Pemesanan Menu\n[2] Reservasi Meja\n[0] Kembali ke Main Menu",
            "Pilih menu: ",
            "Input Tidak Valid" } };

    static String[][] showSalesReportMessages = {
        { "0",
            "\nSales Report:", // 1
            "\nOrder #%d:\n", // 2
            "Menu: ", // 3
            "Order Date: ", // 4
            "Order Quantity: ", // 5
            "Admin: ", // 6
            "ID Menu: ", // 7
            "Unit Price: ", // 8
            "Total Price: ", // 9
            "Total Revenue: ", // 10
            "No sales report available!\n" }, // 11
        { "0",
            "\nLaporan Penjualan:",
            "\nPenjualan #%d:\n",
            "Menu: ",
            "Tanggal Pemesanan: ",
            "Admin: ",
            "ID Menu: ",
            "Jumlah Pesanan: ",
            "Harga Satuan: ",
            "Total Harga: ",
            "Total pendapatan: ",
            "Tidak ada laporan penjualan!\n" } };

    static String[][] showAdminMenuMessages = {
        { "0",
            "\n===== Table Reservation =====", // 1
            "[1] Table Settings", // 2
            "[2] Table List", // 3
            "[3] Reserve a Table", // 4
            "[4] Delete Table Order", // 5
            "[0] Back to main menu", // 6
            "Select menu: ", // 7
            "Invalid option, please select again." }, // 8
        { "0",
            "\n====== Pemesanan Meja ======",
            "[1] Pengaturan Meja",
            "[2] Daftar Meja",
            "[3] Pesan Meja",
            "[4] Hapus Meja",
            "[0] Kembali ke Menu Utama",
            "Pilih menu: ",
            "Opsi tidak valid, harap pilih lagi." } };

    static String[][] showUserMenuMessages = {
            { "0",
                 "\n===== Table Reservation =====", // 1
                "[1] Table List", // 2
                "[2] Reserve a Table", // 3
                "[3] Delete Table Order", // 4
                "[0] Back to main menu", // 5
                "Select menu: ", // 6
                "Invalid option, please select again." }, // 7
            { "0",
                "\n====== Pemesanan Meja ======", 
                "[1] Daftar Meja", 
                "[2] Pesan Meja", 
                "[3] Hapus Meja",
                "[0] Kembali ke Menu Utama", 
                "Pilih menu: ", 
                "Opsi tidak valid, harap pilih lagi." } };

    static String[][] tableSettingsMessages = { { "0", "Please enter the number of tables: " },
            { "0", "Silakan masukkan jumlah meja: " } };

    static String[][] tableListMessages = {
            { "0",
                "\nTable List:", // 1
                "Available",  // 2
                "Not Available", // 3
                "Table ", // 4
                "Please set available table at admin menu first." }, // 5
            { "0", 
                "\nDaftar Meja:", 
                "Tersedia", 
                "Tidak Tersedia", 
                "Meja ",
                "Harap atur meja yang tersedia pada menu admin terlebih dahulu." } };

    static String[][] reserveTableMessages = {
        { "0", 
            "Select the table number you want to book: ", // 1
            "Invalid Table Number.\n", // 2
            "\nInsert Reservation Date: ", // 3
            "Hour: ", // 4
            "\nHour Invalid.", // 5
            "Date: ", // 6
            "\nDate Invalid.", // 7
            "Month: ", // 8
            "\nMonth Invalid.", // 9
            "Year: ", // 10
            "\nYear Invalid.", // 11
            "\nPayment Method: \n[1] Cash 50.000\n[2] DP 25.000\n\nChoose your payment method (1/2): ", // 12
            "Invalid Input.\nPlease choose valid payment method.", // 13
            "\nPayment: Cash 50.000", // 14
            "Insert your money: ", // 15
            "\nSorry, your money is insufficient.", // 16
            "Your change: ", // 17
            "\nPayment: Down Payment 25.000", // 18
            "Insert your money: ", // 19
            "\nSorry, your money is insufficient.", // 20
            "Your change: " // 21
            },   
        { "0",
            "Masukkan meja yang ingin anda pesan: ",
            "Nomor Meja Tidak Valid.\n",
            "\nMasukkan Tanggal Reservasi: ",
            "Jam: ",
            "\nJam Tidak Valid.",
            "Tanggal: ",
            "\nTanggal Tidak Valid",
            "Bulan: ",
            "\nBulan Tidak Valid",
            "Tahun: ",
            "\nTahun Tidak Valid",
            "Metode Pembayaran: \n[1] Cash 50.00\n[2] DP 25.000\n\nPilih metode pemybayaran anda (1/2): ",
            "Input Tidak Valid.\nSilahkan pilih metode pembayaran yang valid.",
            "\nPembayaran: Cash 50.000",
            "Masukkan uang anda: ",
            "\nMaaf uang anda kurang.",
            "Kembalian anda: ",
            "\nPembayaran: Down Payment 25.000",
            "Masukkam uang anda: ",
            "\nMaaf yang anda kurang.",
            "Kembalian anda: "
        } };
    
    static String[][] showStrukReservationMessages = {
        {"0",
            "\n\n-------------------------Receipt------------------------", // 1
            "Table Number\t  : \t\t  ", // 2
            "Order Date\t  : \t\t  ", // 3
            "Reservation Date : \t\t  ", // 4
            "Cash\t\t:\t\t  Rp. ", // 5
            "Change\t:\t\t  Rp. ", // 6
            "  \tThank you for your visit\n" //  7

        },
        {"0",
            "\n\n-------------------------Struk------------------------",
            "Nomor Meja\t  : \t\t  ",
            "Tanggal Order\t  : \t\t  ",
            "Tanggal Reservasi : \t\t  ",
            "Cash\t\t:\t\t  Rp. ",
            "Kembalian\t:\t\t  Rp. ",
            "  \tTerima Kasih Atas Kunjungan Anda\n"
        }
    };

    static String[][] showSalesReportReservationMessages = {
        {"0",
            "Sales Report:", // 1
            "\nOrder Table #%d:\n", // 2
            "Booking Date: ", // 3
            "Reservation Date: ", // 4
            "Table Number: ", // 5
            "Cashier: ", // 6
            "Income: ", // 7
            "Total Profit: ", // 8
            "\"No sales report available!\\n" // 9
        },
        {"0",
            "Laporan Penjualan: ",
            "\nPemesanan Meja #%d:\n",
            "Tanggal Pemesanan: ",
            "Tanggal Reservasi: ",
            "Nomor Meja: ",
            "Kasir: ",
            "Pemasukan: ",
            "Total Pendapatan: ",
            "Tidak ada laporan penjualan!\n"
        }
    };

    static String[][] deleteReservationTableNumberMessages = {
            { "0", 
                "Enter the table number you want to cancel: ", // 1
                "Table Reservation ", // 2
                " successfully cancelled.", // 3
                "Refundable advance: ", // 4
                "Table not reserved." }, // 5
            { "0", 
                "Masukkan nomor meja yang ingin Anda batalkan: ", 
                "Pemesanan meja ", 
                " berhasil dibatalkan.",
                "uang muka yang dapat dikembalikan: ", 
                "Meja tidak dipesan." } };

    static String[][] getUserInputIntMessages = { { "0", "Please enter a valid number." },
            { "0", "Harap masukan nomor yang valid." } };

    static String[][] displayAccountSettingsMenuMessages = {
            { "0", 
                "\nAccount Settings :", // 1
                "[1] View All Account", // 2
                "[2] Register New Account", // 3
                "[3] Change Username Account", // 4
                "[4] Change Account Password", // 5
                "[5] Delete Account", // 6
                "[0] Back to Main Menu",  // 7
                "Select the settings: " }, // 8
            { "0",
                "\nPengaturan Akun :", 
                "[1] Lihat Semua Akun", 
                "[2] Daftar Akun Baru", 
                "[3] Ubah Nama Akun",
                "[4] Ubah Kata Sandi Akun", 
                "[5] Hapus Akun", 
                "[0] Kembali ke Menu Utama", 
                "Pilih pengaturan: " } };

    static String[][] viewAllAccountsMessages = { { "0", "\nView All Account : " }, { "0", "\nLihat Semua Akun: " } };

    static String[][] registerNewAccountMessages = {
            { "0",
                "\nRegister New Account ", // 1
                "Enter a new username : ", // 2
                "Enter a new password : ", // 3
                "Account added successfully.", // 4
                "Account limit reached. Cannot add more accounts." }, // 5
            { "0",
                "\nDaftar Akun Baru ", 
                "Masukkan nama pengguna baru: ", 
                "Masukkan kata sandi baru: ",
                "Akun berhasil ditambahkan.",
                "Batas jumlah akun tercapai. Tidak dapat menambahkan lebih banyak akun." } };

    static String[][] changeUsernameMessages = {
            { "0",
                "\nChange Username Account : ", // 1
                "Select the account you want to change the username : ", // 2
                "Enter a new username : ", // 3
                "Username changed successfully.", // 4
                "Cannot change the username for the default account." }, // 5
            { "0",
                "\nUbah Nama Pengguna Akun: ", 
                "Pilih akun yang ingin Anda ubah nama penggunanya: ",
                "Masukkan nama pengguna baru: ", 
                "Nama pengguna berhasil diubah.",
                "Tidak dapat mengubah nama pengguna untuk akun default." }};

    static String[][] changePasswordMessages = {
            { "0",
                "\nChange Password Account: ", // 1
                "Select the account you want to change the password : ", // 2
                "Enter a new password : ", // 3
                "Password changed successfully.", // 4
                "Cannot change the password for the default account." }, // 5
            { "0","\nUbah Kata Sandi Pengguna Akun: ",
                "Pilih akun yang ingin Anda ubah kata sandinya: ",
                "Masukkan kata sandi baru: ",
                "Kata sandi berhasil diubah.",
                "Tidak dapat mengubah kata sandi untuk akun default." } };

    static String[][] deleteAccountMessages = {
            { "0", 
                "\nDelete Account", // 1
                "Available Account to Delete:",  // 2 
                "Select account to delete : ", // 3
                "Delete successfully.", // 4
                "You cannot delete the admin account.", // 5
                "Account doesn't exist!", // 6
                "Invalid account. Please enter a valid account.", // 7
                "\nThere are no available account to delete" }, // 8
            { "0", 
                "\nHapus Akun", 
                "Akun yang Tersedia untuk Dihapus:", 
                "Pilih akun yang ingin dihapus: ",
                "Hapus akun berhasil.", 
                "Anda tidak dapat menghapus akun admin.", 
                "Akun tidak ada!",
                "Akun tidak valid. Harap masukkan akun yang valid.",
                "\nTidak ada akun yang tersedia untuk dihapus" } };

    static String[][] doUpdateStockMessages = {
            { "0", 
                "\nUpdate Stock: ", // 1
                "\nSelect the menu you want to update (use the number) : ", // 2
                "The input you entered is incorrect!\nEnter the menu you want to update: ", // 3
                "Enter the change in stock for %s {%d} : ", // 4
                "Stock cannot be less than 0!\nPlease enter the change in stock: ", // 5
                "\nStock updated." }, // 6
            { "0", 
                "\nPerbarui Stok: ", 
                "\nPilih menu yang ingin Anda perbarui (gunakan angka): ",
                "Input yang anda masukkan salah!\nMasukkan menu yang ingin di perbarui: ",
                "Masukkan perubahan stock dari %s {%d} : ",
                "Stock tidak bisa kurang dari 0!\nSilahkan masukkan perubahan stock: ",
                "\nStock telah diperbarui." } };

    static String[][] doChangePriceMessages = {
            { "0", 
                "\nChange Price", // 1
                "\nSelect the menu you want to update (use the number) : ", // 2
                "The input you entered is incorrect!\nEnter the menu you want to update: ", // 3
                "Enter the change in price for %s {%d} : ", // 4
                "Price cannot be less than 0!\nPlease enter the change in price: ", //5
                "\nPrice updated." }, // 6
            { "0", 
                "\nUbah Harga", 
                "\nPilih menu yang ingin Anda perbarui (gunakan angka): ",
                "Input yang anda masukkan salah!\nMasukkan menu yang ingin di perbarui: ",
                "Masukkan perubahan harga dari %s {%d} : ",
                "Stock tidak bisa kurang dari 0!\nSilahkan masukkan perubahan stock: ",
                "\nStock telah diperbarui." } };

    static String[][] doAddMenuMessages = {
            { "0", 
                "\nAdd New Menu", // 1
                "Enter the new menu name: ", // 2
                "Menu has already been added! Please enter the new menu name: ", // 3
                "Enter the initial price for %s: ", // 4
                "\nSorry, the price for the new menu cannot be less than 1 rupiah\nPlease, enter the price: ", // 5
                "Enter the initial stock for %s: ", // 6
                "Sorry, the stock for the new menu cannot be less than 0\nPlease enter the, initial stock: " }, // 7
            { "0",
                "\nTambah Menu Baru", 
                "Masukkan nama menu baru: ",
                "Menu sudah ditambahkan! Silahkan masukkan nama menu baru: ", 
                "Masukkan harga awal untuk %s: ",
                "\nMaaf, harga untuk menu baru tidak bisa kurang dari 1 rupiah\nSilahkan masukkan harga: ",
                "Masukkan stock awal untuk %s: ",
                "Maaf, stock untuk menu baru tidak bisa kurang dari 0\nSilahkan masukkan stock awal: " } };

    static String[][] doDeleteMessages = {
            { "0", 
                "Delete Menu", // 1
                "Enter the number of the menu you want to delete: ", // 2
                "Are you sure [y/n]? ", // 3
                "\nInvalid input.\nEnter the number of the menu you want to delete: " //4
            },
            { "0", 
                "Hapus Menu", 
                "Masukkan menu nomor berapa yang ingin anda hapus: ", 
                "Apakah anda yakin [y/n]? ",
                "\nInput tidak valid.\nMasukkan menu nomor berapa yang ingin anda hapus: "}};
    /*
     * Clear Terminal
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /*
     * Login System
     */
    public static int userIndex = -1;
    public static String username, password;
    public static boolean isLoggedin = false;

    public static void logInSystem() {
        userIndex = -1;
        isLoggedin = false;
        backMenu = false;

        System.out.println("\n+-----------------------------------------+");
        System.out.println("|                LOG IN                   |");
        System.out.println("+-----------------------------------------+");

        System.out.print("Username\t: ");
        username = sc.nextLine();

        for (int i = 0; i < account.length; i++) {
            if (username.equals(account[i][0])) {
                userIndex = i;
                break;
            }
        }
        if (userIndex >= 0) {
            System.out.print("Password\t: ");
            password = sc.nextLine();
            if (password.equals(account[userIndex][1])) {
                clearScreen();
                System.out.println(logInMessages[selectedBahasa][1]);
                isLoggedin = true;
            } else {
                clearScreen();
                System.out.println(logInMessages[selectedBahasa][2]);
                backMenu = true;
            }
        } else {
            clearScreen();
            System.out.println(logInMessages[selectedBahasa][3]);
            backMenu = true;
        }
    }

    /*
     * Main Menu
     */
    public static boolean backMenu = false;
    public static String inputMenu;

    public static void menu() {
        loopAccountSettings = false;
        loopMenuSettings = false;
        loopReservation = false;
        System.out.println(menuMessages[selectedBahasa][1]);
        System.out.println("-------------------- MAIN MENU --------------------");

        if (userIndex == 0) {
            displayMainMenu();
        } else if (userIndex > 0) {
            displayUserMenu();
        }

        System.out.print(menuMessages[selectedBahasa][2]);
        inputMenu = sc.nextLine();
        switch (inputMenu) {
            case "0":
                isLoggedin = false;
                backMenu = true;
                break;
            case "1":
                showMenu(menuArr, hargaIsBanyakTotalMenuArr, stockMenuArr);
                orderMenu();
                break;
            case "2":
                reservationMenu();
                break;
            case "3":
                if (userIndex == 0) {
                    salesReportMenu();
                break;
                } else {
                    changeLanguage();
                }
                break;

            case "4":
                while (!loopMenuSettings) {
                    System.out.println(menuMessages[selectedBahasa][3]);
                    System.out.println(menuMessages[selectedBahasa][4]);
                    System.out.println(menuMessages[selectedBahasa][5]);
                    System.out.println(menuMessages[selectedBahasa][6]);
                    System.out.println(menuMessages[selectedBahasa][7]);
                    System.out.println(menuMessages[selectedBahasa][8]);
                    System.out.println(menuMessages[selectedBahasa][9]);
                    System.out.print(menuMessages[selectedBahasa][10]);
                    String inputMenuSettings = sc.nextLine();
                    sc.nextLine();
                    switch (inputMenuSettings) {
                        case "0":
                            loopMenuSettings = true;
                            break;

                        case "1":
                            showMenu(menuArr, hargaIsBanyakTotalMenuArr, stockMenuArr);
                            break;

                        case "2":
                            doUpdateStock(menuArr, stockMenuArr, sc);
                            break;

                        case "3":
                            doChangePrice(menuArr, hargaIsBanyakTotalMenuArr, sc);
                            break;
                        case "4":
                            // Deklarasi array temporary
                            String[] tempMenuArr = new String[menuArr.length + 1]; // +1 kolom
                            int[][] tempHargaIsBanyakTotalMenuArr = new int[hargaIsBanyakTotalMenuArr[0].length][tempMenuArr.length]; // +1
                                                                                                                                      // kolom
                                                                                                                                      // dari
                                                                                                                                      // tempMenuArr.length
                                                                                                                                      // yang
                                                                                                                                      // telah
                                                                                                                                      // dideklarasi
                                                                                                                                      // sebelumnya
                            int[] tempStockMenuArr = new int[tempMenuArr.length]; // +1 kolom dari deklarasi
                                                                                  // tempMenuArr

                            doAddMenu(menuArr, hargaIsBanyakTotalMenuArr, stockMenuArr, sc, tempMenuArr,
                                    tempHargaIsBanyakTotalMenuArr, tempStockMenuArr);

                            menuArr = tempMenuArr;
                            hargaIsBanyakTotalMenuArr = tempHargaIsBanyakTotalMenuArr;
                            stockMenuArr = tempStockMenuArr;
                            break;

                        case "5":
                            String[] tempMinusMenuArr = new String[menuArr.length - 1];
                            int[][] tempMinusHargaIsBanyakTotalMenuArr = new int[hargaIsBanyakTotalMenuArr.length][tempMinusMenuArr.length];
                            int[] tempMinusStockMenuArr = new int[tempMinusMenuArr.length];

                            showMenu(menuArr, hargaIsBanyakTotalMenuArr, stockMenuArr);

                            isMenuDeleted = doDeleteMenu(menuArr, hargaIsBanyakTotalMenuArr, stockMenuArr, sc,
                                    tempMinusMenuArr, tempMinusHargaIsBanyakTotalMenuArr, tempMinusStockMenuArr);

                            if (isMenuDeleted) {
                                menuArr = tempMinusMenuArr;
                                stockMenuArr = tempMinusStockMenuArr;
                                hargaIsBanyakTotalMenuArr = tempMinusHargaIsBanyakTotalMenuArr;
                                isMenuDeleted = false;
                            }

                            break;

                        default:
                            break;
                    }
                }
                break;

            case "5":
                while (!loopAccountSettings) {
                    displayAccountSettingsMenu();
                    int inputAccount = sc.nextInt();
                    sc.nextLine();

                    switch (inputAccount) {
                        case 0:
                            loopAccountSettings = true;
                            break;
                        case 1:
                            viewAllAccounts();
                            break;
                        case 2:
                            registerNewAccount();
                            break;
                        case 3:
                            changeUsername();
                            break;
                        case 4:
                            changePassword();
                            break;
                        case 5:
                            deleteAccount();
                            break;
                        default:
                            System.out.println(menuMessages[selectedBahasa][10]);
                    }
                }
                break;
            
            case "6":
                changeLanguage();
                break;

            default:
                System.out.println(menuMessages[selectedBahasa][11]);
                break;
        }
    }

    public static void displayMainMenu() {
        System.out.println(displayMainMenuMessages[selectedBahasa][1]);
        System.out.println(displayMainMenuMessages[selectedBahasa][2]);
        System.out.println(displayMainMenuMessages[selectedBahasa][3]);
        System.out.println(displayMainMenuMessages[selectedBahasa][4]);
        System.out.println(displayMainMenuMessages[selectedBahasa][5]);
        System.out.println(displayMainMenuMessages[selectedBahasa][6]);
        System.out.println(displayMainMenuMessages[selectedBahasa][7]);
    }

    public static void displayUserMenu() {
        System.out.println(displayUserMenuMessages[selectedBahasa][1]);
        System.out.println(displayUserMenuMessages[selectedBahasa][2]);
        System.out.println(displayUserMenuMessages[selectedBahasa][3]);
        System.out.println(displayUserMenuMessages[selectedBahasa][4]);
    }

    /*
     * Order System
     */
    public static int jumlahMenu, scMenu, uangPembeli;
    public static int uangKembalian = 0, totalMenuFinal = 0;
    public static String[] menuArr = { "Nasi Goreng", "Sate", "Sayur Lodeh", "Sayur Asem", "Ayam Geprek", "Teh Anget",
            "Jeruk", "Susu Soda" };
    public static int[][] hargaIsBanyakTotalMenuArr = { { 10000, 15000, 8000, 8000, 10000, 5000, 5000, 5000 },
            { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }
    };
    public static int isDeleteMenu = 0;
    public static int[] stockMenuArr = { 35, 20, 1, 10, 25, 509, 5320, 20 };
    public static int[][] tempMinusHargaIsBanyakTotalMenuArr = new int[hargaIsBanyakTotalMenuArr.length][hargaIsBanyakTotalMenuArr[0].length
            - 1];
    public static int[] tempMinusStockMenuArr = new int[stockMenuArr.length - 1];
    public static String[] tempMinusMenuArr = new String[menuArr.length - 1];
    public static boolean isDeletedMenu = false;

    public static void showMenu(String[] menuArr, int[][] hargaIsBanyakTotalMenuArr, int[] stockMenuArr) {
        System.out.println("\t\t+--------------------------------------------------------+");
        System.out.println(showMenuMessages[selectedBahasa][1]);
        System.out.println("\t\t+--------------------------------------------------------+");
        for (int j = 0; j < menuArr.length; j++) { // Perulangan Daftar Menu
            System.out.printf("\t\t| %6d | %-15s  \t | Rp. %-5d\t| %-6d |\n", j + 1, menuArr[j],
                    hargaIsBanyakTotalMenuArr[0][j], stockMenuArr[j]);
        }
        System.out.println("\t\t+--------------------------------------------------------+\n");
    }

    public static void orderMenu() {
        int[][] resetHargaIsBanyakTotalMenuArr = { hargaIsBanyakTotalMenuArr[0],
                { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 } };
        hargaIsBanyakTotalMenuArr = resetHargaIsBanyakTotalMenuArr;
        totalMenuFinal = 0;
        System.out.print(orderMenuMessages[selectedBahasa][1]);

        while (true) {
            jumlahMenu = sc.nextInt();
            if (jumlahMenu > menuArr.length | jumlahMenu < 1) {
                System.out.println(orderMenuMessages[selectedBahasa][25]);
                System.out.print(orderMenuMessages[selectedBahasa][1]);
                continue;
            } else break;
        }

        // Perulangan sesuai input jumlahMenu
        int i = 1;
        while (jumlahMenu >= i) {

            // Validasi apakah menu yang dipesan memiliki stock 0 atau tidak
            while (true) {
                doShowOrderedMenu();

                System.out.printf(orderMenuMessages[selectedBahasa][2], i);
                scMenu = sc.nextInt();

                while (scMenu > menuArr.length || scMenu < 1
                        || hargaIsBanyakTotalMenuArr[1][scMenu - 1] != 0) {
                    // Mengecek kesesuaian input tidak lebih dari menu atau tidak 0
                    if (scMenu > menuArr.length || scMenu < 1 || stockMenuArr[scMenu - 1] == 0) {
                        System.out.print(orderMenuMessages[selectedBahasa][4]);
                        scMenu = sc.nextInt();
                    } else { // Mengecek menu jika sudah pernah ditambahkan
                        System.out.printf(
                                orderMenuMessages[selectedBahasa][4],
                                menuArr[scMenu - 1]);
                        scMenu = sc.nextInt();
                    }
                }

                if (stockMenuArr[scMenu - 1] < 1) {
                    System.out.print(orderMenuMessages[selectedBahasa][3]);
                    continue;
                } else
                    break;

            }

            // Input elemen array banyak menu tiap menu
            System.out.printf(orderMenuMessages[selectedBahasa][6], menuArr[scMenu - 1]);

            while (true) { // Validasi input dengan stock yang tersedia
                int isValidWithStock = sc.nextInt();
                sc.nextLine();
                if (stockMenuArr[scMenu - 1] < isValidWithStock) {
                    System.out.print(
                            orderMenuMessages[selectedBahasa][7]);
                    continue;
                } else if (isValidWithStock <= 0) {
                    System.out.print(orderMenuMessages[selectedBahasa][8]);
                    continue;
                } else {
                    hargaIsBanyakTotalMenuArr[1][scMenu - 1] = isValidWithStock;
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
            doShowOrderedMenu();
            System.out.print(orderMenuMessages[selectedBahasa][9]);
            String isEditMenu = sc.nextLine();
            if (isEditMenu.equalsIgnoreCase("y")) {
                System.out.print(orderMenuMessages[selectedBahasa][10]);
                int noEditMenu = sc.nextInt();

                // Pengecekan input noEditMenu apabila input tidak sesuai
                boolean isTruee = true;
                while (isTruee) {
                    if (noEditMenu > hargaIsBanyakTotalMenuArr[1].length || noEditMenu < 1) {
                        System.out.print(
                                orderMenuMessages[selectedBahasa][11]);
                        noEditMenu = sc.nextInt();
                    } else if (hargaIsBanyakTotalMenuArr[1][noEditMenu - 1] == 0) {
                        System.out.printf(
                                orderMenuMessages[selectedBahasa][11],
                                noEditMenu, menuArr[noEditMenu - 1]);
                        noEditMenu = sc.nextInt();
                    } else
                        isTruee = false;
                }

                // Validasi
                while (true) {
                    System.out.printf(orderMenuMessages[selectedBahasa][13],
                            menuArr[noEditMenu - 1]);
                    int isValidWithStock = sc.nextInt();
                    sc.nextLine();

                    if (stockMenuArr[noEditMenu - 1] < isValidWithStock) {
                        System.out.print(
                                orderMenuMessages[selectedBahasa][14]);
                        continue;
                    } else if (isValidWithStock <= 0) {
                        System.out.print(
                                orderMenuMessages[selectedBahasa][15]);
                        continue;
                    } else {
                        hargaIsBanyakTotalMenuArr[1][noEditMenu - 1] = isValidWithStock;
                        break;
                    }
                }

                // Mengecek kesesuaian banyaknya menu, sehingga tidak 0
                while (hargaIsBanyakTotalMenuArr[1][noEditMenu - 1] <= 0) {
                    System.out.print(
                            orderMenuMessages[selectedBahasa][16]);
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

        System.out.println(orderMenuMessages[selectedBahasa][17] + totalMenuFinal);
        System.out.print(orderMenuMessages[selectedBahasa][18]);
        uangPembeli = sc.nextInt();
        sc.nextLine();

        while (uangPembeli < totalMenuFinal) {
            System.out.print(orderMenuMessages[selectedBahasa][19]);
            uangPembeli = sc.nextInt();
            sc.nextLine();

        }

        uangKembalian = uangPembeli - totalMenuFinal;

        System.out.println(orderMenuMessages[selectedBahasa][20]);
        for (int j = 0; j < menuArr.length; j++) {
            if (hargaIsBanyakTotalMenuArr[2][j] != 0) {

                // Deklarasi Date
                LocalDateTime currentDateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedDateTime = currentDateTime.format(formatter);

                /// Memasukkan data sale report kedalam array
                String[] tempSalesMenuArr = new String[totalOrders + 1];
                String[] tempSalesDateReportArr = new String[totalOrders + 1];
                String[] tempSalesAdminArr = new String[totalOrders + 1];
                int[][] tempSalesIdQtyPriceTotalArr = new int[totalOrders + 1][4];

                for (int k = 0; k < salesMenuArr.length; k++) {
                    tempSalesMenuArr[k] = salesMenuArr[k];
                    tempSalesDateReportArr[k] = salesDateReportArr[k];
                    tempSalesAdminArr[k] = salesAdminArr[k];
                    tempSalesIdQtyPriceTotalArr[k][0] = salesIdQtyPriceTotalArr[k][0]; // ID menu
                    tempSalesIdQtyPriceTotalArr[k][1] = salesIdQtyPriceTotalArr[k][1]; // jumlah
                                                                                       // pesanan
                    tempSalesIdQtyPriceTotalArr[k][2] = salesIdQtyPriceTotalArr[k][2]; // Harga
                                                                                       // satuan
                    tempSalesIdQtyPriceTotalArr[k][3] = salesIdQtyPriceTotalArr[k][3]; // Total
                                                                                       // harga
                }

                tempSalesMenuArr[tempSalesMenuArr.length - 1] = menuArr[j];
                tempSalesDateReportArr[tempSalesDateReportArr.length - 1] = formattedDateTime;
                tempSalesAdminArr[tempSalesAdminArr.length - 1] = username; // Admin yang melayani
                tempSalesIdQtyPriceTotalArr[totalOrders][0] = totalOrders + 1; // ID menu
                tempSalesIdQtyPriceTotalArr[totalOrders][1] = hargaIsBanyakTotalMenuArr[1][j]; // Jumlah
                                                                                               // pesanan
                tempSalesIdQtyPriceTotalArr[totalOrders][2] = hargaIsBanyakTotalMenuArr[0][j]; // Harga
                                                                                               // satuan
                tempSalesIdQtyPriceTotalArr[totalOrders][3] = hargaIsBanyakTotalMenuArr[2][j]; // Total
                                                                                               // harga

                salesMenuArr = tempSalesMenuArr;
                salesDateReportArr = tempSalesDateReportArr;
                salesAdminArr = tempSalesAdminArr;
                salesIdQtyPriceTotalArr = tempSalesIdQtyPriceTotalArr;
                ///

                // Menampilkan struk
                System.out.printf("%s    \t: %d  x  Rp. %d\t= Rp. %d\n", menuArr[j],
                        hargaIsBanyakTotalMenuArr[1][j],
                        hargaIsBanyakTotalMenuArr[0][j],
                        hargaIsBanyakTotalMenuArr[2][j]);

                totalOrders++;
            }
        }
        System.out.println("------------------------------------------------------");
        System.out.println(orderMenuMessages[selectedBahasa][21] + totalMenuFinal);
        System.out.println(orderMenuMessages[selectedBahasa][22] + uangPembeli);
        System.out.println(orderMenuMessages[selectedBahasa][23] + uangKembalian);
        System.out.println("------------------------------------------------------");
        System.out.println(orderMenuMessages[selectedBahasa][24]);

        // Menambah totalMenuFinal kedalam variabel total profit
        totalProfit += totalMenuFinal;

        // Pengurangan stock
        for (int j = 0; j < stockMenuArr.length; j++) {
            stockMenuArr[j] -= hargaIsBanyakTotalMenuArr[1][j];
        }

        backMenu = false;
    }

    /*
     * Sales Report
     */
    public static int totalOrders = 0;
    public static int[][] salesIdQtyPriceTotalArr = new int[totalOrders + 1][4];
    public static String[] salesMenuArr = new String[totalOrders + 1];
    public static String[] salesDateReportArr = new String[totalOrders + 1];
    public static String[] salesAdminArr = new String[totalOrders + 1];
    public static double totalProfit = 0;
    
    public static void salesReportMenu() {
        boolean loopSalesReport = false;
        System.out.println(salesReportMenuMessages[selectedBahasa][1]);
        System.out.println(salesReportMenuMessages[selectedBahasa][2]);
        while (!loopSalesReport) {
            System.out.print(salesReportMenuMessages[selectedBahasa][3]);
            String isSalesReport = sc.nextLine();
            switch (isSalesReport) {
                case "0":
                    loopSalesReport = true;
                    break;
                case "1":
                    showSalesReportOrderMenu(totalOrders, salesMenuArr, salesDateReportArr, salesAdminArr,
                            salesIdQtyPriceTotalArr, totalProfit);
                    loopSalesReport = true;
                    break;
                case "2":
                    showSalesReportReservation();
                    loopSalesReport = true;
                    break;
                default:
                    System.out.println(salesReportMenuMessages[selectedBahasa][4]);
            }
        }
    }

    public static void showSalesReportOrderMenu(int totalOrders, String[] salesMenuArr, String[] salesDateReportArr,
            String[] salesAdminArr, int[][] salesIdQtyPriceTotalArr, double totalProfit) {
        System.out.println(showSalesReportMessages[selectedBahasa][1]);

        if (totalOrders > 0) {
            for (int j = 0; j < totalOrders; j++) {
                System.out.printf(showSalesReportMessages[selectedBahasa][2], j + 1);
                System.out.println(showSalesReportMessages[selectedBahasa][3] + salesMenuArr[j]);
                System.out.println(showSalesReportMessages[selectedBahasa][4] + salesDateReportArr[j]);
                System.out.println(showSalesReportMessages[selectedBahasa][5] + salesAdminArr[j]);
                System.out.println(showSalesReportMessages[selectedBahasa][6] + salesIdQtyPriceTotalArr[j][0]);
                System.out.println(showSalesReportMessages[selectedBahasa][7] + salesIdQtyPriceTotalArr[j][1]);
                System.out.println(showSalesReportMessages[selectedBahasa][8] + salesIdQtyPriceTotalArr[j][2]);
                System.out.println(showSalesReportMessages[selectedBahasa][9] + salesIdQtyPriceTotalArr[j][3]);
                System.out.println("-------------------------------------");
            }

            System.out.println(showSalesReportMessages[selectedBahasa][10] + totalProfit);

        } else {
            System.out.println(showSalesReportMessages[selectedBahasa][11]);
        }
    }

    /*
     * Table Reservation
     */
    public static int maxTable; // Jumlah maksimum meja (dapat diatur di dalam menu admin)
    public static boolean[] tableAvailable = new boolean[maxTable];
    public static int[] downPayment = new int[maxTable];
    public static boolean loopReservation = false;
    public static String tableReservation = "";
    public static int totalOrdersReservation = 0;
    public static String[] salesDateReportReservationArr = new String[totalOrdersReservation + 1]; // tanggal pesan
    public static String[] arrivalateArr = new String[totalOrdersReservation + 1]; // tanggal kedatangan
    public static int[] numberTableReservationArr = new int[totalOrdersReservation + 1]; // nomer meja yg di pesan
    public static String[] salesAdminReservationArr = new String[totalOrdersReservation + 1];// melayani
    public static boolean isBayarTunai;
    public static int uangPembeliReservasi;
    public static int uangPembeliReservasiMeja;
    public static int uangKembalianReservasi;
    public static int reservationTableNumber;
    public static String arrivalAtReservation;
    public static int[] incomeReservationArr = new int[totalOrdersReservation + 1];
    public static double totalProfitReservation = 0;

    public static void reservationMenu() {
        while (!loopReservation) {
            if (userIndex == 0) {
                // Admin menu
                showAdminMenu();
            } else {
                // User menu
                showUserMenu();
            }
        }
    }

    public static void showAdminMenu() {
        System.out.println(showAdminMenuMessages[selectedBahasa][1]);
        System.out.println(showAdminMenuMessages[selectedBahasa][2]);
        System.out.println(showAdminMenuMessages[selectedBahasa][3]);
        System.out.println(showAdminMenuMessages[selectedBahasa][4]);
        System.out.println(showAdminMenuMessages[selectedBahasa][5]);
        System.out.println(showAdminMenuMessages[selectedBahasa][6]);
        System.out.print(showAdminMenuMessages[selectedBahasa][7]);
        tableReservation = sc.nextLine();

        switch (tableReservation) {
            case "1":
                tableSettings();
                break;
            case "2":
                tableList();
                break;
            case "3":
                reserveTable();
                break;
            case "4":
                deleteReservationTableNumber();
                break;
            case "0":
                loopReservation = true;
                break;
            default:
                System.out.println(showAdminMenuMessages[selectedBahasa][8]);
                break;
        }
    }

    public static void showUserMenu() {
        System.out.println(showUserMenuMessages[selectedBahasa][1]);
        System.out.println(showUserMenuMessages[selectedBahasa][2]);
        System.out.println(showUserMenuMessages[selectedBahasa][3]);
        System.out.println(showUserMenuMessages[selectedBahasa][4]);
        System.out.println(showUserMenuMessages[selectedBahasa][5]);
        System.out.print(showUserMenuMessages[selectedBahasa][6]);
        tableReservation = sc.nextLine();

        switch (tableReservation) {
            case "1":
                tableList();
                break;
            case "2":
                reserveTable();
                break;
            case "3":
                deleteReservationTableNumber();
                break;
            case "0":
                loopReservation = true;
                break;
            default:
                System.out.println(showUserMenuMessages[selectedBahasa][7]);
                break;
        }
    }

    public static void tableSettings() {
        System.out.print(tableSettingsMessages[selectedBahasa][1]);
        maxTable = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        tableAvailable = new boolean[maxTable];
        downPayment = new int[maxTable];

        // Initialize tables and make it true
        for (int j = 0; j < maxTable; j++) {
            tableAvailable[j] = true;
            downPayment[j] = 0;
        }
    }

    public static void tableList() {
        boolean anyAvailableTable = false;
        System.out.println(tableListMessages[selectedBahasa][1]);
        for (int i = 0; i < maxTable; i++) {
            String status = tableAvailable[i] ? tableListMessages[selectedBahasa][2] : tableListMessages[selectedBahasa][3];
            System.out.println(tableListMessages[selectedBahasa][4] + (i + 1) + " : " + status);
            if (tableAvailable[i]) {
                anyAvailableTable = true;
            }
        }

        if (!anyAvailableTable) {
            System.out.println(tableListMessages[selectedBahasa][5]);
        }
    }

    public static void reserveTable() {
        int jamArrival;
        int tanggalArrival;
        int bulanArrival;
        int tahunArrival;

        while (true) {
            System.out.print(reserveTableMessages[selectedBahasa][1]);
            reservationTableNumber = sc.nextInt();
            if (reservationTableNumber > tableAvailable.length || reservationTableNumber < 1 || tableAvailable[reservationTableNumber - 1] == false) {
                System.out.println(reserveTableMessages[selectedBahasa][2]);
                continue;
            } else
                break;
        }
        sc.nextLine();

        System.out.println(reserveTableMessages[selectedBahasa][3]);
        while (true) {
            System.out.print(reserveTableMessages[selectedBahasa][4]);
            jamArrival = sc.nextInt();
            if (jamArrival < 1 || jamArrival > 24) {
                System.out.println(reserveTableMessages[selectedBahasa][5]);
                continue;
            } else
                break;
        }
        while (true) {
            System.out.print(reserveTableMessages[selectedBahasa][6]);
            tanggalArrival = sc.nextInt();
            if (tanggalArrival < 1 || tanggalArrival > 32) {
                System.out.println(reserveTableMessages[selectedBahasa][7]);
                continue;
            } else
                break;
        }
        while (true) {
            System.out.print(reserveTableMessages[selectedBahasa][8]);
            bulanArrival = sc.nextInt();
            if (bulanArrival < 1 || bulanArrival > 12) {
                System.out.println(reserveTableMessages[selectedBahasa][9]);
                continue;
            } else
                break;
        }
        LocalDateTime currentDateTime = LocalDateTime.now();
        int tahunSekarang = currentDateTime.getYear();

        while (true) {
            System.out.print(reserveTableMessages[selectedBahasa][10]);
            tahunArrival = sc.nextInt();
            sc.nextLine();
            if (tahunArrival < tahunSekarang) {
                System.out.println(reserveTableMessages[selectedBahasa][11]);
                continue;
            } else
                break;
        }

        if (jamArrival < 10) {
            arrivalAtReservation = tahunArrival + "-" + bulanArrival + "-" + tanggalArrival + " " + "0" + jamArrival + ":00";
        } else {
            arrivalAtReservation = tahunArrival + "-" + bulanArrival + "-" + tanggalArrival + " " + jamArrival + ":00";
        }

        boolean paymentMethod = false;
        while (!paymentMethod) {
            System.out.print(reserveTableMessages[selectedBahasa][12]);
            String isDPCash = sc.nextLine();
            switch (isDPCash) {
                case "1":
                    isBayarTunai = true;
                    paymentMethod = true;
                    break;
    
                case "2":
                    isBayarTunai = false;
                    paymentMethod = true;
                    break;
    
                default:
                    System.out.println(reserveTableMessages[selectedBahasa][13]);
                    paymentMethod = false;
                    break;
            }
        }
        if (isBayarTunai == true) {
            System.out.println(reserveTableMessages[selectedBahasa][14]);
            while (true) {
                System.out.print(reserveTableMessages[selectedBahasa][15]);
                uangPembeliReservasi = sc.nextInt();
                sc.nextLine();
                if (uangPembeliReservasi < 50000) {
                    System.out.println(reserveTableMessages[selectedBahasa][16]);
                    continue;
                } else if (uangPembeliReservasi > 50000) {
                    uangKembalianReservasi = uangPembeliReservasi - 50000;
                    System.out.println(reserveTableMessages[selectedBahasa][17] + uangKembalianReservasi);
                    uangPembeliReservasiMeja = 50000;
                    totalProfitReservation += uangPembeliReservasiMeja;
                    break;
                } else
                    uangKembalianReservasi = 0;
                    uangPembeliReservasiMeja = 50000;
                    totalProfitReservation += uangPembeliReservasiMeja;
                    break;

            }
        } else if (isBayarTunai == false) {
            System.out.println(reserveTableMessages[selectedBahasa][18]);
            while (true) {
                System.out.print(reserveTableMessages[selectedBahasa][19]);
                uangPembeliReservasi = sc.nextInt();
                sc.nextLine();
                if (uangPembeliReservasi < 25000) {
                    System.out.println(reserveTableMessages[selectedBahasa][20]);
                    continue;
                } else if (uangPembeliReservasi > 25000) {
                    uangKembalianReservasi = uangPembeliReservasi - 25000;
                    System.out.println(reserveTableMessages[selectedBahasa][21] + uangKembalianReservasi);
                    uangPembeliReservasiMeja = 25000;
                    totalProfitReservation += uangPembeliReservasiMeja;
                    break;
                } else
                    uangKembalianReservasi = 0;
                    uangPembeliReservasiMeja = 25000;
                    totalProfitReservation += uangPembeliReservasiMeja;
                    break;

            }
        }

        tableAvailable[reservationTableNumber - 1] = false;
        showStrukReservation();
    }

    public static void showStrukReservation() {
        // Deklarasi Date
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

        String[] tempSalesDateReportReservationArr = new String[totalOrdersReservation + 1];
        String[] tempArrivalateArr = new String[totalOrdersReservation + 1];
        int[] tempNumberTableReservationArr = new int[totalOrdersReservation + 1];
        String[] tempSalesAdminReservationArr = new String[totalOrdersReservation + 1];
        int[] tempIncomeReservationArr = new int[totalOrdersReservation + 1];

        for (int k = 0; k < incomeReservationArr.length; k++) {
            tempSalesDateReportReservationArr[k] = salesDateReportReservationArr[k];
            tempSalesAdminReservationArr[k] = salesAdminReservationArr[k];
            tempNumberTableReservationArr[k] = numberTableReservationArr[k];
            tempArrivalateArr[k] = arrivalateArr[k];
            tempIncomeReservationArr[k] = incomeReservationArr[k];

        }

        tempSalesDateReportReservationArr[tempSalesDateReportReservationArr.length - 1] = formattedDateTime;
        tempSalesAdminReservationArr[tempSalesAdminReservationArr.length - 1] = username;
        tempNumberTableReservationArr[tempNumberTableReservationArr.length - 1] = reservationTableNumber;
        tempArrivalateArr[tempArrivalateArr.length - 1] = arrivalAtReservation;
        tempIncomeReservationArr[tempIncomeReservationArr.length - 1] = uangPembeliReservasiMeja;

        salesDateReportReservationArr = tempSalesDateReportReservationArr;
        salesAdminReservationArr = tempSalesAdminReservationArr;
        numberTableReservationArr = tempNumberTableReservationArr;
        arrivalateArr = tempArrivalateArr;
        incomeReservationArr = tempIncomeReservationArr;

        ///

        System.out.println(showStrukReservationMessages[selectedBahasa][1]);
        System.out.println(showStrukReservationMessages[selectedBahasa][2] + reservationTableNumber);
        System.out.println(showStrukReservationMessages[selectedBahasa][3] + formattedDateTime);
        System.out.println(showStrukReservationMessages[selectedBahasa][4] + arrivalAtReservation);
        System.out.println("------------------------------------------------------");
        System.out.println(showStrukReservationMessages[selectedBahasa][5] + uangPembeliReservasi);
        System.out.println(showStrukReservationMessages[selectedBahasa][6] + uangKembalianReservasi);
        System.out.println("------------------------------------------------------");
        System.out.println(showStrukReservationMessages[selectedBahasa][7]);

        totalOrdersReservation++;
    }
    

    public static void deleteReservationTableNumber() {
        int deleteReservationTableNumber = getUserInputInt(deleteReservationTableNumberMessages[selectedBahasa][1], 1, maxTable);

        if (!tableAvailable[deleteReservationTableNumber - 1]) {
            tableAvailable[deleteReservationTableNumber - 1] = true;
            int cancelDownPayment = downPayment[deleteReservationTableNumber - 1];
            System.out.println(deleteReservationTableNumberMessages[selectedBahasa][2] + deleteReservationTableNumber + deleteReservationTableNumberMessages[selectedBahasa][3]);
            System.out.println(deleteReservationTableNumberMessages[selectedBahasa][4] + cancelDownPayment / 2);
        } else {
            System.out.println(deleteReservationTableNumberMessages[selectedBahasa][5]);
        }
    }

    public static void showSalesReportReservation(){
        System.out.println(showSalesReportReservationMessages[selectedBahasa][1]);

      if (totalOrdersReservation > 0) {
          for (int j = 0; j < totalOrdersReservation; j++) {
              System.out.printf(showSalesReportReservationMessages[selectedBahasa][2], j + 1);
              System.out.println(showSalesReportReservationMessages[selectedBahasa][3] + salesDateReportReservationArr[j]);
              System.out.println(showSalesReportReservationMessages[selectedBahasa][4] + arrivalateArr[j]);
              System.out.println(showSalesReportReservationMessages[selectedBahasa][5] + numberTableReservationArr[j]);
              System.out.println(showSalesReportReservationMessages[selectedBahasa][6] + salesAdminReservationArr[j]);
              System.out.println(showSalesReportReservationMessages[selectedBahasa][7] + incomeReservationArr[j]);
              System.out.println("-------------------------------------");
          }

          System.out.println(showSalesReportReservationMessages[selectedBahasa][8] + totalProfitReservation);

      } else {
          System.out.println(showSalesReportReservationMessages[selectedBahasa][9]);
      }
  }

    public static int getUserInputInt(String prompt, int min, int max) {
        int userInput;
        do {
            System.out.print(prompt);
            while (!sc.hasNextInt()) {
                System.out.println(getUserInputIntMessages[selectedBahasa][1]);
                sc.next();
            }
            userInput = sc.nextInt();
        } while (userInput < min || userInput > max);
        sc.nextLine();
        return userInput;
    }

    /*
     * Account Settings
     */
    public static String[][] account = {
        {"admin", "admin"}};
    public static String newUsername, newPassword; // variabel untuk menerima input username dan password baru
    public static int changeUsername, changePassword; // variabel untuk menerima input perubahan username atau password
    public static int inputAccount; // variabel untuk menerima input dari menu account settings
    public static int inputDeleteAccount; // variabel untuk menerima akun yang akan dihapus
    public static boolean loopAccountSettings = false; // variabel untuk melakukan looping di dalam menu accound settings
    public static boolean hasAccountToDelete = false; // variabel untuk mengecek apakah ada akun untuk dihapus

    public static void displayAccountSettingsMenu() {
        System.out.println(displayAccountSettingsMenuMessages[selectedBahasa][1]);
        System.out.println(displayAccountSettingsMenuMessages[selectedBahasa][2]);
        System.out.println(displayAccountSettingsMenuMessages[selectedBahasa][3]);
        System.out.println(displayAccountSettingsMenuMessages[selectedBahasa][4]);
        System.out.println(displayAccountSettingsMenuMessages[selectedBahasa][5]);
        System.out.println(displayAccountSettingsMenuMessages[selectedBahasa][6]);
        System.out.println(displayAccountSettingsMenuMessages[selectedBahasa][7]);
        System.out.print(displayAccountSettingsMenuMessages[selectedBahasa][8]);
    }

    public static void viewAllAccounts() {
        System.out.println(viewAllAccountsMessages[selectedBahasa][1]);
        for (int i = 0; i < account.length; i++) {
            if (account[i][0] != null) {
                    System.out.println("[" + (i + 1) + "] " + account[i][0]);
            }
        }
    }

    public static void registerNewAccount() {
        System.out.println(registerNewAccountMessages[selectedBahasa][1]);
        System.out.print(registerNewAccountMessages[selectedBahasa][2]);
        String newUsername = sc.next();
        System.out.print(registerNewAccountMessages[selectedBahasa][3]);
        String newPassword = sc.next();

        boolean added = false;
        String[][] tempAccount = new String[account.length + 1][2];
        
        for (int i = 0; i < account.length; i++) {
            for (int j = 0; j < account[i].length; j++) {
                tempAccount[i][j] = account[i][j];
            }
        }

        for (int i = 0; i < tempAccount.length; i++) {
            if (tempAccount[i][0] == null) {
                tempAccount[i][0] = newUsername;
                tempAccount[i][1] = newPassword;
                added = true;
                break;
            }
        }

        if (added) {
            account = tempAccount;
            System.out.println(registerNewAccountMessages[selectedBahasa][4]);
        } else {
            System.out.println(registerNewAccountMessages[selectedBahasa][5]);
        }
    }

    public static void changeUsername() {
        System.out.println(changeUsernameMessages[selectedBahasa][1]);
        displayAccountsList();

        System.out.print(registerNewAccountMessages[selectedBahasa][2]);
        int changeUsername = sc.nextInt();
        sc.nextLine();

        if (isValidAccountIndex(changeUsername)) {
            if (changeUsername != 0) {
                System.out.print(registerNewAccountMessages[selectedBahasa][3]);
                String newUsername = sc.next();
                account[changeUsername][0] = newUsername;
                System.out.println(registerNewAccountMessages[selectedBahasa][4]);
            } else {
                System.out.println(registerNewAccountMessages[selectedBahasa][5]);
            }
        }
    }

    public static void changePassword() {
        System.out.println(changePasswordMessages[selectedBahasa][1]);
        displayAccountsList();

        System.out.print(changePasswordMessages[selectedBahasa][2]);
        int changePassword = sc.nextInt();
        sc.nextLine();

        if (isValidAccountIndex(changePassword)) {
            if (changePassword != 0) {
                System.out.print(changePasswordMessages[selectedBahasa][3]);
                String newPassword = sc.next();
                account[changePassword][1] = newPassword;
                System.out.println(changePasswordMessages[selectedBahasa][4]);
            } else {
                System.out.println(changePasswordMessages[selectedBahasa][5]);
            }
        }
    }

    public static void deleteAccount(){
        hasAccountToDelete = false;
        for (int j = 1; j < account.length; j++) {
            if (account[j][0] != null) { // memeriksa apakah username ada nilai
                hasAccountToDelete = true; // memberikan tanda jika ada username untuk
                                           // dihapus
                System.out.println(deleteAccountMessages[selectedBahasa][1]);
                System.out.println(deleteAccountMessages[selectedBahasa][2]);
                for (int k = 1; k < account.length; k++) {
                    if (account[k][0] != null) {
                        System.out.println("[" + k + "] " + account[k][0]);
                    }
                }
                System.out.print(deleteAccountMessages[selectedBahasa][3]);
                inputDeleteAccount = sc.nextInt();
                sc.nextLine();
                if (inputDeleteAccount >= 1 && inputDeleteAccount <= account.length) {
                    if (account[inputDeleteAccount][0] != null) {
                        if (!account[inputDeleteAccount][0].equals("admin")) {
                            account[inputDeleteAccount][0] = null; // menghapus username
                                                                   // akun yang diminta
                            account[inputDeleteAccount][1] = null; // menghapus password
                                                                   // akun yang diminta
                            System.out.println(deleteAccountMessages[selectedBahasa][4]);
                            break;
                        } else {
                            System.out.println(deleteAccountMessages[selectedBahasa][5]);
                            break;
                        }
                    } else {
                        System.out.println(deleteAccountMessages[selectedBahasa][6]);
                        break;
                    }
                } else {
                    System.out
                            .println(deleteAccountMessages[selectedBahasa][7]);
                    break;
                }
            }
        }
        if (!hasAccountToDelete) { // jika tidak terdapat akun yang akan di hapus
            System.out.println(deleteAccountMessages[selectedBahasa][8]);
        }
    }

    /*
     * Menu Settings
     */
    static boolean loopMenuSettings = false; // variabel untuk looping menu settings
    static int inputMenuSettings; // variabel untuk menerima inputan dalam menu settings
    static String inputUpdateStock; // variabel untuk menerima inputan dalam menu update stock
    static String inputChangePrice; // variabel untuk menerima inputan dalam menu change price
    static String inputDeleteMenu; // variabel untuk menerima inputan dalam menghapus menu
    static String newMenu; // variabel untuk menerima input nama menu baru
    static int newStock; // variabel untuk menerima input stock yang akan di tambahkan
    static int newPrice; // variabel untuk menerima input harga baru
    static boolean isMenuDeleted = false;

    public static void doUpdateStock(String[] menuArr, int[] stockMenuArr, Scanner sc) {
        int inputUpdateStock, inputNewStock;
        System.out.println(doUpdateStockMessages[selectedBahasa][1]);

        // Menampilkan pilihan menu
        for (int j = 0; j < menuArr.length; j++) {
            System.out.printf("[%d] %s\n", (j + 1), menuArr[j]);
        }

        System.out.print(doUpdateStockMessages[selectedBahasa][2]);

        // Validasi inputUpdateStock tidak boleh lebih dan kurang dari menu yang ada
        while (true) {
            inputUpdateStock = sc.nextInt();
            if (inputUpdateStock > menuArr.length || inputUpdateStock < 1) {
                System.out.print(
                        doUpdateStockMessages[selectedBahasa][3]);
                continue;
            } else
                break;
        }

        System.out.printf(doUpdateStockMessages[selectedBahasa][4],
                menuArr[inputUpdateStock - 1], stockMenuArr[inputUpdateStock - 1]);

        // Validasi inputNewStock tidak bisa kurang dari 0
        while (true) {
            inputNewStock = sc.nextInt();
            sc.nextLine();
            if (inputNewStock < 0) {
                System.out.print(
                        doUpdateStockMessages[selectedBahasa][5]);
            } else
                break;
        }

        // Replace inputNewStock kedalam array stockMenuArr
        stockMenuArr[inputUpdateStock - 1] = inputNewStock;
        System.out.println(doUpdateStockMessages[selectedBahasa][6]);
    }

    public static void doChangePrice(String[] menuArr, int[][] hargaIsBanyakTotalMenuArr,
            Scanner sc) {
        int inputUpdatePrice, newPrice;
        System.out.println(doChangePriceMessages[selectedBahasa][1]);
        for (int j = 0; j < menuArr.length; j++) {
            System.out.printf("[%d] %s\n", (j + 1), menuArr[j]);
        }
        System.out.print(doChangePriceMessages[selectedBahasa][2]);

        // Validasi inputUpdatePrice tidak lebih dan kurang dari menu yang ada
        while (true) {
            inputUpdatePrice = sc.nextInt();
            if (inputUpdatePrice > menuArr.length || inputUpdatePrice < 1) {
                System.out.print(
                        doChangePriceMessages[selectedBahasa][3]);
                continue;
            } else
                break;
        }

        System.out.printf(doChangePriceMessages[selectedBahasa][4],
                menuArr[inputUpdatePrice - 1],
                hargaIsBanyakTotalMenuArr[0][inputUpdatePrice - 1]);

        // Validasi newPrice tidak kurang dari 0
        while (true) {
            newPrice = sc.nextInt();
            sc.nextLine();
            if (newPrice < 0) {
                System.out.print(
                        doChangePriceMessages[selectedBahasa][5]);
            } else
                break;
        }

        // Replace harga menu sebelumnya dengan newPrice
        hargaIsBanyakTotalMenuArr[0][inputUpdatePrice - 1] = newPrice;
        System.out.println(doChangePriceMessages[selectedBahasa][6]);
    }

    public static boolean doAddMenu(String[] menuArr, int[][] hargaIsBanyakTotalMenuArr, int[] stockMenuArr, Scanner sc,
            String[] tempMenuArr, int[][] tempHargaIsBanyakTotalMenuArr, int[] tempStockMenuArr) {
        String newMenuName = "";
        int newMenuPrice, newMenuStock;

        // Mengisi array temporary dengan value array master
        for (int j = 0; j < menuArr.length; j++) {
            tempMenuArr[j] = menuArr[j];
            tempHargaIsBanyakTotalMenuArr[0][j] = hargaIsBanyakTotalMenuArr[0][j];
            tempStockMenuArr[j] = stockMenuArr[j];
        }

        System.out.println(doAddMenuMessages[selectedBahasa][1]);
        System.out.print(doAddMenuMessages[selectedBahasa][2]);

        boolean menuExists = false;

        boolean trueMinKh = true;
        while (trueMinKh) {
            menuExists = false;
            newMenuName = sc.nextLine();

            for (int j = 0; j < tempMenuArr.length; j++) {
                if (newMenuName.equalsIgnoreCase(tempMenuArr[j])) {
                    System.out.print(
                            doAddMenuMessages[selectedBahasa][3]);
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

        System.out.printf(doAddMenuMessages[selectedBahasa][4], newMenuName);
        while (true) {
            newMenuPrice = sc.nextInt();
            if (newMenuPrice <= 0) {
                System.out.print(
                        doAddMenuMessages[selectedBahasa][5]);
                continue;
            } else
                break;
        }
        tempHargaIsBanyakTotalMenuArr[0][menuArr.length] = newMenuPrice;

        System.out.printf(doAddMenuMessages[selectedBahasa][6], newMenuName);
        while (true) {
            newMenuStock = sc.nextInt();
            sc.nextLine();
            if (newMenuStock < 0) {
                System.out.println(
                        doAddMenuMessages[selectedBahasa][7]);
                continue;
            } else
                break;
        }

        tempStockMenuArr[menuArr.length] = newMenuStock;
        return true;
    }

    public static boolean doDeleteMenu(String[] menuArr, int[][] hargaIsBanyakTotalMenuArr, int[] stockMenuArr,
            Scanner sc, String[] tempMinusMenuArr, int[][] tempMinusHargaIsBanyakTotalMenuArr,
            int[] tempMinusStockMenuArr) {
        int isDeleteMenu;

        System.out.println(doDeleteMessages[selectedBahasa][1]);
        System.out.print(doDeleteMessages[selectedBahasa][2]);
        
        while (true) {
            isDeleteMenu = sc.nextInt();
            sc.nextLine();
            if (isDeleteMenu - 1 > menuArr.length - 1 || isDeleteMenu - 1 < 0) {
                System.out.print(doDeleteMessages[selectedBahasa][4]);
            } else break;
        }

        System.out.print(doDeleteMessages[selectedBahasa][3]);
        String isYesOrNo = sc.nextLine();

        // Jika user input y maka memasukin proses doDeleteMenu
        if (isYesOrNo.equalsIgnoreCase("y")) {
            for (int j = 0; j < menuArr.length; j++) {
                if (j == isDeleteMenu - 1) {
                    for (int k = j; k < menuArr.length; k++) {
                        // Jika sampai akhir indeks akan merubah value menjadi kosong
                        if (k == menuArr.length - 1) {
                            menuArr[k] = null;
                            stockMenuArr[k] = 0;
                            hargaIsBanyakTotalMenuArr[0][k] = 0;
                            hargaIsBanyakTotalMenuArr[1][k] = 0;
                            hargaIsBanyakTotalMenuArr[2][k] = 0;
                            break;
                        } else {
                            // Replace value terdelete dengan value indeks selanjutnya
                            menuArr[k] = menuArr[k + 1];
                            stockMenuArr[k] = stockMenuArr[k + 1];
                            hargaIsBanyakTotalMenuArr[0][k] = hargaIsBanyakTotalMenuArr[0][k + 1];
                            hargaIsBanyakTotalMenuArr[1][k] = hargaIsBanyakTotalMenuArr[1][k + 1];
                            hargaIsBanyakTotalMenuArr[2][k] = hargaIsBanyakTotalMenuArr[2][k + 1];
                        }

                    }
                }
            }

            for (int j = 0; j < tempMinusMenuArr.length; j++) {
                tempMinusMenuArr[j] = menuArr[j];
                tempMinusStockMenuArr[j] = stockMenuArr[j];
                tempMinusHargaIsBanyakTotalMenuArr[0][j] = hargaIsBanyakTotalMenuArr[0][j];
                tempMinusHargaIsBanyakTotalMenuArr[1][j] = hargaIsBanyakTotalMenuArr[1][j];
                tempMinusHargaIsBanyakTotalMenuArr[2][j] = hargaIsBanyakTotalMenuArr[2][j];
            }
            return true;
        }
        return false;

    }

    public static void doShowOrderedMenu() {
        for (int j = 0; j < hargaIsBanyakTotalMenuArr[1].length; j++) {
            if (hargaIsBanyakTotalMenuArr[1][j] != 0) {
                System.out.println("+---------------------------------------+");
                System.out.printf("| %s  \tx %d\t= Rp. %d  \t|\n", menuArr[j], hargaIsBanyakTotalMenuArr[1][j], hargaIsBanyakTotalMenuArr[2][j]);
            }
        }
    }

    public static void displayAccountsList() {
        for (int j = 1; j < account.length; j++) {
            if (account[j][0] != null) {
                System.out.println("[" + j + "] " + account[j][0]);
            }
        }
    }

    public static boolean isValidAccountIndex(int index) {
        return index >= 0 && index < account.length && account[index][0] != null;
    }

    public static void main(String[] args) {
        clearScreen();
        changeLanguage();
        while (!isLoggedin) {
            logInSystem();
            while (!backMenu) {
                menu();
            }
        }
    }
}