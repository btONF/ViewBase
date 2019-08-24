package com.journeyOS.view.normal

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.TextView
import com.journeyOS.view.R
import com.journeyOS.view.base.BaseStatusView

class StatusTextView: BaseStatusView {
    val textView by lazy {
        TextView(context)
    }
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun init(attrs: AttributeSet?) {
        val params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        addView(textView, params)

    }

    override fun onStatusChanged(isChecked: Boolean) {
        if (isChecked){
            textView.setTextAppearance(context, R.style.text_view_solid)
        } else {
            textView.setTextAppearance(context, R.style.text_view_hollow)
        }
    }

}