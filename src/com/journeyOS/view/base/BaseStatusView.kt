package com.journeyOS.view.base

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout

abstract class BaseStatusView: FrameLayout, View.OnClickListener {
    var statusChangeListener: StatusChangeListener? = null
    var clickListener: OnClickListener? = null
    private var isChecked = false
    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(attrs)
        setStatus(this.isChecked)
    }

    fun setStatus(isChecked:Boolean){
        this.isChecked = isChecked
        onStatusChanged(this.isChecked)
        statusChangeListener?.onStatusChanged(this, this.isChecked)
    }
    fun getStatus():Boolean{
        return isChecked
    }

    override fun onClick(p0: View?) {
        setStatus(!isChecked)
        clickListener?.onClick(p0)
    }
    abstract fun init(attrs: AttributeSet?)
    abstract fun onStatusChanged(isChecked: Boolean)

    interface StatusChangeListener{
        fun onStatusChanged(view: View, isChecked: Boolean)
    }
}