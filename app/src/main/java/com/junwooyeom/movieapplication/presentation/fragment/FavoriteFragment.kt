package com.junwooyeom.movieapplication.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.junwooyeom.domain.model.Movie
import com.junwooyeom.movieapplication.R
import com.junwooyeom.movieapplication.databinding.FragmentFavoriteBinding
import com.junwooyeom.movieapplication.presentation.adapter.FavoriteAdapter
import com.junwooyeom.movieapplication.presentation.viewmodel.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding

    private val viewModel by viewModels<FavoriteViewModel>()

    private val adapter by lazy {
        FavoriteAdapter(
            this::onMovieSelected,
            this::onMovieFavoriteSelected
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavoriteBinding.bind(view)

        initRecyclerView()
        subscribeFlow()
    }

    private fun initRecyclerView() {
        binding.rvFavorite.layoutManager = LinearLayoutManager(requireContext())
        binding.rvFavorite.adapter = adapter
        binding.rvFavorite.addItemDecoration(
            DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        )
    }

    private fun subscribeFlow() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getFavorites().collect {
                adapter.submitList(it)
            }
        }
    }

    private fun onMovieSelected(movie: Movie) {
        val action =
            FavoriteFragmentDirections.actionFavoriteFragmentToDetailFragment(movie, movie.title)
        findNavController().navigate(action)
    }

    private fun onMovieFavoriteSelected(movie: Movie, isSelected: Boolean) {
        if (isSelected) {
            viewModel.deleteToFavorite(movie)
        }
    }

}
