package features;

import java.util.Scanner;

public class Registration {
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
                    case 4:
                        System.out.print("Enter a new username: ");
                        newUsername = sc.next();
                        System.out.print("Enter a new password: ");
                        newPassword = sc.next();
                        // mencari index yang kosong
                            for (int i = 1; i < usernames.length; i++) {
                                if (usernames[i] == null) {
                                    usernames[i] = newUsername;
                                    passwords[i] = newPassword;
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