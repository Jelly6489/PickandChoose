package com.example.myapplication

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.setting.*

class Setting : Basics() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setting)
        setting_text.text = (gvolume*100).toString()
        MusicStart(meduanumber)
        Setting_SeekBar()
        Setting_Sound_Test()
    }

    private fun Setting_SeekBar()
    {
        setting_SeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                gvolume = (p1*0.01).toDouble()
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    setting_SeekBar.setProgress(p1, p2)
                }
                setting_text.text = (gvolume*100).toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })
        setting_SeekBar.setProgress((gvolume*100).toInt())
    }

    private fun Setting_Sound_Test()
    {
        val soundEngine = SoundEngine()
        val sound1 = soundEngine.load(this, R.raw.ring_test_sound, 1)
        setting_btn.setOnClickListener()
        {
            soundEngine.play(sound1, gvolume.toFloat(), gvolume.toFloat(),1, 0, 1f)
        }
    }

    private fun NextPage()
    {
        when(nepg)
        {
            0 -> startActivity(Intent(this@Setting, GameButton::class.java))
            1 -> startActivity(Intent(this@Setting, Game_Text::class.java))
            2 -> startActivity(Intent(this@Setting, ItemFood ::class.java))
            3 -> startActivity(Intent(this@Setting, Item ::class.java))
        }
    }

    override fun onBackPressed() {
        if(inphonTF)
        {
            startActivity(Intent(this@Setting, InPhon ::class.java))
        }
        else
        {
            start = true
            MusicVolum()
            NextPage()
        }
    }

}