package com.example.diceroller

import android.content.Intent
import android.media.MediaParser
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        var mMediaPlayer: MediaPlayer? = null
        val rules = findViewById<TextView>(R.id.rules)
        val startBtn = findViewById<RelativeLayout>(R.id.startBtn)
        val aboutBtn = findViewById<RelativeLayout>(R.id.aboutBtn)
        startBtn.setOnClickListener {
            mMediaPlayer = MediaPlayer.create(this,R.raw.tape)
            mMediaPlayer!!.isLooping = false
            mMediaPlayer!!.start()
            intent = Intent(this, GameMode::class.java)
            Toast.makeText(this@MainActivity, "Choose Game Mode", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
        aboutBtn.setOnClickListener {
            mMediaPlayer = MediaPlayer.create(this,R.raw.tape)
            mMediaPlayer!!.isLooping = false
            mMediaPlayer!!.start()
            intent = Intent(this, AboutActivity::class.java)
            Toast.makeText(this@MainActivity, "About", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
        rules.setOnClickListener{
            mMediaPlayer = MediaPlayer.create(this,R.raw.tape)
            mMediaPlayer!!.isLooping = false
            mMediaPlayer!!.start()
            intent = Intent(this, Rules::class.java)
            Toast.makeText(this@MainActivity, "Rules", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

    }
}