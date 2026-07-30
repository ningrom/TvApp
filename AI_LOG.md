## Entry 1: Flow, Setup, dan Proses Awal

**Ask:**  Minta AI menentukan urutan pengerjaan project, apakah sebaiknya membangun UI terlebih dahulu atau mengerjakan Backend/API terlebih dahulu.
**Got:** AI menyarankan untuk memastikan API dapat berjalan dengan baik terlebih dahulu menggunakan Postman, kemudian membuat layer networking (Retrofit), Repository, ViewModel, dan setelah itu mengimplementasikan UI.
**What I did:** Saya membaca kembali materi Retrofit dan MVVM dari Dicoding, melihat project Android sebelumnya sebagai referensi, memastikan endpoint API dapat diakses, lalu mulai membangun layer networking sebelum mengerjakan UI dengan Jetpack Compose.
**AI got wrong:**  AI mengasumsikan bahwa saya sudah memahami implementasi Retrofit, Repository, dan MVVM secara menyeluruh. Pada kenyataannya saya masih perlu membuka dokumentasi dan project lama untuk memahami kembali alur implementasinya. AI juga tidak mengetahui struktur project yang diharapkan oleh technical test, sehingga beberapa penyesuaian tetap saya lakukan sendiri.

## Entry 2:Setup Retrofit + API interface
**Ask:** minta AI bikinin Retrofit service interface buat TVMaze API
**Got:** interface dengan endpoint /shows dan /shows/{id}, plus data class Show
**What I did:** dipake tapi aku ubah nama field `rating` jadi nested data class karena AI awalnya bikin `rating: Double` padahal di response aslinya rating itu object `{average: Double?}`
**AI got wrong:** AI ngasumsiin rating.average selalu non null, padahal di API banyak show yang ratingnya null, dicek langsung ke response API baru sadarharus di-nullable-in
