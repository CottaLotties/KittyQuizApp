package com.example.kittyquizapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation

var navController: NavController? = null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // setting navigation controller for the fragment container
        navController = Navigation.findNavController(this, R.id.main_fragment);
    }
}