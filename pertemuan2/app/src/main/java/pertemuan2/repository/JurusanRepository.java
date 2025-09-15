package pertemuan2.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import pertemuan2.database.Database;
import pertemuan2.models.Jurusan;

public class JurusanRepository {

    public void addJurusan(Jurusan j) {
        try (Connection conn = Database.connect()) {
            String sql = "INSERT INTO jurusan (kode, nama) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, j.getKode());
            ps.setString(2, j.getNama());
            ps.executeUpdate();
            System.out.println("Jurusan berhasil ditambahkan!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Jurusan> getAllJurusan() {
        List<Jurusan> list = new ArrayList<>();
        try (Connection conn = Database.connect()) {
            String sql = "SELECT * FROM jurusan";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                list.add(new Jurusan(
                    rs.getString("kode"),
                    rs.getString("nama")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
