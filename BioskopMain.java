import java.util.*;

public class BioskopMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Film[] films = new Film[3];
        films[0] = new Film("Attack on Titan: The Last Attack", "Animation", "14:00", 40000);
        films[1] = new Film("You Are the Apple of My Eye", "Drama, Romance", "22:00", 50000);
        films[2] = new Film("Cleaner", "Thriller, Action", "20:00", 45000);

        Studio[] studios = new Studio[3];
        studios[0] = new Studio(1, 50, films[0]);
        studios[1] = new Studio(2, 50, films[1]);
        studios[2] = new Studio(3, 50, films[2]);

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

            System.out.print("Masukkan nomor kursi (1-50): ");
            int nomorKursi = sc.nextInt();
            sc.nextLine();

            tiketList[i] = new Tiket(i + 101, films[filmPilihan], studios[filmPilihan], nomorKursi, penonton);
        }

        System.out.println("\nTiket yang telah dipesan:");
        for (Tiket tiket : tiketList) {
            tiket.tampilkanInfo();
        }

        sc.close();
    }
}
