package com.ubaya.anmpminiproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.anmpminiproject.R
import com.ubaya.anmpminiproject.databinding.FragmentDataBinding
import com.ubaya.anmpminiproject.viewmodel.DataViewModel

class DataFragment : Fragment() {
    private lateinit var binding: FragmentDataBinding
    private lateinit var viewModel: DataViewModel
    private val adapter = DataAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DataViewModel::class.java)

        binding.recViewData.layoutManager = LinearLayoutManager(context)
        binding.recViewData.adapter = adapter
        viewModel.loadData()

        observeViewModel()
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadData()
    }

    private fun observeViewModel() {
        viewModel.listPengukuran.observe(viewLifecycleOwner) { data ->
            adapter.updateData(data)
        }

        viewModel.listKosong.observe(viewLifecycleOwner) { isKosong ->
            if (isKosong == true) {
                // Hapus data lama di adapter jika file kosong
                adapter.updateData(emptyList())
                Toast.makeText(context, "Belum ada data pengukuran", Toast.LENGTH_SHORT).show()
            }
        }
    }
}