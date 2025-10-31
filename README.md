# Modul 2 – Dokumentasi & README (JavaDoc)
Program ini merupakan hasil refactoring Modul 2 sesuai spreadsheet tugas. Paket utama yang terdeteksi dari berkas kelas adalah:

- `Tugas3_After.Main` — *entry point* aplikasi.
- `Tugas3_After.PendaftaranPasien` — model/layanan pendaftaran pasien (menyimpan data inti dan utilitas tampilan/perhitungan).

> Catatan: Berkas yang Anda unggah adalah **`.class`** (hasil kompilasi). Untuk menghasilkan JavaDoc, Anda **membutuhkan berkas sumber `.java`**. README ini menyediakan panduan, struktur dokumentasi, dan *stub* komentar JavaDoc yang bisa Anda salin ke kode sumber.

---

## 1. Struktur Konseptual
```
Tugas3_After/
├─ Main                -> titik masuk aplikasi (menjalankan demo/flow)
└─ PendaftaranPasien   -> entitas pendaftaran pasien:
                          - namaPasien (String)
                          - namaDokter (String)
                          - biayaDokter (double)
                          - biayaAdmin  (double)
                          - printDataPasien()
                          - hitungTotalBiaya() [private]
```
> Properti di atas diinferensikan dari *signature* method pada `.class` yang diunggah.

---

## 2. Panduan Penulisan JavaDoc
### 2.1. Gaya umum
- Gunakan kalimat aktif dan ringkas pada baris pertama (meringkas tujuan).
- Tambahkan detail pada paragraf berikutnya: prasyarat, efek samping, dan catatan.
- Cantumkan tag standar:
  - `@param` untuk setiap parameter (urut dan namanya **harus sama** dengan di kode).
  - `@return` untuk nilai balik (abaikan pada `void`).
  - `@throws` untuk pengecualian yang mungkin dilempar.
  - `@since`, `@author` (opsional).
- Tulis satuan/konvensi (mis. *Rupiah*, persen) pada deskripsi.

### 2.2. Tingkat cakupan
Secara default, JavaDoc hanya mendokumentasikan `public` dan `protected`.  
Jika ingin **mencakup `private`** (mis. `hitungTotalBiaya()`), jalankan JavaDoc dengan opsi `-private` (lihat §4).

---

## 3. *Stub* Komentar JavaDoc Siap Tempel
Agar cepat, gunakan *stub* pada folder [`docs/JAVADOC_STUBS`](docs/JAVADOC_STUBS). Sesuaikan deskripsi dan **nama parameter** bila berbeda dengan implementasi Anda.

- [`PendaftaranPasien.javadoc.stub.java`](docs/JAVADOC_STUBS/PendaftaranPasien.javadoc.stub.java)
- [`Main.javadoc.stub.java`](docs/JAVADOC_STUBS/Main.javadoc.stub.java)

---

## 4. Cara Menghasilkan JavaDoc (CLI)
> Pastikan Anda punya **kode sumber `.java`** (bukan `.class` saja). Misal, struktur proyek:
>
> ```
> src/
> └─ Tugas3_After/
>    ├─ Main.java
>    └─ PendaftaranPasien.java
> ```

### 4.1. Perintah umum (Windows, PowerShell)
```powershell
# dari root project
javadoc -d docs -encoding UTF-8 -docencoding UTF-8 -charset UTF-8 ^
  -private -use -version -author ^
  -sourcepath src Tugas3_After
```
### 4.2. Perintah umum (macOS/Linux)
```bash
# dari root project
javadoc -d docs -encoding UTF-8 -docencoding UTF-8 -charset UTF-8   -private -use -version -author   -sourcepath src Tugas3_After
```
Keluaran akan berada di folder `docs/` → buka `docs/index.html` di browser.

> **Tips**: Jika proyek menggunakan *modules/packages* berbeda, ganti argumen paket di akhir.  
> Bila ingin hanya `public`/`protected`, hilangkan opsi `-private`.

---

## 5. Integrasi Build Tool (opsional)
### Gradle
```groovy
tasks.named('javadoc') {
    options.encoding = 'UTF-8'
    options.charSet = 'UTF-8'
    options.docEncoding = 'UTF-8'
    options.addBooleanOption('private', true)   // sertakan private
    options.addBooleanOption('use', true)
    options.addBooleanOption('version', true)
    options.addBooleanOption('author', true)
}
```
Jalankan: `./gradlew javadoc` → hasil di `build/docs/javadoc`.

### Maven
```xml
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-javadoc-plugin</artifactId>
  <version>3.6.3</version>
  <configuration>
    <encoding>UTF-8</encoding>
    <docencoding>UTF-8</docencoding>
    <charset>UTF-8</charset>
    <show>private</show>
    <additionalJOption>-Xdoclint:none</additionalJOption>
  </configuration>
</plugin>
```
Jalankan: `mvn javadoc:javadoc` → hasil di `target/site/apidocs`.

---

## 6. Checklist kualitas dokumentasi
- [ ] Semua kelas dan *public API* memiliki ringkasan 1 kalimat.
- [ ] Semua parameter ada `@param` dengan satuan/jangkauan nilai.
- [ ] Tidak ada *warning* `no @param/@return` saat `javadoc`.
- [ ] Nama teknis konsisten (mis. “biaya”, “total biaya”).
- [ ] Contoh penggunaan minimal di `Main`.
- [ ] README ini telah diperbarui jika ada perubahan struktur.

---

## 7. Lisensi
Tambahkan lisensi kelas/tugas sesuai kebutuhan institusi/kampus.

---

> Dibuat otomatis dari *signature* berkas `.class` yang diunggah. Jika ada ketidaksesuaian nama parameter/metode, sesuaikan pada stub dan jalankan ulang JavaDoc.
