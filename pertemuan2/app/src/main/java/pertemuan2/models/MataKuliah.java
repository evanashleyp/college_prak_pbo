package pertemuan2.models;

public class MataKuliah {
    private String kode;
    private String nama;
    private int sks;
    private String kodeJurusan; // ✅ Tambahan field untuk relasi ke Jurusan

    // ✅ Constructor lengkap
    public MataKuliah(String kode, String nama, int sks, String kodeJurusan) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
        this.kodeJurusan = kodeJurusan;
    }

    // Getter & Setter
    public String getKode() { return kode; }
    public void setKode(String kode) { this.kode = kode; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public int getSks() { return sks; }
    public void setSks(int sks) { this.sks = sks; }

    public String getKodeJurusan() { return kodeJurusan; }
    public void setKodeJurusan(String kodeJurusan) { this.kodeJurusan = kodeJurusan; }
}
