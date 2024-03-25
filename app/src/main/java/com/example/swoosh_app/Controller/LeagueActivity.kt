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

class LeagueActivity : AppCompatActivity() {
    private lateinit var _toggleButtonMen:ToggleButton
    private lateinit var _toggleButtonWomen: ToggleButton
    private  lateinit var _toggleButtonCoed: ToggleButton
    var player = Player("","")

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putParcelable(EXTRA_PLAYER,player)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
        _toggleButtonMen = findViewById<ToggleButton>(R.id.toggleButtonMens)
        _toggleButtonWomen = findViewById<ToggleButton>(R.id.toggleButtonWomem)
        _toggleButtonCoed = findViewById<ToggleButton>(R.id.toggleButtonCoEd)
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        if(savedInstanceState != null)
        {
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)!!
        }
    }
    fun mensButtonOnClick(view: View)
    {
        player.league = "men"
      _toggleButtonWomen.isChecked = false
      _toggleButtonCoed.isChecked = false
    }
    fun womenButtonOnClick (view: View)
    {
        player.league = "women"
        _toggleButtonMen.isChecked = false
        _toggleButtonCoed.isChecked = false
    }
    fun coedButtonOnClick (view: View)
    {
        player.league = "co-ed"
        _toggleButtonMen.isChecked = false
        _toggleButtonWomen.isChecked = false
    }
    fun leagueNextOnClick(view: View){
        if(player.league != "") {
            val skillIntent = Intent(this, SkillActivity::class.java)
            skillIntent.putExtra(EXTRA_PLAYER,player)
            startActivity(skillIntent)
        }else{
            Toast.makeText(this,"Please select a league.",Toast.LENGTH_SHORT).show()
        }
    }
}