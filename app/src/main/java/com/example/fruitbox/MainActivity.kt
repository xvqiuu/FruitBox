package com.example.fruitbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fruitbox.databinding.ActivityMainBinding
import com.example.recyclerview.FruitAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar) // Mengatur Toolbar sebagai ActionBar
        supportActionBar?.title = "FruitBox" // Memberikan judul pada Action Bar

        val adapterFruit = FruitAdapter(generateFruitsData()) {
                fruit -> onItemClick(fruit)
        }

        with(binding) {
            rvFruit.apply {
                adapter = adapterFruit
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    fun generateFruitsData (): List<Fruit> {
        return listOf(
            Fruit(imageResId = R.drawable.orange, name = "Jeruk", color = "Oranye", taste = "Asam", nutrition = "Vitamin C"),
            Fruit(imageResId = R.drawable.apple, name = "Apel", color = "Merah", taste = "Manis", nutrition = "Serat dan Vitamin C"),
            Fruit(imageResId = R.drawable.grape, name = "Anggur", color = "Ungu", taste = "Asam", nutrition = "Antioksidan"),
            Fruit(imageResId = R.drawable.banana, name = "Pisang", color = "Kuning", taste = "Manis", nutrition = "Kalium"),
            Fruit(imageResId = R.drawable.pineapple, name = "Nanas", color = "Kuning", taste = "Asam", nutrition = "Vitamin C"),
            Fruit(imageResId = R.drawable.durian, name = "Durian", color = "Kuning", taste = "Manis", nutrition = "Kalsium"),
            Fruit(imageResId = R.drawable.strawberry, name = "Strobery", color = "Merah", taste = "Asam", nutrition = "Vitamin C")
        )
    }
    fun onItemClick(data: Fruit) {
        val intent = Intent(this@MainActivity, DecriptionActivity::class.java)
        intent.putExtra(DecriptionActivity.EXTRA_FRUIT, data)
        startActivity(intent)

        Toast.makeText(this@MainActivity, "You clicked on ${data.name}",
            Toast.LENGTH_SHORT).show()
    }
}