package com.route.islami

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.route.islami.fragments.AhadethFragment
import com.route.islami.fragments.QuraanFragment
import com.route.islami.fragments.RadioFragment
import com.route.islami.fragments.SebhaFragment

class HomeActivity : AppCompatActivity() {
    lateinit var bottomNavbar : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNavbar = findViewById(R.id.navbar)
        showFragment(QuraanFragment())
        bottomNavbar.setOnItemSelectedListener { //menuitem ->it
            if (it.itemId == R.id.icQuran){
                showFragment(QuraanFragment())
            }
            else if (it.itemId == R.id.icAhadeth){
                showFragment(AhadethFragment())
            }
            else if (it.itemId == R.id.icSebha){
                showFragment(SebhaFragment())
            }
            else{
                showFragment(RadioFragment())
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer,fragment)
            .commit()
    }
}