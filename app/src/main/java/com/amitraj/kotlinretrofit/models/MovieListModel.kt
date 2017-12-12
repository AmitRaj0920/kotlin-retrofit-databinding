package com.amitraj.kotlinretrofit.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by amitacharya on 12/12/17.
 */
class MovieListModel {
    @SerializedName("id")
    @Expose
    private var id: String? = null
    @SerializedName("poster_path")
    @Expose
    private var poster_path: String? = null
    @SerializedName("adult")
    @Expose
    private var adult: Boolean = false
    @SerializedName("release_date")
    @Expose
    private var release_date: String? = null
    @SerializedName("title")
    @Expose
    private var title: String? = null
    @SerializedName("overview")
    @Expose
    private var overview: String? = null
    @SerializedName("popularity")
    @Expose
    private var popularity: Double = 0.toDouble()

    fun getId(): String? {
        return id
    }

    fun setId(id: String) {
        this.id = id
    }

    fun getPoster_path(): String? {
        return poster_path
    }

    fun setPoster_path(poster_path: String) {
        this.poster_path = poster_path
    }

    fun isAdult(): Boolean {
        return adult
    }

    fun setAdult(adult: Boolean) {
        this.adult = adult
    }

    fun getRelease_date(): String? {
        return release_date
    }

    fun setRelease_date(release_date: String) {
        this.release_date = release_date
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun getOverview(): String? {
        return overview
    }

    fun setOverview(overview: String) {
        this.overview = overview
    }

    fun getPopularity(): Double {
        return popularity
    }

    fun setPopularity(popularity: Double) {
        this.popularity = popularity
    }
}