package com.example.gallery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        NavigationUI.setupActionBarWithNavController(this,findNavController(R.id.fragment))
    }

//    override fun onSupportNavigateUp(): Boolean {
//        return super.onSupportNavigateUp() || findNavController(R.id.fragment).navigateUp()
//    }
}