package pertemuan2.models;

public class Jurusan {
    private String kode;
    private String nama;

    public Jurusan(String kode, String nama) {
        this.kode = kode;
        this.nama = nama;
    }

    public String getKode() { return kode; }
    public String getNama() { return nama; }
}
