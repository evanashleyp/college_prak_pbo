package pertemuan2.models;

public class Nilai {
    private String nim;
    private String kodeMk;
    private String nilai;

    // ✅ Constructor lengkap
    public Nilai(String nim, String kodeMk, String nilai) {
        this.nim = nim;
        this.kodeMk = kodeMk;
        this.nilai = nilai;
    }

    // Getter & Setter
    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }

    public String getKodeMk() { return kodeMk; }
    public void setKodeMk(String kodeMk) { this.kodeMk = kodeMk; }

    public String getNilai() { return nilai; }
    public void setNilai(String nilai) { this.nilai = nilai; }
}
