package com.junwooyeom.movieapplication.presentation.fragment.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.junwooyeom.movieapplication.R
import com.junwooyeom.movieapplication.databinding.FragmentDetailBinding
import com.junwooyeom.movieapplication.presentation.activity.MainActivity
import com.junwooyeom.movieapplication.presentation.viewmodel.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    private val args: DetailFragmentArgs by navArgs()

    private val viewModel by viewModels<FavoriteViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentDetailBinding.bind(view)

        initViews()
        initWebView()
        subscribeFlow()
        initListener()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView() {
        with(binding.webView) {
            webViewClient = WebViewClient()
            settings.apply {
                javaScriptEnabled = true
            }
            loadUrl(args.myArgs.link)
        }
    }

    private fun subscribeFlow() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getFavorites().collect { list ->
                binding.isSelected = list.find { it.title == args.myArgs.title } != null
            }
        }
    }

    private fun initViews() {
        binding.movie = args.myArgs
    }

    private fun initListener() {
        binding.btnFavorite.setOnClickListener {
            if (binding.isSelected == true) {
                viewModel.deleteToFavorite(binding.movie ?: args.myArgs)
            } else {
                viewModel.addToFavorite(binding.movie ?: args.myArgs)
            }
        }
    }
}
