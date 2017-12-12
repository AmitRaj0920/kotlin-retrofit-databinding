package com.amitraj.kotlinretrofit.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.amitraj.kotlinretrofit.R

/**
 * Created by amitacharya on 06-Dec-17.
 */
abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    protected fun addFragment(fragment: BaseFragment, tag: String) {
        supportFragmentManager.beginTransaction().add(R.id.container, fragment, tag).commit()
    }

}