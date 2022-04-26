package com.junwooyeom.data

import com.example.database.MovieEntity
import com.junwooyeom.domain.model.Movie
import com.junwooyeom.network.model.dto.MovieDto

fun MovieDto.toMovie(): Movie =
    Movie(
        title,
        link,
        image,
        subtitle,
        pubDate,
        director.toListString(),
        actor.toListString(),
        userRating
    )

fun MovieEntity.toMovie(): Movie =
    Movie(
        title,
        link,
        image,
        subtitle,
        pubDate,
        director,
        actor,
        userRating
    )

fun Movie.toMovieEntity(): MovieEntity =
    MovieEntity(
        title,
        link,
        image,
        subtitle,
        pubDate,
        director,
        actor,
        userRating
    )

fun String.toListString(): String {
    if (this.isEmpty()) {
        return ""
    }
    val items = this.substring(0, this.length - 1).split("|")
    return items.joinToString(", ")
}
