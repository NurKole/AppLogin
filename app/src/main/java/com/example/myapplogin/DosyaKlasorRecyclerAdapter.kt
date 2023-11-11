package com.example.myapplogin

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplogin.databinding.KlasorDosyaRecyclerItemBinding
import com.example.myapplogin.entity.klasorDosyaGetir.KlasorDosyaGetirResponseItem

class DosyaKlasorRecyclerAdapter : RecyclerView.Adapter<DosyaKlasorRecyclerAdapter.ViewHolder>() {
    lateinit var list : ArrayList<KlasorDosyaGetirResponseItem>

    class ViewHolder(var binding: KlasorDosyaRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = KlasorDosyaRecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = list[position]
        holder.binding.apply {
            if (currentItem.boyut == null) {
                imageView.setImageResource(R.drawable.folder_image)
            } else {
                imageView.setImageResource(R.drawable.file_image)
            }

            textView.text = currentItem.adi
        }

    }

    override fun getItemCount() =  list.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list : ArrayList<KlasorDosyaGetirResponseItem>) {
        this.list = list
        notifyDataSetChanged()
    }




}
