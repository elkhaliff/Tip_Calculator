package org.hyperskill.calculator.tip

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.google.android.material.slider.Slider
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var x: Float? = null
        var p = 0

        val textView: TextView = findViewById(R.id.text_view)

        fun Float.format(digits: Int) = "%.${digits}f".format(this)

        fun setStat() {
            var r: Float = 0F
            if (x != null) {
                r = x!! * p / 100
                textView.setText("Tip amount: ${r.format(2)}")
            }
            else textView.setText("")
        }

        val editText: EditText = findViewById(R.id.edit_text)
        editText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun afterTextChanged(p0: Editable?) {
//                x = p0?.toString()?.toInt() ?: null
                try {
                    x = p0.toString().toFloat()
                } catch (e: Exception) {
                    x = null
                }
                setStat()
            }
        })

        val slider: Slider = findViewById(R.id.slider)

//        slider.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
//            override fun onStartTrackingTouch(slider: Slider) {
//            }
//
//            override fun onStopTrackingTouch(slider: Slider) {
//
//            }
//        })

        slider.addOnChangeListener { slider, value, fromUser ->
            p = value.toInt()
            setStat()
        }
    }
}