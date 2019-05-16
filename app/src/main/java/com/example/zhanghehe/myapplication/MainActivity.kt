package com.example.zhanghehe.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.TextView
import com.example.zhanghehe.myapplication.animation.Rotate2DAnimation

class MainActivity : AppCompatActivity() {

    private val tvHello:TextView by lazy{
        findViewById(R.id.tvHello) as TextView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvHello.setOnClickListener {
            val rotate2D=Rotate2DAnimation(0f,360f,40f,40f,100f,false)
            rotate2D.duration=10000
            tvHello.startAnimation(rotate2D)
        }
    }
}
