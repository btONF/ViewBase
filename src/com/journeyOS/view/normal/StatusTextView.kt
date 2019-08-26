package com.journeyOS.view.normal

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.widget.TextView
import com.journeyOS.view.R
import com.journeyOS.view.base.BaseStatusView

class StatusTextView: BaseStatusView {
    lateinit var textView:TextView
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun init(attrs: AttributeSet?) {
        super.init(attrs)
        val params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        textView = TextView(context)
        textView.gravity = Gravity.CENTER
        addView(textView, params)
    }

    override fun onStatusChanged(isChecked: Boolean) {
        if (isChecked){
            textView.setTextColor(context.resources.getColor(R.color.text_color_light))
            textView.background = context.getDrawable(R.drawable.round_rectangle_solid)
        } else {
            textView.setTextColor(context.resources.getColor(R.color.text_color_dark))
            textView.background = context.getDrawable(R.drawable.round_rectangle_hollow)        }
    }


}