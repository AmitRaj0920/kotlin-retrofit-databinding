package com.amitraj.kotlinretrofit.ui.activities

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.FragmentManager
import android.support.v4.view.GravityCompat
import android.support.v7.app.AlertDialog
import android.view.MenuItem
import com.amitraj.kotlinretrofit.R
import com.amitraj.kotlinretrofit.ui.BaseActivity
import com.amitraj.kotlinretrofit.ui.fragments.MovieListFragment
import kotlinx.android.synthetic.main.activity_home_page.*
import kotlinx.android.synthetic.main.app_bar_home_page.*

class HomePageActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener,
        FragmentManager.OnBackStackChangedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        setSupportActionBar(toolbar)

        menuRight.setOnClickListener {
            if (drawer_layout.isDrawerOpen(GravityCompat.END)) {
                drawer_layout.closeDrawer(GravityCompat.END)
            } else {
                drawer_layout.openDrawer(GravityCompat.END)
            }
        }

        nav_view.setNavigationItemSelectedListener(this)
        addFragment(MovieListFragment.newInstance(), "HomePageActivity->MovieListFragment")
    }


    override fun onBackPressed() {
        val backStackEntryCount = supportFragmentManager.backStackEntryCount
        if (backStackEntryCount == 0) {
            showExitAlert()
        } else {
            super.onBackPressed()
        }
//        if (drawer_layout.isDrawerOpen(GravityCompat.END)) {  /*Closes the Appropriate Drawer*/
//            drawer_layout.closeDrawer(GravityCompat.END)
//        } else {
//            super.onBackPressed()
//        }
    }

    private fun showExitAlert() {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Exit")
        dialog.setMessage("Do you want to exit?")
        dialog.setPositiveButton("Yes") { dialogInterface, i -> System.exit(0) }
        dialog.setNegativeButton("No", null)
        dialog.show()
    }

    override fun onBackStackChanged() {
        val backStackEntryCount = supportFragmentManager.backStackEntryCount
        if (backStackEntryCount == 0) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        } else {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.home_page, menu)
//        return true
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        when (item.itemId) {
//            R.id.action_settings -> return true
//            else -> return super.onOptionsItemSelected(item)
//        }
//    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.END)
        return true
    }
}
