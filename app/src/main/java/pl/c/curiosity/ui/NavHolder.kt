package pl.c.curiosity.ui

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.navigation_activity.*
import pl.c.curiosity.R

class NavHolder : DaggerAppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.navigation_activity)

        navController = Navigation.findNavController(this, R.id.nav_holder)

        bottomNav.setupWithNavController(navController)
    }
}