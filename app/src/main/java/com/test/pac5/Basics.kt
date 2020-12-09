package com.example.myapplication

import android.media.MediaPlayer
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.game_button.*
import kotlinx.android.synthetic.main.game_text.*
import java.util.*

var state = arrayOf<Int>(85, 85, 65)        //  체력, 위생, 배터리
var friend_Ex = arrayOf<String>("", "", "", "")        //  우호도
var friend = arrayOf<String>("김완", "김민재", "이승훈", "강현구")        //  만난 사람
var friend_chick = 4        //  만난사람 수
var Page = 0        //  수직 진행도
var Pick = 3
var btn= arrayOf<Int>(0, 0, 0)     //  버튼 누른 수
var click = arrayOf<Boolean>(true, false, false)    //  버튼 활성화
var btn_TF = 0                  //  버튼 활성화 갯수
var txt = arrayOf<String>("", "", "","")         //  텍스트 저장 변수
var ending_chick = true
var endingg_group = arrayOf<Int>(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)      //   엔딩 수
var endingg_get = arrayOf<Boolean>(false, false, false, false, false, false, false, false, false, false)      //   엔딩 오픈
var ending_num = 0      //  엔딩을 본 횟수
var ending = 0          //  엔딩 종류
var item_set = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)        //  가지고 있는 아이템
var item_num = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)        //  아이템 개수
var item_numbering = 0          //  아이템 얻은 개수
var itemTF = true       //  아이템 체크
var gvolume = 0.50      //  볼륨
var time = "10:00"        //  시간
var reset_game = false
var inphonTF = false
var nepg = 1
var get_E = 0
var gamepage = 1
var end = 0
var m1 : MediaPlayer? = null
var start = true
var meduanumber = 1

open class Basics () : AppCompatActivity() {
    
    public fun AddItem(itemcode: Int, item_count: Int) {
        for (i in 0..item_numbering - 1) {
            if (item_set[i] == itemcode) {
                item_num[i] += item_count
                itemTF = false
                break
            }
        }
        if (itemTF) {
            item_set[item_numbering] = itemcode
            item_num[item_numbering] = item_count
            item_numbering++
        }
        itemTF = true
    }

    public fun MulItme(itemcode: Int, item_count: Int) {
        for (i in 0..item_numbering - 1) {
            if (item_set[i] == itemcode) {
                itemTF = false
                if (item_num[i] > item_count) {
                    item_set[i] -= item_count
                } else if (item_num[i] == item_count) {
                    item_set[i] = 0
                    item_num[i] = 0
                    for (j in i..item_numbering - 1) {
                        item_num[j] = item_num[j + 1]
                        item_set[j] = item_set[j + 1]
                    }
                    --item_numbering
                } else {
                    val bulider = AlertDialog.Builder(this, R.style.Theme_AppCompat_Dialog)
                    bulider.setMessage("아이템이 부족합니다.")
                    bulider.setPositiveButton("예", null)
                    val dialog = bulider.create()
                    dialog.show()
                }
                break
            }
        }
        if (itemTF) {
            val bulider = AlertDialog.Builder(this, R.style.Theme_AppCompat_Dialog)
            bulider.setMessage("아이템이 없습니다.")
            bulider.setPositiveButton("예", null)
            val dialog = bulider.create()
            dialog.show()
        }
        itemTF = true
    }

    //엔딩

    public fun EndingStart(code: Int) {
        for (asdf in 0..ending_num) {
            if (endingg_group[asdf] == code) {
                endingg_get[code - 1] = true
                ending_chick = false
                ending = code
                break
            }
        }
        if (ending_chick) {
            end++
            ending_chick = false
            ending = code
            endingg_group[ending_num++] = code
        }
    }

    public fun EndingState() {
        if (state[0] <= 0) {
            endingg_get[1] = true
            for (asdf in 0..ending_num) {
                if (endingg_group[asdf] == 2) {
                    ending_chick = false
                    ending = 2
                    break
                }
            }
            if (ending_chick) {
                end++
                ending_chick = false
                ending = 2
                endingg_group[ending_num++] = 2
            }
        }
        if (state[1] <= 0) {
            endingg_get[2] = true
            for (asdf in 0..ending_num) {
                if (endingg_group[asdf] == 3) {
                    ending_chick = false
                    ending = 3
                    break
                }
            }
            if (ending_chick) {
                end++
                ending_chick = false
                ending = 3
                endingg_group[ending_num++] = 3
            }
        }
    }

