package com.example.myrecipes_chardon_magaud.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.myrecipes_chardon_magaud.R
import com.example.myrecipes_chardon_magaud.ViewModel.FavoritesViewModel
import com.example.myrecipes_chardon_magaud.ViewModel.RecipeDetailViewModel
import com.example.myrecipes_chardon_magaud.databinding.FragmentRecipeDetailBinding
import com.squareup.picasso.Picasso

class RecipeDetailFragment : Fragment() {

    private lateinit var binding: FragmentRecipeDetailBinding
    private lateinit var viewModel: RecipeDetailViewModel
    private val favoritesViewModel: FavoritesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecipeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[RecipeDetailViewModel::class.java]

        val recipeId = arguments?.getInt("recipeId") ?: return

        viewModel.loadRecipeDetail(recipeId)

        viewModel.recipeDetail.observe(viewLifecycleOwner) { detail ->
            (requireActivity() as AppCompatActivity).supportActionBar?.title = detail?.recipeName

            val nutriScore = detail?.initNutriScore() ?: 0
            binding.nutriScoreView.setScore(nutriScore)

            Picasso.get().load(detail?.recipeImage).into(binding.recipeImage)
            binding.category.text = detail?.categorieName
            binding.area.text = detail?.area
            binding.instructions.text = detail?.instructions

            val ingredients = detail?.getIngredientList()
            binding.ingredients.text = ingredients?.joinToString("\n") {
                "- ${it.first}: ${it.second}"
            }
        }

        viewModel.recipeDetail.observe(viewLifecycleOwner) { detail ->
            detail?.let {
                binding.favoriteButton.setOnClickListener {
                    favoritesViewModel.addToFavorites(detail)
                    Toast.makeText(requireContext(), R.string.favorite_add, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}