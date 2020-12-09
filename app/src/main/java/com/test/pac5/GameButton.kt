package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.game_button.*
import kotlinx.android.synthetic.main.game_text.*
import java.util.*

class GameButton : Basics() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_button)
        Pick--
        DB()
        MusicStart(meduanumber)
        State_Chick()
        EndingStateButton()
        GameText()
        PhoneClick()
        Game_button()
        MyImage()
        Setting()
    }

    private fun EndingStateButton()
    {
        EndingState()
        if(ending_chick == false)
        {
            startActivity(Intent(this@GameButton, Ending ::class.java))
        }
    }

    public fun PhoneClick()
    {
        game_button_phon.setOnClickListener()
        {
            if (state[2] == 0) {
                val bulider = AlertDialog.Builder(this, R.style.Theme_AppCompat_Dialog)

                bulider.setMessage("배터리가 없어 안켜지는 것 같다.")
                bulider.setPositiveButton("확인", null)
                val dialog = bulider.create()
                dialog.show()
            }
            else
            {
                ++Pick
                start = false
                inphonTF = true
                MusicStart(1)
                //  텍스트 인지 안닌지 확인 할 것을 가지고 들어가기
                startActivity(Intent(this@GameButton, InPhon::class.java))
            }
        }
    }

    private fun MyImage()
    {
        if(state[0]>0)
        {
            game_button_me.setImageResource(R.drawable.me_hert4)
            if(state[0] > 20)
            {
                game_button_me.setImageResource(R.drawable.me_hert3)
                if(state[0] > 40)
                {
                    game_button_me.setImageResource(R.drawable.me_hert2)
                    if(state[0] > 60)
                    {
                        game_button_me.setImageResource(R.drawable.me_hert1)
                        if(state[0] > 80)
                        {
                            game_button_me.setImageResource(R.drawable.me_normal)
                        }
                    }
                }
            }
        }
    }

    private fun Setting()
    {
        start = false
        MusicStart(1)
        game_button_setting.setOnClickListener()
        {
            ++Pick
            startActivity(Intent(this@GameButton, Setting::class.java))
        }
    }

    private fun GameText()
    {
        game_button_btn1.text = txt[0]
        game_button_btn2.text = txt[1]
        game_button_btn3.text = txt[2]
        game_button_text.text = txt[3]// +"\n Page : " + Page + "\nPick : " + Pick
    }

    public fun StateRandomDie()
    {
        val random = Random().nextInt(100)+1
        val num = random
        if(num<=5)
        {
            State_Chick()
            if(state[0] < 40)
            {
                for (asdf in 0..ending_num) {
                    if (endingg_group[asdf] == 2) {
                        endingg_get[1] = true
                        ending_chick = false
                        ending = 2
                        break
                    }
                }
                if (ending_chick) {
                    ending_chick = false
                    ending = 2
                    endingg_group[ending_num++] = 2
                }
            }
            startActivity(Intent(this@GameButton, Ending ::class.java))
        }
    }

    private fun NextPage()
    {
        when(nepg)
        {
            0 -> startActivity(Intent(this@GameButton, GameButton::class.java))
            1 -> startActivity(Intent(this@GameButton, Game_Text::class.java))
            2 -> startActivity(Intent(this@GameButton, ItemFood ::class.java))
            3 -> startActivity(Intent(this@GameButton, Item ::class.java))
            4 -> startActivity(Intent(this@GameButton, Ending ::class.java))
            5 -> startActivity(Intent(this@GameButton, Game_Story_Ending ::class.java))
        }
    }


    private fun Game_button()
    {
        for(i in 0..btn_TF)
        {
            click[i] = true
        }
        if(click[0])
        {
            game_button_btn1.setOnClickListener()
            {
                ++btn[0]
                if(Page == 6)
                {
                    when(Pick)
                    {
                        0 -> {PAC(1);}
                    }
                }
                else if(Page == 8)
                {
                    if(Pick == 1)
                    {
                        AddState(0, 1)
                    }
                }
                else if(Page == 9)
                {
                    if(Pick == 1)   //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                {
                    nepg == 2
                }
                    else if(Pick == 2)
                    {
                        MulState(0, 1)
                    }
                }
                else if(Page == 12)
                {

                    if(Pick == 1)
                    {
                       nepg == 2
                    }
                }
                else if(Page == 14)
                {
                    if(Pick == 1)
                    {
                        AddState(0, 1)
                    }
                }
                NextPage()
            }
        }
        if(click[1]) {
            game_button_btn2.setOnClickListener()
            {
                ++btn[1]
                if(Page == 8)
                {
                    if(Pick == 1)
                    {
                        AddState(1, 1)
                    }
                }
                if(Page == 9)
                {
                    if(Pick == 1)
                    {
                        nepg = 1
                    }
                    else if(Pick == 2)
                    {
                        Hungry()
                    }
                }
                if(Page == 12)
                {
                    if(Pick == 2)
                    {
                        get_E = 1
                        nepg = 5
                    }
                    else if(Pick == 1)
                    {
                        Hungry()
                    }
                }
                else if(Page == 14)
                {
                    if(Pick == 1)
                    {
                        Hungry()
                    }
                }
                else if(Page == 22)
                {
                    if(Pick == 1)
                    {
                        nepg = 5
                        get_E = 2
                    }
                }
                NextPage()
            }
        }
        if(click[2]) {
            game_button_btn3.setOnClickListener()
            {
                ++btn[2]
                NextPage()
                MulState(0, 1)
            }
        }
    }
    override fun onBackPressed() {
        ++Pick
        MusicOut()
        startActivity(Intent(this@GameButton, MainLobby ::class.java))
    }
}