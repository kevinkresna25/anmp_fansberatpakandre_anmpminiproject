# Mini Project ANMP - UAS

**Advanced Native Mobile Programming - Aplikasi Ukur Perkembangan Anak**

Aplikasi Android sederhana untuk mencatat dan memantau data perkembangan anak. Aplikasi ini memungkinkan pengguna untuk memasukkan data pengukuran (berat, tinggi, usia), melihat riwayat data, dan mengelola profil anak.

Proyek ini dibuat untuk memenuhi tugas **Mini Project UAS** mata kuliah Advanced Native Mobile Programming, dengan menerapkan arsitektur **MVVM**, **Jetpack Navigation**, **Data Binding**, dan penyimpanan lokal menggunakan **Room Database**.

## Daftar Isi
- [Tampilan Aplikasi](#tampilan-aplikasi)
- [Arsitektur & Teknologi](#arsitektur--teknologi)
- [Anggota Kelompok](#anggota-kelompok)

## Tampilan Aplikasi

Aplikasi ini terdiri dari tiga halaman utama yang terhubung oleh *Bottom Navigation* dan *Navigation Drawer*:

1. **Halaman Ukur:** Formulir untuk memasukkan data berat badan (kg), tinggi badan (cm), dan usia (tahun) ke dalam database.
2. **Halaman Data:** Menampilkan riwayat data pengukuran (Age, Height, Weight) yang diambil dari database lokal.
3. **Halaman Profil:** Formulir untuk menyimpan dan mengedit data profil anak (nama, tanggal lahir, jenis kelamin) menggunakan logika *Single Source of Truth*.

## Arsitektur & Teknologi

Proyek ini dibangun menggunakan arsitektur **MVVM (Model–View–ViewModel)** modern untuk memisahkan logika bisnis, data, dan antarmuka pengguna.

- **Bahasa:** **Kotlin**
- **Arsitektur:** MVVM
- **Komponen Android Jetpack:**
  - **Room Database:** Library persistensi data (SQLite abstraction) untuk menyimpan riwayat pengukuran dan profil anak secara lokal.
  - **Data Binding:** Mengikat komponen UI di layout XML langsung ke sumber data (ViewModel). Menerapkan **Two-Way Binding** (untuk input data) dan **Listener Binding** (untuk event klik).
  - **Navigation Component:** Mengelola alur navigasi antar *fragment* (Ukur, Data, Profil).
  - **ViewModel:** Mengelola data UI dan logika bisnis agar tetap hidup saat terjadi perubahan konfigurasi (seperti rotasi layar).
  - **LiveData:** Pola pengamat data yang sadar siklus hidup (*lifecycle-aware*) untuk update UI secara otomatis.
- **Asynchronous Programming:**
  - **Kotlin Coroutines:** Menangani operasi database di *background thread* (IO Dispatcher) agar tidak memblokir antarmuka pengguna (Main Thread).
- **Antarmuka Pengguna (UI):**
  - `BottomNavigationView`
  - `NavigationDrawer`
  - `RecyclerView` (dengan Data Binding pada item layout)
  - `CardView`, `TextInputLayout`, `RadioGroup`

## Anggota Kelompok

Nama Kelompok : **Fans Berat Pak Andre**

| NRP | NAMA | GITHUB |
|-----|------|--------|
| 160422071 | Kresnayana Nanda Arifink | [kevinkresna25](https://github.com/kevinkresna25) |
| 160422072 | Nur Rachmad Fauzi Putra | [MankSkuy](https://github.com/MankSkuy) |
| 160422170 | Dimas Amirullah | [amrDmas](https://github.com/amrDmas) |

---

**Universitas Surabaya**