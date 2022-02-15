package com.example.scheduler

import android.app.Activity
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog.*
import kotlinx.android.synthetic.main.main_include_drawer.*
import java.lang.NumberFormatException



class MainActivity : AppCompatActivity() {

    lateinit var pref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_include_drawer)

        /*var tvData = findViewById<TextView>(R.id.textView6)
        pref = getPreferences(Context.MODE_PRIVATE)
        editor = pref.edit()


        var inputData = pref.getInt("sumTime",progressbar.progress)
        progressbar.progress = inputData


        if(intent.hasExtra("studyTime")) {
            var time = intent.getStringExtra("studyTime")
                if (time != null) {
                    progressbar.incrementProgressBy(time.toInt()*5) // 프로그레스바에 입력한 시간값만큼 추가하고
                    editor.putInt("sumTime", inputData + time.toInt()) // sharedpreference에 sumTime(시간) 키값으로 위에서 선언한 inputData에 time값 추가.
                    editor.apply()
                }
        } else if(intent.hasExtra("exerciseTime")) {
            var time = intent.getStringExtra("exerciseTime")
                if (time != null) {
                    progressbar.incrementProgressBy(time.toInt()*3) // 프로그레스바에 입력한 시간값만큼 추가하고
                    editor.putInt("sumTime", inputData + time.toInt()) // sharedpreference에 sumTime(시간) 키값으로 위에서 선언한 inputData에 time값 추가.
                    editor.apply()
                }
        } else if(intent.hasExtra("hobbyTime")) {
            var time = intent.getStringExtra("hobbyTime")
            if (time != null) {
                progressbar.incrementProgressBy(time.toInt()) // 프로그레스바에 입력한 시간값만큼 추가하고
                editor.putInt("sumTime", inputData + time.toInt()) // sharedpreference에 sumTime(시간) 키값으로 위에서 선언한 inputData에 time값 추가.
                editor.apply()
            }
        }


        if(inputData >= 1000) {
            progressbar.progress = inputData % 1000
            editor.remove("sumTime")
            editor.apply()
            editor.putInt("sumTime", inputData % 1000)
            editor.apply()
        }

        tvData.setText(progressbar.progress.toString() + "/1000")*/




        //버튼을 눌러 메뉴를 오픈할 수도 있고, 왼쪽에서 오른쪽으로 스왑해 오픈할 수 있습니다.
        //DrawerLayout의 id에 직접 openDrawer()메소드를 사용할 수 있습니다.
        /*open_menu_btn.setOnClickListener {
            main_drawer_layout.openDrawer((GravityCompat.START))
        }

        navigation_header_logout_btn.setOnClickListener {
            logOut()
        }

        navigation_header_login_btn.setOnClickListener {
            logIn()
        }*/

        main_navigation_btn1.setOnClickListener {
            Log.d("sibal","왜안돼")
            val intent = Intent(this, StudyActivity::class.java)
            startActivity(intent)
        }

        main_navigation_btn2.setOnClickListener {
            //버튼2 클릭 시
            val intent2 = Intent(this, ExerciseActivity::class.java)
            startActivity(intent2)
        }

        main_navigation_btn3.setOnClickListener {
            //버튼3 클릭 시
            val intent3 = Intent(this, HobbyActivity::class.java)
            startActivity(intent3)
        }

        main_navigation_calender.setOnClickListener {
            //버튼3 클릭 시
            val intent4 = Intent(this, CalenderActivity::class.java)
            startActivity(intent4)
        }

        main_navigation_progress.setOnClickListener {
            val intent5 = Intent(this, ProgressActivity::class.java)
            startActivity(intent5)
        }
    }



    /*private fun logOut(){
        main_header_include_logged_in.visibility = View.INVISIBLE
        main_header_include_logged_out.visibility = View.VISIBLE
        main_navigation_btn1.isEnabled = false
        main_navigation_btn1.setTextColor(Color.parseColor("#777777"))
        main_navigation_btn2.isEnabled = false
        main_navigation_btn2.setTextColor(Color.parseColor("#777777"))
        main_navigation_btn3.isEnabled = false
        main_navigation_btn3.setTextColor(Color.parseColor("#777777"))
    }

    private fun logIn(){
        main_header_include_logged_in.visibility = View.VISIBLE
        main_header_include_logged_out.visibility = View.INVISIBLE
        main_navigation_btn1.isEnabled = true
        main_navigation_btn1.setTextColor(Color.parseColor("#ffffff"))
        main_navigation_btn2.isEnabled = true
        main_navigation_btn2.setTextColor(Color.parseColor("#ffffff"))
        main_navigation_btn3.isEnabled = true
        main_navigation_btn3.setTextColor(Color.parseColor("#ffffff"))
    }*/

    /*fun calculTime(a: String){

        var time = intent.getStringExtra(a)
        if (time != null) {
            progressbar.incrementProgressBy(time.toInt()*5) // 프로그레스바에 입력한 시간값만큼 추가하고
            editor.putInt("sumTime", inputData + time.toInt()) // sharedpreference에 sumTime(시간) 키값으로 위에서 선언한 inputData에 time값 추가.
            editor.apply()
        }
    }*/
}











