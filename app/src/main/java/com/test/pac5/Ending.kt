package com.example.myapplication

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.ending.*

class Ending : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ending)

        Ending_TI()



        Va_Reset()

    }

    private fun Ending_TI()
    {
        if(ending == 1)
        {
            Ending_Text.text = "허무하게 죽다"
            Ending_Img.setImageResource(R.drawable.ending1)
            Ending_Ex.text = "순간 몸의 중심을 잃었고 \n" +
                    "붕 떠서 앞으로 넘어졌다."
        }
        else if(ending == 2)
        {
            Ending_Text.text = "체력이 없어서 사망"
            Ending_Img.setImageResource(R.drawable.ending2)
            Ending_Ex.text = "체력이 없습니다.\n다음부턴 체력좀 보세요."
        }
        else if(ending == 3)
        {
            Ending_Text.text = "몸이 이상하다"
            Ending_Img.setImageResource(R.drawable.ending3)
            Ending_Ex.text = "뭔가에 감염된 것 같이\n" +
                    "몸이 내몸이 아닌 것 같다."
        }
        else if(ending == 4)
        {
            Ending_Text.text = "먹어둘껄"
            Ending_Img.setImageResource(R.drawable.ending4)
            Ending_Ex.text = "긴장해서 배가 고픈지 몰랐다. 또한 아껴야 했다.\n" +
                    "힘이들고 눈앞이 어둡다.."
        }
        else if(ending == 5)
        {
            Ending_Text.text = "믿었던 로프가 끊어지다"
            Ending_Img.setImageResource(R.drawable.ending5)
            Ending_Ex.text = "순간 줄이 느슨해지더니 끊어 져버렸다.\n" +
                    "말할 틈도 없이 땅으로 떨어져 버렸다"
        }
        else if(ending == 6)
        {
            Ending_Text.text = "옥상탈출 그러나 죽음?"
            Ending_Img.setImageResource(R.drawable.ending6)
            Ending_Ex.text = "힘들게 탈출을 시도했으나 ..\n" +
                    "왜 죽었는지 모르고 의문사하였다"
        }
        else if(ending == 7)
        {
            Ending_Text.text = "정문탈출 그러나 죽음?"
            Ending_Img.setImageResource(R.drawable.ending7)
            Ending_Ex.text = "편했던 기숙사 불편한 기숙사로 바뀐지\n" +
                    "4일 만에 탈출했는데 호흡곤란과 함께 죽어버렸다."
        }
        else if(ending == 8)
        {
            Ending_Text.text = "알 것 같다"
            Ending_Img.setImageResource(R.drawable.ending8)
            Ending_Ex.text = "서늘함과 동시에 누군가 나를 죽였다..\n" +
                    "숨을 쉴수가 없다.. 몸에 힘이 빠진다. "
        }
    }



    private fun Va_Reset()
    {
        if(ending_chick)
        {}
        else
        {
            state = arrayOf<Int>(85, 85, 65)        //  체력, 위생, 배터리
            friend_Ex = arrayOf<String>("", "", "", "")        //  우호도
            friend = arrayOf<String>("A", "B", "C", "D")        //  만난 사람
            friend_chick = 4        //  만난사람 수
            Page = 0        //  수직 진행도
            Pick = 3
            btn = arrayOf<Int>(0, 0, 0)     //  버튼 누른 수
            click = arrayOf<Boolean>(true, false, false)    //  버튼 활성화
            btn_TF = 0                  //  버튼 활성화 갯수
            txt = arrayOf<String>("", "", "", "")         //  텍스트 저장 변수
            item_set = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)        //  가지고 있는 아이템
            item_num = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)        //  아이템 개수
            item_numbering = 0          //  아이템 얻은 개수
            itemTF = true       //  아이템 체크
            gvolume = 0.50      //  볼륨
            time = "10:00"        //  시간
            reset_game = false
            inphonTF = false
            nepg = 1
            get_E = 0

            m1 = null
            start = true
            meduanumber = 1
        }
    }

    override fun onBackPressed() {
        if(ending_chick)
        {
            ending = 0
            startActivity(Intent(this@Ending, Gallery::class.java))
        }
        else
        {
            ending = 0
            ending_chick = true
            startActivity(Intent(this@Ending, MainLobby::class.java))
        }
    }
}