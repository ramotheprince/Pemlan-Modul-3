package Tugas3_After;

/**
 * Representasi entitas pendaftaran pasien.
 *
 * <p>Menyimpan identitas pasien dan dokter penanggung jawab serta komponen biaya
 * (biaya jasa dokter dan biaya administrasi). Menyediakan utilitas untuk mencetak
 * ringkasan data dan menghitung total biaya.
 *
 * <h2>Kontrak & Catatan</h2>
 * <ul>
 *   <li>Semua nilai biaya diasumsikan dalam satuan mata uang yang konsisten (mis. Rupiah).</li>
 *   <li>Nilai biaya tidak negatif.</li>
 * </ul>
 *
 * @author TODO: Nama/NIM
 * @since 1.0
 */
public class PendaftaranPasien {

    /**
     * Membuat entitas pendaftaran baru.
     *
     * @param namaPasien  nama pasien (tidak kosong)
     * @param namaDokter  nama dokter penanggung jawab (tidak kosong)
     * @param biayaDokter biaya jasa dokter (>= 0)
     * @param biayaAdmin  biaya administrasi (>= 0)
     */
    public PendaftaranPasien(String namaPasien, String namaDokter, double biayaDokter, double biayaAdmin) { /* ... */ }

    /**
     * Mengembalikan nama pasien saat ini.
     *
     * @return nama pasien (dapat kosong sesuai implementasi)
     */
    public String getNamaPasien() { /* ... */ return null; }

    /**
     * Mengubah nama pasien.
     *
     * @param namaPasien nama pasien baru
     */
    public void setNamaPasien(String namaPasien) { /* ... */ }

    /**
     * Mengembalikan nama dokter penanggung jawab.
     *
     * @return nama dokter
     */
    public String getNamaDokter() { /* ... */ return null; }

    /**
     * Mengubah nama dokter penanggung jawab.
     *
     * @param namaDokter nama dokter baru
     */
    public void setNamaDokter(String namaDokter) { /* ... */ }

    /**
     * Mengembalikan besaran biaya jasa dokter.
     *
     * @return biaya jasa dokter
     */
    public double getBiayaDokter() { /* ... */ return 0D; }

    /**
     * Mengubah besaran biaya jasa dokter.
     *
     * @param biayaDokter nilai biaya (>= 0)
     */
    public void setBiayaDokter(double biayaDokter) { /* ... */ }

    /**
     * Mengembalikan besaran biaya administrasi.
     *
     * @return biaya administrasi
     */
    public double getBiayaAdmin() { /* ... */ return 0D; }

    /**
     * Mengubah besaran biaya administrasi.
     *
     * @param biayaAdmin nilai biaya (>= 0)
     */
    public void setBiayaAdmin(double biayaAdmin) { /* ... */ }

    /**
     * Mencetak ringkasan data pasien beserta total biaya ke keluaran standar.
     * <p>Format dan tujuan tampilan dapat disesuaikan (mis. ke konsol/log).</p>
     */
    public void printDataPasien() { /* ... */ }

    /**
     * Menghitung total biaya pendaftaran.
     * <p>Implementasi yang umum: {@code biayaDokter + biayaAdmin}.</p>
     *
     * @return total biaya pendaftaran
     */
    private double hitungTotalBiaya() { /* ... */ return 0D; }
}
//tes git

