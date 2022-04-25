package com.example.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieEntity(
    @PrimaryKey
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "link")
    val link: String,
    @ColumnInfo(name = "image")
    val image: String,
    @ColumnInfo(name = "subtitle")
    val subtitle: String,
    @ColumnInfo(name = "pubDate")
    val pubDate: String,
    @ColumnInfo(name = "director")
    val director: String,
    @ColumnInfo(name = "actor")
    val actor: String,
    @ColumnInfo(name = "userRating")
    val userRating: Float
)
