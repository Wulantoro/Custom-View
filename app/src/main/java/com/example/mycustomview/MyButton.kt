package com.example.mycustomview

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat

class MyButton : AppCompatButton {

    private var enabledBackground: Drawable? = null
    private var disabledbackground : Drawable? = null
    private var txtColor : Int = 0

    constructor(context: Context) : super(context) {
        init()

    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()

    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()

    }

    // Metode onDraw() digunakan untuk mengcustom button ketika enable dan disable
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // Mengubah background dari Button
        background = when {
            isEnabled -> enabledBackground
            else -> disabledbackground
        }

        // Mengubah warna text pada button
        setTextColor(txtColor)
        textSize = 12f
        gravity = Gravity.CENTER
        text = when {
            isEnabled -> "Submit"
            else -> "Isi dulu"
        }
    }

    private fun init() {
        txtColor = ContextCompat.getColor(context, android.R.color.background_light)
        enabledBackground = ContextCompat.getDrawable(context, R.drawable.bg_button)
        disabledbackground = ContextCompat.getDrawable(context, R.drawable.bg_button_dissable)

    }

}