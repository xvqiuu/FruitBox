package com.example.fruitbox

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.fruitbox.databinding.ActivityDescriptionBinding

class DecriptionActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDescriptionBinding

    companion object {
        const val EXTRA_FRUIT = "extra_fruit"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar) // Mengatur Toolbar sebagai ActionBar
        supportActionBar?.title = "FruitBox" // Memberikan judul pada Action Bar

        val fruit = intent.getParcelableExtra<Fruit>(EXTRA_FRUIT)

        fruit?.let {
            with(binding) {
                detailImage.setImageResource(it.imageResId)
                descName.text = "Nama: " + it.name
                descColor.text = "Warna: " + it.color
                descTaste.text = "Rasa: " + it.taste
                descNutrition.text = "Kandungan: " + it.nutrition
            }
        }

        binding.btnBack.setOnClickListener {
            finish() // Kembali ke halaman sebelumnya
        }
    }
}
