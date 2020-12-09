package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.game_food.*
import kotlinx.android.synthetic.main.game_text.*

class ItemFood : Basics() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_food)

        MyImage()
        Setting()
        PhoneClick()

        var food = arrayOf("","","","","")
        var food_num = 0
        var food_btn_click = arrayOf(false, false, false, false, false)
        var item_numbered = arrayOf(0, 0, 0, 0, 0)
        for(i in 0..item_numbering)
        {
            if(item_set[i] == 1)
            {
                item_numbered[food_num] = 1
                food[food_num++] = "물"
            }
            else if(item_set[i] == 2)
            {
                item_numbered[food_num] = 2
                food[food_num++] = "에너지 바"
            }
            else if(item_set[i] == 6)
            {
                item_numbered[food_num] = 6
                food[food_num++] = "이온음료"
            }
        }
        if(food_num == 0){}
        else
        {
            for (i in 0..food_num-1)
            {
                food_btn_click[i] = true
            }
        }

        game_food_btn1.text = food[0]
        game_food_btn2.text = food[1]
        game_food_btn3.text = food[2]
        game_food_btn4.text = food[3]
        game_food_btn5.text = food[4]



        if(food_btn_click[0])
        {
            game_food_btn1.setOnClickListener()
            {
                MulItme(item_numbered[0], 1)
                FoodState(item_numbered[0])
                NextPage()
            }
        }
        if(food_btn_click[1])
        {
            game_food_btn2.setOnClickListener()
            {
                MulItme(item_numbered[1], 1)
                FoodState(item_numbered[1])
                NextPage()
            }
        }
        if(food_btn_click[2])
        {
            game_food_btn3.setOnClickListener()
            {
                MulItme(item_numbered[2], 1)
                FoodState(item_numbered[2])
                NextPage()
            }
        }
        if(food_btn_click[3])
        {
            game_food_btn4.setOnClickListener()
            {
                MulItme(item_numbered[3], 1)
                FoodState(item_numbered[3])
                NextPage()
            }
        }
        if(food_btn_click[4])
        {
            game_food_btn5.setOnClickListener()
            {
                MulItme(item_numbered[4], 1)
                FoodState(item_numbered[4])
                NextPage()
            }
        }
    }

    private fun NextPage()
    {
        when(gamepage)
        {
            0 -> startActivity(Intent(this@ItemFood, GameButton::class.java))
            1 -> startActivity(Intent(this@ItemFood, Game_Text::class.java))
            2 -> startActivity(Intent(this@ItemFood, ItemFood ::class.java))
            3 -> startActivity(Intent(this@ItemFood, Item ::class.java))
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
                inphonTF = true
                Pick++
                start = false
                startActivity(Intent(this@ItemFood, InPhon::class.java))
            }
        }
    }

    private fun Setting()
    {

        game_button_setting.setOnClickListener()
        {
            Pick++
            start = false
            startActivity(Intent(this@ItemFood, Setting::class.java))
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

    private fun FoodState(code : Int)
    {
        if(code == 1)
        {
            state[0] += 5
            Toast.makeText(this,"체력 +5",Toast.LENGTH_LONG).show()
        }
        else if(code == 2)
        {
            state[0] += 10
            Toast.makeText(this,"체력 +10",Toast.LENGTH_LONG).show()
        }
        else if(code == 6)
        {
            state[0] += 5
            Toast.makeText(this,"체력 +5",Toast.LENGTH_LONG).show()
        }
    }
}