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

class UkurFragment : Fragment(), UkurListener {
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

        // Binding Data ke XML
        binding.viewModel = viewModel
        binding.listener = this
        binding.lifecycleOwner = viewLifecycleOwner // supaya LiveData di ViewModel Two-Way Binding
    }

    override fun onClick(v: View) {
        val berat = viewModel.berat.value
        val tinggi = viewModel.tinggi.value
        val usia = viewModel.usia.value

        // Validasi
        if (!berat.isNullOrEmpty() && !tinggi.isNullOrEmpty() && !usia.isNullOrEmpty()) {
            viewModel.tambahData()
            Toast.makeText(v.context, "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(v.context, "Semua field harus diisi", Toast.LENGTH_SHORT).show()
        }
    }
}