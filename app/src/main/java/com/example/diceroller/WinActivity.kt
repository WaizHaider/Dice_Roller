package com.example.diceroller

import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import java.util.*

class WinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        var humScore:Int = 0
        var comScore1:Int = 0
        var mMediaPlayer: MediaPlayer? = null
        val bundle =intent.extras
        var Samplename:String = ""
        var Samplename1:String = ""
        var name1: String = ""
        if (bundle != null){
            Samplename = bundle.getInt("sum").toString()
            name1 = bundle.getString("user").toString()
            val username = findViewById<TextView>(R.id.winName)
            val score1  = findViewById<TextView>(R.id.score1)
            score1.setText(Samplename).toString()
           // username.setText(name1).toString()
            humScore = Samplename.toInt()
            Samplename1 = bundle.getInt("sum1").toString()
            val score2  = findViewById<TextView>(R.id.score2)
            score2.setText(Samplename1).toString()
            comScore1 = Samplename1.toInt()
        }
        val win = findViewById<TextView>(R.id.win)
        if(humScore>comScore1){
            mMediaPlayer = MediaPlayer.create(this,R.raw.victory)
            mMediaPlayer!!.isLooping = false
            mMediaPlayer!!.start()
            win.setText("You Win").toString()
            win.setTextColor(Color.parseColor("#00FF00"))
        }else{
            mMediaPlayer = MediaPlayer.create(this,R.raw.lose)
            mMediaPlayer!!.isLooping = false
            mMediaPlayer!!.start()
            win.setText("You Lose").toString()
            win.setTextColor(Color.parseColor("#FF0000"))
        }
        val menuBtn = findViewById<RelativeLayout>(R.id.menuBtn)
        fun pauseSound() {
            if (mMediaPlayer?.isPlaying == true)
                mMediaPlayer?.pause()
        }
        menuBtn.setOnClickListener{
            pauseSound()
            mMediaPlayer = MediaPlayer.create(this,R.raw.tape)
            mMediaPlayer!!.isLooping = false
            mMediaPlayer!!.start()
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onBackPressed() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}