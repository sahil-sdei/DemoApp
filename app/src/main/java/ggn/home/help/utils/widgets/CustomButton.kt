package ggn.home.help.utils.widgets

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.Button
import ggn.home.help.R

class CustomButton : Button {

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)

    }

    constructor(context: Context) : super(context) {
        init(null)
    }

    private fun init(attrs: AttributeSet?) {
        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView)
            val fontName = a.getString(R.styleable.CustomTextView_fontG)

            try {
                if (fontName != null) {
                    val myTypeface = Typeface.createFromAsset(context.assets, "fonts/" + fontName)
                    typeface = myTypeface
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

            a.recycle()
        }
    }
}