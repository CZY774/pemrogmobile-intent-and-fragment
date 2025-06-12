package com.czy.belajartts3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.czy.belajartts3.databinding.ActivityMainBinding
import android.content.Intent

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var currentStudentData: Bundle? = null  // Simpan data mahasiswa

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Load fragment pertama
        loadFragment(InputFragment())

        // Setup bottom navigation
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_input -> {
                    loadFragment(InputFragment())
                    true
                }
                R.id.nav_profile -> {
                    // Gunakan data tersimpan jika ada
                    val profileFragment = ProfileFragment()
                    currentStudentData?.let {
                        profileFragment.arguments = it
                    }
                    loadFragment(profileFragment)
                    true
                }
                R.id.nav_about -> {
                    // Intent ke Activity lain
                    val intent = Intent(this, AboutActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    // Function untuk kirim data antar fragment
    fun sendDataToProfile(name: String, nim: String, jurusan: String, semester: String) {
        // Debug log
        println("DEBUG: MainActivity received data - Name: $name, NIM: $nim, Jurusan: $jurusan, Semester: $semester")

        // Simpan data untuk digunakan nanti
        currentStudentData = Bundle().apply {
            putString("name", name)
            putString("nim", nim)
            putString("jurusan", jurusan)
            putString("semester", semester)
        }

        val profileFragment = ProfileFragment()
        profileFragment.arguments = currentStudentData

        // Debug bundle
        println("DEBUG: Bundle created and saved")

        loadFragment(profileFragment)
        binding.bottomNavigation.selectedItemId = R.id.nav_profile
    }
}