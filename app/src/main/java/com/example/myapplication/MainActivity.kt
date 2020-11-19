package com.example.myapplication

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity()
{
    lateinit var btn:Button
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.button)

        fun showToast() {
            val toast = Toast(this@MainActivity)
            toast.setGravity(Gravity.TOP, 0, 50)
            toast.duration = Toast.LENGTH_SHORT
            val inflater = layoutInflater
            val layout: View = inflater.inflate(R.layout.custom_toast,
                    findViewById<ViewGroup>(R.id.custom_toast_root))
            toast.view = layout
            toast.show()
        }

        fun showListDialog()
        {
            val list = arrayOf("message1", "message2",
                    "message3", "message4", "message5")
            val dialog_list = AlertDialog.Builder(this@MainActivity)
            dialog_list.setTitle("使用LIST呈現")
            dialog_list.setItems(list)
            {
                _, i -> Toast.makeText(this@MainActivity,
                        "你選擇是" + list[i], Toast.LENGTH_SHORT).show()
            }
            dialog_list.show()
        }

        btn.setOnClickListener()
        {
            val dialog = AlertDialog.Builder(this@MainActivity)
            dialog.setTitle("請選擇功能")
            dialog.setMessage("請根據下方按鈕選擇要顯示的物件")
            dialog.setNeutralButton("取消")
            {
                _, _ -> Toast.makeText(this@MainActivity,
                    "dialog關閉", Toast.LENGTH_SHORT).show()
            }
            dialog.setNegativeButton("自定義Toast")
            {
                _, _ -> showToast()
            }
            dialog.setPositiveButton("顯示List")
            {
                _, _ -> showListDialog()
            }
            dialog.show()
        }
    }
}