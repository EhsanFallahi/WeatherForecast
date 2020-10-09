package com.fallahiehsan.weatherforecast.ui

import android.content.Context

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import com.fallahiehsan.weatherforecast.R
import com.fallahiehsan.weatherforecast.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toolbar:androidx.appcompat.widget.Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

        drawerLayout=binding.drawerLayout
        toolbar=binding.toolbar


        val actionbar: ActionBar? = supportActionBar
        actionbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)
        }
//        setSupportActionBar(toolbar)

        val navigationView:NavigationView=binding.navView
        navigationView.setNavigationItemSelectedListener {menuItem->
            menuItem.isChecked
            drawerLayout.closeDrawers()
            when(menuItem.itemId){
                R.id.unit->{
                    Toast.makeText(this,"is Unit...",Toast.LENGTH_LONG).show()
                }

                R.id.about->{
                    Toast.makeText(this,"is about...",Toast.LENGTH_LONG).show()
                }
            }

            // Add code here to update the UI based on the item selected
            // For example, swap UI fragments here

            true

        }



    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
        }
}