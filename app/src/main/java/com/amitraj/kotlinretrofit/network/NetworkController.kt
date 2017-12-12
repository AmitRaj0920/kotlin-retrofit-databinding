package com.amitraj.kotlinretrofit.network

import com.amitraj.kotlinretrofit.BaseApplication
import com.amitraj.kotlinretrofit.listeners.NetworkResponseListner
import com.amitraj.kotlinretrofit.models.MovieDetailModel
import com.amitraj.kotlinretrofit.models.ResponseMovieListModel
import com.amitraj.kotlinretrofit.ui.BaseFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by amitacharya on 12/12/17.
 */
class NetworkController(private val baseContext: BaseFragment) {

//        private var baseActivity: BaseActivity
    private val baseApp:BaseApplication= BaseApplication()

    fun getMovieList(listner: NetworkResponseListner<ResponseMovieListModel>, api_key: String) {
        baseContext.showProgressDialog()
        baseApp.getRetrofitAPI()?.getMovieList(api_key)?.enqueue(object : Callback<ResponseMovieListModel> {
            override fun onResponse(call: Call<ResponseMovieListModel>, response: Response<ResponseMovieListModel>?) {
                baseContext.dismissProgressDialog()

                if (response != null && response.body() != null) {
                    listner.onResponse(response.body())
                }
            }

            override fun onFailure(call: Call<ResponseMovieListModel>, t: Throwable) {
                baseContext.dismissProgressDialog()
                baseContext.showServerError("Please try again !!!")
            }
        })
    }

    fun getMovieDetails(listner: NetworkResponseListner<MovieDetailModel>, id: String, api_key: Map<String, String>) {
        baseContext.showProgressDialog()
        baseApp.getRetrofitAPI()?.getMovieDetails(id, api_key)?.enqueue(object : Callback<MovieDetailModel> {
            override fun onResponse(call: Call<MovieDetailModel>, response: Response<MovieDetailModel>?) {
                baseContext.dismissProgressDialog()

                if (response != null && response.body() != null) {
                    listner.onResponse(response.body())
                }
            }

            override fun onFailure(call: Call<MovieDetailModel>, t: Throwable) {
                baseContext.dismissProgressDialog()
                baseContext.showServerError("Please try again !!!")
            }
        })
    }
}