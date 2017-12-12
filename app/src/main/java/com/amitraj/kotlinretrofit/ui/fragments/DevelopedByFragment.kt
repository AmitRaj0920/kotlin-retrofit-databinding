package com.amitraj.kotlinretrofit.ui.fragments

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amitraj.kotlinretrofit.R
import com.amitraj.kotlinretrofit.databinding.DevelopedByFragmentBinding
import com.amitraj.kotlinretrofit.ui.BaseFragment

/**
 * Created by amitacharya on 12/12/17.
 */
class DevelopedByFragment :BaseFragment() {
    companion object {
        fun newInstance():DevelopedByFragment{
            val bundle= Bundle()
            val frag=DevelopedByFragment()
            frag.arguments=bundle
            return frag
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val mBinding:DevelopedByFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.developed_by_fragment, container, false)
        return mBinding.root
    }
}