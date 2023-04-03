package com.example.diceroller

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast

class GameMode : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_mode)
        var mMediaPlayer:MediaPlayer? = null
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        val rules = findViewById<TextView>(R.id.rules)
        val compBtn = findViewById<RelativeLayout>(R.id.compBtn)
        val PlayerBtn = findViewById<RelativeLayout>(R.id.PlayerBtn)
        compBtn.setOnClickListener {
            mMediaPlayer = MediaPlayer.create(this,R.raw.tape)
            mMediaPlayer!!.isLooping = false
            mMediaPlayer!!.start()
            intent = Intent(this, TargetGoal::class.java)
            Toast.makeText(this@GameMode, "Set User Names", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
        PlayerBtn.setOnClickListener {
            mMediaPlayer = MediaPlayer.create(this,R.raw.tape)
            mMediaPlayer!!.isLooping = false
            mMediaPlayer!!.start()
            intent = Intent(this, two_Players::class.java)
            Toast.makeText(this@GameMode, "Set User Name", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
        rules.setOnClickListener{
            mMediaPlayer = MediaPlayer.create(this,R.raw.tape)
            mMediaPlayer!!.isLooping = false
            mMediaPlayer!!.start()
            intent = Intent(this, Rules::class.java)
            Toast.makeText(this@GameMode, "Rules", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
    }
}