package com.example.myapplication

import android.content.Intent
import android.media.browse.MediaBrowser
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.game_text.*
import java.util.*

class Game_Text : Basics() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_text)
        --Pick
        DB()
        ButtonClier()
        MusicStart(meduanumber)
        State_Chick()
        EndingStateText()
        GameText()
        GameTextButton()
        PhoneClick()
        MyImage()
        Setting()
    }

    private fun EndingStateText()
    {
        EndingState()
        if(ending_chick == false)
        {
            startActivity(Intent(this@Game_Text, Ending ::class.java))
        }
    }

    public fun PhoneClick()
    {
        game_text_phon.setOnClickListener()
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
                inphonTF = true
                Pick++
                start = false
                startActivity(Intent(this@Game_Text, InPhon::class.java))
            }
        }
    }

    private fun Setting()
    {

        game_text_setting.setOnClickListener()
        {
            Pick++
            start = false
            startActivity(Intent(this@Game_Text, Setting::class.java))
        }
    }

    private fun MyImage()
    {
        if(state[0]>0)
        {
            game_text_me.setImageResource(R.drawable.me_hert4)
            if(state[0] > 20)
            {
                game_text_me.setImageResource(R.drawable.me_hert3)
                if(state[0] > 40)
                {
                    game_text_me.setImageResource(R.drawable.me_hert2)
                    if(state[0] > 60)
                    {
                        game_text_me.setImageResource(R.drawable.me_hert1)
                        if(state[0] > 80)
                        {
                            game_text_me.setImageResource(R.drawable.me_normal)
                        }
                    }
                }
            }
        }
    }

    public fun StateRandomDie()
    {
        val random = Random().nextInt(100)+1
        val num = random
        if(state[0] < 40)
        {
            State_Chick()
            if(num <= 5)
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
            startActivity(Intent(this@Game_Text, Ending ::class.java))
        }
    }

    private fun NextPage()
    {
        when(nepg)
        {
            0 -> startActivity(Intent(this@Game_Text, GameButton::class.java))
            1 -> startActivity(Intent(this@Game_Text, Game_Text::class.java))
            2 -> startActivity(Intent(this@Game_Text, ItemFood ::class.java))
            3 -> startActivity(Intent(this@Game_Text, Item ::class.java))
            4 -> startActivity(Intent(this@Game_Text, Ending ::class.java))
            5 -> startActivity(Intent(this@Game_Text, Game_Story_Ending ::class.java))
        }
    }


    private fun GameTextButton()
    {
        val soundEngine = SoundEngine()
        val sound1 = soundEngine.load(this, R.raw.door, 1)      //  문 쾅쾅
        val sound2 = soundEngine.load(this, R.raw.dooropen, 1)  //  문 여는거
        val sound3 = soundEngine.load(this, R.raw.doorknock, 1)  //  문 똑똑
        val sound4 = soundEngine.load(this, R.raw.keydrop, 1)  //  키 떨굼
        val sound5 = soundEngine.load(this, R.raw.tepe_cut, 1)  //  테이프 뜯기
        val sound6 = soundEngine.load(this, R.raw.chigizi, 1)  //  문전기 치지직
        game_text_text.setOnClickListener{

            if(Page == 0)
            {
                when(Pick)
                {
                    0 ->{soundEngine.play(sound1, gvolume.toFloat(), gvolume.toFloat(),1, 0, 1f);PAC(3)}
                }
            }
            else if(Page == 1)
            {
                when(Pick)
                {
                    0 -> {soundEngine.play(sound1, gvolume.toFloat(), gvolume.toFloat(),1, 0, 1f); PAC(3)}
                }
            }
            else if(Page == 2)
            {
                when(Pick)
                {
                    0 -> {PAC(3)}
                }
            }
            else if(Page == 3)
            {
                when(Pick)
                {
                    1 -> friend_Ex[1] += "침착함"
                    0 -> {PAC(5); MulBattery(1)}
                }
            }
            else if(Page == 4)
            {
                when(Pick)
                {
                    3 -> {
                        AddItem(2, 2)
                        AddItem(1, 2)
                        AddItem(6, 1)
                    }
                    0 -> {MulBattery(1); PAC(2)}
                }
            }
            else if(Page == 5)
            {
                when(Pick)
                {
                    0 -> PAC(2)
                }
            }
            else if(Page == 7)
            {
                when(Pick)
                {
                    0 -> {state[0] -= 10; state[0] -= 10; MulBattery(2); StateRandomDie(); PAC(3)}
                }
            }
            else if(Page == 8)
            {
                when(Pick)
                {
                    0 -> PAC(4)
                }
            }
            else if(Page == 9)
            {
                when(Pick)
                {
                    0 -> {MulBattery(1); PAC(4)}
                }
            }
            else if(Page == 10)
            {
                when(Pick)
                {
                    0 -> PAC(7)
                }
            }
            else if(Page == 11)
            {
                when(Pick)
                {
                    5 -> {
                        val random = Random().nextInt(10)
                    val num = random
                    if(num < 2)
                    {
                        EndingStart(1)
                        nepg = 4
                    }}
                    3 -> soundEngine.play(sound2, gvolume.toFloat(), gvolume.toFloat(),1, 0, 1f)
                    0 -> {MulBattery(1);PAC(4)}
                }
            }
            else if(Page == 12)
            {
                when(Pick)
                {
                    0 -> {state[0] -= 10; state[1] -= 10; StateRandomDie(); MulBattery(1); PAC(1)}
                }
            }
            else if(Page == 13)
            {
                when(Pick)
                {
                    0 -> {MulBattery(1); state[0] -= 15; state[1] -= 10; PAC(2)}
                }
            }
            else if(Page == 14)
            {
                when(Pick)
                {
                    0 -> PAC(3)
                }
            }
            else if(Page == 15)
            {
                when(Pick)
                {
                    0 -> PAC(5)
                }
            }
            else if(Page == 16)
            {
                when(Pick)
                {
                    2 -> AddItem(3, 1)
                    0 -> PAC(3)
                }
            }
            else if(Page == 17)
            {
                when(Pick)
                {
                    1 -> {friend_Ex[3] += "자존심이 강하고 계산적\n"
                        soundEngine.play(sound2, gvolume.toFloat(), gvolume.toFloat(),1, 0, 1f)}
                    0 -> PAC(1)
                }
            }
            else if(Page == 18)
            {
                when(Pick)
                {
                    0 -> {PAC(3); MulBattery(2)}
                }
            }
            else if(Page == 19)
            {
                when(Pick)
                {
                    2 -> soundEngine.play(sound6, gvolume.toFloat(), gvolume.toFloat(),1, 0, 1f)
                    1 -> soundEngine.play(sound4, gvolume.toFloat(), gvolume.toFloat(),1, 0, 1f)
                    0 -> {state[0] -= 5; StateRandomDie(); MulBattery(1); PAC(1)}
                }
            }
            else if(Page == 20)
            {
                when(Pick)
                {
                    0 -> {PAC(2); AddItem(5, 1)}
                }
            }
            else if(Page == 21)
            {
                when(Pick)
                {
                    0 ->{
                        state[0] -= 20; state[1] -=10; MulBattery(2); PAC(5)
                        soundEngine.play(sound3, gvolume.toFloat(), gvolume.toFloat(),1, 0, 1f)
                    }
                }
            }
            else if(Page == 22)
            {
                when(Pick)
                {
                    0 -> PAC(2)
                }
            }
            else if(Page == 23)
            {
                when(Pick)
                {
                    1 ->{
                        val random = Random().nextInt(100)
                        val num = random
                        if(num < 15)
                        {
                            EndingStart(1)
                            nepg = 4
                        }
                    }
                    0 -> {soundEngine.play(sound2, gvolume.toFloat(), gvolume.toFloat(),1, 0, 1f)
                        PAC(4)}
                }
            }
            else if(Page == 24)
            {
                when(Pick)
                {
                    0 -> PAC(4)
                }
            }
            else if(Page == 25)
            {
                when(Pick)
                {
                    0 -> PAC(4)
                }
            }
            else if(Page == 26)
            {
                when(Pick)
                {
                    4 -> soundEngine.play(sound5, gvolume.toFloat(), gvolume.toFloat(),1, 0, 1f)
                    0 -> {
                        PAC(1)
                        EndingStart(7)
                    nepg = 4}
                }
            }
            /*
            if(Page == )
            {
                when(Pick)
                {
                    0 ->
                }
            }
             */
            NextPage()
        }
    }

    private fun GameText()
    {
        game_text_text.text = txt[0]// + "\n Page : " + Page + "\n Pick : "+Pick
    }

    private fun ButtonClier()
    {
        for(i in 0..2)
        {
            btn[i] = 0
        }
    }
    override fun onBackPressed() {
        ++Pick
        MusicOut()
        startActivity(Intent(this@Game_Text, MainLobby ::class.java))
    }
}