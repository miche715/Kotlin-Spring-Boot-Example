package com.example.androidclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.androidclient.databinding.ActivityMainBinding
import com.example.androidclient.model.ToDoDTO
import com.example.androidclient.service.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofit = Retrofit.Builder().baseUrl("http://192.168.0.5:8080/").addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(RetrofitService::class.java)

        service.getAll().enqueue(object: Callback<MutableList<ToDoDTO>>
        {
            override fun onResponse(call: Call<MutableList<ToDoDTO>>, response: Response<MutableList<ToDoDTO>>)
            {
                if(response.isSuccessful)
                {
                    binding.resultTextView.text = response.body().toString()
                }
                else
                {
                    println("[* * * LOG * * *] 실패함1.")
                }
            }

            override fun onFailure(call: Call<MutableList<ToDoDTO>>, t: Throwable)
            {
                println("[* * * LOG * * *] 실패함2.")
                println(t.toString())
            }
        })
    }
}