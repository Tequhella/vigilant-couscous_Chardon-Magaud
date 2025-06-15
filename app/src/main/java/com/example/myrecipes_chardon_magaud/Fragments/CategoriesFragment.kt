package com.example.myrecipes_chardon_magaud.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myrecipes_chardon_magaud.Adapter.CategoriesAdapter
import com.example.myrecipes_chardon_magaud.R
import com.example.myrecipes_chardon_magaud.ViewModel.CategoriesViewModel
import com.example.myrecipes_chardon_magaud.databinding.FragmentCategoriesBinding

class CategoriesFragment : Fragment() {

    private var _binding: FragmentCategoriesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CategoriesViewModel by viewModels()

    private lateinit var adapter: CategoriesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = CategoriesAdapter(emptyList()) { category ->
            val bundle = bundleOf("categoryName" to category.categoryName)
            findNavController().navigate(R.id.action_categoryFragment_to_recipeFragment, bundle)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        viewModel.categories.observe(viewLifecycleOwner) { categories ->
            adapter.updateData(categories)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}