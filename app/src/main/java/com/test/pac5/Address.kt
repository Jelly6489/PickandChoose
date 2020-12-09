package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.address.*


class Address : Basics() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.address)
        MyImage()
        State()
        AddressText()
    }

    private fun State()
    {
        callbook_progressbar1.progress = state[0]
        callbook_progressbar2.progress = state[2]
    }

    private fun MyImage()
    {
        if(state[0] > 0)
        {
            callbook_myimg.setImageResource(R.drawable.me_hert4)
            if(state[0] > 20)
            {
                callbook_myimg.setImageResource(R.drawable.me_hert3)
                if(state[0] > 40)
                {
                    callbook_myimg.setImageResource(R.drawable.me_hert2)
                    if(state[0] > 60)
                    {
                        callbook_myimg.setImageResource(R.drawable.me_hert1)
                        if(state[0] > 80)
                        {
                            callbook_myimg.setImageResource(R.drawable.me_normal)
                        }
                    }
                }
            }
        }
    }

    private fun AddressText()
    {
        address_text1.text = friend_Ex[0]
        address_text2.text = friend_Ex[1]
        address_text3.text = friend_Ex[2]
        address_text4.text = friend_Ex[3]
    }

    override fun onBackPressed()
    {
        startActivity(Intent(this@Address, InPhon::class.java))
    }
}