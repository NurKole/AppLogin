package com.example.myapplogin.entity.klasorDosyaGetir


import com.google.gson.annotations.SerializedName

data class KlasorDosyaGetirResponseItem(
    @SerializedName("Adi")
    var adi: String,
    @SerializedName("ID")
    var ıD: Int,
    @SerializedName("Boyut")
    var boyut: Int?
)