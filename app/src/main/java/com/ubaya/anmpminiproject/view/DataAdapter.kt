package com.ubaya.anmpminiproject.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.anmpminiproject.databinding.PengukuranListItemBinding
import com.ubaya.anmpminiproject.model.Pengukuran

class DataAdapter(private var pengukuranList: ArrayList<Pengukuran>)
    : RecyclerView.Adapter<DataAdapter.PengukuranViewHolder>()  {

    class PengukuranViewHolder(var binding: PengukuranListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PengukuranViewHolder {
        val binding = PengukuranListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return PengukuranViewHolder(binding)
    }

    override fun getItemCount() = pengukuranList.size

    override fun onBindViewHolder(holder: PengukuranViewHolder, position: Int) {
        val pengukuran = pengukuranList[position]
        holder.binding.txtUsiaValue.text = "${pengukuran.usia} tahun"
        holder.binding.txtTinggiValue.text = "${pengukuran.tinggi} cm"
        holder.binding.txtBeratValue.text = "${pengukuran.berat} kg"
    }

    fun updateData(newPengukuranList: List<Pengukuran>) {
        pengukuranList.clear()
        pengukuranList.addAll(newPengukuranList)
        notifyDataSetChanged()
    }
}