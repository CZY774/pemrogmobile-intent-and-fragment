package com.czy.belajartts3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.czy.belajartts3.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Detail Mahasiswa"

        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        // Ambil data dari Intent
        val name = intent.getStringExtra("name") ?: "Tidak ada data"
        val nim = intent.getStringExtra("nim") ?: "Tidak ada data"
        val jurusan = intent.getStringExtra("jurusan") ?: "Tidak ada data"
        val semester = intent.getStringExtra("semester") ?: "Tidak ada data"

        // Tampilkan data detail
        binding.apply {
            tvDetailName.text = name
            tvDetailNim.text = nim
            tvDetailJurusan.text = jurusan
            tvDetailSemester.text = semester

            // Tambahan info
            tvAdditionalInfo.text = """
                Status: Mahasiswa Aktif
                Fakultas: ${getFakultas(jurusan)}
                Email: ${nim.lowercase()}@student.university.ac.id
                Tahun Masuk: ${getCurrentYear() - (semester.toIntOrNull()?.let { (it-1)/2 } ?: 0)}
            """.trimIndent()
        }
    }

    private fun getFakultas(jurusan: String): String {
        return when (jurusan.lowercase()) {
            "teknik informatika", "sistem informasi", "teknik komputer" -> "Fakultas Teknik"
            "manajemen", "akuntansi", "ekonomi" -> "Fakultas Ekonomi"
            "hukum" -> "Fakultas Hukum"
            else -> "Fakultas Umum"
        }
    }

    private fun getCurrentYear(): Int = 2024
}