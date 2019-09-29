package com.egco428.example.ex05_listactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true) //for menu bar

        val courseTitle = intent.getStringExtra("courseTitle")
        val courseDesc = intent.getStringExtra("courseDesc")
        val courseNumber = intent.getIntExtra("courseNumber",0)
        val credits = intent.getDoubleExtra("credits",0.0)
        val courseImage = intent.getIntExtra("courseImage",0)

        titleText.text = courseTitle
        descriptionText.text = courseDesc
        txtNumber.text = "Course No#\n$courseNumber"
        txtCredits.text = "Credits $credits"
        imageCourse.setImageResource(courseImage)

    }
    //ปุ่มกลับยังไม่ขึ้นเลยจ้า
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.getItemId()
        if (id == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
