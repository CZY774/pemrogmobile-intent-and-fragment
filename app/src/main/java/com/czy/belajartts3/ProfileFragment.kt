package com.czy.belajartts3

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.czy.belajartts3.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Debug arguments
        println("DEBUG: ProfileFragment arguments: ${arguments}")

        // Ambil data dari arguments
        arguments?.let { bundle ->
            val name = bundle.getString("name", "Belum diisi")
            val nim = bundle.getString("nim", "Belum diisi")
            val jurusan = bundle.getString("jurusan", "Belum diisi")
            val semester = bundle.getString("semester", "Belum diisi")

            // Debug received data
            println("DEBUG: ProfileFragment received - Name: $name, NIM: $nim, Jurusan: $jurusan, Semester: $semester")

            displayProfile(name, nim, jurusan, semester)
        } ?: run {
            println("DEBUG: No arguments found, showing default values")
            displayProfile("Belum diisi", "Belum diisi", "Belum diisi", "Belum diisi")
        }

        // Button untuk share profil menggunakan Intent
        binding.btnShare.setOnClickListener {
            shareProfile()
        }

        // Button untuk buka detail activity
        binding.btnDetail.setOnClickListener {
            val intent = Intent(requireContext(), DetailActivity::class.java).apply {
                putExtra("name", arguments?.getString("name") ?: "Belum diisi")
                putExtra("nim", arguments?.getString("nim") ?: "Belum diisi")
                putExtra("jurusan", arguments?.getString("jurusan") ?: "Belum diisi")
                putExtra("semester", arguments?.getString("semester") ?: "Belum diisi")
            }
            startActivity(intent)
        }
    }

    private fun displayProfile(name: String, nim: String, jurusan: String, semester: String) {
        // Debug display
        println("DEBUG: Displaying profile - Name: $name, NIM: $nim, Jurusan: $jurusan, Semester: $semester")

        binding.apply {
            tvName.text = "Nama: $name"
            tvNim.text = "NIM: $nim"
            tvJurusan.text = "Jurusan: $jurusan"
            tvSemester.text = "Semester: $semester"
        }

        // Debug after setting text
        println("DEBUG: Text views updated")
        println("DEBUG: tvName.text = ${binding.tvName.text}")
        println("DEBUG: tvNim.text = ${binding.tvNim.text}")
    }

    private fun shareProfile() {
        val name = arguments?.getString("name") ?: "Belum diisi"
        val nim = arguments?.getString("nim") ?: "Belum diisi"
        val jurusan = arguments?.getString("jurusan") ?: "Belum diisi"
        val semester = arguments?.getString("semester") ?: "Belum diisi"

        val shareText = """
            Profil Mahasiswa:
            Nama: $name
            NIM: $nim
            Jurusan: $jurusan
            Semester: $semester
        """.trimIndent()

        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, shareText)
            putExtra(Intent.EXTRA_SUBJECT, "Profil Mahasiswa")
        }

        startActivity(Intent.createChooser(shareIntent, "Bagikan profil via"))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}