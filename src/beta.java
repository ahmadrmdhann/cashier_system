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
        String[][] menu = { // inisialisasi array menu, indeks kolom 0 untuk makanan dan indeks kolom 1 untuk minuman
            {"Nasi Goreng", "Teh Hangat"}, // maks 10 makanan
            {"Soto", "Es Teh"}, // maks 10 minuman
            {"Pecel", "Jeruk Hangat"},
            {"Rawon", "Es Jeruk"},
            {null, null}, // persipan untuk penambahan menu
            {null, null},
            {null, null},
            {null, null},
            {null, null},
            {null, null}
        };
        int[][] priceStockFood = { // Inisialisasi array harga dan stock makanan, kolom 0 untuk harga dan kolom 1 untuk stock
            {10000, 100}, // price & stock nasi goreng
            {12000, 100}, // price & stock soto
            {7000, 3}, // price & stock pecel
            {15000, 0}, // price & stock rawon
            {0 , 0}, // persiapan untuk penambahan menu makanan
            {0 , 0}, // mask 10 makanan
            {0 , 0},
            {0 , 0},
            {0 , 0},
            {0 , 0},
        };
        int[][] priceStockBeverage = { // Inisialisasi array harga dan stock minuman, kolom 0 untuk harga dan kolom 1 untuk stock
            {3000, 100}, // price & stock teh hangat
            {5000, 100}, // price & stock es teh
            {4000, 0}, // price & stock jeruk hangat
            {6000, 0}, // price & stock es jeruk
            {0 , 0}, // persiapan untuk penambahan menu minuman
            {0 , 0}, // maks 10 minuman
            {0 , 0},
            {0 , 0},
            {0 , 0},
            {0 , 0}
        };
        String[][] menuCode = {
            {"A1", "B1"},
            {"A2", "B2"},
            {"A3", "B3"},
            {"A4", "B4"},
            {"A5", "B5"},
            {"A6", "B6"},
            {"A7", "B7"},
            {"A8", "B8"},
            {"A9", "B9"},
            {"A10", "B10"}
        };
        int numbersOfOrder; // variabel untuk menerima jumlah pesanan
        String selectedMenu; // variabel untuk menerima input menuCode dari pengguna
        int menuType = -1; // variabel untuk menentukan jenis menu (makanan/minuman)
        int menuAmmount; // variabel untuk menerima banyaknya order dalam satu jenis makanan atau minuman

        /*
         * Menu Settings Feature
         */
        boolean loopMenuSettings = false; // variabel untuk looping menu settings
        int inputMenuSettings; // variabel untuk menerima inputan dalam menu settings
        String inputUpdateStock; // variabel untuk menerima inputan dalam menu update stock
        String inputChangePrice; // variabel untuk menerima inputan dalam menu change price
        String inputDeleteMenu;
        String newMenu; // variabel untuk menerima input nama menu baru
        int newStock; // variabel untuk menerima input stock yang akan di tambahkan
        int newPrice; // variabel untuk menerima input harga baru



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
            if (userIndex >= 0) {
                System.out.print("Password\t: ");
                password = sc.nextLine();
                if (password.equals(account[userIndex][1])) { // indeks kolom 1 digunakan hanya untuk mengakses password
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

                    System.out.println("\nWelcome to our Restaurant!\n");
                    System.out.println("-------------------- MAIN MENU --------------------");
                    System.out.println("[1] Order Here!"); // In Progress
                    System.out.println("[2] Menu Settings"); // Feature Done
                    System.out.println("[3] Account Settings"); // Feature Done
                    System.out.println("[4] Table Reservation"); // In Progress
                    System.out.println("[5] Sales Report"); // Still Developing
                    System.out.println("[0] Log Out");
                    System.out.print("Select the menu you want: ");
                    inputMenu = sc.nextInt();
                    switch (inputMenu) {
                        case 0:
                            isLoggedIn = false;
                            backMenu = true;
                            break;

                        case 1:
                            System.out.println("\n\t+-------------------------------------------------------+");
                            System.out.println("\t|                                                       |");
                            System.out.println("\t|                        MENU                           |");
                            System.out.println("\t|                                                       |");
                            System.out.println("\t+---- Code -----|------ Food -------|- Price -|- Stock -+");
                            for (int i = 0; i < menu.length; i++) {
                                if (menu[i][0] != null) { // pemilihan digunakan hanya untuk menampilkan selain data default
                                    System.out.printf("\t|\t%-3s\t| %-16s  |  %5d  |   %3s   |\n", menuCode[i][0], menu[i][0], priceStockFood[i][0], priceStockFood[i][1]);
                                }
                            }
                            System.out.println("\t+---- Code -----|---- Beverage -----|- Price -|- Stock -+");
                            for (int i = 0; i < menu.length; i++) {
                                if (menu[i][1] != null) { // pemilihan digunakan hanya untuk menampilkan selain data default
                                    System.out.printf("\t|\t%-3s\t| %-16s  |  %5d  |   %3s   |\n", menuCode[i][1], menu[i][1], priceStockBeverage[i][0], priceStockBeverage[i][1]);
                                }
                            }
                            System.out.println("\t+-------------------------------------------------------+");
                            System.out.print("How much menu do you want to order? ");
                            numbersOfOrder = sc.nextInt();
                            sc.nextLine();
                            for (int i = 0; i < numbersOfOrder; i++) {
                                System.out.print("["+(i+1)+"] Select the menu do you want to order (use the code) : ");
                                selectedMenu = sc.nextLine();
                                if (selectedMenu.equalsIgnoreCase(menuCode[i][0]) || selectedMenu.equalsIgnoreCase(menuCode[i][1])) {
                                    menuIndex = i;
                                    if (selectedMenu.startsWith("A") || selectedMenu.startsWith("a")) {
                                        menuType = 0;
                                    }
                                    if (selectedMenu.startsWith("B") || selectedMenu.startsWith("b")) {
                                        menuType = 1;
                                    }
                                    System.out.print("Enter the quantity of "+menu[menuIndex][menuType]+" : ");
                                    menuAmmount = sc.nextInt();
                                }
                            }
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
                                switch (inputMenuSettings) {
                                    case 0:
                                        loopMenuSettings = true;
                                        break;
                                    
                                    case 1:
                                        System.out.println("\n\t+-------------------------------------------------------+");
                                        System.out.println("\t|                                                       |");
                                        System.out.println("\t|                        MENU                           |");
                                        System.out.println("\t|                                                       |");
                                        System.out.println("\t+---- Code -----|------ Food -------|- Price -|- Stock -+");
                                        for (int i = 0; i < menu.length; i++) {
                                            if (menu[i][0] != null) { // pemilihan digunakan hanya untuk menampilkan selain data default
                                                System.out.printf("\t|\t%-3s\t| %-16s  |  %5d  |   %3s   |\n", menuCode[i][0], menu[i][0], priceStockFood[i][0], priceStockFood[i][1]);
                                            }
                                        }
                                        System.out.println("\t+---- Code -----|---- Beverage -----|- Price -|- Stock -+");
                                        for (int i = 0; i < menu.length; i++) {
                                            if (menu[i][1] != null) { // pemilihan digunakan hanya untuk menampilkan selain data default
                                                System.out.printf("\t|\t%-3s\t| %-16s  |  %5d  |   %3s   |\n", menuCode[i][1], menu[i][1], priceStockBeverage[i][0], priceStockBeverage[i][1]);
                                            }
                                        }
                                        System.out.println("\t+-------------------------------------------------------+");
                                        break;
                                    
                                    case 2:
                                        System.out.println("\nUpdate Stock ");
                                        System.out.println("Food : ");
                                        for (int i = 0; i < menu.length; i++) {
                                            if (menu[i][0] != null) {
                                                System.out.println("["+(i+1)+"] "+menu[i][0]+" ("+menuCode[i][0]+")");
                                            }
                                        }
                                        System.out.println("Beverage : ");
                                        for (int i = 0; i < menu.length; i++) {
                                            if (menu[i][1] != null) {
                                                System.out.println("["+(i+1)+"] "+menu[i][1]+" ("+menuCode[i][1]+")");
                                            }
                                        }
                                        System.out.print("Select the menu you want to update (use the code) : ");
                                        inputUpdateStock = sc.next();
                                        for (int i = 0; i < menuCode.length; i++) {
                                            if (inputUpdateStock.equalsIgnoreCase(menuCode[i][0]) || inputUpdateStock.equalsIgnoreCase(menuCode[i][1])) {
                                                menuIndex = i;
                                                if (menu[menuIndex][0] != null && menu[menuIndex][1] != null) {
                                                    if (inputUpdateStock.equalsIgnoreCase(menuCode[i][0])) {
                                                        System.out.print("\nInsert new stock of "+menu[menuIndex][0]+" : ");
                                                        newStock = sc.nextInt();
                                                        priceStockFood[menuIndex][1] += newStock;
                                                        System.out.println("Stock updated.");
                                                    }
                                                    if (inputUpdateStock.equalsIgnoreCase(menuCode[i][1])) {
                                                        System.out.print("\nInsert new stock of "+menu[menuIndex][1]+" : ");
                                                        newStock = sc.nextInt();
                                                        priceStockBeverage[menuIndex][1] += newStock;
                                                        System.out.println("Stock updated.");
                                                    }
                                                }
                                                else {
                                                    System.out.println("\nInvalid input.");
                                                }
                                                break;
                                            }
                                            else if (i == menu.length-1){
                                                System.out.println("\nInvalid input.");
                                            }
                                        }
                                        break;

                                    case 3:
                                        System.out.println("\nChange Price");
                                        System.out.println("Food : ");
                                        for (int i = 0; i < menu.length; i++) {
                                            if (menu[i][0] != null) {
                                                System.out.println("["+(i+1)+"] "+menu[i][0]+" ("+menuCode[i][0]+")");
                                            }
                                        }
                                        System.out.println("Beverage : ");
                                        for (int i = 0; i < menu.length; i++) {
                                            if (menu[i][1] != null) {
                                                System.out.println("["+(i+1)+"] "+menu[i][1]+" ("+menuCode[i][1]+")");
                                            }
                                        }
                                        System.out.print("Select the menu you want to update (use the code) : ");
                                        inputChangePrice = sc.next();
                                        for (int i = 0; i < menuCode.length; i++) {
                                            if (inputChangePrice.equalsIgnoreCase(menuCode[i][0]) || inputChangePrice.equalsIgnoreCase(menuCode[i][1])) {
                                                menuIndex = i;
                                                if (menu[menuIndex][0] != null && menu[menuIndex][1] != null) {
                                                    if (inputChangePrice.equalsIgnoreCase(menuCode[i][0])) {
                                                        System.out.print("\nInput new price of "+menu[menuIndex][0]+" : ");
                                                        newPrice = sc.nextInt();
                                                        priceStockFood[menuIndex][0] = newPrice;
                                                        System.out.println("Price Changed.");
                                                    }
                                                    if (inputChangePrice.equalsIgnoreCase(menuCode[i][1])) {
                                                        System.out.print("\nInput new price of "+menu[menuIndex][1]+" : ");
                                                        newPrice = sc.nextInt();
                                                        priceStockBeverage[menuIndex][0] = newPrice;
                                                        System.out.println("Price Changed.");
                                                    }
                                                }
                                                else { // jika nilai input merujuk pada menu yang tidak memiliki data
                                                    System.out.println("\nInvalid input.");
                                                }
                                                break;
                                            }
                                            else if (i == menu.length-1){ // jika input melebihi length dari menu
                                                System.out.println("\nInvalid input.");
                                            }
                                        }
                                        break;
                                    case 4:
                                        System.out.println("\nAdd New Menu");
                                        System.out.println("[1] Food");
                                        System.err.println("[2] Beverage");
                                        System.out.print("Select type of menu : ");
                                        menuType = sc.nextInt();
                                        if (menuType == 1) {
                                            System.out.print("Add new food name : ");
                                            sc.nextLine(); // biar bisa input yang berisi 2 kata
                                            newMenu = sc.nextLine();
                                            System.out.print("Set a price for "+newMenu+" : ");
                                            newPrice = sc.nextInt();
                                            System.out.print("Set a stock for "+newMenu+" : ");
                                            newStock = sc.nextInt();
                                            for (int i = 0; i < menuCode.length; i++) {
                                                if (menu[i][0] == null) {
                                                    menuIndex = i;
                                                    menu[menuIndex][0] = newMenu;
                                                    priceStockFood[menuIndex][0] = newPrice;
                                                    priceStockFood[menuIndex][1] = newStock;
                                                    System.out.println("Menu succesfully added.");
                                                    break;
                                                }
                                            }
                                        }
                                        if (menuType == 2) {
                                            System.out.print("Add new beverage name : ");
                                            sc.nextLine(); // biar bisa input yang berisi 2 kata
                                            newMenu = sc.nextLine();
                                            System.out.print("Set a price for "+newMenu+" : ");
                                            newPrice = sc.nextInt();
                                            System.out.print("Set a stock for "+newMenu+" : ");
                                            newStock = sc.nextInt();
                                            for (int i = 0; i < menuCode.length; i++) {
                                                if (menu[i][1] == null) {
                                                    menuIndex = i;
                                                    menu[menuIndex][1] = newMenu;
                                                    priceStockBeverage[menuIndex][0] = newPrice;
                                                    priceStockBeverage[menuIndex][1] = newStock;
                                                    System.out.println("Menu succesfully added.");
                                                    break;
                                                }
                                            }
                                        }
                                        else {
                                            System.out.println("Invalid input.");
                                        }
                                        break;
                                    
                                    case 5:
                                        System.out.println("\n Delete the menu");
                                        System.out.println("Available menu to delete : ");
                                        System.out.println("Food : ");
                                        for (int i = 0; i < menu.length; i++) {
                                            if (menu[i][0] != null) {
                                                System.out.println("["+(i+1)+"] "+menu[i][0]+" ("+menuCode[i][0]+")");
                                            }
                                        }
                                        System.out.println("Beverage : ");
                                        for (int i = 0; i < menu.length; i++) {
                                            if (menu[i][1] != null) {
                                                System.out.println("["+(i+1)+"] "+menu[i][1]+" ("+menuCode[i][1]+")");
                                            }
                                        }
                                        System.out.print("Select the menu you want to delete : ");
                                        inputDeleteMenu = sc.next();
                                        for (int i = 0; i < menuCode.length; i++) {
                                            if (inputDeleteMenu.equalsIgnoreCase(menuCode[i][0]) || inputDeleteMenu.equalsIgnoreCase(menuCode[i][1])) {
                                                menuIndex = i;
                                                if (menu[menuIndex][0] != null && menu[menuIndex][1] != null) {
                                                    if (inputDeleteMenu.equalsIgnoreCase(menuCode[i][0])) {
                                                        menu[menuIndex][0] = null;
                                                        priceStockFood[menuIndex][0] = 0;
                                                        priceStockFood[menuIndex][1] = 0;
                                                        System.out.println("\nMenu successfully deleted.");
                                                    }
                                                    if (inputDeleteMenu.equalsIgnoreCase(menuCode[i][1])) {
                                                        menu[menuIndex][1] = null;
                                                        priceStockBeverage[menuIndex][0] = 0;
                                                        priceStockBeverage[menuIndex][1] = 0;
                                                        System.out.println("\nMenu successfully deleted.");
                                                    }
                                                }
                                                else {
                                                    System.out.println("\nInvalid input.");
                                                }
                                                break;
                                            }
                                            else if (i == menu.length-1){
                                                System.out.println("\nInvalid input.");
                                            }
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
                                switch (inputAccount) {
                                    case 0:
                                        loopAccountSettings = true;
                                        break;

                                    case 1:
                                        System.out.println("\nView All Account : ");
                                        for (int i = 0; i < account.length; i++) {
                                            if (account[i][0] != null) { // Hanya untuk mengecek semua akun yang sudah ditambahkan
                                                System.out.println("[" + (i + 1) + "] " + account[i][0]);
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
                                        for (int i = 0; i < account.length; i++) {
                                            if (account[i][0] == null) {
                                                account[i][0] = newUsername;
                                                account[i][1] = newPassword;
                                                added = true;
                                                break;
                                            }
                                        }
                                        if (added) {
                                            System.out.println("Account added successfully."); // akan tampil jika sukses membuat akun
                                        } else {
                                            System.out.println("Account limit reached. Cannot add more accounts."); // akan tampil jika akun sudah melebihi 6
                                        }
                                        break;

                                    case 3:
                                        System.out.println("\nChange Username Account : ");
                                        for (int i = 1; i < account.length; i++) {
                                            if (account[i][0] != null) { // Hanya untuk mengecek semua akun yang sudah ditambahkan
                                                System.out.println("[" + i + "] " + account[i][0]);
                                            }
                                        }
                                        System.out.print("Select the account you want to change the username : ");
                                        changeUsername = sc.nextInt();
                                        System.out.print("Enter a new username : ");
                                        newUsername = sc.next();
                                        if (changeUsername >= 1 && changeUsername <= 5) {
                                            account[changeUsername][0] = newUsername;
                                        }
                                        break;
                                    
                                    case 4:
                                        System.out.println("\nChange Username Account : ");
                                        for (int i = 1; i < account.length; i++) {
                                            if (account[i][0] != null) { // Hanya untuk mengecek semua akun yang sudah ditambahkan
                                                System.out.println("[" + i + "] " + account[i][0]);
                                            }
                                        }
                                        System.out.print("Select the account you want to change the password : ");
                                        changePassword = sc.nextInt();
                                        System.out.print("Enter a new password : ");
                                        newPassword = sc.next();
                                        if (changePassword >= 1 && changePassword <= 5) {
                                            account[changePassword][1] = newPassword;
                                        }
                                        break;
                                    
                                    case 5:
                                        hasAccountToDelete = false;
                                        for (int i = 1; i < account.length; i++) {
                                            if (account[i][0] != null) { // memeriksa apakah username ada nilai
                                                hasAccountToDelete = true; // memberikan tanda jika ada username untuk dihapus
                                                System.out.println("\nDelete Account ");
                                                System.out.println("Available Account to Delete:");
                                                for (int j = 1; j < account.length; j++) {
                                                    if (account[j][0] != null) {
                                                        System.out.println("["+j+"] " + account[j][0]);
                                                    }
                                                }
                                                System.out.print("Select account to delete : ");
                                                inputDeleteAccount = sc.nextInt();
                                                if (inputDeleteAccount >= 1 && inputDeleteAccount <= account.length) {
                                                    if (account[inputDeleteAccount][0] != null) {
                                                        if (!account[inputDeleteAccount][0].equals("admin")) {
                                                            account[inputDeleteAccount][0] = null; // menghapus username akun yang diminta
                                                            account[inputDeleteAccount][1] = null; // menghapus password akun yang diminta
                                                            System.out.println("Delete successfully.");
                                                            break;
                                                        }
                                                        else {
                                                            System.out.println("You cannot delete the admin account.");
                                                            break;
                                                        }
                                                    }
                                                    else {
                                                        System.out.println("Account doesn't exist!");
                                                        break;
                                                    }
                                                }
                                                else {
                                                    System.out.println("Invalid account. Please enter a valid account.");
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

                        default:
                            System.out.println("\nInvalid input.");
                            break;
                    }
                }
                else { // menu yang khusus disiapkan untuk level selain admin
                    System.out.println("Sabar bang multi level masih tahap proses");
                    isLoggedIn = false;
                    backMenu = true;
                }
            }
        }
    }
}