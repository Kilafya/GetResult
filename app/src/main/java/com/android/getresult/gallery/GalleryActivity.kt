package com.android.getresult.gallery

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.android.getresult.R
import com.android.getresult.databinding.ActivityGalleryBinding

class GalleryActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityGalleryBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        launchFragment(ImagesListFragment())
    }

    private fun launchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.galleryContainer.id, fragment)
            .addToBackStack(null)
            .commit()
    }
}