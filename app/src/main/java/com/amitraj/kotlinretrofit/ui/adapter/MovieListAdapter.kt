package com.amitraj.kotlinretrofit.ui.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.amitraj.kotlinretrofit.R
import com.amitraj.kotlinretrofit.databinding.RecyclerMovieListBinding
import com.amitraj.kotlinretrofit.listeners.OnListItemClickListener
import com.amitraj.kotlinretrofit.models.MovieListModel

/**
 * Created by amitacharya on 12/12/17.
 */
class MovieListAdapter (private val context: Context, private val arrayList: ArrayList<MovieListModel>)
    : RecyclerView.Adapter<MovieListAdapter.ViewAgency>() {

    private var onListItemClickListener: OnListItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MovieListAdapter.ViewAgency{
        val binding: RecyclerMovieListBinding = DataBindingUtil.inflate(LayoutInflater.from(context)
                , R.layout.recycler_movie_list, parent, false)
        return ViewAgency(binding)
    }

    override fun onBindViewHolder(holder: MovieListAdapter.ViewAgency, position: Int) {
        val movieListModel = arrayList[position]
        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500/" + movieListModel.getPoster_path())
                .centerCrop()
                .into(holder.mBinding.ivPosterMovie)

        if (movieListModel.isAdult()) {
            holder.mBinding.tvAdult.text = "A"
        } else {
            holder.mBinding.tvAdult.text = "U/A"
        }

        holder.mBinding.model = movieListModel
        holder.mBinding.executePendingBindings()

        holder.itemView.setOnClickListener { onListItemClickListener!!.onItemClick(position) }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class ViewAgency (val mBinding: RecyclerMovieListBinding)
        : RecyclerView.ViewHolder(mBinding.root)

    fun setOnItemClickListener(onItemClickListener: OnListItemClickListener) {
        this.onListItemClickListener = onItemClickListener
    }
}