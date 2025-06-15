package com.example.myrecipes_chardon_magaud.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecipes_chardon_magaud.Model.Recipe
import com.example.myrecipes_chardon_magaud.databinding.ItemRecipeBinding
import com.squareup.picasso.Picasso

class RecipeAdapter(
    private val onItemClick: (Int) -> Unit
) : ListAdapter<Recipe, RecipeAdapter.RecipeViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding = ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class RecipeViewHolder(private val binding: ItemRecipeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(recipe: Recipe) {
            binding.recipeTitle.text = recipe.recipeName
            Picasso.get().load(recipe.recipeImage).into(binding.recipeImage)

            binding.root.setOnClickListener {
                recipe.id?.let { id -> onItemClick(id) }
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Recipe>() {
        override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe) = oldItem == newItem
    }
}