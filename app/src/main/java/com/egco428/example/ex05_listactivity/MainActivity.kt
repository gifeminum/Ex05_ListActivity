package com.egco428.example.ex05_listactivity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.course_item.view.*
import java.text.FieldPosition
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = DataProvider.getData()
//        val iterator = data.iterator()
//        val builder = StringBuilder()
//        while (iterator.hasNext()){
//            val course = iterator.next()
//            builder.append(course.title).append("\n")
//        }
//        courseListView.text = builder.toString()

//        val courseArrayAdapter = ArrayAdapter<Course>(this, android.R.layout.simple_list_item_1, data)
//        list.setAdapter(courseArrayAdapter)

        val adapter =  CourseArrayAdapter(this,5,data)
        list.adapter = adapter
        list.setOnItemClickListener { adapterView, view, position, id ->
            val course = data.get(position)
//            Log.d("Course Catalog","Course: ${course.title}")
            displayDetail(course)
        }
    }
    private fun displayDetail(course: Course){
//        Log.d("Course Catalog","Course: ${course.title}")
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("courseTitle",course.title)
        intent.putExtra("courseDesc",course.description)
        startActivity(intent)

    }
    private class CourseArrayAdapter(var context: Context, var resource: Int, var objects: ArrayList<Course>):BaseAdapter(){
        override fun getItem(position: Int): Any {
            return objects[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return objects.size
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val rowMain: View
            val whiteColor = Color.parseColor("#FFFFFF")
            val greyColor = Color.parseColor("#E0E0E0")

            if(convertView==null){

                val layoutInflator = LayoutInflater.from(parent!!.context)
                rowMain = layoutInflator.inflate(R.layout.course_item, parent, false)
                val viewHolder = ViewHolder(rowMain.imageCourse , rowMain.titleText)
                rowMain.tag = viewHolder
            }else{
                rowMain = convertView

            }
            val viewHolder = rowMain.tag as ViewHolder
//            viewHolder.imageCourse.im
            viewHolder.titleText.text = objects[position].title

            if ((position%2)==1){
                rowMain.setBackgroundColor(greyColor)
            } else {

                rowMain.setBackgroundColor(whiteColor)
            }
//            rowMain.setOnClickListener {
//                rowMain.animate().setDuration(2000).alpha(0f).withEndAction({
//                    objects.removeAt(position)
//                    notifyDataSetChanged()
//                    rowMain.setAlpha(1.0F)
//                })
//            }

            return rowMain
        }
        private class ViewHolder(val imageCourse: ImageView, val titleText: TextView)

    }
}
