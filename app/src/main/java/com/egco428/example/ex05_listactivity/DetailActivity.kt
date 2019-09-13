package com.egco428.example.ex05_listactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val courseTitle = intent.getStringExtra("courseTitle")
        val courseDesc = intent.getStringExtra("courseDesc")
        titleText.text = courseTitle
        descriptionText.text = courseDesc

    }
}
