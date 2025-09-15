package pertemuan2.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import pertemuan2.database.Database;
import pertemuan2.models.Mahasiswa;

public class MahasiswaRepository {

    public void addMahasiswa(Mahasiswa m) {
        try (Connection conn = Database.connect()) {
            String sql = "INSERT INTO mahasiswa (nim, nama, kode_jurusan) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, m.getNim());
            ps.setString(2, m.getNama());
            ps.setString(3, m.getKodeJurusan());
            ps.executeUpdate();
            System.out.println("Mahasiswa berhasil ditambahkan!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Mahasiswa> getAllMahasiswa() {
        List<Mahasiswa> list = new ArrayList<>();
        try (Connection conn = Database.connect()) {
            String sql = "SELECT * FROM mahasiswa";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                list.add(new Mahasiswa(
                    rs.getString("nim"),
                    rs.getString("nama"),
                    rs.getString("kode_jurusan")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
