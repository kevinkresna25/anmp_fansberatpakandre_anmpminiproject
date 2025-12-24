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

class ProfilFragment : Fragment(), ProfilListener {
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
        binding.viewModel = viewModel
        binding.listener = this // interface ke XML
        binding.lifecycleOwner = viewLifecycleOwner // untuk Two-Way Binding

        viewModel.fetch()

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.statusSimpan.observe(viewLifecycleOwner) { status ->
            if (status != null) {
                if (status == true) {
                    Toast.makeText(context, "Profil berhasil disimpan", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Gagal menyimpan profil", Toast.LENGTH_SHORT).show()
                }

                // Reset status agar Toast tidak muncul saat pindah halaman
                viewModel.resetStatus()
            }
        }
    }

    override fun onRadioClick(v: View) {
        val tag = v.tag.toString()
        viewModel.jenisKelamin.value = tag.toInt()
    }

    override fun onClick(v: View) {
        val nama = viewModel.nama.value
        val tgl = viewModel.tglLahir.value
        val jk = viewModel.jenisKelamin.value

        if (!nama.isNullOrEmpty() && !tgl.isNullOrEmpty() && jk != null) {
            viewModel.simpanProfil()
        } else {
            Toast.makeText(context, "Harap lengkapi semua data", Toast.LENGTH_SHORT).show()
        }
    }
}