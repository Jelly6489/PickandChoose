package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.gallery.*

class Gallery : Basics() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gallery)

        ChangeImg()
        EndingButton()

        if(end == 8)
        {
            imageButton1.setImageResource(R.drawable.pandc)
        }

    }

    private fun ChangeImg()
    {
        for(i in 0..ending_num)
        {
            if(endingg_group[i] == 1)
            {
                endingg_get[0] = true
                imageButton1.setImageResource(R.drawable.ending1)
            }
            if(endingg_group[i] == 2)
            {
                endingg_get[1] = true
                imageButton2.setImageResource(R.drawable.ending2)
            }
            if(endingg_group[i] == 3)
            {
                endingg_get[2] = true
                imageButton3.setImageResource(R.drawable.ending3)
            }
            if(endingg_group[i] == 4)
            {
                endingg_get[3] = true
                imageButton4.setImageResource(R.drawable.ending4)
            }
            if(endingg_group[i] == 5)
            {
                endingg_get[4] = true
                imageButton6.setImageResource(R.drawable.ending5)
            }
            if(endingg_group[i] == 6)
            {
                endingg_get[5] = true
                imageButton7.setImageResource(R.drawable.ending6)
            }
            if(endingg_group[i] == 7)
            {
                endingg_get[6] = true
                imageButton8.setImageResource(R.drawable.ending7)
            }
            if(endingg_group[i] == 8)
            {
                endingg_get[7] = true
                imageButton9.setImageResource(R.drawable.ending8)
            }
        }
    }

    private fun EndingButton() {
        if(endingg_get[0]) {
            imageButton1.setOnClickListener()
            {
                ending = 1
                ending_chick = true
                startActivity(Intent(this@Gallery, Ending::class.java))
            }
        }

        if(endingg_get[1]) {
            imageButton2.setOnClickListener()
            {
                ending = 2
                ending_chick = true
                startActivity(Intent(this@Gallery, Ending::class.java))
            }
        }
        if(endingg_get[2]) {
            imageButton3.setOnClickListener()
            {
                ending = 3
                ending_chick = true
                startActivity(Intent(this@Gallery, Ending::class.java))
            }
        }
        if(endingg_get[3]) {
            imageButton4.setOnClickListener()
            {
                ending = 4
                ending_chick = true
                startActivity(Intent(this@Gallery, Ending::class.java))
            }
        }
        if(endingg_get[4]) {
            imageButton6.setOnClickListener()
            {
                ending = 5
                ending_chick = true
                startActivity(Intent(this@Gallery, Ending::class.java))
            }
        }
        if(endingg_get[5]) {
            imageButton7.setOnClickListener()
            {
                ending = 6
                ending_chick = true
                startActivity(Intent(this@Gallery, Ending::class.java))
            }
        }
        if(endingg_get[6]) {
            imageButton8.setOnClickListener()
            {
                ending = 7
                ending_chick = true
                startActivity(Intent(this@Gallery, Ending::class.java))
            }
        }
        if(endingg_get[7]) {
            imageButton9.setOnClickListener()
            {
                ending = 8
                ending_chick = true
                startActivity(Intent(this@Gallery, Ending::class.java))
            }
        }


    }
    override fun onBackPressed() {
        startActivity(Intent(this@Gallery, InPhon ::class.java))
    }
}