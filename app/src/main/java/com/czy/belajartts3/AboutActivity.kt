package com.czy.belajartts3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.czy.belajartts3.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Tentang Aplikasi"

        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        // Set about text
        binding.tvAbout.text = """
            Aplikasi Profil Mahasiswa
            
            Dibuat untuk memenuhi tugas mata kuliah Pemrograman Mobile.
            
            Fitur:
            • Input data mahasiswa
            • Tampilkan profil
            • Share profil
            • Navigation dengan Fragment
            • Intent antar Activity
            
            Teknologi:
            • Kotlin
            • Android Fragment
            • Intent & Bundle
            • View Binding
        """.trimIndent()
    }
}