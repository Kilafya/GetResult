package com.android.getresult.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.getresult.activity.ActivityContract.Companion.GET_NUMBER
import com.android.getresult.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }

    private var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        parsParam()
        setClickListeners()
        updateParam()
    }

    private fun setClickListeners() {
        with(binding) {
            btnAdd.setOnClickListener {
                updateParam(number + 1)
            }
            btnRemove.setOnClickListener {
                updateParam(number - 1)
            }
            btnGoBack.setOnClickListener {
                setResult(RESULT_OK, Intent().putExtra(GET_NUMBER, number))
                finish()
            }
        }
    }

    private fun updateParam(newValue: Int = number) {
        binding.tvValue.text = newValue.toString()
        number = newValue
    }

    private fun parsParam() {
        number = intent.getIntExtra(GET_NUMBER, 0)
    }
}