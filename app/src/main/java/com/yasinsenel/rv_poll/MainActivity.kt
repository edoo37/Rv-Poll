package com.yasinsenel.rv_poll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.yasinsenel.rv_poll.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val onClick = { position: Int, data: Data -> Unit }
    private lateinit var binding : ActivityMainBinding
    private var answers : ArrayList<Data> = arrayListOf()
    private val adapter = ItemAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Burda yolladım değerleri
        answers.add(Data("İyi"))
        answers.add(Data("Kötü"))
        answers.add(Data("Eh İşte"))
        answers.add(Data("Çok iyi"))
        answers.add(Data("HARİKA !"))


        binding.apply {
            recyclerView.layoutManager =
             LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            recyclerView.adapter = adapter
            adapter.fillList(answers)


        }


    }

}