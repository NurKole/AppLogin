package com.example.myapplogin.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplogin.DosyaKlasorRecyclerAdapter
import com.example.myapplogin.RetrofitClient.RetrofitClient
import com.example.myapplogin.databinding.DuvarFragmentBinding
import com.example.myapplogin.entity.klasorDosyaGetir.KlasorDosyaGetirResponse
import com.example.myapplogin.entity.klasorDosyaGetir.KlasorDosyaGetirResponseItem
import retrofit2.Call
import retrofit2.Response

class DuvarFragment(var ticket : String)  : Fragment(){
    lateinit var binding : DuvarFragmentBinding
    private val dosyaKlasorRecyclerAdapter : DosyaKlasorRecyclerAdapter = DosyaKlasorRecyclerAdapter()
    var klasorDosyaGetirResponseItemList: ArrayList<KlasorDosyaGetirResponseItem> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DuvarFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.v("okhttp","duvar fragment")
        folderInit()
    }

    private fun folderInit() {
        val call: Call<KlasorDosyaGetirResponse> = RetrofitClient.getClient().getKlasorListesiGetir(ticket)
        call.enqueue(object : retrofit2.Callback<KlasorDosyaGetirResponse> {
            override fun onResponse(call: Call<KlasorDosyaGetirResponse>, response: Response<KlasorDosyaGetirResponse>) {
                response.body()?.let { klasorDosyaGetirResponseItemList.addAll(it) }
                fileInit()
            }

            override fun onFailure(call: Call<KlasorDosyaGetirResponse>, t: Throwable) {
                Log.v("Hata", t.message.toString())
            }
        })
    }

    private fun fileInit() {
        val call: Call<KlasorDosyaGetirResponse> = RetrofitClient.getClient().getDosyaListesiGetir(ticket)
        call.enqueue(object : retrofit2.Callback<KlasorDosyaGetirResponse> {
            override fun onResponse(call: Call<KlasorDosyaGetirResponse>, response: Response<KlasorDosyaGetirResponse>) {
                response.body()?.let { klasorDosyaGetirResponseItemList.addAll(it) }
                initAdater()
            }

            override fun onFailure(call: Call<KlasorDosyaGetirResponse>, t: Throwable) {
                Log.v("Hata", t.message.toString())
            }
        })
    }

    private fun initAdater() {
        dosyaKlasorRecyclerAdapter.setData(klasorDosyaGetirResponseItemList)
        binding.recyclerView.adapter = dosyaKlasorRecyclerAdapter
    }

}