package com.example.scheduler

import android.app.Dialog
import android.content.Context
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText

class CustomDialog(context: Context) { // 파라미터로 액티비티의 Context 전달받음, 다이얼로그가 어떤 액티비티에서 나와야하는지 알려줘야하기때문에
    /*private val dialog = Dialog(context) // 다이얼로그에 context 넘겨줌

    fun myDig() { // 액티비티에서 이 다이얼로그를 호출하기위한 함수
        dialog.show()
        dialog.setContentView(R.layout.dialog)

        // 다이얼로그 크기설정
        dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)

        val edit = dialog.findViewById<EditText>(R.id.timeInput)
        val btnPos = dialog.findViewById<Button>(R.id.positiveButton)
        val btnNeg = dialog.findViewById<Button>(R.id.negativeButton)

        btnPos.setOnClickListener {
            onClickedListener.onClicked(edit)
            dialog.dismiss()
        }

        btnNeg.setOnClickListener {
            dialog.dismiss()
        }
    }

    interface ButtonClickListener {
        fun onClicked(time: EditText)
    }

    private lateinit var onClickedListener: ButtonClickListener

    fun setOnClickedListener(listener: ButtonClickListener) {
        onClickedListener = listener
    }*/
}