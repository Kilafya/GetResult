package com.android.getresult.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.getresult.activity.ActivityContract
import com.android.getresult.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    private val binding: ActivityFirstBinding by lazy {
        ActivityFirstBinding.inflate(layoutInflater)
    }

    private val activityLauncher = registerForActivityResult(ActivityContract()) {
        updateParam(it ?: number)
    }

    private var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupClickListener()
        updateParam()
    }

    private fun setupClickListener() {
        binding.btnNext.setOnClickListener {
            activityLauncher.launch(number)
        }
    }

    private fun updateParam(newValue: Int = number) {
        binding.tvNumber.text = newValue.toString()
        number = newValue
    }
}