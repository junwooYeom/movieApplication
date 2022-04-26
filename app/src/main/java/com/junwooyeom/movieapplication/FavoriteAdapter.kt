package com.junwooyeom.movieapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.junwooyeom.domain.model.Movie
import com.junwooyeom.movieapplication.databinding.ItemMovieBinding

class FavoriteAdapter(
    private val isMovieSelected: (Movie) -> Unit,
    private val isMovieFavoriteSelected: (Movie, Boolean) -> Unit
) : ListAdapter<Movie, FavoriteAdapter.ViewHolder>(movieComparator){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            isMovieSelected,
            isMovieFavoriteSelected
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), true)
    }


    class ViewHolder(
        private val binding: ItemMovieBinding,
        private val isMovieSelected: (Movie) -> Unit,
        private val isMovieFavoriteSelected: (Movie, Boolean) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Movie, isSelected: Boolean) {
            binding.movie = item
            binding.isSelected = isSelected
            binding.root.setOnClickListener {
                isMovieSelected(item)
            }
            binding.btnFavorite.setOnClickListener {
                isMovieFavoriteSelected(item, isSelected)
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