package com.android.getresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.getresult.activity.FirstActivity
import com.android.getresult.databinding.ActivityMainBinding
import com.android.getresult.fragment.MyFragmentActivity
import com.android.getresult.gallery.GalleryActivity

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupClickListener()
    }

    private fun setupClickListener() {
        with(binding) {
            goToActivity.setOnClickListener {
                startActivity(Intent(this@MainActivity, FirstActivity::class.java))
            }
            goToFragment.setOnClickListener {
                startActivity(Intent(this@MainActivity, MyFragmentActivity::class.java))
            }
            goToGallery.setOnClickListener {
                startActivity(Intent(this@MainActivity, GalleryActivity::class.java))
            }
        }
    }

}