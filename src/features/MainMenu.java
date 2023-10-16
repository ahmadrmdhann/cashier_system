package features;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inisialisasi Main Menu
        int menuChoice;
        boolean isCorrectMenu = false, isDone = false;

        // Main Menu
        while (!isCorrectMenu) {
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

            if (menuChoice == 0){
                isCorrectMenu = true;
                break;
            }

            while (!isDone) {
                switch (menuChoice) {
                    case 1:
                        // Pemesanan Menu
                        break;
                    case 2:
                        // Manajemen Stock
                    case 3:
                        // Pengaturan Diskon
                    case 4:
                        // Tambah Akun
                    case 5:
                        // Reservasi Meja
                    case 6:
                        // Reserved for futher
                    case 7:
                        // Reserved for futher
                    default:
                        System.out.println("Menu yang anda pilih tidak valid!");
                        isDone = true;
                        break;
                }
            }
        }
    }
}
