package pertemuan2.models;

public class Mahasiswa {
    private String nim;
    private String nama;
    private String kodeJurusan;

    // ✅ Constructor lengkap
    public Mahasiswa(String nim, String nama, String kodeJurusan) {
        this.nim = nim;
        this.nama = nama;
        this.kodeJurusan = kodeJurusan;
    }

    // Getter & Setter
    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getKodeJurusan() { return kodeJurusan; }
    public void setKodeJurusan(String kodeJurusan) { this.kodeJurusan = kodeJurusan; }
}
