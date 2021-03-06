package com.junwooyeom.data.mapper

import android.os.Build
import android.text.Html
import com.example.database.entity.MovieEntity
import com.junwooyeom.domain.model.Movie
import com.junwooyeom.network.model.dto.MovieDto

fun MovieDto.toMovie(): Movie =
    Movie(
        title.parseHtml(),
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

@Suppress("DEPRECATION")
fun String.parseHtml(): String {
    return if (this.contains("<b>")) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY).toString()
        } else {
            Html.fromHtml(this).toString()
        }
    } else {
        this
    }
}

fun String.toListString(): String {
    if (this.isEmpty()) {
        return ""
    }
    val items = this.substring(0, this.length - 1).split("|")
    return items.joinToString(", ")
}
