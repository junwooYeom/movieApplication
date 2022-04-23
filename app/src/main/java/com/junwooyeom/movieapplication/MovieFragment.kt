package com.junwooyeom.movieapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.junwooyeom.movieapplication.databinding.FragmentMovieBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding

    private val viewModel by viewModels<MovieViewModel>()

    private val adapter by lazy {
        MovieAdapter()
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

        initListeners()
    }

    private fun getMovie(query: String) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getMovie(query).collect {
                adapter.submitData(it)
            }
        }
    }

    private fun initListeners() {
        binding.btnSearch.setOnClickListener {
            with (binding.etSearch.text) {
                if (isNullOrEmpty().not()) {
                    getMovie(this.toString())
                } else {
                    Toast.makeText(requireContext(), "영화 제목을 입력해주세요", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}