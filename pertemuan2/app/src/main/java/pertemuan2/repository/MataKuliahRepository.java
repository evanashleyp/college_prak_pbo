package pertemuan2.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import pertemuan2.database.Database;
import pertemuan2.models.MataKuliah;

public class MataKuliahRepository {

    public void addMataKuliah(MataKuliah mk) {
        try (Connection conn = Database.connect()) {
            String sql = "INSERT INTO mata_kuliah (kode, nama, sks, kode_jurusan) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mk.getKode());
            ps.setString(2, mk.getNama());
            ps.setInt(3, mk.getSks());
            ps.setString(4, mk.getKodeJurusan()); // ✅ simpan kode jurusan
            ps.executeUpdate();
            System.out.println("✅ Mata kuliah berhasil ditambahkan!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<MataKuliah> getAllMataKuliah() {
        List<MataKuliah> list = new ArrayList<>();
        try (Connection conn = Database.connect()) {
            String sql = "SELECT * FROM mata_kuliah";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                list.add(new MataKuliah(
                    rs.getString("kode"),
                    rs.getString("nama"),
                    rs.getInt("sks"),
                    rs.getString("kode_jurusan") // ✅ ambil kode jurusan
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
