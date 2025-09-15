package pertemuan1;
import java.util.*;

class Jurusan {
    String kode;
    String nama;
    ArrayList<MataKuliah> mataKuliahList = new ArrayList<>();

    public Jurusan(String kode, String nama) {
        this.kode = kode;
        this.nama = nama;
    }

    @Override
    public String toString() {
        return kode + " - " + nama;
    }
}

class MataKuliah {
    String kode;
    String nama;
    int sks;

    public MataKuliah(String kode, String nama, int sks) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
    }

    @Override
    public String toString() {
        return kode + " - " + nama + " (" + sks + " sks)";
    }
}

class Mahasiswa {
    String nim;
    String nama;
    Jurusan jurusan;
    Map<MataKuliah, String> indeksNilai = new HashMap<>(); // nilai huruf

    public Mahasiswa(String nim, String nama, Jurusan jurusan) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
    }

    @Override
    public String toString() {
        return nim + " - " + nama + " (" + jurusan.nama + ")";
    }
}

public class Modul1 {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Jurusan> jurusanList = new ArrayList<>();
    static ArrayList<Mahasiswa> mahasiswaList = new ArrayList<>();

    public static void main(String[] args) {
        int pilih;
        do {
            System.out.println("\n=== MENU AKADEMIK ===");
            System.out.println("1. Input Jurusan");
            System.out.println("2. Lihat Jurusan");
            System.out.println("3. Hapus Jurusan");
            System.out.println("4. Input Mata Kuliah ke Jurusan");
            System.out.println("5. Hapus Mata Kuliah dari Jurusan");
            System.out.println("6. Input Mahasiswa");
            System.out.println("7. Lihat Mahasiswa");
            System.out.println("8. Detail Mahasiswa (by NIM)");
            System.out.println("9. Beri Nilai Mahasiswa");
            System.out.println("10. Hitung IP Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilih = sc.nextInt(); sc.nextLine();

            switch (pilih) {
                case 1: inputJurusan(); break;
                case 2: lihatJurusan(); break;
                case 3: hapusJurusan(); break;
                case 4: inputMataKuliah(); break;
                case 5: hapusMataKuliah(); break;
                case 6: inputMahasiswa(); break;
                case 7: lihatMahasiswa(); break;
                case 8: detailMahasiswa(); break;
                case 9: beriNilai(); break;
                case 10: hitungIP(); break;
            }
        } while (pilih != 0);
    }

    // a. CRUD Jurusan
    static void inputJurusan() {
        System.out.print("Kode Jurusan: ");
        String kode = sc.nextLine();
        System.out.print("Nama Jurusan: ");
        String nama = sc.nextLine();
        jurusanList.add(new Jurusan(kode, nama));
    }

    static void lihatJurusan() {
        System.out.println("\nDaftar Jurusan:");
        for (Jurusan j : jurusanList) {
            System.out.println(j);
        }
    }

    static void hapusJurusan() {
        lihatJurusan();
        System.out.print("Masukkan kode jurusan yang akan dihapus: ");
        String kode = sc.nextLine();
        jurusanList.removeIf(j -> j.kode.equals(kode));
    }

    // b. CRUD Mata Kuliah
    static void inputMataKuliah() {
        lihatJurusan();
        System.out.print("Pilih kode jurusan: ");
        String kodeJ = sc.nextLine();
        Jurusan jurusan = findJurusan(kodeJ);
        if (jurusan != null) {
            System.out.print("Kode MK: ");
            String kode = sc.nextLine();
            System.out.print("Nama MK: ");
            String nama = sc.nextLine();
            System.out.print("SKS: ");
            int sks = sc.nextInt(); sc.nextLine();
            jurusan.mataKuliahList.add(new MataKuliah(kode, nama, sks));
        }
    }

    static void hapusMataKuliah() {
        lihatJurusan();
        System.out.print("Pilih kode jurusan: ");
        String kodeJ = sc.nextLine();
        Jurusan jurusan = findJurusan(kodeJ);
        if (jurusan != null) {
            for (MataKuliah mk : jurusan.mataKuliahList) {
                System.out.println(mk);
            }
            System.out.print("Kode MK yang dihapus: ");
            String kode = sc.nextLine();
            jurusan.mataKuliahList.removeIf(mk -> mk.kode.equals(kode));
        }
    }

    // c. CRUD Mahasiswa
    static void inputMahasiswa() {
        lihatJurusan();
        System.out.print("Masukkan kode jurusan: ");
        String kodeJ = sc.nextLine();
        Jurusan jurusan = findJurusan(kodeJ);
        if (jurusan != null) {
            System.out.print("NIM: ");
            String nim = sc.nextLine();
            System.out.print("Nama: ");
            String nama = sc.nextLine();
            mahasiswaList.add(new Mahasiswa(nim, nama, jurusan));
        }
    }

    static void lihatMahasiswa() {
        System.out.println("\nDaftar Mahasiswa:");
        for (Mahasiswa m : mahasiswaList) {
            System.out.println(m);
        }
    }

    static void detailMahasiswa() {
        System.out.print("Masukkan NIM: ");
        String nim = sc.nextLine();
        Mahasiswa m = findMahasiswa(nim);
        if (m != null) {
            System.out.println("NIM: " + m.nim);
            System.out.println("Nama: " + m.nama);
            System.out.println("Jurusan: " + m.jurusan.nama);
            System.out.println("Nilai:");
            for (Map.Entry<MataKuliah, String> e : m.indeksNilai.entrySet()) {
                System.out.println("  " + e.getKey().nama + " = " + e.getValue());
            }
        }
    }

    // d. Pemberian Nilai
    static void beriNilai() {
        System.out.print("Masukkan NIM: ");
        String nim = sc.nextLine();
        Mahasiswa m = findMahasiswa(nim);
        if (m != null) {
            if (m.jurusan.mataKuliahList.isEmpty()) {
                System.out.println("Jurusan belum memiliki mata kuliah.");
                return;
            }
            for (MataKuliah mk : m.jurusan.mataKuliahList) {
                System.out.print("Nilai untuk " + mk.nama + " (A/B/C/D/E): ");
                String nilai = sc.nextLine().toUpperCase();
                m.indeksNilai.put(mk, nilai);
            }
        }
    }

    // e. Hitung IP
    static void hitungIP() {
        System.out.print("Masukkan NIM: ");
        String nim = sc.nextLine();
        Mahasiswa m = findMahasiswa(nim);
        if (m != null) {
            double totalNilai = 0, totalSks = 0;
            for (Map.Entry<MataKuliah, String> e : m.indeksNilai.entrySet()) {
                int bobot = konversiNilai(e.getValue());
                totalNilai += bobot * e.getKey().sks;
                totalSks += e.getKey().sks;
            }
            double ip = (totalSks == 0) ? 0 : totalNilai / totalSks;
            System.out.println("IP Mahasiswa " + m.nama + " = " + ip);
        }
    }

    // Helper
    static Jurusan findJurusan(String kode) {
        for (Jurusan j : jurusanList) {
            if (j.kode.equals(kode)) return j;
        }
        return null;
    }

    static Mahasiswa findMahasiswa(String nim) {
        for (Mahasiswa m : mahasiswaList) {
            if (m.nim.equals(nim)) return m;
        }
        return null;
    }

    static int konversiNilai(String huruf) {
        return switch (huruf) {
            case "A" -> 4;
            case "B" -> 3;
            case "C" -> 2;
            case "D" -> 1;
            default -> 0;
        };
    }
}

