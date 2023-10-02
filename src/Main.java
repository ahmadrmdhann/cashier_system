
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

        //Sistem registrasi

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

        // fitur order menu dan cetak struk
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
    }
}