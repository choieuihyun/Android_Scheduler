package com.example.scheduler

import android.app.Dialog
import android.content.ContentValues.TAG
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.exercise.*
import kotlinx.android.synthetic.main.study.*
import kotlinx.android.synthetic.main.study.study_button

class ExerciseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exercise)

        val exerciseGif = findViewById<ImageView>(R.id.exercise_gif)

        Glide.with(this).load(R.raw.exercise).into(exerciseGif)

        /*study_button.setOnClickListener {
            val dialog = CustomDialog(this)
            dialog.myDig()

            dialog.setOnClickedListener(object: CustomDialog.ButtonClickListener) {
                override fun onClicked(time: Int) {

                }
            })*/


    }

    override fun onResume() {
        super.onResume()

        exercise_button.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle("운동 얼마나했어")
            builder.setIcon(R.mipmap.ic_launcher)

            var v1 = layoutInflater.inflate(R.layout.dialog, null)
            builder.setView(v1)

            // p0에 해당 AlertDialog가 들어온다. findViewById를 통해 view를 가져와서 사용
            var listener = DialogInterface.OnClickListener { p0, p1 ->
                var alert = p0 as AlertDialog
                var edit1: EditText? = alert.findViewById(R.id.timeInput)
                //var edit2: EditText? = alert.findViewById(R.id.dateInput)
                var data = edit1?.text.toString()
                val intent = Intent(this, ProgressActivity::class.java)
                intent.putExtra("exerciseTime", data)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
                finish()
                /*tv1.text = "${edit1?.text}"
                tv1.append("${edit2?.text}")*/

            }
            builder.setPositiveButton("확인", listener)
            builder.setNegativeButton("취소", null)

            builder.show()

            //https://sbe03005dev.tistory.com/entry/Android-Kotlin-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%BD%94%ED%8B%80%EB%A6%B0-%EB%8B%A4%EC%9D%B4%EC%96%BC%EB%A1%9C%EA%B7%B8-Dialog
        }

    }
}

