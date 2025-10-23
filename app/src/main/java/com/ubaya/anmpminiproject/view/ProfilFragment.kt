package com.ubaya.anmpminiproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.ubaya.anmpminiproject.R
import com.ubaya.anmpminiproject.databinding.FragmentProfilBinding
import com.ubaya.anmpminiproject.viewmodel.ProfilViewModel

class ProfilFragment : Fragment() {
    private lateinit var binding: FragmentProfilBinding
    private lateinit var viewModel: ProfilViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProfilViewModel::class.java)
        viewModel.loadProfil()

        observeViewModel()

        binding.btnSimpan.setOnClickListener {
            val nama = binding.txtNama.text.toString()
            val tglLahir = binding.txtTglLahir.text.toString()
            val selectedRadioId = binding.radioGroupJK.checkedRadioButtonId
            val jenisKelamin = if (selectedRadioId == R.id.radioLaki) "Laki-laki" else "Perempuan"

            if (nama.isNotEmpty() && tglLahir.isNotEmpty() && selectedRadioId != -1) {
                viewModel.simpanProfil(nama, tglLahir, jenisKelamin)
            } else {
                Toast.makeText(context, "Harap lengkapi semua data", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun observeViewModel() {
        viewModel.nama.observe(viewLifecycleOwner) {
            binding.txtNama.setText(it)
        }
        viewModel.tglLahir.observe(viewLifecycleOwner) {
            binding.txtTglLahir.setText(it)
        }
        viewModel.jenisKelamin.observe(viewLifecycleOwner) {
            if (it == "Laki-laki") {
                binding.radioLaki.isChecked = true
            } else if (it == "Perempuan") {
                binding.radioPerempuan.isChecked = true
            }
        }
        viewModel.saveStatus.observe(viewLifecycleOwner) { status ->
            if (status == true) {
                Toast.makeText(context, "Profil berhasil disimpan", Toast.LENGTH_SHORT).show()
            } else if(status == false) {
                Toast.makeText(context, "Profil gagal disimpan", Toast.LENGTH_SHORT).show()
            }
        }
    }
}