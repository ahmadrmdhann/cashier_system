
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String username, password;
        String usernameOwner = "Owner";
        String passwordOwner = "owner123";
        String namaPembeli;
        int jumlahNasiGoreng, jumlahMieGoreng, jumlahSate, jumlahAyamGoreng, jumlahAyamGeprek; 
        double totalHarga, uangPembeli, uangKembalian;
        boolean meja01 = true, meja02 = true, meja03 = true;
        boolean mejaStatusTrue = true;
        boolean mejaStatusFalse = false;
        String mejaMana;
        int jumlahOrang;

        // Sistem registrasi

        System.out.print("Masukkan username anda: ");
        username = sc.nextLine();
        System.out.print("Masukkan password anda: ");
        password = sc.nextLine();

        if (username.equalsIgnoreCase(usernameOwner) && password.equals(passwordOwner)) {
            System.out.println("Telah berhasil login sebagai Owner!");
        } else {
            System.out.println("User dan Passowrd salah!");
            System.exit(0);
        }

        // Fitur order menu dan cetak struk

        System.out.println("\nSelamat datang di restoran kami!");
        System.out.print("Silahkan masukkan nama anda untuk memulai memesan : ");
        namaPembeli = sc.nextLine();
        System.out.print("Berapa banyak anda ingin memesan Nasi Goreng (Rp. 10.000/pcs) : ");
        jumlahNasiGoreng = sc.nextInt();
        System.out.print("Berapa banyak anda ingin memesan Mie Goreng (Rp. 12.000/pcs): ");
        jumlahMieGoreng = sc.nextInt();
        System.out.print("Berapa banyak anda ingin memesan Sate (Rp. 15.000/pcs) : ");
        jumlahSate = sc.nextInt();
        System.out.print("Berapa banyak anda ingin memesan Ayam Goreng (Rp. 12.0000/pcs) : ");
        jumlahAyamGoreng = sc.nextInt();
        System.out.print("Berapa banyak anda ingin memesan Ayam Geprek (Rp. 10.000/pcs) : ");
        jumlahAyamGeprek = sc.nextInt();
        
        totalHarga = jumlahNasiGoreng * 10000 + jumlahMieGoreng * 12000 + jumlahSate * 15000 + jumlahAyamGoreng * 12000 + jumlahAyamGeprek * 10000;

        System.out.println("Total harga yang harus dibayarkan : " + totalHarga);
        System.out.print("Masukkan uang anda : ");
        uangPembeli = sc.nextDouble();

        uangKembalian = uangPembeli - totalHarga;

        System.out.println("\n\n----------------------Struk-----------------------");
        System.out.println("Jumlah nasi goreng yang anda pesan sebanyak : " + jumlahNasiGoreng);
        System.out.println("Jumlah mie goreng yang anga pesan sebanyak : " + jumlahMieGoreng);
        System.out.println("Jumlah sate yang anda pesan sebanyak : " + jumlahSate);
        System.out.println("Jumlah ayam goreng yang anda pesan sebanyak : " + jumlahAyamGoreng);
        System.out.println("Jumlah ayam geprek yang anda pesan sebanyak : " + jumlahAyamGeprek);
        System.out.println("Total harga yang harus anda bayar sebesar : Rp. " + totalHarga);
        System.out.println("Jumlah uang yang dibayarkan: Rp. " + uangPembeli);
        System.out.println("Total uang kembalian : Rp. " + uangKembalian);
        System.out.println(namaPembeli + " terima kasih sudah berbelanja di restoran kami");
        System.out.println("--------------------------------------------------------------");

        // Fitur reservasi meja
        if (meja01 == true) {
            System.out.println("\nMeja 1 tersedia!");
        }
        if (meja02 == true) {
            System.out.println("Meja 2 tersedia!");
        }
        if (meja03 == true) {
            System.out.println("Meja 3 tersedia!");
        }
        System.out.println("Pilihlah meja mana yang ingin anda tempati (1/2/3) ?");
        mejaMana = sc.nextLine();
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