package com.amitraj.kotlinretrofit.ui.fragments

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amitraj.kotlinretrofit.R
import com.amitraj.kotlinretrofit.databinding.MovieListFragmentBinding
import com.amitraj.kotlinretrofit.listeners.NetworkResponseListner
import com.amitraj.kotlinretrofit.listeners.OnListItemClickListener
import com.amitraj.kotlinretrofit.models.MovieListModel
import com.amitraj.kotlinretrofit.models.ResponseMovieListModel
import com.amitraj.kotlinretrofit.network.NetworkController
import com.amitraj.kotlinretrofit.ui.BaseFragment
import com.amitraj.kotlinretrofit.ui.adapter.MovieListAdapter
import kotlinx.android.synthetic.main.movie_list_fragment.*
import java.util.ArrayList

/**
 * Created by amitacharya on 12/12/17.
 */
class MovieListFragment : BaseFragment(), NetworkResponseListner<ResponseMovieListModel>, OnListItemClickListener {

    companion object {
        fun newInstance():MovieListFragment{
            val bundle= Bundle()
            val frag=MovieListFragment()
            frag.arguments=bundle
            return frag
        }
    }
    private var arrayList: ArrayList<MovieListModel> ?=null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding:MovieListFragmentBinding=DataBindingUtil.inflate(inflater, R.layout.movie_list_fragment,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity.title = "Movie Lists"
        val controller = NetworkController(this)
        controller.getMovieList(this, "b7cd3340a794e5a2f35e3abb820b497f")
    }

    override fun onItemClick(positon: Int) {
        val bundle = Bundle()
        bundle.putString("movieId", arrayList!![positon].getId())
        replaceFragment(MovieDetailsFragment.newInstance(bundle), "MovieListFragment->MovieDetailsFragment")
    }

    override fun onResponse(response: ResponseMovieListModel) {
        arrayList = response.getResults()!!
        val linearLayoutManager = LinearLayoutManager(activity)
        recycleMovieList.layoutManager = linearLayoutManager
        recycleMovieList.setHasFixedSize(true)
        val adapter = MovieListAdapter(activity, arrayList!!)
        adapter.setOnItemClickListener(this)
        recycleMovieList.adapter = adapter
    }

}