package features;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inisialisasi Sistem Registrasi
        String usernameOwner = "Owner", passwordOwner = "owner123";
        String username, password;
        boolean isCorrect = false;


        // Sistem Registrasi
        while (!isCorrect) {
            System.out.println("+-----------------------------------------+");
            System.out.println("|                   LOG IN                |");
            System.out.println("+-----------------------------------------+");
            System.out.print("tUsername\t: ");
            username = sc.nextLine();
            if (username.equals(usernameOwner)) {
                System.out.print("Password\t: ");
                password = sc.nextLine();
                if (password.equals(passwordOwner)) {
                    System.out.println("\nAnda berhasil login\n");
                    isCorrect=true;
                }
                else {
                    System.out.println("\nPassword yang anda masukkan salah\n");
                    continue;
                }
            }
            else {
                System.out.println("\nUsername yang anda masukkan tidak ditemukan\n");
                continue;
            }
        }
    }
}
