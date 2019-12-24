package com.example.rango.textview

import android.content.Context
import android.content.res.Resources
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import com.example.rango.R

class RangoTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): TextView(context, attrs, defStyleAttr) {

    @ColorInt private var textColorInt: Int = 0
    @ColorInt private var bgColorInt: Int = 0

    init {
        setAttrs(context, attrs)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        setTextColor(textColorInt)
        setBackgroundColor(bgColorInt)
    }

    fun setStrikeThrough(isStrikeThrough: Boolean) {
        if(isStrikeThrough) {
            this.paintFlags = this.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }else {
            this.paintFlags = this.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    private fun setAttrs(context: Context, attrs: AttributeSet?) {
        val a = context.theme.obtainStyledAttributes(attrs, R.styleable.rango_text_view_style, 0, 0)
        try {
            textColorInt = a.getColor(
                R.styleable.rango_text_view_style_text_color,
                ContextCompat.getColor(context, android.R.color.white)
            )
            bgColorInt = a.getColor(
                R.styleable.rango_text_view_style_bg_color,
                ContextCompat.getColor(context, R.color.white_ff)
            )
            textSize = a.getDimensionPixelSize(
                R.styleable.rango_text_view_style_text_size,
                dpToPx(14)
            ).toFloat()
        } finally {
            a.recycle()
        }
    }

    private fun dpToPx(dp: Int): Int {
        return (dp * Resources.getSystem().displayMetrics.density).toInt()
    }
}