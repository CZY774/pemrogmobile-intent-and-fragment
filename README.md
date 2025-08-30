# 📱 Student Profile App

Aplikasi Android sederhana untuk mengelola profil mahasiswa yang dibuat menggunakan **Kotlin** dan **Gradle KTS**. Aplikasi ini merupakan project mata kuliah **Pemrograman Mobile** dengan fokus implementasi **Intent** dan **Fragment**.

## 🚀 Features

- **📝 Input Data Mahasiswa** - Form untuk memasukkan data pribadi mahasiswa
- **👤 Profil Mahasiswa** - Menampilkan data yang telah diinput
- **📤 Share Profil** - Berbagi profil melalui aplikasi lain (WhatsApp, Email, dll)
- **📋 Detail Mahasiswa** - Halaman detail dengan informasi lengkap
- **ℹ️ About App** - Informasi tentang aplikasi
- **🔄 Navigation** - Bottom Navigation untuk berpindah antar fitur

## 🛠️ Technology Stack

- **Language**: Kotlin
- **Build System**: Gradle KTS
- **UI**: Material Design 3
- **Architecture Components**: Fragment, Intent, Bundle
- **View Binding**: Enabled
- **Target SDK**: 34
- **Min SDK**: 24

## 📋 Prerequisites

- Android Studio Hedgehog atau lebih baru
- JDK 8 atau lebih tinggi
- Android SDK 34
- Gradle 8.0+

## 🔧 Installation

1. **Clone repository**
   ```bash
   git clone https://github.com/czy774/pemrogmobile-intent-and-fragment.git
   cd pemrogmobile-intent-and-fragment
   ```

2. **Open in Android Studio**
   - Buka Android Studio
   - Select "Open an existing project"
   - Pilih folder project yang sudah di-clone

3. **Sync Project**
   - Android Studio akan otomatis sync Gradle
   - Tunggu sampai proses selesai

4. **Run Application**
   - Connect device atau start emulator
   - Klik tombol "Run" atau tekan `Shift + F10`

## 📁 Project Structure

```
app/
├── src/main/
│   ├── java/com/czy/belajartts3/
│   │   ├── MainActivity.kt
│   │   ├── InputFragment.kt
│   │   ├── ProfileFragment.kt
│   │   ├── AboutActivity.kt
│   │   └── DetailActivity.kt
│   ├── res/
│   │   ├── layout/
│   │   │   ├── activity_main.xml
│   │   │   ├── fragment_input.xml
│   │   │   ├── fragment_profile.xml
│   │   │   ├── activity_about.xml
│   │   │   └── activity_detail.xml
│   │   ├── menu/
│   │   │   └── bottom_navigation.xml
│   │   ├── values/
│   │   │   ├── strings.xml
│   │   │   ├── colors.xml
│   │   │   └── themes.xml
│   │   └── ...
│   └── AndroidManifest.xml
└── build.gradle.kts
```

## 🎯 Core Concepts Implemented

### 📱 Fragment
- **InputFragment**: Menampilkan form input data mahasiswa
- **ProfileFragment**: Menampilkan profil hasil input
- **Fragment Transaction**: Navigasi antar fragment
- **Bundle Arguments**: Transfer data antar fragment

### 🔗 Intent
- **Explicit Intent**: Navigasi ke Activity lain (About, Detail)
- **Implicit Intent**: Share profil ke aplikasi eksternal
- **Intent Extras**: Mengirim data antar Activity

### 🎨 UI Components
- **Material Design 3**: Modern UI design
- **Bottom Navigation**: Tab navigation
- **TextInputLayout**: Form input dengan validation
- **CardView**: Card-based layout
- **Toolbar**: Action bar dengan back navigation

## 📱 Screenshots

### Input Screen
Form untuk memasukkan data mahasiswa dengan validation

### Profile Screen  
Menampilkan data yang telah diinput dalam format card

### Detail Screen
Informasi lengkap mahasiswa dengan data tambahan

### About Screen
Informasi tentang aplikasi dan fitur-fiturnya

## 🔧 Key Features Detail

### 1. Data Input & Validation
```kotlin
private fun validateInput(name: String, nim: String, jurusan: String, semester: String): Boolean {
    // Validasi input dengan error handling
}
```

### 2. Fragment Communication
```kotlin
fun sendDataToProfile(name: String, nim: String, jurusan: String, semester: String) {
    val bundle = Bundle().apply {
        putString("name", name)
        // ... data lainnya
    }
    profileFragment.arguments = bundle
}
```

### 3. Intent Implementation
```kotlin
// Explicit Intent
val intent = Intent(this, DetailActivity::class.java)
startActivity(intent)

// Implicit Intent
val shareIntent = Intent(Intent.ACTION_SEND).apply {
    type = "text/plain"
    putExtra(Intent.EXTRA_TEXT, shareText)
}
```

## 🚦 Usage

1. **Input Data**: 
   - Buka tab "Input"
   - Isi semua field (Nama, NIM, Jurusan, Semester)
   - Klik tombol "Submit"

2. **View Profile**:
   - Otomatis redirect ke tab "Profil"
   - Data yang diinput akan ditampilkan

3. **Share Profile**:
   - Di tab "Profil", klik tombol "Share"
   - Pilih aplikasi untuk berbagi

4. **View Detail**:
   - Klik tombol "Detail" untuk melihat info lengkap
   - Informasi tambahan akan ditampilkan

## <img src="https://media.giphy.com/media/utz68KlKM5LGBVF6HZ/giphy.gif" width="25px" alt="rocket"> Quotes of the day
<div align="center">
  <img src="https://quotes-github-readme.vercel.app/api?type=horizontal&theme=tokyonight" alt="Random Dev Quote" />
</div>
<br/>
<br/>
<div align="center">
  <img src="https://github-readme-streak-stats.herokuapp.com/?user=CZY774&theme=tokyonight&hide_border=true&background=1f1f1f&stroke=58a6ff&ring=58a6ff&fire=58a6ff&currStreakNum=ffffff&sideNums=ffffff&currStreakLabel=58a6ff&sideLabels=58a6ff&dates=ffffff" alt="GitHub Streak" />
</div>

## <img src="https://media.giphy.com/media/hvRJCLFzcasrR4ia7z/giphy.gif" width="25px" alt="waving hand"> Get In Touch
<div align="center">
  <a href="https://www.instagram.com/corneliusyoga" target="_blank"><img src="https://img.shields.io/badge/Instagram-%23E4405F.svg?&style=for-the-badge&logo=instagram&logoColor=white" alt="Instagram"></a>&nbsp;
  <a href="https://www.linkedin.com/in/cornelius-yoga-783b6a291" target="_blank"><img src="https://img.shields.io/badge/LinkedIn-%230077B5.svg?&style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn"></a>&nbsp;
  <a href="https://www.youtube.com/channel/UCj0TlW5vLO6r_Nlwc8oFBpw" target="_blank"><img src="https://img.shields.io/badge/YouTube-%23FF0000.svg?&style=for-the-badge&logo=youtube&logoColor=white" alt="YouTube"></a>&nbsp;
  <a href="https://corneliusyoga.vercel.app" target="_blank"><img src="https://img.shields.io/badge/Portfolio-%23000000.svg?&style=for-the-badge&logo=react&logoColor=white" alt="Portfolio"></a>
  <br/><br/>
  <img src="https://komarev.com/ghpvc/?username=CZY774&style=flat-square&color=0366D6" alt="Profile Views" />
  <br/>
  <sub>Made by Cornelius Ardhani Yoga Pratama</sub>
</div>
