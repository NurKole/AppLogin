package com.example.myapplogin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.example.myapplogin.databinding.ActivityLoginBinding
import com.example.myapplogin.entity.RequestLogin
import com.example.myapplogin.entity.ResponseLogin
import com.example.myapplogin.RetrofitClient.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    private var ticket: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener {
            val userName =  binding.logUsername.text.toString()
            val password =  binding.logPassword.text.toString()


            val call: Call<ResponseLogin> = RetrofitClient.getClient().getTicketAl(RequestLogin(userName, password),userName, password)
            call.enqueue(object : Callback<ResponseLogin?> {
                override fun onResponse(call: Call<ResponseLogin?>, response: Response<ResponseLogin?>) {
                    if (response.isSuccessful && response.body()?.sonuc == true) {
                        val responseLogin: ResponseLogin? = response.body()
                        ticket = responseLogin?.id
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        intent.putExtra("ticket", ticket)
                        startActivity(intent)
                    }
                    else {
                        Toast.makeText(this@LoginActivity, "Kullanıcı adı veya şifre hatalı", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<ResponseLogin?>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, "Hata oluştu", Toast.LENGTH_LONG).show()
                    Log.v("Hata", t.message.toString())
                }
            })


        }
    }


}


