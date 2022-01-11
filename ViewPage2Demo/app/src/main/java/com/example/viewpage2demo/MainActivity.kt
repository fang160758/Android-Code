package com.example.viewpage2demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPager2:ViewPager2 = findViewById(R.id.viewPager2)
        object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int  = 3
            override fun createFragment(position: Int) = when(position) {
                0-> RotateFragment()
                1-> ScaleFragment()
                else-> TranslateFragment()
            }
        }.also { viewPager2.adapter = it }

        val tabLayout:TabLayout = findViewById(R.id.tablayout)

        TabLayoutMediator(tabLayout,viewPager2){
            tab,position -> when(position) {
                0-> tab.text = "旋转"
                1-> tab.text = "缩放"
                else -> tab.text = "平移"
            }
            Log.d("mylog", "onCreate: ${position}")
        }.attach()
    }
}
