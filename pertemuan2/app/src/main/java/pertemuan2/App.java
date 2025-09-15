package pertemuan2;

import java.util.List;
import java.util.Scanner;

import pertemuan2.models.*;
import pertemuan2.repository.*;

public class App {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        JurusanRepository jurusanRepo = new JurusanRepository();
        MahasiswaRepository mhsRepo = new MahasiswaRepository();
        MataKuliahRepository mkRepo = new MataKuliahRepository();
        NilaiRepository nilaiRepo = new NilaiRepository();

        int pilih;
        do {
            System.out.println("\n=== MENU AKADEMIK ===");
            System.out.println("1. Input Jurusan");
            System.out.println("2. Lihat Jurusan");
            System.out.println("3. Input Mata Kuliah");
            System.out.println("4. Lihat Mata Kuliah");
            System.out.println("5. Input Mahasiswa");
            System.out.println("6. Lihat Mahasiswa");
            System.out.println("7. Beri Nilai Mahasiswa");
            System.out.println("8. Lihat Nilai Mahasiswa");
            System.out.println("9. Hitung IPK Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilih = Integer.parseInt(sc.nextLine());

            switch (pilih) {
                case 1 -> inputJurusan(jurusanRepo);
                case 2 -> lihatJurusan(jurusanRepo);
                case 3 -> inputMataKuliah(mkRepo, jurusanRepo);
                case 4 -> lihatMataKuliah(mkRepo);
                case 5 -> inputMahasiswa(mhsRepo, jurusanRepo);
                case 6 -> lihatMahasiswa(mhsRepo);
                case 7 -> beriNilai(nilaiRepo, mkRepo, mhsRepo);
                case 8 -> lihatNilai(nilaiRepo);
                case 9 -> hitungIPK(nilaiRepo);
            }
        } while (pilih != 0);
    }

    // === Hitung IPK ===
    static void hitungIPK(NilaiRepository repo) {
        System.out.print("Masukkan NIM: ");
        String nim = sc.nextLine();
        double ipk = repo.hitungIPK(nim);
        System.out.printf("📊 IPK mahasiswa %s = %.2f\n", nim, ipk);
    }

    // === CRUD Jurusan ===
    static void inputJurusan(JurusanRepository repo) {
        System.out.print("Kode Jurusan: ");
        String kode = sc.nextLine();
        System.out.print("Nama Jurusan: ");
        String nama = sc.nextLine();
        repo.addJurusan(new Jurusan(kode, nama));
    }

    static void lihatJurusan(JurusanRepository repo) {
        List<Jurusan> list = repo.getAllJurusan();
        System.out.println("\n📚 Daftar Jurusan:");
        for (Jurusan j : list) {
            System.out.println(j.getKode() + " - " + j.getNama());
        }
    }

    // === CRUD Mata Kuliah ===
    static void inputMataKuliah(MataKuliahRepository repo, JurusanRepository jurusanRepo) {
        // tampilkan daftar jurusan biar ada contekan
        lihatJurusan(jurusanRepo);

        System.out.print("Kode MK: ");
        String kode = sc.nextLine();
        System.out.print("Nama MK: ");
        String nama = sc.nextLine();
        System.out.print("SKS: ");
        int sks = Integer.parseInt(sc.nextLine());
        System.out.print("Kode Jurusan: ");
        String kodeJurusan = sc.nextLine();

        repo.addMataKuliah(new MataKuliah(kode, nama, sks, kodeJurusan));
    }

    static void lihatMataKuliah(MataKuliahRepository repo) {
        List<MataKuliah> list = repo.getAllMataKuliah();
        System.out.println("\n📘 Daftar Mata Kuliah:");
        for (MataKuliah mk : list) {
            System.out.println(mk.getKode() + " - " + mk.getNama() + 
                               " (" + mk.getSks() + " SKS) - Jurusan " + mk.getKodeJurusan());
        }
    }

    // === CRUD Mahasiswa ===
    static void inputMahasiswa(MahasiswaRepository repo, JurusanRepository jurusanRepo) {
        // tampilkan daftar jurusan biar ada contekan
        lihatJurusan(jurusanRepo);

        System.out.print("NIM: ");
        String nim = sc.nextLine();
        System.out.print("Nama: ");
        String nama = sc.nextLine();
        System.out.print("Kode Jurusan: ");
        String kodeJurusan = sc.nextLine();

        repo.addMahasiswa(new Mahasiswa(nim, nama, kodeJurusan));
    }

    static void lihatMahasiswa(MahasiswaRepository repo) {
        List<Mahasiswa> list = repo.getAllMahasiswa();
        System.out.println("\n📋 Daftar Mahasiswa:");
        for (Mahasiswa m : list) {
            System.out.println(m.getNim() + " - " + m.getNama() + 
                               " (Jurusan: " + m.getKodeJurusan() + ")");
        }
    }

    // === CRUD Nilai ===
    static void beriNilai(NilaiRepository repo, MataKuliahRepository mkRepo, MahasiswaRepository mhsRepo) {
        // tampilkan daftar mahasiswa
        lihatMahasiswa(mhsRepo);
        System.out.print("NIM: ");
        String nim = sc.nextLine();

        // tampilkan daftar mata kuliah
        lihatMataKuliah(mkRepo);
        System.out.print("Kode MK: ");
        String kodeMk = sc.nextLine();

        System.out.print("Nilai (A/B/C/D/E): ");
        String nilai = sc.nextLine().toUpperCase();

        repo.addNilai(new Nilai(nim, kodeMk, nilai));
    }

    static void lihatNilai(NilaiRepository repo) {
        System.out.print("Masukkan NIM: ");
        String nim = sc.nextLine();
        List<Nilai> list = repo.getNilaiByNim(nim);
        System.out.println("\n📑 Nilai Mahasiswa:");
        for (Nilai n : list) {
            System.out.println("MK " + n.getKodeMk() + " = " + n.getNilai());
        }
    }
}
