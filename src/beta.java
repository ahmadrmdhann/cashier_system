import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class beta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // variabel penting yang bikin pusing
        int userIndex = -1; // variabel untuk mencari index username dan password dalam variabel account
        int menuIndex = -1; // variabel untuk mencari index menu

        /*
         * Sistem Login
         */
        // variabel berisi akun (max = 1 akun admin & 5 akun kasir)
        String[][] account = new String[6][2];
        // default username and password
        account[0][0] = "admin";
        account[0][1] = "admin";
        String username, password; // variabel untuk menerima input
        boolean isLoggedIn = false; // variabel untuk mencari tau apakah user sedang log in atau tidak

        /*
         * Sistem Registrasi
         */
        String newUsername, newPassword; // variabel untuk menerima input username dan password baru
        int changeUsername, changePassword; // variabel untuk menerima input perubahan username atau password
        int inputAccount; // variabel untuk menerima input dari menu account settings
        int inputDeleteAccount; // variabel untuk menerima akun yang akan dihapus
        boolean loopAccountSettings = false; // variabel untuk melakukan looping di dalam menu accound settings
        boolean hasAccountToDelete = false; // variabel untuk mengecek apakah ada akun untuk dihapus

        /*
         * Main Menu
         */
        boolean backMenu = false; // variabel untuk kembali ke main menu
        int inputMenu; // variabel untuk menerima inputan pemilihan menu di main menu

        /*
         * Order Menu
         */
        int jumlahMenu, scMenu, uangPembeli;
        int uangKembalian = 0, totalMenuFinal = 0;
        String[] menuArr = { "Nasi Goreng", "Sate", "Sayur Lodeh", "Sayur Asem", "Ayam Geprek", "Teh Anget", "Jeruk",
                "Susu Soda" };
        int[][] hargaIsBanyakTotalMenuArr = { { 10000, 15000, 8000, 8000, 10000, 5000, 5000, 5000 },
                { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 } };
        int[] stockMenuArr = { 35, 20, 1, 10, 25, 509, 5320, 20 };
        boolean isMenuDeleted;

        // Array laporan penjualan
        int totalOrders = 0;
        int[][] salesIdQtyPriceTotalArr = new int[totalOrders + 1][4];
        String[] salesMenuArr = new String[totalOrders + 1];
        String[] salesDateReportArr = new String[totalOrders + 1];
        String[] salesAdminArr = new String[totalOrders + 1];
        double totalProfit = 0;

        /*
         * Menu Settings Feature
         */
        boolean loopMenuSettings = false; // variabel untuk looping menu settings
        int inputMenuSettings; // variabel untuk menerima inputan dalam menu settings
        String inputUpdateStock; // variabel untuk menerima inputan dalam menu update stock
        String inputChangePrice; // variabel untuk menerima inputan dalam menu change price
        String inputDeleteMenu; // variabel untuk menerima inputan dalam menghapus menu
        String newMenu; // variabel untuk menerima input nama menu baru
        int newStock; // variabel untuk menerima input stock yang akan di tambahkan
        int newPrice; // variabel untuk menerima input harga baru

        /*
         * menu reservasi
         */
        int maxTable = 10; // Jumlah maksimum meja
        boolean[] tableAvailable = new boolean[maxTable];
        int[] downPayment = new int[maxTable];
        boolean loopReservation = false;

        while (!isLoggedIn) {
            // Tempat reset semua variabel yang diperlukan setelah log out
            userIndex = -1;
            isLoggedIn = false;
            backMenu = false;

            // Sistem Login
            sc.nextLine(); // solusi ketika setelah log out "Username doesn't exist"
            System.out.println("\n+-----------------------------------------+");
            System.out.println("|                LOG IN                   |");
            System.out.println("+-----------------------------------------+");
            System.out.print("Username\t: ");
            username = sc.nextLine();
            for (int i = 0; i < account.length; i++) {
                if (username.equals(account[i][0])) {
                    userIndex = i;
                }
            }
            if (userIndex >= 0) { // userIndex digunakan untuk menyamakan antara index username dan index password
                System.out.print("Password\t: ");
                password = sc.nextLine();
                if (password.equals(account[userIndex][1])) { // indeks kolom 1 digunakan hanya untuk mengakses password
                    // Untuk menjaga keamanan sandi kita memberikan clearScreen
                    clearScreen();
                    System.out.println("\nLogin Successfully!");
                    isLoggedIn = true;
                } else {
                    System.out.println("\nPassword Invalid.");
                    continue;
                }
            } else {
                System.out.println("\nUsername Doesn't Exist!");
                continue;
            }

            while (!backMenu) {
                if (userIndex == 0) { // menu yang hanya bisa diakses admin
                    // reset untuk setiap looping di dalam main menu
                    loopMenuSettings = false;
                    loopAccountSettings = false;
                    loopReservation = false;

                    System.out.println("\nWelcome to our Restaurant!\n");
                    System.out.println("-------------------- MAIN MENU --------------------");
                    System.out.println("[1] Order Here!"); // In Progress
                    System.out.println("[2] Menu Settings"); // Feature Done
                    System.out.println("[3] Account Settings"); // Feature Done
                    System.out.println("[4] Table Reservation"); // In Progress
                    System.out.println("[5] Sales Report"); // In Progress
                    System.out.println("[0] Log Out");
                    System.out.print("Select the menu you want: ");

                    inputMenu = sc.nextInt();
                    sc.nextLine();
                    switch (inputMenu) {
                        case 0:
                            isLoggedIn = false;
                            backMenu = true;
                            break;

                        case 1:
                            // Tampilkan menu
                            doShowMenu(menuArr, hargaIsBanyakTotalMenuArr, stockMenuArr);

                            // Reset array
                            int[][] resetHargaIsBanyakTotalMenuArr = { hargaIsBanyakTotalMenuArr[0],
                                    { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 } };
                            hargaIsBanyakTotalMenuArr = resetHargaIsBanyakTotalMenuArr;
                            totalMenuFinal = 0;

                            System.out.print("How much menu do you want to order? ");
                            jumlahMenu = sc.nextInt();

                            // Perulangan sesuai input jumlahMenu
                            int i = 1;
                            while (jumlahMenu >= i) {

                                // Validasi apakah menu yang dipesan memiliki stock 0 atau tidak
                                while (true) {
                                    System.out.printf(
                                            "\nApa yang ingin anda pesan pada Menu #%d? (Gunakan nomor Pada Menu) ",
                                            i);
                                    scMenu = sc.nextInt();
                                    
                                    if (stockMenuArr[scMenu - 1] < 1) {
                                        System.out.print("\nMaaf stock sedang kosong!");
                                        continue;
                                    } else break;
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
                                        System.out.print(
                                                "\nNominal menu tidak bisa kurang dari 1!\nBerapa banyak anda ingin memesannya? ");
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
                            System.out.println("------------------------------------------------------");
                            System.out.println("Total Akhir\t:\t\t\t  Rp. " + totalMenuFinal);
                            System.out.println("Cash\t\t:\t\t\t  Rp. " + uangPembeli);
                            System.out.println("Kembalian\t:\t\t\t  Rp. " + uangKembalian);
                            System.out.println("------------------------------------------------------");
                            System.out.println("  \tTerima Kasih Atas Kunjungan Anda\n");

                            System.out.print("Write anything to continue: ");
                            sc.nextLine();

                            // Menambah totalMenuFinal kedalam variabel total profit
                            totalProfit += totalMenuFinal;

                            // Pengurangan stock
                            for (int j = 0; j < stockMenuArr.length; j++) {
                                stockMenuArr[j] -= hargaIsBanyakTotalMenuArr[1][j];
                            }

                            backMenu = false;
                            break;

                        case 2:
                            while (!loopMenuSettings) {
                                System.out.println("\nMenu Settings");
                                System.out.println("[1] View All Menu");
                                System.out.println("[2] Update Stock");
                                System.out.println("[3] Change Price");
                                System.out.println("[4] Add New Menu");
                                System.out.println("[5] Delete Menu");
                                System.out.println("[0] Back to Main Menu");
                                System.out.print("Select the menu you want : ");
                                inputMenuSettings = sc.nextInt();
                                sc.nextLine();
                                switch (inputMenuSettings) {
                                    case 0:
                                        loopMenuSettings = true;
                                        break;

                                    case 1:
                                        doShowMenu(menuArr, hargaIsBanyakTotalMenuArr, stockMenuArr);
                                        System.out.print("Write anything to continue: ");
                                        sc.nextLine();
                                        break;

                                    case 2:
                                        doUpdateStock(menuArr, stockMenuArr, sc);
                                        break;

                                    case 3:
                                        doChangePrice(menuArr, hargaIsBanyakTotalMenuArr, sc);
                                        break;
                                    case 4:
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

                                        doAddMenu(menuArr, hargaIsBanyakTotalMenuArr, stockMenuArr, sc, tempMenuArr, tempHargaIsBanyakTotalMenuArr, tempStockMenuArr);
                                        
                                        menuArr = tempMenuArr;
                                        hargaIsBanyakTotalMenuArr = tempHargaIsBanyakTotalMenuArr;
                                        stockMenuArr = tempStockMenuArr;
                                        break;

                                    case 5:
                                        // isMenuDeleted = false;
                                            String[] tempMinusMenuArr = new String[menuArr.length - 1];
                                            int[][] tempMinusHargaIsBanyakTotalMenuArr = new int[hargaIsBanyakTotalMenuArr.length][tempMinusMenuArr.length];
                                            int[] tempMinusStockMenuArr = new int[tempMinusMenuArr.length];
                                        
                                        doShowMenu(menuArr, hargaIsBanyakTotalMenuArr, stockMenuArr);
                                        
                                        isMenuDeleted = doDeleteMenu(menuArr, hargaIsBanyakTotalMenuArr, stockMenuArr, sc, tempMinusMenuArr, tempMinusHargaIsBanyakTotalMenuArr, tempMinusStockMenuArr);

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

                        case 3:
                            while (!loopAccountSettings) {
                                System.out.println("\nAccount Settings :");
                                System.out.println("[1] View All Account");
                                System.out.println("[2] Register New Account");
                                System.out.println("[3] Change Username");
                                System.out.println("[4] Change Password");
                                System.out.println("[5] Delete Account");
                                System.out.println("[0] Back to Main Menu");
                                System.out.print("Select the settings: ");
                                inputAccount = sc.nextInt();
                                sc.nextLine();
                                switch (inputAccount) {
                                    case 0:
                                        loopAccountSettings = true;
                                        break;

                                    case 1:
                                        System.out.println("\nView All Account : ");
                                        for (int j = 0; j < account.length; j++) {
                                            if (account[j][0] != null) { // Hanya untuk mengecek semua akun yang sudah
                                                                         // ditambahkan
                                                System.out.println("[" + (j + 1) + "] " + account[j][0]);
                                            }
                                        }
                                        break;

                                    case 2:
                                        System.out.println("\nRegister New Account ");
                                        System.out.print("Enter a new username : ");
                                        newUsername = sc.next();
                                        System.out.print("Enter a new password : ");
                                        newPassword = sc.next();
                                        boolean added = false;
                                        for (int j = 0; j < account.length; j++) {
                                            if (account[j][0] == null) {
                                                account[j][0] = newUsername;
                                                account[j][1] = newPassword;
                                                added = true;
                                                break;
                                            }
                                        }
                                        if (added) {
                                            System.out.println("Account added successfully."); // akan tampil jika
                                                                                               // sukses membuat akun
                                        } else {
                                            System.out.println("Account limit reached. Cannot add more accounts."); // akan
                                                                                                                    // tampil
                                                                                                                    // jika
                                                                                                                    // akun
                                                                                                                    // sudah
                                                                                                                    // melebihi
                                                                                                                    // 6
                                        }
                                        break;

                                    case 3:
                                        System.out.println("\nChange Username Account : ");
                                        for (int j = 1; j < account.length; j++) {
                                            if (account[j][0] != null) { // Hanya untuk mengecek semua akun yang sudah
                                                                         // ditambahkan
                                                System.out.println("[" + j + "] " + account[j][0]);
                                            }
                                        }
                                        System.out.print("Select the account you want to change the username : ");
                                        changeUsername = sc.nextInt();
                                        sc.nextLine();
                                        System.out.print("Enter a new username : ");
                                        newUsername = sc.next();
                                        if (changeUsername >= 1 && changeUsername <= 5) {
                                            account[changeUsername][0] = newUsername;
                                        }
                                        break;

                                    case 4:
                                        System.out.println("\nChange Username Account : ");
                                        for (int j = 1; j < account.length; j++) {
                                            if (account[j][0] != null) { // Hanya untuk mengecek semua akun yang sudah
                                                                         // ditambahkan
                                                System.out.println("[" + j + "] " + account[j][0]);
                                            }
                                        }
                                        System.out.print("Select the account you want to change the password : ");
                                        changePassword = sc.nextInt();
                                        sc.nextLine();
                                        System.out.print("Enter a new password : ");
                                        newPassword = sc.next();
                                        if (changePassword >= 1 && changePassword <= 5) {
                                            account[changePassword][1] = newPassword;
                                        }
                                        break;

                                    case 5:
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
                                        break;

                                    default:
                                        System.out.println("Invalid input.");
                                        break;
                                }
                            }
                            break;

                        case 4:
                            for (int j = 0; j < maxTable; j++) {
                                tableAvailable[j] = true; // Semua meja awalnya tersedia
                                downPayment[j] = 0;
                            }

                            while (!loopReservation) {
                                System.out.println("\n===== Table Reservation =====");
                                System.out.println("[1] Table List");
                                System.out.println("[2] Reserve Table");
                                System.out.println("[3] Delete Table Order");
                                System.out.println("[0] Back to main menu");
                                System.out.print("Select menu: ");

                                int tableReservation = sc.nextInt();
                                sc.nextLine();

                                switch (tableReservation) {
                                    case 1:
                                        tableList(maxTable, tableAvailable, downPayment, loopReservation);
                                        break;

                                    case 2:
                                        reservationTableNumber(maxTable, tableAvailable, downPayment, loopReservation,
                                                sc);
                                        break;

                                    case 3:
                                        deleteReservationTableNumber(maxTable, tableAvailable, downPayment,
                                                loopReservation, sc);
                                        break;

                                    case 0:
                                        loopReservation = true;
                                        break;

                                    default:
                                        System.out.println("Invalid option, please select again.");
                                        break;
                                }
                            }
                            break;

                        case 5:
                            doShowSalesReport(totalOrders, salesMenuArr, salesDateReportArr, salesAdminArr,
                                    salesIdQtyPriceTotalArr, totalProfit);
                            System.out.print("Write anything to continue: ");
                            sc.nextLine();

                            break;

                        default:
                            System.out.println("\nInvalid input.");
                            break;
                    }
                } else { // menu yang khusus disiapkan untuk level selain admin
                    System.out.println("Sabar bang multi level masih tahap proses");
                    isLoggedIn = false;
                    backMenu = true;
                }
            }
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void doShowMenu(String[] menuArr, int[][] hargaIsBanyakTotalMenuArr, int[] stockMenuArr) {
        System.out.println("\t\t+-------------------------------------------------------+");
        System.out.println("\t\t|                    MENU                       |       |");
        System.out.println("\t\t+-Nomor-------------- Makanan --------------------Stock-+");

        for (int j = 0; j < menuArr.length; j++) { // Perulangan Daftar Menu
            System.out.printf("\t\t|  %d\t| %s  \t\tRp. %d\t| %d\t|\n", j + 1, menuArr[j],
                    hargaIsBanyakTotalMenuArr[0][j], stockMenuArr[j]);
        }

        System.out.println("\t\t+-------------------------------------------------------+\n");
    }

    public static void doUpdateStock(String[] menuArr, int[] stockMenuArr,
            Scanner sc) {
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

    public static boolean doAddMenu(String[] menuArr, int[][] hargaIsBanyakTotalMenuArr, int[] stockMenuArr, Scanner sc, String[] tempMenuArr, int[][] tempHargaIsBanyakTotalMenuArr, int[] tempStockMenuArr) {
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
            Scanner sc, String[] tempMinusMenuArr, int[][] tempMinusHargaIsBanyakTotalMenuArr, int[] tempMinusStockMenuArr) {
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

    public static void doShowSalesReport(int totalOrders, String[] salesMenuArr, String[] salesDateReportArr,
            String[] salesAdminArr, int[][] salesIdQtyPriceTotalArr, double totalProfit) {
        System.out.println("\nLaporan Penjualan:");

        if (totalOrders > 0) {
            for (int j = 0; j < totalOrders; j++) {
                System.out.printf("\nOrder #%d:\n", j + 1);
                System.out.println("Menu: " + salesMenuArr[j]);
                System.out.println("Tanggal Pemesanan: " + salesDateReportArr[j]);
                System.out.println("Admin: " + salesAdminArr[j]);
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

    public static void tableList(int maxTable, boolean[] tableAvailable, int[] downPayment, boolean loopReservation) {
        System.out.println("Table List:");
        for (int i = 0; i < tableAvailable.length; i++) {
            String status = tableAvailable[i] ? "Available" : "Not Available";
            System.out.println("Table " + (i + 1) + " : " + status);
        }

    }

    public static void reservationTableNumber(int maxTable, boolean[] tableAvailable, int[] downPayment,
            boolean loopReservation, Scanner sc) {
        System.out.print("Select the table number you want to serve: ");
        int reservationTableNumber = sc.nextInt();
        sc.nextLine();

        if (reservationTableNumber >= 1
                && reservationTableNumber <= tableAvailable.length) {
            if (tableAvailable[reservationTableNumber - 1]) {
                System.out.print(
                        "Enter the amount of down payment to be paid (minimum 50.000): ");
                int downPaymentAmount = sc.nextInt();
                sc.nextLine();

                if (downPaymentAmount >= 50000) { // jumlah DP minimal 50.000
                    tableAvailable[reservationTableNumber - 1] = false;
                    downPayment[reservationTableNumber - 1] = downPaymentAmount;
                    System.out.println("Table Reservation " + reservationTableNumber
                            + " Successfull.");
                    System.out.println(
                            "Amount of down payment paid: " + downPaymentAmount);
                } else {
                    System.out.println(
                            "The amount of down payment paid is at least 50.000.");
                }
            } else {
                System.out.println("Table is occupied, please choose another table.");
            }
        } else {
            System.out.println("Invalid Table Number.");
        }
    }

    public static void deleteReservationTableNumber(int maxTable, boolean[] tableAvailable, int[] downPayment,
            boolean loopReservation, Scanner sc) {
        System.out.print("Enter the table number you want to cancel: ");
        int deleteReservationTableNumber = sc.nextInt();
        sc.nextLine();

        if (deleteReservationTableNumber >= 1
                && deleteReservationTableNumber <= tableAvailable.length) {
            if (!tableAvailable[deleteReservationTableNumber - 1]) {
                tableAvailable[deleteReservationTableNumber - 1] = true;
                int cancelDownPayment = downPayment[deleteReservationTableNumber - 1];
                System.out.println("Table reservation " + deleteReservationTableNumber
                        + " successfully cancelled.");
                System.out.println("refundable advance: " + cancelDownPayment / 2);
            } else {
                System.out.println("Table not reserved.");
            }
        } else {
            System.out.println("Invalid number table.");
        }

    }
}