# PERSONA GAME

## Deskripsi Singkat

Persona Game merupakan simulasi pertarungan berbasis teks yang menggunakan bahasa pemrograman Java dengan menerapkan konsep Object-Oriented Programming (OOP). User berperan sebagai karakter yang menjelajahi dungeon dan bertarung melawan musuh menggunakan skill elemen seperti Api, Air, dan Tanah. Pertarungan menghasilkan reward berupa HP (Health Point) atau SP (Skill Point) untuk mendukung pertempuran berikutnya. Fitur-fiturnya meliputi sistem pertarungan, pemberian & lihat riwayat hadiah, tampilan profil pemain, dan opsi keluar permainan.

---

## Fitur Utama

### 1. Sistem Pertarungan
User akan menghadapi musuh dalam dungeon melalui sistem pertarungan berbasis giliran. Tersedia tiga jenis skill dengan elemen berbeda — Api🔥, Air💧, dan Tanah🌱 — yang dapat digunakan untuk menyerang musuh. Setiap elemen memiliki keunggulan dan kelemahannya tersendiri.

### 2. Pemberian & Melihat Riwayat Hadiah
User dapat menerima hadiah setelah menyelesaikan pertarungan dan memenangkan pertarungan. Fitur ini juga menyimpan riwayat hadiah yang telah diterima, sehingga pengguna dapat melihat kembali item atau bonus yang pernah diperoleh.

### 3. Tampilan Profile Pengguna
Menampilkan informasi dasar pengguna seperti nama pengguna, nama persona, skill yang digunakan, serta jumlah HP (Health Point) dan SP (Skill Point) yang dimiliki pengguna. Profil ini membantu pengguna memantau perkembangan karakter selama bermain.

### 4. Opsi Keluar Permainan
Fitur ini memungkinkan pengguna keluar dari permainan dengan aman. Sistem akan menampilkan pesan otomatis saat pengguna memilih keluar dari permainan.


## Penerapan Prinsip OOP

### Object & Class

- **User**: Menunjukkan data pemain, termasuk persona dan skill yang dimiliki
- **Persona**: Menjelaskan atribut karakter seperti HP dan SP
- **Musuh**: Menggambarkan karakter musuh dalam permainan
- **Skill (dan subclass)**: Menjelaskan berbagai jenis kemampuan berdasarkan elemen
- **Hadiah (dan subkelas)**: Menjelaskan jenis hadiah yang diperoleh setelah pertarungan

### Attribute, Method & Constructor

#### Attribute:
- User: `nama`, `persona`, `riwayatHadiah`, `totalHadiahSP`
- Persona: `nama`, `skill`, `hp`, `sp`
- Musuh: `nama`, `skill`, `hp`, `sp`

#### Method:
- **User**: `tambahHP()`, `tambahSP()`, `tampilkanRiwayatHadiah()`
- **Persona**: `tambahHp()`, `kurangHp()`, `tambahSp()`, `kurangSp()`
- **Subkelas Skill**: Berbagai implementasi `gunakanSkill()`

#### Constructor:
- `User(String namaUser, String namaPersona, String skillInput)`
- `Persona(String nama, String skill)`
- `Musuh(String nama, String skill)`

### Encapsulation
- Membuat atribut menjadi `private` (contoh: `private String nama`, `private int hp`)
- Menyediakan metode getter publik (`getNama()`, `getHp()`)
- Menggunakan metode pengubah yang terkontrol (`tambahHp()`, `kurangSp()`)

### Inheritance
- `Skill` adalah kelas induk yang diturunkan ke class `Api`, `Air`, dan `Tanah`
- `Hadiah` adalah kelas induk abstrak yang diperluas oleh: `HadiahHP`, `HadiahSP`

### Abstract & Interface
- Interface `UsableSkill` mendefinisikan kontrak dengan metode `gunakanSkill()`
- `Skill` adalah kelas abstrak yang mengimplementasikan `UsableSkill`
- `Hadiah` adalah kelas abstrak dengan metode abstrak `berikanHadiah(User user)`

### Polymorphism

#### Method Overriding:
- Setiap subkelas `Skill` (`Api`, `Air`, `Tanah`) menimpa metode `gunakanSkill()`
- `HadiahHP` dan `HadiahSP` menimpa metode `berikanHadiah()`

#### Method Overloading:
- Setiap skill elemen memiliki beberapa metode `gunakanSkill()` :
  - `gunakanSkill()`
  - `gunakanSkill(String target)`
  - `gunakanSkill(int parameter)`
  - `gunakanSkill(String target, int parameter)`

