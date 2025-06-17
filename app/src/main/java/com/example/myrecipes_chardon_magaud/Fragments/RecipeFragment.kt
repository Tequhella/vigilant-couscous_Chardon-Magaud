package com.example.myrecipes_chardon_magaud.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myrecipes_chardon_magaud.Adapter.RecipeAdapter
import com.example.myrecipes_chardon_magaud.R
import com.example.myrecipes_chardon_magaud.ViewModel.RecipeViewModel
import com.example.myrecipes_chardon_magaud.databinding.FragmentRecipeBinding
import kotlinx.coroutines.launch

class RecipeFragment : Fragment() {

    private var _binding: FragmentRecipeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RecipeViewModel by viewModels()
    private lateinit var adapter: RecipeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecipeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val category = arguments?.getString("categoryName") ?: return

        adapter = RecipeAdapter { recipeId ->
            val bundle = bundleOf("recipeId" to recipeId)
            findNavController().navigate(R.id.action_recipeFragment_to_recipeDetailFragment, bundle)
        }

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        lifecycleScope.launch {
            viewModel.getRecipes(category)
        }

        viewModel.recipes.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        val categoryName = arguments?.getString("categoryName") ?: "Recipes"

        (requireActivity() as AppCompatActivity).supportActionBar?.title = "$categoryName ${R.string.Recipes}"

        viewModel.getRecipes(categoryName)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}