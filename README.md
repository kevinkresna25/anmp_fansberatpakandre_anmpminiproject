\# Mini Project ANMP



\*\*Advanced Native Mobile Programming - Aplikasi Ukur Perkembangan Anak\*\*



Aplikasi Android sederhana untuk mencatat dan memantau data perkembangan anak. Aplikasi ini memungkinkan pengguna untuk memasukkan data pengukuran (berat, tinggi, usia), melihat riwayat data, dan mengelola profil anak.



Proyek ini dibuat untuk memenuhi tugas Mini Project UTS mata kuliah Advanced Native Mobile Programming, dengan menerapkan arsitektur \*\*MVVM\*\*, \*\*Jetpack Navigation\*\*, dan \*\*Penyimpanan Internal\*\* (File \& SharedPreferences).



\## Daftar Isi

\- \[Tampilan Aplikasi](#tampilan-aplikasi)

\- \[Arsitektur \& Teknologi](#arsitektur--teknologi)

\- \[Anggota Kelompok](#anggota-kelompok)



\## Tampilan Aplikasi



Aplikasi ini terdiri dari tiga halaman utama yang terhubung oleh \*Bottom Navigation\* dan \*Navigation Drawer\*:



1\. \*\*Halaman Ukur:\*\* Formulir untuk memasukkan data berat badan (kg), tinggi badan (cm), dan usia (tahun).

2\. \*\*Halaman Data:\*\* Menampilkan riwayat data pengukuran (Age, Height, Weight) yang telah disimpan.

3\. \*\*Halaman Profil:\*\* Formulir untuk menyimpan dan menampilkan data profil anak (nama, tanggal lahir, jenis kelamin).



\## Arsitektur \& Teknologi



Proyek ini dibangun menggunakan arsitektur \*\*MVVM (Model–View–ViewModel)\*\* untuk memisahkan logika bisnis dari antarmuka pengguna.



\- \*\*Bahasa:\*\* \*\*Kotlin\*\*

\- \*\*Arsitektur:\*\* MVVM

\- \*\*Komponen Android Jetpack:\*\*

&nbsp; - \*\*Navigation Component:\*\* Mengelola alur navigasi antar \*fragment\*.

&nbsp; - \*\*ViewModel:\*\* Mengelola data dan logika bisnis yang terkait dengan UI, serta bertahan dari perubahan konfigurasi.

&nbsp; - \*\*LiveData:\*\* Memberi tahu UI (View) tentang perubahan data secara \*lifecycle-aware\*.

&nbsp; - \*\*View Binding:\*\* Mengikat komponen UI di layout ke kode Kotlin dengan aman.

\- \*\*Antarmuka Pengguna (UI):\*\*

&nbsp; - `BottomNavigationView`

&nbsp; - `NavigationDrawer`

&nbsp; - `RecyclerView`

&nbsp; - `CardView`, `TextInputEditText`, `RadioGroup`

\- \*\*Penyimpanan Data:\*\*

&nbsp; - \*\*Internal File Storage:\*\* Menyimpan daftar riwayat pengukuran.

&nbsp; - \*\*SharedPreferences:\*\* Menyimpan data profil anak.

&nbsp; - \*\*Gson:\*\* Serialisasi objek Kotlin (`Pengukuran`) ke JSON untuk disimpan ke file, serta deserialisasi saat dibaca.



\## Anggota Kelompok



Nama Kelompok : \*\*Fans Berat Pak Andre\*\*



| NRP | NAMA | GITHUB |

|-----|------|--------|

| 160422071 | Kresnayana Nanda Arifink | \[kevinkresna25](https://github.com/kevinkresna25) |

| 160422072 | Nur Rachmad Fauzi Putra | \[MankSkuy](https://github.com/MankSkuy) |

| 160422170 | Dimas Amirullah | \[amrDmas](https://github.com/amrDmas) |



---



\*\*Universitas Surabaya\*\*



