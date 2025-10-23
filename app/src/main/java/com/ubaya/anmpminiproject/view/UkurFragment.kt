package com.ubaya.anmpminiproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.ubaya.anmpminiproject.R
import com.ubaya.anmpminiproject.databinding.FragmentUkurBinding
import com.ubaya.anmpminiproject.model.Pengukuran
import com.ubaya.anmpminiproject.viewmodel.UkurViewModel

class UkurFragment : Fragment() {
    private lateinit var binding: FragmentUkurBinding
    private lateinit var viewModel: UkurViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUkurBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(UkurViewModel::class.java)

        binding.btnTambahData.setOnClickListener {
            val berat = binding.txtBeratBadan.text.toString()
            val tinggi = binding.txtTinggiBadan.text.toString()
            val usia = binding.txtUsia.text.toString()

            if (berat.isNotEmpty() && tinggi.isNotEmpty() && usia.isNotEmpty()) {
                val pengukuran = Pengukuran(berat, tinggi, usia)
                viewModel.simpanPengukuran(pengukuran)
            } else {
                Toast.makeText(context, "Semua field harus diisi", Toast.LENGTH_SHORT).show()
            }
        }

        // Observe status penyimpanan
        viewModel.saveStatus.observe(viewLifecycleOwner) { status ->
            if (status == true) {
                Toast.makeText(context, "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show()
                binding.txtBeratBadan.setText("")
                binding.txtTinggiBadan.setText("")
                binding.txtUsia.setText("")
                binding.txtBeratBadan.requestFocus()
                viewModel.resetStatus()
            } else if(status == false) {
                Toast.makeText(context, "Gagal menyimpan data", Toast.LENGTH_SHORT).show()
                viewModel.resetStatus()
            }
        }
    }
}