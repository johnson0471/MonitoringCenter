package com.example.monitoringcenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.inputmethod.InputBinding
import com.example.monitoringcenter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpTab()
    }


    private fun setUpTab(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(CameraFragment(),"房屋即時畫面")
        adapter.addFragment(ResidentFragment(), "社區偵測數據")
        binding.viewPager.adapter = adapter
        binding.tab.setupWithViewPager(binding.viewPager)
    }
}