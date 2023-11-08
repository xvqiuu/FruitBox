package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitbox.Fruit
import com.example.fruitbox.R
import com.example.fruitbox.databinding.ItemFruitBinding

typealias OnClickFruit = (Fruit) -> Unit

class FruitAdapter(private val listFruits: List<Fruit>,
                     private val onClickFruit: OnClickFruit) :
    RecyclerView.Adapter<FruitAdapter.ItemFruitViewHolder>() {


    inner class ItemFruitViewHolder (private val binding : ItemFruitBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data : Fruit) {
            with(binding) {
                imgIcon.setImageResource(data.imageResId)
                nameTxt.text = data.name
                colorTxt.text = data.color
                tasteTxt.text = data.taste
                nutritionTxt.text = data.nutrition

                itemView.setOnClickListener {
                    onClickFruit(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemFruitViewHolder {
        val binding = ItemFruitBinding.inflate(LayoutInflater.from(parent.context),parent,
            false)
        return ItemFruitViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listFruits.size
    }

    override fun onBindViewHolder(holder: ItemFruitViewHolder, position: Int) {
        val fruit = listFruits[position]
        holder.bind(fruit)

        // Ambil warna dari sumber daya warna
        val backgroundColorResId = when (fruit.taste) {
            "Manis" -> R.color.orange
            "Asam" -> R.color.red

            else -> R.color.white
        }
        holder.itemView.setBackgroundResource(backgroundColorResId)
    }
}