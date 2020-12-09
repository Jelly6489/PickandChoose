package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Process.myPid
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.main_lobby.*

class MainLobby : Basics () {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_lobby)

        MusicNumbering()
        MusicVolum()

        lobby_btn.setOnClickListener()
        {
            startActivity(Intent(this@MainLobby,Game_Text::class.java))
        }
    }

    override fun onBackPressed() {
        val bulider = AlertDialog.Builder(this, R.style.Theme_AppCompat_Dialog)

        bulider.setTitle("알림")
        bulider.setMessage("종료하시겠습니까?")
        bulider.setPositiveButton("예"){dialog,which ->
            MusicOut()
            moveTaskToBack(true)
            android.os.Process.killProcess(android.os.Process.myPid())
        }
        bulider.setNegativeButton("아니요",null)
        val dialog = bulider.create()
        dialog.show()
    }
}