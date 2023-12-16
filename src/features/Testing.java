package features;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Testing{
    public static Scanner sc = new Scanner(System.in);

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
    public static String[][] account = new String[100][2];
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

        // Check if the username exists
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
                System.out.println("Login Success!");
                isLoggedin = true;
            } else {
                System.out.println("Password Invalid!");
                backMenu = true;
            }
        } else {
            System.out.println("Username Doesn't Exist!");
            backMenu = true;
        }
    }

    /*
     * Main Menu
     */
    public static boolean backMenu = false;
    public static String inputMenu;

    public static void menu() {
        System.out.println("\nWelcome to our Restaurant!\n");
        System.out.println("-------------------- MAIN MENU --------------------");

        if (userIndex == 0) {
            displayMainMenu();
        } else if (userIndex > 0) {
            displayUserMenu();
        }

        System.out.print("Select the menu you want: ");
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
                boolean loopSalesReport = false;
                System.out.println("[1] Order Menu\n[2] Reservation Table\n[0] Back to Main Menu");
                while (!loopSalesReport) {   
                    System.out.print("Pilih menu yang anda inginkan: ");
                    String isSalesReport = sc.nextLine();
                    switch (isSalesReport) {
                        case "0":
                            loopSalesReport = true;
                            break;
                            case "1":
                            showSalesReportOrderMenu(totalOrders, salesMenuArr, salesDateReportArr, salesAdminArr, salesIdQtyPriceTotalArr, totalProfit);
                            loopSalesReport = true;
                            break;
                            case "2":
                            showSalesReportReservation();
                            loopSalesReport = true;
                            break;
                        default:
                            System.out.println("Input invalid.");
                    }
                }
                break;
                
            case "4":
                while (!loopMenuSettings) {
                    System.out.println("\nMenu Settings");
                    System.out.println("[1] View All Menu");
                    System.out.println("[2] Update Stock");
                    System.out.println("[3] Change Price");
                    System.out.println("[4] Add New Menu");
                    System.out.println("[5] Delete Menu");
                    System.out.println("[0] Back to Main Menu");
                    System.out.print("Select the menu you want : ");
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
                            System.out.println("Invalid option. Please try again.");
                    }
                }
                break;

            default:
                System.out.println("\nInput Invalid!");
        }
    }

    public static void displayMainMenu() {
        System.out.println("[1] Order Here!");
        System.out.println("[2] Table Reservation");
        System.out.println("[3] Sales Report");
        System.out.println("[4] Menu Settings");
        System.out.println("[5] Account Settings");
        System.out.println("[0] Log Out");
    }

    public static void displayUserMenu() {
        System.out.println("[1] Order Here!");
        System.out.println("[2] Table Reservation");
        System.out.println("[0] Log Out");
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
        System.out.println("\t\t| Number | Menu                  | Price        | Stock  |");
        System.out.println("\t\t+--------------------------------------------------------+");
        for (int j = 0; j < menuArr.length; j++) { // Perulangan Daftar Menu
            System.out.printf("\t\t| %6d | %-15s  \t | Rp. %-5d\t| %-6d |\n", j + 1, menuArr[j],
                    hargaIsBanyakTotalMenuArr[0][j], stockMenuArr[j]);
        }
        System.out.println("\t\t+--------------------------------------------------------+\n");
    }

    public static void orderMenu() {
        System.out.print("How much menu do you want to order? ");
        jumlahMenu = sc.nextInt();

        // Perulangan sesuai input jumlahMenu
        int i = 1;
        while (jumlahMenu >= i) {

            // Validasi apakah menu yang dipesan memiliki stock 0 atau tidak
            while (true) {
                System.out.printf("\nApa yang ingin anda pesan pada Menu #%d? (Gunakan nomor Pada Menu) ", i);
                scMenu = sc.nextInt();

                if (stockMenuArr[scMenu - 1] < 1) {
                    System.out.print("\nMaaf stock sedang kosong!");
                    continue;
                } else
                    break;
            }

            while (scMenu > menuArr.length || scMenu < 1
                    || hargaIsBanyakTotalMenuArr[1][scMenu - 1] != 0) {
                // Mengecek kesesuaian input tidak lebih dari menu atau tidak 0
                if (scMenu > menuArr.length || scMenu < 1 || stockMenuArr[scMenu - 1] == 0) {
                    System.out.print("Menu tidak tersedia, silahkan isi kembali: ");
                    scMenu = sc.nextInt();
                } else { // Mengecek menu jika sudah pernah ditambahkan
                    System.out.printf(
                            "\nMenu %s sudah ditambahkan\nSilahkan pilih menu yang lain: ",
                            menuArr[scMenu - 1]);
                    scMenu = sc.nextInt();
                }
            }

            // Input elemen array banyak menu tiap menu
            System.out.printf("Berapa banyak anda ingin memesan %s? ", menuArr[scMenu - 1]);

            while (true) { // Validasi input dengan stock yang tersedia
                int isValidWithStock = sc.nextInt();
                sc.nextLine();
                if (stockMenuArr[scMenu - 1] < isValidWithStock) {
                    System.out.print(
                            "\nMaaf stock kami belum bisa memenuhi permintaan anda!\nBerapa banyak anda ingin memesan? ");
                    continue;
                } else if (isValidWithStock <= 0) {
                    System.out.print("\nNominal menu tidak bisa kurang dari 1!\nBerapa banyak anda ingin memesannya? ");
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

                // Validasi
                while (true) {
                    System.out.printf("Berapa banyak anda ingin memesan %s? ",
                            menuArr[noEditMenu - 1]);
                    int isValidWithStock = sc.nextInt();
                    sc.nextLine();

                    if (stockMenuArr[noEditMenu - 1] < isValidWithStock) {
                        System.out.print(
                                "\nMaaf stock kami belum bisa memenuhi permintaan anda!\n");
                        continue;
                    } else if (isValidWithStock <= 0) {
                        System.out.print(
                                "\nNominal menu tidak bisa kurang dari 1!\n");
                        continue;
                    } else {
                        hargaIsBanyakTotalMenuArr[1][noEditMenu - 1] = isValidWithStock;
                        break;
                    }
                }

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
        sc.nextLine();

        while (uangPembeli < totalMenuFinal) {
            System.out.print("\nMaaf uang anda kurang.\nSilahkan memasukkan nominal lain: ");
            uangPembeli = sc.nextInt();
            sc.nextLine();

        }

        uangKembalian = uangPembeli - totalMenuFinal;

        System.out.println("\n\n-------------------------Struk------------------------");
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
        System.out.println("--------------------Struk-----------------------------");
        System.out.println("Total Akhir\t:\t\t\t  Rp. " + totalMenuFinal);
        System.out.println("Cash\t\t:\t\t\t  Rp. " + uangPembeli);
        System.out.println("Kembalian\t:\t\t\t  Rp. " + uangKembalian);
        System.out.println("------------------------------------------------------");
        System.out.println("  \tTerima Kasih Atas Kunjungan Anda\n");

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

    public static void showSalesReportOrderMenu(int totalOrders, String[] salesMenuArr, String[] salesDateReportArr,
            String[] salesAdminArr, int[][] salesIdQtyPriceTotalArr, double totalProfit) {
        System.out.println("\nLaporan Penjualan:");

        if (totalOrders > 0) {
            for (int j = 0; j < totalOrders; j++) {
                System.out.printf("\nOrder #%d:\n", j + 1);
                System.out.println("Menu: " + salesMenuArr[j]);
                System.out.println("Tanggal Pemesanan: " + salesDateReportArr[j]);
                System.out.println("Kasir: " + salesAdminArr[j]);
                System.out.println("ID Menu: " + salesIdQtyPriceTotalArr[j][0]);
                System.out.println("Jumlah Pesanan: " + salesIdQtyPriceTotalArr[j][1]);
                System.out.println("Harga Satuan: " + salesIdQtyPriceTotalArr[j][2]);
                System.out.println("Total Harga: " + salesIdQtyPriceTotalArr[j][3]);
                System.out.println("-------------------------------------");
            }

            System.out.println("Total pendapatan: " + totalProfit);

        } else {
            System.out.println("Tidak ada laporan penjualan!\n");
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
        System.out.println("\n===== Table Reservation =====");
        System.out.println("[1] Table Settings");
        System.out.println("[2] Table List");
        System.out.println("[3] Reserve Table");
        System.out.println("[4] Delete Table Order");
        System.out.println("[0] Back to main menu");
        System.out.print("Select menu: ");
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
                System.out.println("Invalid option, please select again.");
                break;
        }
    }

    public static void showUserMenu() {
        System.out.println("\n===== Table Reservation =====");
        System.out.println("[1] Table List");
        System.out.println("[2] Reserve Table");
        System.out.println("[3] Delete Table Order");
        System.out.println("[0] Back to main menu");
        System.out.print("Select menu: ");
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
                System.out.println("Invalid option, please select again.");
                break;
        }
    }

    public static void tableSettings() {
        System.out.print("Please enter the number of tables: ");
        maxTable = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        tableAvailable = new boolean[maxTable];
        downPayment = new int[maxTable];

        // Initialize tables anda make it true
        for (int j = 0; j < maxTable; j++) {
            tableAvailable[j] = true;
            downPayment[j] = 0;
        }
    }

    public static void tableList() {
        boolean anyAvailableTable = false;
        System.out.println("\nTable List:");
        for (int i = 0; i < maxTable; i++) {
            String status = tableAvailable[i] ? "Available" : "Not Available";
            System.out.println("Table " + (i + 1) + " : " + status);
            if (tableAvailable[i]) {
                anyAvailableTable = true;
            }
        }

        if (!anyAvailableTable) {
            System.out.println("Please set available table at admin menu first.");
        }
    }

    public static void reserveTable() {
        int jamArrival;
        int tanggalArrival;
        int bulanArrival;
        int tahunArrival;

        while (true) {
            System.out.print("Select the table number you want to serve: ");
            reservationTableNumber = sc.nextInt();
            if (reservationTableNumber > tableAvailable.length || reservationTableNumber < 1 || tableAvailable[reservationTableNumber - 1] == false) {
                System.out.println("Meja tidak valid.\n");
                continue;
            } else
                break;
        }
        sc.nextLine();

        System.out.println("\nMasukkan tanggal reservasi: ");
        while (true) {
            System.out.print("Jam: ");
            jamArrival = sc.nextInt();
            if (jamArrival < 1 || jamArrival > 24) {
                System.out.println("\nJam tidak valid.");
                continue;
            } else
                break;
        }
        while (true) {
            System.out.print("Tanggal: ");
            tanggalArrival = sc.nextInt();
            if (tanggalArrival < 1 || tanggalArrival > 32) {
                System.out.println("\nTanggal tidak valid.");
                continue;
            } else
                break;
        }
        while (true) {
            System.out.print("Bulan: ");
            bulanArrival = sc.nextInt();
            if (bulanArrival < 1 || bulanArrival > 12) {
                System.out.println("\nBulan tidak valid.");
                continue;
            } else
                break;
        }
        LocalDateTime currentDateTime = LocalDateTime.now();
        int tahunSekarang = currentDateTime.getYear();

        while (true) {
            System.out.print("Tahun: ");
            tahunArrival = sc.nextInt();
            sc.nextLine();
            if (tahunArrival < tahunSekarang) {
                System.out.println("\nTahun tidak valid.");
                continue;
            } else
                break;
        }

        if (jamArrival < 10) {
            arrivalAtReservation = tahunArrival + "-" + bulanArrival + "-" + tanggalArrival + " " + "0" + jamArrival + ":00";
        } else {
            arrivalAtReservation = tahunArrival + "-" + bulanArrival + "-" + tanggalArrival + " " + jamArrival + ":00";
        }


        System.out.print("\nAnda memilih bayar:\n[y] Cash 50.000\n[n] DP 25.000\n\nSilahkan memilih (y/n): ");
        String isDPCash = sc.nextLine();
        switch (isDPCash) {
            case "y":
                isBayarTunai = true;
                break;

            default:
                isBayarTunai = false;
                break;
        }
        if (isBayarTunai == true) {
            System.out.println("\nBayar Cash sejumlah 50.000");
            while (true) {
                System.out.print("Masukkan uang anda: ");
                uangPembeliReservasi = sc.nextInt();
                sc.nextLine();
                if (uangPembeliReservasi < 50000) {
                    System.out.println("\nUang anda kurang");
                    continue;
                } else if (uangPembeliReservasi > 50000) {
                    uangKembalianReservasi = uangPembeliReservasi - 50000;
                    System.out.println("Kembalian uang anda: " + uangKembalianReservasi);
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
            System.out.println("\nBayar DP sejumlah 25.000");
            while (true) {
                System.out.print("Masukkan uang anda: ");
                uangPembeliReservasi = sc.nextInt();
                sc.nextLine();
                if (uangPembeliReservasi < 25000) {
                    System.out.println("\nUang anda kurang");
                    continue;
                } else if (uangPembeliReservasi > 25000) {
                    uangKembalianReservasi = uangPembeliReservasi - 25000;
                    System.out.println("Kembalian uang anda: " + uangKembalianReservasi);
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

        System.out.println("\n\n-------------------------Struk------------------------");
        System.out.println("Nomor Meja\t  : \t\t  " + reservationTableNumber);
        System.out.println("Tanggal Order\t  : \t\t  " + formattedDateTime);
        System.out.println("Tanggal Reservasi : \t\t  " + arrivalAtReservation);
        System.out.println("------------------------------------------------------");
        System.out.println("Cash\t\t:\t\t  Rp. " + uangPembeliReservasi);
        System.out.println("Kembalian\t:\t\t  Rp. " + uangKembalianReservasi);
        System.out.println("------------------------------------------------------");
        System.out.println("  \tTerima Kasih Atas Kunjungan Anda\n");

        totalOrdersReservation++;
    }

    public static void deleteReservationTableNumber() {
        int deleteReservationTableNumber = getUserInputInt("Enter the table number you want to cancel: ", 1, maxTable);

        if (!tableAvailable[deleteReservationTableNumber - 1]) {
            tableAvailable[deleteReservationTableNumber - 1] = true;
            int cancelDownPayment = downPayment[deleteReservationTableNumber - 1];
            System.out.println("Table reservation " + deleteReservationTableNumber + " successfully cancelled.");
            System.out.println("Refundable advance: " + cancelDownPayment / 2);
        } else {
            System.out.println("Table not reserved.");
        }
    }
    public static void showSalesReportReservation(){
          System.out.println("\nLaporan Penjualan:");

        if (totalOrdersReservation > 0) {
            for (int j = 0; j < totalOrdersReservation; j++) {
                System.out.printf("\nOrder Table #%d:\n", j + 1);
                System.out.println("Tanggal Pemesanan: " + salesDateReportReservationArr[j]);
                System.out.println("Tanggal Reservasi: " + arrivalateArr[j]);
                System.out.println("Nomor Meja: " + numberTableReservationArr[j]);
                System.out.println("Kasir: " + salesAdminReservationArr[j]);
                System.out.println("ID Menu: " + numberTableReservationArr[j]);
                System.out.println("Pemasukan: " + incomeReservationArr[j]);
                System.out.println("-------------------------------------");
            }

            System.out.println("Total Pendapatan: " + totalProfitReservation);

        } else {
            System.out.println("Tidak ada laporan penjualan!\n");
        }
    }

    public static int getUserInputInt(String prompt, int min, int max) {
        int userInput;
        do {
            System.out.print(prompt);
            while (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number.");
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
    public static String newUsername, newPassword; // variabel untuk menerima input username dan password baru
    public static int changeUsername, changePassword; // variabel untuk menerima input perubahan username atau password
    public static int inputAccount; // variabel untuk menerima input dari menu account settings
    public static int inputDeleteAccount; // variabel untuk menerima akun yang akan dihapus
    public static boolean loopAccountSettings = false; // variabel untuk melakukan looping di dalam menu accound
                                                       // settings
    public static boolean hasAccountToDelete = false; // variabel untuk mengecek apakah ada akun untuk dihapus

    public static void displayAccountSettingsMenu() {
        System.out.println("\nAccount Settings :");
        System.out.println("[1] View All Account");
        System.out.println("[2] Register New Account");
        System.out.println("[3] Change Username");
        System.out.println("[4] Change Password");
        System.out.println("[5] Delete Account");
        System.out.println("[0] Back to Main Menu");
        System.out.print("Select the settings: ");
    }

    public static void viewAllAccounts() {
        System.out.println("\nView All Account : ");
        for (int i = 0; i < account.length; i++) {
            if (account[i][0] != null) {
                System.out.println("[" + (i + 1) + "] " + account[i][0]);
            }
        }
    }

    public static void registerNewAccount() {
        System.out.println("\nRegister New Account ");
        System.out.print("Enter a new username : ");
        String newUsername = sc.next();
        System.out.print("Enter a new password : ");
        String newPassword = sc.next();

        boolean added = false;
        for (int i = 0; i < account.length; i++) {
            if (account[i][0] == null) {
                account[i][0] = newUsername;
                account[i][1] = newPassword;
                added = true;
                break;
            }
        }
        if (added) {
            System.out.println("Account added successfully.");
        } else {
            System.out.println("Account limit reached. Cannot add more accounts.");
        }
    }

    public static void changeUsername() {
        System.out.println("\nChange Username Account : ");
        displayAccountsList();

        System.out.print("Select the account you want to change the username : ");
        int changeUsername = sc.nextInt();
        sc.nextLine();

        if (isValidAccountIndex(changeUsername)) {
            if (changeUsername != 0) {
                System.out.print("Enter a new username : ");
                String newUsername = sc.next();
                account[changeUsername][0] = newUsername;
                System.out.println("Username changed successfully.");
            } else {
                System.out.println("Cannot change the username for the default account.");
            }
        }
    }

    public static void changePassword() {
        System.out.println("\nChange Password Account : ");
        displayAccountsList();

        System.out.print("Select the account you want to change the password : ");
        int changePassword = sc.nextInt();
        sc.nextLine();

        if (isValidAccountIndex(changePassword)) {
            if (changePassword != 0) {
                System.out.print("Enter a new password : ");
                String newPassword = sc.next();
                account[changePassword][1] = newPassword;
                System.out.println("Password changed successfully.");
            } else {
                System.out.println("Cannot change the password for the default account.");
            }
        }
    }

    public static void deleteAccount() {
        hasAccountToDelete = false;
        for (int j = 1; j < account.length; j++) {
            if (account[j][0] != null) { // memeriksa apakah username ada nilai
                hasAccountToDelete = true; // memberikan tanda jika ada username untuk
                                           // dihapus
                System.out.println("\nDelete Account ");
                System.out.println("Available Account to Delete:");
                for (int k = 1; k < account.length; k++) {
                    if (account[k][0] != null) {
                        System.out.println("[" + k + "] " + account[k][0]);
                    }
                }
                System.out.print("Select account to delete : ");
                inputDeleteAccount = sc.nextInt();
                sc.nextLine();
                if (inputDeleteAccount >= 1 && inputDeleteAccount <= account.length) {
                    if (account[inputDeleteAccount][0] != null) {
                        if (!account[inputDeleteAccount][0].equals("admin")) {
                            account[inputDeleteAccount][0] = null; // menghapus username
                                                                   // akun yang diminta
                            account[inputDeleteAccount][1] = null; // menghapus password
                                                                   // akun yang diminta
                            System.out.println("Delete successfully.");
                            break;
                        } else {
                            System.out.println("You cannot delete the admin account.");
                            break;
                        }
                    } else {
                        System.out.println("Account doesn't exist!");
                        break;
                    }
                } else {
                    System.out
                            .println("Invalid account. Please enter a valid account.");
                    break;
                }
            }
        }
        if (!hasAccountToDelete) { // jika tidak terdapat akun yang akan di hapus
            System.out.println("\nThere are no available account to delete");
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
        System.out.println("Update Stock: ");

        // Menampilkan pilihan menu
        for (int j = 0; j < menuArr.length; j++) {
            System.out.printf("[%d] %s\n", (j + 1), menuArr[j]);
        }

        System.out.print("\nSelect the menu you want to update (use the number) : ");

        // Validasi inputUpdateStock tidak boleh lebih dan kurang dari menu yang ada
        while (true) {
            inputUpdateStock = sc.nextInt();
            if (inputUpdateStock > menuArr.length || inputUpdateStock < 1) {
                System.out.print(
                        "Input yang anda masukkan salah!\nMasukkan menu yang ingin di update: ");
                continue;
            } else
                break;
        }

        System.out.printf("Masukkan perubahan stock dari %s {%d} : ",
                menuArr[inputUpdateStock - 1], stockMenuArr[inputUpdateStock - 1]);

        // Validasi inputNewStock tidak bisa kurang dari 0
        while (true) {
            inputNewStock = sc.nextInt();
            sc.nextLine();
            if (inputNewStock < 0) {
                System.out.print(
                        "Stock tidak bisa kurang dari 0!\nSilahkan masukkan perubahan stock: ");
            } else
                break;
        }

        // Replace inputNewStock kedalam array stockMenuArr
        stockMenuArr[inputUpdateStock - 1] = inputNewStock;
        System.out.println("\nStock updated.");
    }

    public static void doChangePrice(String[] menuArr, int[][] hargaIsBanyakTotalMenuArr,
            Scanner sc) {
        int inputUpdatePrice, newPrice;
        System.out.println("\nChange Price");
        for (int j = 0; j < menuArr.length; j++) {
            System.out.printf("[%d] %s\n", (j + 1), menuArr[j]);
        }
        System.out.print("\nSelect the menu you want to update (use the number) : ");

        // Validasi inputUpdatePrice tidak lebih dan kurang dari menu yang ada
        while (true) {
            inputUpdatePrice = sc.nextInt();
            if (inputUpdatePrice > menuArr.length || inputUpdatePrice < 1) {
                System.out.print(
                        "Input yang anda masukkan salah!\nMasukkan menu yang ingin di update: ");
                continue;
            } else
                break;
        }

        System.out.printf("Masukkan perubahan harga dari %s {%d} : ",
                menuArr[inputUpdatePrice - 1],
                hargaIsBanyakTotalMenuArr[0][inputUpdatePrice - 1]);

        // Validasi newPrice tidak kurang dari 0
        while (true) {
            newPrice = sc.nextInt();
            sc.nextLine();
            if (newPrice < 0) {
                System.out.print(
                        "Harga tidak bisa kurang dari 0!\nSilahkan masukkan perubahan harga: ");
            } else
                break;
        }

        // Replace harga menu sebelumnya dengan newPrice
        hargaIsBanyakTotalMenuArr[0][inputUpdatePrice - 1] = newPrice;
        System.out.println("\nHarga updated.");
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

        System.out.println("\nAdd New Menu");
        System.out.print("Masukkan nama menu baru: ");

        boolean menuExists = false;

        boolean trueMinKh = true;
        while (trueMinKh) {
            menuExists = false;
            newMenuName = sc.nextLine();

            for (int j = 0; j < tempMenuArr.length; j++) {
                if (newMenuName.equalsIgnoreCase(tempMenuArr[j])) {
                    System.out.print(
                            "Menu sudah ditambahkan! Silahkan masukkan nama menu baru: ");
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
                System.out.print(
                        "\nMaaf, harga untuk menu baru tidak bisa kurang dari 1 rupiah\nSilahkan masukkan harga: ");
                continue;
            } else
                break;
        }
        tempHargaIsBanyakTotalMenuArr[0][menuArr.length] = newMenuPrice;

        System.out.printf("Masukkan stock awal untuk %s: ", newMenuName);
        while (true) {
            newMenuStock = sc.nextInt();
            sc.nextLine();
            if (newMenuStock < 0) {
                System.out.println(
                        "Maaf, stock untuk menu baru tidak bisa kurang dari 0\nSilahkan masukkan stock awal: ");
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

        System.out.println("Delete Menu");
        System.out.print("Masukkan menu nomor berapa yang ingin anda hapus: ");
        isDeleteMenu = sc.nextInt();
        sc.nextLine();

        System.out.print("Apakah anda yakin [y/n]? ");
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
        account[0] = new String[] { "admin", "admin" }; // account default
        while (!isLoggedin) {
            logInSystem();
            while (!backMenu) {
                menu();
            }
        }
    }
}
