package com.example.rango.textview

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.TextView

class RangoTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): TextView(context, attrs, defStyleAttr) {

    fun setStrikeThrough(isStrikeThrough: Boolean) {
        if(isStrikeThrough) {
            this.paintFlags = this.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }else {
            this.paintFlags = this.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
}