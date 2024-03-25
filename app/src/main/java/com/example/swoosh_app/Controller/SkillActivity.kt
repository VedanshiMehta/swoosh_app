package com.example.swoosh_app.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import android.widget.ToggleButton
import com.example.swoosh_app.Model.Player
import com.example.swoosh_app.R
import com.example.swoosh_app.Utilities.EXTRA_PLAYER


class SkillActivity : AppCompatActivity() {

    private lateinit var _toggleButtonBeginner: ToggleButton
    private  lateinit var _toggleButtonBaller: ToggleButton
    private lateinit var _player: Player

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putParcelable(EXTRA_PLAYER,_player)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        _toggleButtonBeginner = findViewById<ToggleButton>(R.id.toggleButtonBeginner)
        _toggleButtonBaller = findViewById<ToggleButton>(R.id.toggleButtonBaller)
        _player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)!!

    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        if(savedInstanceState != null)
        {
            _player =  savedInstanceState.getParcelable(EXTRA_PLAYER)!!
        }
    }

    fun  beginnerButtonOnClick(view: View)
    {
       _toggleButtonBaller.isChecked = false
        _player.skill = "beginner"
    }
    fun ballerButtonOnClick(view: View)
    {
      _toggleButtonBeginner.isChecked = false
        _player.skill = "baller"
    }
    fun finishButtonOnClick(view: View)
    {
        if(_player.skill != "") {
            val finishIntent = Intent(this,FinishActivity::class.java)
            finishIntent.putExtra(EXTRA_PLAYER,_player)
            startActivity(finishIntent)
        }else
        {
            Toast.makeText(this,"Please select the skill level.",Toast.LENGTH_SHORT).show()
        }

    }
}