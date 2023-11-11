package com.example.myapplogin.apiservice

import com.example.myapplogin.entity.RequestLogin
import com.example.myapplogin.entity.ResponseLogin
import com.example.myapplogin.entity.klasorDosyaGetir.KlasorDosyaGetirResponse
import retrofit2.Call
import retrofit2.http.*


interface APIService {
    //@FormUrlEncoded

    @POST("TicketAl/")
    fun  getTicketAl(@Body requestLogin: RequestLogin ,@Query("kullaniciAdi") kullaniciAdi: String, @Query("sifre") sifre: String): Call<ResponseLogin>

    @GET("KlasorListesiGetir")
    fun getKlasorListesiGetir(@Query("ticketID") ticketID: String?): Call<KlasorDosyaGetirResponse>

    @GET("DosyaListesiGetir")
    fun getDosyaListesiGetir(@Query("ticketID") ticketID: String?):  Call<KlasorDosyaGetirResponse>


}