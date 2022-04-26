package com.junwooyeom.movieapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.junwooyeom.domain.Movie
import com.junwooyeom.movieapplication.databinding.ItemMovieBinding
import java.lang.IllegalArgumentException

class MovieAdapter(
    private val isMovieSelected: (Movie) -> Unit,
    private val isMovieFavoriteSelected: (Movie, Boolean) -> Unit
) : PagingDataAdapter<Movie, MovieAdapter.ViewHolder>(movieComparator) {

    private var favoriteMovieList: List<Movie> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            isMovieSelected,
            isMovieFavoriteSelected
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(
            getItem(position),
            favoriteMovieList.find { getItem(position)?.title == it.title } != null)
    }

    fun addToFavoriteMovieList(movieList: List<Movie>) {
        favoriteMovieList = movieList
        notifyItemRangeChanged(0, itemCount)
    }

    class ViewHolder(
        private val binding: ItemMovieBinding,
        private val isMovieSelected: (Movie) -> Unit,
        private val isMovieFavoriteSelected: (Movie, Boolean) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Movie?, isFavorite: Boolean) {
            binding.movie = item
            binding.isSelected = isFavorite
            item?.let { movie ->
                binding.root.setOnClickListener {
                    isMovieSelected(movie)
                }

                binding.btnFavorite.setOnClickListener {
                    isMovieFavoriteSelected(movie, isFavorite)
                }
            }
        }
    }

    private companion object {
        val movieComparator = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }

        }
    }
}
