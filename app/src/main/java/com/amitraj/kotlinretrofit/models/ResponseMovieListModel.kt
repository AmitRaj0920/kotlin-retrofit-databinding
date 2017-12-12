package com.amitraj.kotlinretrofit.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

/**
 * Created by amitacharya on 12/12/17.
 */
class ResponseMovieListModel {
    @SerializedName("results")
    @Expose
    private var results: ArrayList<MovieListModel>? = null

    fun getResults(): ArrayList<MovieListModel>? {
        return results
    }

    fun setResults(results: ArrayList<MovieListModel>) {
        this.results = results
    }
}