---

## Struktur dan Alur Permainan

- Permainan dimulai di `Main.java` dengan registrasi pengguna
- Pemain membuat karakter dengan nama, persona, dan skill elemen
- Dalam loop permainan, pemain dapat memilih tindakan:
  - Bertarung (masuk dungeon)
  - Melihat profil
  - Melihat riwayat hadiah
  - Keluar

### Selama pertarungan di kelas `Dungeon`:
- Pemain dan musuh bergantian menyerang
- Pemain dapat menggunakan serangan biasa atau skill khusus yang menghabiskan SP
- Elemen berbeda memiliki efek berbeda:
  - **Api**: Damage tambahan
  - **Air**: Menyembuhkan HP
  - **Tanah**: Memulihkan SP
- Pemain mendapatkan hadiah (boost HP atau SP) setelah menang

---

## Keseruan Game

Dalam game ini kamu bisa:

🧙‍♂️ Buat karakter dengan nama persona sendiri  
🔥 Pilih kekuatan elemen favoritmu: Api, Air, atau Tanah  
⚔️ Bertarung melawan monster dengan strategi serangmu  
🎁 Kumpulkan hadiah untuk menambah HP dan SP  
📊 Pantau perkembangan karaktermu  

---

## 🚀 Cara Menjalankan Game Persona

1. Pastikan Anda telah menginstal Java JDK & VsCode (atau IDE lain seperti IntelliJ IDEA atau Eclipse).
2. Clone repositori melalui Command Prompt:
   ```bash
   git clone https://github.com/yaaawan/persona.git

3.Main.java (root package)

Package user:
  - User.java
  - Persona.java

Package user.hadiah:
  - Hadiah.java
  - HadiahHP.java
  - HadiahSP.java

Package user.skill:
  - Skill.java
  - UsableSkill.java
  - SkillFactory.java
  - Api.java
  - Air.java
  - Tanah.java

Package pertarungan:
  - Dungeon.java
  - Musuh.java

4.Jalankan file Main.java dari IDE.

5.Saat dijalankan, Anda akan diminta:

  - Memilih apakah ingin bermain atau tidak

  - Memasukkan data pemain seperti nama user dan nama persona

  - Memilih skill (Api, Air, atau Tanah)

  - Melakukan aksi (bertarung, melihat profil, melihat riwayat hadiah, atau keluar)

Hadiah setelah pertarungan: tambahan HP (nyawa) atau SP (kekuatan persona).
Selamat bermain dan semoga berhasil mengalahkan musuh-musuh di dalam game!


## 👥 Pembagian Tugas Per Anggota

• YUD BRYAWAN (H071241063)

Bertugas mengatur bagaimana pemain berinteraksi dengan permainan secara keseluruhan. Membuat kelas User untuk menyimpan informasi pemain seperti nama, karakter, hadiah yang pernah didapat, dan skill yang digunakan. Selain itu, membuat kelas Main yang menjadi pusat jalannya permainan. Di kelas ini, permainan dimulai, input dari pemain diproses, dan hasilnya ditampilkan dengan jelas ke layar.

• MUHAMMAD ARLIS (H071241047)

Bertanggung jawab pada bagian pertarungan dalam permainan. Mengembangkan logika dan kelas-kelas yang mengatur dungeon sebagai tempat pertarungan dan musuh yang dihadapi pemain. Meskipun tidak semua file ditampilkan, pemanggilan kelas Dungeon di kelas Main menunjukkan bahwa bagian ini merupakan inti dari sistem pertarungan.

• DIESTY MENDILA TAPPO (H071241077)

Mengembangkan karakter pemain dan skill yang dimiliki. Membuat kelas Persona yang berisi data seperti nama, HP, SP, dan skill. Juga membuat kelas abstrak Skill sebagai dasar skill lain, serta skill konkret seperti Api dan Tanah. Untuk memudahkan pembuatan skill, juga dibuat kelas SkillFactory.

• SUCI SRI AULIA (H071241067)

Bertugas membuat sistem hadiah dalam permainan. Membuat kelas Hadiah sebagai dasar untuk jenis hadiah, lalu mengembangkan hadiah seperti HadiahHP dan HadiahSP yang menambah HP atau SP pemain. Sistem ini membuat hadiah dalam permainan jadi lebih bervariasi dan berguna.

