package com.example.myapplogin

import android.R
import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.example.myapplogin.databinding.ActivityMainBinding
import com.example.myapplogin.ui.fragment.DuvarFragment
import com.google.android.material.navigation.NavigationView


private val ActivityMainBinding.root: Int
    get() {
        TODO("Not yet implemented")
    }

class MainActivity : AppCompatActivity() {
    lateinit var ticket: String
    lateinit var binding: ActivityMainBinding
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView : NavigationView
    lateinit var toggle : ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ticket = intent.getStringExtra("ticket").toString()
        initDuvarim()
        drawableInit()

    }

    private fun drawableInit() {
        drawerLayout = findViewById(com.example.myapplogin.R.id.drawerLayout)
        navView = findViewById(com.example.myapplogin.R.id.navView)
        toggle = ActionBarDrawerToggle(this, drawerLayout,binding.toolbar, com.example.myapplogin.R.string.open, com.example.myapplogin.R.string.close)
        drawerLayout.addDrawerListener(toggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        toggle.syncState()
        navView.setNavigationItemSelectedListener {
            true
        }

    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }


    private fun initDuvarim() {
        val duvarimFragment = DuvarFragment(ticket)
        val fragmentManager: FragmentManager = supportFragmentManager
        fragmentManager.commit {
            setReorderingAllowed(true)
            this.add(binding.container.id, duvarimFragment)

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.home) {
            if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                binding.drawerLayout.openDrawer(GravityCompat.START)
            }
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}












