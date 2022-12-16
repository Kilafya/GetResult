package com.android.getresult.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

class ActivityContract: ActivityResultContract<Int, Int>() {
    override fun createIntent(context: Context, input: Int): Intent {
        return Intent(context, SecondActivity::class.java).putExtra(GET_NUMBER, input)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Int {
        if (intent == null) throw java.lang.RuntimeException("Lol 1")
        if (resultCode != Activity.RESULT_OK) throw java.lang.RuntimeException("Lol 2")
        return intent.getIntExtra(GET_NUMBER, 0)
    }

    companion object {
        const val GET_NUMBER = "get_number"
    }
}