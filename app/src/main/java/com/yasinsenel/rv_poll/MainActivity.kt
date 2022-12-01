package com.yasinsenel.rv_poll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.yasinsenel.rv_poll.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val adapter = ItemAdapter()
    private var answers : ArrayList<String> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Burda yolladım değerleri
    answers.add("İyi")
    answers.add("Kötü")
    answers.add("Eh İşte")
    answers.add("Çok iyi")
    answers.add("HARİKA !")

    binding.apply {
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter
        adapter.fillList(answers)
    }

    }
}