    public fun Hungry() {
        val random = Random().nextInt(10)
        val num = random
        if(num == 5) {
            EndingStart(2)
            nepg = 4
        }
    }

    //  설정
    public fun MusicNumbering() {
        m1 = MediaPlayer.create(this, R.raw.bgm1)
        m1?.isLooping = true
    }

    public fun MusicVolum() {
        m1?.setVolume(gvolume.toFloat(), gvolume.toFloat())
    }

    public fun MusicStart(music: Int) {
        MusicVolum()
        if (gvolume == 0.0) {
            start = false
        }

        if (start) {
            if (music == 1) {
                m1?.start()
            }
        } else {
            if (music == 1) {
                m1?.pause()
            }
        }
    }

    public fun MusicOut() {
        m1?.stop()
        m1?.release()
    }

    //  DB 관련 내용
    public fun PAC(PickNumber: Int) {
        Pick = PickNumber
        ++Page
    }

    public fun AddState(whate: Int, tree: Int) {
        if (tree == 1) {
            val random = Random().nextInt(3) + 5
            val num = random
            state[whate] += num
        }
    }

    public fun MulState(whate: Int, tree: Int) {
        if (tree == 1) {
            val random = Random().nextInt(4) + 7
            val num = random
            state[whate] -= num
        }
    }

    public fun State_Chick()           //  스테이스 초과 방지
    {
        for (i in 0..2) {
            if (state[i] < 0) {
                state[i] = 0
            } else if (state[i] > 100) {
                state[i] = 100
            }
        }
    }

    public fun MulBattery(tree: Int) {
        if (tree == 1) {
            val random = Random().nextInt(3) + 1
            val num = random
            state[2] -= num
        } else if (tree == 2) {
            val random = Random().nextInt(3) + 3
            val num = random
            state[2] -= num
        }
    }

    // 지문 내용

