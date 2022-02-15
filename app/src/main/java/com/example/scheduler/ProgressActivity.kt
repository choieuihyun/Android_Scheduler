package com.example.scheduler

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.progress.*

class CustomView: View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    var numProgress: Float = 0.0f

    // onDraw() 메서드 오버라이드 : VIew가 화면에 출력될 때 호출되는 콜백 메서드
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // paint객체로 속성 설정
        val paint = Paint()
        paint.color = Color.GRAY // 색상 설정
        paint.style = Paint.Style.STROKE // 도형 내부 꽉채움
        paint.strokeWidth = 60f

        // canvas 객체로 도형(원) 그리기
        // 매개변수 : 중심의 x좌표, 주심의 Y좌표, 반지름, paint객체
        canvas?.drawArc(250f,250f , 700f, 700f, 0f,  360f, false, paint)
        Log.d("why", numProgress.toString())
        paint.color = Color.BLUE
        canvas?.drawArc(250f, 250f, 700f, 700f, -90f, numProgress, false, paint)
    }

    // 함수 : 프로그레스바의 각도값을 변경하는 함수
    fun setProgress(num: Float) {

        // numProgress값을 변경
        numProgress += num

        // 뷰 갱신: 변경된 numProgress 값을 적용하여 뷰를 다시 그린다.
        invalidate()

    }
}

class ProgressActivity : AppCompatActivity() {

    lateinit var pref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    val customProgress: CustomView by lazy { findViewById(R.id.customCircleBarView) } // 아 왜 이렇게 해야만 되는거지?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.progress)

        var tvData = findViewById<TextView>(R.id.textView6)
        pref = getPreferences(Context.MODE_PRIVATE)
        editor = pref.edit()
        //val customProgress = CustomView(this)
        /*val customView = CustomView(this)
        val parentView: ConstraintLayout = findViewById(R.id.progress_activity)
        parentView.addView(customView)*/


        /*var inputData = pref.getInt("sumTime", progressBar.progress)
        progressBar.progress = inputData*/

        var inputData = pref.getFloat("sumTime", customProgress.numProgress)
        customProgress.numProgress = inputData

        var name:String? = null

        when(name) {
            "studyTime" -> { intent.hasExtra(name)
                             var time = intent.getStringExtra(name)
                             customProgress.setProgress(time?.toFloat()!! * 3)
                             editor.putFloat("sumTime", inputData + time.toFloat() * 3)
                             editor.apply()
           }
        }


        /*if (intent.hasExtra("studyTime")) {
            var time = intent.getStringExtra("studyTime")
            if (time != null) {
                customProgress.setProgress((time.toFloat() * 3)) // 프로그레스바에 입력한 시간값만큼 추가하고
                editor.putFloat(
                    "sumTime",
                    inputData + time.toFloat() * 3
                ) // sharedpreference에 sumTime(시간) 키값으로 위에서 선언한 inputData에 time값 추가.
                editor.apply()
                Log.d("sibal", customProgress.numProgress.toString())
            }
        } else if (intent.hasExtra("exerciseTime")) {
            var time = intent.getStringExtra("exerciseTime")
            if (time != null) {
                customProgress.setProgress((time.toFloat() * 2)) // 프로그레스바에 입력한 시간값만큼 추가하고
                editor.putFloat(
                    "sumTime",
                    inputData + time.toFloat() * 2
                ) // sharedpreference에 sumTime(시간) 키값으로 위에서 선언한 inputData에 time값 추가.
                editor.apply()
            }
        } else if (intent.hasExtra("hobbyTime")) {
            var time = intent.getStringExtra("hobbyTime")
            if (time != null) {
                customProgress.setProgress((time.toFloat())) // 프로그레스바에 입력한 시간값만큼 추가하고
                editor.putFloat(
                    "sumTime",
                    inputData + time.toFloat()
                ) // sharedpreference에 sumTime(시간) 키값으로 위에서 선언한 inputData에 time값 추가.
                editor.apply()
            }
        }*/

        if (inputData >= 360) {
            customProgress.numProgress = (inputData % 360).toFloat()
            editor.remove("sumTime")
            editor.apply()
            editor.putFloat("sumTime", (inputData % 360).toFloat())
            editor.apply()
        }
        Log.d("why2", customProgress.numProgress.toString())
        tvData.setText(customProgress.numProgress.toString() + "/360")

        /*if (intent.hasExtra("studyTime")) {
            var time = intent.getStringExtra("studyTime")
            if (time != null) {
                progressBar.incrementProgressBy(time.toInt() * 5) // 프로그레스바에 입력한 시간값만큼 추가하고
                editor.putInt(
                    "sumTime",
                    inputData + time.toInt()
                ) // sharedpreference에 sumTime(시간) 키값으로 위에서 선언한 inputData에 time값 추가.
                editor.apply()
            }
        } else if (intent.hasExtra("exerciseTime")) {
            var time = intent.getStringExtra("exerciseTime")
            if (time != null) {
                progressBar.incrementProgressBy(time.toInt() * 3) // 프로그레스바에 입력한 시간값만큼 추가하고
                editor.putInt(
                    "sumTime",
                    inputData + time.toInt()
                ) // sharedpreference에 sumTime(시간) 키값으로 위에서 선언한 inputData에 time값 추가.
                editor.apply()
            }
        } else if (intent.hasExtra("hobbyTime")) {
            var time = intent.getStringExtra("hobbyTime")
            if (time != null) {
                progressBar.incrementProgressBy(time.toInt()) // 프로그레스바에 입력한 시간값만큼 추가하고
                editor.putInt(
                    "sumTime",
                    inputData + time.toInt()
                ) // sharedpreference에 sumTime(시간) 키값으로 위에서 선언한 inputData에 time값 추가.
                editor.apply()
            }
        }*/


        /*if (inputData >= 1000) {
            progressBar.progress = inputData % 1000
            editor.remove("sumTime")
            editor.apply()
            editor.putInt("sumTime", inputData % 1000)
            editor.apply()
        }

        tvData.setText(progressBar.progress.toString() + "/1000")*/

    }


}


