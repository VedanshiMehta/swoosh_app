package com.example.swoosh_app.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.swoosh_app.Model.Player
import com.example.swoosh_app.R
import com.example.swoosh_app.Utilities.EXTRA_PLAYER

class FinishActivity : AppCompatActivity() {
    private lateinit var  _swooshSelected : TextView
    private lateinit var _player : Player
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        _swooshSelected = findViewById<TextView>(R.id.textViewSerachLeague)
        _player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)!!
        _swooshSelected.text = "Looking for ${_player.league} ${_player.skill} near you..."
    }
}