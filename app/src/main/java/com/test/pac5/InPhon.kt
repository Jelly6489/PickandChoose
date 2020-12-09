package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.in_phon.*

class InPhon : Basics() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.in_phon)
        InPhon_Time.text = time
        MusicStart(meduanumber)
        Battery()
        InSetting()
        PhonButton()
    }

    private fun PhonButton()
    {
        InPhon_Address.setOnClickListener()
        {
            startActivity(Intent(this@InPhon, Address ::class.java))
        }
        InPhon_Gallery.setOnClickListener()
        {
            startActivity(Intent(this@InPhon, Gallery ::class.java))
        }
        InPhon_Instart.setOnClickListener()
        {
            startActivity(Intent(this@InPhon, Instart ::class.java))
        }
        InPhon_Internet.setOnClickListener()
        {
            startActivity(Intent(this@InPhon, Internet ::class.java))
        }
        InPhon_Item.setOnClickListener()
        {
            startActivity(Intent(this@InPhon, Item ::class.java))
        }
    }

    private fun Battery()
    {
        if(state[2]>=0)
        {
            InPhon_img_battery.setImageResource(R.drawable.battery1)
            if(state[2]>=25)
            {
                InPhon_img_battery.setImageResource(R.drawable.battery2)
                if(state[2]>=50)
                {
                    InPhon_img_battery.setImageResource(R.drawable.battery3)
                    if(state[2]>=75)
                    {
                        InPhon_img_battery.setImageResource(R.drawable.battery4)
                    }
                }
            }
        }
    }

    private fun NextPage()
    {
        when(gamepage)
        {
            0 -> startActivity(Intent(this@InPhon, GameButton::class.java))
            1 -> startActivity(Intent(this@InPhon, Game_Text::class.java))
            2 -> startActivity(Intent(this@InPhon, ItemFood ::class.java))
            3 -> startActivity(Intent(this@InPhon, Item ::class.java))
        }
    }


    override fun onBackPressed()
    {
        inphonTF = false
        start = true
        NextPage()
    }

    private fun InSetting()
    {
        InPhon_Setting.setOnClickListener()
        {
            startActivity(Intent(this@InPhon, Setting ::class.java))
        }
    }

}