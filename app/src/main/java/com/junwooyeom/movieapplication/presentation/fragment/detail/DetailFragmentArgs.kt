package com.junwooyeom.movieapplication.presentation.fragment.detail

import androidx.navigation.NavArgs
import com.junwooyeom.domain.model.Movie

data class DetailFragmentArgs(
    val movie: Movie
) : NavArgs