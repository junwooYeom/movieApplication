package com.junwooyeom.data

import com.junwooyeom.domain.Movie
import com.junwooyeom.network.MovieDto

fun MovieDto.toMovie(): Movie =
    Movie(
        title,
        link,
        image,
        subtitle,
        pubDate,
        director.toDirector(),
        actor.toActors(),
        userRating
    )

fun String.toDirector() : String {
    return if (this.isEmpty().not()) {
        this.substring(0, this.length - 1)
    } else {
        ""
    }
}

fun String.toActors(): String {
    if (this.isEmpty()) {
        return ""
    }
    val items = this.substring(0, this.length - 1).split("|")
    return items.joinToString(",")
}
