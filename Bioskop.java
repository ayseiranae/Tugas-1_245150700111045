import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Film {
    String judul;
    String genre;
    String[] jamTayang;
    int hargaTiket;
    boolean[][] kursiTerisi;

    Film(String judul, String genre, String[] jamTayang, int hargaTiket, int kapasitas) {
        this.judul = judul;
        this.genre = genre;
        this.jamTayang = jamTayang;
        this.hargaTiket = hargaTiket;
        this.kursiTerisi = new boolean[jamTayang.length][kapasitas + 1];
    }
}

class Studio {
    int nomorStudio;
    int kapasitasKursi;
    Film film;

    Studio(int nomorStudio, int kapasitasKursi, Film film) {
        this.nomorStudio = nomorStudio;
        this.kapasitasKursi = kapasitasKursi;
        this.film = film;
    }
}

class Penonton {
    String nama;

    Penonton(String nama) {
        this.nama = nama;
    }
}

class Tiket {
    int nomorTiket;
    Film film;
    Studio studio;
    int nomorKursi;
    int jamIndex;
    Penonton penonton;
    String tanggalWaktu;
    
    Tiket(int nomorTiket, Film film, Studio studio, int nomorKursi, int jamIndex, Penonton penonton) {
        this.nomorTiket = nomorTiket;
        this.film = film;
        this.studio = studio;
        this.nomorKursi = nomorKursi;
        this.jamIndex = jamIndex;
        this.penonton = penonton;
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss");
        this.tanggalWaktu = now.format(formatter);
    }

    void justify(String label, String value) {
        int width = 50;
        int separator = 15;
        System.out.print(String.format("%-" + separator + "s: %" + (width - separator - 2) + "s\n", label, value));
    }

    void center(String text) {
        int tengah = (50 - text.length()) / 2;        
        for (int i = 0; i < tengah; i++) {
            System.out.print(" ");
        }        
        System.out.println(text);
    }

    void tampilkanInfo() {
        System.out.println();
        System.out.println("__________________________________________________");
        System.out.println();
        center("Nadiha's Cinema");
        System.out.println("__________________________________________________");
        justify("Nomor Tiket ", Integer.toString(nomorTiket));
        justify("Time", tanggalWaktu);
        justify("Nama Penonton ", penonton.nama);
        justify("Film ", film.judul);
        justify("Genre ", film.genre);
        justify("Jam Tayang ", film.jamTayang[jamIndex]);
        justify("Studio ", Integer.toString(studio.nomorStudio));
        justify("Nomor Kursi ", Integer.toString(nomorKursi));
        justify("Harga Tiket ", String.format("Rp %,d", film.hargaTiket));
        System.out.println("__________________________________________________");
        center("Selamat Menonton!");
        center("Terima Kasih");
        System.out.println("__________________________________________________");
        System.out.println();
        center("(CUT HERE)");
    }
}
