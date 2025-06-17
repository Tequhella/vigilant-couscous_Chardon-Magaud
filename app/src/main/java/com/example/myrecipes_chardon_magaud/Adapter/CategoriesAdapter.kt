package com.example.myrecipes_chardon_magaud.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecipes_chardon_magaud.Model.Categories
import com.example.myrecipes_chardon_magaud.databinding.ItemCategoriesBinding
import com.squareup.picasso.Picasso

class CategoriesAdapter(
    private var categories: List<Categories>,
    private val onItemClick: (Categories) -> Unit
) : RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(private val binding: ItemCategoriesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Categories) {
            binding.categoryName.text = category.categoryName
            Picasso.get().load(category.categoryImage).into(binding.categoryImage)

            binding.root.setOnClickListener {
                onItemClick(category)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun getItemCount() = categories.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    fun updateData(newCategories: List<Categories>) {
        categories = newCategories
        notifyDataSetChanged()
    }
}