    public fun DB() {
        for (i in 0..3) {
            txt[i] = ""
        }
        if (Page == 0)
        {
            time = "10 : 00"
            when(Pick)
            {
                2 -> txt[0] = "어제 1학기를 마무리 지으면서\n" +
                        "친구들과 술을 마신 것 같은데\n" +
                        "기숙사에 돌아와 바로 뻗은 것 같다.\n" +
                        "기억이 선명하지 않다.\n" +
                        "수많은 부재중 전화가 찍혀있다.\n" +
                        "전화를 걸려 했지만 신호가 가지 않는다.\n" +
                        "정신을 차리기 위해 세수를 하려는데\n" +
                        "화장실 불이 들어오지 않는다.\n" +
                        "갑자기 왜 이런 상황이 벌어지는지\n" +
                        "이해할 수가 없다."
                1 -> txt[0] = "승훈이도 방에 없는 것 같다.\n" +
                        "찾으러 다녀 봐야 할 것 같다.\n" +
                        "나는 승훈이를 찾기 위해 \n" +
                        "1층으로 내려갔다."
                0 -> txt[0] = "1층의 방화문이 잠겨있다.\n" +
                        "평소에는 열어 두는 곳이다.\n" +
                        "혹시나 해서 손잡이를 \n" +
                        "돌려보았지만 잠겨있다."
            }
        }
        else if(Page == 1)
        {
            time == "11 : 00"
            when(Pick)
            {
                2 -> {txt[0] = "어제 같이 술을 마셨던 \n" +
                        "친구 놈들은 알지 않을까 하고 \n" +
                        "친구들 방문 앞에서 문을 크게 두드렸다."
                    start = false}
                1 -> {txt[0] = "방안에 인기척이 느껴지고\n" +
                        "민재가 문을 열어주었다.\n" +
                        "내가 문 두드리는 소리에\n" +
                        "일어난 것 같았고\n" +
                        "현구는 아직 자는 것 같았다. "
                    start = true}
                0 -> txt[0] = "있었던 일들을 민재에게 얘기하였고\n" +
                        "많이 놀란 것 같았다.\n" +
                        "일단 정신 먼저 차리고 \n" +
                        "휴게실에서 보자고 하였다.\n" +
                        "나는 김완이 있는 방으로\n" +
                        "발걸음을 돌렸다."
            }
        }
        else if(Page == 2)
        {
            time = " 12 : 00"
            when(Pick)
            {
                2 -> {txt[0] = "역시 문을 두드리며\n" +
                        "있냐고 물었고 짜증 가득한 말투로\n" +
                        "“나간다 기다려” 라고 하였다.\n" +
                        "김완 역시 내가 문 두드리는 \n" +
                        "소리에 일어난 것 같다."
                start = false}
                1 -> {txt[0] = "김완에게도 있었던 일을 얘기하였지만\n" +
                        "모르고 있었던 것 같다.\n" +
                        "역시 놀란 눈치였다. 건물들의 열쇠는\n" +
                        "김완이 보관하고 있었기 때문이다.\n" +
                        "그때 뒤에서 누군가 오는 소리가 들렸다."
                start = true}
                0 -> txt[0] = "민재와 현구였다.\n" +
                        "민재는 무슨 생각에 잠긴 표정이었다.\n" +
                        "일단은 완이는 휴게실에서 보기로 하고\n" +
                        "민재와 현구랑 함께 휴게실로 향하였다."
            }
        }
        else if(Page == 3)
        {
            time = "14 : 00"
            when(Pick)
            {
                2 -> txt[0] = "1시간 정도 지난 것 같다.\n" +
                        "김완이 휴게실로 들어왔다. \n" +
                        "자기는 ‘ 사감실 열쇠와 ’, ‘ 3층 창고 열쇠’ 2개 만이\n" +
                        "가지고 있는 전부라고 얘기해주었다. \n" +
                        "다른 열쇠는 사라진 것 같았다."
                1 -> txt[0] = "민재는 침착하게 상황을 정리해주었다.\n" +
                        "일단 승훈이를 찾아보고 \n" +
                        "각자 확인해야 할 것을\n" +
                        "확인하고 난 후에 2시간 뒤에\n" +
                        "다시 휴게실에서 모이자고 하였다."
                0 -> txt[0] = "각자 알았다고 한 후\n" +
                        "나는 방으로 돌아왔다.\n" +
                        "집으로 가려고 싸두었던\n" +
                        "짐들을 만지작거리며\n" +
                        "어제 집으로 가지 않고 남아\n" +
                        "술을 마신 것에 대한 후회가 들었다.\n" +
                        "뒤늦은 후회였다."
            }
        }
        else if(Page == 4)
        {
            time = "16 : 00"
            when(Pick)
            {
                4 -> txt[0] = "대략 필요한 것들을 점검하고 나니\n" +
                        "만나기로 한 4시가 되어\n" +
                        "휴게실로 향하였다."
                3 -> txt[0] = "승훈이를 아무도 못 본 것 같다.\n" +
                        "그를 제외하고 휴게실에 다 모여있었다.\n" +
                        "혹시 모르기에 가지고 있는 것들을\n" +
                        "서로 확인하였다."
                2 -> {txt[0] = "집에 가려고 했던 터라 뭔가 없었다.\n" +
                        "나는 ‘에너지바’ 2개와, ‘생수 500ML’ 1통, ‘ 이온음료 1개’가 전부였다."
                nepg = 3}
                1 -> {txt[0] = "건물에 누가 우리를 가둔 건지\n" +
                        "뭐가 어떻게 돌아가는지 알아갈 \n" +
                        "필요가 있는 것 같다.\n" +
                        "서로 아는 것이 생기면 휴게실에\n" +
                        "모여 의논하기로 하였다."
                nepg = 1}
                0 -> txt[0] = "다들 피곤해 보이는 것 같았다.\n" +
                        "현구가 뭔가 생각에 잠기는 \n" +
                        "듯한 표정을 보였지만\n" +
                        "나만 본 것 같았다."
            }
        }
        else if(Page == 5)
        {
            time = "17 : 00"
            when(Pick)
            {
                1 -> txt[0] = "민재가 다들 피곤한 것 같으니\n" +
                        "오늘은 이만 쉬자고 하였다. \n" +
                        "다들 피곤했는지 동의하였고\n" +
                        "생각을 정리하고 내일 다시 \n" +
                        "휴게실에서 보기로 하였다."
                0 -> txt[0] = "방으로 돌아왔지만\n" +
                        "승훈이는 역시 오지 않았다.\n" +
                        "평소에도 어디 갈 때\n" +
                        "늘 말해주고 가던 녀석이다.\n" +
                        "말도 없이 사라지니 \n" +
                        "당황스러울 뿐이다."
            }
        }
        else if(Page == 6)
        {
            time = "19 : 00"
            when(Pick)
            {
                1 -> {txt[0] = "긴장이 조금 풀려서인지\n" +
                        "배가 고파져 왔다. \n" +
                        "그러고 보니 오늘 아무것도 먹지 못했다. "
                nepg = 0}
                0 -> {txt[0] = "뭐라도 먹어야 할 것 같다."
                    nepg = 2}
            }
        }
        else if(Page == 7)
        {
            time = "22 : 00"
            when(Pick)
            {
                0 -> {txt[0] = "침대에 누워 생각에 잠겼다.\n" +
                        "무슨 일이 벌어지는 건지 알 수 없었다.\n" +
                        "내일이면 해결될 것 같다.\n" +
                        "단순한 장난이면 좋겠다.\n" +
                        "전기가 들어오지 않아 어두워서 그런지\n" +
                        "잠 말곤 가능한 것이 없었다. "
                nepg = 1}
            }
        }
        else if(Page == 8)
        {
            time = "11 : 00"
            when(Pick)
            {
                2 -> {txt[0] = "창문에서 비추는 햇살이 \n" +
                        "눈에서 일렁일 때 \n" +
                        "눈이 떠졌다. 하루가 지났다. "
               nepg = 0}
                1 -> {txt[0] = "피곤이 몸이 짓누르는 것 같아 \n" +
                        "5분만 더 누워 있자. "
                    txt[1] = "정신을 차리기 위해 불이 \n" +
                            "들어오지 않는 화장실로 향하였다. "
                nepg = 1
                btn_TF = 2}

                0 -> {
                    if (btn[0] == 1 && btn[1] == 0 && btn[2] == 0) {
                        txt[0] = "전기도 끊겼는데 얼마 지나지 않아\n" +
                                "물도 끊어질 수도 있겠다는 생각이 들었다.\n" +
                                "이따 친구들을 만나서 의논\n" +
                                "해봐야 할 것 같았다."
                    }
                    else if (btn[0] == 0 && btn[1] == 1 && btn[2] == 0)
                    {
                        txt[0] = "전기도 끊겼는데 얼마 지나지 않아\n" +
                                "물도 끊어질 수도 있겠다는 생각이 들었다.\n" +
                                "이따 친구들을 만나서 의논\n" +
                                "해봐야 할 것 같았다."
                    }
                }
            }
        }
        else if(Page == 9)
        {
            time = "12 : 00"
            when(Pick)
            {
                3 -> {txt[0] = "아침에 일어나니\n" +
                        "어제 먹은 것이 얼마 없던 탓인지\n" +
                        "배가 고픈 것 같았다. \n" +
                        "먹을게 얼마 없는 건 알지만\n" +
                        "뭐라도 먹어야 하지 않을까 싶다. "
                nepg = 0}
                2 -> {txt[0] = "조금이라도 먹는 것이 좋겠어."
                txt[1] = "생각해보니 좀 아껴둬야 할 것 같다."
                        txt[3] = "뭐라도 먹어야 하지 않을까 싶다."
                    btn_TF = 1}
                1 -> {if(btn[0] == 1 && btn[1] == 0 && btn[2] == 0)
                    txt[0] = "뭐라도 먹으니 조금 나은 것 같다.\n" +
                            "남은 식량이 없으나 이 상황이\n" +
                            "빨리 해결되기를 바랄 뿐이다."
                    if(btn[0] == 0 && btn[1] == 1 && btn[2] == 0)
                        txt[0] = "배는 고프겠지만 \n" +
                                "상황이 더 나빠질 수도 있으니\n" +
                                "절제해야 하지 않을까 싶다. "
                    nepg = 1
                }
            }
        }
        else if(Page == 10)
        {
            time = "14 : 00"
            when(Pick)
            {
                3 -> txt[0] = "핸드폰으로 시간을 확인해보니 14시가 다 되어간다.\n" +
                        "아직도 먹통이고 전기가 들어오지 않아 충전도 할 수 없다.\n" +
                        "시계와 손전등의 용도로만 사용될 뿐이다.\n" +
                        "배터리도 점점 달아간다. "
                2 -> txt[0] = "어제 만나기로 한 시간이 다 되어서\n" +
                        "휴게실로 향하였다."
                1 -> txt[0] = "완이랑 민재가 언쟁을 높이며 싸우고 있었다.\n" +
                        "완이 말로는 어제 3층 창고를 열었을 땐\n" +
                        "옥상 열쇠가 있다는 것을 확인했었는데\n" +
                        "오늘 다시 보니 없어졌다는 것이었다.\n" +
                        "민재는 각자 방으로 돌아간 뒤에\n" +
                        "다시 방 밖으로 나온 적이 없다고 하였다."
                0 -> txt[0] = "일단은 내가 말렸다.\n" +
                        "현구에게 이 얘기에 대해 \n" +
                        "아는 것이 있냐고 물었고\n" +
                        "본인 역시 쓸만한 것을 찾고 다녔기에\n" +
                        "모른다고 하였다. \n" +
                        "민재 또한 증명해주었다."
            }
        }
        else if(Page == 11)
        {
            time = "17 : 00"
            when(Pick)
            {
                6 -> txt[0] = "현구는 돌아다니면서 따로 \n" +
                        "발견한 것은 없다고 하였다.\n" +
                        "이때 김완은 방화문을 누가 잠가 놓은 \n" +
                        "건지 대해서 다시 얘기를 꺼내었다.\n" +
                        "처음엔 승훈이를 의심하였지만 \n" +
                        "그럴 친구도 아니고\n" +
                        "전기와 데이터가 다 끊긴 것이 \n" +
                        "설명되지 않았다. "
                5 -> txt[0] = "나는 옥상이 열려있을 수도 있으니\n" +
                        "모두에게 같이 올라가 보자고 하였다.\n" +
                        "현구를 제외하고 올라가기로 하였다."
                4 -> txt[0] =
                        "김완은 현구를 안 좋게 보는 것 같았다.\n" +
                        "항상 연구한다고 바쁘다고 자리를 피하는\n" +
                        "이유가 있기 때문이다. \n" +
                        "현구를 제외하고 모두 옥상으로 올라갔다."
                3 -> txt[0] = "현구가 휴게실을 나오면서 \n" +
                        "중얼거렸던 말이 생각났다.\n" +
                        "“ 나는 별로 옥상에 가고 싶지 않아 수고해” \n" +
                        "그닥 대수롭지 않게 생각하였다."
                2 -> {txt[0] = "옥상 문 앞에 서서 손잡이를 돌려보았다.\n" +
                        "잠겨있지 않은 것 같았다.\n" +
                        "둘은 빨리 열어보라며 재촉하였다."
                start = false}
                1 -> {txt[0] = "다행히 문은 열렸고 우리는 옥상으로 나왔다.\n" +
                        "평소 옥상과 별반 다를 것이 없었다.\n" +
                        "뭔가 이상한 것은 1층과 2층 높이에\n" +
                        "안개가 자욱하게 깔린 것이었다."
                start = true}
                0 -> txt[0] = "우리 모두 처음 보는 안개였다.\n" +
                        "순간 정적을 깨고\n" +
                        "김완은 로프를 연결하면 1층으로\n" +
                        "내려갈 수 있을 거라고 하였다."
            }
        }
        else if(Page == 12)
        {
            time = "19 : 00"
            when(Pick)
            {
                3 -> {txt[0] = "민재는 옆에서 위험하다고 아니라며 \n" +
                        "그건 너무 위험하다고 하였다.\n" +
                        "방화문을 열고 정문으로 나가자고 하였다."
               nepg = 0}
                2 -> {txt[0] = "민재의 말에 다들 동의하는 눈치였다. \n" +
                        "일단 늦어 내일 휴게실에 만나기로 하고\n" +
                        "각자의 방으로 돌아가기로 하였다."
                txt[1] = "나는 김완의 의견에 동조하였다.\n" +
                        "고민하다가 민재는 우리와 함께하기로\n" +
                        "하고 내일 아침에 바로\n" +
                        "옥상에서 만나기로 하였다."
                btn_TF = 1; nepg = 1}
                1 -> {txt[0] = "먹는다"
                    txt[1] = "생각해보니 좀 아껴둬야 할 것 같다."
                txt[3] = "방으로 돌아오니 허기가 지는 것 같았다."
                btn_TF = 1
                nepg = 1}
                0 -> {
                    if(btn[0] == 2 && btn[1] == 0 && btn[2] == 0)
                    {txt[0] = "뭐라도 먹으니 그나마 괜찮은 것 같다.\n" +
                            "남은 음식이 많이 없다.. "}
                    else if(btn[0] == 1 && btn[1] == 1 && btn[2] == 0)
                    {txt[0] = "오늘 일찍 잠을 자는 것이 좋겠다.\n" +
                            "상황이 더 나빠질 수도 있으니\n" +
                            "절제해야 하지 않을까 싶다."}
                }
            }
        }
        else if(Page == 13)
        {
            time = "21 : 00"
            when(Pick)
            {
                0 -> {txt[0] = "오늘은 빨리 잠을 자기로 하였다. "
                nepg = 0}
            }
        }
        else if(Page == 14)
        {
            time = "11 : 00"
            when(Pick)
            {
                1 -> {txt[0] = "매일 피곤함이 극대화되는 것 같다.\n" +
                        "조금만 누워 있자. "
                    txt[1] = "정신을 차리기 위해 불이 \n" +
                            "들어오지 않는 화장실로 향하였다."
                    txt[3] = "다시 하루가 밝아오고 아침이 찾아왔다."
                btn_TF = 1
                nepg = 1}
                0 -> {
                    if(btn[0] == 1 && btn[1] == 0 && btn[2] == 0)
                    {txt[0] = "조금 더 누워 있더니 조금 나아진 것 같다."}
                    else if(btn[0] == 0 && btn[1] == 1 && btn[2] == 0)
                    {txt[0] = "정신을 차리기 위해 세수한다.\n" +
                            "아직 물을 나오는 걸 보니 다행이다."}
                }
            }
        }
        else if(Page == 15)
        {
            time = "12 : 00"
            when(Pick)
            {
                2 -> {txt[0] = "먹은 것이 얼마 없던 탓인지\n" +
                        "배가 고픈 것 같았다. \n" +
                        "먹을게 얼마 없는 건 알지만\n" +
                        "뭐라도 먹어야 하지 않을까 싶다."
                nepg = 0}
                1 -> {txt[0] = "먹는다"
                txt[1] = "가능하면 아껴둬야 할 것 같다.\n" +
                        "더 버티는 것이 좋겠다."
                txt[3] = "뭐라도 먹어야 하지 않을까 싶다."
                nepg = 1
                btn_TF = 1}
                0 -> {
                    if(btn[0] == 1 && btn[1] == 0 && btn[2] == 0)
                    {txt[0] = "뭐라도 먹으니 그나마 괜찮은 것 같다.\n" +
                            "남은 음식이 많이 없다. "}
                    else if(btn[0] == 0 && btn[1] == 1 && btn[2] == 0)
                    {txt[0] = "상황이 더 나빠질 것이다.\n" +
                            "절제해야 하지 않을까 싶다."}
                }
            }
        }
        else if(Page == 16)
        {
            time = "14 : 00"
            when(Pick)
            {
                4 -> txt[0] = "휴게실에 내가 먼저 도착하였다.\n" +
                        "얼마 지나지 않아 민재와 현구가 왔고\n" +
                        "김완은 늦어서 미안하다며 휴게실로 들어왔다. "
                3 -> txt[0] = "여전히 승훈이는 아무도 못 봤고\n" +
                        "다들 물도 끊기는 것을 걱정하고 있었다."
                2 -> txt[0] = "현구가 창고와 세탁실에 발견한 양동이가 있으니\n" +
                        "가져가서 물을 받아두라고 하였다."
                1 -> txt[0] = "민재가 갑자기 현구에게 \n" +
                        "다른 것은 못 봤냐고 물어보았다.\n" +
                        "모두가 민재에게 집중하였다.\n" +
                        "그때 나는 양동이가 있던 창고에 기숙사 인원들\n" +
                        "주고 남은 간식들을 넣어 두었다고 얘기하였다."
                0 -> txt[0] = "나의 얘기가 끝나자 현구에게 모두가 집중하였다.\n" +
                        "순간 현구가 뭔지 모르게 의심스러웠다.\n" +
                        "김완과 나는 불편한 기색을 참지 않고 드러냈다."
            }
        }
        else if(Page == 17)
        {
            time = "17 : 00"
            when(Pick)
            {
                2 -> txt[0] = "순간 정적이었다. 이내 현구는 기분이 나쁘다며\n" +
                        "화를 내며 직접 확인해보라며 방으로 돌아가 버렸다.\n" +
                        "김완도 기분이 나빴는지 방으로 돌아가 버렸다."
                1 -> txt[0] = "민재는 나에게 \n" +
                        "현구가 평소에 자존심이 강하고 계산적이니까\n" +
                        "이해하라고 하였다.\n" +
                        "잘 말해 줄 것이니 걱정하지 말라고 하였다.\n" +
                        "거짓말쟁이로 몰아갔으니 기분이 나빴을 것이다.\n" +
                        "나도 말하고 보니 미안했다."
                0 -> txt[0] = "혹시 모르니 나는 창고로 가보기로 하였다.\n" +
                        "창고 문을 열어보았다."
            }
        }
        else if(Page == 18)
        {
            time = "18 : 00"
            when(Pick)
            {
                0 -> txt[0] = "구석에 쌓여있는 먼지들을 제외하고는\n" +
                        "정말 아무것도 보이지 않았다. \n" +
                        "순간 잡생각이 들었지만 이내\n" +
                        "방으로 돌아왔다. 잠깐 쉬고 오늘은 \n" +
                        "저녁에 돌아다녀 봐야 할 것 같았다. "
            }
        }
        else if(Page == 19)
        {
            time = "20 : 00"
            when(Pick)
            {
                3 -> txt[0] = "잠시 시간이 흘러 해가 저물었고\n" +
                        "나는 핸드폰 불빛을 이용하여 \n" +
                        "돌아다니기로 하였다. "
                2 -> txt[0] = "방들을 돌아다니는데 인기척이 느껴졌다.\n" +
                        "나는 재빨리 불빛을 끄고 화장실에 몸을 숨겼다."
                1 -> txt[0] = "그때 누군가 세탁실로 들어가는 것 같았다.\n" +
                        "얼핏 들었을 때 현구의 \n" +
                        "목소리도 나는 것 같았다.\n" +
                        "현구의 손에는 무언가 들려있었다. \n" +
                        "갑자기 치지직.. 치직 거리는 소리가 들려왔다."
                0 -> txt[0] = "잘 들리진 않았다.\n" +
                        "현구는 누군가와 대화를 하는 것 같았다.\n" +
                        "“ .... 공 했어요. .. 지켜 주시는 거죠? ... 습니다.. 그럼.. 습니다 ”"
            }
        }
        else if(Page == 20)
        {
            time = "22 : 00"
            when(Pick)
            {
                0 -> txt[0] = "조용히 말하고 있기에 \n" +
                        "전부 들리지는 않았다. \n" +
                        "현구의 무전이 끝나고\n" +
                        "나는 한동안 화장실을 나갈 수가 없었다. "
            }
        }
        else if(Page == 21)
        {
            time = "23 : 00"
            when(Pick)
            {
                1 -> txt[0] = "시간이 조금 지난 것 같다.\n" +
                        "아까 뭔가 떨어지는 소리가 들렸기에\n" +
                        "세탁실로 들어가 보았다.\n" +
                        "핸드폰 불빛을 통해 바닥을 살펴보는데\n" +
                        "뭔가 반짝인다. 열쇠인 것 같다. "
                0 -> txt[0] = "방으로 돌아오자마자 \n" +
                        "긴장이 풀려버렸다.\n" +
                        "침대에 눕듯이 기절 해버렸다. "
            }
        }
        else if(Page == 22)
        {
            time = "14 : 00"
            when(Pick)
            {
                4 -> txt[0] = "누군가 문을 노크하는 소리에 일어났다."
                3 -> txt[0] = "문을 열어주었는데 김완였다. \n" +
                        "나는 속으로 현구가 아니라 \n" +
                        "다행이라고 생각하였다.\n" +
                        "휴게실로 오지 않아 걱정되어 \n" +
                        "와준 것이라고 하였다.\n" +
                        "나는 정신을 차리고 휴게실로 향하였다."
                2 -> {txt[0] = "모두 휴게실에 와있었다. \n" +
                        "늦은 나는 모두에게 사과하였다. \n" +
                        "나를 제외한 친구들은 발견한 것이 따로\n" +
                        "없는 것 같다며 회의가 끝날 때쯤\n" +
                        "나는 고심하다 말하였다."
                nepg = 0}
                1 -> {
                    txt[0] = "현구가 무전기가 있다는 것은 얘기하지 말자..\n" +
                        "세탁실에서 열쇠를 주었다고."
                txt[1] = "어제 화장실에서 숨었던 내용의\n" +
                        "전부를 얘기해주었다."
                nepg = 1
                btn_TF = 1}
                0 -> txt[0] = "열쇠를 줍긴 했는데 방에 있으니 \n" +
                        "가져오겠다고 기다려 달라고 말하였다."
            }
        }
        else if(Page == 23)
        {
            time = "17 : 00"
            when(Pick)
            {
                1 -> txt[0] = "열쇠를 가져와 보니 \n" +
                        "친구들이 방화문 열쇠인 것 같다고 하였다.\n" +
                        "다들 왜 방화문 열쇠가 \n" +
                        "세탁실에서 발견되었는지\n" +
                        "의문이 들긴 하였지만 \n" +
                        "일단 방화문부터 열기로 하였다."
                0 -> txt[0] = "다 같이 1층 방화문으로 향하였다."
            }
        }
        else if(Page == 24)
        {
            time = "18 : 00"
            when(Pick)
            {
                3 -> txt[0] = "발견한 열쇠를 넣은 후 손잡이를 돌렸다."
                2 -> txt[0] = "문이 열리고 정문이 보여 열기 위해\n" +
                        "문을 흔드는데 열리지 않았다.\n" +
                        "전기가 나간 탓인지 고정되어 있었다.\n" +
                        "그리고 누군가 문틈을 사이사이마다 \n" +
                        "테이프로 고정해두었다는 것이었다."
                1 -> txt[0] = "일단은 사감실에서 비상시에 \n" +
                        "정문을 수동으로\n" +
                        "전환 시킬 수 있기에 \n" +
                        "사감실 비번을 아는\n" +
                        "완이가 사감실을 들어가 열기로 하였다."
                0 -> txt[0] = "내가 어떻게 해야 하는지 고민하고 있을 때\n" +
                        "현구가 누군가 의도를 가지고 테이프로\n" +
                        "막아두었을 것 같으니 일단 기계실에서\n" +
                        "전기부터 어떻게 해보자고 하였다.\n" +
                        "일단 알았다고 하였다."
            }
        }
        else if(Page == 25)
        {
            time = "19 : 00"
            when(Pick)
            {
                3 -> txt[0] = "완이가 정문을 수동으로 전환하였으니\n" +
                        "각자 짐을 챙겨 정문으로 나가자고 하였다.\n" +
                        "그러나 현구는 날도 어둡고 해서\n" +
                        "내일 나가고 싶다고 하였다. "
                2 -> txt[0] = "현구를 제외한 우리는\n" +
                        "아무것도 모르는 상태에서 \n" +
                        "기숙사 안에 있는 것 보다\n" +
                        "지금이라도 나가는 좋다고 생각하여\n" +
                        "지금 당장 나가기로 하였다."
                1 -> txt[0] = "현구랑 있기에도 어제 일 때문인지\n" +
                        "빨리 그 자리를 벗어나고 싶기도 하였다."
                0 -> txt[0] = "결국 현구를 제외하고 \n" +
                        "우리는 짐을 챙겨 1시간 뒤에\n" +
                        "1층에서 모이기로 하였다. "
            }
        }
        else if(Page == 26)
        {
            time = "20 : 00"
            when(Pick)
            {
                3 -> txt[0] = "1시간이 지나고 \n" +
                        "내가 내려오니 현구를 제외하고\n" +
                        "다들 정문 앞에 모여있었다."
                2 -> txt[0] = "나와 김완은 문 앞에 고정되어 있던 테이프를\n" +
                        "뜯기 시작하였다.\n" +
                        "테이플 다 뜯자마자 민재가 문을 열었다."
                1 -> txt[0] = "전에 옥상에 봤던 안개와 같은 것이 보였지만\n" +
                        "기숙사를 나갔다는 것에 정신이 팔려\n" +
                        "딱히 신경 쓰지 않았다."
                0 -> txt[0] = "학교를 벗어나는데 주변에 사람이 아무도 없다.\n" +
                        "아까보다 안개가 더 자욱해진 것 같다.\n" +
                        "친구 한 놈이 두통을 호소하는 것 같다."
            }
        }
        else if(Page == 26)
        {
            time = "21 : 00"
            when(Pick)
            {
                0 -> txt[0] = "생각보다 기숙사에서 오래 있고 신경도 많이 써서\n" +
                        "그런 것 같다고 느낄 때쯤\n" +
                        "나도 두통이 느껴지고 몸에 붉은 반점이 보인다.\n" +
                        "점점 숨이 쉬기 어려워지고\n" +
                        "신나서 가던 친구 한 명이 쓰러져있다.\n" +
                        "나 또한 몸에 힘이 빠지더니 쓰러졌다.\n" +
                        "눈이 점점 감겨오다 눈이 감겼다... "
            }
        }
        /*
        else if(Page == )
        {
            time = "
            when(Pick)
            {

            }
        }
         */
        //  0 -> txt[0] = ""
    }
}