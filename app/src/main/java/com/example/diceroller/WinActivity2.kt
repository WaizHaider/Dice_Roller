package com.example.diceroller

import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView

class WinActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win2)
        var mMediaPlayer:MediaPlayer? = null
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        var humScore:Int = 0
        var comScore1:Int = 0
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
            win.setText("Player 1 Wins").toString()
            win.setTextColor(Color.parseColor("#00FF00"))
        }else{
            mMediaPlayer = MediaPlayer.create(this,R.raw.victory)
            mMediaPlayer!!.isLooping = false
            mMediaPlayer!!.start()
            win.setText("Player 2 Wins").toString()
            win.setTextColor(Color.parseColor("#00FF00"))
        }
        fun pauseSound() {
            if (mMediaPlayer?.isPlaying == true)
                mMediaPlayer?.pause()
        }
        val menuBtn = findViewById<RelativeLayout>(R.id.menuBtn)
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