package com.amitraj.kotlinretrofit.ui.fragments

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amitraj.kotlinretrofit.R
import com.amitraj.kotlinretrofit.databinding.MovieDetailsFragmentBinding
import com.amitraj.kotlinretrofit.listeners.ButtonClickListener
import com.amitraj.kotlinretrofit.listeners.NetworkResponseListner
import com.amitraj.kotlinretrofit.models.MovieDetailModel
import com.amitraj.kotlinretrofit.network.NetworkController
import com.amitraj.kotlinretrofit.ui.BaseFragment
import com.bumptech.glide.Glide
import java.util.HashMap

/**
 * Created by amitacharya on 12/12/17.
 */
class MovieDetailsFragment : BaseFragment(), NetworkResponseListner<MovieDetailModel>, ButtonClickListener {

    companion object {
        fun newInstance(bundle: Bundle): MovieDetailsFragment {
            val frag = MovieDetailsFragment()
            frag.arguments = bundle
            return frag
        }
    }
    lateinit private var mBinding: MovieDetailsFragmentBinding
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil
                .inflate(inflater, R.layout.movie_details_fragment, container, false)
//        mBinding.model
        return mBinding.root
    }

    private var movieId:String = ""

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity.title = "Movie Details"
        mBinding.handler = this
        if (arguments != null) {
            movieId = arguments.getString("movieId")
        }
        val map = HashMap<String, String>()
        map.put("api_key", "b7cd3340a794e5a2f35e3abb820b497f")
//        String path = movieId+getString(R.string.urlamp)+"api_key=b7cd3340a794e5a2f35e3abb820b497f";
        val controller = NetworkController(this)
        controller.getMovieDetails(this, movieId, map)

    }

    override fun onDevelopedByClickListner() {
        replaceFragment(DevelopedByFragment.newInstance(), "DevelopedByFragment->MovieDetailsFragment")
    }

    override fun onResponse(response: MovieDetailModel) {
        mBinding.model = response
        val stars = response.getPopularity().toFloat() / 100
        mBinding.ratingBar.rating = stars
        Glide.with(activity)
                .load("https://image.tmdb.org/t/p/w500/" + response.getPoster_path())
                .fitCenter()
                .into(mBinding.imageView)
    }
}