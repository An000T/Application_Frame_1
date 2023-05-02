package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


            val button: Button = findViewById(R.id.button_menu)
            button.setOnClickListener {
                Toast.makeText(this, "Меню", Toast.LENGTH_SHORT).show()
                }
            val button_2: Button = findViewById(R.id.button_favorite)
            button_2.setOnClickListener {
                Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
            }
            val button_3: Button = findViewById(R.id.button_watch)
            button_3.setOnClickListener {
                Toast.makeText(this, "Посмотреть позже", Toast.LENGTH_SHORT).show()
            }
            val button_4: Button = findViewById(R.id.button_selections)
            button_4.setOnClickListener {
                Toast.makeText(this, "Подборки", Toast.LENGTH_SHORT).show()
            }
            val button_5: Button = findViewById(R.id.button_settings)
            button_5.setOnClickListener {
                Toast.makeText(this, "Настройки", Toast.LENGTH_SHORT).show()
            }


    }

}