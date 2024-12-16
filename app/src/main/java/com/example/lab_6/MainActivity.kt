package com.example.lab_6

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doAfterTextChanged
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Finding by ID
        val etValueA = findViewById<EditText>(R.id.edit1)
        val etValueB = findViewById<EditText>(R.id.edit2)
        val etValueC = findViewById<EditText>(R.id.edit3)

        // Define values
        var a: Double = 0.0
        var b: Double = 0.0
        var c: Double = 0.0

        // After entering value A
        etValueA.doAfterTextChanged {
            a = etValueA.text.toString().toDoubleOrNull() ?: 0.0
            equation(a, b, c)
        }

        // After entering value B
        etValueB.doAfterTextChanged {
            b = etValueB.text.toString().toDoubleOrNull() ?: 0.0
            equation(a, b, c)
        }
        // After entering value С
        etValueC.doAfterTextChanged {
            c = etValueC.text.toString().toDoubleOrNull() ?: 0.0
            equation(a, b, c)
        }
    }
    private fun equation(a: Double, b: Double, c:Double) {
        val etFoundRoots = findViewById<TextView>(R.id.title2)
        val etRoot1 = findViewById<TextView>(R.id.root1)
        val etRoot2 = findViewById<TextView>(R.id.root2)
        val root1: Double
        val root2: Double
        val d: Double = (b / 2).pow(2.0) - a * c
        if (a==0.0) {
            etFoundRoots.text = "Уравнение не квадратное"
            etRoot1.text = null
            etRoot2.text = null
        }
        else if (d > 0) {
            root1 = (-(b / 2) - sqrt(d)) / a
            root2 = (-(b / 2) + sqrt(d)) / a
            etFoundRoots.text = "Найдено два корня"
            etRoot1.setText(root1.toString())
            etRoot2.setText(root2.toString())
        }
        else if (d < 0){
            etFoundRoots.text = "Корней нет"
            etRoot1.text = null
            etRoot2.text = null
        }
        else {
            root1 = -b / 2
            etFoundRoots.text = "Найден один корень"
            etRoot1.setText(root1.toString())
            etRoot2.text = null
        }
    }
}