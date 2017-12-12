package com.amitraj.kotlinretrofit.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import com.amitraj.kotlinretrofit.R

/**
 * Created by amitacharya on 06-Dec-17.
 */

open class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private var progressDialog: ProgressDialog? = null

    @Synchronized
    fun showProgressDialog() {
        progressDialog = ProgressDialog(context, R.style.TransparentProgressDialog)
//        progressDialog!!.setMessage("Loading...")
        progressDialog!!.setCancelable(false)
        progressDialog!!.setProgressStyle(/*ProgressDialog.STYLE_SPINNER*/ android.R.style.Widget_ProgressBar_Small)
        progressDialog!!.show()
    }

    @Synchronized
    fun dismissProgressDialog() {
        if (progressDialog == null) {
            return
        }
        progressDialog!!.dismiss()
    }

    fun showServerError() {
        try {
            val builder = AlertDialog.Builder(activity)
            builder.setTitle("Network Error")
            builder.setMessage(
                    "Unable to connect to server, please check your internet connection and try again.")
            builder.setNeutralButton("Dismiss") { dialogInterface, i -> dialogInterface.dismiss() }.create().show()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun showServerError(msg: String) {
        try {
            val builder = AlertDialog.Builder(activity)
            builder.setMessage(msg)
            builder.setNeutralButton("Dismiss") { dialogInterface, i -> dialogInterface.dismiss() }.create().show()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    protected fun replaceFragment(fragment: BaseFragment, tag: String) {
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment, tag)
                .addToBackStack(tag)
                .commit()
    }
}