import java.time.LocalDateTime;
import java.util.*;

public class BioskopMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] jamTayang = {"14:00", "16:00", "18:00", "20:00", "22:00"};

        Film[] films = new Film[3];
        films[0] = new Film("Attack on Titan: The Last Attack", "Animation", jamTayang, 40000, 50);
        films[1] = new Film("You Are the Apple of My Eye", "Drama, Romance", jamTayang, 50000, 50);
        films[2] = new Film("Cleaner", "Thriller, Action", jamTayang, 45000, 50);

        Studio[] studios = new Studio[3];
        studios[0] = new Studio(1, 50, films[0]);
        studios[1] = new Studio(2, 50, films[1]);
        studios[2] = new Studio(3, 50, films[2]);

        LocalDateTime now = LocalDateTime.now();
        int currentHour = now.getHour();
        
        // if (currentHour >= 22) {
        //     System.out.println("Maaf, bioskop kami sudah tutup. Silahkan kembali lagi besok.");
        //     sc.close();
        //     return;
        // } else if (currentHour < 14) {
        //     System.out.println("Maaf, bioskop kami belum buka. Silahkan datang pukul 14.00 WIB");
        //     sc.close();
        //     return;
        // }

        System.out.print("Masukkan jumlah tiket yang ingin dipesan: ");
        int jumlahTiket = sc.nextInt();
        sc.nextLine();

        Tiket[] tiketList = new Tiket[jumlahTiket];

        for (int i = 0; i < jumlahTiket; i++) {
            System.out.print("Masukkan nama penonton: ");
            String nama = sc.nextLine();
            Penonton penonton = new Penonton(nama);

            System.out.println("Pilih film:");
            for (int j = 0; j < films.length; j++) {
                System.out.println((j + 1) + ". " + films[j].judul);
            }
            int filmPilihan = sc.nextInt() - 1;
            sc.nextLine();

            System.out.println("Pilih jam tayang yang tersedia:");
            for (int j = 0; j < jamTayang.length; j++) {
                int jam = Integer.parseInt(jamTayang[j].split(":" )[0]);
                if (jam > currentHour) {
                    System.out.println((j + 1) + ". " + jamTayang[j]);
                }
            }
            int jamPilihan = sc.nextInt() - 1;
            sc.nextLine();

            int nomorKursi;
            while (true) {
                System.out.print("Masukkan nomor kursi (1-50): ");
                nomorKursi = sc.nextInt();
                
                if (nomorKursi < 1 || nomorKursi > studios[filmPilihan].kapasitasKursi) {
                    System.out.println("Nomor kursi tidak valid. Silakan pilih nomor yang sesuai.");
                } else if (films[filmPilihan].kursiTerisi[jamPilihan][nomorKursi]) {
                    System.out.println("Kursi ini sudah dipesan! Silakan pilih kursi lain.");
                } else {
                    films[filmPilihan].kursiTerisi[jamPilihan][nomorKursi] = true;
                    break;
                }
            }
            sc.nextLine();

            tiketList[i] = new Tiket(i + 101, films[filmPilihan], studios[filmPilihan], nomorKursi, jamPilihan, penonton);
        }

        System.out.println("\nTiket yang telah dipesan:");
        for (Tiket tiket : tiketList) {
            tiket.tampilkanInfo();
        }

        sc.close();
    }
}
