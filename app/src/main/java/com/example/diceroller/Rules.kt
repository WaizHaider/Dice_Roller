package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Rules : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rules)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
    }
}