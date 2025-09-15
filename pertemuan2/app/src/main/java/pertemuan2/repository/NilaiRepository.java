package pertemuan2.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import pertemuan2.database.Database;
import pertemuan2.models.Nilai;

public class NilaiRepository {

    // Tambah nilai
    public void addNilai(Nilai n) {
        try (Connection conn = Database.connect()) { // ✅ pakai Database.connect()
            String sql = "INSERT INTO nilai (nim, kode_mk, nilai) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, n.getNim());
            ps.setString(2, n.getKodeMk());
            ps.setString(3, n.getNilai());
            ps.executeUpdate();
            System.out.println("✅ Nilai berhasil ditambahkan!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Ambil daftar nilai berdasarkan NIM
    public List<Nilai> getNilaiByNim(String nim) {
        List<Nilai> list = new ArrayList<>();
        try (Connection conn = Database.connect()) { // ✅ konsisten
            String sql = "SELECT * FROM nilai WHERE nim=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nim);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Nilai(
                    rs.getString("nim"),
                    rs.getString("kode_mk"),
                    rs.getString("nilai")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Hitung IPK mahasiswa
    public double hitungIPK(String nim) {
        double totalBobot = 0;
        int totalSks = 0;

        try (Connection conn = Database.connect()) { // ✅ konsisten
            String sql = """
                SELECT n.nilai, mk.sks
                FROM nilai n
                JOIN mata_kuliah mk ON n.kode_mk = mk.kode
                WHERE n.nim = ?
                """;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nim);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String huruf = rs.getString("nilai");
                int sks = rs.getInt("sks");
                double bobot = konversiNilai(huruf);

                totalBobot += bobot * sks;
                totalSks += sks;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (totalSks == 0) ? 0 : totalBobot / totalSks;
    }

    // Konversi nilai huruf ke bobot
    private double konversiNilai(String huruf) {
        return switch (huruf.toUpperCase()) {
            case "A" -> 4.0;
            case "B" -> 3.0;
            case "C" -> 2.0;
            case "D" -> 1.0;
            case "E" -> 0.0;
            default -> 0.0;
        };
    }
}
