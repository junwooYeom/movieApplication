package com.junwooyeom.movieapplication.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.junwooyeom.domain.model.Movie
import com.junwooyeom.movieapplication.R
import com.junwooyeom.movieapplication.databinding.FragmentMovieBinding
import com.junwooyeom.movieapplication.presentation.viewmodel.FavoriteViewModel
import com.junwooyeom.movieapplication.presentation.adapter.MovieAdapter
import com.junwooyeom.movieapplication.presentation.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding

    private val movieViewModel by viewModels<MovieViewModel>()
    private val favoriteViewModel by viewModels<FavoriteViewModel>()

    private val adapter by lazy {
        MovieAdapter(
            this::onMovieSelected,
            this::onMovieFavoriteSelected
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieBinding.bind(view)

        initRecyclerView()
        initListeners()
        subscribeFavorite()
    }

    private fun getMovie(query: String) {
        viewLifecycleOwner.lifecycleScope.launch {
            movieViewModel.getMovie(query).collect {
                adapter.submitData(it)
            }
        }
    }

    private fun subscribeFavorite() {
        viewLifecycleOwner.lifecycleScope.launch {
            favoriteViewModel.getFavorites().collect {
                 adapter.addToFavoriteMovieList(it)
            }
        }
    }

    private fun initRecyclerView() {
        binding.rvMovie.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMovie.adapter = adapter
        binding.rvMovie.addItemDecoration(
            DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        )
        adapter.addLoadStateListener { loadState ->
            if (loadState.source.refresh is LoadState.NotLoading && loadState.append.endOfPaginationReached && adapter.itemCount < 1) {
                binding.rvMovie.visibility = View.GONE
                binding.layoutEmpty.visibility = View.VISIBLE
            } else {
                binding.layoutEmpty.visibility = View.GONE
                binding.rvMovie.visibility = View.VISIBLE
            }
        }
    }

    private fun initListeners() {
        with(binding.etMovie.editText) {
            this?.doOnTextChanged { text, _, _, _ ->
                if (text.isNullOrEmpty()) {
                    binding.etMovie.error = "?????? ????????? ??????????????????."
                } else {
                    binding.etMovie.error = null
                    getMovie(text.toString())
                }
            }
        }

        binding.btnFavorite.setOnClickListener {
            val action = MovieFragmentDirections.actionMovieFragmentToFavoriteFragment()
            findNavController().navigate(action)
        }
    }

    private fun onMovieSelected(movie: Movie) {
        val action = MovieFragmentDirections.actionMovieFragmentToDetailFragment(
            movie,
            movie.title
        )
        findNavController().navigate(action)
    }

    private fun onMovieFavoriteSelected(movie: Movie, isSelected: Boolean) {
        if (isSelected) {
            favoriteViewModel.deleteToFavorite(movie)
        } else {
            favoriteViewModel.addToFavorite(movie)
        }
    }

}
