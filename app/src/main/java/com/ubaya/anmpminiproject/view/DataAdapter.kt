package com.ubaya.anmpminiproject.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.anmpminiproject.databinding.PengukuranListItemBinding
import com.ubaya.anmpminiproject.model.Pengukuran
import com.ubaya.anmpminiproject.model.UkurData

class DataAdapter(private var pengukuranList: ArrayList<UkurData>)
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
        holder.binding.ukur = pengukuranList[position]

//        val pengukuran = pengukuranList[position]
//        holder.binding.txtUsiaValue.text = pengukuran.usia
//        holder.binding.txtTinggiValue.text = pengukuran.tinggi
//        holder.binding.txtBeratValue.text = pengukuran.berat
    }

    fun updateData(newPengukuranList: List<UkurData>) {
        pengukuranList.clear()
        pengukuranList.addAll(newPengukuranList)
        notifyDataSetChanged()
    }
}