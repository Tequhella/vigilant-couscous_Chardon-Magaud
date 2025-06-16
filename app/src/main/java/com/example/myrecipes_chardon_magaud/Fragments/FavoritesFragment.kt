package com.example.myrecipes_chardon_magaud.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myrecipes_chardon_magaud.Adapter.FavoriteRecipeAdapter
import com.example.myrecipes_chardon_magaud.R
import com.example.myrecipes_chardon_magaud.ViewModel.FavoritesViewModel
import com.example.myrecipes_chardon_magaud.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {

    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FavoritesViewModel by viewModels()
    private lateinit var adapter: FavoriteRecipeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = FavoriteRecipeAdapter(
            onItemClick = { recipe ->
                val bundle = Bundle().apply {
                    putInt("recipeId", recipe.id)
                }
                findNavController().navigate(
                    R.id.action_favoritesFragment_to_recipeDetailFragment,
                    bundle
                )
            },
            onDeleteClick = { recipe ->
                viewModel.removeFromFavorites(recipe)
                Toast.makeText(requireContext(), "Supprimé des favoris", Toast.LENGTH_SHORT).show()
            }
        )

        binding.favoritesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.favoritesRecyclerView.adapter = adapter

        viewModel.favorites.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}