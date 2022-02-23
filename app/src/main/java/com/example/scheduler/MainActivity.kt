package com.example.scheduler

import adapter.PagerAdapter
import android.content.Context
import android.icu.text.AlphabeticIndex
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import fragment.*
import kotlinx.android.synthetic.main.record.*


class MainActivity : AppCompatActivity() {

    private lateinit var context: Context

    private val fl: FrameLayout by lazy {
        findViewById(R.id.timeLayout)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //supportFragmentManager.beginTransaction().replace(R.id.listView, ListFragment()).commit()
/*        val items = mutableListOf<ListViewItem>()

        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.doge)!!, "도지코인", "도지"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.doge)!!, "도지코인", "도지"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.doge)!!, "도지코인", "도지"))

        val adapter = ListViewAdapter(items)
        listView.adapter = adapter*/


        val bnv_main = findViewById<BottomNavigationView>(R.id.bottom_menu)

        bnv_main.setOnItemSelectedListener { item -> // 요렇게 리스너 안에 람다식을 사용해서? 한건가?
            changeFragment(
                when(item.itemId) {
                    R.id.main_navigation_main -> MainFragment()
                    //R.id.main_navigation_study -> StudyFragment()
                    //R.id.main_navigation_exercise -> ExerciseFragment() 요 3개 통합합시다.
                    //R.id.main_navigation_hobby -> HobbyFragment()
                    R.id.main_navigation_record -> {
                        RecordFragment()
                    }
                    R.id.main_navigation_calender -> CalenderFragment()
                    R.id.main_navigation_progress -> ProgressFragment()
                    else -> MainFragment()
                }
            )
            true

        }



      /*  main_navigation_btn1.setOnClickListener {
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
        }*/
    }

    override fun onPause() {
        super.onPause()
    }

    private fun changeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.timeLayout, fragment).commit()
    }
}
