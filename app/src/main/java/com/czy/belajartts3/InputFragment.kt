package com.czy.belajartts3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.czy.belajartts3.databinding.FragmentInputBinding

class InputFragment : Fragment() {
    private var _binding: FragmentInputBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInputBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmit.setOnClickListener {
            val name = binding.etName.text.toString().trim()
            val nim = binding.etNim.text.toString().trim()
            val jurusan = binding.etJurusan.text.toString().trim()
            val semester = binding.etSemester.text.toString().trim()

            // Debug log
            println("DEBUG: Input data - Name: $name, NIM: $nim, Jurusan: $jurusan, Semester: $semester")

            if (validateInput(name, nim, jurusan, semester)) {
                // Kirim data ke MainActivity untuk diteruskan ke ProfileFragment
                (activity as MainActivity).sendDataToProfile(name, nim, jurusan, semester)
            }
        }

        binding.btnClear.setOnClickListener {
            clearFields()
        }
    }

    private fun validateInput(name: String, nim: String, jurusan: String, semester: String): Boolean {
        return when {
            name.isEmpty() -> {
                binding.etName.error = "Nama tidak boleh kosong"
                false
            }
            nim.isEmpty() -> {
                binding.etNim.error = "NIM tidak boleh kosong"
                false
            }
            jurusan.isEmpty() -> {
                binding.etJurusan.error = "Jurusan tidak boleh kosong"
                false
            }
            semester.isEmpty() -> {
                binding.etSemester.error = "Semester tidak boleh kosong"
                false
            }
            else -> {
                Toast.makeText(context, "Data berhasil disimpan!", Toast.LENGTH_SHORT).show()
                true
            }
        }
    }

    private fun clearFields() {
        binding.etName.text?.clear()
        binding.etNim.text?.clear()
        binding.etJurusan.text?.clear()
        binding.etSemester.text?.clear()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}