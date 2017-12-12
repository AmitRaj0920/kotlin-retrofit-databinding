package com.amitraj.kotlinretrofit.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by amitacharya on 12/12/17.
 */
class MovieDetailModel {
    @SerializedName("original_title")
    @Expose
    private var original_title: String? = null
    @SerializedName("overview")
    @Expose
    private var overview: String? = null
    @SerializedName("popularity")
    @Expose
    private var popularity: Double = 0.toDouble()
    @SerializedName("poster_path")
    @Expose
    private var poster_path: String? = null

    fun getPoster_path(): String? {
        return poster_path
    }

    fun setPoster_path(poster_path: String) {
        this.poster_path = poster_path
    }

    fun getOriginal_title(): String? {
        return original_title
    }

    fun setOriginal_title(original_title: String) {
        this.original_title = original_title
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