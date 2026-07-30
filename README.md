# Android TV App

Aplikasi Android TV sederhana yang menampilkan daftar film dari REST API menggunakan arsitektur MVVM dan Jetpack Compose.

## Fitur

- Menampilkan daftar film dari API
- Halaman detail film
- Integrasi REST API menggunakan Retrofit
- Arsitektur MVVM
- Repository Pattern
- Navigasi menggunakan Navigation Compose
- Unit Test pada Repository

---

## Teknologi yang Digunakan

- Kotlin
- Jetpack Compose
- Android TV
- MVVM Architecture
- Retrofit
- Gson
- Coil
- Coroutines
- JUnit

---

## Struktur Project

```
app/
│
├── data
│   ├── api
│   ├── model
│   └── repository
│
├── ui
│   ├── screen
│   ├── component
│   └── theme
│
├── viewmodel
│
└── MainActivity
```

---

## Cara Menjalankan Project

1. Clone repository

```
git clone https://github.com/ningrom/TvApp.git
```

2. Buka menggunakan Android Studio Ladybug atau versi yang lebih baru.

3. Lakukan Gradle Sync.

4. Jalankan aplikasi menggunakan Android TV Emulator atau perangkat Android TV.

---

## Menjalankan Unit Test

Melalui Android Studio 
```
src
 └── test
      └── java
           └── com
                └── ayuk
                     └── tvapp
                          └── data
```
atau menggunakan perintah:

```
./gradlew test
```

---

## Arsitektur

Project ini menggunakan pola **MVVM (Model-View-ViewModel)**.

Alur data:

```
REST API
    ↓
Repository
    ↓
ViewModel
    ↓
Jetpack Compose UI

## Catatan

Project ini dibuat sebagai bagian dari proses Technical Test Mobile Engineer Intern Mamikos.
