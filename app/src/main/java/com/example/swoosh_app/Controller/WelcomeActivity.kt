package com.example.swoosh_app.Controller


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.swoosh_app.R

class WelcomeActivity : AppCompatActivity() {
    private lateinit var _buttonGetStarted:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        _buttonGetStarted = findViewById<Button>(R.id.buttonGetStatrted)

        _buttonGetStarted.setOnClickListener {
            val leagueIntent = Intent(this, LeagueActivity::class.java)
            startActivity(leagueIntent)
        }
    }
}