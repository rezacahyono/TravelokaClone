package com.rchyn.travelokaclone.presentation.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.rchyn.travelokaclone.R
import com.rchyn.travelokaclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_main) as NavHostFragment
        navController = navHostFragment.navController

        val bottomNavigationView = binding.bottomNavMain
        val radius = resources.getDimension(R.dimen.bottom_nav_corner)
        val bottomNavigationBackground = bottomNavigationView.background as MaterialShapeDrawable
        bottomNavigationBackground.shapeAppearanceModel =
            bottomNavigationBackground.shapeAppearanceModel.toBuilder().apply {
                setAllCorners(CornerFamily.ROUNDED, radius)
            }.build()

        bottomNavigationView.setupWithNavController(navController)

    }
}