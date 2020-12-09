package com.example.myapplication

import android.content.Intent
import android.media.browse.MediaBrowser
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.game_story_ending.*
import kotlinx.android.synthetic.main.game_text.*
import kotlinx.android.synthetic.main.game_text.game_text_me
import java.util.*

class Game_Story_Ending : Basics() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_story_ending)
        --Pick
        Story()
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
            startActivity(Intent(this@Game_Story_Ending, Ending ::class.java))
        }
    }

    public fun PhoneClick()
    {
        game_story_phon.setOnClickListener()
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
                startActivity(Intent(this@Game_Story_Ending, InPhon::class.java))
            }
        }
    }

    private fun Setting()
    {

        game_story_setting.setOnClickListener()
        {
            Pick++
            start = false
            startActivity(Intent(this@Game_Story_Ending, Setting::class.java))
        }
    }

    private fun MyImage()
    {
        if(state[0]>0)
        {
            game_story_me.setImageResource(R.drawable.me_hert4)
            if(state[0] > 20)
            {
                game_story_me.setImageResource(R.drawable.me_hert3)
                if(state[0] > 40)
                {
                    game_story_me.setImageResource(R.drawable.me_hert2)
                    if(state[0] > 60)
                    {
                        game_story_me.setImageResource(R.drawable.me_hert1)
                        if(state[0] > 80)
                        {
                            game_story_me.setImageResource(R.drawable.me_normal)
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
            if(num<=5)
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
            startActivity(Intent(this@Game_Story_Ending, Ending ::class.java))
        }
    }

    private fun NextPage()
    {
        when(nepg)
        {
            0 -> startActivity(Intent(this@Game_Story_Ending, GameButton::class.java))
            1 -> startActivity(Intent(this@Game_Story_Ending, Game_Story_Ending::class.java))
            2 -> startActivity(Intent(this@Game_Story_Ending, ItemFood ::class.java))
            3 -> startActivity(Intent(this@Game_Story_Ending, Item ::class.java))
            4 -> startActivity(Intent(this@Game_Story_Ending, Ending ::class.java))
        }
    }


    private fun GameTextButton()
    {
        game_story_text.setOnClickListener {
            if(Page == 12)
            {
                when(Pick)
                {
                    1 -> PAC(6)
                }
            }
            else if(Page == 13)
            {
                when(Pick)
                {
                    2 -> {
                        val random = Random().nextInt(10)
                        val num = random
                        if(num < 4)
                        { EndingStart(5); nepg = 4 }
                    }
                    0 ->{EndingStart(6); nepg = 4}

                }
            }
            else if(Page == 23)
            {
                when(Pick)
                {
                    0 ->PAC(4)
                }
            }
            else if(Page == 24)
            {
                when(Pick)
                {
                    0 -> {EndingStart(8); nepg = 4}
                }
            }
            /*
            if(Page ==)
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
        game_text_text.text = txt[0] + "\n Page : " + Page + "\n Pick : "+Pick
    }

    private fun ButtonClier()
    {
        for(i in 0..2)
        {
            btn[i] = 0
        }
    }

    private fun Story()
    {
        if(get_E == 1)
        {
            if(Page == 12)
            {
                when(Pick)
                {
                    1 -> txt[0] = "로프를 미리 챙겨두고 \n" +
                            "내일 아침을 위해 오늘은\n" +
                            "일찍 잠을 자기로 하였다."
                }
            }
            else if(Page == 13)
            {
                time = "9 : 00"
                when(Pick)
                {
                    5 -> txt[0] = "날이 밝아왔다. 창문 밖을 보니\n" +
                            "어제와 같은 안개가 많아 보인다."
                    4 -> txt[0] = "대충 정신을 차리고 옥상으로 향하였다.\n" +
                            "친구들이 와있었는지 문이 열려있었다.\n" +
                            "현구는 위험하다고 오지 않았다."
                    3 -> txt[0] = "민재는 옥상 물탱크에 로프를 묶어 두었다.\n" +
                            "튼튼한지 수차례 확인하였고 또 확인하였다.\n" +
                            "내가 먼저 로프를 타고 \n" +
                            "내려가기로 하였다."
                    2 -> txt[0] = "로프를 잡고 내려가는데\n" +
                            "조금 무서웠다. 몸에 잘 묶고\n" +
                            "침착하게 땅을 밟을 수 있었다.\n" +
                            "아까 보이던 안개가 느껴지는 것 같았다.\n" +
                            "일단 나는 오케이 싸인을 보냈고\n" +
                            "뒤따라서 완이가 내려오기 시작했다."
                    1 -> txt[0] = "완이가 다 내려오기 직전에\n" +
                            "로프에서 손을 놔버렸다.\n" +
                            "높이가 낮았으나 바닥에 떨어졌고\n" +
                            "두통과 호흡곤란이 있는 것 같다.\n" +
                            "나 역시 갑자기 두통이 오고\n" +
                            "몸에 힘이 빠진다."
                    0 -> txt[0] = "저위에서 민재가 뭐라 하는데\n" +
                            "뭐라 하는지 모르겠다.\n" +
                            "숨쉬기 역시 힘들고 눈이 감긴다."
                }
            }
        }
        else if(get_E == 2)
        {
            if(Page == 23)
            {
                when (Pick)
                {
                    0 -> txt[0] = "모두가 현구에게 시선이 집중되었다.\n" +
                            "현구는 나를 죽일 듯이 째려보았다.\n" +
                            "순간 김완이 현구의 멱살을 잡으며 소리쳤다.\n" +
                            "분위기가 싸해졌다."
                }
            }
            else if(Page == 24)
            {
                when(Pick)
                {
                    3 -> txt[0] = "김완은 현구에게 입에 담지\n" +
                            "못할 욕을 하며 화를 내다가\n" +
                            "방으로 올라가 버렸다."
                    2 -> txt[0] = "현구에게 내일 이 시간에 해명하라고\n" +
                            "말해두고 나와 민재 역시 \n" +
                            "방으로 돌아왔다."
                    1 -> txt[0] = "순간 많은 생각이 들었다.\n" +
                            "생각을 정리하지 않고 말한 것이\n" +
                            "후회되었다. \n" +
                            "그러나 내일 빨리 사실에 대해 \n" +
                            "듣기 위해 잠자리에 들었다."
                    0 -> txt[0] = "많은 생각 때문인지 \n" +
                            "잠에 깊게 들지 못하고 살짝 깬 것 같다.\n" +
                            "눈앞에 뭔가 있는듯한 느낌이 난다.\n" +
                            "갑자기 뭔가에 조여짐과 동시에\n" +
                            "숨쉬기가 힘들어진다.\n" +
                            "목을 조르는 것 같았다.\n" +
                            "발버둥을 쳤지만 살려달라 말하려 했지만\n" +
                            "이내 눈앞이 어두워졌다."
                }
            }
        }
        //0 -> txt[0] = ""

    }
    override fun onBackPressed() {
        ++Pick
        MusicOut()
        startActivity(Intent(this@Game_Story_Ending, MainLobby ::class.java))
    }
}