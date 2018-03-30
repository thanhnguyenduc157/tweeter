package com.thanh.tweeter.customView

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import android.widget.EditText

class RequiredEditText : android.support.v7.widget.AppCompatEditText {

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context) : super(context)

    override fun onKeyPreIme(keyCode: Int, event: KeyEvent): Boolean {
        if (event.keyCode == KeyEvent.KEYCODE_BACK) {
            dispatchKeyEvent(event)
            (context as Activity).finish()
            return false
        }
        return super.onKeyPreIme(keyCode, event)
    }

}
