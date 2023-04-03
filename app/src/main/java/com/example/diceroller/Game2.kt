package com.example.diceroller

import android.content.Intent
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.MediaController
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import java.util.*

class Game2 : AppCompatActivity(), SensorEventListener {
    lateinit var dice_1: ImageView
    lateinit var dice_2: ImageView
    lateinit var dice_3: ImageView
    lateinit var dice_4: ImageView
    lateinit var dice_5: ImageView
    lateinit var textView: TextView
    lateinit var logo: ImageView
    private lateinit var sensorManager: SensorManager
    var sum1 = 0
    var sum2 = 0
    var mMediaPlayer: MediaPlayer? = null
    private var tarValue:Int = 101
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game2)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        var userName:String = ""
        var userName1:String = ""
        logo = findViewById(R.id.logo)
        textView = findViewById(R.id.textview)
        val username = findViewById<TextView>(R.id.name)
        val username2 = findViewById<TextView>(R.id.name2)
        userName = username.text.toString()
        userName1 = username2.text.toString()
        val bundle =intent.extras
        var score1:String = ""
        var name1: String = ""
        var name2: String = ""
        if (bundle != null) {
            score1 = bundle.getString("target1").toString()
            name1 = bundle.getString("user1").toString()
            name2 = bundle.getString("user2").toString()
            val targetValue = findViewById<TextView>(R.id.targetValue)
            targetValue.setText(score1).toString()
            username.setText(name1).toString()
            username2.setText(name2).toString()
            tarValue = score1.toInt()
        }
        val rollBtn = findViewById<RelativeLayout>(R.id.rollBtn)
        val showBtn = findViewById<RelativeLayout>(R.id.showBtn)
        val score = findViewById<RelativeLayout>(R.id.score)
        var counter = 0
        showBtn.setOnClickListener{
            mMediaPlayer = MediaPlayer.create(this,R.raw.tape)
            mMediaPlayer!!.isLooping = false
            mMediaPlayer!!.start()
            if(counter%2==0){
                score.visibility = View.VISIBLE
                counter += 1
            }else{
                score.visibility = View.INVISIBLE
                counter += 1
            }
        }
        var counter1: Int = 1
        rollBtn.setOnClickListener {
            if(counter1 == 1){
                rollDice()
                counter1 +=1
            }
            if(counter1 == 2 ){
                if(sum1 < tarValue || sum2 < tarValue){
                    comRollDice()
                    counter1 += 1
                }else{
                    intent = Intent(this, WinActivity2::class.java)
                    intent.putExtra("sum",sum1)
                    intent.putExtra("sum1",sum2)
                    intent.putExtra("user", userName)
                    Toast.makeText(this@Game2, "End Game", Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                }
            }else  if (counter1 == 3){
                if(sum1 < tarValue || sum2 < tarValue){
                    rollDice()
                    counter1 += 1
                }else{
                    intent = Intent(this, WinActivity2::class.java)
                    intent.putExtra("sum",sum1)
                    intent.putExtra("sum1",sum2)
                    intent.putExtra("user", userName)
                    Toast.makeText(this@Game2, "End Game", Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                }
            }else  if (counter1 == 4){
                if(sum1 < tarValue || sum2 < tarValue){
                    comRollDice()
                    counter1 += 1
                    intent = Intent(this, WinActivity2::class.java)
                    intent.putExtra("sum",sum1)
                    intent.putExtra("sum1",sum2)
                    intent.putExtra("user", userName)
                    Toast.makeText(this@Game2, "End Game", Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                }else{
                    intent = Intent(this, WinActivity2::class.java)
                    intent.putExtra("sum",sum1)
                    intent.putExtra("sum1",sum2)
                    intent.putExtra("user", userName)
                    Toast.makeText(this@Game2, "End Game", Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                }
            }else if (counter1 == 5){
                if(sum1 < tarValue || sum2 < tarValue){
                    rollDice()
                    counter1 += 1
                }else{
                    intent = Intent(this, WinActivity2::class.java)
                    intent.putExtra("sum",sum1)
                    intent.putExtra("sum1",sum2)
                    intent.putExtra("user", userName)
                    Toast.makeText(this@Game2, "End Game", Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                }
            }else if (counter1 == 6){
                if(sum1 < tarValue || sum2 < tarValue){
                    comRollDice()
                    counter1 += 1
                    intent = Intent(this, WinActivity2::class.java)
                    intent.putExtra("sum",sum1)
                    intent.putExtra("sum1",sum2)
                    intent.putExtra("user", userName)
                    Toast.makeText(this@Game2, "End Game", Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                }else{
                    intent = Intent(this, WinActivity2::class.java)
                    intent.putExtra("sum",sum1)
                    intent.putExtra("sum1",sum2)
                    intent.putExtra("user", userName)
                    Toast.makeText(this@Game2, "End Game", Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                }
            }
        }
        dice_1 = findViewById(R.id.dice_1)
        dice_2 = findViewById(R.id.dice_2)
        dice_3 = findViewById(R.id.dice_3)
        dice_4 = findViewById(R.id.dice_4)
        dice_5 = findViewById(R.id.dice_5)
        var list = arrayOf(dice_1,dice_2,dice_3,dice_4,dice_5)
        setUpSensorStuff()
    }
    private fun setUpSensorStuff() {
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)?.also {
            sensorManager.registerListener(this,
                it,
                SensorManager.SENSOR_DELAY_FASTEST,
                SensorManager.SENSOR_DELAY_FASTEST)
        }

    }

    private fun rollDice(){
        mMediaPlayer = MediaPlayer.create(this,R.raw.dice)
        mMediaPlayer!!.isLooping = false
        mMediaPlayer!!.start()
        if(sum1 >=tarValue){
            intent = Intent(this, WinActivity2::class.java)
            Toast.makeText(this@Game2, "End Game", Toast.LENGTH_SHORT).show()
            intent.putExtra("sum",sum1)
            startActivity(intent)
        }else{
            val randomInt1 = Random().nextInt(6)+1
            val randomInt2 = Random().nextInt(6)+1
            val randomInt3 = Random().nextInt(6)+1
            val randomInt4 = Random().nextInt(6)+1
            val randomInt5 = Random().nextInt(6)+1
            val drawableResource1 = when (randomInt1){
                1 -> R.drawable.one
                2 -> R.drawable.two
                3 -> R.drawable.three
                4 -> R.drawable.four
                5 -> R.drawable.five
                else -> R.drawable.six
            }
            dice_1.setImageResource(drawableResource1)
            val drawableResource2 = when (randomInt2){
                1 -> R.drawable.one
                2 -> R.drawable.two
                3 -> R.drawable.three
                4 -> R.drawable.four
                5 -> R.drawable.five
                else -> R.drawable.six
            }
            dice_2.setImageResource(drawableResource2)
            val drawableResource3 = when (randomInt3){
                1 -> R.drawable.one
                2 -> R.drawable.two
                3 -> R.drawable.three
                4 -> R.drawable.four
                5 -> R.drawable.five
                else -> R.drawable.six
            }
            dice_3.setImageResource(drawableResource3)
            val drawableResource4 = when (randomInt4){
                1 -> R.drawable.one
                2 -> R.drawable.two
                3 -> R.drawable.three
                4 -> R.drawable.four
                5 -> R.drawable.five
                else -> R.drawable.six
            }
            dice_4.setImageResource(drawableResource4)
            val drawableResource5 = when (randomInt5){
                1 -> R.drawable.one
                2 -> R.drawable.two
                3 -> R.drawable.three
                4 -> R.drawable.four
                5 -> R.drawable.five
                else -> R.drawable.six
            }
            dice_5.setImageResource(drawableResource5)
            val sum: Int = randomInt1 + randomInt2 + randomInt3 + randomInt4 + randomInt5
            sum1 += sum
            val score1 = findViewById<TextView>(R.id.score1)
            val num:String = sum1.toString()
            score1.setText(num).toString()
        }
    }

    private fun comRollDice(){
        mMediaPlayer = MediaPlayer.create(this,R.raw.dice)
        mMediaPlayer!!.isLooping = false
        mMediaPlayer!!.start()
        if(sum2 >=tarValue){
            intent = Intent(this, WinActivity2::class.java)
            Toast.makeText(this@Game2, "End Game", Toast.LENGTH_SHORT).show()
            intent.putExtra("sum",sum2)
            startActivity(intent)
        }else{
            val randomIntC1 = Random().nextInt(6)+1
            val randomIntC2 = Random().nextInt(6)+1
            val randomIntC3 = Random().nextInt(6)+1
            val randomIntC4 = Random().nextInt(6)+1
            val randomIntC5 = Random().nextInt(6)+1
            val drawableResource1 = when (randomIntC1){
                1 -> R.drawable.one
                2 -> R.drawable.two
                3 -> R.drawable.three
                4 -> R.drawable.four
                5 -> R.drawable.five
                else -> R.drawable.six
            }
            dice_1.setImageResource(drawableResource1)
            val drawableResource2 = when (randomIntC2){
                1 -> R.drawable.one
                2 -> R.drawable.two
                3 -> R.drawable.three
                4 -> R.drawable.four
                5 -> R.drawable.five
                else -> R.drawable.six
            }
            dice_2.setImageResource(drawableResource2)
            val drawableResource3 = when (randomIntC3){
                1 -> R.drawable.one
                2 -> R.drawable.two
                3 -> R.drawable.three
                4 -> R.drawable.four
                5 -> R.drawable.five
                else -> R.drawable.six
            }
            dice_3.setImageResource(drawableResource3)
            val drawableResource4 = when (randomIntC4){
                1 -> R.drawable.one
                2 -> R.drawable.two
                3 -> R.drawable.three
                4 -> R.drawable.four
                5 -> R.drawable.five
                else -> R.drawable.six
            }
            dice_4.setImageResource(drawableResource4)
            val drawableResource5 = when (randomIntC5){
                1 -> R.drawable.one
                2 -> R.drawable.two
                3 -> R.drawable.three
                4 -> R.drawable.four
                5 -> R.drawable.five
                else -> R.drawable.six
            }
            dice_5.setImageResource(drawableResource5)
            val sum: Int = randomIntC1 + randomIntC2 + randomIntC3 + randomIntC4 + randomIntC5
            sum2 += sum
            val score2 = findViewById<TextView>(R.id.score2)
            val num:String = sum2.toString()
            score2.setText(num).toString()
        }
    }
    override fun onBackPressed() {
        startActivity(Intent(this, NewGame::class.java))
        Toast.makeText(this@Game2, "You Need To Finish This Game", Toast.LENGTH_SHORT).show()
    }
    override fun onSensorChanged(event: SensorEvent?) {
        if(event?.sensor?.type == Sensor.TYPE_ACCELEROMETER){
            val sides =  event.values[0]
            val upDown = event.values[1]
            textView.apply {
                rotationX = upDown * 3f
                rotationY = sides * 3f
                translationX = sides *-10
                translationY = upDown * 10
                rotation = -sides
            }
            val color = if(upDown.toInt() == 0 && sides.toInt() == 0) Color.GRAY else Color.WHITE
            textView.setBackgroundColor(color)
            logo.apply {
                rotationX = upDown * 3f
                rotationY = sides * 3f
                translationX = sides *-10
                translationY = upDown * 10
                rotation = -sides
            }
            val color1 = if(upDown.toInt() == 0 && sides.toInt() == 0) Color.GRAY else Color.WHITE
            logo.setBackgroundColor(color1)
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        return
    }

    override fun onDestroy() {
        sensorManager.unregisterListener(this)
        super.onDestroy()
    }
}