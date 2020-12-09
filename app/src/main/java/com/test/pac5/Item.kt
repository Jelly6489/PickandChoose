package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.item.*

class Item : Basics() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item)

        val LL1 = findViewById<LinearLayout>(R.id.LL1)
        val LL2 = findViewById<LinearLayout>(R.id.LL2)
        val LL3 = findViewById<LinearLayout>(R.id.LL3)
        val LL4 = findViewById<LinearLayout>(R.id.LL4)
        val LL5 = findViewById<LinearLayout>(R.id.LL5)
        val LL6 = findViewById<LinearLayout>(R.id.LL6)

        val T1_1 = findViewById<TextView>(R.id.Txt1_1)
        val T1_2 = findViewById<TextView>(R.id.Txt1_2)
        val T1_3 = findViewById<TextView>(R.id.Txt1_3)
        val T2_1 = findViewById<TextView>(R.id.Txt2_1)
        val T2_2 = findViewById<TextView>(R.id.Txt2_2)
        val T2_3 = findViewById<TextView>(R.id.Txt2_3)
        val T3_1 = findViewById<TextView>(R.id.Txt3_1)
        val T3_2 = findViewById<TextView>(R.id.Txt3_2)
        val T3_3 = findViewById<TextView>(R.id.Txt3_3)
        val T4_1 = findViewById<TextView>(R.id.Txt4_1)
        val T4_2 = findViewById<TextView>(R.id.Txt4_2)
        val T4_3 = findViewById<TextView>(R.id.Txt4_3)
        val T5_1 = findViewById<TextView>(R.id.Txt5_1)
        val T5_2 = findViewById<TextView>(R.id.Txt5_2)
        val T5_3 = findViewById<TextView>(R.id.Txt5_3)
        val T6_1 = findViewById<TextView>(R.id.Txt6_1)
        val T6_2 = findViewById<TextView>(R.id.Txt6_2)
        val T6_3 = findViewById<TextView>(R.id.Txt6_3)
        val array1 = arrayOf(LL1, LL2, LL3, LL4, LL5, LL6)
        val array2 = arrayOf(T1_1, T2_1, T3_1, T4_1, T5_1, T6_1)
        val array3 = arrayOf(T1_2, T2_2, T3_2, T4_2, T5_2, T6_2)
        val array4 = arrayOf(T1_3, T2_3, T3_3, T4_3, T5_3, T6_3)

        if(item_numbering == 0){}
        else
        {
            for (i in 0..item_numbering-1)
            {
                if(item_set[i] == 1)
                {
                    array2[i].text = "물 500ml"
                    array4[i].text = "체력 +5"
                    if(item_num[i] % 2 ==0 )
                    {
                        array3[i].text = (item_num[i]/2).toString()
                        for(j in 1..(item_num[i]/2)) {
                            //  이미지
                            val iv_j = ImageView(this)
                            iv_j.layoutParams = ViewGroup.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT
                            )
                            iv_j.setImageResource(R.drawable.box_fullwater)
                            array1[i].addView(iv_j, 150, 150)
                        }
                    }
                    else
                    {
                        array3[i].text = ((item_num[i]/2)+0.5).toString()
                        if((item_num[i]/2)>0) {
                            for (j in 1..(item_num[i] / 2)) {
                                //  이미지
                                val iv_j = ImageView(this)
                                iv_j.layoutParams = ViewGroup.LayoutParams(
                                    ViewGroup.LayoutParams.WRAP_CONTENT,
                                    ViewGroup.LayoutParams.WRAP_CONTENT
                                )
                                iv_j.setImageResource(R.drawable.box_fullwater)
                                array1[i].addView(iv_j, 150, 150)
                            }
                        }
                        val iv_j = ImageView(this)
                        iv_j.layoutParams = ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                        )
                        iv_j.setImageResource(R.drawable.box_water)
                        array1[i].addView(iv_j, 150, 150)
                    }
                }
                else if(item_set[i] == 2)
                {
                    array2[i].text = "에너지바"
                    array3[i].text = item_num[i].toString()
                    array4[i].text = "체력 +10"

                    for(j in 1..item_num[i]) {
                        //  이미지
                        val iv_j = ImageView(this)
                        iv_j.layoutParams = ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                        )
                        iv_j.setImageResource(R.drawable.box_energybar)
                        array1[i].addView(iv_j, 150, 150)
                    }
                }
                else if(item_set[i] == 3)
                {
                    array2[i].text = "양동이"
                    array3[i].text = item_num[i].toString()
                    array4[i].text = "액체를 담을 수 있다."
                    for(j in 1..item_num[i]) {
                        //  이미지
                        val iv_j = ImageView(this)
                        iv_j.layoutParams = ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                        )
                        iv_j.setImageResource(R.drawable.box_bucket)
                        array1[i].addView(iv_j, 150, 150)
                    }
                }
                else if(item_set[i] == 4)
                {
                    array2[i].text = "밧줄"
                    array3[i].text = item_num[i].toString()
                    array4[i].text = "쓸 곳이 있을 것이다."
                    for(j in 1..item_num[i]) {
                        //  이미지
                        val iv_j = ImageView(this)
                        iv_j.layoutParams = ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                        )
                        iv_j.setImageResource(R.drawable.box_rope)
                        array1[i].addView(iv_j, 150, 150)
                    }
                }
                else if(item_set[i] == 5)
                {
                    array2[i].text = "열쇠"
                    array3[i].text = item_num[i].toString()
                    array4[i].text = "방화문 열쇠이다."
                    for(j in 1..item_num[i]) {
                        //  이미지
                        val iv_j = ImageView(this)
                        iv_j.layoutParams = ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                        )
                        iv_j.setImageResource(R.drawable.box_key)
                        array1[i].addView(iv_j, 150, 150)
                    }
                }
                else if(item_set[i] == 6)
                {
                    array2[i].text = "이온음료"
                    array3[i].text = item_num[i].toString()
                    array4[i].text = "체력 +5"
                    for(j in 1..item_num[i]) {
                        //  이미지
                        val iv_j = ImageView(this)
                        iv_j.layoutParams = ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                        )
                        iv_j.setImageResource(R.drawable.box_isotonic)
                        array1[i].addView(iv_j, 150, 150)
                    }
                }
            }
        }
    }
    override fun onBackPressed() {
        startActivity(Intent(this@Item, InPhon ::class.java))
    }
}