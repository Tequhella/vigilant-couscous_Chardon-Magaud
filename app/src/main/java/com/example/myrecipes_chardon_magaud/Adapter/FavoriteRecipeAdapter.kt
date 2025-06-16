package com.example.myrecipes_chardon_magaud.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecipes_chardon_magaud.Entity.FavoriteRecipeEntity
import com.example.myrecipes_chardon_magaud.databinding.ItemFavoriteRecipeBinding
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class FavoriteRecipeAdapter(
    private val onItemClick: (FavoriteRecipeEntity) -> Unit,
    private val onDeleteClick: (FavoriteRecipeEntity) -> Unit
) : ListAdapter<FavoriteRecipeEntity, FavoriteRecipeAdapter.FavoriteViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFavoriteRecipeBinding.inflate(inflater, parent, false)
        return FavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class FavoriteViewHolder(private val binding: ItemFavoriteRecipeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(recipe: FavoriteRecipeEntity) {
            binding.recipeName.text = recipe.name
            binding.recipeDate.text = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
                .format(Date(recipe.timestamp))
            Picasso.get().load(recipe.imageUrl).into(binding.recipeImage)

            binding.root.setOnClickListener { onItemClick(recipe) }
            binding.deleteButton.setOnClickListener { onDeleteClick(recipe) }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<FavoriteRecipeEntity>() {
        override fun areItemsTheSame(oldItem: FavoriteRecipeEntity, newItem: FavoriteRecipeEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: FavoriteRecipeEntity, newItem: FavoriteRecipeEntity): Boolean {
            return oldItem == newItem
        }
    }
}