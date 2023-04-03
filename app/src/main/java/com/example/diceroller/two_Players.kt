package com.example.diceroller

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView

class two_Players : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_players)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        var mMediaPlayer: MediaPlayer? = null
        var value:String = ""
        var userName1:String = ""
        var userName2:String = ""
        val targetBtn = findViewById<RelativeLayout>(R.id.targetBtn1)
        val target = findViewById<EditText>(R.id.target1)
        val user1 = findViewById<EditText>(R.id.user1)
        val user2 = findViewById<EditText>(R.id.user2)
        targetBtn.setOnClickListener{
            mMediaPlayer = MediaPlayer.create(this,R.raw.tape)
            mMediaPlayer!!.isLooping = false
            mMediaPlayer!!.start()
            value = target.text.toString()
            userName1 = user1.text.toString()
            userName2 = user2.text.toString()
            intent = Intent(this, Game2::class.java)
            intent.putExtra("target1",value)
            intent.putExtra("user1",userName1)
            intent.putExtra("user2",userName2)
            startActivity(intent)
        }
        val skip = findViewById<TextView>(R.id.skip)
        skip.setOnClickListener{
            mMediaPlayer = MediaPlayer.create(this,R.raw.tape)
            mMediaPlayer!!.isLooping = false
            mMediaPlayer!!.start()
            intent = Intent(this, Game2::class.java)
            startActivity(intent)
        }
    }
}