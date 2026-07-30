## Entry 1: Flow, Setup, dan Proses Awal

**Ask:**  Minta AI menentukan urutan pengerjaan project, apakah sebaiknya membangun UI terlebih dahulu atau mengerjakan Backend/API terlebih dahulu.
**Got:** AI menyarankan untuk memastikan API dapat berjalan dengan baik terlebih dahulu menggunakan Postman, kemudian membuat layer networking (Retrofit), Repository, ViewModel, dan setelah itu mengimplementasikan UI.
**What I did:** Saya membaca kembali materi Retrofit dan MVVM dari Dicoding, melihat project Android sebelumnya sebagai referensi, memastikan endpoint API dapat diakses, lalu mulai membangun layer networking sebelum mengerjakan UI dengan Jetpack Compose.
**AI got wrong:**  AI mengasumsikan bahwa saya sudah memahami implementasi Retrofit, Repository, dan MVVM secara menyeluruh. Pada kenyataannya saya masih perlu membuka dokumentasi dan project lama untuk memahami kembali alur implementasinya. AI juga tidak mengetahui struktur project yang diharapkan oleh technical test, sehingga beberapa penyesuaian tetap saya lakukan sendiri.

## Entry 2:Setup Retrofit + API interface
**Ask:** minta AI bikinin Retrofit service interface buat TVMaze API
**Got:** interface dengan endpoint /shows dan /shows/{id}, plus data class Show
**What I did:** dipake tapi saya mengubah nama field `rating` jadi nested data class karena AI awalnya membuat `rating: Double` padahal di response aslinya rating itu object `{average: Double?}`
**AI got wrong:** AI mengasumsikan rating.average selalu non null, padahal di API banyak menunjukkan yang ratingnya null, kemudian ditinjau langsung ke response API, akhirnya harus di nullable kan

## Entry 3: UI
**Ask:** minta AI menyesuaikan code desain yg di punya dengan emulator TV
**Got:** mendapatkan code yang sesuai dengan emulatornya, akan tetapi ketika di running terdapat kesalahan secara eksplisit.
**What I did:** Mencoba evaluasi, apa yang perlu dihapus dan tidak. Dijalankan ulang, tertanya AI menyarankan menggunakan layout modifier di column dan box pada listscreen. Maka dari itu bagian title, dan rating tidak keliatan karena tertutup oleh layouot .fillMaxSize
**AI got wrong:** AI mengasumsikan tampilan poster yang diminta memerlukan double .layout.fillMaxSize

