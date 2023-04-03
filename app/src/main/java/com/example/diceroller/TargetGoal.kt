package com.example.diceroller

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView

class TargetGoal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_target_goal)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        var mMediaPlayer:MediaPlayer? = null
        var value:String = ""
        var userName:String = ""
        val targetBtn = findViewById<RelativeLayout>(R.id.targetBtn)
        val target = findViewById<EditText>(R.id.target)
        val user = findViewById<EditText>(R.id.user)
        targetBtn.setOnClickListener{
            mMediaPlayer = MediaPlayer.create(this,R.raw.tape)
            mMediaPlayer!!.isLooping = false
            mMediaPlayer!!.start()
            value = target.text.toString()
            userName = user.text.toString()
            intent = Intent(this, NewGame::class.java)
            intent.putExtra("target1",value)
            intent.putExtra("user1",userName)
            startActivity(intent)
        }
        val skip = findViewById<TextView>(R.id.skip)
        skip.setOnClickListener{
            mMediaPlayer = MediaPlayer.create(this,R.raw.tape)
            mMediaPlayer!!.isLooping = false
            mMediaPlayer!!.start()
            intent = Intent(this, NewGame::class.java)
            startActivity(intent)
        }
    }
}