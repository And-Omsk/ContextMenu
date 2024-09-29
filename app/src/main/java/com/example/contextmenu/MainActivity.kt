@file:Suppress("DEPRECATION")

package com.example.contextmenu

import android.annotation.SuppressLint
import android.graphics.Color.BLUE
import android.graphics.Color.GREEN
import android.graphics.Color.RED
import android.graphics.Color.WHITE
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

@Suppress("MoveVariableDeclarationIntoWhen")
class MainActivity : AppCompatActivity() {
    private lateinit var editText:EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        editText=findViewById(R.id.edittext)
        registerForContextMenu(editText)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menucontext,menu)
    }

    @SuppressLint("ResourceAsColor")
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.menu_change_color ->{
                val estimation=editText.text.toString()
                when (estimation){
                    "1" -> {
                        editText.setBackgroundColor(resources.getColor(R.color.orange1))
                        Toast.makeText(this,"меняем цвет на ОРАНЖЕВЫЙ",Toast.LENGTH_LONG).show()
                    }
                    "2" -> {
                        editText.setBackgroundColor(resources.getColor(R.color.yellow2))
                        Toast.makeText(this,"меняем цвет на ЖЕЛТЫЙ",Toast.LENGTH_LONG).show()
                    }
                    "3" -> {
                        editText.setBackgroundColor(GREEN)
                        Toast.makeText(this,"меняем цвет на ЗЕЛЕНЫЙ",Toast.LENGTH_LONG).show()
                    }
                    "4" -> {
                        editText.setBackgroundColor(BLUE)
                        Toast.makeText(this,"меняем цвет на СИНИЙ",Toast.LENGTH_LONG).show()
                    }
                    "5" -> {
                        editText.setBackgroundColor(RED)
                        Toast.makeText(this,"меняем цвет на КРАСНЫЙ",Toast.LENGTH_LONG).show()
                    }
                    else -> {
                        editText.setBackgroundColor(WHITE)
                        Toast.makeText(this,"Не правильная оценка $estimation",Toast.LENGTH_LONG).show()}
                }


            }
            R.id.menu_exit_program ->{
                finish()
                Toast.makeText(this,"выход из программы",Toast.LENGTH_LONG).show()

            }
        else -> return super.onContextItemSelected(item)
        }

        return true
    }
}