package pertemuan1;
public class App {
  public static void main(String[] args) {
    System.out.println(hitungNilaiAkhir(5, 80)); // Output: 65
    System.out.println(hitungNilaiAkhir(2, 80)); // Output: 80
    System.out.println(hitungNilaiAkhir(0, 80)); // Output: 80
    System.out.println(hitungNilaiAkhir(10, 80)); // Output: 0
  }
  public static float hitungNilaiAkhir(int jumlahAlpha, double nilaiAkhir) {
      // Jika alpha lebih dari 2, kurangi nilai akhir
      if (jumlahAlpha > 2) {
          int pengurang = (jumlahAlpha - 2) * 5;
          nilaiAkhir -= pengurang;
      }
  
      // Pastikan nilai akhir tidak negatif
      if (nilaiAkhir < 0) {
          nilaiAkhir = 0;
      }
  
      return (float) nilaiAkhir;
  }
}

