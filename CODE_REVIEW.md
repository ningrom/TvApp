# Code Review Excercise

## Temuan

1. **Network di Main Thread**
   Pemanggilan API dilakukan secara hardcode/sinkron, bukan dilakukan dilatar belakang seperti configuration, service, sehingga dpt berpotensi membuat aplikasi freeze.
   **Saran:** Gunakan pemanggilan pada file yg berbeda, seperti APIconfig/repository.

2. **Tidak ada error handling**
   pada bagian "val data = url.readText()" tidak ada penanganan eror, akan berpotensi kegagalan jaringan yg dapat menyebabkan aplikasi crash.
   **Saran:** Tambahkan `try-catch` dan tampilkan state error.

3. **ViewModel terlalu banyak tanggung jawab**
   Proses networking dilakukan langsung di ViewModel.
   **Saran:** Pindahkan ke Repository.

4. **Sulit diuji**
   Ditulis secara eksplisit ("URL dan readText()") pada fungsi di ViewModel sehingga sulit di-mock saat testing.
   **Saran:** Gunakan dependency injection melalui constructor.

## Kesimpulan

Kode sudah berjalan, tetapi masih perlu perbaikan pada pengelolaan state, error handling, arsitektur, dan testing agar lebih sesuai dengan praktik Android modern.
