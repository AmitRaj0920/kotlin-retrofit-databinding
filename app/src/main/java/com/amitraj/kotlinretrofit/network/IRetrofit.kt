package com.amitraj.kotlinretrofit.network

import com.amitraj.kotlinretrofit.models.MovieDetailModel
import com.amitraj.kotlinretrofit.models.ResponseMovieListModel
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by amitacharya on 12/12/17.
 */
interface IRetrofit {

    @FormUrlEncoded
    @POST("upcoming")
    fun getMovieList(@Field("api_key") api_key: String)
            : Call<ResponseMovieListModel>

    @GET("{path}")
    fun getMovieDetails(@Path("path") path: String, @QueryMap filters: Map<String, String>)
            : Call<MovieDetailModel>

}